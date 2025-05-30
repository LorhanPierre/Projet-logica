package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ConexaoBD.ConexaoBD;

public class orientacaoFr {

    public static void cadastroFR() {

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()){

        System.out.println("=====================================================================");
        System.out.println("Entrez le titre de la directive que vous souhaitez enregistrer :");
        System.out.println("--------------------------------------------------------------------");
        String titulo = input.nextLine();
        System.out.println("+==================================================================+");
        System.out.println("|                          Types de directives                     |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|   1 Manuel d'opération    2 Procédure de sécurité                |");
        System.out.println("|   3 Maintenance et Réparation 4 Tests et diagnostics            |");
        System.out.println("|   5 Code de conduite      6 Opérations sectorielles              |");
        System.out.println("+==================================================================+");
        System.out.print("| Sélectionnez le type de directive que vous souhaitez enregistrer :");
        String tipo = input.nextLine();

        if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manuel d'opération")){
            tipo = "Manuel d'opération";

        } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procédure de sécurité")){
            tipo = "Procédure de sécurité";

        } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance et Réparation")){
            tipo = "Maintenance et Réparation";

        } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Tests et diagnostics")){
            tipo = "Tests et diagnostics";

        } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Code de conduite")){
            tipo = "Code de conduite";

        } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Opérations sectorielles")){
            tipo = "Opérations sectorielles";

        } else {
            System.out.println("Type invalide. Veuillez réessayer.");
            return;
        }
        System.out.println("|------------------------------------------------------------------|");
        System.out.print("| Entrez la directive que vous souhaitez enregistrer :");
        System.out.println("|------------------------------------------------------------------|");
        String Orientacao = input.nextLine();
        System.out.println("+==================================================================+");

        String sql =  "INSERT INTO orientFr (titulo, tipo, orient) VALUES (?,?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        stmt.setString(2, tipo);
        stmt.setString(3, Orientacao);
        stmt.executeUpdate();

        System.out.println("Directive en Fr enregistrée avec succès !");

    } catch (SQLException e) {
        System.out.println("Erreur lors de l'enregistrement de la directive : " + e.getMessage());
    } 
    input.close();
}

public static void ListarTodaTabelaFR() {
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
            System.out.println("Directive : " + rs.getString("orient"));

        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la récupération des directives : " + e.getMessage());
    }
}



}
