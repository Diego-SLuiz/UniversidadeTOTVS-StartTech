package rpg;

import rpg.enumeration.EspeciePersonagem;

import java.util.Random;

public class Personagem {
    private final Integer vidaBase;
    private final Integer precisaoBase;
    private final Integer ataqueBase;
    private final Integer defesaBase;
    private final EspeciePersonagem especiePersonagem;

    private Integer vida;
    private Integer precisao;
    private Integer ataque;
    private Integer defesa;
    private Armamento armamento;
    private Equipamento equipamento;

    public String nome;
    public Boolean estaVivo;

    public Personagem(String nome, Integer vidaBase, Integer precisaoBase, Integer ataqueBase, Integer defesaBase, EspeciePersonagem especiePersonagem) {
        this.nome = nome;
        this.vidaBase = vidaBase;
        this.precisaoBase = precisaoBase;
        this.ataqueBase = ataqueBase;
        this.defesaBase = defesaBase;
        this.especiePersonagem = especiePersonagem;

        this.vida = vidaBase;
        this.precisao = precisaoBase;
        this.ataque = ataqueBase;
        this.defesa = defesaBase;
        this.estaVivo = true;
    }

    public void usarArmamento(Armamento armamento) {
        System.out.printf("%s pegou \"%s\" para usar como armamento\n", nome, armamento.nome);
        this.armamento = armamento;
        precisao = calcularPrecisao();
        ataque = calcularAtaque();
    }

    public void usarEquipamento(Equipamento equipamento) {
        System.out.printf("%s pegou \"%s\" para usar como equipamento\n", nome, equipamento.nome);
        this.equipamento = equipamento;
        defesa = calcularDefesa();
    }

    public void inferirAtaque(Personagem alvo) {
        System.out.printf("%s atacou %s\n", nome, alvo.nome);
        Random aleatorio = new Random();
        Integer numeroSorteado = aleatorio.nextInt(precisao) + 1;

        if (numeroSorteado >= alvo.defesa) {
            System.out.println("O ataque acertou!");
            Integer valorDano = aleatorio.nextInt(ataque) + 1;
            alvo.receberAtaque(valorDano);
        }
        else {
            System.out.println("O ataque errou!");
        }
    }

    public void receberAtaque(Integer valorDano) {
        System.out.printf("%s perdeu %d pontos de vida\n", nome, valorDano);
        vida -= valorDano;

        if (vida <= 0) {
            vida = 0;
            estaVivo = false;
        }

        System.out.printf("%s possui %d pontos de vida restantes\n", nome, vida);
    }

    private Integer calcularPrecisao() {
        return precisaoBase + armamento.precisaoBase;
    }

    private Integer calcularAtaque() {
        return ataqueBase + armamento.ataqueBase;
    }

    private Integer calcularDefesa() {
        return defesaBase + equipamento.defesaBase;
    }

    public String toString() {
        String textoArmamento = armamento == null ? "Vazio" : armamento.toString();
        String textoEquipamento = equipamento == null ? "Vazio" : equipamento.toString();
        return String.format("""
                %s:
                    Vida -> %d
                    Precisao -> %d
                    Ataque -> %d
                    Defesa -> %d
                    Especie -> %s
                    
                    Armamento -> %s
                    Equipamento -> %s
                """, nome, vida, precisao, ataque, defesa, especiePersonagem, textoArmamento, textoEquipamento);
    }

}
