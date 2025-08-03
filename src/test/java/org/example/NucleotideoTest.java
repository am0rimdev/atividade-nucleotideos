package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DNATest {
    private DNA dna;

    @BeforeEach
    // Inicializa o objeto da classe a ser testada antes de cada teste
    void setUp() {
        this.dna = new DNA();
    }

    @Test
    @DisplayName("Verifica se uma exceção é lançada para uma sequência de DNA vazia")
    void calculoDeNucleotideosCase1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> { this.dna.calculoDeNucleotideos(""); }
        );
    }

    @Test
    @DisplayName("Verifica se o método retorna o array com os dados corretos quando a sequência de DNA é válida e sem erros")
    void calculoDeNucleotideosCase2() {
        int[] arr = {4, 2, 2, 2, 0};
        int[] calculoResultado = this.dna.calculoDeNucleotideos("AAAGTCTGAC");

        assertArrayEquals(arr, calculoResultado);
    }

    @Test
    @DisplayName("Verifica se o método retorna o array com os dados corretos quando a sequência de DNA é válida e com erros")
    void calculoDeNucleotideosCase3() {
        int[] arr = {6, 4, 5, 5, 2};
        int[] calculoResultado = this.dna.calculoDeNucleotideos("AAAAAGTCTGBACKCGGTTCGT");

        assertArrayEquals(arr, calculoResultado);
    }

    @Test
    @DisplayName("Verifica se o método retorna null caso o número de erros seja maior que 10% da sequência de DNA")
    void calculoDeNucleotideosCase4() {
        assertNull(this.dna.calculoDeNucleotideos("AAAGTCTGACB"));
    }

    @Test
    @DisplayName("Verifica se o método retorna o array com os dados corretas se a sequência tiver exatamente 10% de erros")
    void calculoDeNucleotideosCase5() {
        int[] arr = {6, 3, 4, 5, 2};
        int[] calculoResultado = this.dna.calculoDeNucleotideos("ACGTACGTAHACGTAGALTT");

        assertArrayEquals(arr, calculoResultado);
    }
}
