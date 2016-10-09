import java.util.*;

public class exercicio337 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		double a;
		int b, c=0, temp=0;
		
		System.out.print("Insira o valor A: ");
		a = sc.nextDouble();
		System.out.print("Insira o valor B: ");
		b = sc.nextInt();
		
		if(a>b){
			
			temp = (int)a;
			a = b;
			b = temp;
			
		}
		
		do{
			if (a%2 != 0)c = c + b;
			
			a = Math.floor(a);
			
			a = a / 2; 
			
			b = 2 * b;
			
		}while (a!=1);
		
		c = c + b;

		System.out.println("A soma dos seus valores é igual a " + c);
	}

}
