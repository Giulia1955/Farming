package Fazenda.Plantas;

import Fazenda.*;
import Fazenda.Itens.SementeSoja;

import java.util.ArrayList;

public class Soja extends Planta implements Ativo {
    public Soja() {
        super(false, false, new SementeSoja(), "Soja", 10, 4);
    }

    public TipoLote getTipo(){
        return TipoLote.SOJA;
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
            if (ativo instanceof Soja soja && soja.isEstado()) {
                inventario.adicionar(soja.getItemProduzido(), soja.getQuantidadeProducao());
                lista.remove(i);
                System.out.println(soja.getNome() + " colhido com sucesso!");
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
            Ativo ativo = new Soja();
            lotes.adicionar(ativo);
            System.out.println(this.getItemProduzido().getNome() + " plantado com sucesso.");
        }

    }
}
