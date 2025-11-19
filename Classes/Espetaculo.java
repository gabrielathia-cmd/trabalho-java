package Classes;

import java.util.ArrayList;

public class Espetaculo {
    private String nome;
    private String data;
    private String hora;
    private double valor;
    private boolean[][] cadeiras;

    //? Construtores
    public Espetaculo(String nome, String data, String hora, double valor) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.cadeiras = new boolean[][] {
        {true, true, true, true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true, true}
        };
    }
    
    //? Getters e Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String getData(){
        return this.data;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public String getHora() {
        return this.hora;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public double getValor() {
        return this.valor;
    }

    //? Métodos

    public String infoEspet() {
        return nome + "\t" + data + "\t" + hora + "\tR$ " + valor;
    }

    public void mostrarCadeiras() {
        int contadorCadeiras = 1;
        System.out.println("Assentos Disponíveis");
        for(int i = 0; i < this.cadeiras.length; i++) {
            for(int j = 0; j < this.cadeiras[i].length; j++) {
                if(this.cadeiras[i][j] == true && contadorCadeiras < 10) {
                    System.out.print("0" + contadorCadeiras + " ");
                }
                else if(this.cadeiras[i][j] == true) {
                    System.out.print(contadorCadeiras + " ");
                } else {
                    System.out.print("XX ");
                }
                contadorCadeiras++;
            }
            System.out.print("\n");
        }
    }

    public boolean verificarCadeira(int c) {
        int contadorCadeiras = 1;
        for(int i = 0; i < this.cadeiras.length; i++) {
            for(int j = 0; j < this.cadeiras[i].length; j++) {
                if(contadorCadeiras == c && this.cadeiras[i][j] == true){
                    return true;
                } else if(contadorCadeiras == c && this.cadeiras[i][j] == false) {
                    return false;
                }
                contadorCadeiras++;
            }
        }
        return false;
    }

    public void atualizarCadeiras(ArrayList<Integer> cadeiras) {
        for(int ic = 0; ic < cadeiras.size(); ic++) {
            int contadorCadeiras = 0;
            int cadeira = cadeiras.get(ic);
            for(int i = 0; i < this.cadeiras.length; i++) {
                for(int j = 0; j < this.cadeiras[i].length; j++) {
                    contadorCadeiras++;
                    if(contadorCadeiras == cadeira && this.cadeiras[i][j] == true) {
                        this.cadeiras[i][j] = false;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Espetáculo: " + this.nome + "    |    Valor: " + this.valor;
    }
}
