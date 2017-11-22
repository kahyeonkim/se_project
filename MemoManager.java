import java.util.*;

public class MemoManager {
	ArrayList<String> memoList = new ArrayList();
	int memoCount = 0;
	
	public int selectMemoMenu() {
		Scanner scanner = new Scanner(System.in);
		//scanner�� private?
		int userChoice;
		//�̰� private�ϸ� return�� �ȵǳפ�
		
		System.out.println("1. Create Memo");
		System.out.println("2. Update Memo");
		System.out.println("3. Delete Memo");
		System.out.println("4. Print Memo List");
		System.out.println("5. Go Back to Main");
		System.out.println("> ");
		
		userChoice = scanner.nextInt(); //scanner.nextline���������� �����ϱ� 
		scanner.nextLine();
		
		return userChoice; 	
	}
	
	public void create(String memo) {
		memoList.add(memo);
		memoCount++; // ������ 0��° �޸���� ��ȣ�ű�
		printMemo(memoCount, "����");
	}
	
	public void update(int memoNumber, String newMemo) {
		memoList.remove(memoNumber);
		memoList.add(memoNumber, newMemo);
		printMemo(memoNumber, "����");
	}
	
	public void delete(int memoNumber) {
		String memo = memoList.get(memoNumber);
		
		memoList.remove(memo);
		memoCount--;
		printMemo(memoCount, "����");
	}
	
	private void printMemo(int memoNumber, String function) {
		String contents = memoNumber + " ��° �޸�" + function + "�Ǿ����ϴ�."; 
		System.out.println(contents);
	}

	public void printMemoList() {
		for(int i = 0; i < memoList.size(); i++) {
			String memo = memoList.get(i);
			System.out.println(i + "��° �޸�: " + memo);
			}
	}
	
	public void goBackToMain() {
	//	MainProgram.printInitialScreen();

	}
}
