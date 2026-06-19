package PC3.Oil_Deposits;
import java.util.*;
public class Oil_Deposits {
    static final int N= 100;
    static boolean[][] a= new boolean[N][N];
    static boolean[][] used= new boolean[N][N];
    static int[] di={1,-1,0,0,-1,-1,1,1};
    static int[] dj={0,0,1,-1,1,-1,1,-1};
    static void main() {
        Scanner sc= new Scanner(System.in);
        while(true){
            int n=sc.nextInt(), m=sc.nextInt();
            if(n==0 || m==0) break;
            for(int i=0; i<n; i++){
                String s=sc.next();
                for(int j=0; j<m; j++){
                    used[i][j]=false;
                    char c=s.charAt(j);
                    a[i][j]=(c=='@');
                }
            }
            int comp=0;
            for(int i=0; i<n; i++) for(int j=0; j<m; j++) if(a[i][j] && !used[i][j]){
                comp++;
                Queue<Integer> q= new ArrayDeque<>();
                used[i][j]=true;
                q.offer(i*m+j);
                while(!q.isEmpty()){
                    int u=q.poll();
                    int ui=u/m;
                    int uj=u%m;
                    for(int k=0; k<8; k++){
                        int vi=ui+di[k], vj=uj+dj[k];
                        if(vi<0 || vi>=n || vj<0 || vj>=m || !a[vi][vj] || used[vi][vj]) continue;
                        q.offer(vi*m+vj);
                        used[vi][vj]=true;
                    }
                }
            }
            System.out.println(comp);
        }

    }
}
