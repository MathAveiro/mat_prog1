import java.util.*;

public class exercicio1113 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza o fator de escala: ");
		int escala = sc.nextInt();
		System.out.print("Introduza as coordenadas da localidade A: ");
		double xA = sc.nextDouble();
		double yA = sc.nextDouble();
		System.out.print("Introduza as coordenadas da localidade B: ");
		double xB = sc.nextDouble();
		double yB = sc.nextDouble();
		
		double dist = Math.sqrt(Math.pow(xA-xB,2)+Math.pow(yA-yB,2));
		double distKm = dist * escala;
		
		System.out.println("A distância em Km entre a localidade A e a localidade B é: " + distKm);
		
	}

}