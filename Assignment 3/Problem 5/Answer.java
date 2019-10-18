  
import java.util.Scanner;
class B{
    double k;
    int l;
}
public class A{
    
    static int [] c;
    public static void func (int t, int n,B a[]){
        for(int i=t+1;i<t+n;i++){
            double key=a[i].k;
            int f=a[i].l;
            int j=i-1;
            while( (j>=t) && (key>a[j].k)){
                a[j+1].k=a[j].k;
                a[j+1].l=a[j].l;
                j--;
            }
            a[j+1].k=key;
            a[j+1].l=f;
        }
    }
    
    public static void main(String args[]){
        
        Scanner var=new Scanner(System.in);
        int n=var.nextInt();
        c=new int[n];
        int s=0;
        for(int i=0;i<n;i++){
            int x=var.nextInt();
            c[i]=x;
            s+=x;
        }
        double [] p=new double[s];
        double [] w=new double[s];
        B [] a=new B[s];  
        for(int i=0;i<s;i++){
            p[i]=var.nextDouble();
        }       
        for(int i=0;i<s;i++){
            a[i]=new B();
            w[i]=var.nextDouble();
            a[i].k=w[i]/p[i];
            a[i].l=i;
        }
        
        int sum=0;
        int[][] r=new int[n][100];
        B []b=new B[n];
        for(int i=0;i<n;i++){
            b[i]=new B();
            double ww=0;
            double pp=0;
            func(sum,c[i],a);
            for(int j=0;j<c[i];j++){
                ww+=w[a[sum+j].l];
                pp+=p[a[sum+j].l];
                r[i][j]=a[sum+j].l+1;
            }
            b[i].k=ww/pp;
            b[i].l=i;
            sum+=c[i];
        }
        
        func(0,n,b);
        /*for(int i=1;i<s;i++){
            double key=a[i].k;
            int f=a[i].l;
            int j=i-1;
            while( (j>=0) && (key>a[j].k)){
                a[j+1].k=a[j].k;
                a[j+1].l=a[j].l;
                j--;
            }
            a[j+1].k=key;
            a[j+1].l=f;
        }*/
        /* int g=0;
         int t=0;
        for(int i=0;i<s;i++){
            g+=w[a[i].l]*(p[a[i].l]+t);
            t+=p[a[i].l];
        }
        System.out.println(g);
        for(int i=0;i<s;i++){
            System.out.println(a[i].l+1);
        }*/
        int g=0;
        int t=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<c[b[i].l];j++){
                g+=w[r[b[i].l][j]-1]*(p[r[b[i].l][j]-1]+t);
                t+=p[r[b[i].l][j]-1];
            }
        }
        System.out.println(g);
        for(int i=0;i<n;i++){
            for(int j=0;j<c[b[i].l];j++){
                System.out.println(r[b[i].l][j]);
            }
        }
    }
}