import java.util.*;
import static java.lang.System.*;

public class exercicio662 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		out.print("Insert the number: ");
		int n = sc.nextInt();

		int count = 0;
		int[] nSequence = new int[100];

		do {

			out.print("Insert the element number " + (count+1) + ": ");
			nSequence[count] =  sc.nextInt();
			if(nSequence[count] < 0) break;
			count++;

		} while(count < nSequence.length);

		int nEqual = 0;

		for(int i = 0; i < count; i++) {
			if(nSequence[i] == n) nEqual++;
		}

		out.println("The number " + n + " appeared " + nEqual + " times");

	}
}