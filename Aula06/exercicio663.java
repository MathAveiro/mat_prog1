import java.util.*;
import static java.lang.System.*; 

public class exercicio663 {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int count = 0, op = 0;

		int[] sequence = new int[50];

		do {

			out.printf("Analysis of a sequence of integers\n 1 - Read sequence\n 2 - Write sequence\n 3 - Calculate the maximum value of the sequence\n 4 - Calculate the minimum value of the sequence\n 5 - Calculate the average of the sequence\n 6 - Detect whether a sequence composed of only even numbers\n 10 - Exit\n");

			out.print("Option: ");

			op = sc.nextInt();

			switch(op) {
				case 1: 

					count = readSequence(count, sequence);

					break;

				case 2: 

					writeSequence(count, sequence);

					break;

				case 3: 

					findMax(count, sequence);
			
					break;

				case 4: 

					findMin(count, sequence);

					break;

				case 5: 

					findAverage(count, sequence);

					break;
				
				case 6: 
				
					checkSequence(count, sequence);

					break;

					case 10: 

						out.println("The program will be terminated!");

						break;

					default: 

						out.println("Wrong option!");

						break;
			}

			out.println();

		}while(op != 10);

	}

	public static int readSequence(int count, int[] sequence) {

		count = 0;

		do {
			out.print("Insert the element number " + (count+1) + ": ");
			sequence[count] =  sc.nextInt();
			if(sequence[count] ==  0) break;
			count++;
		} while(count < sequence.length);

		return count;

	}

	public static void writeSequence(int count, int[] sequence) {

		out.print("Sequence: ");

		for (int j=0; j < count; j++) {
			if(j == count-1) out.println(sequence[j]);
			else out.print(sequence[j] + " - ");
		}

	}

	public static void findMax(int count, int[] sequence) {

		int max = 0;

		for (int j=0; j < count; j++) {
		
			if(sequence[j] >= max) max = sequence[j];

		}

		out.println("The maximum value of the sequence is: " + max);

	}

	public static void findMin(int count, int[] sequence) {

		int min = sequence[0];

		for (int j=0; j < count; j++) {
					
			if(sequence[j] <= min) min = sequence[j];

		}

		out.println("The maximum value of the sequence is: " + min);

	}

	public static void findAverage(int count, int[] sequence) {

		Double sum = 0.0;
		Double med;
		int i=0;

		for (int j = 0; j < count ; j++) {
				
			sum = sum + sequence[j];
			i++;

		}

		med = sum/(i);

		out.println("The total of the sequence is " + sum + ", the average of the sequence is " + med + " and have " + i + " elements");

	}

	public static void checkSequence(int count, int[] sequence) {

		boolean pair = false, odd = false;

		for(int j = 0; j < count; j++) {

			if(!(sequence[j]%2 == 0)) {

				pair = false; 
				break;
						
			}

			else {

				pair = true;

			}

		}

		for(int j = 0; j < count; j++) {

			if(sequence[j]%2 == 0) {

				odd = false; 
				break;
						
			}

			else {

				odd = true;

			}

		}

		if(pair) out.println("The sequence is composed only of pairs numbers!");

		else if(odd) out.println("The sequence consists only of odd numbers!");

		else out.println("The sequence is not composed of only odd or pairs numbers!");

	}
}