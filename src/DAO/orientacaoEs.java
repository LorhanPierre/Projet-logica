package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ConexaoBD.ConexaoBD;

public class orientacaoEs {


    public void cadastroEs() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {

        boolean entradaValida = true;
        String titulo;
        String tipo;
        String Orientacao;

        String tipoPt = "", tipoFr = "", tipoDe = "", tipoEn = "";
        String tituloPt, tituloFr, tituloDe, tituloEn;
        String orientPt, orientFr, orientDe, orientEn;

        do {
            entradaValida = true;

            System.out.println("¡Atención! Deberás registrar la orientación en español, inglés, francés, alemán y portugués.");
            System.out.println("=====================================================================");
            System.out.println("Ingrese el título de la orientación en español:");
            System.out.println("--------------------------------------------------------------------");
            titulo = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Ingrese el título de la orientación en inglés:");
            System.out.println("--------------------------------------------------------------------");
            tituloEn = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Ingrese el título de la orientación en francés:");
            System.out.println("--------------------------------------------------------------------");
            tituloFr = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Ingrese el título de la orientación en alemán:");
            System.out.println("--------------------------------------------------------------------");
            tituloDe = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Ingrese el título de la orientación en portugués:");
            System.out.println("--------------------------------------------------------------------");
            tituloPt = input.nextLine();
            System.out.println("+==================================================================+");

            if (titulo.isEmpty()) {
                System.out.println("Este campo debe completarse.");
                entradaValida = false;
            }

        } while (!entradaValida);

        do {
            entradaValida = true;

            System.out.println("+==================================================================+");
            System.out.println("|                      Tipos de Orientaciones                      |");
            System.out.println("|------------------------------------------------------------------|");
            System.out.println("| 1 Manual de Operaciones       2 Procedimiento de Seguridad       |");
            System.out.println("| 3 Mantenimiento y Reparación  4 Pruebas y Diagnósticos           |");
            System.out.println("| 5 Código de Conducta          6 Operaciones Sectoriales          |");
            System.out.println("+==================================================================+");
            System.out.print("| Ingrese el tipo de orientación que desea registrar: ");
            tipo = input.nextLine();

            if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manual de Operaciones")) {
                tipo = "Manual de Operaciones";
                tipoEn = "Operation Manual";
                tipoFr = "Manuel d'opération";
                tipoDe = "Betriebsanleitung";
                tipoPt = "Manual de Operação";

            } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procedimiento de Seguridad")) {
                tipo = "Procedimiento de Seguridad";
                tipoEn = "Safety Procedure";
                tipoFr = "Procédure de sécurité";
                tipoDe = "Sicherheitsverfahren";
                tipoPt = "Procedimento de Segurança";

            } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Mantenimiento y Reparación")) {
                tipo = "Mantenimiento y Reparación";
                tipoEn = "Maintenance and Repairs";
                tipoFr = "Maintenance et Réparation";
                tipoDe = "Wartung und Reparatur";
                tipoPt = "Manutenção e Reparos";

            } else if (tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Pruebas y Diagnósticos")) {
                tipo = "Pruebas y Diagnósticos";
                tipoEn = "Testing and Diagnosis";
                tipoFr = "Tests et diagnostics";
                tipoDe = "Tests und Diagnosen";
                tipoPt = "Testes e Diagnóstico";

            } else if (tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Código de Conducta")) {
                tipo = "Código de Conducta";
                tipoEn = "Code of Conduct";
                tipoFr = "Code de conduite";
                tipoDe = "Verhaltenskodex";
                tipoPt = "Manual de Conduta";

            } else if (tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Operaciones Sectoriales")) {
                tipo = "Operaciones Sectoriales";
                tipoEn = "Sector Operations";
                tipoFr = "Opérations sectorielles";
                tipoDe = "Sektoroperationen";
                tipoPt = "Operações Setoriais";

            } else {
                System.out.println("Tipo inválido. Por favor, intente de nuevo.");
                entradaValida = false;
            }

        } while (!entradaValida);

        do {
            System.out.println("+==================================================================+");
            System.out.println("| Ingrese la orientación (Español):");
            System.out.println("|------------------------------------------------------------------|");
            Orientacao = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Ingrese la orientación (Inglés):");
            System.out.println("|------------------------------------------------------------------|");
            orientEn = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Ingrese la orientación (Francés):");
            System.out.println("|------------------------------------------------------------------|");
            orientFr = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Ingrese la orientación (Alemán):");
            System.out.println("|------------------------------------------------------------------|");
            orientDe = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Ingrese la orientación (Portugués):");
            System.out.println("|------------------------------------------------------------------|");
            orientPt = input.nextLine();
            System.out.println("+==================================================================+");

            if (Orientacao.isEmpty()) {
                System.out.println("Este campo debe completarse.");
                entradaValida = false;
            } else {
                entradaValida = true;
            }

        } while (!entradaValida);

        // Inserción en la base de datos
        String sqlEs = "INSERT INTO orientEs (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtEs = conn.prepareStatement(sqlEs);
        stmtEs.setString(1, titulo);
        stmtEs.setString(2, tipo);
        stmtEs.setString(3, Orientacao);
        stmtEs.executeUpdate();

        String sqlEn = "INSERT INTO orientEn (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtEn = conn.prepareStatement(sqlEn);
        stmtEn.setString(1, tituloEn);
        stmtEn.setString(2, tipoEn);
        stmtEn.setString(3, orientEn);
        stmtEn.executeUpdate();

        String sqlFr = "INSERT INTO orientFr (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtFr = conn.prepareStatement(sqlFr);
        stmtFr.setString(1, tituloFr);
        stmtFr.setString(2, tipoFr);
        stmtFr.setString(3, orientFr);
        stmtFr.executeUpdate();

        String sqlDe = "INSERT INTO orientDe (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtDe = conn.prepareStatement(sqlDe);
        stmtDe.setString(1, tituloDe);
        stmtDe.setString(2, tipoDe);
        stmtDe.setString(3, orientDe);
        stmtDe.executeUpdate();

        String sqlPt = "INSERT INTO orientPt (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtPt = conn.prepareStatement(sqlPt);
        stmtPt.setString(1, tituloPt);
        stmtPt.setString(2, tipoPt);
        stmtPt.setString(3, orientPt);
        stmtPt.executeUpdate();

        System.out.println("¡Orientación registrada exitosamente en español!");

    } catch (SQLException e) {
        System.out.println("Error al registrar la orientación: " + e.getMessage());
    }

    input.close();
}

    //==================================================================================================================

    public static void ListarTodaTabelaEs() {
    try (Connection conn = ConexaoBD.getConexao()) {
        String sql = "SELECT * FROM orientEs";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println("==================================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("..................................................................");
            System.out.println("Título: " + rs.getString("titulo"));
            System.out.println("..................................................................");
            System.out.println("Tipo: " + rs.getString("tipo"));
            System.out.println("..................................................................");
            System.out.println("Orientación: " + rs.getString("orient"));
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener orientaciones: " + e.getMessage());
    }
}

public static void ListarTudoPorTipoEs() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("+==================================================================+");
        System.out.println("|                      Tipos de Orientaciones                      |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|         1 Manual de Operaciones      2 Procedimiento de Seguridad|");
        System.out.println("|         3 Mantenimiento y Reparaciones 4 Pruebas y Diagnósticos  |");
        System.out.println("|         5 Código de Conducta          6 Operaciones Sectoriales  |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.print("| Elija el tipo de orientación que desea filtrar: ");
        String tipo = input.nextLine();

        if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manual de Operaciones")) {
            tipo = "Manual de Operaciones";
        } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procedimiento de Seguridad")) {
            tipo = "Procedimiento de Seguridad";
        } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Mantenimiento y Reparaciones")) {
            tipo = "Mantenimiento y Reparaciones";
        } else if (tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Pruebas y Diagnósticos")) {
            tipo = "Pruebas y Diagnósticos";
        } else if (tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Código de Conducta")) {
            tipo = "Código de Conducta";
        } else if (tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Operaciones Sectoriales")) {
            tipo = "Operaciones Sectoriales";
        } else {
            System.out.println("Tipo inválido. Por favor, inténtelo de nuevo.");
            return;
        }

        String sql = "SELECT * FROM orientEs WHERE tipo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tipo);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("===================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("...................................................");
            System.out.println("Título: " + rs.getString("titulo"));
            System.out.println("...................................................");
            System.out.println("Tipo: " + rs.getString("tipo"));
            System.out.println("...................................................");
            System.out.println("Orientación: " + rs.getString("orient"));
            System.out.println("===================================================");
        }

    } catch (SQLException e) {
        System.out.println("Error al obtener orientaciones: " + e.getMessage());
    }

    input.close();
}

public static void BuscaPorIDEs() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Ingrese el ID de la orientación que busca:");
        System.out.println("---------------------------------------------------");
        int id = input.nextInt();
        String sql = "SELECT * FROM orientEs WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("===================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("...................................................");
            System.out.println("Título: " + rs.getString("titulo"));
            System.out.println("...................................................");
            System.out.println("Tipo: " + rs.getString("tipo"));
            System.out.println("...................................................");
            System.out.println("Orientación: " + rs.getString("orient"));
            System.out.println("===================================================");
        } else {
            System.out.println("No se encontró orientación con ID: " + id);
        }
    } catch (SQLException e) {
        System.out.println("Error al buscar orientación: " + e.getMessage());
    }

    input.close();
}

public static void BuscaPorTituloEs() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Ingrese el título de la orientación que busca:");
        System.out.println("---------------------------------------------------");
        String titulo = input.nextLine();
        String sql = "SELECT * FROM orientEs WHERE titulo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            do {
                System.out.println("===================================================");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("...................................................");
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("...................................................");
                System.out.println("Tipo: " + rs.getString("tipo"));
                System.out.println("...................................................");
                System.out.println("Orientación: " + rs.getString("orient"));
                System.out.println("===================================================");
            } while (rs.next());
        } else {
            System.out.println("No se encontró orientación con el título: " + titulo);
        }
    } catch (SQLException e) {
        System.out.println("Error al buscar orientación: " + e.getMessage());
    }

    input.close();
}


}
