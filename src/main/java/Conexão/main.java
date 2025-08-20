package Conexão;

import Modelos.Teste;
import Modelos.TesteDAO;

import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TesteDAO dao = new TesteDAO();
        int opt = 1;
        while(opt != 0){
            System.out.println("Oque você quer fazer? \n" +
                    "0. Encerrar programa\n" +
                    "1. Inserir no Banco de Dados\n" +
                    "2. Pesquisar linha no Banco de Dados\n" +
                    "3. Alterar linha no Banco de Dados\n" +
                    "4. Excluir linha no Banco de Dados");
            opt = in.nextInt();
            System.out.println("");

            if (opt == 0){
                System.out.println("Encerrando programa...");
            }
            else if (opt == 1) {
                System.out.println("Digite o ID: ");
                Long id = in.nextLong();
                System.out.println("Digite o valor: ");
                Double val = in.nextDouble();
                System.out.println("Digite o nome: ");
                String nm = in.next();
                Teste teste = new Teste(id, val, nm);
                dao.inserir(teste);
                System.out.println("Inserido no Banco de Dados!!!");
                System.out.println("");
            }
            else if (opt == 2) {
                System.out.println("Digite o ID: ");
                Long id = in.nextLong();
                List<Teste> lista = dao.pesquisar(id);
                for (Teste x : lista){
                    System.out.println(x.getId() + " -- " + x.getNome() + " -- " + x.getValor());
                }
                System.out.println("");
            }
            else if (opt == 3) {
                System.out.println("n sei");
                System.out.println("");
            }
            else if (opt == 4) {
                System.out.println("Digite o ID: ");
                Long id = in.nextLong();
                dao.exclusao(id);
                System.out.println("Linha excluida do Banco de Dados!!!");
                System.out.println("");
            }

        }







    }
}
