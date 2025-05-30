package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import ConexaoBD.ConexaoBD;

public class orientacaoDe {

    public static void cadastroDE() {

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {

        System.out.println("=====================================================================");
        System.out.println("Geben Sie den Titel der Richtlinie ein, die Sie registrieren möchten:");
        System.out.println("--------------------------------------------------------------------");
        String titulo = input.nextLine();
        System.out.println("+==================================================================+");
        System.out.println("|                          Arten von Richtlinien                   |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|   1 Bedienungsanleitung   2 Sicherheitsverfahren                |");
        System.out.println("|   3 Wartung und Reparatur 4 Tests und Diagnostik                |");
        System.out.println("|   5 Verhaltenskodex       6 Sektorale Operationen               |");
        System.out.println("+==================================================================+");
        System.out.print("| Wählen Sie den Typ der Richtlinie, die Sie registrieren möchten:");
        String tipo = input.nextLine();

        if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Bedienungsanleitung")){
            tipo = "Bedienungsanleitung";

        } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Sicherheitsverfahren")){
            tipo = "Sicherheitsverfahren";

        } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Wartung und Reparatur")){
            tipo = "Wartung und Reparatur";

        } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Tests und Diagnostik")){
            tipo = "Tests und Diagnostik";

        } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Verhaltenskodex")){
            tipo = "Verhaltenskodex";

        } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Sektorale Operationen")){
            tipo = "Sektorale Operationen";

        } else {
            System.out.println("Ungültiger Typ. Bitte versuchen Sie es erneut.");
            return;
        }
        System.out.println("|------------------------------------------------------------------|");
        System.out.print("| Geben Sie die Richtlinie ein, die Sie registrieren möchten:");
        System.out.println("|------------------------------------------------------------------|");
        String Orientacao = input.nextLine();
        System.out.println("+==================================================================+");

        String sql =  "INSERT INTO orientDe (titulo, tipo, orient) VALUES (?,?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        stmt.setString(2, tipo);
        stmt.setString(3, Orientacao);
        stmt.executeUpdate();

        System.out.println("Richtlinie auf DE erfolgreich registriert!");

    } catch (SQLException e) {
        System.out.println("Fehler beim Registrieren der Richtlinie: " + e.getMessage());
    } 
    input.close();
}

public static void ListarTodaTabelaDE() {
    try (Connection conn = ConexaoBD.getConexao()) {
        String sql = "SELECT * FROM orientDe";
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
            System.out.println("Richtlinie: " + rs.getString("orient"));

        }
    } catch (SQLException e) {
        System.out.println("Fehler beim Abrufen der Richtlinien: " + e.getMessage());
    }
}


}
