import java.util.*;
import static java.lang.System.*;
import static java.lang.Character.*;

public class exercicio1085 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		out.print("Introduza um número: ");
		int num = sc.nextInt();
		out.print("Introduza uma base: ");
		int base = sc.nextInt();
		out.println(numToBase(num, base));
	}
	public static int numToBase(int num, int base) {
		int dividendo = num;
		String numBase = "";
		int quociente = 0;
		do {
			quociente = dividendo/base;
			numBase = dividendo%base + numBase;
			dividendo = quociente;
		} while(dividendo != 0);
		int finalNumb = Integer.parseInt(numBase);
		return finalNumb;
	}	
}