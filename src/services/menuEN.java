package services;

import DAO.orientacaoEn;
import java.util.Scanner;
//import app.wegone.*;

public class menuEN {


	
	
//MENU INICIAL - lista todas ações que podem ser executadas no sistema em português///=======================================================
	public void menuInicialEN () { // Method name remains menuPT, but its content will be translated
		
		boolean valido = true;
		Scanner input = new Scanner (System.in);
		
		do {
			
		System.out.println("+==================================================================+");
	    System.out.println("|                         Initial Menu                             |"); // Translated "Menu Inicial"
	    System.out.println("|------------------------------------------------------------------|");
	    System.out.println("|   1 Register new guidance       2 Delete a guidance          |"); // Translated "Cadastrar nova orientação" and "Excluir uma orientação"
	    System.out.println("|   3 Search for a guidance       4 Edit existing guidance     |"); // Translated "Buscar por uma orientação" and "Editar orientação existente"
	    System.out.println("|   5 Change language               6 Close and exit             |"); // Translated "Mudar idioma" and "Encerrar e sair"
	    System.out.println("+==================================================================+");
	    System.out.print("| Your action: "); // Translated "Sua ação :"
	    
	    String acao = input.nextLine();
	    
	//1 CADASTRO ///======================================================================================================================    
	    
	    if (acao.equals("1")) {
	    	orientacaoEn.cadastroEN(); // Assuming this method also has PT messages to be translated separately
			menuInicialEN();

	//2 EXCLUSÂO ///======================================================================================================================    
	    	
	    } else if (acao.equals("2")) {
	    	
	    	boolean excluirValido = true;
	    	
	    	do {
		    System.out.println("------------------------------------------------------------------");	   
		    System.out.println(" It will be necessary to find the guidance you want to delete. For this, please inform: "); // Translated "Sera preciso enncontar a orientação que deseja excluir. Para isso informe:"
		    System.out.println("       1 ID or 2 Title"); // Translated "1 ID ou 2 Titulo"
		    System.out.println("------------------------------------------------------------------");	   
		    System.out.print(" Enter which one you want to inform: "); // Translated "Digite qual deseja informar:"
		    
		    String excluir = input.nextLine();
		    
		    if (excluir.equals("1")) {
		    	orientacaoEn.ExcluirPorIDEN();; // Assuming this method also has PT messages
	    	
		    } else if (excluir.equals("2")) {
		    	orientacaoEn.ExcluirPorTituloEN(); // Assuming this method also has PT messages
	    	
		    } else {
	    	System.out.println("\nNon-existent action, please check the entered number and try again.\n" ); // Translated "Ação inexistente, confira o numero digitado e tente novamente"
	    	excluirValido = false;
		    }
	    
			} while (!excluirValido);
	    	
			menuInicialEN();		    
	//3 BUSCA ///======================================================================================================================    
	    	
	    } else if (acao.equals("3")) {
	    	
	    	boolean buscaValida = true;
	    	
	    	do {
	    	System.out.println("+==================================================================+");
		    System.out.println("|                      Guidance Search                             |"); // Translated "Busca de Orientações"
		    System.out.println("|------------------------------------------------------------------|");	   
		    System.out.println("|             1 List All               2 List by type              |"); // Translated "Listar Todas" and "Listar por tipo"
		    System.out.println("|             3 Search by ID           4 Search by title           |"); // Translated "Buscar por ID" and "Buscar por titulo"
		    System.out.println("|------------------------------------------------------------------|");
		    System.out.print("| Enter the type of search you want to perform: "); // Translated "Digite o tipo de busca que deseja realizar:"

		    
		    String busca = input.nextLine();
		    
		    if (busca.equals("1")) {
		    	orientacaoEn.ListarTodaTabelaEN(); // Assuming PT messages
		    	
		    }else if (busca.equals("2")) {
		    	orientacaoEn.ListarTudoPorTipoEN(); // Assuming PT messages
		    	
		    } else if (busca.equals("3")) {
		    	orientacaoEn.BuscaPorIDEN(); // Assuming PT messages
		    	
		    } else if (busca.equals("4")) {
		    	orientacaoEn.BuscaPorTituloEN(); // Assuming PT messages
		    	
		    } else {
		    	System.out.println("\nNon-existent action, please check the entered number and try again.\n" ); // Translated
		    	buscaValida = false;
		    }
		    
			} while (!buscaValida);
	    	
			menuInicialEN();	

	//4 EDIÇÂO ///======================================================================================================================    
	    	
	    } else if (acao.equals("4")) {
			boolean edicaoValida = true;

			do {
			System.out.println("|------------------------------------------------------------------|");
		    System.out.println("|         1 Re-register guidance       2 Edit Title                |"); // Translated "Recadastrar orientação" and "Editar Titulo"
			System.out.println("|         3 Edit Type                  4 Edit content              |"); // Translated "Editar Tipo" and "Editar conteudo"
			System.out.println("|------------------------------------------------------------------|");
			System.out.print("| What type of edit do you want to perform: "); // Translated "Que tipo de edição deseja realizar:"

			String edita = input.nextLine();
		    
		    if (edita.equals("1")) {
		    	orientacaoEn.AtualizarTodaAOrientacaoEN(); // Assuming PT messages
		    	
		    }else if (edita.equals("2")) {
		    	orientacaoEn.AtualizarTituloOrientacaoEN(); // Assuming PT messages
		    	
		    } else if (edita.equals("3")) {
		    	orientacaoEn.AtualizarTipoOrientacaoEN(); // Assuming PT messages
		    	
		    } else if (edita.equals("4")) {
		    	orientacaoEn.AtualizarOrientacaoEN(); // Assuming PT messages
		    	
		    } else {
		    	System.out.println("\nNon-existent action, please check the entered number and try again.\n" ); // Translated
		    	edicaoValida = false;
		    }
		    
			} while (!edicaoValida);
	    	
	    	menuInicialEN();
	    
	//5 MUDAR IDIOMA ///======================================================================================================================    
	    	
	    } else if (acao.equals("5")) {

			idioma.setLanguage();

	//6 ENCERRAR ///======================================================================================================================

	    } else if (acao.equals("6")) {	
			System.out.println("+==================================================================+");
			System.out.println("\n               Thank you for using WEGone"); // Translated "Obrigado por utilizar o WEGone"
			System.out.println("                         Come back soon!\n" ); // Translated "Volte sempre!"
	    	
	 // MENSAGEM DE ERRO ///======================================================================================================================    
  	
	    } else {
	    	System.out.println("\nNon-existent action, please check the entered number and try again.\n" ); // Translated
	    	valido = false;
	    }
	    
		} while (!valido);
		
		
	}

	
}
    

