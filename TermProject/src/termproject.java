import java.util.Random;
import java.util.Scanner;

class termproject {
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	int min;
	int max;
	int sum;
	int size;
	int a1;
	int a2;
	int[] array;
	termproject() {}
	public int mini(int a1, int a2) {
		min = array[a1];
	    for(int i=a1-1;i<a2;i++) {
	    	if(array[i]<min) {
	    		min = array[i];
	    	}
	    }
		return min;
	}
	public int maxi(int a1, int a2) {
		max = array[a1];
		for(int i=a1-1;i<a2;i++) {
			if(array[i]>max) {
	    		max = array[i];
	    	}
		}
		return max;
	}
	public int sum(int a1, int a2) {
		sum = 0;
		for(int i=a1-1;i<a2;i++) {
			sum += array[i];
		}
		return sum;
	}
}