package PC3;
import java.util.*;
public class caballos {
    static final int MX=19;
    static int[][] a= new int[MX][MX];
    static int[][] base_outdeg= new int[MX][MX];
    static int[][] outdeg= new int[MX][MX];
    static int c=0;
    static int[] di = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dj = {2, -2, 1, -1, 2, -2, 1, -1};
    static void mark(int i, int j, int cont){
        a[i][j]=cont;
        for (int k = 0; k < 8; k++) {
            int ii = i + di[k], jj = j + dj[k];
            if (ii < 0 || ii >= MX || jj < 0 || jj >= MX) continue;
            outdeg[ii][jj]--;
        }
    }
    static void unmark(int i, int j){
        a[i][j]=0;
        for (int k = 0; k < 8; k++) {
            int ii = i + di[k], jj = j + dj[k];
            if (ii < 0 || ii >= MX || jj < 0 || jj >= MX) continue;
            outdeg[ii][jj]++;
        }
    }
    static boolean cmp(int a, int b){
        int i1=a/MX;
        int j1=a%MX;
        int i2=b/MX;
        int j2=b%MX;
        if (outdeg[i1][j1] == outdeg[i2][j2]) {
            if (i1 == i2) return j1 > j2;
            return i1 > i2;
        }
        return outdeg[i1][j1] > outdeg[i2][j2];
    }
    static boolean solve(int i, int j, int cont){
        c++;
        if(c>10000000) return false;
        if (cont == MX * MX) return true;
        List<Integer> valids=new ArrayList<>();
        for (int k = 0; k < 8; k++) {
            int ii = i + di[k], jj = j + dj[k];
            if (ii < 0 || ii >= MX || jj < 0 || jj >= MX || a[ii][jj]!=0) continue;
            valids.add(ii*MX+jj);
        }
        int n = valids.size();
        for (int ii = 1; ii < n; ii++)
            for (int jj = 0; jj < n - ii; jj++)
                if (cmp(valids.get(jj), valids.get(jj + 1))) Collections.swap(valids,jj,jj+1);
        for (int xd : valids) {
            int ii=xd/MX;
            int jj=xd%MX;
            mark(ii, jj, cont+1);
            if (solve(ii, jj, cont + 1)) return true;
            unmark(ii, jj);
        }
        return false;
    }

    static void main() {
        for (int i = 0; i < MX; i++)
            for (int j = 0; j < MX; j++) {
                for (int k = 0; k < 8; k++) {
                    int ii = i + di[k], jj = j + dj[k];
                    if (ii < 0 || ii >= MX || jj < 0 || jj >= MX) continue;
                    base_outdeg[ii][jj]++;
                }
            }
        for (int x = 0; x < MX; x++)
            for (int y = 0; y < MX; y++) {
                for (int i = 0; i < MX; i++)
                    for (int j = 0; j < MX; j++) {
                        a[i][j] = 0;
                        outdeg[i][j] = base_outdeg[i][j];
                    }
                c = 0;
                mark(x, y, 1);
                boolean ok = solve(x, y, 1);
                System.out.print("(x,y) = ("+(x+1)+", "+(y+1)+"): ");
                if(!ok){
                    System.out.println("No tiene solucion");
                    continue;
                }
                System.out.println("Si tiene solucion");
                for(int i=0; i<MX; i++){
                    for(int j=0; j<MX; j++) System.out.print(a[i][j]+" ");
                    System.out.println();
                }
            }
    }
}
