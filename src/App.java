import ConexaoBD.ConexaoBD;
import java.sql.Connection;
import java.util.Scanner;
import DAO.*;
import services.*;


//criar pasta lib para importar o driver do jddc do mysql

public class App {
    public static void main(String[] args) throws Exception {

        Connection conexao = ConexaoBD.getConexao();

        if (conexao != null){
            System.out.println("banco de dados Conectado!");
        } else {
            System.out.println("Erro na conexão com o banco de dados");
        }
        
        //orientacaoEs test = new orientacaoEs();
        //test.ListarTodaTabelaES();
        orientacaoPT orientacaoPt = new orientacaoPT();
        orientacaoPt.ExcluirPorTitulo();
        
        System.out.println("====================================================================");
        System.out.println("||                      Welcome to WEG one                        ||");
        System.out.println("====================================================================");
        
        setLanguage();
        		
        	
        
    }

    	//MÉTODO PARA DEFINIR O IDIOMA///==================================================================================================
	public static void setLanguage () {
		
		boolean valido = true;
		Scanner input = new Scanner (System.in);
		
		do {
        System.out.println("+==================================================================+");
        System.out.println("|                      Set system's language                       |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|            1 Português - PT         2 English - EN               |");
        System.out.println("|            3 Deutsch - DE           4 Español - ES               |");
        System.out.println("|                        5 Français - FR                           |");
        System.out.println("+==================================================================+");
        System.out.print("| choose : ");
        
        String idiomaAtual = input.nextLine();
        
        if (idiomaAtual.equalsIgnoreCase("portugues") || idiomaAtual.equalsIgnoreCase("PT") || idiomaAtual.equalsIgnoreCase("1") ) {
        	menuInicialPT.menuPT();
        	
        } else if (idiomaAtual.equalsIgnoreCase("english") || idiomaAtual.equalsIgnoreCase("EN") || idiomaAtual.equalsIgnoreCase("2") ) {
        	menuEN.menuEn();
        	
        } else if (idiomaAtual.equalsIgnoreCase("deutsch") || idiomaAtual.equalsIgnoreCase("DE") || idiomaAtual.equalsIgnoreCase("3") ) {
        	System.out.println("menu em desenvolviento");
        	
        } else if (idiomaAtual.equalsIgnoreCase("Español") || idiomaAtual.equalsIgnoreCase("ES") || idiomaAtual.equalsIgnoreCase("3") ) {
        	System.out.println("menu em desenvolviento");
        	
        } else if (idiomaAtual.equalsIgnoreCase("Français") || idiomaAtual.equalsIgnoreCase("FR") || idiomaAtual.equalsIgnoreCase("4") ) {
        	System.out.println("menu em desenvolviento");
        	
        } else {
        	System.out.println("\nIdioma não reconhecido, confira os dados inseridos e tente novamente\n");
        	valido = false;
        }
        
        
		} while (!valido);

		input.close();
	}
}
