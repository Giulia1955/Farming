package Fazenda;
import Fazenda.Produto;
import java.io.Serializable;

public interface Ativo{
    public void coletar(Inventario inventario, Lotes lotes);

    TipoLote getTipo();

    boolean prontoParaColeta();

}
