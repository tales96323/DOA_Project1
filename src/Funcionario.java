// Arquivo: Funcionario.java
import java.io.*;
import java.util.*;

abstract class Funcionario {
    protected String id;
    protected String nome;
    protected String nif;
    protected String dataContrato;
    protected double salario;
    protected double metaVendas;

    public Funcionario(String id, String nome, String nif, String dataContrato, double salario, double metaVendas) {
        this.id = id;
        this.nome = nome;
        this.nif = nif;
        this.dataContrato = dataContrato;
        this.salario = salario;
        this.metaVendas = metaVendas;
    }

    public abstract String getTipo();

    public String toString() {
        return String.join(",", id, nome, nif, dataContrato, String.valueOf(salario), String.valueOf(metaVendas), getTipo());
    }

    public void salvar() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("funcionarios.txt", true))) {
            bw.write(this.toString() + "\n");
        }
    }
}

class Dono extends Funcionario {
    public Dono(String id, String nome, String nif, String dataContrato, double salario, double metaVendas) {
        super(id, nome, nif, dataContrato, salario, metaVendas);
    }

    @Override
    public String getTipo() { return "Dono"; }
}

class Gerente extends Funcionario {
    public Gerente(String id, String nome, String nif, String dataContrato, double salario, double metaVendas) {
        super(id, nome, nif, dataContrato, salario, metaVendas);
    }

    @Override
    public String getTipo() { return "Gerente"; }
}

class Vendedor extends Funcionario {
    public Vendedor(String id, String nome, String nif, String dataContrato, double salario, double metaVendas) {
        super(id, nome, nif, dataContrato, salario, metaVendas);
    }

    @Override
    public String getTipo() { return "Vendedor"; }
}
