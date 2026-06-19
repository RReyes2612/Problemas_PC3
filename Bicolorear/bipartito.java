package PC3.Bicolorear;
import java.util.*;

public class bipartito {
    static List<Integer>[] adj;
    static boolean[] used;
    static boolean[] tipo;
    static boolean dfs(int u, boolean t){
        tipo[u]=t;
        used[u]=true;
        for(int v: adj[u]){
            if(used[v] && tipo[v]==t) return false;
            else if(!used[v] && !dfs(v,!t)) return false;
        }
        return true;
    }
    static boolean bfs(int root){
        Queue<Integer> q= new ArrayDeque<>();
        q.add(root);
        used[root]=true;
        tipo[root]=true;
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v: adj[u]){
                if(used[v] && tipo[v]==tipo[u]) return false;
                else if(!used[v]){
                    q.add(v);
                    used[v]=true;
                    tipo[v]=!tipo[u];
                }
            }
        }
        return true;
    }
    static void main() {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        while(n!=0){
            int m= sc.nextInt();
            adj=new List[n];
            for(int i=0; i<n; i++) adj[i]=new ArrayList<>();
            while(m-->0){
                int u= sc.nextInt(), v= sc.nextInt();
                adj[u].add(v);
                adj[v].add(u);
            }
            used=new boolean[n];
            tipo=new boolean[n];
            boolean ok=true;
            for(int i=0; i<n; i++) if(!used[i] && !bfs(i)) ok=false;
            System.out.println(ok?"BICOLORABLE": "NOT BICOLORABLE");
            n= sc.nextInt();
        }
    }
}
