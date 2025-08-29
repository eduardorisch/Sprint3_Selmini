package Conexão;

import Modelos.Acesso;
import Modelos.AcessoDAO;
import Modelos.Etapa;
import Modelos.EtapaDAO;

import java.util.Scanner;

public class mainEtapa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        EtapaDAO dao = new EtapaDAO();
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
                Etapa eta = new Etapa();
                System.out.println("Digite o ID: ");
                eta.setId(in.nextLong());
                System.out.println("Digite o nome: ");
                eta.setNome(in.next());
                System.out.println("Digite a descrição: ");
                eta.setDesc(in.next());
                System.out.println("Digite quantos pontos base: ");
                eta.setPontos(in.nextLong());
                System.out.println("Digite o status: ");
                eta.setStatus(in.next());
                dao.inserir(eta);
                System.out.println("Inserido no Banco de Dados!!!");
                System.out.println("");
            }

        }
    }
}
