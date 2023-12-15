package dao;

import java.util.ArrayList;

import vo.Cart;
import vo.Item;
import vo.User;

public class ItemDAO {
	ArrayList<Item> itemList;
	public ItemDAO(){
		itemList = new ArrayList<Item>();
	}
	private void printItemList() {
		for(Item list : itemList) {
			System.out.println(list);
		}
	}
	public void shopping(User user, CartDAO cDAO) {
		printItemList();
	}
	public String getData() {
		String data = "";
		for(Item list : itemList) {
			data += list.getData();
		}
		return data;
	}
	public void loadDataFromFile(String data) {
		String temp[] = data.split("\n");
		for(int i=0; i < temp.length; i+=1) {
			String info[] = temp[i].split("/");
			Item item = new Item(info[0], Integer.parseInt(info[1]));
			itemList.add(item);
		}
	}
}
