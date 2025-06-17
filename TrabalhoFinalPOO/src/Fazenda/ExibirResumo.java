package Fazenda;

import Fazenda.Informacoes.Dinheiro;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;

public class ExibirResumo {
    Controle controle = new Controle();
    public void exibirResumoDiario(Inventario inventario, Lotes lotes, Loja loja, Dinheiro dinheiro, EventoRandomico evento) {
        String borda = "═".repeat(70);
        System.out.println();
        System.out.println("╔" + borda + "╗");
        System.out.printf("║%-70s║%n", "                🌄 RESUMO DO DIA " + controle.dias + " NA BUSFARM 🌄");
        System.out.println("╠" + borda + "╣");

        if(controle.dias != 1){
            evento.executarEvento(dinheiro, inventario);
        }

        if (controle.controleMortes[0] > 0) {
            System.out.println("🐔 " + controle.controleMortes[0] + " galinha(s) morreram");
        }
        if (controle.controleMortes[1] > 0) {
            System.out.println("🐑 " + controle.controleMortes[1] + " ovelha(s) morreram");
        }
        if (controle.controleMortes[2] > 0) {
            System.out.println("🐄 " + controle.controleMortes[2] + " vaca(s) morreram");
        }
        if (controle.controleMortes[3] > 0) {
            System.out.println("🌽 " + controle.controleMortes[3] + " milho(s) morreram");
        }
        if (controle.controleMortes[4] > 0) {
            System.out.println("🌱 " + controle.controleMortes[4] + " soja(s) morreram");
        }
        if (controle.controleMortes[5] > 0) {
            System.out.println("🌾 " + controle.controleMortes[5] + " trigo(s) morreram");
        }

        System.out.printf("║ %-68s ║%n", "💰 Dinheiro disponível: R$ " + dinheiro.getValor());

        System.out.println("╠" + borda + "╣");
        System.out.printf("║%-70s║%n", " 📦 Inventário:");
        System.out.println("╟" + "-".repeat(70) + "╢");
        inventario.imprimirInventario();

        System.out.println("╠" + borda + "╣");
        System.out.printf("║%-70s║%n", " 🚜 Lotes:");
        System.out.println("╟" + "-".repeat(70) + "╢");
        lotes.imprimirLotes(lotes);

        System.out.println("╚" + borda + "╝");
    }
}
