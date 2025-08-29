package Conexão;

import Modelos.Acesso;
import Modelos.AcessoDAO;
import Modelos.Empregado;
import Modelos.EmpregadoDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class mainAcesso {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AcessoDAO dao = new AcessoDAO();
        int opt = 1;
        while(opt != 0){
            System.out.println("Oque você quer fazer? \n" +
                    "0. Encerrar programa\n" +
                    "1. Inserir no Banco de Dados\n");
            opt = in.nextInt();
            System.out.println("");

            if (opt == 0){
                System.out.println("Encerrando programa...");
            }
            else if (opt == 1) {
                Acesso ace = new Acesso();
                System.out.println("Digite o ID: ");
                ace.setId(in.nextLong());
                System.out.println("Digite o ID do empregado: ");
                ace.setIdEmp(in.nextLong());
                System.out.println("Digite o nome: ");
                ace.setNm(in.next());
                System.out.println("Digite a descrição: ");
                ace.setDesc(in.next());
                System.out.println("Digite o tipo: ");
                ace.setTipo(in.next());
                System.out.println("Digite a status:");
                ace.setStatus(in.next());
                dao.inserir(ace);
                System.out.println("Inserido no Banco de Dados!!!");
                System.out.println("");
            }

        }

    }
}
