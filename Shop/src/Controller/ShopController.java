package Controller;

import Utils.FileManager;
import Utils.InputManager;
import dao.CartDAO;
import dao.ItemDAO;
import dao.UserDAO;
import vo.User;

public class ShopController {
	UserDAO uDAO;
	ItemDAO iDAO;
	CartDAO cDAO;
	User log;
	FileManager fm;
	public ShopController(){
		cDAO = new CartDAO();
		uDAO = new UserDAO();
		iDAO = new ItemDAO();
		fm = new FileManager();
		fm.loadData(cDAO, uDAO, iDAO);
	}

	public void run() {
		printMenu();
		menu();
	}
	private void loginMenu() {
		while (true) {
			int sel = InputManager.getValue("메뉴입력", 0, 2);
			if(sel == 0) {
				System.out.println("뒤로가기");
				return;
			}else if(sel == 1) { //쇼핑
				iDAO.shopping(log,cDAO);
			}else if(sel == 2) { //장바구니목룍
				myPage();
			}
		}
	}
	private void myPage() {
		printMyPageMenu();
		int sel = InputManager.getValue("메뉴입력", 0, 3);
		if(sel == 0) {
			System.out.println("뒤로가기");
			return;
		}else if(sel == 1) { //내 장바구니
			cDAO.printMyList(log);
		}else if(sel == 2) { //삭제
			cDAO.deleteMyCartList(log);
		}else if(sel == 3) { //구입
			cDAO.buyItem(log);
		}
	}
	
	private void menu() {
		while (true) {
//			System.out.println("자동 저장 완료");
			fm.saveData(cDAO, uDAO, iDAO);
			int sel = InputManager.getValue("메뉴입력", 0, 100);
			if (sel == 0) {// 종료
				System.out.println("종료");
				return;
			} else if (sel == 1) {// 가입
				uDAO.insertUser();
			} else if (sel == 2) {// 탈퇴
				uDAO.exitUser(cDAO);
			} else if (sel == 3) {// 로그인
				log = uDAO.login();
				if(log != null) {
					printLoginMenu();
					loginMenu();
				}
			} else if (sel == 4) {// 로그아웃
				if(log==null) {
					System.out.println("로그인 상태가 아닙니다.");
					return;
				}
				log = null;
				return;

			} else if (sel == 100) {// 관리자
				if(uDAO.adminlogin()) {
					adminMenu();
				}
			} else {
				System.out.println("없는 메뉴입니다.");
				continue;
			}
		}
	}
	private void adminMenu() {
		printAdminMenu();
		int sel = InputManager.getValue("[관리자메뉴]메뉴입력", 0, 4);
		if(sel == 0) {
			System.out.println("종료");
			return;
		}else if(sel == 1) {//아이템관리
			itemManager();
		}else if(sel == 2) {//카테고리관리
			iDAO.categoriManager();
		}else if(sel == 3) {//장바구니관리
//			basketManager();
		}else if(sel == 4) {//유저목록관리
//			userListManager();
		}
	}
	private void itemManager() {
		System.out.println("[1.아이템 추가] [2. 아이템 삭제] [0.뒤로가기]");
		int sel = InputManager.getValue("[관리자메뉴]메뉴입력", 0, 2);
		if(sel == 0) {
			System.out.println("종료");
			return;
		}else if(sel == 1) {//아이템추가
			iDAO.insertItem();
		}else if(sel == 2) {//아이템삭제ㅔ
			iDAO.deleteItem(cDAO);
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
	private void printLoginMenu() {
		System.out.println("[1.쇼핑]");
		System.out.println("[2.장바구니목록]");
		System.out.println("[0.뒤로가기]");
	}
	private void printMyPageMenu() {
		System.out.println("[1.내 장바구니]");
		System.out.println("[2.삭제]");
		System.out.println("[3.구입]");
		System.out.println("[0.뒤로가기]");
	}
	private void printAdminMenu() {
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