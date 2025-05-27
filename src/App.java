import java.sql.Connection;

import ConexaoBD.ConexaoBD;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

                Connection conexao = ConexaoBD.getConexao();

        if (conexao != null){
            System.out.println("banco de dados Conectado!");
        } else {
            System.out.println("Erro na conexão com o banco de dados");
        }
    }
}
