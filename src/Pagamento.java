// Arquivo: Pagamento.java
import java.io.*;

class Pagamento {
    private double valor;
    private String data;
    private String metodoPagamento;

    public Pagamento(double valor, String data, String metodoPagamento) {
        this.valor = valor;
        this.data = data;
        this.metodoPagamento = metodoPagamento;
    }

    public String toString() {
        return String.join(",", String.valueOf(valor), data, metodoPagamento);
    }

    public void salvar() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pagamentos.csv", true))) {
            bw.write(this.toString() + "\n");
        }
    }
}
