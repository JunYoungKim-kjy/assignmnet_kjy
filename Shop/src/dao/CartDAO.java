package dao;

import java.util.ArrayList;

import vo.Cart;
import vo.User;

public class CartDAO {
	private ArrayList<Cart> cartList;
	public CartDAO(){
		cartList = new ArrayList<Cart>();
	}
	public void deleteAllCartListByOneUser(User user) {
		for(int i=0; i < cartList.size(); i+=1) {
			if(cartList.get(i).getUserId().equals(user.getId())) {
				cartList.remove(i);
				i-=1;
			}
		}
	}
	public String getData() {
		String data = "";
		for(Cart list : cartList) {
			data += list.getData();
		}
		return data;
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
