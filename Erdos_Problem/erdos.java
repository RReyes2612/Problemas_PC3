package PC3.Erdos_Problem;
import java.util.*;
public class erdos {
    static final int MX=500;
    static List<Integer>[] adj= new List[MX];
    static int[] d= new int[MX];

    static void main() {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0; i<MX; i++) adj[i]= new ArrayList<>();

        for(int tst=1; tst<=T; tst++){

            for(int i=0; i<MX; i++){
                adj[i].clear();
                d[i]=-1;
            }

            int n= sc.nextInt(), Q= sc.nextInt();
            sc.nextLine();

            Map<String,Integer> mp= new HashMap<>();
            mp.put("Erdos, P.", 1);
            int cur=2;

            for(int i=0; i<n; i++){
                String s=sc.nextLine();
                int sz=s.length();
                List<Integer> a= new ArrayList<>();

                for(int j=0;j<sz; j++)
                    if(s.charAt(j)!=' '){
                        int cont=0;
                        StringBuilder t = new StringBuilder();

                        while(j<sz && cont<2 && s.charAt(j)!=':'){
                            if(s.charAt(j)==',') cont++;
                            if(cont==2) break;
                            t.append(s.charAt(j));
                            j++;
                        }

                        if(mp.get(t.toString())==null) mp.put(t.toString(), cur++);
                       // System.out.println(t.toString()+" "+mp.get(t.toString()));
                        a.add(mp.get(t.toString()));

                        if(j<sz && s.charAt(j)==':') break;
                }

                sz=a.size();
                for(int j=0; j<sz; j++) for(int k=j+1; k<sz; k++){
                    int u=a.get(j), v=a.get(k);
                    adj[u].add(v);
                    adj[v].add(u);
                }
            }

            d[1]=0;
            Queue<Integer> q= new ArrayDeque<>();
            q.add(1);
            while(!q.isEmpty()){
                int u=q.poll();
                for(int v: adj[u])
                    if(d[v]==-1){
                        d[v]=d[u]+1;
                        q.add(v);
                    }
            }
            System.out.println("Scenario "+tst);
            for(int i=0; i<Q; i++){
                String t=sc.nextLine();
                Integer u=mp.get(t);
                System.out.print(t+" ");
                if(u==null || d[u]==-1) System.out.println("infinity");
                else System.out.println(d[u]);

            }
        }
    }
}
