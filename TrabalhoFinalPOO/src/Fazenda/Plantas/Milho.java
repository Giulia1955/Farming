package Fazenda.Plantas;

import Fazenda.*;
import Fazenda.Itens.sementeMilho;

import java.util.ArrayList;

public class Milho extends Planta implements Ativo {
    public Milho() {
        super(false, false, new sementeMilho(), "Milho", 5, 7);
    }

    public TipoLote getTipo(){
        return TipoLote.MILHO;
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
            if (ativo instanceof Milho milho && milho.isEstado()) {
                inventario.adicionar(milho.getItemProduzido(), milho.getQuantidadeProducao());
                lista.remove(i);
                System.out.println(milho.getNome() + " colhido com sucesso!");
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
            Ativo ativo = new Milho();
            lotes.adicionar(ativo);
            System.out.println(this.getItemProduzido().getNome() + " plantado com sucesso.");
        }
    }
}
