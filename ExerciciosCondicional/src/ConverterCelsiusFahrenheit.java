import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class ConverterCelsiusFahrenheit {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o tipo de temperatura (F - Fahrenheit | C - Celsius)");
        String medida = entrada.nextLine();

        System.out.printf("Digite uma temperatura em %s\n", medida);
        Double temperatura = entrada.nextDouble();

        if (medida.equals("F")) {
            System.out.printf("A medida %s em °C é %.2f\n", medida, );
            return;
        }


    }

}


