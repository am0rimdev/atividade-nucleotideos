/*
 * @description: Programa com ambiente e implementação de uma classe de testes, com os respectivos casos de teste, usando JUnit.
 *               Classe com o método main.
 * @author Nifane Borges & Vinicius Alves Amorim
 */


package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DNA dna = new DNA();

        int[] resultado = dna.calculoDeNucleotideos("ACTGACTGACTGACTGACTG");

        System.out.println(Arrays.toString(resultado));
    }
}
