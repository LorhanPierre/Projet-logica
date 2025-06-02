package services;

import DAO.orientacaoEn;
import java.util.Scanner;
//import app.wegone.*;

public class menuEN {
	
//MENU INICIAL - lista todas ações que podem ser executadas no sistema em Inglês//=======================================================
	public static void menuInicialEN () { 
		
		boolean valido = true;
		Scanner input = new Scanner (System.in);
		
		do {
			
		System.out.println("+==================================================================+");
	    System.out.println("|                         Initial Menu                             |"); 
	    System.out.println("|------------------------------------------------------------------|");
	    System.out.println("|     1 Register new guidance       2 Delete a guidance            |"); 
	    System.out.println("|     3 Search for a guidance       4 Edit existing guidance       |"); 
	    System.out.println("|     5 Change language               6 Close and exit             |"); 
	    System.out.println("+==================================================================+");
	    System.out.print("| Your action: "); 
	    
	    String acao = input.nextLine();
	    
	//1 CADASTRO ///======================================================================================================================    
	    
	    if (acao.equals("1")) {
	    	orientacaoEn.cadastroEn();
			menuInicialEN();

	//2 EXCLUSÂO ///======================================================================================================================    
	    	
	    } else if (acao.equals("2")) {
	    	
	    	boolean excluirValido = true;
	    	
	    	do {
		    System.out.println("------------------------------------------------------------------");	   
		    System.out.println(" It will be necessary to find the guidance you want to delete. For this, please inform: "); 
		    System.out.println("       1 ID or 2 Title"); 
		    System.out.println("------------------------------------------------------------------");	   
		    System.out.print(" Enter which one you want to inform: "); 
		    String excluir = input.nextLine();
		    
		    if (excluir.equals("1")) {
		    	orientacaoEn.ExcluirPorIDEn();
		    } else if (excluir.equals("2")) {
		    	orientacaoEn.ExcluirPorTituloEn(); 
	    	
		    } else {
	    	System.out.println("\nNon-existent action, please check the entered number and try again.\n" ); 
	    	excluirValido = false;
		    }
	    
			} while (!excluirValido);
	    	
			menuInicialEN();		    
	//3 BUSCA ///======================================================================================================================    
	    	
	    } else if (acao.equals("3")) {
	    	
	    	boolean buscaValida = true;
	    	
	    	do {
	    	System.out.println("+==================================================================+");
		    System.out.println("|                      Guidance Search                             |"); 
		    System.out.println("|------------------------------------------------------------------|");	   
		    System.out.println("|             1 List All               2 List by type              |"); 
		    System.out.println("|             3 Search by ID           4 Search by title           |"); 
		    System.out.println("|------------------------------------------------------------------|");
		    System.out.print("| Enter the type of search you want to perform: ");

		    
		    String busca = input.nextLine();
		    
		    if (busca.equals("1")) {
		    	orientacaoEn.ListarTodaTabelaEn(); 
		    	
		    }else if (busca.equals("2")) {
		    	orientacaoEn.ListarTudoPorTipoEn(); 
		    	
		    } else if (busca.equals("3")) {
		    	orientacaoEn.BuscaPorIDEn(); 
		    	
		    } else if (busca.equals("4")) {
		    	orientacaoEn.BuscaPorTituloEn(); 
		    	
		    } else {
		    	System.out.println("\nNon-existent action, please check the entered number and try again.\n" ); 
		    	buscaValida = false;
		    }
		    
			} while (!buscaValida);
	    	
			menuInicialEN();	

	//4 EDIÇÂO ///======================================================================================================================    
	    	
	    } else if (acao.equals("4")) {
			boolean edicaoValida = true;

			do {
			System.out.println("|------------------------------------------------------------------|");
		    System.out.println("|         1 Re-register guidance       2 Edit Title                |"); 
			System.out.println("|         3 Edit Type                  4 Edit content              |"); 
			System.out.println("|------------------------------------------------------------------|");
			System.out.print("| What type of edit do you want to perform: "); 

			String edita = input.nextLine();
		    
		    if (edita.equals("1")) {
		    	orientacaoEn.AtualizarTodaAOrientacaoEn();
		    	
		    }else if (edita.equals("2")) {
		    	orientacaoEn.AtualizarTituloOrientacaoEn(); 
		    	
		    } else if (edita.equals("3")) {
		    	orientacaoEn.AtualizarTipoOrientacaoEn(); 
		    	
		    } else if (edita.equals("4")) {
		    	orientacaoEn.AtualizarOrientacaoEn(); 
		    	
		    } else {
		    	System.out.println("\nNon-existent action, please check the entered number and try again.\n" ); 
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
			System.out.println("\n               Thank you for using WEGone"); 
			System.out.println("                     Come back soon!\n" );
	    	
	 // MENSAGEM DE ERRO ///======================================================================================================================    
  	
	    } else {
	    	System.out.println("\nNon-existent action, please check the entered number and try again.\n" ); 
	    	valido = false;
	    }
	    
		} while (!valido);
		
		
	}

	
}
    

