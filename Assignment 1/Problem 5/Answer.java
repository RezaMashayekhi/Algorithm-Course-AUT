import java.util.Scanner;


public class A {
    
    public static long merge(long[] a,int p, int r){
        if(p<r){
            int q=(p+r)/2;
            return merge(a,p,q)+
            merge(a,q+1,r)+
            mergeSort(a,p,q,r);
        }
        else
            return 0;
    }
    
    public static long mergeSort(long[] a, int p, int q, int r){
        int n1=q-p+1;
        int n2=r-q;
        long m=0;
        long[] la=new long[n1];
        long[] ra=new long[n2];
        for(int i=0; i<n1; i++){
            la[i]=a[p+i];
        }
        
        for(int i=0; i<n2; i++){
            ra[i]=a[q+1+i];
        }
        
        int lp=0, rp=0;
        
        for(int i=p; i<=r; i++){
            if( (lp<n1) && ((rp>=n2) || (la[lp]<ra[rp])) ){
                a[i]=la[lp];
                lp++;
            }
            else if( (rp<n2) && ((lp>=n1) || (la[lp]>ra[rp])) ){
                a[i]=ra[rp];
                if(lp<n1){
                    m+=(n1-1)-lp+1;
                }
                rp++;
            }
        }
        return m;
    }
    
    public static void main(String[] args){
        Scanner var=new Scanner(System.in);
        int n=var.nextInt();
        long[] a=new long[n];
        for(int i=0; i<n; i++){
            a[i]=var.nextInt();
        }
        
        System.out.println(merge(a, 0, n-1)%1000000007);
        
        /*for(int i=0; i<n; i++){
            System.out.println(a[i]);
        }*/
    }   
}


