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
        EventosDiarios eventosDiarios = new EventosDiarios();
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do{
            eventosDiarios.exibir();
            System.out.println("Digite o que você quer fazer:");
            System.out.println("1 - ");
            System.out.println("2 - ");
            System.out.println("3 - ");
            System.out.println("4 - ");
            System.out.println("5 - ");
            System.out.println("6 - ");
            System.out.println("7 - ");
            escolha = scanner.nextInt();

        }

    }
}
