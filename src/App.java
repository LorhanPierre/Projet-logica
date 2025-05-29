import ConexaoBD.ConexaoBD;
import DAO.orientacaoPT;
import java.sql.Connection;
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
        
        orientacaoPT test = new orientacaoPT();
        
        
        System.out.println("====================================================================");
        System.out.println("||                      Welcome to WEG one                        ||");
        System.out.println("====================================================================");
        
        services.setLanguage();
        		
        	
        
    }
}
