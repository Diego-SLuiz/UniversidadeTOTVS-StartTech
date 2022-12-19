package rpg;

import rpg.enumeration.CategoriaArmamento;
import rpg.enumeration.CategoriaEquipamento;
import rpg.enumeration.EspeciePersonagem;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Criação do humano e seus equipamentos
        Personagem humano = new Personagem("Aventureiro",10,20,0,10,EspeciePersonagem.HUMANO);
        Armamento espadaBasica = new Armamento("Espada Básica", 2,8,CategoriaArmamento.ESPADA);
        Equipamento armaduraCotaDeMalha = new Equipamento("Armadura Cota De Malha", 4, CategoriaEquipamento.ARMADURA);

        humano.usarArmamento(espadaBasica);
        humano.usarEquipamento(armaduraCotaDeMalha);
        System.out.println(humano);

        // Criação do orc e seus equipamentos
        Personagem orc = new Personagem("Orc Selvagem", 8, 20, 0, 10, EspeciePersonagem.ORC);
        Armamento machadoBasico = new Armamento("Machado Básico", 0, 12, CategoriaArmamento.MACHADO);

        orc.usarArmamento(machadoBasico);
        System.out.println(orc);

        // Sistema de batalha
        String mensagemVitoria = "%s é o vencedor da batalha!!!";
        
        while(true) {
            if (humano.estaVivo) {
                humano.inferirAtaque(orc);
                Thread.sleep(5000);
                System.out.println();
            } else {
                System.out.println(mensagemVitoria.formatted(orc.nome));
                break;
            }

            if (orc.estaVivo) {
                orc.inferirAtaque(humano);
                Thread.sleep(5000);
                System.out.println();
            } else {
                System.out.println(mensagemVitoria.formatted(humano.nome));
                break;
            }
        }
    }

}
