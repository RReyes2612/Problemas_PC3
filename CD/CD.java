package PC3.CD;
import java.util.*;

public class CD {
    static int a[]= new int[20];
    static List<Integer> v= new ArrayList<>();
    static List<Integer> ans= new ArrayList<>();
    static int mx_sum=-1;
    static void solve(int i, int sum, int n, int lim){
        if(sum>lim) return;
        if(i==n){
            if(sum>mx_sum){
                ans=new ArrayList<>(v);
                mx_sum=sum;
            }
            return;
        }
        v.add(a[i]);
        solve(i+1,sum+a[i], n,lim);
        v.removeLast();
        solve(i+1,sum,n,lim);
    }

    static void main() {
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            mx_sum=-1;
            ans.clear();
            int lim=sc.nextInt();
            if(lim==0) break;
            int n=sc.nextInt();
            for(int i=0; i<n; i++) a[i]=sc.nextInt();
            solve(0,0,n,lim);
            if(mx_sum==-1){
                System.out.println("No solution");
            }else{
                for(int x: ans) System.out.print(x+" ");
                System.out.println("sum: "+mx_sum+" ");
            }
        }
    }
}
