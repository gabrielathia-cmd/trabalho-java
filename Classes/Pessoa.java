package Classes;

import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String cpf;
    private Double valores;
    private Pedidos Pedido;
    private ArrayList<Pedidos> Pedidos;
    //? Construtores
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.Pedidos = new ArrayList<Pedidos>();
    }

    //? Getters e Setters

    public String getNome() {return this.nome;}
    
    public void setNome(String nome) {this.nome = nome;}
    
    public String getCpf() {return this.cpf;}
    
    public void setCpf(String cpf) {this.cpf = cpf;}

    public double getValores() {return this.valores;}

    public Pedidos getPedido() {return this.Pedido;}
    
    //? Métodos

    public void criarPedio(String espetaculo) {
        this.Pedido = new Pedidos(espetaculo);
    }

    public void addAssentos(int dr) {
        getPedido().addAssentos(dr);
    }

    public ArrayList<Integer> getAssentos() {
        return getPedido().getAssentos();
    }

    public void clearPedido() {
        getPedido().setValorTotal(0.0);
        getPedido().getAssentos().clear();
    }

    public void clearValores() {
        this.valores = 0.0;
    }

    public void finalizarPedido(Pedidos Pedido) {
        this.Pedidos.add(Pedido);
    }

    @Override
    public String toString() {
        return "Nome Pessoa: " + this.nome;
    }
}
