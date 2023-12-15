package dao;

import java.util.ArrayList;

import Utils.InputManager;
import vo.User;

public class UserDAO {
	ArrayList<User> userList;
	public UserDAO(){
		userList = new ArrayList<User>();
	}
	public void insertUser() {
		System.out.println("=====[회원가입]=====");
		String id = InputManager.getValue("아이디 입력");
		if(getUserById(id)!= null) {
			System.out.println("이미 존재하는 아이디 입니다.");
			return;
		}
		String pw = InputManager.getValue("비밀번호 입력");
		String name = InputManager.getValue("이름 입력");
		User user = new User(id, pw, name);
		userList.add(user);
		System.out.println("회원가입 완료");
		System.out.println(user);
	}
	private User getUserById(String id) {
		for(User list : userList) {
			if(id.equals(list.getId())) {
				return list;
			}
		}
		return null;
	}
	
}
