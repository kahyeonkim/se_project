package account;

import java.util.ArrayList;
//import java.util.Date;
import java.util.Scanner;
import account.PurchaseInfo;

public class AccountBook {

	private static int menu;
	static Scanner scan = new Scanner(System.in);
	static ArrayList<PurchaseInfo> purchaseInfos = new ArrayList<>();
	
	public static void main(String[] args) {
		while (menu != 5) {
			selectAccountBookMenu();
			goToSelectedMenu();
		}
	}

	public static int selectAccountBookMenu() {
		System.out.println("1.내역 생성 ");
		System.out.println("2. 수정");
		System.out.println("3. 삭제 ");
		System.out.println("4. 전체 출력 ");
		System.out.println("5. 메인메뉴로 돌아가기 ");
		System.out.print("실행하실 메뉴를 선택하세요:");
		menu = scan.nextInt();
		return menu;
	}

	// 이건 메인에서 구현?
	private static void goToSelectedMenu() {
		// Date date=new Date();
	
		switch (menu) {
		case 1:
			String date = new String();
			System.out.print("날짜:");
			date = scan.next();
			String content = new String();
			System.out.print("내용:");
			content = scan.next();
			System.out.print("가격:");
			int price ;
			price = scan.nextInt();
			
			PurchaseInfo purchaseInfo = new PurchaseInfo(date, content, price);
			create(purchaseInfo);
			break;
		case 2:
			System.out.print("수정할 가계부 번호:");
			int purchaseNum;
			purchaseNum=scan.nextInt();
			System.out.print("날짜:");
			date = scan.next();
			System.out.print("내용:");
			content = scan.next();
			System.out.print("가격:");
			price = scan.nextInt();
			purchaseInfo = new PurchaseInfo(date, content, price);
			update(purchaseNum,purchaseInfo);
			break;
		case 3:
			int purchaseNum2=scan.nextInt();
			delete(purchaseNum2);
			break;
		case 4:
			printAccountLists();
			break;
		}
	}

	public static void create(PurchaseInfo purchaseInfo) {
		int purchaseNum=0;
		purchaseInfos.add(purchaseNum, purchaseInfo);
		printAccountList(purchaseNum, purchaseInfo);
		purchaseNum++;
	}

	private static void printAccountList(int purchaseNum,PurchaseInfo purchaseinfo) {
		//purchaseinfo = purchaseInfos.get(purchaseNum).p();
		purchaseInfos.get(purchaseNum).printList();
	}

	public static void update(int purchaseNum,PurchaseInfo purchaseinfo) {
		// int purchaseNumber, PurchaseInfo newPurchaseInfo
		purchaseInfos.set(purchaseNum,purchaseinfo);
	}
	

	public static void delete(int purchaseNum) {
		// int purchaseNumber
		purchaseInfos.remove(purchaseNum);
	}

	public static void printAccountLists() {
		for(int i=0;i<purchaseInfos.size();i++){
			System.out.println("번호:"+i);
			purchaseInfos.get(i).printList();
		}
	}

}

// 메인 함수는 없애기
