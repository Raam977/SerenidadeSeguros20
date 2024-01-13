public enum Origem {
    IMPORTADO("Importado"),
    NACIONAL("Nacional");

    private final String descricao;

    Origem(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
