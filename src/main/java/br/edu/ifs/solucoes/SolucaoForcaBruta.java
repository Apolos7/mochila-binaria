package br.edu.ifs.solucoes;

import java.util.ArrayList;
import java.util.List;

public class SolucaoForcaBruta {
    public static void main(String[] args) {
        List<Item> listaItens = new ArrayList<>();
        listaItens.add(new Item(70, 31));
        listaItens.add(new Item(20, 10));
        listaItens.add(new Item(39, 20));
        listaItens.add(new Item(37, 19));
        listaItens.add(new Item(7, 4));
        listaItens.add(new Item(5, 3));
        listaItens.add(new Item(10, 6));

        int resultado = mochilaBinariaRecursiva(listaItens, 0, 50);
        System.out.println(resultado);
    }

    static int mochilaBinariaRecursiva(List<Item> itens, int index, int pesoMochila) {
        // Caso base: Caso não exista mais itens ou a mochila não suporta mais peso
        if (pesoMochila == 0 || index == itens.size()) {
            return 0;
        }

        Item item = itens.get(index);
        if (item.peso() > pesoMochila) { // Caso o item tenha um peso maior que o tamanho da mochila, pula para o próximo
            return mochilaBinariaRecursiva(itens, index + 1, pesoMochila);
        }

        int valorAdicionando = item.valor() + mochilaBinariaRecursiva(itens, index + 1, pesoMochila - item.peso());
        int valorNaoAdicionando = mochilaBinariaRecursiva(itens, index + 1, pesoMochila);
        // Retorna a posição que trás o maior valor valor
        return Math.max(valorAdicionando, valorNaoAdicionando);
    }
}
