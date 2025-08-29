package Modelos;

import Conexão.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EtapaDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    public void inserir (Etapa eta){
        sql = "insert into spj_etapa values(?, ?, ?, ?, ?)";
        try (Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            ps.setLong(1, eta.getId());
            ps.setString(2, eta.getNome());
            ps.setString(3, eta.getDesc());
            ps.setLong(4, eta.getPontos());
            ps.setString(5, eta.getStatus());
            ps.execute();
        }
        catch (SQLException e){
            System.out.println("Erro ao inserir etapa no banco de dados\n" + e);
        }
    }
}
