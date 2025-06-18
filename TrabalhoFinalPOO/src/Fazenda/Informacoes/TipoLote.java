package Fazenda.Informacoes;

/**
 * Enumeração que representa os diferentes tipos de lotes disponíveis na fazenda.
 * Inclui animais e cultivos como galinhas, ovelhas, vacas, milho, soja e trigo.
 */
public enum TipoLote {
    GALINHA, OVELHA, VACA, MILHO, SOJA, TRIGO;

    /**
     * Constante que armazena a quantidade total de tipos de lotes existentes.
     * Útil para percorrer ou validar os tipos de lotes dinamicamente.
     */
    public static final int TAMANHO = values().length;
}

