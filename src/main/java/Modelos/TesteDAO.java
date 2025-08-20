package Modelos;

import Conexão.Conexão;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public void inserir (Teste teste){
        sql = "insert into java_teste values(?, ?, ?)";
        try (Connection connection = Conexão.conectar()){
            ps = connection.prepareStatement(sql);
            ps.setLong(1, teste.getId());
            ps.setString(2, teste.getNome());
            ps.setDouble(3, teste.getValor());
            ps.execute();
        }
        catch (SQLException e){
            System.out.println("Erro ao inserir no banco de dados\n" + e);
        }
    }

    public List<Teste> pesquisar(){
        List<Teste> lista = new ArrayList<>();
        sql = "select * from java_teste";
        try (Connection connection = Conexão.conectar()){
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                lista.add(new Teste(rs.getLong("teste_id"), rs.getDouble("teste_vl"), rs.getString("teste_nm")));
            }
        }
        catch (SQLException e){
            System.out.println("Erro ao pesquisar no banco de dados\n" + e);
        }
        return lista;
    }
}
