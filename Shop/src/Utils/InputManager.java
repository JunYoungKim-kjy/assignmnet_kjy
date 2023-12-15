package Utils;

import java.util.Random;
import java.util.Scanner;

public class InputManager {
	private static Scanner sc;
	private static Random rd;
	private static InputManager instance = new InputManager();

	private InputManager() {
		sc = new Scanner(System.in);
		rd = new Random();
	}
	public static int getValue(String msg, int start, int end) {
		System.out.printf("%s [%d~%d]", msg, start, end);
		try {
			int input = sc.nextInt();
			if (input < start || input > end) {
				System.out.println("입력 범위 오류");
				return 0;
			}
			return input;
		} catch (Exception e) {
			sc.nextLine();
			System.out.println("숫자값만 입력 가능합니다.");
		}
		return 0;
	}
	public static String getValue(String msg) {
		System.out.println(msg);
		return sc.next();
	}
}
