import java.util.Scanner;

class Node{
    int d;
    int color;
    int h;
    Node pi;
}

class Adj{
    int p;
    Adj next;
    Adj pre;
    Adj(int x){
        this.p=x;
    }
}

class Queue{
    static int n;
    static Adj t;
    static Adj h;
    public static void enqueue(int x){
        if(n==0){
            t=new Adj(x);
            h=t;
        }
        else{
            Adj temp=t;
            t.next=new Adj(x);
            t=t.next;
            t.pre=temp;
        }
        n++;
    }
    public static int dequeue(){
        if(n==1){
            int temp=h.p;
            t=null;
            h=null;
            n--;
            return temp;
        }
        else if(n!=0){
            int temp=h.p;
            h=h.next;
            h.pre=null;
            n--;
            return temp;
        }
        else
            return -1;
      
    }
}

public class A{
    

    public static void main(String args[]){
        Scanner var=new Scanner(System.in);
        int n=var.nextInt();      
        Node g[]=new Node[n+1];
        Adj a[]=new Adj[n+1];
        for(int i=0;i<n+1;i++){
            g[i]=new Node();
            a[i]=new Adj(i);
        }
        int m=var.nextInt();
        int k=var.nextInt();
        
        
        Adj t=a[0];
        for(int i=0;i<k;i++){
            int f=var.nextInt();
            g[f].h=1;
            t.next=new Adj(f);
            t=t.next;
            
        }
        
        for(int i=0;i<m;i++){
            int v1=var.nextInt();
            int v2=var.nextInt();
            
            t=a[v1];
            while(t.next!=null)
                t=t.next;
            t.next=new Adj(v2);
            
            t=a[v2];
            while(t.next!=null)
                t=t.next;
            t.next=new Adj(v1);
            
        }
        
        /*t=a[8];
        while(t.next!=null){
            t=t.next;
            System.out.println(t.p);
        }*/
        
        for(int i=1;i<n+1;i++){
            g[i].d=Integer.MAX_VALUE;
        }
        g[0].color=1;
        Queue q=new Queue();
        /*q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.t.p);*/
        q.enqueue(0);
        
        while(q.n!=0){
            int x=q.dequeue();
            Adj t1=a[x];
            t=t1;
            while(t.next!=null){
                t=t.next;
                if(g[t.p].color==0){
                    g[t.p].color=1;
                    g[t.p].d=g[t1.p].d+1;
                    g[t.p].pi=g[t1.p];
                    //System.out.println(t.p);
                    q.enqueue(t.p);
                }
                
            }
            g[t1.p].color=2;
            
        }
        //System.out.println("*****************");
        for(int i=1;i<n+1;i++)
            System.out.println(g[i].d-1);
        
    }
}