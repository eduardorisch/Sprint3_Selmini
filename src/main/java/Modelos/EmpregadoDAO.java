package Modelos;

import Conexão.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpregadoDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public void inserir (Empregado emp){
        sql = "insert into spj_empregado values(?, ?, ?, ?, ?, ?)";
        try (Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            ps.setLong(1, emp.getId());
            ps.setString(2, emp.getNome());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getTipo());
            ps.setString(5, emp.getStatus());
            ps.setDate(6, Date.valueOf(emp.getData()));
            ps.execute();
        }
        catch (SQLException e){
            System.out.println("Erro ao inserir empregado no banco de dados\n" + e);
        }
    }

    public List<Empregado> pesquisar(Long id){
        List<Empregado> lista = new ArrayList<>();
        sql = "select * from spj_empregado where id_empregado = ?";
        try (Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                Empregado emp = new Empregado();
                emp.setId(rs.getLong("id_empregado"));
                emp.setNome(rs.getString("nm_empregado"));
                emp.setEmail(rs.getString("email_empregado"));
                emp.setTipo(rs.getString("tp_perfil"));
                emp.setStatus(rs.getString("status_empregado"));
                emp.setData(rs.getDate("dt_cadastro").toLocalDate());
                lista.add(emp);
            }
        }
        catch (SQLException e){
            System.out.println("Erro ao pesquisar empregado no banco de dados\n" + e);
        }
        return lista;
    }

    public void alterar (Long id, String nome, String email, String tipo, String status){
        sql = "update spj_empregado set nm_empregado = ?,email_empregado = ?, tp_perfil = ?, status_empregado = ? where id_empregado = ?";
        try (Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, tipo);
            ps.setString(4, status);
            ps.setLong(5, id);
            ps.execute();
        }
        catch (SQLException e){
            System.out.println("Erro ao alterar empregado no banco de dados\n" + e);
        }
    }

    public void exclusao(Long id){
        sql = "delete from spj_empregado where id_empregado = ?";
        try (Connection connection = Conexao.conectar()){
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
        }
        catch (SQLException e){
            System.out.println("Erro ao excluir empregado no banco de dados\n" + e);
        }
    }
}
