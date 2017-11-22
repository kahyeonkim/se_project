import java.util.*;

public class MemoManager {
	ArrayList<String> memoList = new ArrayList();
	int memoCount = 0;
	
	public int selectMemoMenu() {
		Scanner scanner = new Scanner(System.in);
		//scanner도 private?
		int userChoice;
		//이건 private하면 return이 안되네ㅠ
		
		System.out.println("1. Create Memo");
		System.out.println("2. Update Memo");
		System.out.println("3. Delete Memo");
		System.out.println("4. Print Memo List");
		System.out.println("5. Go Back to Main");
		System.out.println("> ");
		
		userChoice = scanner.nextInt(); //scanner.nextline할지뭐할지 통일하기 
		scanner.nextLine();
		
		return userChoice; 	
	}
	
	public void create(String memo) {
		memoList.add(memo);
		memoCount++; // 지금은 0번째 메모부터 번호매김
		printMemo(memoCount, "생성");
	}
	
	public void update(int memoNumber, String newMemo) {
		memoList.remove(memoNumber);
		memoList.add(memoNumber, newMemo);
		printMemo(memoNumber, "수정");
	}
	
	public void delete(int memoNumber) {
		String memo = memoList.get(memoNumber);
		
		memoList.remove(memo);
		memoCount--;
		printMemo(memoCount, "삭제");
	}
	
	private void printMemo(int memoNumber, String function) {
		String contents = memoNumber + " 번째 메모가" + function + "되었습니다."; 
		System.out.println(contents);
	}

	public void printMemoList() {
		for(int i = 0; i < memoList.size(); i++) {
			String memo = memoList.get(i);
			System.out.println(i + "번째 메모: " + memo);
			}
	}
	
	public void goBackToMain() {
	//	MainProgram.printInitialScreen();

	}
}
