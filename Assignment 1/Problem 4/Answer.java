import static java.lang.Math.abs;
import java.util.Scanner;
import java.util.Arrays;
public class A{
    
    public static void main(String[] args){
        
        Scanner var=new Scanner(System.in);
        long s=var.nextLong();
        long m=var.nextLong();
        long c=0;
        long k=1;
        while(s!=m){
            if(s>m){
                k=s/m;
                if(k*m==s)
                    k--;
                s-=k*m;
            }
            else{
                k=m/s;
                if(k*s==m)
                    k--;
                m-=s*k;
            }
            c+=k;
        }
        if(s==1)
            System.out.println(c);
        else
            System.out.println("impossible");
    }
}