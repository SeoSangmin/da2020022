import java.util.*;
public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack stack = new Stack();
		int index = 0;
		ArrayList<String> succ = new ArrayList<String>();
		int number = sc.nextInt();
		int Array[] = new int[number];
		for(int i=0; i<number; i++) {
			Array[i] = sc.nextInt();
        }
		for(int i=1; i<=number; i++) {
			stack.add(i);
			succ.add("+");
			while(!stack.isEmpty()&&Array[index]==(int)stack.peek()) {
				index++;
				stack.pop();
				succ.add("-");
			}
		}
		if(!stack.isEmpty()) 
			System.out.println("NO");
		else 
			for(char i=0;i<succ.size();i++) {
				System.out.println(succ.get(i));
			}
	}
}
