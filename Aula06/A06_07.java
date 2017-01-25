import java.util.*;
public class A06_07 {
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) {
		int n;
		n = 100;
		int x;
		int k=0;
		int [] a = new int [100];
		System.out.println (" Introduza varios numeros. ");
		
		for ( int i=0; i<n ; i++){
			System.out.print (" Numero " + i + ":");
			a[i] = sc.nextInt ();
			if (a[i]<0){
				break;
			}
		}
		
		System.out.print(" Que numero escolhe, para saber quantas vezes o repetiu? ");
		x = sc.nextInt ();
		
		for ( int i=0; i<n; i++) {
			if ( a[i] == x) {
				k++;
			}
		}
		System.out.println
		  (" O numero " + x + " ocorre " + k + " vezes. ");
	}
}

