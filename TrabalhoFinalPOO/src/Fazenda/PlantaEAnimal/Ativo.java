package Fazenda.PlantaEAnimal;

import Fazenda.Informacoes.Inventario;
import Fazenda.Informacoes.Lotes;
import Fazenda.Informacoes.TipoLote;

public interface Ativo{
    public void coletar(Inventario inventario, Lotes lotes);

    TipoLote getTipo();

    boolean prontoParaColeta();

}
