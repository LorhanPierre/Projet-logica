package DAO;

import ConexaoBD.ConexaoBD;
import java.sql.*;
import java.util.*;

public class orientacaoFr {

    public static void cadastroFr() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {

        boolean entradaValida = true;
        String titulo;
        String tipo;
        String Orientacao;

        String tipoPt = "", tipoEs = "", tipoDe = "", tipoEn = "";
        String tituloPt, tituloEs, tituloDe, tituloEn;
        String orientPt, orientEs, orientDe, orientEn;

        do {
            entradaValida = true;

            System.out.println("!Attention! Vous devrez enregistrer l'orientation en français, anglais, espagnol, allemand et portugais.");
            System.out.println("=====================================================================");
            System.out.println("Entrez le titre de l'orientation en français:");
            System.out.println("--------------------------------------------------------------------");
            titulo = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Entrez le titre de l'orientation en anglais:");
            System.out.println("--------------------------------------------------------------------");
            tituloEn = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Entrez le titre de l'orientation en espagnol:");
            System.out.println("--------------------------------------------------------------------");
            tituloEs = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Entrez le titre de l'orientation en allemand:");
            System.out.println("--------------------------------------------------------------------");
            tituloDe = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("Entrez le titre de l'orientation en portugais:");
            System.out.println("--------------------------------------------------------------------");
            tituloPt = input.nextLine();
            System.out.println("+==================================================================+");

            if (titulo.isEmpty()) {
                System.out.println("Ce champ doit être rempli.");
                entradaValida = false;
            }

        } while (!entradaValida);

        do {
            entradaValida = true;

            System.out.println("+==================================================================+");
            System.out.println("|                      Types d'orientations                        |");
            System.out.println("|------------------------------------------------------------------|");
            System.out.println("| 1 Manuel d'exploitation     2 Procédure de sécurité              |");
            System.out.println("| 3 Maintenance et réparations 4 Tests et diagnostics              |");
            System.out.println("| 5 Code de conduite          6 Opérations sectorielles            |");
            System.out.println("+==================================================================+");
            System.out.print("| Entrez le type d'orientation que vous souhaitez enregistrer: ");
            tipo = input.nextLine();

            if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manuel d'exploitation")) {
                tipo = "Manuel d'exploitation";
                tipoEn = "Operation Manual";
                tipoEs = "Manual de Operaciones";
                tipoDe = "Betriebsanleitung";
                tipoPt = "Manual de Operação";

            } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procédure de sécurité")) {
                tipo = "Procédure de sécurité";
                tipoEn = "Safety Procedure";
                tipoEs = "Procedimiento de Seguridad";
                tipoDe = "Sicherheitsverfahren";
                tipoPt = "Procedimento de Segurança";

            } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance et Réparation")) {
                tipo = "Maintenance et Réparation";
                tipoEn = "Maintenance and Repairs";
                tipoEs = "Mantenimiento y Reparación";
                tipoDe = "Wartung und Reparatur";
                tipoPt = "Manutenção e Reparos";

            } else if (tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Tests et diagnostics")) {
                tipo = "Tests et diagnostics";
                tipoEn = "Testing and Diagnosis";
                tipoEs = "Pruebas y Diagnósticos";
                tipoDe = "Tests und Diagnosen";
                tipoPt = "Testes e Diagnóstico";

            } else if (tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Code de conduite")) {
                tipo = "Code de conduite";
                tipoEn = "Code of Conduct";
                tipoEs = "Código de Conducta";
                tipoDe = "Verhaltenskodex";
                tipoPt = "Manual de Conduta";

            } else if (tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Opérations sectorielles")) {
                tipo = "Opérations sectorielles";
                tipoEn = "Sector Operations";
                tipoEs = "Operaciones Sectoriales";
                tipoDe = "Sektoroperationen";
                tipoPt = "Operações Setoriais";

            } else {
                System.out.println("Type invalide. Veuillez réessayer.");
                entradaValida = false;
            }

        } while (!entradaValida);

        do {
            System.out.println("+==================================================================+");
            System.out.println("| Entrez l'orientation (Français) :");
            System.out.println("|------------------------------------------------------------------|");
            Orientacao = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Entrez l'orientation (Anglais) :");
            System.out.println("|------------------------------------------------------------------|");
            orientEn = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Entrez l'orientation (Espagnol) :");
            System.out.println("|------------------------------------------------------------------|");
            orientEs = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Entrez l'orientation (Allemand) :");
            System.out.println("|------------------------------------------------------------------|");
            orientDe = input.nextLine();
            System.out.println("+==================================================================+");
            System.out.println("| Entrez l'orientation (Portugais) :");
            System.out.println("|------------------------------------------------------------------|");
            orientPt = input.nextLine();
            System.out.println("+==================================================================+");

            if (Orientacao.isEmpty()) {
                System.out.println("Ce champ doit être rempli.");
                entradaValida = false;
            } else {
                entradaValida = true;
            }

        } while (!entradaValida);

        // Insertion dans la base de données
        String sqlFr = "INSERT INTO orientFr (titulo, tipo, orient) VALUES (?, ?, ?)";
        PreparedStatement stmtFr = conn.prepareStatement(sqlFr);
        stmtFr.setString(1, titulo);
        stmtFr.setString(2, tipo);
        stmtFr.setString(3, Orientacao);
        stmtFr.executeUpdate();

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

        System.out.println("Orientation enregistrée avec succès en français !");

    } catch (SQLException e) {
        System.out.println("Erreur lors de l'enregistrement de l'orientation : " + e.getMessage());
    }

    input.close();
}

    //============================================================================================================================

    public static void ListarTodaTabelaFr() {
    try (Connection conn = ConexaoBD.getConexao()) {
        String sql = "SELECT * FROM orientFr";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println("==================================================================");
            System.out.println("ID : " + rs.getInt("id"));
            System.out.println("..................................................................");
            System.out.println("Titre : " + rs.getString("titulo"));
            System.out.println("..................................................................");
            System.out.println("Type : " + rs.getString("tipo"));
            System.out.println("..................................................................");
            System.out.println("Orientation : " + rs.getString("orient"));
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la récupération des orientations : " + e.getMessage());
    }
}

public static void ListarTudoPorTipoFr() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("+==================================================================+");
        System.out.println("|                      Types d'Orientation                         |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|         1 Manuel d'Opération     2 Procédure de Sécurité         |");
        System.out.println("|         3 Maintenance et Réparations 4 Tests et Diagnostics      |");
        System.out.println("|         5 Manuel de Conduite     6 Opérations Sectorielles       |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.print("| Choisissez le type d'orientation à filtrer : ");
        String tipo = input.nextLine();

        if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manuel d'Opération")) {
            tipo = "Manuel d'Opération";
        } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procédure de Sécurité")) {
            tipo = "Procédure de Sécurité";
        } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance et Réparations")) {
            tipo = "Maintenance et Réparations";
        } else if (tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Tests et Diagnostics")) {
            tipo = "Tests et Diagnostics";
        } else if (tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Manuel de Conduite")) {
            tipo = "Manuel de Conduite";
        } else if (tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Opérations Sectorielles")) {
            tipo = "Opérations Sectorielles";
        } else {
            System.out.println("Type invalide. Veuillez réessayer.");
            return;
        }

        String sql = "SELECT * FROM orientFr WHERE tipo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tipo);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("===================================================");
            System.out.println("ID : " + rs.getInt("id"));
            System.out.println("...................................................");
            System.out.println("Titre : " + rs.getString("titulo"));
            System.out.println("...................................................");
            System.out.println("Type : " + rs.getString("tipo"));
            System.out.println("...................................................");
            System.out.println("Orientation : " + rs.getString("orient"));
            System.out.println("===================================================");
        }

    } catch (SQLException e) {
        System.out.println("Erreur lors de la récupération des orientations : " + e.getMessage());
    }

    input.close();
}

public static void BuscaPorIDFr() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Entrez l'ID de l'orientation que vous souhaitez rechercher :");
        System.out.println("---------------------------------------------------");
        int id = input.nextInt();
        String sql = "SELECT * FROM orientFr WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("===================================================");
            System.out.println("ID : " + rs.getInt("id"));
            System.out.println("...................................................");
            System.out.println("Titre : " + rs.getString("titulo"));
            System.out.println("...................................................");
            System.out.println("Type : " + rs.getString("tipo"));
            System.out.println("...................................................");
            System.out.println("Orientation : " + rs.getString("orient"));
            System.out.println("===================================================");
        } else {
            System.out.println("Aucune orientation trouvée avec l'ID : " + id);
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la recherche de l'orientation : " + e.getMessage());
    }

    input.close();
}

public static void BuscaPorTituloFr() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Entrez le titre de l'orientation que vous souhaitez rechercher :");
        System.out.println("---------------------------------------------------");
        String titulo = input.nextLine();
        String sql = "SELECT * FROM orientFr WHERE titulo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            do {
                System.out.println("===================================================");
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("...................................................");
                System.out.println("Titre : " + rs.getString("titulo"));
                System.out.println("...................................................");
                System.out.println("Type : " + rs.getString("tipo"));
                System.out.println("...................................................");
                System.out.println("Orientation : " + rs.getString("orient"));
                System.out.println("===================================================");
            } while (rs.next());
        } else {
            System.out.println("Aucune orientation trouvée avec le titre : " + titulo);
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la recherche de l'orientation : " + e.getMessage());
    }

    input.close();
}

    //============================================================================================================================

    public static void ExcluirPorIDFr() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("Vous êtes sur le point de supprimer une orientation dans toutes les langues.");
        System.out.println("===================================================");
        System.out.println("Entrez l'ID de l'orientation que vous souhaitez supprimer :");
        System.out.println("---------------------------------------------------");
        int id = input.nextInt();
        System.out.println("===================================================");
        System.out.println("Êtes-vous sûr de vouloir supprimer l'orientation avec l'ID : " + id + " ? (o/n)");
        String escolha = input.next();

        if (escolha.equalsIgnoreCase("n") || escolha.equalsIgnoreCase("non")) {
            System.out.println("Suppression annulée.");
            return;
        }

        String sqlDe = "DELETE FROM orientDe WHERE id = ?";
        PreparedStatement stmtDe = conn.prepareStatement(sqlDe);
        stmtDe.setInt(1, id);
        int rowsAffectedDe = stmtDe.executeUpdate();

        String sqlEn = "DELETE FROM orientEn WHERE id = ?";
        PreparedStatement stmtEn = conn.prepareStatement(sqlEn);
        stmtEn.setInt(1, id);
        int rowsAffectedEn = stmtEn.executeUpdate();

        String sqlEs = "DELETE FROM orientEs WHERE id = ?";
        PreparedStatement stmtEs = conn.prepareStatement(sqlEs);
        stmtEs.setInt(1, id);
        int rowsAffectedEs = stmtEs.executeUpdate();

        String sqlFr = "DELETE FROM orientFr WHERE id = ?";
        PreparedStatement stmtFr = conn.prepareStatement(sqlFr);
        stmtFr.setInt(1, id);
        int rowsAffectedFr = stmtFr.executeUpdate();

        String sqlPt = "DELETE FROM orientPt WHERE id = ?";
        PreparedStatement stmtPt = conn.prepareStatement(sqlPt);
        stmtPt.setInt(1, id);
        int rowsAffectedPt = stmtPt.executeUpdate();

        if (rowsAffectedDe > 0) {
            System.out.println("Orientation supprimée avec succès !");
        } else {
            System.out.println("L'ID : " + id + " n'a pas été trouvé pour la suppression.");
        }

    } catch (SQLException e) {
        System.out.println("Erreur lors de la suppression de l'orientation : " + e.getMessage());
    }

    input.close();
}

public static void ExcluirPorTituloFr() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Entrez le titre de l'orientation que vous souhaitez supprimer :");
        System.out.println("---------------------------------------------------");
        String titulo = input.nextLine();
        System.out.println("===================================================");
        System.out.println("Êtes-vous sûr de vouloir supprimer l'orientation avec le titre : " + titulo + " ? (o/n)");
        String escolha = input.next();

        if (escolha.equalsIgnoreCase("n") || escolha.equalsIgnoreCase("non")) {
            System.out.println("Suppression annulée.");
            return;
        }

        String sqlDe = "SELECT id FROM orientDe WHERE titulo = ?";
        PreparedStatement stmtDe = conn.prepareStatement(sqlDe);
        stmtDe.setString(1, titulo);
        ResultSet rs = stmtDe.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");

            String sqlDelDe = "DELETE FROM orientDe WHERE id = ?";
            PreparedStatement stmtDelDe = conn.prepareStatement(sqlDelDe);
            stmtDelDe.setInt(1, id);
            int rowsAffectedDe = stmtDelDe.executeUpdate();

            String sqlDelEn = "DELETE FROM orientEn WHERE id = ?";
            PreparedStatement stmtDelEn = conn.prepareStatement(sqlDelEn);
            stmtDelEn.setInt(1, id);
            int rowsAffectedEn = stmtDelEn.executeUpdate();

            String sqlDelEs = "DELETE FROM orientEs WHERE id = ?";
            PreparedStatement stmtDelEs = conn.prepareStatement(sqlDelEs);
            stmtDelEs.setInt(1, id);
            int rowsAffectedEs = stmtDelEs.executeUpdate();

            String sqlDelFr = "DELETE FROM orientFr WHERE id = ?";
            PreparedStatement stmtDelFr = conn.prepareStatement(sqlDelFr);
            stmtDelFr.setInt(1, id);
            int rowsAffectedFr = stmtDelFr.executeUpdate();

            String sqlDelPt = "DELETE FROM orientPt WHERE id = ?";
            PreparedStatement stmtDelPt = conn.prepareStatement(sqlDelPt);
            stmtDelPt.setInt(1, id);
            int rowsAffectedPt = stmtDelPt.executeUpdate();

            if (rowsAffectedDe > 0) {
                System.out.println("Orientation supprimée avec succès !");
            } else {
                System.out.println("Aucune orientation trouvée avec le titre : " + titulo);
            }

        } else {
            System.out.println("Aucune orientation trouvée avec le titre : " + titulo);
        }

    } catch (SQLException e) {
        System.out.println("Erreur lors de la suppression de l'orientation : " + e.getMessage());
    }

    input.close();
}

    //============================================================================================================================

    public static void AtualizarTodaAOrientacaoFr(){
    
    Scanner input = new Scanner (System.in);

    try(Connection conn = ConexaoBD.getConexao()){
        System.out.println("===================================================");
        System.out.println("Souhaitez-vous rechercher l'orientation par ID ou par Titre ? (Tapez 'ID' ou 'Titre')");
        System.out.println("---------------------------------------------------");
        String escolha = input.nextLine();

        if(escolha.equalsIgnoreCase("ID")){
            System.out.println("===================================================");
            System.out.println("Entrez l'ID de l'orientation à mettre à jour :");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Nettoyer le buffer du scanner
            System.out.println("Entrez le nouveau titre de l'orientation :");
            System.out.println("----------------------------------------------------");
            String novoTitulo = input.nextLine();

            System.out.println("===================================================");
            System.out.println("               Types d'Orientations               ");
            System.out.println("===================================================");
            System.out.println("1.Manuel d'Opération   2.Procédure de Sécurité");
            System.out.println("3.Maintenance et Réparation  4.Tests et Diagnostics");
            System.out.println("5.Manuel de Conduite   6.Opérations du Secteur");
            System.out.println("===================================================");
            System.out.println("Choisissez le nouveau type d'orientation :");
            System.out.println("---------------------------------------------------");
            String tipo = input.nextLine();

            if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manuel d'Opération")){
                tipo = "Manuel d'Opération";
            } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procédure de Sécurité")){
                tipo = "Procédure de Sécurité";
            } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance et Réparation")){
                tipo = "Maintenance et Réparation";
            } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Tests et Diagnostics")){
                tipo = "Tests et Diagnostics";
            } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Manuel de Conduite")){
                tipo = "Manuel de Conduite";
            } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Opérations du Secteur")){
                tipo = "Opérations du Secteur";
            } else {
                System.out.println("Type invalide. Veuillez réessayer.");
                return;
            }

            System.out.println("===================================================");
            System.out.println("Entrez la nouvelle orientation :");
            System.out.println("---------------------------------------------------");
            String novaOrientacao = input.nextLine();

            String sql = "UPDATE orientFr SET titulo = ?, tipo = ?, orient = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, novoTitulo);
            stmt.setString(2, tipo);
            stmt.setString(3, novaOrientacao);
            stmt.setInt(4, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Orientation mise à jour avec succès !");
            } else {
                System.out.println("Aucune orientation trouvée avec l'ID : " + id);
            }

        } else if(escolha.equalsIgnoreCase("Titre")){
            System.out.println("===================================================");
            System.out.println("Entrez le titre de l'orientation à mettre à jour :");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();

            System.out.println("Entrez le nouveau titre de l'orientation :");
            System.out.println("----------------------------------------------------");
            String novoTitulo = input.nextLine();

            System.out.println("===================================================");
            System.out.println("               Types d'Orientations               ");
            System.out.println("===================================================");
            System.out.println("1.Manuel d'Opération   2.Procédure de Sécurité");
            System.out.println("3.Maintenance et Réparation  4.Tests et Diagnostics");
            System.out.println("5.Manuel de Conduite   6.Opérations du Secteur");
            System.out.println("===================================================");
            System.out.println("Choisissez le nouveau type d'orientation :");
            System.out.println("---------------------------------------------------");
            String tipo = input.nextLine();

            if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manuel d'Opération")){
                tipo = "Manuel d'Opération";
            } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procédure de Sécurité")){
                tipo = "Procédure de Sécurité";
            } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance et Réparation")){
                tipo = "Maintenance et Réparation";
            } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Tests et Diagnostics")){
                tipo = "Tests et Diagnostics";
            } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Manuel de Conduite")){
                tipo = "Manuel de Conduite";
            } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Opérations du Secteur")){
                tipo = "Opérations du Secteur";
            } else {
                System.out.println("Type invalide. Veuillez réessayer.");
                return;
            }

            System.out.println("===================================================");
            System.out.println("Entrez la nouvelle orientation :");
            System.out.println("---------------------------------------------------");
            String novaOrientacao = input.nextLine();

            String sql = "UPDATE orientFr SET titulo = ?, tipo = ?, orient = ? WHERE titulo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, novoTitulo);
            stmt.setString(2, tipo);
            stmt.setString(3, novaOrientacao);
            stmt.setString(4, titulo);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Orientation mise à jour avec succès !");
            } else {
                System.out.println("Aucune orientation trouvée avec le titre : " + titulo);
            }

        } else {
            System.out.println("Option invalide. Veuillez réessayer.");
        }

    } catch (Exception e) {
        System.out.println("Erreur lors de la mise à jour de l'orientation : " + e.getMessage());
    }

    input.close();
}

    public static void AtualizarTituloOrientacaoFr() {
    Scanner input = new Scanner(System.in);

    try {

        System.out.println("===================================================");
        System.out.println("Voulez-vous rechercher l'orientation par ID ou par Titre ? (Tapez 'ID' ou 'Titre')");
        System.out.println("---------------------------------------------------");
        String escolha = input.nextLine();

        if (escolha.equalsIgnoreCase("Id")) {
            System.out.println("===================================================");
            System.out.println("Entrez l'ID de l'orientation que vous souhaitez mettre à jour :");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Nettoyer le buffer du scanner
            System.out.println("Entrez le nouveau titre de l'orientation :");
            System.out.println("----------------------------------------------------");
            String novoTitulo = input.nextLine();

            String sql = "UPDATE orientFr SET titulo = ? WHERE id = ?";
            try (Connection conn = ConexaoBD.getConexao();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, novoTitulo);
                stmt.setInt(2, id);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Titre mis à jour avec succès !");
                } else {
                    System.out.println("Aucune orientation trouvée avec l'ID : " + id);
                }
            }

        } else if (escolha.equalsIgnoreCase("titulo")) {

            System.out.println("===================================================");
            System.out.println("Entrez le titre de l'orientation que vous souhaitez mettre à jour :");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();
            System.out.println("===================================================");
            System.out.println("Entrez le nouveau titre de l'orientation :");
            String novoTitulo = input.nextLine();
            System.out.println("----------------------------------------------------");

            String sql = "UPDATE orientFr SET titulo = ? WHERE titulo = ?";
            try (Connection conn = ConexaoBD.getConexao();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, novoTitulo);
                stmt.setString(2, titulo);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Titre mis à jour avec succès !");
                } else {
                    System.out.println("Aucune orientation trouvée avec le titre : " + titulo);
                }
            }

        } else {
            System.out.println("Option invalide. Veuillez réessayer.");
        }

    } catch (Exception e) {
        System.out.println("Erreur lors de la mise à jour du titre de l'orientation : " + e.getMessage());
    }

    input.close();
}

public static void AtualizarTipoOrientacaoFr() {

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {

        System.out.println("===================================================");
        System.out.println("Voulez-vous rechercher l'orientation par ID ou par Titre ? (Tapez 'ID' ou 'Titre')");
        System.out.println("---------------------------------------------------");
        String escolha = input.nextLine();

        if (escolha.equalsIgnoreCase("Id")) {

            System.out.println("===================================================");
            System.out.println("Entrez l'ID de l'orientation que vous souhaitez mettre à jour :");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Nettoyer le buffer du scanner

            System.out.println("===================================================");
            System.out.println("               Types d'Orientation                 ");
            System.out.println("===================================================");
            System.out.println("1.Manuel d'Opération    2.Procédure de Sécurité");
            System.out.println("3.Maintenance et Réparations  4.Tests et Diagnostic");
            System.out.println("5.Manuel de Conduite    6.Opérations Sectorielles");
            System.out.println("===================================================");
            System.out.println("Choisissez le nouveau Type d'Orientation :");
            System.out.println("---------------------------------------------------");
            String tipo = input.nextLine();

            if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manuel d'Opération")) {
                tipo = "Manuel d'Opération";
            } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procédure de Sécurité")) {
                tipo = "Procédure de Sécurité";
            } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance et Réparations")) {
                tipo = "Maintenance et Réparations";
            } else if (tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Tests et Diagnostic")) {
                tipo = "Tests et Diagnostic";
            } else if (tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Manuel de Conduite")) {
                tipo = "Manuel de Conduite";
            } else if (tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Opérations Sectorielles")) {
                tipo = "Opérations Sectorielles";
            } else {
                System.out.println("Type invalide. Veuillez réessayer.");
                return;
            }

            String sql = "UPDATE orientFr SET tipo = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipo);
            stmt.setInt(2, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Type mis à jour avec succès !");
            } else {
                System.out.println("Aucune orientation trouvée avec l'ID : " + id);
            }

        } else if (escolha.equalsIgnoreCase("Titulo")) {

            System.out.println("===================================================");
            System.out.println("Entrez le titre de l'orientation que vous souhaitez mettre à jour :");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();
            System.out.println("===================================================");
            System.out.println("               Types d'Orientation                 ");
            System.out.println("===================================================");
            System.out.println("1.Manuel d'Opération    2.Procédure de Sécurité");
            System.out.println("3.Maintenance et Réparations  4.Tests et Diagnostic");
            System.out.println("5.Manuel de Conduite    6.Opérations Sectorielles");
            System.out.println("===================================================");
            System.out.println("Choisissez le nouveau Type d'Orientation :");
            System.out.println("---------------------------------------------------");
            String tipo = input.nextLine();

            if (tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manuel d'Opération")) {
                tipo = "Manuel d'Opération";
            } else if (tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procédure de Sécurité")) {
                tipo = "Procédure de Sécurité";
            } else if (tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance et Réparations")) {
                tipo = "Maintenance et Réparations";
            } else if (tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Tests et Diagnostic")) {
                tipo = "Tests et Diagnostic";
            } else if (tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Manuel de Conduite")) {
                tipo = "Manuel de Conduite";
            } else if (tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Opérations Sectorielles")) {
                tipo = "Opérations Sectorielles";
            } else {
                System.out.println("Type invalide. Veuillez réessayer.");
                return;
            }

            String sql = "UPDATE orientFr SET tipo = ? WHERE titulo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tipo);
            stmt.setString(2, titulo);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Type mis à jour avec succès !");
            } else {
                System.out.println("Aucune orientation trouvée avec le titre : " + titulo);
            }

        } else {
            System.out.println("Option invalide. Veuillez réessayer.");
            return;
        }

    } catch (Exception e) {
        System.out.println("Erreur lors de la mise à jour du type d'orientation : " + e.getMessage());
    }

    input.close();

}

public static void AtualizarOrientacaoFr() {

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {

        System.out.println("===================================================");
        System.out.println("Voulez-vous rechercher l'orientation par ID ou par Titre ? (Tapez 'ID' ou 'Titre')");
        System.out.println("---------------------------------------------------");
        String escolha = input.nextLine();

        if (escolha.equalsIgnoreCase("Id")) {

            System.out.println("===================================================");
            System.out.println("Entrez l'ID de l'orientation que vous souhaitez mettre à jour :");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Nettoyer le buffer du scanner
            System.out.println("Entrez la nouvelle orientation :");
            System.out.println("----------------------------------------------------");
            String novaOrientacao = input.nextLine();

            String sql = "UPDATE orientFr SET orient = ? WHERE id = ?";
            PreparedStatement stmt = ConexaoBD.getConexao().prepareStatement(sql);
            stmt.setString(1, novaOrientacao);
            stmt.setInt(2, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Orientation mise à jour avec succès !");
            } else {
                System.out.println("Aucune orientation trouvée avec l'ID : " + id);
            }

        } else if (escolha.equalsIgnoreCase("Titulo")) {

            System.out.println("===================================================");
            System.out.println("Entrez le titre de l'orientation que vous souhaitez mettre à jour :");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();
            System.out.println("===================================================");
            System.out.println("Entrez la nouvelle orientation :");
            System.out.println("----------------------------------------------------");
            String novaOrientacao = input.nextLine();

            String sql = "UPDATE orientFr SET orient = ? WHERE titulo = ?";
            PreparedStatement stmt = ConexaoBD.getConexao().prepareStatement(sql);
            stmt.setString(1, novaOrientacao);
            stmt.setString(2, titulo);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Orientation mise à jour avec succès !");
            } else {
                System.out.println("Erreur lors de la recherche de " + titulo + " dans le système");
            }

        } else {
            System.out.println("Option invalide. Veuillez réessayer.");
            return;
        }
    } catch (Exception e) {
        System.out.println("Erreur lors de la mise à jour de l'orientation : " + e.getMessage());
    }

    input.close();

}


}
