package _12_exercices;

public class TemperatureConverter {

    private static double convertFromCelsiusToFahrenheit(double temperature){
    //Formulas: (0°C × 9/5) + 32 = 32°F
        return temperature * ((double) 9 /5) + 32;
    }

    private static double convertFromFahrenheitToCelsius(double temperature){
    //Formulas: (32°F − 32) × 5/9 = 0°C
        return (temperature - 32) * 5/9;
    }


    static void main() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        double temperature;
        double result;
        System.out.print("Welcome to Temperature converter");
        System.out.println("Type \n1: for Celsius -> Fahrenheit \n2: for Fahrenheit -> Celsius: ");
        int isCelsiusToFahrenheit = scanner.nextInt();

        if (isCelsiusToFahrenheit == 1){
            System.out.println("Enter Temperature in Celsius: ");
            temperature = scanner.nextDouble();
            result = convertFromCelsiusToFahrenheit(temperature);
            System.out.printf("%f in Fahrenheit is %f", temperature, result);
        } else if (isCelsiusToFahrenheit == 2) {
            System.out.println("Enter Temperature in Fahrenheit: ");
            temperature = scanner.nextDouble();
            result = convertFromFahrenheitToCelsius(temperature);
            System.out.printf("%f in Celsius is %f", temperature, result);
        } else{
            System.err.print("Choice not available ");
        }
    }
}
