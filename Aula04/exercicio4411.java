import java.util.*;

public class exercicio4411 {
	
		public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub

		for (int b=8; b>0; b--){	
			for(int i=0; i<8;i++){
				char letra = (char)('a' + i);
				System.out.print(letra);
				System.out.print(b + " ");
			} 
			System.out.println();
		}
	}

}