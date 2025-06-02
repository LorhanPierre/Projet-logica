package services;

import DAO.*;
import java.util.Scanner;


public class menuDE{ 

//MENU INICIAL - lista todas ações que podem ser executadas no sistema em Alemão///=======================================================
	public static void menuInicialDE () {

		boolean valido = true;
		Scanner input = new Scanner (System.in);

		do {

		System.out.println("+==================================================================+");
	    System.out.println("|                           Startmenü                              |"); 
	    System.out.println("|------------------------------------------------------------------|");
	    System.out.println("|   1 Neue Anleitung registrieren     2 Anleitung löschen          |"); 
	    System.out.println("|   3 Nach Anleitung suchen           4 Bestehende Anleitung       |");
        System.out.println("|                                       bearbeiten                 |"); 
	    System.out.println("|   5 Sprache ändern                  6 Beenden und verlassen      |"); 
	    System.out.println("+==================================================================+");
	    System.out.print("| Ihre Aktion : ");

	    String acao = input.nextLine();

	//1 CADASTRO ///======================================================================================================================

	    if (acao.equals("1")) {
	    	orientacaoDe.cadastroDe();
			menuInicialDE();

	//2 EXCLUSÂO ///======================================================================================================================

	    } else if (acao.equals("2")) {

	    	boolean excluirValido = true;

	    	do {
		    System.out.println("------------------------------------------------------------------");
		    System.out.println(" Sie müssen die Anleitung finden, die Sie löschen möchten. "); 
			System.out.println(" Geben Sie dazu Folgendes an: "); 
		    System.out.println("       1 ID oder 2 Titel"); 
		    System.out.println("------------------------------------------------------------------");
		    System.out.print(" Geben Sie ein, welche Information Sie angeben möchten: "); 

		    String excluir = input.nextLine();

		    if (excluir.equals("1")) {
		    	orientacaoDe.ExcluirPorIDDe();

		    } else if (excluir.equals("2")) {
		    	orientacaoDe.ExcluirPorTituloDe();

		    } else {
	    	System.out.println("\nUngültige Aktion, bitte überprüfen Sie die eingegebene Nummer und versuchen Sie es erneut.\n" ); // Ação inexistente, confira o numero digitado e tente novamente -> Ungültige Aktion, bitte überprüfen Sie die eingegebene Nummer und versuchen Sie es erneut.
	    	excluirValido = false;
		    }

			} while (!excluirValido);

	    	menuInicialDE();

	//3 BUSCA ///======================================================================================================================

	    } else if (acao.equals("3")) {

	    	boolean buscaValida = true;

	    	do {
	    	System.out.println("+==================================================================+");
		    System.out.println("|                       Suche nach Anleitungen                     |"); 
		    System.out.println("|------------------------------------------------------------------|");
		    System.out.println("|             1 Alle auflisten         2 Nach Typ auflisten        |"); 
		    System.out.println("|             3 Nach ID suchen         4 Nach Titel suchen         |"); 
		    System.out.println("|------------------------------------------------------------------|");
		    System.out.print("| Geben Sie den gewünschten Suchtyp ein: "); 


		    String busca = input.nextLine();

		    if (busca.equals("1")) {
		    	orientacaoDe.ListarTodaTabelaDe();

		    }else if (busca.equals("2")) {
		    	orientacaoDe.ListarTudoPorTipoDe();

		    } else if (busca.equals("3")) {
		    	orientacaoDe.BuscaPorIDDe();

		    } else if (busca.equals("4")) {
		    	orientacaoDe.BuscaPorTituloDe();

		    } else {
		    	System.out.println("\nUngültige Aktion, bitte überprüfen Sie die eingegebene Nummer und versuchen Sie es erneut.\n" );
		    	buscaValida = false;
		    }

			} while (!buscaValida);

	    	menuInicialDE();

	//4 EDIÇÂO ///======================================================================================================================

	    } else if (acao.equals("4")) {
			boolean edicaoValida = true;

			do {
			System.out.println("|------------------------------------------------------------------|");
		    System.out.println("|         1 Anleitung neu registrieren   2 Titel bearbeiten        |"); 
			System.out.println("|         3 Typ bearbeiten               4 Inhalt bearbeiten       |"); 
			System.out.println("|------------------------------------------------------------------|");
			System.out.print("| Welche Art von Bearbeitung möchten Sie durchführen: "); 

			String edita = input.nextLine();

		    if (edita.equals("1")) {
		    	orientacaoDe.AtualizarTodaAOrientacaoDe();

		    }else if (edita.equals("2")) {
		    	orientacaoDe.AtualizarTituloOrientacaoDe();

		    } else if (edita.equals("3")) {
		    	orientacaoDe.AtualizarTipoOrientacaoDe();

		    } else if (edita.equals("4")) {
		    	orientacaoDe.AtualizarOrientacaoDe();

		    } else {
		    	System.out.println("\nUngültige Aktion, bitte überprüfen Sie die eingegebene Nummer und versuchen Sie es erneut.\n" );
		    	edicaoValida = false;
		    }

			} while (!edicaoValida);

	    	menuInicialDE();

	//5 MUDAR IDIOMA ///======================================================================================================================

	    } else if (acao.equals("5")) {

			idioma.setLanguage();

	//6 ENCERRAR ///======================================================================================================================

	    } else if (acao.equals("6")) {

			System.out.println("+==================================================================+");
			System.out.println("\n          Vielen Dank, dass Sie WEGone verwendet haben");
			System.out.println("                     Kommen Sie bald wieder!\n" );

	 // MENSAGEM DE ERRO ///======================================================================================================================

	    } else {
	    	System.out.println("\nUngültige Aktion, bitte überprüfen Sie die eingegebene Nummer und versuchen Sie es erneut.\n" );
	    	valido = false;
	    }

		} while (!valido);


	}


}