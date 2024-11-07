// Arquivo: Pedido.java
import java.io.*;
import java.util.*;

class Pedido {
    private String id;
    private Cliente cliente;
    private String data;
    private List<Joia> itens;
    private double valor;
    private String status;

    public Pedido(String id, Cliente cliente, String data, List<Joia> itens, double valor, String status) {
        this.id = id;
        this.cliente = cliente;
        this.data = data;
        this.itens = itens;
        this.valor = valor;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toString() {
        String itensStr = String.join(";", itens.stream().map(Object::toString).toArray(String[]::new));
        return String.join(",", id, cliente.toString(), data, itensStr, String.valueOf(valor), status);
    }

    public void salvar() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pedidos.csv", true))) {
            bw.write(this.toString() + "\n");
        }
    }
}
