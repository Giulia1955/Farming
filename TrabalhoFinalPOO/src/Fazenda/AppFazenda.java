package Fazenda;
import Fazenda.Itens.Item;
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
        int valorRandomico, dias;
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        EventoRandomico evento = new EventoRandomico();
        Dinheiro dinheiro = new Dinheiro();

        System.out.println("Bem vindo à fazenda BUSiness Farm!"
                + "Por quantos dias você gostaria de ser nosso fazendeiro? ");
        // inserir aqui um try/catch para garantir que a entrada seja de fato um int
        dias = scanner.nextInt();

        for (int i = 0; i < dias; i++){
            // inserir aqui os processos padrões de cada dia
            valorRandomico = rand.nextInt(10);
            evento.executarEvento(valorRandomico, i, dinheiro);
        }

    }
}
