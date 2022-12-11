package RandomNumber;

import java.util.Random;

public class sparse{
    static int matrix [][] = new int[6][6];

    public static int randomGen(){
        int rA;
        Random r = new Random();
        rA = r.nextInt(100);
        return rA;
    }
    
    public static void matrixGen(){
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[i].length; j++){
                matrix[i][j] = randomGen();
            }
        }
    }

    

    public static void main(String args[]){
        new sparse();
    }
}