package services;

import DAO.*;
import java.util.Scanner;


public class menuFR{
	
	public static void menuInicialFR () {
		
		boolean valido = true;
		Scanner input = new Scanner (System.in);
		
		do {
			
		System.out.println("+==================================================================+");
	    System.out.println("|                          Menu Principal                          |");
	    System.out.println("|------------------------------------------------------------------|");
	    System.out.println("|   1 Enregistrer nouvelle         2 Supprimer une orientation     |");
        System.out.println("|     orientation                                                  |");
	    System.out.println("|   3 Rechercher une orientation  4 Modifier orientation existante |");
	    System.out.println("|   5 Changer de langue           6 Fermer et quitter              |");
	    System.out.println("+==================================================================+");
	    System.out.print("| Votre action : ");
	    
	    String acao = input.nextLine();
	    
	    if (acao.equals("1")) {
	    	orientacaoFr.cadastroFR();
			menuInicialFR();
	    	
	    } else if (acao.equals("2")) {
	    	
	    	boolean excluirValido = true;
	    	
	    	do {
		    System.out.println("------------------------------------------------------------------");	   
		    System.out.println(" Il faudra trouver l'orientation que vous souhaitez supprimer. ");
            System.out.println("  Pour cela, informez : 1 ID ou 2 Titre");
		    System.out.println("------------------------------------------------------------------");	   
		    System.out.print(" Saisissez ce que vous souhaitez informer : ");
		    
		    String excluir = input.nextLine();
		    
		    if (excluir.equals("1")) {
		    	//orientacaoFr.ExcluirPorIDFR();
	    	
		    } else if (excluir.equals("2")) {
		    	//orientacaoFr.ExcluirPorTituloFR();

		    } else {
	    	System.out.println("\nAction inexistante, vérifiez le numéro saisi et réessayez.\n" );
	    	excluirValido = false;
		    }
	    
			} while (!excluirValido);

	    	menuInicialFR();

	    } else if (acao.equals("3")) {
	    	
	    	boolean buscaValida = true;
	    	
	    	do {
	    	System.out.println("+==================================================================+");
		    System.out.println("|                     Recherche d'Orientations                     |");
		    System.out.println("|------------------------------------------------------------------|");	   
		    System.out.println("|           1 Tout lister              2 Lister par type           |");
		    System.out.println("|           3 Rechercher par ID        4 Rechercher par titre      |");
		    System.out.println("|------------------------------------------------------------------|");
		    System.out.print("| Saisissez le type de recherche que vous souhaitez effectuer : ");

		    
		    String busca = input.nextLine();
		    
		    if (busca.equals("1")) {
		    	//orientacaoFr.ListarTodaTabelaFR();
		    	
		    }else if (busca.equals("2")) {
		    	//orientacaoFr.ListarTudoPorTipoFR();
		    	
		    } else if (busca.equals("3")) {
		    	//orientacaoFr.BuscaPorIDFR();

		    } else if (busca.equals("4")) {
		    	//orientacaoFr.BuscaPorTituloFR();

		    } else {
		    	System.out.println("\nAction inexistante, vérifiez le numéro saisi et réessayez.\n" );
		    	buscaValida = false;
		    }
		    
			} while (!buscaValida);

	    	menuInicialFR();

	    } else if (acao.equals("4")) {
			boolean edicaoValida = true;

			do {
			System.out.println("|------------------------------------------------------------------|");
		    System.out.println("|         1 Réenregistrer orientation    2 Modifier Titre          |");
			System.out.println("|         3 Modifier Type                4 Modifier contenu        |");
			System.out.println("|------------------------------------------------------------------|");
			System.out.print("| Quel type de modification souhaitez-vous effectuer : ");

			String edita = input.nextLine();
		    
		    if (edita.equals("1")) {
		    	//orientacaoFr.AtualizarTodaAOrientacaoFR();
		    	
		    }else if (edita.equals("2")) {
		    	//orientacaoFr.AtualizarTituloOrientacaoFR();

		    } else if (edita.equals("3")) {
		    	//orientacaoFr.AtualizarTipoOrientacaoFR();

		    } else if (edita.equals("4")) {
		    	//orientacaoFr.AtualizarOrientacaoFR();

		    } else {
		    	System.out.println("\nAction inexistante, vérifiez le numéro saisi et réessayez.\n" );
		    	edicaoValida = false;
		    }
		    
			} while (!edicaoValida);

	    	menuInicialFR();

	    } else if (acao.equals("5")) {

			idioma.setLanguage();
	
	    } else if (acao.equals("6")) {
		
			System.out.println("+==================================================================+");
			System.out.println("\n               Merci d'avoir utilisé WEGone");
			System.out.println("                         À bientôt !\n" );
	    	
	    } else {
	    	System.out.println("\nAction inexistante, vérifiez le numéro saisi et réessayez.\n" );
	    	valido = false;
	    }
	    
		} while (!valido);
		
		
	}

	
}