import java.util.Date;
import java.util.Scanner;

public class MainProgram {
	Scanner scan = new Scanner(System.in);
	
	public int selectMenu() {		
		System.out.println("1. Memo Manager");
		System.out.println("2. Calculator");
		System.out.println("3. Account Book");
		//System.out.println("4. Quit");
		
		int menu = scan.nextInt();
		return menu;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainProgram main = new MainProgram();
		Scanner scan = new Scanner(System.in);
		int menu;
		
		do {
			menu = main.selectMenu();
			
			switch(menu) {
			case 1: // �޸��� 
				MemoManager memoManager = new MemoManager();
				int memoMenu;
				do{
					memoManager.selectMemoMenu();					
					switch(memoMenu) {
					case 1:
						System.out.println("���ο� �޸� ������ �Է��ϼ���: ");
						String newMemo = scan.nextLine(); //�� �ٸ� ����������
						memoManager.create(newMemo);
						break;
					case 2:
						System.out.println("������ �޸��� ��ȣ�� �Է��ϼ���: ");
						int memoNumberToUpdate = scan.nextInt();
						System.out.println("������ �޸��� ������ �Է��ϼ���:");
						String updateMemo = scan.nextLine(); //�� �ٸ� ����������
						memoManager.update(memoNumberToUpdate, updateMemo);				
						break;
					case 3:
						System.out.println("������ �޸��� ��ȣ�� �Է��ϼ���: ");
						int memoNumberToDelete = scan.nextInt();
						memoManager.delete(memoNumberToDelete);
						break;
					case 4:
						memoManager.printMemoList();
						break;
					}					
				} while(memoMenu != 5);				
				break;
				
			case 2: //���� ���
				Calculator calculator = new Calculator();
				int calculatorMenu;
				do{
					calculatorMenu = calculator.selectCalculatorMenu();
					switch(calculatorMenu) {
					case 1: //��Ģ ����
						double num1, num2;
						int arithmeticOperationMenu = calculator.selectArithmeticOperationMenu();
						switch(arithmeticOperationMenu) {
						case 1:
							System.out.print("������ ������ �� �Ǽ��� �Է��ϼ���: ");
							num1 = scan.nextDouble();
							num2 = scan.nextDouble();
							calculator.add(num1, num2);
							break;
						case 2:
							System.out.print("������ ������ �� �Ǽ��� �Է��ϼ���: ");
							num1 = scan.nextDouble();
							num2 = scan.nextDouble();
							calculator.subtract(num1, num2);
							break;
						case 3:
							System.out.print("������ ������ �� �Ǽ��� �Է��ϼ���: ");
							num1 = scan.nextDouble();
							num2 = scan.nextDouble();
							calculator.multiply(num1, num2);
							break;
						case 4:
							System.out.print("�������� ������ �� �Ǽ��� �Է��ϼ���: ");
							num1 = scan.nextDouble();
							num2 = scan.nextDouble();
							calculator.divide(num1, num2);
							break;
						}
						break;
					case 2: //���� ��ȯ
						double weight, length, temperature;
						int direction;
						int convertorMenu = calculator.selectConvertMenu();
						switch(convertorMenu) {
						case 1:
							direction = calculator.selectDirectionOfWeightConvertor();
							if (direction == 1) {
								System.out.print("����(kg)�� �Է��ϼ���: ");
								weight = scan.nextDouble();
								calculator.convertKgToPound(weight);
							}
							if (direction == 2) {
								System.out.print("����(pound)�� �Է��ϼ���: ");
								weight = scan.nextDouble();
								calculator.convertPoundToKg(weight);
							}
							break;
						case 2:
							direction = calculator.selectDirectionOfLengthConvertor();
							if (direction == 1) {
								System.out.print("����(Inch)�� �Է��ϼ���: ");
								length = scan.nextDouble();
								calculator.convertInchToCm(length);
							}
							if (direction == 2) {
								System.out.print("����(cm)�� �Է��ϼ���: ");
								length = scan.nextDouble();
								calculator.convertCmToInch(length);
							}
							break;
						case 3:
							direction = calculator.selectDirectionOfTemperatureConvertor();
							if (direction == 1) {
								System.out.print("�µ�(F)�� �Է��ϼ���: ");
								temperature = scan.nextDouble();
								calculator.convertFahrenheitToCelsius(temperature);
							}
							if (direction == 2) {
								System.out.print("�µ�(C)�� �Է��ϼ���: ");
								temperature = scan.nextDouble();
								calculator.convertCelsiusToFahrenheit(temperature);
							}
							break;
						}
						break;
					}					
				} while(calculatorMenu != 3);
				break;
				
			case 3: //�����
				AccountBook accountBook = new AccountBook();
				int year, month, date;
				String item;
				int price;
				int accountBookMenu;
				int purchaseNumberToUpdate, purchaseNumberToDelete;
				
				do{
					accountBookMenu = accountBook.selectAccountBookMenu();
					Date purchaseDate = new Date();
					switch(accountBookMenu) {
					case 1:
						System.out.println("���ο� ���� ������ �Է��ϼ���.");
						System.out.print("���� ��¥(ex. 2017 11 22): ");
						year = scan.nextInt(); 
						month = scan.nextInt();
						date = scan.nextInt();						
						purchaseDate.setYear(year);
						purchaseDate.setMonth(month);
						purchaseDate.setDate(date);
						System.out.print("���� ��ǰ: ");
						item = scan.nextLine();
						System.out.print("����: ");
						price = scan.nextInt();
						PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseDate, item, price);
						accountBook.create(purchaseInfo);
						break;
					case 2:												
						System.out.println("������ ���� ������ �Է��ϼ���.");
						System.out.print("���� ���� ��ȣ: ");
						purchaseNumberToUpdate = scan.nextInt();
						System.out.print("���� ��¥(ex. 2017 11 22): ");
						year = scan.nextInt(); //��¥ ���� ���� �� ????
						month = scan.nextInt();
						date = scan.nextInt();
						purchaseDate.setYear(year);
						purchaseDate.setMonth(month);
						purchaseDate.setDate(date);
						System.out.print("���� ��ǰ: ");
						item = scan.nextLine();
						System.out.print("����: ");
						price = scan.nextInt();
						PurchaseInfo newPurchaseInfo = new PurchaseInfo(purchaseNumberToUpdate, purchaseDate, item, price);
						accountBook.update(purchaseNumberToUpdate, newPurchaseInfo);						
						break;
					case 3:
						System.out.println("������ ���� ������ ��ȣ�� �Է��ϼ���.");
						purchaseNumberToDelete = scan.nextInt();
						accountBook.delete(purchaseNumberToDelete);						
						break;
					case 4:
						accountBook.printAccountList();
						break;
					}					
				} while(accountBookMenu != 5);
				break;
			}
			
		} while (menu != 4);			
		
	}

}
