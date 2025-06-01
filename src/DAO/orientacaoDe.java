package DAO;

import ConexaoBD.ConexaoBD;
import java.sql.*;
import java.util.Scanner;

public class orientacaoDe {

public void cadastroDe() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {

        boolean entradaValida = true;
        String titulo;
        String tipo;
        String Orientacao;

        String tipoEn = "", tipoFr = "", tipoEs = "", tipoPt = "";
        String tituloEn, tituloFr, tituloEs, tituloPt;
        String orientEn, orientFr, orientEs, orientPt;

        do {
            entradaValida = true;

            System.out.println("!Achtung! Sie müssen die Anleitung auf Deutsch, Englisch,\nFranzösisch, Spanisch und Portugiesisch eingeben.");
            System.out.println("=====================================================================");
            System.out.println("Geben Sie den deutschen Titel der Anleitung ein, die Sie registrieren möchten:");
            System.out.println("--------------------------------------------------------------------");
            titulo = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Geben Sie den englischen Titel der Anleitung ein:");
            System.out.println("--------------------------------------------------------------------");
            tituloEn = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Geben Sie den französischen Titel der Anleitung ein:");
            System.out.println("--------------------------------------------------------------------");
            tituloFr = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Geben Sie den spanischen Titel der Anleitung ein:");
            System.out.println("--------------------------------------------------------------------");
            tituloEs = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Geben Sie den portugiesischen Titel der Anleitung ein:");
            System.out.println("--------------------------------------------------------------------");
            tituloPt = input.nextLine();
            System.out.println("+==================================================================+");

            if (titulo.isEmpty()) {
                System.out.println("Dieses Feld muss ausgefüllt werden.");
                entradaValida = false;
            }

        } while (entradaValida == false);

        do {
            entradaValida = true;

            System.out.println("+==================================================================+");
            System.out.println("|                      Anleitungstypen                             |");
            System.out.println("|------------------------------------------------------------------|");
            System.out.println("|    1 Betriebsanleitung     2 Sicherheitsverfahren                |");
            System.out.println("|    3 Wartung und Reparatur 4 Tests und Diagnosen                |");
            System.out.println("|    5 Verhaltenskodex       6 Sektoroperationen                  |");
            System.out.println("+==================================================================+");
            System.out.print("| Geben Sie den Typ der Anleitung ein, die Sie registrieren möchten: ");
            tipo = input.nextLine();

            if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Betriebsanleitung")) {
                tipo = "Betriebsanleitung";
                tipoEn = "Operation Manual";
                tipoFr = "Manuel d'opération";
                tipoEs = "Manual de Operaciones";
                tipoPt = "Manual de Operação";

            } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Sicherheitsverfahren")) {
                tipo = "Sicherheitsverfahren";
                tipoEn = "Safety Procedure";
                tipoFr = "Procédure de sécurité";
                tipoEs = "Procedimiento de Seguridad";
                tipoPt = "Procedimento de Segurança";

            } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Wartung und Reparatur")) {
                tipo = "Wartung und Reparatur";
                tipoEn = "Maintenance and Repairs";
                tipoFr = "Maintenance et Réparation";
                tipoEs = "Mantenimiento y Reparación";
                tipoPt = "Manutenção e Reparos";

            } else if (tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Tests und Diagnosen")) {
                tipo = "Tests und Diagnosen";
                tipoEn = "Testing and Diagnosis";
                tipoFr = "Tests et diagnostics";
                tipoEs = "Pruebas y Diagnósticos";
                tipoPt = "Testes e Diagnóstico";

            } else if (tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Verhaltenskodex")) {
                tipo = "Verhaltenskodex";
                tipoEn = "Code of Conduct";
                tipoFr = "Code de conduite";
                tipoEs = "Código de Conducta";
                tipoPt = "Manual de Conduta";

            } else if (tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Sektoroperationen")) {
                tipo = "Sektoroperationen";
                tipoEn = "Sector Operations";
                tipoFr = "Opérations sectorielles";
                tipoEs = "Operaciones Sectoriales";
                tipoPt = "Operações Setoriais";

            } else {
                System.out.println("Ungültiger Typ. Bitte versuchen Sie es erneut.");
                entradaValida = false;
            }

        } while (entradaValida == false);

        do {
            System.out.println("+==================================================================+");
            System.out.println("| Geben Sie die Anleitung auf Deutsch ein:");
            System.out.println("|------------------------------------------------------------------|");
            Orientacao = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Geben Sie die Anleitung auf Englisch ein:");
            System.out.println("|------------------------------------------------------------------|");
            orientEn = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Geben Sie die Anleitung auf Französisch ein:");
            System.out.println("|------------------------------------------------------------------|");
            orientFr = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Geben Sie die Anleitung auf Spanisch ein:");
            System.out.println("|------------------------------------------------------------------|");
            orientEs = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Geben Sie die Anleitung auf Portugiesisch ein:");
            System.out.println("|------------------------------------------------------------------|");
            orientPt = input.nextLine();
            System.out.println("+==================================================================+");

            if (Orientacao.isEmpty()) {
                System.out.println("Dieses Feld muss ausgefüllt werden.");
                entradaValida = false;
            } else {
                entradaValida = true;
            }

        } while (entradaValida == false);

        // Inserções no banco de dados com os papéis invertidos
        String sql = "INSERT INTO orientDe (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        stmt.setString(2, tipo);
        stmt.setString(3, Orientacao);
        stmt.executeUpdate();

        String sqlEn = "INSERT INTO orientEn (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtEn = conn.prepareStatement(sqlEn);
        stmtEn.setString(1, tituloEn);
        stmtEn.setString(2, tipoEn);
        stmtEn.setString(3, orientEn);
        stmtEn.executeUpdate();

        String sqlEs = "INSERT INTO orientEs (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtEs = conn.prepareStatement(sqlEs);
        stmtEs.setString(1, tituloEs);
        stmtEs.setString(2, tipoEs);
        stmtEs.setString(3, orientEs);
        stmtEs.executeUpdate();

        String sqlFr = "INSERT INTO orientFr (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtFr = conn.prepareStatement(sqlFr);
        stmtFr.setString(1, tituloFr);
        stmtFr.setString(2, tipoFr);
        stmtFr.setString(3, orientFr);
        stmtFr.executeUpdate();

        String sqlPt = "INSERT INTO orientPt (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtPt = conn.prepareStatement(sqlPt);
        stmtPt.setString(1, tituloPt);
        stmtPt.setString(2, tipoPt);
        stmtPt.setString(3, orientPt);
        stmtPt.executeUpdate();

        System.out.println("Anleitung auf Deutsch erfolgreich registriert!");

    } catch (SQLException e) {
        System.out.println("Fehler beim Registrieren der Anleitung: " + e.getMessage());
    }

    input.close();
}
    //================================================================================================================

    public static void ListarTodaTabelaDe() {
    try (Connection conn = ConexaoBD.getConexao()) {
        String sql = "SELECT * FROM orientDe"; // também mudei a tabela para alemão
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {

            System.out.println("==================================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("..................................................................");
            System.out.println("Titel: " + rs.getString("titulo"));
            System.out.println("..................................................................");
            System.out.println("Typ: " + rs.getString("tipo"));
            System.out.println("..................................................................");
            System.out.println("Anleitung: " + rs.getString("orient"));

        }
    } catch (SQLException e) {
        System.out.println("Fehler beim Abrufen der Anleitungen: " + e.getMessage());
    }
}

public static void ListarTudoPorTipoDe() {

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("+==================================================================+");
        System.out.println("|                      Arten von Anleitungen                      |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|         1 Betriebsanleitung        2 Sicherheitsverfahren        |");
        System.out.println("|         3 Wartung und Reparatur   4 Tests und Diagnosen          |");
        System.out.println("|         5 Verhaltenskodex          6 Sektoroperationen           |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.print("| Wählen Sie den Anleitungs-Typ, den Sie filtern möchten: ");
        String tipo = input.nextLine();

        if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Betriebsanleitung")) {
            tipo = "Betriebsanleitung";
        } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Sicherheitsverfahren")) {
            tipo = "Sicherheitsverfahren";
        } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Wartung und Reparatur")) {
            tipo = "Wartung und Reparatur";
        } else if (tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Tests und Diagnosen")) {
            tipo = "Tests und Diagnosen";
        } else if (tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Verhaltenskodex")) {
            tipo = "Verhaltenskodex";
        } else if (tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Sektoroperationen")) {
            tipo = "Sektoroperationen";
        } else {
            System.out.println("Ungültiger Typ. Bitte versuchen Sie es erneut.");
            return;
        }

        String sql = "SELECT * FROM orientDe WHERE tipo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tipo);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("===================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("...................................................");
            System.out.println("Titel: " + rs.getString("titulo"));
            System.out.println("...................................................");
            System.out.println("Typ: " + rs.getString("tipo"));
            System.out.println("...................................................");
            System.out.println("Anleitung: " + rs.getString("orient"));
            System.out.println("===================================================");
        }

    } catch (SQLException e) {
        System.out.println("Fehler beim Abrufen der Anleitungen: " + e.getMessage());
    }

    input.close();

}

//BUSCAS ESPECIFICAS///========================================================================================

public static void BuscaPorIDDe() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Geben Sie die ID der Anleitung ein, die Sie suchen:");
        System.out.println("---------------------------------------------------");
        int id = input.nextInt();
        String sql = "SELECT * FROM orientDe WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("===================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("...................................................");
            System.out.println("Titel: " + rs.getString("titulo"));
            System.out.println("...................................................");
            System.out.println("Typ: " + rs.getString("tipo"));
            System.out.println("...................................................");
            System.out.println("Anleitung: " + rs.getString("orient"));
            System.out.println("===================================================");
        } else {
            System.out.println("Keine Anleitung mit der ID gefunden: " + id);
        }
    } catch (SQLException e) {
        System.out.println("Fehler bei der Suche nach der Anleitung: " + e.getMessage());
    }

    input.close();
}

public static void BuscaPorTituloDe() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Geben Sie den Titel der Anleitung ein, die Sie suchen:");
        System.out.println("---------------------------------------------------");
        String titulo = input.nextLine();
        String sql = "SELECT * FROM orientDe WHERE titulo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            do {
                System.out.println("===================================================");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("...................................................");
                System.out.println("Titel: " + rs.getString("titulo"));
                System.out.println("...................................................");
                System.out.println("Typ: " + rs.getString("tipo"));
                System.out.println("...................................................");
                System.out.println("Anleitung: " + rs.getString("orient"));
                System.out.println("===================================================");
            } while (rs.next());
        } else {
            System.out.println("Keine Anleitung mit dem Titel gefunden: " + titulo);
        }
    } catch (SQLException e) {
        System.out.println("Fehler bei der Suche nach der Anleitung: " + e.getMessage());
    }

    input.close();
}

}