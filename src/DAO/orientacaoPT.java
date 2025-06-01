package DAO;

import ConexaoBD.ConexaoBD;
import java.sql.*;
import java.util.*;

public class orientacaoPT {

    //METEDO DE CADASTRO DE ORIENTAÇÕES EM PORTUGUÊS///=========================================================================================
    public void cadastroPt(){

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()){

        boolean entradaValida = true;
        String titulo;
        String tipo;
        String Orientacao;

        String tipoEn="", tipoFr="", tipoEs="", tipoDe="";
        String tituloEn, tituloFr, tituloEs, tituloDe;
        String orientEn, orientFr, orientEs, orientDe;



        do {

            entradaValida = true;
        
        System.out.println("!Alerta! Você terá que cadastrar a orientação em português, inglês,\nfrancês, espanhol e alemão.");
        System.out.println("=====================================================================");
        System.out.println("Digite o titulo da orientação que deseja cadastrar:");
	    System.out.println("--------------------------------------------------------------------");
        titulo = input.nextLine();
        System.out.println("+==================================================================+");
        System.out.println("Digite o titulo da orientação em ingles:");
        System.out.println("--------------------------------------------------------------------");
        tituloEn = input.nextLine();
        System.out.println("+==================================================================+");
        System.out.println("Digite o titulo da orientação em francês:");
        System.out.println("--------------------------------------------------------------------");
        tituloFr = input.nextLine();
        System.out.println("+==================================================================+");
        System.out.println("Digite o titulo da orientação em espanhol:");
        System.out.println("--------------------------------------------------------------------");
        tituloEs = input.nextLine();
        System.out.println("+==================================================================+");
        System.out.println("Digite o titulo da orientação em alemão:");
        System.out.println("--------------------------------------------------------------------");
        tituloDe = input.nextLine();
        System.out.println("+==================================================================+");

            if(titulo.isEmpty()){
                System.out.println("Este campo precisa ser preenchido");
                entradaValida = false;
            }

        }while (entradaValida == false);

        do{

            entradaValida = true;

        System.out.println("+==================================================================+");
        System.out.println("|                      Tipos de Orientações                        |");
	    System.out.println("|------------------------------------------------------------------|");
        System.out.println("|         1 Manual de Operação    2 Procedimento de Segurança      |");
        System.out.println("|         3 Manutenção e Reparos  4 Testes e Diagnóstico           |");
        System.out.println("|         5 Manual de Conduta     6 Operações Setoriais            |");
        System.out.println("+==================================================================+");
        System.out.print("| o tipo de orientação que deseja cadastrar:");
        tipo = input.nextLine();
        

        if(tipo.equalsIgnoreCase("1") || tipo.equalsIgnoreCase("Manual de Operação")){
            tipo = "Manual de Operação";
            tipoEn = "Operation Manual";  
            tipoFr = "Manuel d'opération";
            tipoEs = "Manual de Operaciones";
            tipoDe = "Betriebsanleitung";
   
        } else if(tipo.equalsIgnoreCase("2") || tipo.equalsIgnoreCase("Procedimento de Segurança")){
            tipo = "Procedimento de Segurança";
            tipoEn = "Safety Procedure";
            tipoFr = "Procédure de sécurité";
            tipoEs = "Procedimiento de Seguridad";
            tipoDe = "Sicherheitsverfahren";
            
        } else if(tipo.equalsIgnoreCase("3") || tipo.equalsIgnoreCase("Manutenção e Reparos")){
            tipo = "Manutenção e Reparos";
            tipoEn = "Maintenance and Repairs";
            tipoFr = "Maintenance et Réparation";
            tipoEs = "Mantenimiento y Reparación";
            tipoDe = "Wartung und Reparatur";
            
        } else if(tipo.equalsIgnoreCase("4") || tipo.equalsIgnoreCase("Testes e Diagnóstico")){
            tipo = "Testes e Diagnóstico";
            tipoEn = "Testing and Diagnosis";
            tipoFr = "Tests et diagnostics";
            tipoEs = "Pruebas y Diagnósticos";
            tipoDe = "Tests und Diagnosen";
            
        } else if(tipo.equalsIgnoreCase("5") || tipo.equalsIgnoreCase("Manual de Conduta")){
            tipo = "Manual de Conduta";
            tipoEn = "Code of Conduct";
            tipoFr = "Code de conduite";
            tipoEs = "Código de Conducta";
            tipoDe = "Verhaltenskodex";
            
        } else if(tipo.equalsIgnoreCase("6") || tipo.equalsIgnoreCase("Operações Setoriais")){
            tipo = "Operações Setoriais";
            tipoEn = "Sector Operations";
            tipoFr = "Opérations sectorielles";
            tipoEs = "Operaciones Sectoriales";
            tipoDe = "Sektoroperationen";
            
        } else {
            System.out.println("Tipo inválido. Por favor, tente novamente.");
            entradaValida = false;
            
        }

        }while (entradaValida == false);

        do {
   
            //entradaValida = true;
        System.out.println("+==================================================================+");
        System.out.println("| Digite a orientação que deseja cadastrar(Português):");
	    System.out.println("|------------------------------------------------------------------|");
        Orientacao = input.nextLine();
        System.out.println("+==================================================================+");
        System.out.println("| Digite a orientação que deseja cadastrar(Inglês):");
        System.out.println("|------------------------------------------------------------------|");
        orientEn = input.nextLine();
        System.out.println("+==================================================================+");
        System.out.println("| Digite a orientação que deseja cadastrar(Francês):");
	    System.out.println("|------------------------------------------------------------------|");
        orientFr = input.nextLine();
        System.out.println("+==================================================================+");
        System.out.println("| Digite a orientação que deseja cadastrar(Espanhol):");
        System.out.println("|------------------------------------------------------------------|");
        orientEs = input.nextLine();
        System.out.println("+==================================================================+");
        System.out.println("| Digite a orientação que deseja cadastrar(Alemão):");
        System.out.println("|------------------------------------------------------------------|");
        orientDe = input.nextLine();
        System.out.println("+==================================================================+");

            if (Orientacao.isEmpty()){
                System.out.println("Este campo precisa ser preenchido");
                entradaValida = false;
            } else {
                entradaValida = true;
            }
        
        }while (entradaValida == false);

        //Codigo para inserir no banco de dados

        String sql =  "INSERT INTO orientPt (titulo, tipo, orient) VALUES (?,?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, titulo);
        stmt.setString(2, tipo);
        stmt.setString(3, Orientacao);
        stmt.executeUpdate();

        String sqlEn=  "INSERT INTO orientEn (titulo, tipo, orient) VALUES (?,?, ?)";
        PreparedStatement stmtEn = conn.prepareStatement(sqlEn);
        stmtEn.setString(1, tituloEn);
        stmtEn.setString(2, tipoEn);
        stmtEn.setString(3, orientEn);
        stmtEn.executeUpdate();

        String sqlEs=  "INSERT INTO orientEs (titulo, tipo, orient) VALUES (?,?, ?)";
        PreparedStatement stmtEs = conn.prepareStatement(sqlEs);
        stmtEs.setString(1, tituloEs);
        stmtEs.setString(2, tipoEs);
        stmtEs.setString(3, orientEs);
        stmtEs.executeUpdate();

        String sqlFr=  "INSERT INTO orientFr (titulo, tipo, orient) VALUES (?,?, ?)";
        PreparedStatement stmtFr = conn.prepareStatement(sqlFr);
        stmtFr.setString(1, tituloFr);
        stmtFr.setString(2, tipoFr);
        stmtFr.setString(3, orientFr);
        stmtFr.executeUpdate();

        String sqlDe =  "INSERT INTO orientDe (titulo, tipo, orient) VALUES (?,?, ?)";
        PreparedStatement stmtDe = conn.prepareStatement(sqlDe);
        stmtDe.setString(1, tituloDe);
        stmtDe.setString(2, tipoDe);
        stmtDe.setString(3, orientDe);
        stmtDe.executeUpdate();

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

    	    System.out.println("==================================================================");
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("..................................................................");
            System.out.println("Título: " + rs.getString("titulo"));
            System.out.println("..................................................................");
            System.out.println("Tipo: " + rs.getString("tipo"));
            System.out.println("..................................................................");
            System.out.println("Orientação: " + rs.getString("orient"));
            
        }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar orientações: " + e.getMessage());
        }
    }

    public static void ListarTudoPorTipo(){

        Scanner input = new Scanner(System.in);

        try (Connection conn = ConexaoBD.getConexao()){
	    System.out.println("+==================================================================+");
        System.out.println("|                      Tipos de Orientações                        |");
	    System.out.println("|------------------------------------------------------------------|");	   
        System.out.println("|         1 Manual de Operação    2 Procedimento de Segurança      |");
        System.out.println("|         3 Manutenção e Reparos  4 Testes e Diagnóstico           |");
        System.out.println("|         5 Manual de Conduta     6 Operações Setoriais            |");
	    System.out.println("|------------------------------------------------------------------|");
        System.out.print("| Escolha o Tipo de Orientação que Deseja Filtrar: ");
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

    //FIM DOS METODOS DE BUSCA/ VIEWS///========================================================================================

    //METODO DE EXCLUSÃO///========================================================================================

    public void ExcluirPorID() {
        Scanner input = new Scanner(System.in);


        try (Connection conn = ConexaoBD.getConexao()) {
            System.out.println("Você está prestes a excluir uma orientação em todos os idiomas.");
            System.out.println("===================================================");
            System.out.println("Digite o ID da orientação que deseja excluir:");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            System.out.println("Tem certeza que deseja excluir a orientação com ID: " + id + "? (s/n)");
            String escolha = input.next();  

            if(escolha.equalsIgnoreCase("n") || escolha.equalsIgnoreCase("não")){
                System.out.println("Exclusão cancelada.");
                return;
            } 

            
                
            String sql = "DELETE FROM orientPt WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();

            String sqlEn = "DELETE FROM orientEn WHERE id = ?";
            PreparedStatement stmtEn = conn.prepareStatement(sqlEn);
            stmtEn.setInt(1, id);
            int rowsAffectedEn = stmtEn.executeUpdate();

            String sqlEs = "DELETE FROM orientEs WHERE id = ?";
            PreparedStatement stmtEs = conn.prepareStatement(sqlEs);
            stmtEs.setInt(1, id);
            int rowsAffectedEs = stmtEs.executeUpdate();

            String sqlFr= "DELETE FROM orientFr WHERE id = ?";
            PreparedStatement stmtFr = conn.prepareStatement(sqlFr);
            stmtFr.setInt(1, id);
            int rowsAffectedFr = stmtFr.executeUpdate();

            String sqlDe = "DELETE FROM orientDe WHERE id = ?";
            PreparedStatement stmtDe = conn.prepareStatement(sqlDe);
            stmtDe.setInt(1, id);
            int rowsAffectedDe = stmtDe.executeUpdate();

            
            if (rowsAffected > 0) {
                System.out.println("Orientação excluída com sucesso!");
            }else {
                System.out.println("O ID: " + id + "não foi encontrado para exclusão");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir orientação: " + e.getMessage());
        }

        input.close();
        
    }

    public void ExcluirPorTitulo() {
        Scanner input = new Scanner(System.in);

        try (Connection conn = ConexaoBD.getConexao()) {
            System.out.println("===================================================");
            System.out.println("Digite o título da orientação que deseja excluir:");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();
            System.out.println("===================================================");
            System.out.println("Tem certeza que deseja excluir a orientação com título: " + titulo + "? (s/n)");
            String escolha = input.next();  

            if(escolha.equalsIgnoreCase("n") || escolha.equalsIgnoreCase("não")){
                System.out.println("Exclusão cancelada.");
                return;
            } 

            String sql = "SELECT id FROM orientPt WHERE titulo = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");

            String sqlPt = "DELETE FROM orientPt WHERE id = ?";
            PreparedStatement stmtPt = conn.prepareStatement(sqlPt);
            stmtPt.setInt(1, id);
            int rowsAffected = stmtPt.executeUpdate();

            String sqlEn = "DELETE FROM orientEn WHERE id = ?";
            PreparedStatement stmtEn = conn.prepareStatement(sqlEn);
            stmtEn.setInt(1, id);
            int rowsAffectedEn = stmtEn.executeUpdate();

            String sqlEs = "DELETE FROM orientEs WHERE id = ?";
            PreparedStatement stmtEs = conn.prepareStatement(sqlEs);
            stmtEs.setInt(1, id);
            int rowsAffectedEs = stmtEs.executeUpdate();

            String sqlFr= "DELETE FROM orientFr WHERE id = ?";
            PreparedStatement stmtFr = conn.prepareStatement(sqlFr);
            stmtFr.setInt(1, id);
            int rowsAffectedFr = stmtFr.executeUpdate();

            String sqlDe = "DELETE FROM orientDe WHERE id = ?";
            PreparedStatement stmtDe = conn.prepareStatement(sqlDe);
            stmtDe.setInt(1, id);
            int rowsAffectedDe = stmtDe.executeUpdate();


            if (rowsAffected > 0) {
                System.out.println("Orientação excluída com sucesso!");
            } else {
                System.out.println("Nenhuma orientação encontrada com o título: " + titulo);
            }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir orientação: " + e.getMessage());
        }

        input.close();
        
    }

    //FIM DOS METODOS DE EXCLUSÃO///========================================================================================

    //METODOS DE ATUALIZAÇÃO///========================================================================================

     public static void AtualizarTodaAOrientacao(){
        
        Scanner input = new Scanner (System.in);

        try(Connection conn = ConexaoBD.getConexao()){
        System.out.println("===================================================");
        System.out.println("Deseja buscar a orientação por ID ou Título? (Digite 'ID' ou 'Título')");
        System.out.println("---------------------------------------------------");
        String escolha = input.nextLine();

        if(escolha.equalsIgnoreCase("ID")){
            System.out.println("===================================================");
            System.out.println("Digite o ID da orientação que deseja atualizar:");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Limpar o buffer do scanner
            System.out.println("Digite o novo título da orientação:");
            System.out.println("----------------------------------------------------");
            String novoTitulo = input.nextLine();

        System.out.println("===================================================");
        System.out.println("                Tipos de Orientações               ");
        System.out.println("===================================================");
        System.out.println("1.Manual de Operação    2.Procedimento de Segurança");
        System.out.println("3.Manutenção e Reparos  4.Testes e Diagnóstico     ");
        System.out.println("5.Manual de Conduta     6.Operações Setoriais      ");
        System.out.println("===================================================");  
        System.out.println("Escolha o novo Tipo de Orientação:");
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
        System.out.println("===================================================");
        System.out.println("Digite a nova orientação:");
        System.out.println("---------------------------------------------------");
        String novaOrientacao = input.nextLine();
        // Código para atualizar no banco de dados

        String sql = "UPDATE orientPt SET titulo = ?, tipo = ?, orient = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, novoTitulo);
        stmt.setString(2, tipo);
        stmt.setString(3, novaOrientacao);
        stmt.setInt(4, id);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Orientação atualizada com sucesso!");
        } else {
            System.out.println("Nenhuma orientação encontrada com o ID: " + id);
        }




        } else if(escolha.equalsIgnoreCase("Título")){
            System.out.println("===================================================");
            System.out.println("Digite o título da orientação que deseja atualizar:");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();

            System.out.println("Digite o novo título da orientação:");
            System.out.println("----------------------------------------------------");
            String novoTitulo = input.nextLine();

        System.out.println("===================================================");
        System.out.println("                Tipos de Orientações               ");
        System.out.println("===================================================");
        System.out.println("1.Manual de Operação    2.Procedimento de Segurança");
        System.out.println("3.Manutenção e Reparos  4.Testes e Diagnóstico     ");
        System.out.println("5.Manual de Conduta     6.Operações Setoriais      ");
        System.out.println("===================================================");  
        System.out.println("Escolha o novo Tipo de Orientação:");
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
        System.out.println("===================================================");
        System.out.println("Digite a nova orientação:");
        System.out.println("---------------------------------------------------");
        String novaOrientacao = input.nextLine();
        // Código para atualizar no banco de dados

        String sql = "UPDATE orientPt SET titulo = ?, tipo = ?, orient = ? WHERE titulo = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, novoTitulo);
        stmt.setString(2, tipo);
        stmt.setString(3, novaOrientacao);
        stmt.setString(4, titulo);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Orientação atualizada com sucesso!");
        } else {
            System.out.println("Nenhuma orientação encontrada com o titulo: " + titulo);
        }


        } else {
            System.out.println("Opção inválida. Por favor, tente novamente.");
        }

        }catch (Exception e) {
        System.out.println("Erro ao atualizar orientação: " + e.getMessage());
     }

     input.close();
     
}

public static void AtualizarTituloOrientacao(){
    Scanner input =  new Scanner(System.in);

    try {

        System.out.println("===================================================");
        System.out.println("Deseja buscar a orientação por ID ou Título? (Digite 'ID' ou 'Título')");
        System.out.println("---------------------------------------------------");
        String escolha = input.nextLine();

        if(escolha.equalsIgnoreCase("Id")){
            System.out.println("===================================================");
            System.out.println("Digite o ID da orientação que deseja atualizar:");
            System.out.println("---------------------------------------------------");
            int id = input.nextInt();
            System.out.println("===================================================");
            input.nextLine(); // Limpar o buffer do scanner
            System.out.println("Digite o novo título da orientação:");
            System.out.println("----------------------------------------------------");        
            String novoTitulo = input.nextLine();

            String sql = "UPDATE orientPt SET titulo = ? WHERE id = ?";
            try (Connection conn = ConexaoBD.getConexao();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, novoTitulo);
                stmt.setInt(2, id);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Título atualizado com sucesso!");
                } else {
                    System.out.println("Nenhuma orientação encontrada com o ID: " + id);
                }
            }

        }else if(escolha.equalsIgnoreCase("titulo")){

            System.out.println("===================================================");
            System.out.println("Digite o título da orientação que deseja atualizar:");
            System.out.println("---------------------------------------------------");
            String titulo = input.nextLine();
            System.out.println("===================================================");
            System.out.println("Digite o novo título da orientação:");
            String novoTitulo = input.nextLine();
            System.out.println("----------------------------------------------------"); 

            String sql = "UPDATE orientPt SET titulo = ? WHERE titulo = ?";
            try (Connection conn = ConexaoBD.getConexao();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, novoTitulo);
                stmt.setString(2, titulo);
                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Título atualizado com sucesso!");
                } else {
                    System.out.println("Nenhuma orientação encontrada com o título: " + titulo);
                }
            }

        } else {
            System.out.println("Opção inválida. Por favor, tente novamente.");

        }
        
    } catch (Exception e) {
        System.out.println("Erro ao atualizar título da orientação: " + e.getMessage()); 
    }

    input.close();
}


public static void AtualizarTipoOrientacao(){

    Scanner input = new Scanner (System.in);

    try(Connection conn = ConexaoBD.getConexao()){

    System.out.println("===================================================");
    System.out.println("Deseja buscar a orientação por ID ou Título? (Digite 'ID' ou 'Título')");
    System.out.println("---------------------------------------------------");
    String escolha = input.nextLine();
    
    if(escolha.equalsIgnoreCase("Id")){

    System.out.println("===================================================");
    System.out.println("Digite o ID da orientação que deseja atualizar:");
    System.out.println("---------------------------------------------------");
    int id = input.nextInt();
    System.out.println("===================================================");
    input.nextLine(); // Limpar o buffer do scanner

    System.out.println("===================================================");
    System.out.println("                Tipos de Orientações               ");
    System.out.println("===================================================");
    System.out.println("1.Manual de Operação    2.Procedimento de Segurança");
    System.out.println("3.Manutenção e Reparos  4.Testes e Diagnóstico     ");
    System.out.println("5.Manual de Conduta     6.Operações Setoriais      ");
    System.out.println("===================================================");  
    System.out.println("Escolha o novo Tipo de Orientação:");
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

    String sql = "UPDATE orientPt SET tipo = ? WHERE id = ?";	
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, tipo);
    stmt.setInt(2, id);
    int rowsAffected = stmt.executeUpdate();
    if (rowsAffected > 0) {
        System.out.println("Tipo atualizado com sucesso!");
    } else {
        System.out.println("Nenhuma orientação encontrada com o ID: " + id);
    }

    }else if(escolha.equalsIgnoreCase("Titulo")){

    System.out.println("===================================================");
    System.out.println("Digite o título da orientação que deseja atualizar:");
    System.out.println("---------------------------------------------------");
    String titulo = input.nextLine();
    System.out.println("===================================================");
    System.out.println("                Tipos de Orientações               ");
    System.out.println("===================================================");
    System.out.println("1.Manual de Operação    2.Procedimento de Segurança");
    System.out.println("3.Manutenção e Reparos  4.Testes e Diagnóstico     ");
    System.out.println("5.Manual de Conduta     6.Operações Setoriais      ");
    System.out.println("===================================================");
    System.out.println("Escolha o novo Tipo de Orientação:");
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
            
    String sql = "UPDATE orientPt SET tipo = ? WHERE titulo = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, tipo);
    stmt.setString(2, titulo);
    int rowsAffected = stmt.executeUpdate();

    if (rowsAffected > 0) {
        System.out.println("Tipo atualizado com sucesso!");
    } else {
        System.out.println("Nenhuma orientação encontrada com o título: " + titulo);
    }

    } else {
        System.out.println("Opção inválida. Por favor, tente novamente.");
        return;
    }

    } catch (Exception e) {
        System.out.println("Erro ao atualizar tipo da orientação: " + e.getMessage());
    }

    input.close();

}



public static void AtualizarOrientacao(){

    Scanner input = new Scanner(System.in);

    try (Connection conn = ConexaoBD.getConexao()) {
        
    System.out.println("===================================================");
    System.out.println("Deseja buscar a orientação por ID ou Título? (Digite 'ID' ou 'Título')");
    System.out.println("---------------------------------------------------");
    String escolha = input.nextLine();

    if(escolha.equalsIgnoreCase("Id")){

        System.out.println("===================================================");
        System.out.println("Digite o ID da orientação que deseja atualizar:");
        System.out.println("---------------------------------------------------");
        int id = input.nextInt();
        System.out.println("===================================================");
        input.nextLine(); // Limpar o buffer do scanner
        System.out.println("Digite a nova orientação:");
        System.out.println("----------------------------------------------------");
        String novaOrientacao = input.nextLine();

        String sql = "UPDATE orientPt SET orient = ? WHERE id = ?";
        PreparedStatement stmt = ConexaoBD.getConexao().prepareStatement(sql);
        stmt.setString(1, novaOrientacao);
        stmt.setInt(2, id);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Orientação atualizada com sucesso!");
        } else {
            System.out.println("Nenhuma orientação encontrada com o ID: " + id);
        }

    } else if(escolha.equalsIgnoreCase("Titulo")){

        System.out.println("===================================================");
        System.out.println("Digite o título da orientação que deseja atualizar:");
        System.out.println("---------------------------------------------------");
        String titulo = input.nextLine();
        System.out.println("===================================================");
        System.out.println("Digite a nova orientação:");
        System.out.println("----------------------------------------------------");
        String novaOrientacao = input.nextLine();

        String sql = "UPDATE orientPt SET orient = ? WHERE titulo = ?";
        PreparedStatement stmt = ConexaoBD.getConexao().prepareStatement(sql);
        stmt.setString(1, novaOrientacao);
        stmt.setString(2, titulo);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Orientação atualizada com sucesso!");
        } else {
            System.out.println("Erro ao procurar " + titulo + " no sistema");
        }

    } else {
            System.out.println("Opção inválida. Por favor, tente novamente.");
            return;
        }
    }catch (Exception e) {
        System.out.println("Erro ao atualizar orientação: " + e.getMessage());
    } 

    input.close();
    
}

}