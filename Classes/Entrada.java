package Classes;

public abstract class Entrada {
    private int numeroDoAssento;

    public int getAssento() {
        return this.numeroDoAssento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }

    public  abstract double calcularValor(double valor, int assento);

}
