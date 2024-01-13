// Version: 1.0
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Veiculo extends VeiculoTeste {
    private int idCliente;
    private  int id;
    private static int nextId = 0;
    private String modelo;
    private int ano;
    private String marca;
    private String numeroChassis;
    private  Origem origem;
    protected String historicoSinistros;
    private String campanha;

    private TipoVeiculo tipo;

    private int preco;

    private String matricula;






    protected Veiculo(int idCliente, String modelo, int ano, String marca, String numeroChassis, Origem origem, int preco, String matricula) {
        id = nextId++;
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
        this.numeroChassis = numeroChassis;
        this.origem = origem;
        this.idCliente = idCliente;
        this.historicoSinistros = "";
        this.preco = preco;
        this.matricula = matricula;

        SerenidadeSeguros.veiculosPrincipal.add(this);
    }


    protected int getId() {
        return id;
    }





    protected int getIdCliente() {
        return idCliente;
    }

    protected void setCampanha(String campanha) {
        this.campanha = campanha.trim();
    }
    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }


    public TipoVeiculo getTipo() {
        return tipo;
    }


    public  Origem getOrigem() {
        return Origem.valueOf(String.valueOf(origem)); // Supondo que 'origem' seja uma string representando a origem
    }

    protected String getHistoricoSinistros() {
        return historicoSinistros;
    }

    private static TipoVeiculo getTipoById(int idVeiculo) {
        for (Veiculo veiculo : SerenidadeSeguros.getVeiculosPrincipal()) {
            if (veiculo.getId() == idVeiculo) {
                return veiculo.getTipo();
            }
        }
        // Caso o veículo não seja encontrado, retorne um valor padrão ou trate de acordo com sua lógica.
        return TipoVeiculo.DEFAULT; // Substitua 'TipoVeiculo.DEFAULT' pelo valor desejado.
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNumeroChassis() {
        return numeroChassis;
    }

    @Override
        public String toString () {
            return "Veiculo:" + "modelo=" + modelo + ", id" + id + ", ano=" + ano + ", marca=" + marca + ", numeroChassis=" + numeroChassis+ ", origem=" + origem.getDescricao() + ", historico de sinistros=" + historicoSinistros + ", campanha atual=" + campanha + ", preco=" + preco + ", tipo=" + tipo + ", matricula=" + matricula;
        }

    @Override
    public double getDepreciationFactor() {
        // Calcular a idade do veículo em meses

        TipoVeiculo tipoVeiculo = getTipoById(id);

        LocalDate dataAtual = LocalDate.now();
        long mesesDeUso = ChronoUnit.MONTHS.between(LocalDate.of(ano, 1, 1), dataAtual);
        long anosDeUso = ChronoUnit.YEARS.between(LocalDate.of(ano,1,1), dataAtual);
        long desvalorizacao=(preco* anosDeUso)/ 100;
        long desvalorizacaoMes=((preco* mesesDeUso)/ 100)+50;
        String tipo = tipoVeiculo.toString();
        // Calcular o fator de desvalorização com base no tipo de veículo
        if(tipo.equals(TipoVeiculo.LIGEIRO_MERCADORIAS.toString())){
            System.out.println("anos de uso="+ anosDeUso);
            System.out.println("Desvalorização=" + anosDeUso + "%");
            System.out.println("preco base=" + preco + "=> "+anosDeUso + "%"  + "="+ desvalorizacao + "/ano:"+desvalorizacao+"/12 =" + (desvalorizacao/12) + "/mes" );

        }


        if(tipo.equals(TipoVeiculo.LIGEIRO_PASSAGEIROS.toString())) {

            System.out.println("anos de uso=" + anosDeUso);
            System.out.println("Desvalorização=" + anosDeUso + "%");
            System.out.println("preco base=" + preco + "=> " + anosDeUso + "%" + "=" + desvalorizacao + "/ano:" + desvalorizacao + "/12 =" + (desvalorizacao / 12) + "/mes");

        }
        if(tipo.equals(TipoVeiculo.MOTOCICLO.toString())) {
            System.out.println("1% por cada mes de idade");
        }
        if(tipo.equals(TipoVeiculo.PESADO.toString())) {
            System.out.println("por cada mês de idade 50€ + 1%");
            System.out.println("Desvalorização=" + desvalorizacaoMes + "%");
            System.out.println("preco base=" + preco + "=> "+ mesesDeUso + "%"  + "="+ desvalorizacaoMes);

        }


        return 0;

    }

    @Override
    public double getCurrentValue() {
        TipoVeiculo tipoVeiculo = getTipoById(id);
        // Calcular o valor atual do veículo com base no fator de desvalorização
        LocalDate dataAtual = LocalDate.now();
        long mesesDeUso = ChronoUnit.MONTHS.between(LocalDate.of(ano, 1, 1), dataAtual);
        long anosDeUso = ChronoUnit.YEARS.between(LocalDate.of(ano, 1, 1), dataAtual);
        long desvalorizacao = (preco * anosDeUso) / 100;
        long desvalorizacaoMes = (mesesDeUso * 50) + (preco / 100);

        // Calcular o fator de desvalorização com base no tipo de veículo
        switch (tipoVeiculo) {
            case LIGEIRO_PASSAGEIROS:
            case LIGEIRO_MERCADORIAS:
                return Math.max(0, preco - desvalorizacao);
            case MOTOCICLO:
                return Math.max(0, preco - ((double) (preco * mesesDeUso) / 100));
            case PESADO:
                return Math.max(0, preco - desvalorizacaoMes);
            default:
                System.out.println("erro tipo de veículo não reconhecido");
        }
        return 0;
    }

}