import java.util.*;

public class exercicio229 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza a temperatura : ");
		double temp = sc.nextDouble();
		System.out.print("Introduza o tipo de temperatura (0: Celsius e 1:Fahrenheit): ");
		int tipo = sc.nextInt();
		if (tipo == 0) System.out.printf("%.2f ºCelsius é equivalente a %.2f ºFahrenheit", temp, (1.8*temp + 32));
		else if (tipo == 1) System.out.printf("%.2f ºFahrenheit é equivalente a %.2f ºCelsius", temp, (temp - 32)/1.8);
	}

}
