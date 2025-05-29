package DAO;

import ConexaoBD.ConexaoBD;
import java.sql.*;
import java.util.*;

public class orientacaoEn {

    //METEDO DE CADASTRO DE ORIENTAÇÕES EM INGLES///=========================================================================================
  public static void cadastroEN(){

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()){

        System.out.println("=====================================================================");
        System.out.println("Enter the title of the guideline you want to register:");
        System.out.println("--------------------------------------------------------------------");
        String titulo = input.nextLine();
        System.out.println("+==================================================================+");
        System.out.println("|                          Types of Guidelines                     |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|   1 Operation Manual     2 Safety Procedure                      |");
        System.out.println("|   3 Maintenance & Repair 4 Testing and Diagnostics               |");
        System.out.println("|   5 Code of Conduct      6 Sectoral Operations                   |");
        System.out.println("+==================================================================+");
        System.out.print("| Select the type of guideline you want to register:");
        String tipo = input.nextLine();

        if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Operation Manual")){
            tipo = "Operation Manual";

        } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Safety Procedure")){
            tipo = "Safety Procedure";

        } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance and Repair")){
            tipo = "Maintenance and Repair";

        } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Testing and Diagnostics")){
            tipo = "Testing and Diagnostics";

        } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Code of Conduct")){
            tipo = "Code of Conduct";

        } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Sectoral Operations")){
            tipo = "Sectoral Operations";

        } else {
            System.out.println("Invalid type. Please try again.");
            return;
        }
        System.out.println("|------------------------------------------------------------------|");
        System.out.print("| Enter the guideline you want to register:");
        System.out.println("|------------------------------------------------------------------|");
        String Orientacao = input.nextLine();
        System.out.println("+==================================================================+");

        // Code to insert into database

        String sql =  "INSERT INTO orientEn (titulo, tipo, orient) VALUES (?,?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        stmt.setString(2, tipo);
        stmt.setString(3, Orientacao);
        stmt.executeUpdate();

        System.out.println("Guideline in Pt-BR registered successfully!");

    } catch (SQLException e) {
        System.out.println("Error while registering guideline: " + e.getMessage());
    } 
    input.close();
}


    //METODOS DE BUSCA/ VIEWS///========================================================================================
public static void ListarTodaTabelaEN() {
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
            System.out.println("Guideline: " + rs.getString("orient"));

        }
    } catch (SQLException e) {
        System.out.println("Error fetching guidelines: " + e.getMessage());
    }
}

public static void ListarTudoPorTipoEN(){

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()){
        System.out.println("+==================================================================+");
        System.out.println("|                          Types of Guidelines                     |");
        System.out.println("|------------------------------------------------------------------|");	   
        System.out.println("|   1 Operation Manual     2 Safety Procedure                      |");
        System.out.println("|   3 Maintenance & Repair 4 Testing and Diagnostics               |");
        System.out.println("|   5 Code of Conduct      6 Sectoral Operations                   |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.print("| Choose the type of guideline you want to filter: ");
        String tipo = input.nextLine();

        if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Operation Manual")){
            tipo = "Operation Manual";
        } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Safety Procedure")){
            tipo = "Safety Procedure";
        } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance and Repair")){
            tipo = "Maintenance and Repair";
        } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Testing and Diagnostics")){
            tipo = "Testing and Diagnostics";
        } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Code of Conduct")){
            tipo = "Code of Conduct";
        } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Sectoral Operations")){
            tipo = "Sectoral Operations";
        } else {
            System.out.println("Invalid type. Please try again.");
            return;
        }

        String sql = "SELECT * FROM orientEn WHERE tipo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tipo);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            System.out.println("===================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("...................................................");
            System.out.println("Title: " + rs.getString("titulo"));
            System.out.println("...................................................");
            System.out.println("Type: " + rs.getString("tipo"));
            System.out.println("...................................................");
            System.out.println("Guideline: " + rs.getString("orient"));
            System.out.println("===================================================");
        }


    }catch (SQLException e) {
        System.out.println("Error fetching guidelines: " + e.getMessage());
    }

    input.close();
}

    //BUSCAS ESPECIFICAS///========================================================================================

public static void BuscaPorIDEN(){
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Enter the ID of the guideline you want to search:");
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
            System.out.println("Guideline: " + rs.getString("orient"));
            System.out.println("===================================================");
        } else {
            System.out.println("No guideline found with ID: " + id);
        }
    } catch (SQLException e) {
        System.out.println("Error searching guideline: " + e.getMessage());
    }
    input.close();
}

public static void BuscaPorTituloEN(){
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Enter the title of the guideline you want to search:");
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
                System.out.println("Guideline: " + rs.getString("orient"));
                System.out.println("===================================================");
            } while (rs.next());
        } else {
            System.out.println("No guideline found with the title: " + titulo);
        }
    } catch (SQLException e) {
        System.out.println("Error searching guideline: " + e.getMessage());
    }
    input.close();
}


    //FIM DOS METODOS DE BUSCA/ VIEWS///========================================================================================

    //METODO DE EXCLUSÃO///========================================================================================

   public static void ExcluirPorIDEN() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Enter the ID of the guideline you want to delete:");
        System.out.println("---------------------------------------------------");
        int id = input.nextInt();
        System.out.println("===================================================");
        System.out.println("Are you sure you want to delete the guideline with ID: " + id + "? (y/n)");
        String escolha = input.next();

        if(escolha.equalsIgnoreCase("n") || escolha.equalsIgnoreCase("no")){
            System.out.println("Deletion canceled.");
            return;
        } 
            
        String sql = "DELETE FROM orientEn WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Guideline successfully deleted!");
        } else {
            System.out.println("ID: " + id + " was not found for deletion");
        }
    } catch (SQLException e) {
        System.out.println("Error deleting guideline: " + e.getMessage());
    }
    input.close();
}


  public static void ExcluirPorTituloEN() {
    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        System.out.println("===================================================");
        System.out.println("Enter the title of the guideline you want to delete:");
        System.out.println("---------------------------------------------------");
        String titulo = input.nextLine();
        System.out.println("===================================================");
        System.out.println("Are you sure you want to delete the guideline with the title: " + titulo + "? (y/n)");
        String escolha = input.next();

        if(escolha.equalsIgnoreCase("n") || escolha.equalsIgnoreCase("no")){
            System.out.println("Deletion canceled.");
            return;
        }

        String sql = "DELETE FROM orientEn WHERE titulo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Guideline successfully deleted!");
        } else {
            System.out.println("No guideline found with the title: " + titulo);
        }
    } catch (SQLException e) {
        System.out.println("Error deleting guideline: " + e.getMessage());
    }
    input.close();
}


    //FIM DOS METODOS DE EXCLUSÃO///========================================================================================

    //METODOS DE ATUALIZAÇÃO///========================================================================================

public static void AtualizarTodaAOrientacaoEN(){

    Scanner input = new Scanner (System.in);

    try(Connection conn = ConexaoBD.getConexao()){
        System.out.println("===================================================");
        System.out.println("Do you want to search the guideline by ID or Title? (Type 'ID' or 'Title')");
        System.out.println("---------------------------------------------------");
        String escolha = input.nextLine();

        if(escolha.equalsIgnoreCase("ID")){
            System.out.println("===================================================");
            System.out.println("Enter the ID of the guideline you want to update:");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Clear scanner buffer
            System.out.println("Enter the new title of the guideline:");
            System.out.println("----------------------------------------------------");
            String novoTitulo = input.nextLine();

            System.out.println("===================================================");
            System.out.println("                 Types of Guidelines                ");
            System.out.println("===================================================");
            System.out.println("1.Operation Manual    2.Safety Procedure");
            System.out.println("3.Maintenance and Repairs  4.Tests and Diagnostics");
            System.out.println("5.Code of Conduct     6.Sectoral Operations");
            System.out.println("===================================================");
            System.out.println("Choose the new type of guideline:");
            System.out.println("---------------------------------------------------");
            String tipo = input.nextLine();

            if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Operation Manual")){
                tipo = "Operation Manual";
            } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Safety Procedure")){
                tipo = "Safety Procedure";
            } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance and Repairs")){
                tipo = "Maintenance and Repairs";
            } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Tests and Diagnostics")){
                tipo = "Tests and Diagnostics";
            } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Code of Conduct")){
                tipo = "Code of Conduct";
            } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Sectoral Operations")){
                tipo = "Sectoral Operations";
            } else {
                System.out.println("Invalid type. Please try again.");
                return;
            }
            System.out.println("===================================================");
            System.out.println("Enter the new guideline:");
            System.out.println("---------------------------------------------------");
            String novaOrientacao = input.nextLine();
            // Code to update database

            String sql = "UPDATE orientEn SET titulo = ?, tipo = ?, orient = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, novoTitulo);
            stmt.setString(2, tipo);
            stmt.setString(3, novaOrientacao);
            stmt.setInt(4, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Guideline updated successfully!");
            } else {
                System.out.println("No guideline found with ID: " + id);
            }

        } else if(escolha.equalsIgnoreCase("Título") || escolha.equalsIgnoreCase("Title")){
            System.out.println("===================================================");
            System.out.println("Enter the title of the guideline you want to update:");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();

            System.out.println("Enter the new title of the guideline:");
            System.out.println("----------------------------------------------------");
            String novoTitulo = input.nextLine();

            System.out.println("===================================================");
            System.out.println("                 Types of Guidelines                ");
            System.out.println("===================================================");
            System.out.println("1.Operation Manual    2.Safety Procedure");
            System.out.println("3.Maintenance and Repairs  4.Tests and Diagnostics");
            System.out.println("5.Code of Conduct     6.Sectoral Operations");
            System.out.println("===================================================");
            System.out.println("Choose the new type of guideline:");
            System.out.println("---------------------------------------------------");
            String tipo = input.nextLine();

            if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Operation Manual")){
                tipo = "Operation Manual";
            } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Safety Procedure")){
                tipo = "Safety Procedure";
            } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Maintenance and Repairs")){
                tipo = "Maintenance and Repairs";
            } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Tests and Diagnostics")){
                tipo = "Tests and Diagnostics";
            } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Code of Conduct")){
                tipo = "Code of Conduct";
            } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Sectoral Operations")){
                tipo = "Sectoral Operations";
            } else {
                System.out.println("Invalid type. Please try again.");
                return;
            }
            System.out.println("===================================================");
            System.out.println("Enter the new guideline:");
            System.out.println("---------------------------------------------------");
            String novaOrientacao = input.nextLine();
            // Code to update database

            String sql = "UPDATE orientEn SET titulo = ?, tipo = ?, orient = ? WHERE titulo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, novoTitulo);
            stmt.setString(2, tipo);
            stmt.setString(3, novaOrientacao);
            stmt.setString(4, titulo);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Guideline updated successfully!");
            } else {
                System.out.println("No guideline found with the title: " + titulo);
            }

        } else {
            System.out.println("Invalid option. Please try again.");
        }

    }catch (Exception e) {
        System.out.println("Error updating guideline: " + e.getMessage());
    }
    input.close();
}


public static void AtualizarTituloOrientacaoEN(){
    Scanner input =  new Scanner(System.in);

    try {

        System.out.println("===================================================");
        System.out.println("Do you want to search the guideline by ID or Title? (Type 'ID' or 'Title')");
        System.out.println("---------------------------------------------------");
        String escolha = input.nextLine();

        if(escolha.equalsIgnoreCase("Id")){
            System.out.println("===================================================");
            System.out.println("Enter the ID of the guideline you want to update:");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Clear scanner buffer
            System.out.println("Enter the new title of the guideline:");
            System.out.println("----------------------------------------------------");        
            String novoTitulo = input.nextLine();

            String sql = "UPDATE orientEn SET titulo = ? WHERE id = ?";
            try (Connection conn = ConexaoBD.getConexao();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, novoTitulo);
                stmt.setInt(2, id);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Title updated successfully!");
                } else {
                    System.out.println("No guideline found with ID: " + id);
                }
            }

        } else if(escolha.equalsIgnoreCase("titulo") || escolha.equalsIgnoreCase("title")){

            System.out.println("===================================================");
            System.out.println("Enter the title of the guideline you want to update:");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();
            System.out.println("===================================================");
            System.out.println("Enter the new title of the guideline:");
            String novoTitulo = input.nextLine();
            System.out.println("----------------------------------------------------"); 

            String sql = "UPDATE orientEn SET titulo = ? WHERE titulo = ?";
            try (Connection conn = ConexaoBD.getConexao();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, novoTitulo);
                stmt.setString(2, titulo);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Title updated successfully!");
                } else {
                    System.out.println("No guideline found with the title: " + titulo);
                }
            }

        } else {
            System.out.println("Invalid option. Please try again.");
            return;
        }

    } catch (Exception e) {
        System.out.println("Error updating guideline title: " + e.getMessage()); 
    }

    input.close();

}



public static void AtualizarTipoOrientacaoEN() {

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {

        System.out.println("===================================================");
        System.out.println("Do you want to search the orientation by ID or Title? (Type 'ID' or 'Title')");
        System.out.println("---------------------------------------------------");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("Id")) {

            System.out.println("===================================================");
            System.out.println("Enter the ID of the orientation you want to update:");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Clear the scanner buffer

            System.out.println("===================================================");
            System.out.println("                Types of Orientations              ");
            System.out.println("===================================================");
            System.out.println("1.Operation Manual     2.Safety Procedure          ");
            System.out.println("3.Maintenance and Repairs  4.Tests and Diagnostics  ");
            System.out.println("5.Code of Conduct      6.Sector Operations          ");
            System.out.println("===================================================");
            System.out.println("Choose the new Orientation Type:");
            System.out.println("---------------------------------------------------");
            String type = input.nextLine();

            if (type.equalsIgnoreCase("1") || type.equalsIgnoreCase("Operation Manual")) {
                type = "Operation Manual";
            } else if (type.equalsIgnoreCase("2") || type.equalsIgnoreCase("Safety Procedure")) {
                type = "Safety Procedure";
            } else if (type.equalsIgnoreCase("3") || type.equalsIgnoreCase("Maintenance and Repairs")) {
                type = "Maintenance and Repairs";
            } else if (type.equalsIgnoreCase("4") || type.equalsIgnoreCase("Tests and Diagnostics")) {
                type = "Tests and Diagnostics";
            } else if (type.equalsIgnoreCase("5") || type.equalsIgnoreCase("Code of Conduct")) {
                type = "Code of Conduct";
            } else if (type.equalsIgnoreCase("6") || type.equalsIgnoreCase("Sector Operations")) {
                type = "Sector Operations";
            } else {
                System.out.println("Invalid type. Please try again.");
                return;
            }

            String sql = "UPDATE orientEn SET tipo = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, type);
            stmt.setInt(2, id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Type updated successfully!");
            } else {
                System.out.println("No orientation found with ID: " + id);
            }

        } else if (choice.equalsIgnoreCase("Title")) {

            System.out.println("===================================================");
            System.out.println("Enter the title of the orientation you want to update:");
            System.out.println("---------------------------------------------------");
            String title = input.nextLine();
            System.out.println("===================================================");
            System.out.println("                Types of Orientations              ");
            System.out.println("===================================================");
            System.out.println("1.Operation Manual     2.Safety Procedure          ");
            System.out.println("3.Maintenance and Repairs  4.Tests and Diagnostics  ");
            System.out.println("5.Code of Conduct      6.Sector Operations          ");
            System.out.println("===================================================");
            System.out.println("Choose the new Orientation Type:");
            System.out.println("---------------------------------------------------");
            String type = input.nextLine();

            if (type.equalsIgnoreCase("1") || type.equalsIgnoreCase("Operation Manual")) {
                type = "Operation Manual";
            } else if (type.equalsIgnoreCase("2") || type.equalsIgnoreCase("Safety Procedure")) {
                type = "Safety Procedure";
            } else if (type.equalsIgnoreCase("3") || type.equalsIgnoreCase("Maintenance and Repairs")) {
                type = "Maintenance and Repairs";
            } else if (type.equalsIgnoreCase("4") || type.equalsIgnoreCase("Tests and Diagnostics")) {
                type = "Tests and Diagnostics";
            } else if (type.equalsIgnoreCase("5") || type.equalsIgnoreCase("Code of Conduct")) {
                type = "Code of Conduct";
            } else if (type.equalsIgnoreCase("6") || type.equalsIgnoreCase("Sector Operations")) {
                type = "Sector Operations";
            } else {
                System.out.println("Invalid type. Please try again.");
                return;
            }

            String sql = "UPDATE orientEn SET tipo = ? WHERE titulo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, type);
            stmt.setString(2, title);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Type updated successfully!");
            } else {
                System.out.println("No orientation found with the title: " + title);
            }

        } else {
            System.out.println("Invalid option. Please try again.");
            return;
        }

    } catch (Exception e) {
        System.out.println("Error updating orientation type: " + e.getMessage());
    }
    input.close();
}




public static void AtualizarOrientacaoEN() {

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {

        System.out.println("===================================================");
        System.out.println("Do you want to search the orientation by ID or Title? (Type 'ID' or 'Title')");
        System.out.println("---------------------------------------------------");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("Id")) {

            System.out.println("===================================================");
            System.out.println("Enter the ID of the orientation you want to update:");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Clear the scanner buffer
            System.out.println("Enter the new orientation:");
            System.out.println("----------------------------------------------------");
            String newOrientation = input.nextLine();

            String sql = "UPDATE orientEn SET orient = ? WHERE id = ?";
            PreparedStatement stmt = ConexaoBD.getConexao().prepareStatement(sql);
            stmt.setString(1, newOrientation);
            stmt.setInt(2, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Orientation updated successfully!");
            } else {
                System.out.println("No orientation found with ID: " + id);
            }

        } else if (choice.equalsIgnoreCase("Title")) {

            System.out.println("===================================================");
            System.out.println("Enter the title of the orientation you want to update:");
            System.out.println("---------------------------------------------------");
            String title = input.nextLine();
            System.out.println("===================================================");
            System.out.println("Enter the new orientation:");
            System.out.println("----------------------------------------------------");
            String newOrientation = input.nextLine();

            String sql = "UPDATE orientEn SET orient = ? WHERE titulo = ?";
            PreparedStatement stmt = ConexaoBD.getConexao().prepareStatement(sql);
            stmt.setString(1, newOrientation);
            stmt.setString(2, title);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Orientation updated successfully!");
            } else {
                System.out.println("No orientation found with the title: " + title);
            }

        } else {
            System.out.println("Invalid option. Please try again.");
            return;
        }
    } catch (Exception e) {
        System.out.println("Error updating orientation: " + e.getMessage());
    }

    input.close();
}


}