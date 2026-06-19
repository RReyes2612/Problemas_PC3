package PC3.Passwords;
import java.util.*;
public class Password {
    static final int MX= 105;
    static StringBuilder s= new StringBuilder();
    static List<String> words= new ArrayList<>();
    static void solve(int i, String rule){
        if(i==rule.length()){
            System.out.println(s.toString());
            return;
        }
        if(rule.charAt(i)=='0'){
            for(char c='0'; c<='9'; c++){
                s.append(c);
                solve(i+1,rule);
                s.deleteCharAt(s.length()-1);
            }
        }else{
            for(String t: words) {
                s.append(t);
                solve(i+1, rule);
                s.setLength(s.length()-t.length());
            }
        }
    }

    static void main() {
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            int N=sc.nextInt();
            words.clear();
            if(N==0) break;
            for(int i=0; i<N; i++){
                String t=sc.next();
                words.add(t);
            }
            int m=sc.nextInt();
            for(int i=0; i<m; i++){
                String rule=sc.next();
                System.out.println("--");
                solve(0,rule);
            }
        }

    }
}
