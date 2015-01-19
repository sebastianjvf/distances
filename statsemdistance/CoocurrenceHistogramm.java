/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statsemdistance;

import java.util.ArrayList;
import java.util.Map;

import static statsemdistance.Distances.calculateCooccurrences;

/**
 * @author eegyedzsigmond
 */
public class CoocurrenceHistogramm extends Thread {

    int i;
    ArrayList<String> tagpool;
    Map imagesTags;
    ArrayList<String> representativeTags;

    public CoocurrenceHistogramm(int i,
                                 ArrayList<String> tagpool,
                                 Map imagesTags,
                                 ArrayList<String> representativeTags) {
        this.i = i;
        this.tagpool = tagpool;
        this.imagesTags = imagesTags;
        this.representativeTags = representativeTags;
    }


    @Override
    public void run() {

        ArrayList<Integer> cooccurrence = calculateCooccurrences(tagpool.get(i), representativeTags, imagesTags);
        DistancesMT.histogramms.put(i, cooccurrence);

    }
}