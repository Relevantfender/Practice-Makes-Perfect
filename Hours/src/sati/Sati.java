package sati;

import java.util.Scanner;

/**
 *
 * @author dr Miroslav Ilić
 */
public class Sati {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

//konstante za uglove
        final int ANGLE_MINUTE = 6;
        final int ANGLE_HOUR = 30;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter hours then minutes");
        
        //angle hour
        float sati;
        while(true){
            System.out.print("Enter what time it is: ");
            sati = sc.nextFloat();
            if (sati >=0 && sati<=12){
                break;
            }
            System.out.println("Please enter hour between 1 i 12.");
        }
          
       
        //angle minute
        float minutes;
        while(true){
        System.out.print("Enter minutes: ");
        minutes = sc.nextInt();
        if (minutes <=60 && minutes >=0 ){
            break;
        }
        System.out.println("Please enter value between 0 i 60");
        }
       
        //5/60,  while minute does 60 hour hand does 5 minutes = 1/12=0.833
        
        double extraAngle = 0.5 * minutes;
        double angleHour = (ANGLE_HOUR * sati) + extraAngle;
        double angleMinute = minutes * ANGLE_MINUTE;
        
        double angleBetweenHands = angleHour - angleMinute;
        double result = Math.abs(angleBetweenHands);
        
   
        if (result == 0){
        System.out.println("Angle between two hands is: " + result );
        }
        else{
        System.out.println("Angle between two hands is: " + result + " ie. " + (360 -result));
        }
                 
    }
    
}
