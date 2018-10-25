package Programmieren1;

public class Matrix {




    
    public boolean isSymmetric(int [] [] matrix) 
    {
        for(int zeile = 0; zeile < matrix.length; zeile++) 
        { // Für jede Zeile der Matrix
            System.out.println("Überprüfe Zeile "+zeile+": ");
            for(int spalte = 0; spalte < zeile; spalte++) 
            {  // Für jede Spalte in der aktuellen Zeile
                if(matrix[zeile][spalte] != matrix[spalte][zeile]) {
                    System.out.println("ist nicht symmetrisch!");
                    return false;
                }
                else 
                {
                    //System.out.println(" stimmen überein!");
                }
            }
        }
        System.out.println("Matrix ist symmetrisch!");
        System.out.println(matrix.length);
        return true;
    }
}