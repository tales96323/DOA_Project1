// Arquivo: Joia.java
import java.io.*;

abstract class Joia {
    protected String id;
    protected String nome;
    protected String tipo;
    protected String material;
    protected double peso;
    protected double preco;
    protected int quantidadeEstoque;
    protected String classificacao;

    public Joia(String id, String nome, String tipo, String material, double peso, double preco, int quantidadeEstoque, String classificacao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.material = material;
        this.peso = peso;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.classificacao = classificacao;
    }

    public abstract String detalhesExtras();

    public String toString() {
        return String.join(",", id, nome, tipo, material, String.valueOf(peso), String.valueOf(preco), String.valueOf(quantidadeEstoque), classificacao, detalhesExtras());
    }

    public void salvar() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("joias.csv", true))) {
            bw.write(this.toString() + "\n");
        }
    }
}

class Colar extends Joia {
    private double comprimento;

    public Colar(String id, String nome, String material, double peso, double preco, int quantidadeEstoque, String classificacao, double comprimento) {
        super(id, nome, "Colar", material, peso, preco, quantidadeEstoque, classificacao);
        this.comprimento = comprimento;
    }

    @Override
    public String detalhesExtras() { return String.valueOf(comprimento); }
}

class Brinco extends Joia {
    private String tipoDeFecho;

    public Brinco(String id, String nome, String material, double peso, double preco, int quantidadeEstoque, String classificacao, String tipoDeFecho) {
        super(id, nome, "Brinco", material, peso, preco, quantidadeEstoque, classificacao);
        this.tipoDeFecho = tipoDeFecho;
    }

    @Override
    public String detalhesExtras() { return tipoDeFecho; }
}

class Anel extends Joia {
    private int tamanho;

    public Anel(String id, String nome, String material, double peso, double preco, int quantidadeEstoque, String classificacao, int tamanho) {
        super(id, nome, "Anel", material, peso, preco, quantidadeEstoque, classificacao);
        this.tamanho = tamanho;
    }

    @Override
    public String detalhesExtras() { return String.valueOf(tamanho); }
}
