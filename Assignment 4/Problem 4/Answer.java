import java.util.Scanner;

class Row{
    int i,j1,j2;
    Row next;
    Row(int a, int b, int c){
        i=a;
        j1=b;
        j2=c;
    }
}

class Column{
    int j,i1,i2;
    Column next;
    Column(int a, int b, int c){
        j=a;
        i1=b;
        i2=c;
    }
}

public class A{
    static int g[][];
    static int rcounter;
    static int ccounter;
    static int match[];
    static int seen[];
    
    public static void build(){             
        Scanner var=new Scanner(System.in);
        int n=var.nextInt();  
        int m=var.nextInt();
        int a[][]=new int[n][m];
        for (int i = 0; i < n; i++) {
            String s=var.next();
            for (int j = 0; j < m; j++) {
                if(s.charAt(j)=='.'){
                    a[i][j]=1;
                }
                else
                    a[i][j]=0;
            }
        }
        
        Row r=new Row(-1,-1,-1);
        Row hr=r;
        rcounter=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(a[i][j]==1){
                    int s=j;
                    while(j<m && a[i][j]==1)
                        j++;
                    r.next=new Row(i,s,j-1);
                    r=r.next;
                    rcounter++;
                }                 
            }
        }
        
        Column c=new Column(-1,-1,-1);
        Column hc=c;
        ccounter=0;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if(a[i][j]==1){
                    int s=i;
                    while(i<n && a[i][j]==1)
                        i++;
                    c.next=new Column(j,s,i-1);
                    c=c.next;
                    ccounter++;
                }                 
            }
        }
        
        g=new int[rcounter][ccounter];        
        Row rp=hr;
        for (int i = 0; i < rcounter; i++) {
            rp=rp.next;
            Column cp=hc;
            for (int j = 0; j < ccounter; j++) {
                cp=cp.next;
                if(cp.i1<=rp.i && rp.i<=cp.i2 && cp.j<=rp.j2 && rp.j1<=cp.j)
                    g[i][j]=1;
                else
                    g[i][j]=0;
               // System.out.print(g[i][j]);
            }
            //System.out.println("");
        }
    }
    
    public static boolean find(int i){
        
        for(int j=0;j<ccounter;j++){
            
            if(g[i][j]==1 && seen[j]==0){
                
                seen[j]=1;
                
                if(match[j]==-1 || find(match[j])){ 
                    
                    match[j]=i;
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String args[]){
        build();
        
        match=new int[ccounter];
        int counter=0;
        for(int i=0; i<ccounter;i++){
            match[i]=-1;
            
        }
        
        for(int i=0;i<rcounter;i++){
            seen=new int[ccounter];
            if(find(i))
                counter++;
        }
        System.out.println(counter);
        
    }
}