import java.util.*;
public class A06_05 {
	static Scanner sc = new Scanner (System.in);
	
	public static void main (String[] args) {
		System.out.print("Quantos números quer introduzir? ");
		int n = sc.nextInt();
		int[]a = new int [n];
		int count = 0;
		
		for(int i=0; i<n; i++){
			System.out.print("Número " + i + ": ");
			a[i] = sc.nextInt();
			count ++;
		}
		double media = mediaSeq(a, n);
		System.out.println(media);
		double desvio = desvPadrao(a, n, media);
		System.out.println(desvio);
	}
	
	public static double mediaSeq (int[]a, int n) {
		double media;
		int soma=0;
		double count = n;
		for (int i=0; i<n ; i++) {
			soma = soma + a[i];
		}
		media = soma/count;	
		return media;
	}
	
	public static double desvPadrao (int[]a, int n, double media) {
		double desvio = 0.0;
		double x = sc.nextDouble();
		for (int i=0; i<n ; i++) {
			x = Math.abs (a[i] - media);
			if (x > desvio){
				desvio = x;
			}
		}
		return desvio;
	}
}

/*
	for (int i=0; i<n; i++) {
		if (a[i] > media) 
		maiorMedia++;
    }
    System.out.printf("Notas acima da media: %d\n",maiorMedia);

*/ 
