package account;

public class PurchaseInfo {

	public PurchaseInfo(String date, String content, int price) {
		// TODO Auto-generated constructor stub
		this.date=date;
		this.price=price;
		this.content=content;
	}
	
	private String date;
	private int price;
	private String content;
	
	public void printList(){
		System.out.println("date:"+ date);
		System.out.println("content:"+ content);
		System.out.println("price:"+ price);
	}
	
	/*public PurchaseInfo(Date date,String content,int price) {
		this.date= date;
		this.content = content ;
		this.price = price ;	
	}*/
	
	
}
