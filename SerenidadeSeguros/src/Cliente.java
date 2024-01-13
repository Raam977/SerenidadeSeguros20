

public class Cliente {
    private int id;
    private static int nextId;
    private String nome;
    private int contato;
    private String email;
    private String morada;




    protected Cliente(String nome, int contato, String email, String morada) {
        this.id = nextId++;
        this.nome = nome;
        this.contato = contato;
        this.email = email;
        this.morada = morada;
       SerenidadeSeguros.clientes.add(this);
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected void setContato(int contato) {
        this.contato = contato;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected void setMorada(String morada) {
        this.morada = morada;
    }

    protected int getId() {
        return id;
    }






    @Override
    public String toString() {
        return "Cliente:" + "nome=" + nome + ", id=" + id + ", contato=" + contato + ", email=" + email + ", morada=" + morada;
    }
}
