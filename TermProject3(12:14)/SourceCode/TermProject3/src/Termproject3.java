import java.io.*;

//쿼리의 구간이 노드의 구간을 일부 포함되면 자식 노드로 이동한다.
//쿼리의 구간이 노드의 구간을 포함하거나 같으면 노드의 값을 부모 노드로 반환한다.
//쿼리의 구간과 노드의 구간이 서로 포함 관계가 없으면 부모 노드로 아무것도 반환하지 않는다.
 
import java.util.*;
public class Termproject3 {
    private static int[] minTree, maxTree;
    private static long[] sumTree;

    private static int minInit(int[] v, int start, int end, int node) {
        if (start == end) {return minTree[node] = v[start];}
        int mid = (start + end) / 2;
        minTree[node] = Math.min(minInit(v, start, mid, node * 2), 
        						 minInit(v, mid + 1, end, node * 2 + 1));
        return minTree[node];
    }

    private static int minQuery(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {return Integer.MAX_VALUE;} 
        if (left <= start && end <= right) {return minTree[node];}
        int mid = (start + end) / 2;
        int result = Math.min(minQuery(start, mid, node * 2, left, right), 
        				      minQuery(mid + 1, end, node * 2 + 1, left, right));
        return result;
    }

    private static int maxInit(int[] v, int start, int end, int node) {
        if (start == end) {return maxTree[node] = v[start];}
        int mid = (start + end) / 2;
        maxTree[node] = Math.max(maxInit(v, start, mid, node * 2), 
        					     maxInit(v, mid + 1, end, node * 2 + 1));
        return maxTree[node];
    }

    private static int maxQuery(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {return -1;}
        if (left <= start && end <= right) {return maxTree[node];}
        int mid = (start + end) / 2;
        int result = Math.max(maxQuery(start, mid, node * 2, left, right), 
        					  maxQuery(mid + 1, end, node * 2 + 1, left, right));
        return result;
    }
    
    private static long sumInit(int[] v, int start, int end, int node) {
        if (start == end) {return sumTree[node] = v[start];}
        int mid = (start + end) / 2;
        sumTree[node] = sumInit(v, start, mid, node * 2) +
        				sumInit(v, mid + 1, end, node * 2 + 1);
        return sumTree[node];
    }
    
    private static long sumQuery(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {return 0;}
        if (left <= start && end <= right) {return sumTree[node];}
        int mid = (start + end) / 2;
        long result = sumQuery(start, mid, node * 2, left, right)+
        			 sumQuery(mid + 1, end, node * 2 + 1, left, right);
        return result;
    }
    
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	Random rd = new Random();
        int n = sc.nextInt(), k = sc.nextInt();
        
        int[] v = new int[n+1]; // v에 랜덤하게 값을 저장.
		for(int i = 0; i<n ; i++) v[i] = rd.nextInt();
		
        
		int[] p1 = new int[k], p2 = new int[k]; // 구간값의 배열 생성, 랜덤하게 값을 저장.
        for(int i=0; i<k; i++) {
			int a = (int)(Math.random()*(n-1));
			int b = (int)(Math.random()*(n-1));
			if( a < b) { p1[i] = a; p2[i] = b;} 
			else {p1[i] = b; p2[i] = a;}
		}
        
		long startTime = System.currentTimeMillis();
		minTree = new int[n * 4]; //min, max, sum tree 생성
        maxTree = new int[n * 4];
        sumTree = new long[n * 4];
        
		int[] minarr = new int[k]; //min, max, sum 결과값을 담을 배열 생성
		int[] maxarr = new int[k];
		long[] sumarr = new long[k];
		
	    minInit(v, 0, n - 1, 1); //min, max, sum 초기화
	    maxInit(v, 0, n - 1, 1);
	    sumInit(v, 0, n - 1, 1);
		
        for (int i = 0; i < k; i++) { // 구간 부르며 min, max, sum 값 저장
            int a = p1[i]; int b = p2[i];
            int min = minQuery(0, n - 1, 1, a, b);
            int max = maxQuery(0, n - 1, 1, a, b);
            long sum = sumQuery(0, n - 1, 1, a, b);
            minarr[i] = min; maxarr[i] = max; sumarr[i] = sum;
        }
        long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime));
		System.out.println((endTime - startTime)/1000+"초");
		sc.close();
    }
}

/* min, max, sum 이 잘 나오는지 보기 위한 코드
for(int i=0; i<v.length; i++) {
	System.out.println(i+" : "+v[i]);
}
for(int i=0; i<k; i++) {
	System.out.println(p1[i]+"-"+p2[i]+":"+maxarr[i]+" "+minarr[i]+" "+sumarr[i]);
}
*/
