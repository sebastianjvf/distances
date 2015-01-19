/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statsemdistance;

import java.util.ArrayList;

/**
 * @author eegyedzsigmond
 */
public class DivergenceHistogramms extends Thread {

    ArrayList<Integer> histogramm1;
    ArrayList<Integer> histogramm2;
    int i;
    int i2;

    public DivergenceHistogramms(ArrayList<Integer> histogramm1,
                                 ArrayList<Integer> histogramm2,
                                 int i, int i2) {

        this.histogramm1 = histogramm1;
        this.histogramm2 = histogramm2;
        this.i = i;
        this.i2 = i2;
    }


    @Override
    public void run() {

        DistancesMT.distanceMatrix[i][i2] = DistancesMT.divergenceOfHistogrammes(histogramm1, histogramm2);

    }
}