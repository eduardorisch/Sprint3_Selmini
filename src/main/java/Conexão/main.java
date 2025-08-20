package Conexão;

import Modelos.Teste;
import Modelos.TesteDAO;

import java.sql.Connection;
import java.util.List;

public class main {
    public static void main(String[] args) {
        TesteDAO dao = new TesteDAO();
        //Teste teste = new Teste(01L, 78.45, "roberto");
        //dao.inserir(teste);

        List<Teste> lista = dao.pesquisar();
        for (Teste x : lista){
            System.out.println(x.getId() + " -- " + x.getNome() + " -- " + x.getValor());
        }
    }
}
