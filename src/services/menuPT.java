package services;

import DAO.*;
import java.util.Scanner;


public class menuPT{
	
//MENU INICIAL - lista todas ações que podem ser executadas no sistema em português///=======================================================
	public static void menuInicialPT () {
		
		boolean valido = true;
		Scanner input = new Scanner (System.in);
		
		do {
			


		System.out.println("+==================================================================+");
	    System.out.println("|                         Menu Inicial                             |");
	    System.out.println("|------------------------------------------------------------------|");
	    System.out.println("|   1 Cadastrar nova orientação     2 Excluir uma orientação       |");
	    System.out.println("|   3 Buscar por uma orientação     4 Editar orientação existente  |");
	    System.out.println("|   5 Mudar idioma                  6 Encerrar e sair              |");
	    System.out.println("+==================================================================+");
	    System.out.print("| Sua ação : ");
	    
	    String acao = input.nextLine();
	    
	//1 CADASTRO ///======================================================================================================================    
	    
	    if (acao.equals("1")) {
	    	orientacaoPT.cadastroPt();
			menuInicialPT();
	    	
	//2 EXCLUSÂO ///======================================================================================================================    
	    	
	    } else if (acao.equals("2")) {
	    	
	    	boolean excluirValido = true;
	    	
	    	do {
		    System.out.println("------------------------------------------------------------------");	   
		    System.out.println(" Sera preciso enncontar a orientação que deseja excluir. Para isso informe: ");
		    System.out.println("       1 ID ou 2 Titulo");
		    System.out.println("------------------------------------------------------------------");	   
		    System.out.print(" Digite qual deseja informar: ");
		    
		    String excluir = input.nextLine();
		    
		    if (excluir.equals("1")) {
		    	orientacaoPT.ExcluirPorID();
	    	
		    } else if (excluir.equals("2")) {
		    	orientacaoPT.ExcluirPorTitulo();
	    	
		    } else {
	    	System.out.println("\nAção inexistente, confira o numero digitado e tente novamente\n" );
	    	excluirValido = false;
		    }
	    
			} while (!excluirValido);
	    	
	    	menuInicialPT();
		    
	//3 BUSCA ///======================================================================================================================    
	    	
	    } else if (acao.equals("3")) {
	    	
	    	boolean buscaValida = true;
	    	
	    	do {
	    	System.out.println("+==================================================================+");
		    System.out.println("|                      Busca de Orientações                        |");
		    System.out.println("|------------------------------------------------------------------|");	   
		    System.out.println("|             1 Listar Todas           2 Listar por tipo           |");
		    System.out.println("|             3 Buscar por ID          4 Buscar por titulo         |");
		    System.out.println("|------------------------------------------------------------------|");
		    System.out.print("| Digite o tipo de busca que deseja realizar: ");

		    
		    String busca = input.nextLine();
		    
		    if (busca.equals("1")) {
		    	orientacaoPT.ListarTodaTabela();
		    	
		    }else if (busca.equals("2")) {
		    	orientacaoPT.ListarTudoPorTipo();
		    	
		    } else if (busca.equals("3")) {
		    	orientacaoPT.BuscaPorID();
		    	
		    } else if (busca.equals("4")) {
		    	orientacaoPT.BuscaPorTitulo();
		    	
		    } else {
		    	System.out.println("\nAção inexistente, confira o numero digitado e tente novamente\n" );
		    	buscaValida = false;
		    }
		    
			} while (!buscaValida);
	    	
	    	menuInicialPT();
	    	
	//4 EDIÇÂO ///======================================================================================================================    
	    	
	    } else if (acao.equals("4")) {
			boolean edicaoValida = true;

			do {
			System.out.println("|------------------------------------------------------------------|");
		    System.out.println("|         1 Recadastrar orientação       2 Editar Titulo           |");
			System.out.println("|         3 Editar Tipo                  4 Editar conteudo         |");
			System.out.println("|------------------------------------------------------------------|");
			System.out.print("| Que tipo de edição deseja realizar: ");

			String edita = input.nextLine();
		    
		    if (edita.equals("1")) {
		    	orientacaoPT.AtualizarTodaAOrientacao();
		    	
		    }else if (edita.equals("2")) {
		    	orientacaoPT.AtualizarTituloOrientacao();
		    	
		    } else if (edita.equals("3")) {
		    	orientacaoPT.AtualizarTipoOrientacao();
		    	
		    } else if (edita.equals("4")) {
		    	orientacaoPT.AtualizarOrientacao();
		    	
		    } else {
		    	System.out.println("\nAção inexistente, confira o numero digitado e tente novamente\n" );
		    	edicaoValida = false;
		    }
		    
			} while (!edicaoValida);
	    	
	    	menuInicialPT();
	    
	//5 MUDAR IDIOMA ///======================================================================================================================    
	    	
	    } else if (acao.equals("5")) {

			idioma.setLanguage();
	
	//6 ENCERRAR ///======================================================================================================================    
	    	
	    } else if (acao.equals("6")) {
		
			System.out.println("+==================================================================+");
			System.out.println("\n               Obrigado por utilizar o WEGone");
			System.out.println("                         Volte sempre!\n" );
	    	
	 // MENSAGEM DE ERRO ///======================================================================================================================    
  	
	    } else {
	    	System.out.println("\nAção inexistente, confira o numero digitado e tente novamente\n" );
	    	valido = false;
	    }
	    
		} while (!valido);
		
		
	}

	
}
