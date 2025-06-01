package services;

import DAO.*;
import java.util.Scanner;


public class menuES{ 
	
//MENU INICIAL - lista todas ações que podem ser executadas no sistema em português///=======================================================
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
	    System.out.print("| Su acción : "); // Traduzido
	    
	    String acao = input.nextLine();
	    
	//1 CADASTRO ///======================================================================================================================    
	    
	    if (acao.equals("1")) {
	    	orientacaoEs.cadastroES(); // Chamada de método original mantida
			menuInicialES();
	    	
	//2 EXCLUSÂO ///======================================================================================================================    
	    	
	    } else if (acao.equals("2")) {
	    	
	    	boolean excluirValido = true;
	    	
	    	do {
		    System.out.println("------------------------------------------------------------------");	   
		    System.out.println(" Será preciso encontrar la orientación que desea eliminar. Para ello, informe: "); // Traduzido
		    System.out.println("       1 ID o 2 Título"); // Traduzido
		    System.out.println("------------------------------------------------------------------");	   
		    System.out.print(" Digite cuál desea informar: "); // Traduzido
		    
		    String excluir = input.nextLine();
		    
		    if (excluir.equals("1")) {
		    	//orientacaoEs.ExcluirPorIDES(); // Chamada de método original mantida
	    	
		    } else if (excluir.equals("2")) {
		    	//orientacaoEs.ExcluirPorTituloES(); // Chamada de método original mantida
	    	
		    } else {
	    	System.out.println("\nAcción inexistente, verifique el número ingresado e inténtelo de nuevo.\n" ); // Traduzido
	    	excluirValido = false;
		    }
	    
			} while (!excluirValido);

	    	menuInicialES();

	//3 BUSCA ///======================================================================================================================

	    } else if (acao.equals("3")) {
	    	
	    	boolean buscaValida = true;
	    	
	    	do {
	    	System.out.println("+==================================================================+");
		    System.out.println("|                     Búsqueda de Orientaciones                    |"); // Traduzido
		    System.out.println("|------------------------------------------------------------------|");	   
		    System.out.println("|             1 Listar Todas             2 Listar por tipo           |"); // Traduzido (textos iguais ou de mesmo tamanho)
		    System.out.println("|             3 Buscar por ID            4 Buscar por título         |"); // Traduzido (textos iguais ou de mesmo tamanho)
		    System.out.println("|------------------------------------------------------------------|");
		    System.out.print("| Digite el tipo de búsqueda que desea realizar: "); // Traduzido

		    
		    String busca = input.nextLine();
		    
		    if (busca.equals("1")) {
		    	orientacaoEs.ListarTodaTabelaES(); // Chamada de método original mantida
		    	
		    }else if (busca.equals("2")) {
		    	//orientacaoEs.ListarTudoPorTipoES(); // Chamada de método original mantida
		    	
		    } else if (busca.equals("3")) {
		    	//orientacaoEs.BuscaPorIDES(); // Chamada de método original mantida
		    	
		    } else if (busca.equals("4")) {
		    	//orientacaoEs.BuscaPorTituloES(); // Chamada de método original mantida
		    	
		    } else {
		    	System.out.println("\nAcción inexistente, verifique el número ingresado e inténtelo de nuevo.\n" ); // Traduzido
		    	buscaValida = false;
		    }
		    
			} while (!buscaValida);
	    	
	    	menuInicialES();
	    	
	//4 EDIÇÂO ///======================================================================================================================    
	    	
	    } else if (acao.equals("4")) {
			boolean edicaoValida = true;

			do {
			System.out.println("|------------------------------------------------------------------|");
		    System.out.println("|         1 Volver a registrar orientación 2 Editar Título           |"); // Traduzido e espaçamento ajustado
			System.out.println("|         3 Editar Tipo                  4 Editar contenido          |"); // Traduzido e espaçamento ajustado
			System.out.println("|------------------------------------------------------------------|");
			System.out.print("| Qué tipo de edición desea realizar: "); // Traduzido

			String edita = input.nextLine();
		    
		    if (edita.equals("1")) {
		    	//orientacaoEs.AtualizarTodaAOrientacaoES(); 
		    	
		    }else if (edita.equals("2")) {
		    	//orientacaoEs.AtualizarTituloOrientacaoES(); 
		    } else if (edita.equals("3")) {
		    	//orientacaoEs.AtualizarTipoOrientacaoES(); 
		    	
		    } else if (edita.equals("4")) {
		    	//orientacaoEs.AtualizarOrientacaoES(); 
		    	
		    } else {
		    	System.out.println("\nAcción inexistente, verifique el número ingresado e inténtelo de nuevo.\n" ); // Traduzido
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
			System.out.println("\n               Gracias por utilizar WEGone"); // Traduzido
			System.out.println("                         ¡Vuelva pronto!\n" ); // Traduzido
	    	
	 // MENSAGEM DE ERRO ///======================================================================================================================    
  	
	    } else {
	    	System.out.println("\nAcción inexistente, verifique el número ingresado e inténtelo de nuevo.\n" ); // Traduzido
	    	valido = false;
	    }
	    
		} while (!valido);
		
		
	}

	
}