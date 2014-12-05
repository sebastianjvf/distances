/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statsemdistancenetbeans;

import java.util.ArrayList;
import java.util.Map;
import static statsemdistancenetbeans.Distances.REFERENCE_TAG_PERCENTAGE;
import static statsemdistancenetbeans.Distances.calculcateDistanceMatrix;
import static statsemdistancenetbeans.Distances.getRepresentativeTags;
import static statsemdistancenetbeans.Distances.mapFromDatabase;

/**
 *
 * @author eegyedzsigmond
 */
public class StatSemDistanceNetbeans {

    public static void printDistanceMatrix(double[][] theMatrix) {

        int size = theMatrix.length;
        for (int j = 0; j < size; j++) {
            System.out.print(j + ", ");
            for (int i = 0; i < size; i++) {
                System.out.print(theMatrix[i][j] + ", ");

            }
            System.out.println("");
        }

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Map imagesTags = mapFromDatabase("jdbc:postgresql://localhost:5432/2014GettyClean", "postgres", "postgres");
        if (Distances.PRINT==1) 
            System.out.println("ImageTags size : "+imagesTags.size());
        
        /* Calculate representativeTags */
        ArrayList representativeTags = getRepresentativeTags(imagesTags, REFERENCE_TAG_PERCENTAGE);
        System.out.println(representativeTags);
        /* 

        // Testing histogramm function
        ArrayList<Integer> histogramm1 = calculateCooccurrences("allemagne", representativeTags, imagesTags);
        ArrayList<Integer> histogramm2 = calculateCooccurrences("france", representativeTags, imagesTags);
        System.out.println(divergenceOfHistogrammes(histogramm1, histogramm2, representativeTags));
        */

        /* Distance Matrix */
        printDistanceMatrix(calculcateDistanceMatrix(imagesTags, representativeTags));

    }
    
}
