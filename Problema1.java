package PC3;
import java.sql.SQLOutput;
import java.util.*;
public class Problema1 {
    //No dirigido
    static final int N=100;
    static boolean g[][]= new boolean[N][N];
    static boolean used[]= new boolean[N];
    static int d[]= new int[N];
    static void bfs(int r, int n){
        Queue<Integer> q= new ArrayDeque<>();
        q.offer(r);
        used[r]=true;
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v=1; v<=n; v++) if(g[u][v]){
                if(used[v]) continue;
                q.offer(v);
                used[v]=true;
            }
        }
    }
    static void main() {
        Scanner sc= new Scanner(System.in);
        int n=sc.next().charAt(0)-'A'+1;
        int m=sc.nextInt();
        for(int i=0; i<m; i++){
            String s=sc.next(); //AB
            int u=s.charAt(0)-'A'+1, v=s.charAt(1)-'A'+1;
            g[u][v]=true;
            g[v][u]=true;
        }
        int comp=0;
        for(int u=1;u<=n; u++) if(!used[u]){
            comp++;
            bfs(u,n);
        }
        System.out.println(comp);
    }
    //7 8 1 2 1 3 1 4 2 3 3 4 4 6 4 7 3 5
}
