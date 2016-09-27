import java.util.*;

public class exercicio224 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Introduza o ano: ");
		int a = sc.nextInt();
		System.out.print("Introduza o mês: ");
		int m = sc.nextInt();
		
		if (m==2) {
			if (a%100==0) {
				if (a%400==0) System.out.println("O mês 2 do ano " + a + " tem 29 dias");
				else System.out.println("O mês 2 do ano " + a + " tem 28 dias");
				
			}
			else {
				if (a%4==0)System.out.println("O mês 2 do ano " + a + " tem 29 dias");
				else System.out.println("O mês 2 do ano " + a + " tem 28 dias");
			}
		}
		else {
			if (m==4 || m==6 || m==9 || m==11) System.out.println("O mês " + m + " do ano " + a + " tem 30 dias");
			else System.out.println("O mês " + m + " do ano " + a + " tem 31 dias");
			
		}
		
	}
	
}