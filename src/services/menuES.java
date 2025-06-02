package services;

import DAO.*;
import java.util.Scanner;


public class menuES{ 
	
//MENU INICIAL - lista todas ações que podem ser executadas no sistema em Espanhol///=======================================================
	public static void menuInicialES () { 
		
		boolean valido = true;
		Scanner input = new Scanner (System.in);
		
		do {
			
		System.out.println("+==================================================================+");
	    System.out.println("|                          Menú Inicial                            |"); 
	    System.out.println("|------------------------------------------------------------------|");
	    System.out.println("|   1 Registrar nueva orientación  2 Eliminar una orientación      |"); 
	    System.out.println("|   3 Buscar una orientación       4 Editar orientación existente  |");
	    System.out.println("|   5 Cambiar idioma               6 Cerrar y salir                |");
	    System.out.println("+==================================================================+");
	    System.out.print("| Su acción : ");
	    
	    String acao = input.nextLine();
	    
	//1 CADASTRO ///======================================================================================================================    
	    
	    if (acao.equals("1")) {
	    	orientacaoEs.cadastroEs(); 
			menuInicialES();
	    	
	//2 EXCLUSÂO ///======================================================================================================================    
	    	
	    } else if (acao.equals("2")) {
	    	
	    	boolean excluirValido;
	    	
	    	do {
		    System.out.println("------------------------------------------------------------------");	   
		    System.out.println(" Será preciso encontrar la orientación que desea eliminar. Para ello, informe: ");
		    System.out.println("       1 ID o 2 Título"); 
		    System.out.println("------------------------------------------------------------------");	   
		    System.out.print(" Digite cuál desea informar: "); 
		    String excluir = input.nextLine();
		    
		    if (excluir.equals("1")) {
		    	orientacaoEs.ExcluirPorIDEs(); 
				excluirValido = true;
	    	
		    } else if (excluir.equals("2")) {
		    	orientacaoEs.ExcluirPorTituloEs();
				excluirValido = true; 

		    } else {
	    	System.out.println("\nAcción inexistente, verifique el número ingresado e inténtelo de nuevo.\n" ); 
			excluirValido = false;
		    }
	    
			} while (!excluirValido);

	    	menuInicialES();

	//3 BUSCA ///======================================================================================================================

	    } else if (acao.equals("3")) {
	    	
	    	boolean buscaValida;
	    	
	    	do {
	    	System.out.println("+==================================================================+");
		    System.out.println("|                     Búsqueda de Orientaciones                    |"); 
		    System.out.println("|------------------------------------------------------------------|");	   
		    System.out.println("|             1 Listar Todas             2 Listar por tipo         |"); 
		    System.out.println("|             3 Buscar por ID            4 Buscar por título       |"); 
		    System.out.println("|------------------------------------------------------------------|");
		    System.out.print("| Digite el tipo de búsqueda que desea realizar: "); 

		    
		    String busca = input.nextLine();
		    
		    if (busca.equals("1")) {
		    	orientacaoEs.ListarTodaTabelaEs(); 
				buscaValida = true;
		    	
		    }else if (busca.equals("2")) {
		    	orientacaoEs.ListarTudoPorTipoEs(); 
				buscaValida = true;
		    	
		    } else if (busca.equals("3")) {
		    	orientacaoEs.BuscaPorIDEs();
				buscaValida = true;
		    	
		    } else if (busca.equals("4")) {
		    	orientacaoEs.BuscaPorTituloEs(); 
				buscaValida = true;
		    	
		    } else {
		    	System.out.println("\nAcción inexistente, verifique el número ingresado e inténtelo de nuevo.\n" ); 
		    	buscaValida = false;
		    }
		    
			} while (!buscaValida);
	    	
	    	menuInicialES();
	    	
	//4 EDIÇÂO ///======================================================================================================================    
	    	
	    } else if (acao.equals("4")) {
			boolean edicaoValida;

			do {
			System.out.println("|------------------------------------------------------------------|");
		    System.out.println("|         1 Volver a registrar orientación 2 Editar Título         |"); 
			System.out.println("|         3 Editar Tipo                  4 Editar contenido        |"); 
			System.out.println("|------------------------------------------------------------------|");
			System.out.print("| Qué tipo de edición desea realizar: "); 

			String edita = input.nextLine();
		    
		    if (edita.equals("1")) {
		    	orientacaoEs.AtualizarTodaAOrientacaoEs(); 
				edicaoValida = true;
		    	
		    }else if (edita.equals("2")) {
		    	orientacaoEs.AtualizarTituloOrientacaoEs(); 
				edicaoValida = true;

		    } else if (edita.equals("3")) {
		    	orientacaoEs.AtualizarTipoOrientacaoEs(); 
		    	edicaoValida = true;

		    } else if (edita.equals("4")) {
		    	orientacaoEs.AtualizarOrientacaoEs(); 
		    	edicaoValida = true;

		    } else {
		    	System.out.println("\nAcción inexistente, verifique el número ingresado e inténtelo de nuevo.\n" ); 
		    	edicaoValida = false;
		    }
		    
			} while (!edicaoValida);
	    	
	    	menuInicialES();

	//5 MUDAR IDIOMA ///======================================================================================================================    
	    	
	    } else if (acao.equals("5")) {

			idioma.setLanguage(); 
	
	//6 ENCERRAR ///======================================================================================================================    
	    	
	    } else if (acao.equals("6")) {
		
			System.out.println("+==================================================================+");
			System.out.println("\n               Gracias por utilizar WEGone"); 
			System.out.println("                         ¡Vuelva pronto!\n" ); 
	    	
	 // MENSAGEM DE ERRO ///======================================================================================================================    
  	
	    } else {
	    	System.out.println("\nAcción inexistente, verifique el número ingresado e inténtelo de nuevo.\n" );
	    }
	    
		} while (!valido);
		
		
	}

	
}