import java.util.*;
public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.println("N(데이터 갯수)와 구간 a, b를 차례대로 입력하세요.");
		//N, 구간 a, b 입력 받기
		int n = sc.nextInt(); 
		int a1 = sc.nextInt(); 
		int a2 = sc.nextInt();
		int b1 = sc.nextInt();
		int b2 = sc.nextInt();
		
		//N개의 배열을 생성한 뒤 임의의 랜덤 데이터를 할당
	    int[] arr = new int[n];
	    for (int i = 0; i < arr.length; i++) {
	        arr[i] = rd.nextInt();
	    }
	    
	    //a 구간에 해당하는 데이터의 최소값, 최대값, 합계를 출력
	    int a_min = arr[a1-1];
	    int a_max = arr[a1-1];
	    int a_sum = 0;
	    for(int i=a1-1;i<a2;i++) {
	    	if(arr[i]<a_min) {
	    		a_min = arr[i];
	    	}
	    	if(arr[i]>a_max) {
	    		a_max = arr[i];
	    	}
	    	a_sum += arr[i];
	    }
	    int b_min = arr[b1-1];
	    int b_max = arr[b1-1];
	    int b_sum = 0;
	    for(int i=b1-1;i<b2;i++) {
	    	if(arr[i]<b_min) {
	    		b_min = arr[i];
	    	}
	    	if(arr[i]>b_max) {
	    		b_max = arr[i];
	    	}
	    	b_sum += arr[i];
	    }

	    System.out.println(a_min+" "+a_max+" "+a_sum);
	    System.out.println(b_min+" "+b_max+" "+b_sum);

	}

}
