package Conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexão {
    private static String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static String user = "rm555212";
    private static String password = "110106";

    private Conexão(){}

    public static Connection conectar(){
        try {
            return DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e){
            System.out.println("Erro ao conectar banco de dados\n" + e);
        }
        return null;
    }
}
