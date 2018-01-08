/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jameslu
 */
public class NoonSnoozeHome {
     public static void main(String[] args) {
        int snooze = 35;
        
        int hours = snooze/60;
        int minutes = snooze%60;
        
        if (hours < 24) {
            if (hours == 0) {
                System.out.println("12:" + minutes + " pm");
            }
            else if (hours == 12) {
                System.out.println("12:0" + minutes + " am");
            }
            else {
                if (hours < 12) {
                    System.out.println(hours + ":" + minutes + " pm");
                }
                else  {
                    int hour = hours - 12;
                    System.out.println(hour + ":" + minutes + " am");
                }
            }
        }
        else {
            if (hours >= 24) {
                hours = hours%24;
            }
            if (hours == 0) {
                System.out.println("12:" + minutes + " pm");
            }
            else if (hours == 12) {
                System.out.println("12:0" + minutes + " am");
            }
            else {
                if (hours < 12) {
                    System.out.println(hours + ":" + minutes + " pm");
                }
                else  {
                    int hour = hours - 12;
                    System.out.println(hour + ":" + minutes + " am");
                }
            } 
        }
    }

}
