package statsemdistance;

import java.util.ArrayList;
import java.util.Map;

public class StatSemDistance {

    public static void main(String[] args) {
        // Map imagesTags = Distances.mapFromDatabase("jdbc:postgresql://localhost:5432/ist_zwei", "sebastianjvf", "");

        /* EXAMPLE
        *
        *  1. Read example.cvs in res/
        *  2. Create a Map "imagesTags" according to the specifications in Distances.java
        *  3. Compute Representative Tags
        *  4. Compute a distance matrix by utilising the representative tags
        *
        * */
        Map imagesTags = Distances.imageTagsFromFile("example.cvs");

        if (Distances.PRINT == 1)
            System.out.println("ImageTags size : " + imagesTags.size());

        /* Calculate representativeTags */
        ArrayList representativeTags = Distances.getRepresentativeTags(imagesTags, Distances.REFERENCE_TAG_PERCENTAGE);
        System.out.println("Most representative Tags of input: " + representativeTags);

        /* Distance Matrix */
        Distances.printDistanceMatrix(Distances.calculcateDistanceMatrix(imagesTags, representativeTags));
    }

}
