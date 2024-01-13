// Version: 1.0

public class Campanha {
    private String nome;
    private String descricao;
    private int desconto;
    private int id;
    private boolean sinistros;

    private static int nextId;




    protected Campanha(String nome, String descricao, int desconto, boolean sinistros) {
        this.nome = nome;
        this.descricao = descricao;
        this.desconto = desconto;
        this.id = nextId++;
        this.sinistros = sinistros;

    }

    protected String getNome() {
        return nome;
    }

    protected String getDescricao() {
        return descricao;
    }

    protected int getDesconto() {
        return desconto;
    }

    protected int getId() {
        return id;
    }

    public boolean isSinistros() {
        return sinistros;
    }




    protected static void getCampanhas() {
        for (Campanha campanha : SerenidadeSeguros.campanhas) {
            System.out.printf("Campanha=%s, descrição=%s, id=%d, aceita sinistros=%b, desconto=%d%n",
                    campanha.getNome(), campanha.getDescricao(), campanha.getId(),
                    campanha.isSinistros(), campanha.getDesconto());
        }
    }




}
