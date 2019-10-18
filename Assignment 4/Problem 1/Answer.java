import java.util.Scanner;

class Node{
    int d;
    int color;
    String v="";
    Node pi;
    Node(String s){
        this.v=s;
    }
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
    Queue(){
        this.n=0;
        t=null;
        h=null;
    }
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
    
    public static Node g[];
    public static Adj a[]; 
    public static int n;
    
    public static boolean connect(String s1, String s2){
        s1=s1.toLowerCase();
        s2=s2.toLowerCase();
        if(s1.length()==s2.length()){
            int c=0;
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i)==s2.charAt(i)){
                    c++;
                }
            }
            if (c==s1.length()-1)
                return true;
            else
                return false;
        }
        else if(s1.length()==s2.length()-1 || s1.length()==s2.length()+1){
            int m=Math.min(s1.length(),s2.length());
            if(s1.length()>s2.length()){
                String t; t=s1; s1=s2; s2=t;
            }
            int j=0;
            for (int i = 0; i < m+1; i++) {
                if(j<m && s1.charAt(j)==s2.charAt(i))
                    j++;              
            }
            if(j==m)
                return true;
            else
                return false;
        }
        
        return false;
    }
    
    public static String bfs(int v1,int v2){
        String s="";
        int f=0;
        for(int i=0;i<n;i++){
            if(i!=v1){
                g[i].d=Integer.MAX_VALUE;
                g[i].color=0;
                g[i].pi=null;
            }
        }
        g[v1].color=1;
        g[v1].d=0;
        g[v1].pi=null;
        Queue q=new Queue();
        /*q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.t.p);*/
        q.enqueue(v1);
        
        while(q.n!=0){
            int x=q.dequeue();
            Adj t1=a[x];
            Adj t=t1;
            while(t.next!=null){
                t=t.next;
                if(g[t.p].color==0){
                    g[t.p].color=1;
                    g[t.p].d=g[t1.p].d+1;
                    g[t.p].pi=g[t1.p];
                    if(t.p==v2){
                        f=1;
                        break;
                    }
                    //System.out.println(t.p);
                    q.enqueue(t.p);
                }
                if(f==1)
                    break;
                
            }
            g[t1.p].color=2;
            if(f==1)
                break;
            
        }
        if(f==1){
            Node t=g[v2];
            s+=g[v2].v;
            while(t.pi!=null){
                t=t.pi;
                s+=" "+t.v;
            }
        }
        else
            s="*";
        
        return s;
        
    }
    
    public static void main(String args[]){
        Scanner var=new Scanner(System.in);
        n=var.nextInt();  
        int query=var.nextInt();
        g=new Node[n];
        a=new Adj[n];
        for(int i=0;i<n;i++){
            g[i]=new Node(var.next());
            a[i]=new Adj(i);
        }
        
        for (int i = 0; i < n; i++) {
            Adj t=a[i];
            for (int j = 0; j < n; j++) {
                if(j!=i && connect(g[i].v,g[j].v)){
                    t.next=new Adj(j);
                    t=t.next;
                }
            }
        }
        
        
     
        /*Adj t=a[0];
        while(t.next!=null){
               t=t.next;
               System.out.println(g[t.p].v);
        }*/
        
        for (int i = 0; i < query; i++) {
            int v1=-1;
            int v2=-1;
            String s1=var.next();
            String s2=var.next();
            for (int j = 0; j < n; j++) {
                if(s1.equalsIgnoreCase(g[j].v)){
                    v1=j;
                    
                }
                if(s2.equalsIgnoreCase(g[j].v)){
                    v2=j;
                }
            }
            if(v1!=-1 && v2!=-1){
                System.out.println(bfs(v2,v1));
            }
            else
                System.out.println("*");
        }
        
        
    }
}