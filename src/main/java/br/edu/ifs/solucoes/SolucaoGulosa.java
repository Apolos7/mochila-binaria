package br.edu.ifs.solucoes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolucaoGulosa {

    // Escolher os itens mais leves primeiro
    // Escolher os itens com maior valor primeiro
    // Escolher os itens com base na razão entre o valor e o peso de cada item

    public static void main(String[] args) {
        List<Item> listaItens = new ArrayList<>();
        listaItens.add(new Item(70, 31));
        listaItens.add(new Item(10, 6));
        listaItens.add(new Item(7, 4));
        listaItens.add(new Item(39, 20));
        listaItens.add(new Item(37, 19));
        listaItens.add(new Item(5, 3));
        listaItens.add(new Item(20, 10));

        listaItens.sort(Comparator.comparingDouble(Item::getRazao).reversed());

        int resultado = mochilaBinariaRecursiva(listaItens, 0, 50);
        System.out.println(resultado);

        resultado = mochilaBinaria(listaItens, 50);
        System.out.println(resultado);
    }

    private static int mochilaBinaria(List<Item> itens, int pesoMaxMochila) {
        int pesoAtualMochila = 0;
        int valorAtualMochila = 0;

        for (Item item : itens) {
            if ((item.peso() + pesoAtualMochila) < pesoMaxMochila) {
                pesoAtualMochila += item.peso();
                valorAtualMochila += item.valor();
                continue;
            }
            break;
        }
        return valorAtualMochila;
    }

    private static int mochilaBinariaRecursiva(List<Item> listaItens, int index, int pesoMochila) {
        if (pesoMochila == 0 || index >= listaItens.size()) {
            return 0;
        }

        Item item = listaItens.get(index);
        if (item.peso() > pesoMochila) {
            return 0;
        }
        return item.valor() + mochilaBinariaRecursiva(listaItens, index + 1, pesoMochila - item.peso());
    }
}
