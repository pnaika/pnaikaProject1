/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.pnaika.mp2.util;

import java.util.Random;

/**
 *
 * @author Prashanth
 */
public class RandomName {
    
   private static final Random GENERATOR = new Random();
   
   private static final String[] FIRST_NAME = new String[]{
       "Prashanth","Ashvik","Sanjeev","Shashank","Simran"
   };
   
   private static final String[] LAST_NAME = new String[]{
       "Naika","Rathod","Naik","Chawan","James"
   };
   
   public static String generateFirstName(){
       return FIRST_NAME[GENERATOR.nextInt(FIRST_NAME.length)];
   }
   
   public static String generateLastName(){
       return LAST_NAME[GENERATOR.nextInt(LAST_NAME.length)];
   }
   
}
