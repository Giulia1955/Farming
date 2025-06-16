package Fazenda.Animais;
import Fazenda.*;
import Fazenda.Itens.filhoteGalinha;
import Fazenda.Itens.sementeMilho;
import Fazenda.Itens.Ovo;
import java.io.Serializable;

import java.util.ArrayList;

public class Galinha extends Animal implements Ativo {
    public Galinha() {
        super("Galinha", new Ovo(), false, 10, new sementeMilho(), 1, 3, 1, new filhoteGalinha());
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
        if(!inventario.contem(this.getComida())){
            System.out.println("Não há comida para " + this.getNome() + " no inventario.");
            return;
        }

        int index = this.getTipo().ordinal();
        ArrayList<Ativo> lista = lotes.getLotes()[index];

        for (int i = 0; i < lista.size(); i++) {
            Ativo ativo = lista.get(i);
            if (ativo instanceof Galinha galinha && galinha.isFome()) {
                if((inventario.remover(galinha.getItemProduzido(), 1))){
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

    public String toString(){
        return getNome() + ":\n" +
                "   Vida: " + getVida() + " dias\n" +
                "   Quantidade que come: " + getQuantoCome() + " sementes de milho\n" +
                "   Quanto produz: " + getQuantidadeProducao() + " ovo(s)\n" +
                "   Dias para produzir o proximo ovo: " + getDiasParaProduzir() + "\n";
    }
}
