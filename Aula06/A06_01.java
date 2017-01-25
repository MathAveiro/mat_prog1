import java.util.*;
public class A06_01 {
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) {
		System.out.print(" Quantos números serão introduzidos? ");
		int n = sc.nextInt();
		
		int [] a = new int [n];
		for (int i=0; i<n; i++){
			System.out.print (" Numero " + i + ":" );
			a[i] = sc.nextInt ();
		}
		for (int i=n-1; i>=0; i--) {
			System.out.print(a[i] + "\n");
		}
	}
}

