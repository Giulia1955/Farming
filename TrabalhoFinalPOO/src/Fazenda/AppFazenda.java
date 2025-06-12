package Fazenda;
import Fazenda.Itens.Item;
import Fazenda.Itens.sementeSoja;
import Fazenda.Plantas.Milho;
import Fazenda.Plantas.Planta;
import Fazenda.Plantas.Soja;
import Fazenda.Produto;
import Fazenda.Lotes;
import Fazenda.Inventario;
import Fazenda.EventoRandomico;
import Fazenda.Dinheiro;
import Fazenda.Ativo;
import java.util.*;


public class AppFazenda {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Lotes lotes = new Lotes();
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();

        System.out.println("Bem vindo à sua fazenda! Por quantos dias você irá jogar?");
        int dias = scanner.nextInt();

        EventosDiarios eventosDiarios = new EventosDiarios(dias);

        for (int i = 1; i <= dias; i++){
            //
        }


    }
}
