public class Matrix {
    public void search(int[][] mat, int n, int x){
        int i = 0;
        int j = n-1;
        while(i<n && j>=0){
            if(mat[i][j] == x){
                System.out.println("found the key at, x : " + i + " y : "+ j);
                return;
            }
            if(mat[i][j] > x){
                j--;
            }
            else{
                i++;
            }
        }
        System.out.println("key not found");
    }
    public void printSpiral(int[][] mat, int r, int c){
        int i; int k = 0; int l = 0;
        while(k<r && l<c){
            for(i = l; i<c; i++){
                System.out.print(mat[k][i] + ", ");
            }
            k++;
            for(i = k; i<r; i++){
                System.out.print(mat[i][c-1] + ", ");
            }
            c--;
            if(k<r){
                for(i = c-1; i>=l;i-- ){
                    System.out.print(mat[r-1][i] + ", ");
                }
                r--;
            }
            if(l < c){
                for(i = r-1; i >= k; i--){
                    System.out.print(mat[i][l] + ", ");
                }
                i++;
            }
        } 
    }
    public static void main(String[] args) {
        int[][] mat = {{10, 20, 30, 40},
                       {15, 25, 35, 45},
                       {27, 29, 37, 48},
                       {32, 33, 39, 51}};
        Matrix m = new Matrix();
        m.search(mat, mat.length, 10);
        m.printSpiral(mat, mat.length, mat.length);
    }
}
