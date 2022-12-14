package BaralhoCartas;

import BaralhoCartas.Enum.Cor;
import BaralhoCartas.Enum.Naipe;

public class Carta {
    public String nome;
    public Integer valor;
    public Cor cor;
    public Naipe naipe;

    public Carta(String nome, Integer valor, Cor cor, Naipe naipe) {
        this.nome = nome;
        this.valor = valor;
        this.cor = cor;
        this.naipe = naipe;
    }

}
