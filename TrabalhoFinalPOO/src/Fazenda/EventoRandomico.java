package Fazenda;

import Fazenda.Informacoes.Dinheiro;
import Fazenda.Informacoes.Inventario;
import Fazenda.Itens.*;
import java.util.*;

public class EventoRandomico {
    Random random = new Random();

    public void executarEvento(Dinheiro dinheiro, Inventario inventario) {
        int numAleatorio = random.nextInt(40);
        switch (numAleatorio) {
            case 0: PresenteDeVaca(inventario); break;
            case 1: FeiraRuralOvelha(inventario); break;
            case 2: PresenteDaVovoGalinha(inventario); break;
            case 3: Emprestimo(dinheiro); break;
            case 4: MilhoDoCorreio(inventario); break;
            case 5: GanhouSojaFeira(inventario); break;
            case 6: EncontrouTrigo(inventario); break;
        }
    }

    public void PresenteDeVaca(Inventario inventario) {
        System.out.println("Um fazendeiro que se aposentou te presenteou com um filhote de vaca!");
        inventario.adicionar(new FilhoteVaca(), 1);
    }

    public void FeiraRuralOvelha(Inventario inventario) {
        System.out.println("Na feira rural, você ganhou um filhote de ovelha num sorteio!");
        inventario.adicionar(new FilhoteOvelha(), 1);
    }

    public void PresenteDaVovoGalinha(Inventario inventario) {
        System.out.println("Sua avó te trouxe um filhote de galinha como presente de visita!");
        inventario.adicionar(new FilhoteGalinha(), 1);
    }

    public void Emprestimo(Dinheiro dinheiro) {
        System.out.println("Um vizinho devolveu um empréstimo de R$ 150,00 que você havia esquecido.");
        dinheiro.setValor(dinheiro.getValor() + 150.0);
    }

    public void GanhouSojaFeira(Inventario inventario){
        System.out.println("Você participou de um quiz na feira da cidade e ganhou um pacote de sementes de soja!");
        inventario.adicionar(new SementeSoja(), 3);
    }

    public void EncontrouTrigo(Inventario inventario){
        System.out.println("Você encontrou um pacote de sementes de trigo no fundo da gaveta.");
        inventario.adicionar(new SementeTrigo(), 3);
    }
    public void MilhoDoCorreio(Inventario inventario){
        System.out.println("Uma amostra grátis de sementes de milho chegou pelo correio com uma revista de agricultura!");
        inventario.adicionar(new SementeMilho(), 3);
    }

}
