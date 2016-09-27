import java.util.*;

public class exercicio225 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza as coordenadas dos pontos: ");
		System.out.print("P1 x: ");
		int x1 = sc.nextInt();
		System.out.print("P1 y: ");
		int y1 = sc.nextInt();
		System.out.print("P2 x: ");
		int x2 = sc.nextInt();
		System.out.print("P2 y: ");
		int y2 = sc.nextInt();
		System.out.print("P3 x: ");
		int x3 = sc.nextInt();
		System.out.print("P3 y: ");
		int y3 = sc.nextInt();
		System.out.print("P4 x: ");
		int x4 = sc.nextInt();
		System.out.print("P4 y: ");
		int y4 = sc.nextInt();
		
		if (y1==y2 && y3==y4 && x1==x4 && x2==x3)System.out.println("A figura forma um quadrado");
		else System.out.println("A figura não forma um quadrado");
		
	}
	
}