package baralhocartas;

import baralhocartas.enumeration.Cor;
import baralhocartas.enumeration.Naipe;

import java.util.Random;

public class Baralho {
    private static final String[] nomesCarta = {"Ás", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei"};
    private static final Integer quantidadeGrupos = 4;
    private static final Integer cartasPorGrupo = 13;
    private Integer posicao;
    public Carta[] cartas;
    public Cor cor;

    public Baralho(Cor cor) {
        this.posicao = 0;
        this.cor = cor;
        this.cartas = new Carta[cartasPorGrupo * quantidadeGrupos];
        construirBaralho();
    }

    private void construirBaralho() {
        for (int i = 0; i < quantidadeGrupos; i++) {
            for (int j = 0; j < cartasPorGrupo; j++) {
                Naipe naipe = Naipe.values()[i];
                String nome = nomesCarta[j];
                Integer valor = j + 1;

                Carta carta = new Carta(nome, valor, naipe, cor);
                cartas[i * cartasPorGrupo + j] = carta;
            }
        }
    }

    public void embaralhar() {
        Random aleatorio = new Random();
        posicao = 0;

        for (int i = 0; i < cartas.length; i++) {
            Integer posicaoDestino = aleatorio.nextInt(cartas.length);
            Integer posicaoOrigem = i;
            Carta cartaDestino = cartas[posicaoDestino];
            Carta cartaOrigem = cartas[posicaoOrigem];
            cartas[posicaoDestino] = cartaOrigem;
            cartas[posicaoOrigem] = cartaDestino;
        }
    }

    public Carta[] sacar(Integer quantidade) {
        Carta[] cartasSaque = new Carta[quantidade];

        for (int i = 0; i < quantidade; i++) {
            if (posicao >= cartas.length) {
                cartasSaque[i] = null;
            } else {
                cartasSaque[i] = cartas[posicao];
            }

            posicao++;
        }

        return cartasSaque;
    }

}
