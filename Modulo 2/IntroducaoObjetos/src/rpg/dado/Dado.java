package rpg.dado;

import java.util.Random;

public class Dado {
    private final Random aleatorizador;
    private final Integer lados;

    public Dado(Integer lados) {
        this.lados = lados;
        this.aleatorizador = new Random();
    }

    public Integer sortear() {
        return aleatorizador.nextInt(lados) + 1;
    }

}
