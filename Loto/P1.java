package PC3.Loto;
import java.util.*;
public class P1 {
    static int[] a= new int[14];
    static int[] ans= new int[6];
    static void solve(int i, int cont, int n){
        if(cont==6){
            for(int x: ans) System.out.print(x+" ");
            System.out.println();
            return;
        }
        if (i>=n) return;
        ans[cont]=a[i];
        solve(i+1,cont+1,n);
        ans[cont]=0;
        solve(i+1,cont,n);
    }
    static void main() {
        Scanner sc= new Scanner(System.in);
        while(true){
            int n=sc.nextInt();
            if(n==0) break;
            for(int i=0; i<n; i++) a[i]=sc.nextInt();
            solve(0,0,n);
        }

    }
}
