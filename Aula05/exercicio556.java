import java.util.*;

public class exercicio556 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		int n = Funcoes.getIntRange(0, 100);
		escreverTabuada(n);
	}
	
	public static void escreverTabuada (int n) {
		for(int i = 1; i <= 10; i++) {
			System.out.printf("%2d x %d | %3d\n", n, i, n*i);
		}		
		
	}
}