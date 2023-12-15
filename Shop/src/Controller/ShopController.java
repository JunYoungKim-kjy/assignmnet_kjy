package Controller;

import Utils.InputManager;
import dao.CartDAO;
import dao.ItemDAO;
import dao.UserDAO;

public class ShopController {
	UserDAO uDAO;
	ItemDAO iDAO;
	CartDAO cDAO;
	
	public ShopController(){
		cDAO = new CartDAO();
		uDAO = new UserDAO();
		iDAO = new ItemDAO();
	}
	public void run() {
		while (true) {
			printMenu();
			int sel = InputManager.getValue("메뉴입력", 0, 100);
			if (sel == 0) {//종료
				System.out.println("종료");
				return;
			} else if (sel == 1) {//가입
				uDAO.insertUser();
			} else if (sel == 2) {//탈퇴
				uDAO.exitUser(cDAO);
			} else if (sel == 3) {//로그인

			} else if (sel == 4) {//로그아웃

			} else if (sel == 100) {//관리자

			} else {
				System.out.println("없는 메뉴입니다.");
				continue;
			}
		}
	}
	private void printMenu() {
		System.out.println("[1.가입]");
		System.out.println("[2.탈퇴]");
		System.out.println("[3.로그인]");
		System.out.println("[4.로그아웃]");
		System.out.println("[100.관리자]");
		System.out.println("[0. 종료");
	}
	private void loginMenu() {
		System.out.println("[1.쇼핑]");
		System.out.println("[2.장바구니목록]");
		System.out.println("[0.뒤로가기]");
	}
	private void myPageMenu() {
		System.out.println("[1.내 장바구니]");
		System.out.println("[2.삭제]");
		System.out.println("[3.장바구니관리]");
		System.out.println("[4.마이페이지]");
		System.out.println("[0.뒤로가기]");
	}
	private void adminMenu() {
		System.out.println("[1.아이템관리]");
		System.out.println("[2.카테고리관리]");
		System.out.println("[3.장바구니관리]");
		System.out.println("[4.유저목록관리]");
		System.out.println("[0.뒤로가기]");
	}
	
	// 	System.out.println("[1.가입] [2.탈퇴] [3.로그인] [4.로그아웃]" + "\n[100.관리자] [0.종료] ");  
	
	// 	System.out.println("[1.쇼핑] [2.장바구니목록] [0.뒤로가기]");
	
	// 	System.out.println("[1.내 장바구니] [2.삭제] [3.구입] [0.뒤로가기]");
}
// 	System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기] ");