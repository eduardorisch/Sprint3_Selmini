package Conexão;

import Modelos.Empregado;
import Modelos.EmpregadoDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class mainEmpregado {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        EmpregadoDAO dao = new EmpregadoDAO();
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
                Empregado emp = new Empregado();
                System.out.println("Digite o ID: ");
                emp.setId(in.nextLong());
                System.out.println("Digite o nome: ");
                emp.setNome(in.next());
                System.out.println("Digite o email: ");
                emp.setEmail(in.next());
                System.out.println("Digite o tipo: ");
                emp.setTipo(in.next());
                System.out.println("Digite o status: ");
                emp.setStatus(in.next());
                System.out.println("Digite a data de cadastro(aaaa-mm-dd):");
                emp.setData(LocalDate.parse(in.next()));
                dao.inserir(emp);
                System.out.println("Inserido no Banco de Dados!!!");
                System.out.println("");
            }
            else if (opt == 2) {
                System.out.println("Digite o ID para pesquisar: ");
                Long id = in.nextLong();
                List<Empregado> lista = dao.pesquisar(id);
                for (Empregado x : lista){
                    System.out.println(x);
                }
                System.out.println("");
            }
            else if (opt == 3) {
                System.out.println("Digite o ID para alterar: ");
                Long id = in.nextLong();
                System.out.println("Digite o nome: ");
                String nm = in.next();
                System.out.println("Digite o email: ");
                String email = in.next();
                System.out.println("Digite o tipo: ");
                String tipo = in.next();
                System.out.println("Digite o status: ");
                String status = in.next();
                dao.alterar(id,nm,email, tipo, status);
                System.out.println("Linha alterada do Banco de Dados!!!");
                System.out.println("");
            }
            else if (opt == 4) {
                System.out.println("Digite o ID para excluir: ");
                Long id = in.nextLong();
                dao.exclusao(id);
                System.out.println("Linha excluida do Banco de Dados!!!");
                System.out.println("");
            }

        }

    }
}
