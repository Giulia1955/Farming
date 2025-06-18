package Fazenda.PlantaEAnimal.Animais;
import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;
import Fazenda.Informacoes.TipoLote;
import Fazenda.PlantaEAnimal.Ativo;
import Fazenda.Itens.FilhoteGalinha;
import Fazenda.Itens.SementeMilho;
import Fazenda.Itens.Ovo;

import java.util.ArrayList;

public class Galinha extends Animal implements Ativo {
    public Galinha() {
        super("Galinha", new Ovo(), false, 10, new SementeMilho(), 1, 3, new FilhoteGalinha());
    }

    public TipoLote getTipo(){
        return TipoLote.GALINHA;
    }

    public boolean prontoParaColeta() {
        return this.getDiasParaProduzir() <= 0;
    }

    public void coletar(Inventario inventario, Lotes lotes) {
        if (!lotes.temDisponivel(this.getTipo())) {
            System.out.println("Não há " + this.getNome() + " na fazenda");
            return;
        }

        int index = this.getTipo().ordinal();
        ArrayList<Ativo> lista = lotes.getLotes()[index];

        for (int i = 0; i < lista.size(); i++) {
            Ativo ativo = lista.get(i);
            if (ativo instanceof Galinha galinha && galinha.prontoParaColeta()) {
                inventario.adicionar(galinha.getItemProduzido(), galinha.getQuantidadeProducao());
                galinha.setDiasParaProduzir(this.getDiasParaProduzir());
                System.out.println(galinha.getItemProduzido().getNome() + " coletado com sucesso!");
                return;
            }
        }
        System.out.println("Nenhum(a) " + this.getNome() + " pronto para coleta");
    }

    public void alimentar(Inventario inventario, Lotes lotes) {
        if (!inventario.contem(this.getComida())) {
            System.out.println("Não há comida para " + this.getNome() + " no inventário.");
            return;
        }

        int index = this.getTipo().ordinal();
        ArrayList<Ativo> lista = lotes.getLotes()[index];

        for (int i = 0; i < lista.size(); i++) {
            Ativo ativo = lista.get(i);
            if (ativo instanceof Galinha galinha && galinha.isFome()) {
                if (inventario.remover(galinha.getComida(), 1)) {
                    galinha.setFome(false);
                    System.out.println(this.getNome() + " alimentado(a) com sucesso.");
                    return;
                }
            }
        }
        System.out.println("Nenhum(a) " + this.getNome() + " com fome.");
    }

    public void colocar(Inventario inventario, Lotes lotes) {
        if(lotes.estaCheio()){
            System.out.println("Não há lotes disponíveis.");
            return;
        }
        if(inventario.remover(this.getFilhote(), 1)){
            Ativo ativo = new Galinha();
            lotes.adicionar(ativo);
            System.out.println(this.getFilhote().getNome() + " colocado com sucesso, agora ele ja pode produzir!");
        }

    }

    @Override
    public String toString() {
        return getNome() + ":\n" +
                "   Vida: " + getVida() + " dias\n" +
                "   Come semente de milho\n" +
                "   Quanto produz: " + getQuantidadeProducao() + " ovo(s)\n" +
                "   Dias para produzir o próximo ovo: " + getDiasParaProduzir() + "\n" +
                "   Está com fome: " + (this.isFome() ? "Sim" : "Não");
    }
}
