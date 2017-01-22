import java.util.*;

public class MultiMatriz {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Dimensão da matriz: ");
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		int[][] b = new int[n][n];
		int[][] f = new int[n][n];
		int i = 0, j = 0;
		int l = 0, c = 0;

		System.out.println("Inserir dados da matriz A: ");
		do {
			System.out.print((i+1)+"º valor: ");
			a[l][c] = sc.nextInt();
			if(c==(n-1)) {
				c=0;
				l++;
			} else {
				c++;
			}
			i++;
		}while(i < n*n);
		c = 0;  
		l = 0;
		System.out.println("Inserir dados da matriz B: ");
		do {
			System.out.print((j+1)+"º valor: ");
			b[l][c] = sc.nextInt();
			if(c==(n-1)) {
				c=0;
				l++;
			} else {
				c++;
			}
			j++;
		}while(j < n*n);
		System.out.println();
		System.out.println("Matriz A: ");
		for(int k = 0; k < n; k++) {
			for (int w = 0; w < n; w++) {
				System.out.printf("%4d", a[k][w]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Matriz B: ");
		for(int k = 0; k < n; k++) {
			for (int w = 0; w < n; w++) {
				System.out.printf("%4d", b[k][w]);
			}
			System.out.println();
		}
		System.out.println();
		for(int k = 0; k < n; k++) {
			for (int w = 0; w < n; w++) {
				int v = 0;
				for(int u = 0; u < n; u++) {
					v += a[k][u]*b[u][w];
				}
				f[k][w] = v;
			}
		}
		System.out.println("Matriz AxB: ");
		for(int k = 0; k < n; k++) {
			for (int w = 0; w < n; w++) {
				System.out.printf("%4d", f[k][w]);
			}
			System.out.println();
		}
	}
}