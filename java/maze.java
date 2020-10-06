package recursion;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
public class mazePath {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[][] maze= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                maze[i][j] = sc.nextInt();
            }
        }
        boolean[][] vis=new boolean[n][n];
        int maxAllowed= sc.nextInt();
//        // System.out.println(maxAllowed);
//        System.out.println(countRatInMaize(maze,0,0,n-1,n-1,vis));
       boolean ans= ratInMaize(maze,0,0,n-1,n-1,maxAllowed,0, vis);
        System.out.println(ans);
    }
    public static boolean ratInMaize(int[][] maze,int srcRow,int srcCol,int destRow,int destCol,int maxAllowed ,int count, boolean vis[][]){
       boolean ans = true;
        if(srcRow<0 || srcCol<0 || srcRow>destRow || srcCol>destCol|| count>maxAllowed){
            ans=false;
             System.out.println(count);
            return ans;
        }
        else  if(srcRow==destRow && srcCol== destCol && count<=maxAllowed ){
             ans=true;
             System.out.println(count);
             return ans;
        }
        if(maze[srcRow][srcCol]==0) {
        	ans=false;
            // System.out.println(count);
           return ans;     
        }
        else {       	
            if(maze[srcRow][srcCol]==1 && vis[srcRow][srcCol]== false){
                vis[srcRow][srcCol]= true;
               ans= ratInMaize(maze,srcRow+1,srcCol,destRow,destCol,maxAllowed,count+1,  vis);
                ans=ratInMaize(maze,srcRow,srcCol+1,destRow,destCol,maxAllowed,count+1,  vis);
                ans= ratInMaize(maze,srcRow,srcCol-1,destRow,destCol,maxAllowed,count+1,  vis);
                ans =ratInMaize(maze,srcRow-1,srcCol,destRow,destCol,maxAllowed,count+1,  vis);
//                vis[srcRow][srcCol]= false;
            }   
        }
        return ans;
    }
    public static int countRatInMaize(int[][] maze,int srcRow,int srcCol,int destRow,int destCol, boolean vis[][]){
    	int countt = 0;
         if(srcRow<0 || srcCol<0 || srcRow>destRow || srcCol>destCol){
//        	 System.out.println(maze[srcRow][srcCol]);
        	 return 0;
         }
         if(srcRow==destRow && srcCol== destCol){
//        	 System.out.println(maze[srcRow][srcCol]+" fd");
        	 return 1;
         }
         if(maze[srcRow][srcCol]==0) {
            // System.out.println(count);
            return 0;
         }
         else{         	
             if(maze[srcRow][srcCol]==1 && vis[srcRow][srcCol]== false){
                 vis[srcRow][srcCol]= true;
                countt +=  countRatInMaize(maze,srcRow+1,srcCol,destRow,destCol,  vis);
                countt += countRatInMaize(maze,srcRow,srcCol+1,destRow,destCol,  vis);
                countt +=countRatInMaize(maze,srcRow,srcCol-1,destRow,destCol,  vis);
                countt +=countRatInMaize(maze,srcRow-1,srcCol,destRow,destCol,  vis);
                 vis[srcRow][srcCol]= false;
             }   
         }
         return countt;
     }
}
