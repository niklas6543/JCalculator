package Calculator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	private static Scanner operator;
	private static Scanner input2;
	private static Scanner input;

	public static void main(String[] args) {
		
		while (true) {
			input = new Scanner(System.in);
			input2 = new Scanner(System.in);
			operator = new Scanner(System.in);

			try {
				printOut("Eingabe Operator (+-*/) | ein anderes Zeichen beendet das Programm");
				String op = input.next();
				printOut("Eingabe 1. Zahl");
				float number = input.nextFloat();
				printOut("Eingabe 2. Zahl");
				float number2 = input.nextFloat();
				
				printOut(String.valueOf(calc(number , number2, op)));
			} catch (InputMismatchException e)
			{
				printOut("Fehler ungueltige Eingabe !");
			} catch (Exception e) 
			{
				printOut("Fehler: " + e);
			}
		}

	}

	public static float calc(float x, float y, String op) {

		switch (op) {
		case "+":
			return x + y;

		case "-":
			return x - y;

		case "*":
			return x * y;

		case "/":
			return x / y;

		default:
			printOut("Programm beendet");
			System.exit(0);
		}

		return 0;

	}

	public static void printOut(String result) {
		System.out.println(result);
		return;

	}
}
