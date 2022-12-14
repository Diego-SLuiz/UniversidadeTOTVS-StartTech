package volumepiscina;

public class Piscina {
    public Integer largura;
    public Integer comprimento;
    public Integer profundidade;

    public Piscina(Integer largura, Integer comprimento, Integer profundidade) {
        this.largura = largura;
        this.comprimento = comprimento;
        this.profundidade = profundidade;
    }

    public Integer calcularVolume() {
        return largura * comprimento * profundidade;
    }
}
