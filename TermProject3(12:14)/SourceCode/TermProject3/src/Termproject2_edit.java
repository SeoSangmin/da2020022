import java.util.Random; 
import java.util.Scanner;
public class Termproject2_edit {
	static Random rd = new Random();
	static int[] array, minarr, maxarr;
	static long[] sumarr;
	public static void all(int s, int p1, int p2) {
		int a = p1, b = p2;
		int min = array[a];
		int max = array[b];
		int sum = 0;
		for(int i=p1;i<=p2;i++) {
			if(array[i]<min) {
	    		min = array[i];
	    	}
			if(array[i]>max) {
	    		max = array[i];
	    	}
			sum += array[i];
		}
		minarr[s] = min; maxarr[s] = max; sumarr[s] = sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		int N = sc.nextInt(), K = sc.nextInt();
		
		array = new int[N];
		for (int i = 0; i < N; i++) {
	        array[i] = rd.nextInt();
	    }
		
		long startTime = System.currentTimeMillis();
		minarr = new int[K];
		maxarr = new int[K];
		sumarr = new long[K];
		
		int[] p1 = new int[K], p2 = new int[K];
        for(int i=0; i<K; i++) {
			int a = (int)(Math.random()*(N-1));
			int b = (int)(Math.random()*(N-1));
			if( a < b) {
				p1[i] = a; p2[i] = b;
			} else {
				p1[i] = b; p2[i] = a;
			}
		}
        
        for(int i = 0; i<K; i++){
        	int a = p1[i], b = p2[i];
        	all(i, a, b);
        }
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime));
		System.out.println((endTime - startTime)/1000+"초");
		
		sc.close();
	}
}