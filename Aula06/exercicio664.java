import java.util.*;
import static java.lang.System.*;

public class exercicio664 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		out.print("Number of grades: ");
		int n = sc.nextInt();

		Double[] grades = new Double[n];

		insertGrades(n, grades);

		makeHistogram(n, grades);

	}

	public static void insertGrades(int n, Double[] grades) {

		int count = 0;

		do {

			out.print("Insert the element number " + (count+1) + ": ");
			Double grade =  sc.nextDouble();
			if(grade < 0 || grade > 20) {

				out.println("The value is invalid!");

			} 
			else {

				grades[count] = grade;
				count++;

			}

		} while(count < n);

	}

	public static void makeHistogram(int n, Double[] grades) {

		out.println("Histogram of grades");
		out.println("--------------------------------------");

		for(int i=20; i >= 0; i--) {

			out.printf("%-2d | ", i);

			for(int j = 0; j < grades.length; j++) {

				if(grades[j] == i) out.print("*");

			}

			out.println();

		}

	}
}