package caculator;

import java.util.Scanner;

public class calculator {

	Scanner scan = new Scanner(System.in);
	static calculator calc = new calculator();

	public static void main(String[] args) {

		while(true) {
			switch (calc.selectCalculatorMenu()) {

			case 1:
				calc.selectArithmeticOperationMenu();
				break;
			case 2:
				calc.selectConvertorMenu();
				break;
			}
		}

	}

	int selectCalculatorMenu() {

		System.out.println("1.Arithmetic Operation");
		System.out.println("2.Convertor");

		int calc_menu = scan.nextInt();
		return calc_menu;
	}

	void selectArithmeticOperationMenu() {

		System.out.println("1. Add");
		System.out.println("2. Substract");
		System.out.println("3. Multiply");
		System.out.println("4. Devide");

		int calc_arithmetic_menu = scan.nextInt();

		System.out.print("Input numbers: ");
		double num1 = scan.nextDouble();
		double num2 = scan.nextDouble();

		switch (calc_arithmetic_menu) {
		case 1:
			System.out.println(add(num1, num2));
			break;

		case 2:
			System.out.println(subtract(num1, num2));
			break;
		case 3:
			System.out.println(multiply(num1, num2));
			break;
		case 4:
			System.out.println(devide(num1, num2));
			break;

		}
		// return calc_arithmetic_menu;
	}

	double add(double num1, double num2) {
		return num1 + num2;
	}

	double subtract(double num1, double num2) {
		return num1 - num2;
	}

	double multiply(double num1, double num2) {
		return num1 * num2;
	}

	double devide(double num1, double num2) {
		return num1 / num2;
	}

	void selectConvertorMenu() {
		System.out.println("1. Weight Convertor");
		System.out.println("2. Length Convertor");
		System.out.println("3. Temparature Convertor");

		int calc_convertor_menu = scan.nextInt();

		switch (calc_convertor_menu) {
		case 1:
			selectDirectionOfWeightConvertor();
			break;
		case 2:
			selectDirectionOfLengthConvertor();
			break;
		case 3:
			selectDirectionOfTemperatureConvertor();
			break;

		}
		// return calc_convertor_menu;

	}

	void selectDirectionOfWeightConvertor() {
		System.out.println("1. Kg to Pound");
		System.out.println("2. Pound to Kg");

		int calc_D_weight_menu = scan.nextInt();

		System.out.print("Input number : ");
		double weight = scan.nextInt();

		if (calc_D_weight_menu == 1)
			System.out.println(calc.convertKgToPound(weight));

		else if (calc_D_weight_menu == 2)
			System.out.println(calc.convertPoundToKg(weight));

	}

	void selectDirectionOfLengthConvertor() {
		System.out.println("1. Inch to cm");
		System.out.println("2. cm to Inch");

		int calc_D_length_menu = scan.nextInt();

		System.out.print("Input number : ");
		double length = scan.nextInt();

		if (calc_D_length_menu == 1)
			System.out.println(calc.convertInchToCm(length));

		else if (calc_D_length_menu == 2)
			System.out.println(calc.convertInchToCm(length));

		// return calc_D_length_menu;

	}

	void selectDirectionOfTemperatureConvertor() {
		System.out.println("1. Fahrenheit To Celsius ");
		System.out.println("2. Celsius To Fahrenheit");

		int calc_D_temp_menu = scan.nextInt();

		System.out.print("Input number : ");
		double temp = scan.nextInt();

		if (calc_D_temp_menu == 1)
			System.out.println(calc.convertInchToCm(temp));

		else if (calc_D_temp_menu == 2)
			System.out.println(calc.convertInchToCm(temp));

	}

	double convertKgToPound(double weight) {
		return weight * 2.2204;

	}

	double convertPoundToKg(double weight) {
		return weight * 0.4535;
	}

	double convertInchToCm(double length) {
		return length * 2.54;
	}

	double convertCmToInch(double length) {
		return length * 0.3937;
	}

	double convertFahrenheitToCelsius(double temperature) {
		return (temperature - 32) / 1.8;
	}

	double convertCelsiusToFahrenheit(double temperature) {
		return (temperature * 1.8) + 32;
	}
}
/*
 * 
 * double add(double num1, double num2) {} double subtract(double num1, double
 * num2) {} double multiply(double num1, double num2) {} double divide(double
 * num1, double num2)
 * 
 * int selectDirectionOfWeightConvertor() double convertKgToPound(double weight)
 * 
 * double convertPoundToKg(double weight) int selectDirectionOfLengthConvertor()
 * double convertInchToCm(double length) double convertCmToInch(double length)
 * 
 * int selectDirectionOfTemperatureConvertor() double
 * convertFahrenheitToCelsius(double temperature) double
 * convertCelsiusToFahrenheit(double temperature)
 */