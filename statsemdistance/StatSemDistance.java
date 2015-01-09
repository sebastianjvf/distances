package statsemdistance;

import java.util.ArrayList;
import java.util.Map;

public class StatSemDistance {

    public static void main(String[] args) {
        Map imagesTags = DistancesMT.mapFromDatabase("jdbc:postgresql://localhost:5432/ist_zwei", "sebastianjvf", "");

        /* EXAMPLE
        *
        *  1. Read example.cvs in res/
        *  2. Create a Map "imagesTags" according to the specifications in Distances.java
        *  3. Compute Representative Tags
        *  4. Compute a distance matrix by utilising the representative tags
        *
        * */
        // Map imagesTags = DistancesMT.imageTagsFromFile("example.cvs");

        if (DistancesMT.PRINT == 1)
            System.out.println("ImageTags size : " + imagesTags.size());

        /* Calculate representativeTags */
        ArrayList representativeTags = DistancesMT.getRepresentativeTags(imagesTags, DistancesMT.REFERENCE_TAG_PERCENTAGE);
        System.out.println("Most representative Tags of input: " + representativeTags);

        /* Distance Matrix */
        DistancesMT.printDistanceMatrix(DistancesMT.calculcateDistanceMatrix(imagesTags, representativeTags));
    }

}
