import java.util.*;
public class A06_02 {
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) {
		int n = 100, x, k=0;
		int [] a = new int [n];
		
		for(int i=0; i<n; i++){
			System.out.print (" Numero " + i + ":");
			a[i] = sc.nextInt ();
			if (a[i]<0){
				n = i;
				i = 101;
			}
		}
		
		System.out.print(" Que número escolhe, para saber quantas vezes o repetiu? ");
		x = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			if(a[i] == x) {
				k++;
			}
		}
		System.out.println(" O numero " + x + " foi introduzido " + k + " vezes. ");
	}
}
