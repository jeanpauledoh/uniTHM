package Programmieren1;

public class Matrix {




    
    public boolean isSymmetric(int [] [] matrix) 
    {
        for(int zeile = 0; zeile < matrix.length; zeile++) 
        { // F�r jede Zeile der Matrix
            System.out.println("�berpr�fe Zeile "+zeile+": ");
            for(int spalte = 0; spalte < zeile; spalte++) 
            {  // F�r jede Spalte in der aktuellen Zeile
                if(matrix[zeile][spalte] != matrix[spalte][zeile]) {
                    System.out.println("ist nicht symmetrisch!");
                    return false;
                }
                else 
                {
                    //System.out.println(" stimmen �berein!");
                }
            }
        }
        System.out.println("Matrix ist symmetrisch!");
        System.out.println(matrix.length);
        return true;
    }
}