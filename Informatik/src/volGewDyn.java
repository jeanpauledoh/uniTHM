public class volGewDyn
{
public static void main(String[] args){
  int[][] erg;
  int [] volumen = {1,3,1,1};
  int[] gewicht={1,2,1,1};
  int[] wert={5,3,6,5};
 int volkapa=2;
 int gewKapa=2;
  erg=Algo(volumen,gewicht,wert,volkapa,gewKapa);
 
          
             for(int i=0;i<gewicht.length;i++){
                 for(int j=0;j<Math.max(gewKapa,volkapa);j++){
                     System.out.print(erg[i][j]+("  " ));
                    }
                    System.out.println();
}
        
    }
 
 
 
public static int[][] Algo(int [] volumen, int [] gewicht, int[] wert , int volkapa,int gewKapa){
 
    int[][] c= new int[gewicht.length+1][Math.max(gewKapa,volkapa)+1];
 
 
    for(int j=0;j<Math.max(gewKapa,volkapa)+1;j++){
        c[0][j]=0;
    }
    
    for(int i=1;i<gewicht.length;i++){
        for(int j=0;j<Math.max(gewKapa,volkapa)+1;j++){
            if(j<gewicht[i] ||  j< volumen[i]){
 
                c[i][j]= c[i-1][j];
            }
            else{
                
                c[i][j]=Math.max(c[i-1][j],wert[i-1]+(c[i-1][j-gewicht[i]]) );
            
        }
        }
    }
    return c;
}
}