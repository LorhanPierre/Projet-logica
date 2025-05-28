package DAO;

import java.sql.*;
import java.util.*;
import ConexaoBD.ConexaoBD;

public class orientacaoPT {

    //METEDO DE CADASTRO DE ORIENTAÇÕES EM PORTUGUÊS///=========================================================================================
    public static void cadastroPt(){

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()){

        System.out.println("===================================================");
        System.out.println("Digite o titulo da orientação que deseja cadastrar:");
        System.out.println("---------------------------------------------------");
        String titulo = input.nextLine();
        System.out.println("===================================================");
        System.out.println("                Tipos de Orientações               ");
        System.out.println("===================================================");
        System.out.println("1.Manual de Operação    2.Procedimento de Segurança");
        System.out.println("3.Manutenção e Reparos  4.Testes e Diagnóstico     ");
        System.out.println("5.Manual de Conduta     6.Operações Setoriais      ");
        System.out.println("---------------------------------------------------");  
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
        System.out.println("---------------------------------------------------");
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

    //METODOS DE BUSCA/ VIEWS///========================================================================================

    public static void ListarTodaTabela() {
        try (Connection conn = ConexaoBD.getConexao()) {
            String sql = "SELECT * FROM orientPt";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

            System.out.println("===================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("...................................................");
            System.out.println("Título: " + rs.getString("titulo"));
            System.out.println("...................................................");
            System.out.println("Tipo: " + rs.getString("tipo"));
            System.out.println("...................................................");
            System.out.println("Orientação: " + rs.getString("orient"));
            
        }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar orientações: " + e.getMessage());
        }
    }

    public static void ListarTudoPorTipo(){

        Scanner input = new Scanner(System.in);

        try (Connection conn = ConexaoBD.getConexao()){
        System.out.println("===================================================");
        System.out.println("                Tipos de Orientações               ");
        System.out.println("===================================================");
        System.out.println("1.Manual de Operação    2.Procedimento de Segurança");
        System.out.println("3.Manutenção e Reparos  4.Testes e Diagnóstico     ");
        System.out.println("5.Manual de Conduta     6.Operações Setoriais      ");
        System.out.println("===================================================");  
        System.out.println("Escolha o Tipo de Orientação que Deseja Filtrar:");
        System.out.println("---------------------------------------------------");
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

        String sql = "SELECT * FROM orientPt WHERE tipo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tipo);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            System.out.println("===================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("...................................................");
            System.out.println("Título: " + rs.getString("titulo"));
            System.out.println("...................................................");
            System.out.println("Tipo: " + rs.getString("tipo"));
            System.out.println("...................................................");
            System.out.println("Orientação: " + rs.getString("orient"));
            System.out.println("===================================================");
        }


    }catch (SQLException e) {
        System.out.println("Erro ao buscar orientações: " + e.getMessage());
    }

    input.close();
    }

    //BUSCAS ESPECIFICAS///========================================================================================

    public static void BuscaPorID(){
        Scanner input = new Scanner(System.in);

        try (Connection conn = ConexaoBD.getConexao()) {
            System.out.println("===================================================");
            System.out.println("Digite o ID da orientação que deseja buscar:");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            String sql = "SELECT * FROM orientPt WHERE id = ?";
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
                System.out.println("Orientação: " + rs.getString("orient"));
                System.out.println("===================================================");
            } else {
                System.out.println("Nenhuma orientação encontrada com o ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar orientação: " + e.getMessage());
        }
        input.close();
    }

    public static void BuscaPorTitulo(){
        Scanner input = new Scanner(System.in);

        try (Connection conn = ConexaoBD.getConexao()) {
            System.out.println("===================================================");
            System.out.println("Digite o título da orientação que deseja buscar:");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();
            String sql = "SELECT * FROM orientPt WHERE titulo = ?";
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
                    System.out.println("Orientação: " + rs.getString("orient"));
                    System.out.println("===================================================");
                } while (rs.next());
            } else {
                System.out.println("Nenhuma orientação encontrada com o título: " + titulo);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar orientação: " + e.getMessage());
        }
        input.close();
    }
}

