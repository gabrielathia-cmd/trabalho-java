package Classes;
import java.util.ArrayList;

public class Pedidos {
    private String espetaculo;
    private double valorTotal;
    private ArrayList<Integer> Assentos;
    private ArrayList<Entrada> Entrada;

    //? Construtores

    public Pedidos(String espetaculo) {
        this.espetaculo = espetaculo;
        this.valorTotal = 0.0;
        this.Assentos = new ArrayList<Integer>();
        this.Entrada = new ArrayList<Entrada>();
    }

    //? Getters e Setters

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ArrayList<Integer> getAssentos(){
        return this.Assentos;
    }

    public ArrayList<Entrada> getEntradas(){
        return this.Entrada;
    }

    //? Métodos
    
    public void addEntrada(int assento, double valor, int entrada) {
        if(entrada == 1) {
            this.Assentos.add(assento);
            EntradaInteira Entrada = new EntradaInteira();
            Entrada.calcularValor(valor, assento);
        }
        if(entrada == 2) {
            this.Assentos.add(assento);
            EntradaMeia Entrada = new EntradaMeia();
            Entrada.calcularValor(valor, assento);
        }
        if(entrada == 3) {
            this.Assentos.add(assento);
            EntradaProfessor Entrada = new EntradaProfessor();
            Entrada.calcularValor(valor, assento);
        }
    }

    @Override
    public String toString() {
    return "Espetáculo: " + espetaculo + "Valor Total: R$" + valorTotal;
    }
}
