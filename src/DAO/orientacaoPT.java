package DAO;

import java.sql.*;
import java.util.*;
import ConexaoBD.ConexaoBD;

public class orientacaoPT {


    public static void cadastroPt(){

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()){

        System.out.println("===================================================");
        System.out.println("Digite o titulo da orientação que deseja cadastrar:");
        System.out.println("===================================================");
        String titulo = input.nextLine();
        System.out.println("===================================================");
        System.out.println("                Tipos de Orientações               ");
        System.out.println("===================================================");
        System.out.println("1.Manual de Operação    2.Procedimento de Segurança");
        System.out.println("3.Manutenção e Reparos  4.Testes e Diagnóstico     ");
        System.out.println("5.Manual de Conduta     6.Operações Setoriais      ");
        System.out.println("===================================================");  
        System.out.println("o tipo de orientação que deseja cadastrar:");
        String tipo = input.nextLine();

        if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manual de Operação")){
            tipo = "Manual de Operação";
        } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procedimento de Segurança")){
            tipo = "Procedimento de Segurança";
        } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Manutenção e Reparos")){
            tipo = "Manutenção e Reparos";
        } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Testes e Diagnóstico")){
            tipo = "Testes e Diagnóstico";
        } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Manual de Conduta")){
            tipo = "Manual de Conduta";
        } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Operações Setoriais")){
            tipo = "Operações Setoriais";
        } else {
            System.out.println("Tipo inválido. Por favor, tente novamente.");
            return;
        }
        System.out.println("===================================================");
        System.out.println("Digite a orientação que deseja cadastrar:");
        String Orientacao = input.nextLine();
        System.out.println("===================================================");
        

        //Codigo para inserir no banco de dados

        String sql =  "INSERT INTO orientPt (titulo, tipo, orient) VALUES (?,?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        stmt.setString(2, tipo);
        stmt.setString(3, Orientacao);
        stmt.executeUpdate();

        System.out.println("Orientação em Pt-BR cadastrada com sucesso!");

    } catch (SQLException e) {
        System.out.println("Erro ao cadastrar orientação: " + e.getMessage());
    } 
    input.close();
    }

    public static void buscarOrientacoes() {
        try (Connection conn = ConexaoBD.getConexao()) {
            String sql = "SELECT * FROM orientPt";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String tipo = rs.getString("tipo");
                String orientacao = rs.getString("orient");
                System.out.println("Título: " + titulo + ", Tipo: " + tipo + ", Orientação: " + orientacao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar orientações: " + e.getMessage());
        }
    }

}
