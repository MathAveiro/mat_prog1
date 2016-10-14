import java.util.*;
import static java.lang.System.*;

public class exercicio661 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		out.print("Number of sequence elements: ");
		int n = sc.nextInt();

		int[] sequence = new int[n];

		for (int i = 0; i<sequence.length; i++) {
			out.print("Insert the element number " + (i+1) + ": ");
			sequence[i] = sc.nextInt();
		}

		for (int j=sequence.length-1; j>=0; j--) {
			if(j == 0) out.print(sequence[j]);
			else out.print(sequence[j] + " - ");
		}

		out.println();
	}
}