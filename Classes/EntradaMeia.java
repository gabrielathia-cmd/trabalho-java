package Classes;

public class EntradaMeia extends Entrada {
    public double calcularValor(double valor, int assento) {
        setAssento(assento);
        return valor * 0.50;
    }
}
