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
			case 1: // 메모기능 
				MemoManager memoManager = new MemoManager();
				int memoMenu;
				do{
					memoManager.selectMemoMenu();					
					switch(memoMenu) {
					case 1:
						System.out.println("새로운 메모 내용을 입력하세요: ");
						String newMemo = scan.nextLine(); //한 줄만 받을수있음
						memoManager.create(newMemo);
						break;
					case 2:
						System.out.println("수정할 메모의 번호를 입력하세요: ");
						int memoNumberToUpdate = scan.nextInt();
						System.out.println("수정할 메모의 내용을 입력하세요:");
						String updateMemo = scan.nextLine(); //한 줄만 받을수있음
						memoManager.update(memoNumberToUpdate, updateMemo);				
						break;
					case 3:
						System.out.println("삭제할 메모의 번호를 입력하세요: ");
						int memoNumberToDelete = scan.nextInt();
						memoManager.delete(memoNumberToDelete);
						break;
					case 4:
						memoManager.printMemoList();
						break;
					}					
				} while(memoMenu != 5);				
				break;
				
			case 2: //계산기 기능
				Calculator calculator = new Calculator();
				int calculatorMenu;
				do{
					calculatorMenu = calculator.selectCalculatorMenu();
					switch(calculatorMenu) {
					case 1: //사칙 연산
						double num1, num2;
						int arithmeticOperationMenu = calculator.selectArithmeticOperationMenu();
						switch(arithmeticOperationMenu) {
						case 1:
							System.out.print("덧셈을 수행할 두 실수를 입력하세요: ");
							num1 = scan.nextDouble();
							num2 = scan.nextDouble();
							calculator.add(num1, num2);
							break;
						case 2:
							System.out.print("뺄셈을 수행할 두 실수를 입력하세요: ");
							num1 = scan.nextDouble();
							num2 = scan.nextDouble();
							calculator.subtract(num1, num2);
							break;
						case 3:
							System.out.print("곱셈을 수행할 두 실수를 입력하세요: ");
							num1 = scan.nextDouble();
							num2 = scan.nextDouble();
							calculator.multiply(num1, num2);
							break;
						case 4:
							System.out.print("나눗셈을 수행할 두 실수를 입력하세요: ");
							num1 = scan.nextDouble();
							num2 = scan.nextDouble();
							calculator.divide(num1, num2);
							break;
						}
						break;
					case 2: //단위 변환
						double weight, length, temperature;
						int direction;
						int convertorMenu = calculator.selectConvertMenu();
						switch(convertorMenu) {
						case 1:
							direction = calculator.selectDirectionOfWeightConvertor();
							if (direction == 1) {
								System.out.print("무게(kg)를 입력하세요: ");
								weight = scan.nextDouble();
								calculator.convertKgToPound(weight);
							}
							if (direction == 2) {
								System.out.print("무게(pound)를 입력하세요: ");
								weight = scan.nextDouble();
								calculator.convertPoundToKg(weight);
							}
							break;
						case 2:
							direction = calculator.selectDirectionOfLengthConvertor();
							if (direction == 1) {
								System.out.print("길이(Inch)를 입력하세요: ");
								length = scan.nextDouble();
								calculator.convertInchToCm(length);
							}
							if (direction == 2) {
								System.out.print("길이(cm)를 입력하세요: ");
								length = scan.nextDouble();
								calculator.convertCmToInch(length);
							}
							break;
						case 3:
							direction = calculator.selectDirectionOfTemperatureConvertor();
							if (direction == 1) {
								System.out.print("온도(F)를 입력하세요: ");
								temperature = scan.nextDouble();
								calculator.convertFahrenheitToCelsius(temperature);
							}
							if (direction == 2) {
								System.out.print("온도(C)를 입력하세요: ");
								temperature = scan.nextDouble();
								calculator.convertCelsiusToFahrenheit(temperature);
							}
							break;
						}
						break;
					}					
				} while(calculatorMenu != 3);
				break;
				
			case 3: //가계부
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
						System.out.println("새로운 구매 내역을 입력하세요.");
						System.out.print("구매 날짜(ex. 2017 11 22): ");
						year = scan.nextInt(); 
						month = scan.nextInt();
						date = scan.nextInt();						
						purchaseDate.setYear(year);
						purchaseDate.setMonth(month);
						purchaseDate.setDate(date);
						System.out.print("구매 제품: ");
						item = scan.nextLine();
						System.out.print("가격: ");
						price = scan.nextInt();
						PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseDate, item, price);
						accountBook.create(purchaseInfo);
						break;
					case 2:												
						System.out.println("수정할 구매 내역을 입력하세요.");
						System.out.print("구매 내역 번호: ");
						purchaseNumberToUpdate = scan.nextInt();
						System.out.print("구매 날짜(ex. 2017 11 22): ");
						year = scan.nextInt(); //날짜 어케 받을 거 ????
						month = scan.nextInt();
						date = scan.nextInt();
						purchaseDate.setYear(year);
						purchaseDate.setMonth(month);
						purchaseDate.setDate(date);
						System.out.print("구매 제품: ");
						item = scan.nextLine();
						System.out.print("가격: ");
						price = scan.nextInt();
						PurchaseInfo newPurchaseInfo = new PurchaseInfo(purchaseNumberToUpdate, purchaseDate, item, price);
						accountBook.update(purchaseNumberToUpdate, newPurchaseInfo);						
						break;
					case 3:
						System.out.println("삭제할 구매 내역의 번호를 입력하세요.");
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
