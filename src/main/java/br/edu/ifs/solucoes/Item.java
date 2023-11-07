package br.edu.ifs.solucoes;

public record Item(int valor, int peso) {

    double getRazao() {
        return (double) valor / peso;
    }

    @Override
    public String toString() {
        return "Item{valor=" + valor + ", peso=" + peso + ", razao=" + getRazao() + "}";
    }
}