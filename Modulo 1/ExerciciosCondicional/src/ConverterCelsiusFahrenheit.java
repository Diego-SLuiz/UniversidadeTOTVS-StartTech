import java.util.Scanner;

public class ConverterCelsiusFahrenheit {
    private static final Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        String tipoTemperatura = perguntarTipoTemperatura();
        Double valorTemperatura = perguntarValorTemperatura();
        Double valorConvertido;

        if (tipoTemperatura.equalsIgnoreCase("F")) {
            valorConvertido = converterParaCelsius(valorTemperatura);
            System.out.printf("A temperatura %.2f°F equivale à %.2f°C\n", valorTemperatura, valorConvertido);
        } else {
            valorConvertido = converterParaFahrenheit(valorTemperatura);
            System.out.printf("A temperatura %.2f°C equivale à %.2f°F\n", valorTemperatura, valorConvertido);
        }
    }

    public static String perguntarTipoTemperatura() {
        String tipoTemperaturaInformada = "";
        Boolean informacaoInvalida = true;

        while (informacaoInvalida) {
            System.out.print("Digite um tipo de temperatura (F - Fahrenheit | C - Celsius): ");
            tipoTemperaturaInformada = entrada.nextLine();

            if (!(tipoTemperaturaInformada.equalsIgnoreCase("F") || tipoTemperaturaInformada.equalsIgnoreCase("C"))) {
                System.out.printf("Foi informado um tipo de temperatura inválida: %s\n", tipoTemperaturaInformada);
            } else {
                informacaoInvalida = false;
            }
        }

        return tipoTemperaturaInformada;
    }

    public static Double perguntarValorTemperatura() {
        Double valorTemperaturaInformado = 0.0;
        String textoTemperaturaInformado = "";
        Boolean valorInvalido = true;

        while (valorInvalido) {
            System.out.print("Digite um valor para a temperatura: ");

            try {
                textoTemperaturaInformado = entrada.nextLine();
                valorTemperaturaInformado = Double.parseDouble(textoTemperaturaInformado.replace(",", "."));
                valorInvalido = false;
            } catch (NumberFormatException error) {
                System.out.printf("Foi informado um valor inválido: %s\n", textoTemperaturaInformado);
            }
        }

        return valorTemperaturaInformado;
    }

    public static Double converterParaCelsius(Double temperatura) {
        return (temperatura - 32) * 5 / 9;
    }

    public static Double converterParaFahrenheit(Double temperatura) {
        return (temperatura * 9 / 5) + 32;
    }

}
