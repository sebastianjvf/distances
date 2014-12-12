/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadpooltest;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author eegyedzsigmond
 */
public class PoolThread extends Thread {

    private String name = null;
 
    public PoolThread(String name) {
        this.name = name;
    }
 
     
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        double somme=1;
//        for (int i=0;i<10000;i++){somme=somme*;};
        System.out.println("Executing : " + name);
        
    }
}