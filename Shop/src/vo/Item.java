package vo;

public class Item {
	 String name;
	 int price;
	 String category; // 카테고리 // 육류 , 과자 , 어류 , 과일 등등
	 public Item(String name, int price) {
		 super();
		 this.name = name;
		 this.price = price;
	 }
	 public String getName() {
		 return name;
	 }
	public int getPrice() {
		return price;
	}
}
