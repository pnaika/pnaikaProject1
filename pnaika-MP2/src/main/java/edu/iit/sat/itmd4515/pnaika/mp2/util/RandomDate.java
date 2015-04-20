/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.pnaika.mp2.util;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Prashanth
 */
public class RandomDate {
    
    private static final Random GENERATOR = new Random();
    
    private static final long BEGIN_TIME = 1L * 365L * 24L * 60L * 60L * 1000L;
    private static final long END_TIME = 1L * 365L * 24L * 60L * 60L * 1000L;
 
    public static Date generate() {
        return new Date(System.currentTimeMillis() - getRandomTimeBetweenTwoDates()); 
    }

    private static long getRandomTimeBetweenTwoDates() {
        long diff = END_TIME - BEGIN_TIME + 1;
        return BEGIN_TIME + (long)(Math.random() * diff);
    }
}
