
import ConexaoBD.ConexaoBD;
import java.sql.Connection;
import services.idioma;



//criar pasta lib para importar o driver do jddc do mysql

public class App {
    public static void main(String[] args) throws Exception {

        Connection conexao = ConexaoBD.getConexao();

        if (conexao != null){
            System.out.println("banco de dados Conectado!");
        } else {
            System.out.println("Erro na conexão com o banco de dados");
        }
        
        //orientacaoEs test = new orientacaoEs();
        //test.ListarTodaTabelaES();
        
        System.out.println("====================================================================");
        System.out.println("||                      Welcome to WEG one                        ||");
        System.out.println("====================================================================");
        
        idioma.setLanguage();
        		
        	
        
    }


}
