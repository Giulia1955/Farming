package Fazenda;

import Fazenda.Itens.*;
import java.util.*;

public class EventoRandomico {
    Random random = new Random();

    public void executarEvento(Dinheiro dinheiro, Inventario inventario) {
        int numAleatorio = random.nextInt(20);
        switch (numAleatorio) {
            case 0: VacaPrenha(inventario); break;
            case 1: OvelhaPrenha(inventario); break;
            case 2: GalinhaChoca(inventario); break;
            case 3: Emprestimo(dinheiro); break;
            case 4: EncontrouMilho(inventario); break;
            case 5: EncontrouSoja(inventario); break;
            case 6: EncontrouTrigo(inventario); break;
        }
    }

    public void VacaPrenha(Inventario inventario) {
        System.out.println("Há uma vaca prenha! Reserve espaço para o novo membro da fazenda!");
        inventario.adicionar(new filhoteVaca(), 1);
    }

    public void OvelhaPrenha(Inventario inventario) {
        System.out.println("Há uma ovelha prenha! Reserve espaço para o novo membro da fazenda!");
        inventario.adicionar(new filhoteOvelha(), 1);
    }

    public void GalinhaChoca(Inventario inventario) {
        System.out.println("Há uma galinha chocando! Reserve espaço para o novo membro da fazenda!");
        inventario.adicionar(new filhoteGalinha(), 1);
    }

    public void Emprestimo(Dinheiro dinheiro) {
        System.out.println("Um vizinho devolveu um empréstimo de R$ 150,00 que você havia esquecido.");
        dinheiro.setValor(dinheiro.getValor() + 150.0);
    }

    public void EncontrouSoja(Inventario inventario){
        System.out.println("Ao limpar o celeiro, você encontrou um pacote esquecido de soja.");
        inventario.adicionar(new sementeSoja(), 3);
    }

    public void EncontrouTrigo(Inventario inventario){
        System.out.println("Você encontrou um pacote de sementes de trigo no fundo da gaveta.");
        inventario.adicionar(new sementeTrigo(), 3);
    }
    public void EncontrouMilho(Inventario inventario){
        System.out.println("Sua vizinha lhe deu um pacote de milho em troca de mudas de hortelã.");
        inventario.adicionar(new sementeMilho(), 3);
    }
}
