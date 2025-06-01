package DAO;

import ConexaoBD.ConexaoBD;
import java.sql.*;
import java.util.*;

public class orientacaoEn {

    //METEDO DE CADASTRO DE ORIENTAÇÕES EM INGLES///=========================================================================================
  
    public void cadastroEn() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {

        boolean entradaValida = true;
        String titulo;
        String tipo;
        String Orientacao;

        String tipoPt = "", tipoFr = "", tipoEs = "", tipoDe = "";
        String tituloPt, tituloFr, tituloEs, tituloDe;
        String orientPt, orientFr, orientEs, orientDe;

        do {
            entradaValida = true;

            System.out.println("!Warning! You will need to register the instruction in English, German,\nFrench, Spanish, and Portuguese.");
            System.out.println("=====================================================================");
            System.out.println("Enter the English title of the instruction:");
            System.out.println("--------------------------------------------------------------------");
            titulo = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Enter the German title of the instruction:");
            System.out.println("--------------------------------------------------------------------");
            tituloDe = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Enter the French title of the instruction:");
            System.out.println("--------------------------------------------------------------------");
            tituloFr = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Enter the Spanish title of the instruction:");
            System.out.println("--------------------------------------------------------------------");
            tituloEs = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Enter the Portuguese title of the instruction:");
            System.out.println("--------------------------------------------------------------------");
            tituloPt = input.nextLine();
            System.out.println("+==================================================================+");

            if (titulo.isEmpty()) {
                System.out.println("This field must be filled out.");
                entradaValida = false;
            }

        } while (entradaValida == false);

        do {
            entradaValida = true;

            System.out.println("+==================================================================+");
            System.out.println("|                       Instruction Types                          |");
            System.out.println("|------------------------------------------------------------------|");
            System.out.println("| 1 Operation Manual        2 Safety Procedure                     |");
            System.out.println("| 3 Maintenance and Repairs 4 Testing and Diagnosis               |");
            System.out.println("| 5 Code of Conduct         6 Sector Operations                   |");
            System.out.println("+==================================================================+");
            System.out.print("| Enter the instruction type you wish to register: ");
            tipo = input.nextLine();

            if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Operation Manual")) {
                tipo = "Operation Manual";
                tipoDe = "Betriebsanleitung";
                tipoFr = "Manuel d'opération";
                tipoEs = "Manual de Operaciones";
                tipoPt = "Manual de Operação";

            } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Safety Procedure")) {
                tipo = "Safety Procedure";
                tipoDe = "Sicherheitsverfahren";
                tipoFr = "Procédure de sécurité";
                tipoEs = "Procedimiento de Seguridad";
                tipoPt = "Procedimento de Segurança";

            } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance and Repairs")) {
                tipo = "Maintenance and Repairs";
                tipoDe = "Wartung und Reparatur";
                tipoFr = "Maintenance et Réparation";
                tipoEs = "Mantenimiento y Reparación";
                tipoPt = "Manutenção e Reparos";

            } else if (tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Testing and Diagnosis")) {
                tipo = "Testing and Diagnosis";
                tipoDe = "Tests und Diagnosen";
                tipoFr = "Tests et diagnostics";
                tipoEs = "Pruebas y Diagnósticos";
                tipoPt = "Testes e Diagnóstico";

            } else if (tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Code of Conduct")) {
                tipo = "Code of Conduct";
                tipoDe = "Verhaltenskodex";
                tipoFr = "Code de conduite";
                tipoEs = "Código de Conducta";
                tipoPt = "Manual de Conduta";

            } else if (tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Sector Operations")) {
                tipo = "Sector Operations";
                tipoDe = "Sektoroperationen";
                tipoFr = "Opérations sectorielles";
                tipoEs = "Operaciones Sectoriales";
                tipoPt = "Operações Setoriais";

            } else {
                System.out.println("Invalid type. Please try again.");
                entradaValida = false;
            }

        } while (entradaValida == false);

        do {
            System.out.println("+==================================================================+");
            System.out.println("| Enter the instruction content (English):");
            System.out.println("|------------------------------------------------------------------|");
            Orientacao = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Enter the instruction content (German):");
            System.out.println("|------------------------------------------------------------------|");
            orientDe = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Enter the instruction content (French):");
            System.out.println("|------------------------------------------------------------------|");
            orientFr = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Enter the instruction content (Spanish):");
            System.out.println("|------------------------------------------------------------------|");
            orientEs = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Enter the instruction content (Portuguese):");
            System.out.println("|------------------------------------------------------------------|");
            orientPt = input.nextLine();
            System.out.println("+==================================================================+");

            if (Orientacao.isEmpty()) {
                System.out.println("This field must be filled out.");
                entradaValida = false;
            } else {
                entradaValida = true;
            }

        } while (entradaValida == false);

        // Database inserts
        String sql = "INSERT INTO orientEn (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        stmt.setString(2, tipo);
        stmt.setString(3, Orientacao);
        stmt.executeUpdate();

        String sqlDe = "INSERT INTO orientDe (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtDe = conn.prepareStatement(sqlDe);
        stmtDe.setString(1, tituloDe);
        stmtDe.setString(2, tipoDe);
        stmtDe.setString(3, orientDe);
        stmtDe.executeUpdate();

        String sqlFr = "INSERT INTO orientFr (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtFr = conn.prepareStatement(sqlFr);
        stmtFr.setString(1, tituloFr);
        stmtFr.setString(2, tipoFr);
        stmtFr.setString(3, orientFr);
        stmtFr.executeUpdate();

        String sqlEs = "INSERT INTO orientEs (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtEs = conn.prepareStatement(sqlEs);
        stmtEs.setString(1, tituloEs);
        stmtEs.setString(2, tipoEs);
        stmtEs.setString(3, orientEs);
        stmtEs.executeUpdate();

        String sqlPt = "INSERT INTO orientPt (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtPt = conn.prepareStatement(sqlPt);
        stmtPt.setString(1, tituloPt);
        stmtPt.setString(2, tipoPt);
        stmtPt.setString(3, orientPt);
        stmtPt.executeUpdate();

        System.out.println("English instruction successfully registered!");

    } catch (SQLException e) {
        System.out.println("Error while registering the instruction: " + e.getMessage());
    }

    input.close();
}

    //=====================================================================================================================================

    public static void ListarTodaTabelaEn() {
    try (Connection conn = ConexaoBD.getConexao()) {
        String sql = "SELECT * FROM orientEn";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println("==================================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("..................................................................");
            System.out.println("Title: " + rs.getString("titulo"));
            System.out.println("..................................................................");
            System.out.println("Type: " + rs.getString("tipo"));
            System.out.println("..................................................................");
            System.out.println("Guidance: " + rs.getString("orient"));
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving guidances: " + e.getMessage());
    }
}

public static void ListarTudoPorTipoEn() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("+==================================================================+");
        System.out.println("|                      Types of Guidance                           |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|         1 Operation Manual        2 Safety Procedure             |");
        System.out.println("|         3 Maintenance and Repairs 4 Testing and Diagnosis        |");
        System.out.println("|         5 Code of Conduct         6 Sector Operations             |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.print("| Choose the type of guidance you want to filter: ");
        String tipo = input.nextLine();

        if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Operation Manual")) {
            tipo = "Operation Manual";
        } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Safety Procedure")) {
            tipo = "Safety Procedure";
        } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance and Repairs")) {
            tipo = "Maintenance and Repairs";
        } else if (tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Testing and Diagnosis")) {
            tipo = "Testing and Diagnosis";
        } else if (tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Code of Conduct")) {
            tipo = "Code of Conduct";
        } else if (tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Sector Operations")) {
            tipo = "Sector Operations";
        } else {
            System.out.println("Invalid type. Please try again.");
            return;
        }

        String sql = "SELECT * FROM orientEn WHERE tipo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tipo);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("===================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("...................................................");
            System.out.println("Title: " + rs.getString("titulo"));
            System.out.println("...................................................");
            System.out.println("Type: " + rs.getString("tipo"));
            System.out.println("...................................................");
            System.out.println("Guidance: " + rs.getString("orient"));
            System.out.println("===================================================");
        }

    } catch (SQLException e) {
        System.out.println("Error retrieving guidances: " + e.getMessage());
    }

    input.close();
}

public static void BuscaPorIDEn() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Enter the ID of the guidance you want to find:");
        System.out.println("---------------------------------------------------");
        int id = input.nextInt();
        String sql = "SELECT * FROM orientEn WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("===================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("...................................................");
            System.out.println("Title: " + rs.getString("titulo"));
            System.out.println("...................................................");
            System.out.println("Type: " + rs.getString("tipo"));
            System.out.println("...................................................");
            System.out.println("Guidance: " + rs.getString("orient"));
            System.out.println("===================================================");
        } else {
            System.out.println("No guidance found with ID: " + id);
        }
    } catch (SQLException e) {
        System.out.println("Error searching guidance: " + e.getMessage());
    }

    input.close();
}

public static void BuscaPorTituloEn() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Enter the title of the guidance you want to find:");
        System.out.println("---------------------------------------------------");
        String titulo = input.nextLine();
        String sql = "SELECT * FROM orientEn WHERE titulo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            do {
                System.out.println("===================================================");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("...................................................");
                System.out.println("Title: " + rs.getString("titulo"));
                System.out.println("...................................................");
                System.out.println("Type: " + rs.getString("tipo"));
                System.out.println("...................................................");
                System.out.println("Guidance: " + rs.getString("orient"));
                System.out.println("===================================================");
            } while (rs.next());
        } else {
            System.out.println("No guidance found with the title: " + titulo);
        }
    } catch (SQLException e) {
        System.out.println("Error searching guidance: " + e.getMessage());
    }

    input.close();
}

}