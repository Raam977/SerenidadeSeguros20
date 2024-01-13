public enum TipoVeiculo {
    PESADO("Pesado"),
    LIGEIRO_MERCADORIAS("Ligeiro de Mercadorias"),
    LIGEIRO_PASSAGEIROS("Ligeiro de Passageiros"),
    MOTOCICLO("Motociclo"),

    DEFAULT("Desconhecido");

    private final String descricao;

    TipoVeiculo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}