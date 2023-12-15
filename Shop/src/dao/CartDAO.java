package dao;

import java.util.ArrayList;

import vo.Cart;
import vo.Item;
import vo.User;

public class CartDAO {
	private ArrayList<Cart> cartList;
	public CartDAO(){
		cartList = new ArrayList<Cart>();
	}
	public void deleteAllCartListByOneUser(String id) {
		for(int i=0; i < cartList.size(); i+=1) {
			if(cartList.get(i).getUserId().equals(id)) {
				cartList.remove(i);
				i-=1;
			}
		}
	}
	public void addCartData(String id,String name) {
		Cart c = new Cart(id,name);
		cartList.add(c);
	}
	private ArrayList<Cart> getMyCartList(User user) {
		ArrayList<Cart> myList = new ArrayList<Cart>();
		for(Cart list :cartList) {
			if(list.getUserId().equals(user.getId())) {
				myList.add(list);
			}
		}
		return myList;
	}
	public void myCartList(User user) {
		System.out.println(user.getName() + "님의 장바구니 목록");
		for(Cart list :cartList) {
			if(list.getUserId().equals(user.getId())) {
				System.out.println(list);
			}
		}
		System.out.println("=============================");
	}
	public String getData() {
		String data = "";
		for(Cart list : cartList) {
			data += list.getData();
		}
		return data;
	}
	public void deleteMyCartList(User user) {
		ArrayList<Cart> myList = getMyCartList(user);
		if(myList.size() == 0) {
			System.out.println("장바구니가 비어있습니다.");
		}
		
	}
	public void loadDataFromFile(String data) {
		String temp[] = data.split("\n");
		for(int i=0; i < temp.length; i+=1) {
			String info[] = temp[i].split("/");
			Cart cart = new Cart(info[0], info[1]);
			cartList.add(cart);
		}
	}
}
