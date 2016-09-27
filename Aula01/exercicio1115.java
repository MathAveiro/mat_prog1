import java.util.*;

public class exercicio1115 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza a nota do teste TP1: ");
		double tp1 = sc.nextDouble();
		System.out.print("Introduza a nota do teste TP2: ");
		double tp2 = sc.nextDouble();
		System.out.print("Introduza a nota do teste API: ");
		double api = sc.nextDouble();
		System.out.print("Introduza a nota do teste EP: ");
		double ep = sc.nextDouble();
		
		double afinal = tp1*0.15 + tp2*0.15 + api*0.3 + ep*0.4; 
		System.out.printf("A nota final é: %.2f", afinal);
	}

}