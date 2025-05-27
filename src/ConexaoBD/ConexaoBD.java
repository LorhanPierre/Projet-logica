package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://shinkansen.proxy.rlwy.net:14508/railway";
    private static final String USER = "root";
    private static final String SENHA = "zWzbiDPJNfHqcKbGEdROrutRQQBEGLZa";

    public static Connection getConexao(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL,USER,SENHA);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Erro na conexão com o banco de dados", e);
        }
    }
}
