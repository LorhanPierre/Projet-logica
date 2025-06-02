package DAO;

import ConexaoBD.ConexaoBD;
import java.sql.*;
import java.util.*;

public class orientacaoEs {


    public static void cadastroEs() {
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
    //==================================================================================================================

    public static void ExcluirPorIDEs() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("Está a punto de eliminar una orientación en todos los idiomas.");
        System.out.println("===================================================");
        System.out.println("Ingrese el ID de la orientación que desea eliminar:");
        System.out.println("---------------------------------------------------");
        int id = input.nextInt();
        System.out.println("===================================================");
        System.out.println("¿Está seguro de que desea eliminar la orientación con ID: " + id + "? (s/n)");
        String escolha = input.next();

        if (escolha.equalsIgnoreCase("n") || escolha.equalsIgnoreCase("no")) {
            System.out.println("Eliminación cancelada.");
            return;
        }

        String sqlEs = "DELETE FROM orientEs WHERE id = ?";
        PreparedStatement stmtEs = conn.prepareStatement(sqlEs);
        stmtEs.setInt(1, id);
        int rowsAffectedEs = stmtEs.executeUpdate();

        String sqlPt = "DELETE FROM orientPt WHERE id = ?";
        PreparedStatement stmtPt = conn.prepareStatement(sqlPt);
        stmtPt.setInt(1, id);
        int rowsAffectedPt = stmtPt.executeUpdate();

        String sqlDe = "DELETE FROM orientDe WHERE id = ?";
        PreparedStatement stmtDe = conn.prepareStatement(sqlDe);
        stmtDe.setInt(1, id);
        int rowsAffectedDe = stmtDe.executeUpdate();

        String sqlEn = "DELETE FROM orientEn WHERE id = ?";
        PreparedStatement stmtEn = conn.prepareStatement(sqlEn);
        stmtEn.setInt(1, id);
        int rowsAffectedEn = stmtEn.executeUpdate();

        String sqlFr = "DELETE FROM orientFr WHERE id = ?";
        PreparedStatement stmtFr = conn.prepareStatement(sqlFr);
        stmtFr.setInt(1, id);
        int rowsAffectedFr = stmtFr.executeUpdate();

        if (rowsAffectedEs > 0) {
            System.out.println("¡Orientación eliminada con éxito!");
        } else {
            System.out.println("El ID: " + id + " no fue encontrado para eliminación.");
        }
    } catch (SQLException e) {
        System.out.println("Error al eliminar orientación: " + e.getMessage());
    }

    input.close();
}

public static void ExcluirPorTituloEs() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Ingrese el título de la orientación que desea eliminar:");
        System.out.println("---------------------------------------------------");
        String titulo = input.nextLine();
        System.out.println("===================================================");
        System.out.println("¿Está seguro de que desea eliminar la orientación con título: " + titulo + "? (s/n)");
        String escolha = input.next();

        if (escolha.equalsIgnoreCase("n") || escolha.equalsIgnoreCase("no")) {
            System.out.println("Eliminación cancelada.");
            return;
        }

        String sqlEs = "SELECT id FROM orientEs WHERE titulo = ?";
        PreparedStatement stmtEs = conn.prepareStatement(sqlEs);
        stmtEs.setString(1, titulo);
        ResultSet rs = stmtEs.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");

            String sqlDelEs = "DELETE FROM orientEs WHERE id = ?";
            PreparedStatement stmtDelEs = conn.prepareStatement(sqlDelEs);
            stmtDelEs.setInt(1, id);
            int rowsAffectedEs = stmtDelEs.executeUpdate();

            String sqlDelPt = "DELETE FROM orientPt WHERE id = ?";
            PreparedStatement stmtDelPt = conn.prepareStatement(sqlDelPt);
            stmtDelPt.setInt(1, id);
            int rowsAffectedPt = stmtDelPt.executeUpdate();

            String sqlDelDe = "DELETE FROM orientDe WHERE id = ?";
            PreparedStatement stmtDelDe = conn.prepareStatement(sqlDelDe);
            stmtDelDe.setInt(1, id);
            int rowsAffectedDe = stmtDelDe.executeUpdate();

            String sqlDelEn = "DELETE FROM orientEn WHERE id = ?";
            PreparedStatement stmtDelEn = conn.prepareStatement(sqlDelEn);
            stmtDelEn.setInt(1, id);
            int rowsAffectedEn = stmtDelEn.executeUpdate();

            String sqlDelFr = "DELETE FROM orientFr WHERE id = ?";
            PreparedStatement stmtDelFr = conn.prepareStatement(sqlDelFr);
            stmtDelFr.setInt(1, id);
            int rowsAffectedFr = stmtDelFr.executeUpdate();

            if (rowsAffectedEs > 0) {
                System.out.println("¡Orientación eliminada con éxito!");
            } else {
                System.out.println("No se encontró ninguna orientación con el título: " + titulo);
            }
        } else {
            System.out.println("No se encontró ninguna orientación con el título: " + titulo);
        }

    } catch (SQLException e) {
        System.out.println("Error al eliminar orientación: " + e.getMessage());
    }

    input.close();
}

    //==================================================================================================================

    public static void AtualizarTodaAOrientacaoEs(){
    
    Scanner input = new Scanner (System.in);

    try(Connection conn = ConexaoBD.getConexao()){
        System.out.println("===================================================");
        System.out.println("¿Desea buscar la orientación por ID o Título? (Escriba 'ID' o 'Título')");
        System.out.println("---------------------------------------------------");
        String escolha = input.nextLine();

        if(escolha.equalsIgnoreCase("ID")){
            System.out.println("===================================================");
            System.out.println("Ingrese el ID de la orientación que desea actualizar:");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Limpiar el búfer del escáner
            System.out.println("Ingrese el nuevo título de la orientación:");
            System.out.println("----------------------------------------------------");
            String novoTitulo = input.nextLine();

            System.out.println("===================================================");
            System.out.println("                Tipos de Orientaciones             ");
            System.out.println("===================================================");
            System.out.println("1.Manual de Operación    2.Procedimiento de Seguridad ");
            System.out.println("3.Mantenimiento y Reparación 4.Pruebas y Diagnóstico ");
            System.out.println("5.Manual de Conducta     6.Operaciones del Sector   ");
            System.out.println("===================================================");
            System.out.println("Elija el nuevo tipo de orientación:");
            System.out.println("---------------------------------------------------");
            String tipo = input.nextLine();

            if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manual de Operación")){
                tipo = "Manual de Operación";
            } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procedimiento de Seguridad")){
                tipo = "Procedimiento de Seguridad";
            } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Mantenimiento y Reparación")){
                tipo = "Mantenimiento y Reparación";
            } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Pruebas y Diagnóstico")){
                tipo = "Pruebas y Diagnóstico";
            } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Manual de Conducta")){
                tipo = "Manual de Conducta";
            } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Operaciones del Sector")){
                tipo = "Operaciones del Sector";
            } else {
                System.out.println("Tipo inválido. Inténtelo de nuevo.");
                return;
            }

            System.out.println("===================================================");
            System.out.println("Ingrese la nueva orientación:");
            System.out.println("---------------------------------------------------");
            String novaOrientacao = input.nextLine();

            String sql = "UPDATE orientEs SET titulo = ?, tipo = ?, orient = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, novoTitulo);
            stmt.setString(2, tipo);
            stmt.setString(3, novaOrientacao);
            stmt.setInt(4, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("¡Orientación actualizada con éxito!");
            } else {
                System.out.println("No se encontró orientación con el ID: " + id);
            }

        } else if(escolha.equalsIgnoreCase("Título") || escolha.equalsIgnoreCase("Titulo")){
            System.out.println("===================================================");
            System.out.println("Ingrese el título de la orientación que desea actualizar:");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();

            System.out.println("Ingrese el nuevo título de la orientación:");
            System.out.println("----------------------------------------------------");
            String novoTitulo = input.nextLine();

            System.out.println("===================================================");
            System.out.println("                Tipos de Orientaciones             ");
            System.out.println("===================================================");
            System.out.println("1.Manual de Operación    2.Procedimiento de Seguridad ");
            System.out.println("3.Mantenimiento y Reparación 4.Pruebas y Diagnóstico ");
            System.out.println("5.Manual de Conducta     6.Operaciones del Sector   ");
            System.out.println("===================================================");
            System.out.println("Elija el nuevo tipo de orientación:");
            System.out.println("---------------------------------------------------");
            String tipo = input.nextLine();

            if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manual de Operación")){
                tipo = "Manual de Operación";
            } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procedimiento de Seguridad")){
                tipo = "Procedimiento de Seguridad";
            } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Mantenimiento y Reparación")){
                tipo = "Mantenimiento y Reparación";
            } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Pruebas y Diagnóstico")){
                tipo = "Pruebas y Diagnóstico";
            } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Manual de Conducta")){
                tipo = "Manual de Conducta";
            } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Operaciones del Sector")){
                tipo = "Operaciones del Sector";
            } else {
                System.out.println("Tipo inválido. Inténtelo de nuevo.");
                return;
            }

            System.out.println("===================================================");
            System.out.println("Ingrese la nueva orientación:");
            System.out.println("---------------------------------------------------");
            String novaOrientacao = input.nextLine();

            String sql = "UPDATE orientEs SET titulo = ?, tipo = ?, orient = ? WHERE titulo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, novoTitulo);
            stmt.setString(2, tipo);
            stmt.setString(3, novaOrientacao);
            stmt.setString(4, titulo);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("¡Orientación actualizada con éxito!");
            } else {
                System.out.println("No se encontró orientación con el título: " + titulo);
            }

        } else {
            System.out.println("Opción inválida. Inténtelo de nuevo.");
        }

    } catch (Exception e) {
        System.out.println("Error al actualizar la orientación: " + e.getMessage());
    }

    input.close();
}

    public static void AtualizarTituloOrientacaoEs() {
    Scanner input = new Scanner(System.in);

    try {

        System.out.println("===================================================");
        System.out.println("¿Desea buscar la orientación por ID o Título? (Escriba 'ID' o 'Título')");
        System.out.println("---------------------------------------------------");
        String escolha = input.nextLine();

        if (escolha.equalsIgnoreCase("Id")) {
            System.out.println("===================================================");
            System.out.println("Escriba el ID de la orientación que desea actualizar:");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Limpiar el buffer del scanner
            System.out.println("Escriba el nuevo título de la orientación:");
            System.out.println("----------------------------------------------------");
            String novoTitulo = input.nextLine();

            String sql = "UPDATE orientEs SET titulo = ? WHERE id = ?";
            try (Connection conn = ConexaoBD.getConexao();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, novoTitulo);
                stmt.setInt(2, id);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("¡Título actualizado con éxito!");
                } else {
                    System.out.println("No se encontró ninguna orientación con el ID: " + id);
                }
            }

        } else if (escolha.equalsIgnoreCase("titulo")) {

            System.out.println("===================================================");
            System.out.println("Escriba el título de la orientación que desea actualizar:");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();
            System.out.println("===================================================");
            System.out.println("Escriba el nuevo título de la orientación:");
            String novoTitulo = input.nextLine();
            System.out.println("----------------------------------------------------");

            String sql = "UPDATE orientEs SET titulo = ? WHERE titulo = ?";
            try (Connection conn = ConexaoBD.getConexao();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, novoTitulo);
                stmt.setString(2, titulo);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("¡Título actualizado con éxito!");
                } else {
                    System.out.println("No se encontró ninguna orientación con el título: " + titulo);
                }
            }

        } else {
            System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
        }

    } catch (Exception e) {
        System.out.println("Error al actualizar el título de la orientación: " + e.getMessage());
    }

    input.close();
}

public static void AtualizarTipoOrientacaoEs() {

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {

        System.out.println("===================================================");
        System.out.println("¿Desea buscar la orientación por ID o Título? (Escriba 'ID' o 'Título')");
        System.out.println("---------------------------------------------------");
        String escolha = input.nextLine();

        if (escolha.equalsIgnoreCase("Id")) {

            System.out.println("===================================================");
            System.out.println("Escriba el ID de la orientación que desea actualizar:");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Limpiar el buffer del scanner

            System.out.println("===================================================");
            System.out.println("                Tipos de Orientaciones             ");
            System.out.println("===================================================");
            System.out.println("1.Manual de Operación    2.Procedimiento de Seguridad");
            System.out.println("3.Mantenimiento y Reparaciones  4.Pruebas y Diagnóstico");
            System.out.println("5.Manual de Conducta     6.Operaciones Sectoriales   ");
            System.out.println("===================================================");
            System.out.println("Elija el nuevo Tipo de Orientación:");
            System.out.println("---------------------------------------------------");
            String tipo = input.nextLine();

            if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manual de Operación")) {
                tipo = "Manual de Operación";
            } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procedimiento de Seguridad")) {
                tipo = "Procedimiento de Seguridad";
            } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Mantenimiento y Reparaciones")) {
                tipo = "Mantenimiento y Reparaciones";
            } else if (tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Pruebas y Diagnóstico")) {
                tipo = "Pruebas y Diagnóstico";
            } else if (tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Manual de Conducta")) {
                tipo = "Manual de Conducta";
            } else if (tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Operaciones Sectoriales")) {
                tipo = "Operaciones Sectoriales";
            } else {
                System.out.println("Tipo inválido. Por favor, inténtelo de nuevo.");
                return;
            }

            String sql = "UPDATE orientEs SET tipo = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipo);
            stmt.setInt(2, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("¡Tipo actualizado con éxito!");
            } else {
                System.out.println("No se encontró ninguna orientación con el ID: " + id);
            }

        } else if (escolha.equalsIgnoreCase("Titulo")) {

            System.out.println("===================================================");
            System.out.println("Escriba el título de la orientación que desea actualizar:");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();
            System.out.println("===================================================");
            System.out.println("                Tipos de Orientaciones             ");
            System.out.println("===================================================");
            System.out.println("1.Manual de Operación    2.Procedimiento de Seguridad");
            System.out.println("3.Mantenimiento y Reparaciones  4.Pruebas y Diagnóstico");
            System.out.println("5.Manual de Conducta     6.Operaciones Sectoriales   ");
            System.out.println("===================================================");
            System.out.println("Elija el nuevo Tipo de Orientación:");
            System.out.println("---------------------------------------------------");
            String tipo = input.nextLine();

            if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manual de Operación")) {
                tipo = "Manual de Operación";
            } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procedimiento de Seguridad")) {
                tipo = "Procedimiento de Seguridad";
            } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Mantenimiento y Reparaciones")) {
                tipo = "Mantenimiento y Reparaciones";
            } else if (tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Pruebas y Diagnóstico")) {
                tipo = "Pruebas y Diagnóstico";
            } else if (tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Manual de Conducta")) {
                tipo = "Manual de Conducta";
            } else if (tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Operaciones Sectoriales")) {
                tipo = "Operaciones Sectoriales";
            } else {
                System.out.println("Tipo inválido. Por favor, inténtelo de nuevo.");
                return;
            }

            String sql = "UPDATE orientEs SET tipo = ? WHERE titulo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipo);
            stmt.setString(2, titulo);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("¡Tipo actualizado con éxito!");
            } else {
                System.out.println("No se encontró ninguna orientación con el título: " + titulo);
            }

        } else {
            System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            return;
        }

    } catch (Exception e) {
        System.out.println("Error al actualizar el tipo de la orientación: " + e.getMessage());
    }

    input.close();

}

public static void AtualizarOrientacaoEs() {

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {

        System.out.println("===================================================");
        System.out.println("¿Desea buscar la orientación por ID o Título? (Escriba 'ID' o 'Título')");
        System.out.println("---------------------------------------------------");
        String escolha = input.nextLine();

        if (escolha.equalsIgnoreCase("Id")) {

            System.out.println("===================================================");
            System.out.println("Escriba el ID de la orientación que desea actualizar:");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Limpiar el buffer del scanner
            System.out.println("Escriba la nueva orientación:");
            System.out.println("----------------------------------------------------");
            String novaOrientacao = input.nextLine();

            String sql = "UPDATE orientEs SET orient = ? WHERE id = ?";
            PreparedStatement stmt = ConexaoBD.getConexao().prepareStatement(sql);
            stmt.setString(1, novaOrientacao);
            stmt.setInt(2, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("¡Orientación actualizada con éxito!");
            } else {
                System.out.println("No se encontró ninguna orientación con el ID: " + id);
            }

        } else if (escolha.equalsIgnoreCase("Titulo")) {

            System.out.println("===================================================");
            System.out.println("Escriba el título de la orientación que desea actualizar:");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();
            System.out.println("===================================================");
            System.out.println("Escriba la nueva orientación:");
            System.out.println("----------------------------------------------------");
            String novaOrientacao = input.nextLine();

            String sql = "UPDATE orientEs SET orient = ? WHERE titulo = ?";
            PreparedStatement stmt = ConexaoBD.getConexao().prepareStatement(sql);
            stmt.setString(1, novaOrientacao);
            stmt.setString(2, titulo);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("¡Orientación actualizada con éxito!");
            } else {
                System.out.println("Error al buscar " + titulo + " en el sistema");
            }

        } else {
            System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            return;
        }
    } catch (Exception e) {
        System.out.println("Error al actualizar la orientación: " + e.getMessage());
    }

    input.close();

}

}
