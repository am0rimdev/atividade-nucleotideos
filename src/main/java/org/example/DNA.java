/*
* @description: Classe com o método para calcular a quantidade de nucleotídeos e o número de erros em uma sequência de DNA.
* @author Nifane Borges & Vinicius Alves Amorim
*/


package org.example;

import java.util.Objects;

public class DNA {
    /**
     * Calcula o número de nucleotídeos A, C, G e T e a quantidade de erros em uma sequência de DNA.
     *
     * @param sequenciaDNA A sequência de DNA em formato de String.
     * @return Um array de inteiros com 5 posições, contendo a contagem de A, C, G, T e erros, respectivamente.
     * Retorna null se a sequência for considerada inválida (erros > 10%).
     * @throws IllegalArgumentException Se a sequência de DNA for vazia.
     */
    public int[] calculoDeNucleotideos(String sequenciaDNA) {
        if (sequenciaDNA == null || sequenciaDNA.isEmpty()) {
            throw new IllegalArgumentException("sequencia de DNA vazia");
        }

        sequenciaDNA = sequenciaDNA.toUpperCase();

        int[] contagem = new int[5]; // Posições: [A, C, G, T, Erros]

        for (char nucleotideo: sequenciaDNA.toCharArray()) {
            switch (nucleotideo) {
                case 'A':
                    contagem[0]++;
                    break;
                case 'C':
                    contagem[1]++;
                    break;
                case 'G':
                    contagem[2]++;
                    break;
                case 'T':
                    contagem[3]++;
                    break;
                default:
                    // Qualquer outro caractere que não seja A, C, G ou T é considerado um erro.
                    // Isso inclui espaços em branco.
                    contagem[4]++;
                    break;
            }
        }

        int porcentagemErros = (contagem[4] * 100) / sequenciaDNA.length();
        if (contagem[4] > (sequenciaDNA.length() * 0.1)) {
            return null;
        }

        return contagem;
    }
}
