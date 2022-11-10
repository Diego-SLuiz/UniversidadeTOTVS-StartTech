import java.util.Scanner;

public class ConverterCelsiusFahrenheit {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite uma temperatura em °C: ");
        Double temperaturaCelsius = entrada.nextDouble();
        Double temperaturaFahrenheit = (temperaturaCelsius * 9 / 5) + 32;

        System.out.printf("A temperatura informada é {%.1f}°C\n", temperaturaCelsius);
        System.out.printf("A temperatura convertida é {%.1f}°F\n", temperaturaFahrenheit);
    }
}
