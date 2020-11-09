import java.util.Random;
import java.util.Scanner;

public class firstA {
	/*
	 * 두 가지 방법으로 만들어보았습니다.
	 * 1. firstA / termproject : termproject 파일에 클래스 객체를 생성하여 firstA에
	 * 객체를 불러와 구현하였습니다.
	 * 
	 * 2. Test1 : 객체를 구성하지 않고 하나의 파일에 코드를 짰습니다.
	 * 
	 * + git에 처음 올린 파일에는 1. 방법에서 클래스 객체가 분리되어있지 않습니다.
	 *   또 올바르게 동작하는지 보기 위해 배열에 각 원소들을 출력하는 코드를 작성한 것을
	 *   삭제하지 않았습니다.
	 * 
	 * + 랜덤 넘버 범위가 인트 범위라고 하셔서 숫자 범위만 다시 수정했습니다.
	 */
	
	public static void main(String[] args) {
		System.out.println("N(데이터 갯수)와 구간 a, b를 차례대로 입력하세요.");
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		termproject pr = new termproject();
		
		pr.size = sc.nextInt();
		pr.a1 = sc.nextInt();
		pr.a2 = sc.nextInt();
		int b1 = sc.nextInt();
		int b2 = sc.nextInt();
		pr.array = new int[pr.size];
		for (int i = 0; i < pr.array.length; i++) {
	        pr.array[i] = rd.nextInt();
	    }
		sc.close();

		int minimum = pr.mini(pr.a1, pr.a2);
		int maximum = pr.maxi(pr.a1, pr.a2);
		int sum = pr.sum(pr.a1, pr.a2);
		
		int minimum2 = pr.mini(b1, b2);
		int maximum2 = pr.maxi(b1, b2);
		int sum2 = pr.sum(b1, b2);
		
		System.out.println(minimum+" "+maximum+" "+sum);
		System.out.println(minimum2+" "+maximum2+" "+sum2);

	}
}
	
