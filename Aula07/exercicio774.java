import java.util.Scanner;

public class exercicio774 {
	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Complexo num1 = new Complexo();
		Complexo num2 = new Complexo();

		String operacao = "";
		boolean acabar = false;
		do {

			do {
				System.out.print("Operação: ");
				operacao = sc.next();
				if (operacao.equals("=")) {
					System.out.println("O programa vai terminar!");
					acabar = true;
				} else if (!operacao.equals("+") && !operacao.equals("-") && !operacao.equals("*")
						&& !operacao.equals("/"))
					System.out.println("Operação não permitida!");

			} while (!operacao.equals("+") && !operacao.equals("-") && !operacao.equals("*") && !operacao.equals("/")
					&& !acabar);

			if (!acabar) {
				num1 = lerComplexo();
				num2 = lerComplexo();
				escreverOperacao(num1, num2, operacao);
			}

		} while (!acabar);
	}

	public static Complexo lerComplexo() {

		Complexo num = new Complexo();

		System.out.println("Introduza um numero complexo:");
		System.out.print("Parte real: ");
		num.r = sc.nextDouble();
		System.out.print("Parte imaginária: ");
		num.i = sc.nextDouble();

		return num;

	}

	public static void escreverComplexo(double r, double i) {
		if (i >= 0)
			System.out.printf("%.1f + %.1fi", r, i);
		else
			System.out.printf("%.1f - %.1fi", r, i);
	}

	public static void escreverOperacao(Complexo num1, Complexo num2, String operacao) {
		if (operacao.equals("+")) {
			escreverComplexo(num1.r, num1.i);
			System.out.print(" + ");
			escreverComplexo(num2.r, num2.i);
			System.out.println();
		} else if (operacao.equals("-")) {
			escreverComplexo(num1.r, num1.i);
			System.out.print(" - ");
			escreverComplexo(num2.r, num2.i);
			System.out.println();
		} else if (operacao.equals("*")) {
			System.out.print("(");
			escreverComplexo(num1.r, num1.i);
			System.out.print(")");
			System.out.print(" * ");
			System.out.print("(");
			escreverComplexo(num2.r, num2.i);
			System.out.print(")");
			System.out.println();
		} else if (operacao.equals("/")) {
			System.out.print("(");
			escreverComplexo(num1.r, num1.i);
			System.out.print(")");
			System.out.print(" / ");
			System.out.print("(");
			escreverComplexo(num2.r, num2.i);
			System.out.print(")");
			System.out.println();
		}

	}

	public static class Complexo {
		double i, r;
	}
}