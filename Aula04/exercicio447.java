import java.util.*;

public class exercicio447 {
	
		public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		int h, l, n, m;

		System.out.print("Introduza a altura do rectângulo: ");
		h = sc.nextInt();

		System.out.print("Introduza a largura do rectângulo: ");
		l = sc.nextInt();

		for(n=1;n<=h;n++)
		{

			for(m=1;m<=l;m++) {
				if (n == 1 || n == h) System.out.print("*");
				else if (m == 1 || m == l) System.out.print("*");
				else System.out.print(" ");
			}

			System.out.println("");

		}
		
	}

}