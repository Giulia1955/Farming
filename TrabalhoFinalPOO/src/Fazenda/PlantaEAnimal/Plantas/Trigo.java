package Fazenda.PlantaEAnimal.Plantas;

import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;
import Fazenda.Informacoes.TipoLote;
import Fazenda.PlantaEAnimal.Ativo;
import Fazenda.Itens.sementeTrigo;

import java.util.ArrayList;

public class Trigo extends Planta implements Ativo {
    public Trigo() {
        super(false, new sementeTrigo(), "Trigo", 3, 10);
    }

    public TipoLote getTipo(){
        return TipoLote.TRIGO;
    }

    public void coletar(Inventario inventario, Lotes lotes) {
        if (!lotes.temDisponivel(this.getTipo())) {
            System.out.println("Não há " + this.getNome() + " plantado");
            return;
        }

        int index = this.getTipo().ordinal();
        ArrayList<Ativo> lista = lotes.getLotes()[index];

        for (int i = 0; i < lista.size(); i++) {
            Ativo ativo = lista.get(i);
            if (ativo instanceof Trigo trigo && trigo.prontoParaColeta()) {
                inventario.adicionar(trigo.getItemProduzido(), trigo.getQuantidadeProducao());
                lista.remove(i);
                System.out.println(trigo.getNome() + " colhido com sucesso!");
                return;
            }
        }
        System.out.println(this.getNome() + " ainda não está pronto para colheita");
    }

    public boolean prontoParaColeta() {
        return this.getDiasParaProduzir() <= 0;
    }

    @Override
    public void plantar(Lotes lotes, Inventario inventario) {
        if(lotes.estaCheio()){
            System.out.println("Não há lotes disponíveis.");
            return;
        }
        if(inventario.remover(this.getItemProduzido(), 1)){
            Ativo ativo = new Trigo();
            lotes.adicionar(ativo);
            System.out.println(this.getItemProduzido().getNome() + " plantado com sucesso.");
        }
    }

    @Override
    public String toString(){
        return getNome() + ":\n" +
                "   Quanto produz: " + getQuantidadeProducao() + " sementes de trigo\n" +
                "   Dias para produzir: " + getDiasParaProduzir() + "\n" +
                "   Esta com sede? " + (this.isSede() ? "Sim" : "Não");
    }
}
