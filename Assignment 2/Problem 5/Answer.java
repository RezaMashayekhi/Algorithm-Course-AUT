import java.util.Scanner;


public class A {
    public static void main (String args[]){
        Scanner var=new Scanner (System.in);
        int n= var.nextInt();
        String s=var.next();
        int []a=new int [n+1];
        int []b=new int [n];
        a[n]=0;
        a[n-1]=0;
        for(int i=n-2;i>=0;i--){
            if(  (s.charAt(i)=='(')&&(s.charAt(i+a[i+1]+1)==')') || (s.charAt(i)=='<')&&(s.charAt(i+a[i+1]+1)=='>') || (s.charAt(i)=='{')&&(s.charAt(i+a[i+1]+1)=='}') || (s.charAt(i)=='[')&&(s.charAt(i+a[i+1]+1)==']') ){
                a[i]=2+a[i+1]+a[i+a[i+1]+2];
            }
            else
                a[i]=0;
        }
        for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
        //System.out.println(a[0]);
    }
}