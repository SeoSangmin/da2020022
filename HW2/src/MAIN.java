import java.util.*;
 
public class MAIN{
    public static String isValid(String str) {  
         str = str.trim();
         char stack[] = str.toCharArray();
         int c = 0;
         
         for(int i =0; i<stack.length; i++){
            if(stack[i]=='(') {
            	c=c+1;
            }
            else {
            	c=c-1;
            }
            if(c<0){              
                return "NO";
            }
          }   
 
           if(c==0) {
                return "YES";
           }
           else {
                return "NO";
           }
    }
 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            System.out.println(isValid(sc.nextLine()));
        }
    }
}
