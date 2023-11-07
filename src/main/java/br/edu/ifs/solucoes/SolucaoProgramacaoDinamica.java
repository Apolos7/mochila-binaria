package br.edu.ifs.solucoes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolucaoProgramacaoDinamica {
    public static void main(String[] args) {
        List<Item> listaItens = new ArrayList<>();
        listaItens.add(new Item(70, 31));
        listaItens.add(new Item(20, 10));
        listaItens.add(new Item(39, 20));
        listaItens.add(new Item(37, 19));
        listaItens.add(new Item(7, 4));
        listaItens.add(new Item(5, 3));
        listaItens.add(new Item(10, 6));

        int resultado = mochilaBinariaRecursiva(listaItens, 0, 50, new HashMap<>());
        System.out.println(resultado);
    }

    static int mochilaBinariaRecursiva(List<Item> itens, int index, int pesoMochila, Map<String, Integer> mapCalculado) {
        String chave = index + "_" + pesoMochila;
        if (mapCalculado.containsKey(chave)) { // Caso já tenha sido processado, retorna o valor
            return mapCalculado.get(chave);
        }

        // Caso base: Caso não exista mais itens ou a mochila não suporta mais peso
        if (pesoMochila == 0 || index == itens.size()) {
            return 0;
        }

        Item item = itens.get(index);
        if (item.peso() > pesoMochila) { // Caso o item tenha um peso maior que o tamanho da mochila, pula para o próximo
            return mochilaBinariaRecursiva(itens, index + 1, pesoMochila, mapCalculado);
        }

        int valorAdicionando = item.valor() + mochilaBinariaRecursiva(itens, index + 1, pesoMochila - item.peso(), mapCalculado);
        int valorNaoAdicionando = mochilaBinariaRecursiva(itens, index + 1, pesoMochila, mapCalculado);

        int maxValor = Math.max(valorAdicionando, valorNaoAdicionando);
        mapCalculado.put(chave, maxValor); // Coloca o valor processado no map

        // Retorna a posição que trás o maior valor
        return maxValor;
    }

}
