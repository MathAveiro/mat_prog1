import java.util.*;

public class exercicio228 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza o primeiro número: ");
		int tp1 = sc.nextInt();
		System.out.print("Introduza o segundo número: ");
		int tp2 = sc.nextInt();
		System.out.print("Introduza o terceiro número: ");
		int tp3 = sc.nextInt();
				
		if (tp1 <= tp2 && tp2 <= tp3) System.out.println(tp1 + " " + tp2 + " " + tp3);
		else if (tp1 <= tp3 && tp3 <= tp2) System.out.println(tp1 + " " + tp3 + " " + tp2);
		else if (tp3 <= tp1 && tp1 <= tp2) System.out.println(tp3 + " " + tp1 + " " + tp2);
		else if (tp3 <= tp2 && tp2 <= tp1) System.out.println(tp3 + " " + tp2 + " " + tp1);
		else if (tp2 <= tp1 && tp1 <= tp3) System.out.println(tp2 + " " + tp1 + " " + tp3);
		else if (tp2 <= tp3 && tp3 <= tp1) System.out.println(tp2 + " " + tp3 + " " + tp1);
	}

}
