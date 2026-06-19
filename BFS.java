package PC3;
import java.util.*;
public class BFS {
    //No dirigido
    static final int N=100;
    static boolean g[][]= new boolean[N][N];
    static boolean used[]= new boolean[N];
    static int d[]= new int[N];
    static void main() {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt(), m=sc.nextInt();
        for(int i=0; i<m; i++){
            int u=sc.nextInt(), v=sc.nextInt();
            g[u][v]=true;
            g[v][u]=true;
        }
        int r=6;
        Queue<Integer> q= new ArrayDeque<>();
        q.offer(r);
        used[r]=true;
        d[r]=0;
        //BFS
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v=1; v<=n; v++) if(g[u][v]){
                if(used[v]) continue;
                d[v]=d[u]+1;
                used[v]=true;
                q.offer(v);
            }
        }
        for(int u=1; u<=n; u++) System.out.println(u+": "+d[u]);
    }
    //7 8 1 2 1 3 1 4 2 3 3 4 4 6 4 7 3 5
}
