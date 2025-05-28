import java.sql.Connection;
import DAO.*;
//import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;
import services.*;
import ConexaoBD.ConexaoBD;

public class App {
    public static void main(String[] args) throws Exception {

                Connection conexao = ConexaoBD.getConexao();

        if (conexao != null){
            System.out.println("banco de dados Conectado!");
        } else {
            System.out.println("Erro na conexão com o banco de dados");
        }
        ;
        
        
        System.out.println("====================================================================");
        System.out.println("||                      Welcome to WEG one                        ||");
        System.out.println("====================================================================");
        
        services.setLanguage();
        		
        	
        
    }
}
