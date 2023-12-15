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
}
