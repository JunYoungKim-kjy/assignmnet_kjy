package dao;

import java.util.ArrayList;

import Utils.InputManager;
import vo.Cart;
import vo.Item;
import vo.User;

public class ItemDAO {
	ArrayList<Item> itemList;
	public ItemDAO(){
		itemList = new ArrayList<Item>();
	}
	private void printItemList() {
		int num = 1;
		for(Item list : itemList) {
			System.out.printf("%d %s \n",num++,list);
		}
	}
	public void shopping(User user, CartDAO cDAO) {
		printItemList();
		int sel = InputManager.getValue("[쇼핑]번호선택", 1, itemList.size())-1;
		cDAO.addCartData(user.getId(),itemList.get(sel).getName());
		System.out.println(itemList.get(sel) + "장바구니 담기 완료");
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
			Item item = new Item(info[0], Integer.parseInt(info[1]),info[2]);
			itemList.add(item);
		}
	}
}
