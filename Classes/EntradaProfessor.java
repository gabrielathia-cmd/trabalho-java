package Classes;

public class EntradaProfessor extends Entrada {
    public double calcularValor(double valor, int assento) {
        setAssento(assento);
        return valor * 0.60;
    }
}
