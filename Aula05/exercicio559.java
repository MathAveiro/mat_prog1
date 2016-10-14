import java.util.*;

public class exercicio559 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub

		int a = Funcoes.getintpos();
		
		System.out.println("Os números primos são: ");
		
		for (int i = a ; i >= 1; i--){
			if(isprime(i) == true) System.out.print(i + " ");
		}
	}

	public static boolean isprime(int n){
		
		boolean primo = true;
		
		if (n == 2) primo = true;
		else {
			for(int i = 2;i < n; i++) {
				if (n % i == 0) primo = false;
			}
		}

		return primo;
		
	}

}