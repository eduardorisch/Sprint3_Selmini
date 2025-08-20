package Modelos;

import Conexão.Conexao;

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
        try (Connection connection = Conexao.conectar()){
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

    public List<Teste> pesquisar(Long id){
        List<Teste> lista = new ArrayList<>();
        sql = "select * from java_teste where teste_id = " + id;
        try (Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                lista.add(new Teste(rs.getLong("teste_id"), rs.getDouble("teste_vl"), rs.getString("teste_nm")));
            }
        }
        catch (SQLException e){
            System.out.println("Erro ao pesquisar linha no banco de dados\n" + e);
        }
        return lista;
    }

    public void exclusao(Long id){
        sql = "delete from java_teste where teste_id = " + id;
        try (Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            ps.execute();
        }
        catch (SQLException e){
            System.out.println("Erro ao excluir linha no banco de dados\n" + e);
        }
    }
}
