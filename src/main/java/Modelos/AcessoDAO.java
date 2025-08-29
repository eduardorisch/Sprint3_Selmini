package Modelos;

import Conexão.Conexao;

import java.sql.*;

public class AcessoDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    public void inserir (Acesso ace){
        sql = "insert into spj_acesso values(?, ?, ?, ?, ?, ?)";
        try (Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            ps.setLong(1, ace.getId());
            ps.setLong(2, ace.getIdEmp());
            ps.setString(3, ace.getNm());
            ps.setString(4, ace.getDesc());
            ps.setString(5, ace.getTipo());
            ps.setString(6, ace.getStatus());
            ps.execute();
        }
        catch (SQLException e){
            System.out.println("Erro ao inserir acesso no banco de dados\n" + e);
        }
    }
}
