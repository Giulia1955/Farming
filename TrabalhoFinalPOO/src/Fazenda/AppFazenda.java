package Fazenda;
import java.util.*;


public class AppFazenda {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Lotes lotes = new Lotes();
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();
        Controle controle = new Controle();
        Dinheiro dinheiro = new Dinheiro();
        EstadoJogo estado = new EstadoJogo(inventario,dinheiro,lotes);


        while(controle.isJogoAcontecendo()){
            controle.atualizarDados(lotes, loja);
            controle.exibirResumoDiario(inventario, lotes, loja);
            while(!controle.isPulouDia()){
                controle.exibirEscolhas();
                controle.tratarEscolha(scanner, inventario, lotes, loja);
            }
        }
    }
}
