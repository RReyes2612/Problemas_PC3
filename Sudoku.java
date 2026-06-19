package PC3;
import java.util.*;
public class Sudoku {
    static final int n=3;
    static final int N=n*n;
    static boolean fila[][]= new boolean[N][N+1];
    static boolean  col[][]= new boolean[N][N+1];
    static boolean cuad[][][]= new boolean[n][n][N+1];
    static int ans[][]= new int[N][N];

    static void solve(int i, int j){
        if(j==N && i==N-1){
            for(int ii=0; ii<N; ii++){
                for(int jj=0; jj<N; jj++) System.out.print(ans[ii][jj]+" ");
                System.out.println();
            }
            System.out.println();
            return;
        }
        if(j==N) solve(i+1,0);
        for(int x=1; x<=N; x++){
            if(fila[i][x] || col[j][x] || cuad[i/n][j/n][x]) continue;
            ans[i][j]=x;
            fila[i][x]=true;
            col[j][x]=true;
            cuad[i/n][j/n][x]=true;
            solve(i,j+1);
            ans[i][j]=0;
            fila[i][x]=false;
            col[j][x]=false;
            cuad[i/n][j/n][x]=false;
        }
    }
    static void main() {
        Scanner sc=new Scanner(System.in);
        solve(0,0);
    }
}
