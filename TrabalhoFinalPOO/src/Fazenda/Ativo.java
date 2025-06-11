package Fazenda;
import Fazenda.Produto;

public interface Ativo{
    public void coletar(Inventario inventario, Lotes lotes);

    TipoLote getTipo();

    boolean prontoParaColeta();
}
