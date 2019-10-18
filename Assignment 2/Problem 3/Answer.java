import java.util.Scanner;

public class A{

    public static void main(String args[]){
        Scanner var=new Scanner(System.in);
        int n=var.nextInt();
        int m=4001;
        int [] a= new int[n];
        int [][] b=new int [n+1][m];
        for(int i=0;i<m;i++){
            b[0][i]=0;
        }
        
        for(int i=0;i<n;i++){
            a[i]=var.nextInt();
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=0;j<m;j++){
                if(j>2000){
                    b[i][j]=b[i-1][j-a[i-1]];
                }
                else{
                    b[i][j]=Math.max(1+b[i-1][j+a[i-1]],b[i-1][2000-a[i-1]]);
                }
     
            }
        }
        
        /*for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println("");
        }*/
        System.out.println(b[n][2000]);
        
        
    }
}