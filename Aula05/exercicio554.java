import java.util.*;

public class exercicio554 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Insira um valor entre 0 e 100: ");
		int valor = Funcoes.getIntRange(100,0);
		for (int i = valor;i >= 1;i--){
			System.out.print(i + "! = ");
			System.out.println(Funcoes.fact(i));
		}

	}
}