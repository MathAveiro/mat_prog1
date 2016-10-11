import java.util.*;

public class exercicio448 {
	
		public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		int a, b, i=0;
				
		System.out.print("Introduza A: ");
		a = sc.nextInt();
		System.out.print("\nIntroduza B: ");
		b = sc.nextInt();
		
		if (b>a) {
			i=a;
			a=b;
			b=i;
		}
		
		for(i=b; (a>=i && i>=b ); i++) if(i%2==1) System.out.println(i);

	}

}