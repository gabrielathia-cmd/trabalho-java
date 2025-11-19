package Classes;

public class EntradaInteira extends Entrada {
    public double calcularValor(double valor, int assento) {
        setAssento(assento);
        return valor;
    }
}
