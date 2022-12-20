package baralhocartas;

import baralhocartas.enumeration.Cor;
import baralhocartas.enumeration.Naipe;
import baralhocartas.enumeration.Nome;

public class Carta {
    public Integer valor;
    public Nome nome;
    public Cor cor;
    public Naipe naipe;

    public Carta(Integer valor, Nome nome, Naipe naipe, Cor cor) {
        this.valor = valor;
        this.nome = nome;
        this.cor = cor;
        this.naipe = naipe;
    }

    @Override
    public String toString() {
        return String.format("Carta - Nome: %s Valor: %d Naipe: %s Cor: %s", nome, valor, naipe, cor);
    }

}
