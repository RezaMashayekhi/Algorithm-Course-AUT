import java.util.Scanner;


public class A {
    public static void main (String args[]){
        Scanner var=new Scanner (System.in);
        int n= var.nextInt();
        int q= var.nextInt();
        int [] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=var.nextInt();
        }
        int [][] b=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            b[i][i+1]=1;
        }
        
        for(int i=2;i<n+1;i++)
            for(int j=i-2;j>=0;j--){
                int m=(j+i)/2;
                if((b[j][m]==1)&&(b[m][i]==1)&&(a[m-1]<=a[m]))
                    b[j][i]=1;
                else
                    b[j][i]=b[j][m]+b[m][i]+1;
                
            }

        for(int i=0;i<q;i++){
            int a1=var.nextInt();
            int a2=var.nextInt();
            System.out.println(b[a1-1][a2-1]);
        }
    }
}
