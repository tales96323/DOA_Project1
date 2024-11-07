// Arquivo: Cliente.java
import java.io.*;

class Cliente {
    private String id;
    private String nome;
    private String nif;
    private String email;
    private String telefone;
    private String endereco;

    public Cliente(String id, String nome, String nif, String email, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.nif = nif;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String toString() {
        return String.join(",", id, nome, nif, email, telefone, endereco);
    }

    public void salvar() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("clientes.txt", true))) {
            bw.write(this.toString() + "\n");
        }
    }
}
