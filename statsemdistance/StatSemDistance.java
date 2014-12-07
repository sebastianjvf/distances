package statsemdistance;

import java.util.ArrayList;
import java.util.Map;

public class StatSemDistance {

    public static void main(String[] args) {
        Map imagesTags = Distances.mapFromDatabase("jdbc:postgresql://localhost:5432/ist_zwei", "sebastianjvf", "");

        if (Distances.PRINT == 1)
            System.out.println("ImageTags size : " + imagesTags.size());

        /* Calculate representativeTags */
        ArrayList representativeTags = Distances.getRepresentativeTags(imagesTags, Distances.REFERENCE_TAG_PERCENTAGE);
        System.out.println("Most representative Tags of input: " + representativeTags);

        /* Distance Matrix */
        Distances.printDistanceMatrix(Distances.calculcateDistanceMatrix(imagesTags, representativeTags));
    }

}
