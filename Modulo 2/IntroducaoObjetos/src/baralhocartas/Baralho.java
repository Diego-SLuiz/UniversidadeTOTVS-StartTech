package baralhocartas;

import baralhocartas.enumeration.Cor;
import baralhocartas.enumeration.Naipe;
import baralhocartas.enumeration.Nome;

import java.util.Random;

public class Baralho {
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
                Integer valor = j + 1;
                Naipe naipe = Naipe.values()[i];
                Nome nome = Nome.values()[j];

                Carta carta = new Carta(valor, nome, naipe, cor);
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
            if (posicao < cartas.length) {
                cartasSaque[i] = cartas[posicao];
                posicao++;
            }
        }

        return cartasSaque;
    }

}
