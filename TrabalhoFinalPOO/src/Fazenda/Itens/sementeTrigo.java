package Fazenda.Itens;
import Fazenda.Plantas.Planta;
/**
 * Representa a {@code sementeTrigo}, que é um tipo de {@link Item} produzido por plantas de Trigo.
 * Vem como uma única unidade de semente e pode ser vendida pelo jogador.
 *
 * Esta classe define um item com preço fixo e nome padrão.
 *
 * @author Giulia
 * @version 1.0
 */


public class sementeTrigo extends Item {
    public sementeTrigo(){
        /**
         * Construtor da classe {@code sementeTrigo}.
         * Inicializa uma semente de trigo com valor fixo, descrição e nome padrão.
         */
        super (4, "sementes de trigo", "Semente Trigo");
    }
}
