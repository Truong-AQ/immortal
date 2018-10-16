/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoplaysound;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Genius
 */
public class Demoplaysound {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s;
        Scanner ip = new Scanner(System.in);
        s = ip.nextLine();
        s = "CreateObject(" + '"' + "SAPI.SpVoice" + '"' + ").Speak" + '"' + s + '"';
        try(PrintWriter pw = new PrintWriter("C:\\Users\\Genius\\Documents\\sound.vbs")) {
               pw.print(s);
        } catch (Exception e) {
        }
   try {
      Runtime.getRuntime().exec( "wscript C:\\Users\\Genius\\Documents\\sound.vbs" );
   }

   catch( IOException e ) {
   }
    }
}
