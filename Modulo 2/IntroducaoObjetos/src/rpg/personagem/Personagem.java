package rpg.personagem;

import rpg.armamento.Armamento;
import rpg.dado.Dado;
import rpg.equipamento.Equipamento;
import rpg.enumeration.EspeciePersonagem;

public class Personagem {
    private final String nome;
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
    }

    public void usarArmamento(Armamento armamento) {
        System.out.printf("%s pegou \"%s\" para usar como armamento\n", nome, armamento.getNome());
        this.armamento = armamento;
        precisao = calcularPrecisao();
        ataque = calcularAtaque();
    }

    public void usarEquipamento(Equipamento equipamento) {
        System.out.printf("%s pegou \"%s\" para usar como equipamento\n", nome, equipamento.getNome());
        this.equipamento = equipamento;
        defesa = calcularDefesa();
    }

    public void atacar(Personagem alvo) {
        System.out.printf("%s atacou %s\n", nome, alvo.nome);
        Dado dadoPrecisao = new Dado(precisao);
        Integer valorPrecisao = dadoPrecisao.sortear();

        if (valorPrecisao >= alvo.defesa) {
            System.out.printf("O ataque de %s acertou!\n", nome);
            Dado dadoDano = new Dado(ataque);
            Integer valorDano = dadoDano.sortear();
            alvo.receberDano(valorDano);
        }
        else {
            System.out.printf("O ataque de %s errou!\n", nome);
        }
    }

    public void receberDano(Integer dano) {
        System.out.printf("%s perdeu %d pontos de vida\n", nome, dano);
        vida -= dano;
        vida = vida < 0 ? 0 : vida;
        System.out.printf("%s possui %d pontos de vida restantes\n", nome, vida);
    }

    public Boolean estaVivo() {
        return vida > 0;
    }

    private Integer calcularPrecisao() {
        return precisaoBase + armamento.getPrecisaoBase();
    }

    private Integer calcularAtaque() {
        return ataqueBase + armamento.getAtaqueBase();
    }

    private Integer calcularDefesa() {
        return defesaBase + equipamento.getDefesaBase();
    }

    public String getNome() {
        return nome;
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
