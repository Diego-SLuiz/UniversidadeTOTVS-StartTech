package rpg;

import rpg.armamento.EspadaBasica;
import rpg.armamento.MachadoBasico;
import rpg.equipamento.ArmaduraCotaDeMalha;
import rpg.personagem.Humano;
import rpg.personagem.Orc;

public class Main {
    public static void main(String[] args){
        Humano humano = new Humano("Aventureiro");
        EspadaBasica espada = new EspadaBasica();
        ArmaduraCotaDeMalha armadura = new ArmaduraCotaDeMalha();

        humano.usarArmamento(espada);
        humano.usarEquipamento(armadura);

        Orc orc = new Orc("Orc Selvagem");
        MachadoBasico machado = new MachadoBasico();

        orc.usarArmamento(machado);

        Integer contadorTurnos = 1;

        while(true) {
            System.out.printf("\nRodada %d\n", contadorTurnos);
            contadorTurnos++;

            humano.atacar(orc);
            if (!orc.estaVivo()) {
                System.out.printf("\n%s morreu!\n", orc.getNome());
                System.out.printf("%s venceu!\n\n", humano.getNome());
                break;
            }
            
            orc.atacar(humano);
            if (!humano.estaVivo()) {
                System.out.printf("\n%s morreu!\n", humano.getNome());
                System.out.printf("%s venceu!\n\n", orc.getNome());
                break;
            }
        }

        System.out.print(humano);
        System.out.print(orc);
    }

}
