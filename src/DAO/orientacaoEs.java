package DAO;

import java.sql.*;
import java.util.Scanner;

import ConexaoBD.ConexaoBD;

public class orientacaoEs {

    public static void cadastroES() {

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()){

        System.out.println("=====================================================================");
        System.out.println("Ingrese el título de la guía que desea registrar:");
        System.out.println("--------------------------------------------------------------------");
        String titulo = input.nextLine();
        System.out.println("+==================================================================+");
        System.out.println("|                          Tipos de Guías                         |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|   1 Manual de Operaciones  2 Procedimiento de Seguridad         |");
        System.out.println("|   3 Mantenimiento y Reparación 4 Pruebas y Diagnósticos         |");
        System.out.println("|   5 Código de Conducta      6 Operaciones Sectoriales            |");
        System.out.println("+==================================================================+");
        System.out.print("| Seleccione el tipo de guía que desea registrar:");
        String tipo = input.nextLine();

        if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manual de Operaciones")){
            tipo = "Manual de Operaciones";

        } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procedimiento de Seguridad")){
            tipo = "Procedimiento de Seguridad";

        } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Mantenimiento y Reparación")){
            tipo = "Mantenimiento y Reparación";

        } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Pruebas y Diagnósticos")){
            tipo = "Pruebas y Diagnósticos";

        } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Código de Conducta")){
            tipo = "Código de Conducta";

        } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Operaciones Sectoriales")){
            tipo = "Operaciones Sectoriales";

        } else {
            System.out.println("Tipo inválido. Por favor, inténtelo de nuevo.");
            return;
        }
        System.out.println("|------------------------------------------------------------------|");
        System.out.print("| Ingrese la guía que desea registrar:");
        System.out.println("|------------------------------------------------------------------|");
        String Orientacao = input.nextLine();
        System.out.println("+==================================================================+");

        String sql =  "INSERT INTO orientEs (titulo, tipo, orient) VALUES (?,?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        stmt.setString(2, tipo);
        stmt.setString(3, Orientacao);
        stmt.executeUpdate();

        System.out.println("¡Guía en ES registrada con éxito!");

    } catch (SQLException e) {
        System.out.println("Error al registrar la guía: " + e.getMessage());
    } 
    input.close();
}

public static void ListarTodaTabelaES() {
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
            System.out.println("Directriz: " + rs.getString("orient"));

        }
    } catch (SQLException e) {
        System.out.println("Error al obtener las directrices: " + e.getMessage());
    }
}



}
