package services;

import DAO.*;
import java.util.Scanner;


public class menuDE{ // Mantido como menuPT conforme solicitado

//MENU INICIAL - lista todas ações que podem ser executadas no sistema em português///=======================================================
	public static void menuInicialDE () {

		boolean valido = true;
		Scanner input = new Scanner (System.in);

		do {

		System.out.println("+==================================================================+");
	    System.out.println("|                           Startmenü                              |"); // Menu Inicial -> Startmenü
	    System.out.println("|------------------------------------------------------------------|");
	    System.out.println("|   1 Neue Anleitung registrieren     2 Anleitung löschen          |"); // Cadastrar nova orientação (28) -> Neue Anleitung registrieren (28). Excluir uma orientação (23) -> Anleitung löschen (17). Original spaces: 5 after T1, 7 after T2. New spaces: 5 after T1, 7+(23-17)=13 after T2.
	    System.out.println("|   3 Nach Anleitung suchen           4 Bestehende Anleitung       |");
        System.out.println("|                                       bearbeiten                 |"); 
	    System.out.println("|   5 Sprache ändern                  6 Beenden und verlassen      |"); // Mudar idioma (12) -> Sprache ändern (14). Encerrar e sair (15) -> Beenden und verlassen (21). Original spaces for T1 padding: 21. New T1 padding: 38-(5+14)=19. Original suffix spaces for T2: 11. New suffix: 11+(15-21)=5.
	    System.out.println("+==================================================================+");
	    System.out.print("| Ihre Aktion : "); // Sua ação -> Ihre Aktion

	    String acao = input.nextLine();

	//1 CADASTRO ///======================================================================================================================

	    if (acao.equals("1")) {
	    	orientacaoDe.cadastroDE();
			menuInicialDE();

	//2 EXCLUSÂO ///======================================================================================================================

	    } else if (acao.equals("2")) {

	    	boolean excluirValido = true;

	    	do {
		    System.out.println("------------------------------------------------------------------");
		    System.out.println(" Sie müssen die Anleitung finden, die Sie löschen möchten. Geben Sie dazu Folgendes an: "); // Sera preciso enncontar a orientação que deseja excluir. Para isso informe: -> Sie müssen die Anleitung finden, die Sie löschen möchten. Geben Sie dazu Folgendes an:
		    System.out.println("       1 ID oder 2 Titel"); // 1 ID ou 2 Titulo -> 1 ID oder 2 Titel
		    System.out.println("------------------------------------------------------------------");
		    System.out.print(" Geben Sie ein, welche Information Sie angeben möchten: "); // Digite qual deseja informar: -> Geben Sie ein, welche Information Sie angeben möchten:

		    String excluir = input.nextLine();

		    if (excluir.equals("1")) {
		    	orientacaoPT.ExcluirPorID();

		    } else if (excluir.equals("2")) {
		    	orientacaoPT.ExcluirPorTitulo();

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
		    System.out.println("|                       Suche nach Anleitungen                     |"); // Busca de Orientações -> Suche nach Anleitungen
		    System.out.println("|------------------------------------------------------------------|");
		    System.out.println("|             1 Alle auflisten         2 Nach Typ auflisten        |"); // Listar Todas (12) -> Alle auflisten (14). Listar por tipo (15) -> Nach Typ auflisten (18). Orig T1 pad: 11. New T1 pad: 11+(12-14)=9. Orig T2 suf: 11. New T2 suf: 11+(15-18)=8.
		    System.out.println("|             3 Nach ID suchen         4 Nach Titel suchen         |"); // Buscar por ID (13) -> Nach ID suchen (14). Buscar por titulo (17) -> Nach Titel suchen (17). Orig T1 pad: 10. New T1 pad: 10+(13-14)=9. Orig T2 suf: 9. New T2 suf: 9+(17-17)=9.
		    System.out.println("|------------------------------------------------------------------|");
		    System.out.print("| Geben Sie den gewünschten Suchtyp ein: "); // Digite o tipo de busca que deseja realizar: -> Geben Sie den gewünschten Suchtyp ein:


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
		    System.out.println("|         1 Anleitung neu registrieren   2 Titel bearbeiten        |"); // Recadastrar orientação (26) -> Anleitung neu registrieren (28). Editar Titulo (13) -> Titel bearbeiten (16).
			System.out.println("|         3 Typ bearbeiten               4 Inhalt bearbeiten         |"); // Editar Tipo (11) -> Typ bearbeiten (14). Editar conteudo (15) -> Inhalt bearbeiten (17).
			System.out.println("|------------------------------------------------------------------|");
			System.out.print("| Welche Art von Bearbeitung möchten Sie durchführen: "); // Que tipo de edição deseja realizar: -> Welche Art von Bearbeitung möchten Sie durchführen:

			String edita = input.nextLine();

		    if (edita.equals("1")) {
		    	//orientacaoDe.AtualizarTodaAOrientacao();

		    }else if (edita.equals("2")) {
		    	//orientacaoDe.AtualizarTituloOrientacao();

		    } else if (edita.equals("3")) {
		    	//orientacaoDe.AtualizarTipoOrientacao();

		    } else if (edita.equals("4")) {
		    	//orientacaoDe.AtualizarOrientacao();

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
			System.out.println("\n          Vielen Dank, dass Sie WEGone verwendet haben"); // Obrigado por utilizar o WEGone -> Vielen Dank, dass Sie WEGone verwendet haben
			System.out.println("                     Kommen Sie bald wieder!\n" ); // Volte sempre! -> Kommen Sie bald wieder!

	 // MENSAGEM DE ERRO ///======================================================================================================================

	    } else {
	    	System.out.println("\nUngültige Aktion, bitte überprüfen Sie die eingegebene Nummer und versuchen Sie es erneut.\n" );
	    	valido = false;
	    }

		} while (!valido);


	}


}