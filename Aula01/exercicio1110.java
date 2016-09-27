import java.util.*;

public class exercicio1110 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza a temperatura em graus Celsius: ");
		double tCelsius = sc.nextDouble();
		double tFahrenheit = 1.8*tCelsius + 32;
		System.out.printf("%.2f ºCelsius é equivalente a %.2f ºFahrenheit", tCelsius, tFahrenheit);
	}

}
