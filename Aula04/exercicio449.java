import java.util.*;

public class exercicio449 {
	
		public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		int a, soma=0, b=0;
		
		do{
			System.out.print("Insira um número positivo: ");
			a = sc.nextInt();
		
		} while(a <= 0 || a >= 1000);
		
		for(int i=1; i<=a; i++){
		
			b=2*i;
			soma += b;
			System.out.print(b + " ");
		
		}
		System.out.println("e a soma será " + soma +".");

	}

}