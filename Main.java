//GridShift Cipher 1.10.3 (December 19, 2021) Copyright 2021 by Divesh Gupta is licensed under CC BY-NC-ND 4.0. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/
import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
public class Main {
  public static void main(String[] args) {
    Scanner scam = new Scanner(System.in);
    String alphabet = " abcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+`{[}]:;\'\"<,>.?/|ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder sb=new StringBuilder(alphabet);
    StringBuilder ralphabet1 = sb.reverse();
    String ralphabet = ralphabet1.toString();
    String plain = "";
    String cipher = "";
    String reverse = "";
    String key = "";
    int index = 0;
    int grid = 0;
    int modifier = 0;
    int dirInt = 0;
    double gridSqr = 0;
    System.out.print("GridShift Cipher 1.10.3 (December 19, 2021) Copyright 2021 by Divesh Gupta is licensed under CC BY-NC-ND 4.0. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/\nEnter Command (e/d/help/exit): ");
    String operation = scam.nextLine();
    if (operation.equals("e")){
      System.out.println("Enter message to encrypt: ");
      String message = scam.nextLine();
      if (message.contains("~")){
        System.out.println("Key detected in message!");
        int kIndex = message.indexOf("~");
        key = message.substring(kIndex+1, message.length());
        message = message.substring(0,kIndex);
      }else{
        System.out.println("Enter the key (<key>/auto):");
        key = scam.nextLine();
      }
      if (key.equals("auto")){
        System.out.println("Generating Key...");
        grid = (int)(Math.random() * 90 + 10);
        gridSqr = Math.pow(grid,2)-1;
        int randstart = (int)(Math.random() * gridSqr);
        String[] dirList = {"-", "+"};
        Random ran = new Random();
        reverse = dirList[ran.nextInt(dirList.length)];
        dirInt = (int)(Math.random() * grid + 10);
        dirInt %= 100;
        if (dirInt == 0){
          dirInt = 10;
        }
        String dir = Integer.toString(dirInt);
        key = grid + "(" + reverse + dir + ")" + randstart;
        System.out.println("Key Generated: " + key);
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < gridSqr+1; i++){
          numList.add(i);
        }
        System.out.println("Encrypting...");
        for (int i = 0; i < message.length(); i++){
          plain = message.substring(0+i, 1+i);
          if(reverse == "-"){
            index = ralphabet.indexOf(plain);
            randstart %= 93;
            index += randstart;
            index %= 93;
            cipher += ralphabet.substring(index, index+1);
          }else if(reverse.equals("+")){
            index = alphabet.indexOf(plain);
            randstart %= 93;
            index += randstart;
            index %= 93;
            cipher += alphabet.substring(index, index+1);
          }
          randstart += grid+dirInt;
        }
        System.out.println("Finished!");
        System.out.println("\nPlaintext:\n" + message + "\n\nCiphertext:\n" + cipher + "\n\nKey:\n" + key + "\n\nExport (Ciphertext is before ~ and Key is after ~):\n" + cipher + "~" + key + "\n\nCopied to clipboard!");
        String export = cipher + "~" + key;
        StringSelection stringSelection = new StringSelection(export);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
      }
      else{
        System.out.println("Using key: " + key);
        String gridS = key.substring(0,1);
        try{
          grid = Integer.parseInt(key.substring(1,2));
          gridS += key.substring(1,2);
          grid = Integer.parseInt(gridS);
          modifier = 1;
        }catch (Exception error){
          System.out.println("One digit grid number detected! Cipher will be less secure!");
          grid = Integer.parseInt(gridS);
        }
        gridSqr = Math.pow(grid,2)-1;
        int randstart = 0;
        reverse = key.substring(2+modifier,3+modifier);
        modifier += 1;
        String dir = key.substring(2+modifier,4+modifier);
        dirInt = Integer.parseInt(dir);
        String start1 = key.substring(5+modifier,6+modifier);
        String randstartS = start1;
        try{
          String start2 = key.substring(6+modifier,7+modifier);
          randstartS += start2;
          randstart = Integer.parseInt(randstartS);
        }catch (Exception e) {
          System.out.println("Detected 1 digit starting number or incorrect key. Encryption may fail.");
        }
        try{
          String start3 = key.substring(7+modifier,8+modifier);
          randstartS += start3;
          randstart = Integer.parseInt(randstartS);
        }catch (Exception e) {}
        try{
          String start4 = key.substring(8+modifier,9+modifier);
          randstartS += start4;
          randstart = Integer.parseInt(randstartS);
        }catch (Exception e) {}
        randstart = Integer.parseInt(randstartS);
        if (randstart <= gridSqr){
          key = grid + "(" + reverse + dir + ")" + randstart;
        }
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < gridSqr+1; i++){
          numList.add(i);
        }
        System.out.println("Encrypting...");
        for (int i = 0; i < message.length(); i++){
          plain = message.substring(0+i, 1+i);
          if(reverse.equals("-")){
            index = ralphabet.indexOf(plain);
            randstart %= 93;
            index += randstart;
            index %= 93;
            cipher += ralphabet.substring(index, index+1);
          }else if(reverse.equals("+")){
            index = alphabet.indexOf(plain);
            randstart %= 93;
            index += randstart;
            index %= 93;
            cipher += alphabet.substring(index, index+1);
          }
          randstart += grid+dirInt;
        }
        System.out.println("Finished!");
        System.out.println("\nPlaintext:\n" + message + "\n\nCiphertext:\n" + cipher + "\n\nKey:\n" + key + "\n\nExport (Ciphertext is before ~, Key is after ~):\n" + cipher + "~" + key + "\n\nCopied to clipboard!");
        String export = cipher + "~" + key;
        StringSelection stringSelection = new StringSelection(export);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
      }
    }
    else if (operation.equals("d")){
      System.out.println("Enter Ciphertext or Export text to decrypt: ");
      String message = scam.nextLine();
      if (message.contains("~")){
        System.out.println("Key detected!");
        int kIndex = message.indexOf("~");
        key = message.substring(kIndex+1, message.length());
        message = message.substring(0,kIndex);
      }else{
        System.out.println("Enter the key (<key>/auto):");
        key = scam.nextLine();
      }
      String gridS = key.substring(0,1);
      try{
        grid = Integer.parseInt(key.substring(1,2));
        gridS += key.substring(1,2);
        grid = Integer.parseInt(gridS);
        modifier = 1;
      }catch (Exception error){
        grid = Integer.parseInt(gridS);
      }
      gridSqr = Math.pow(grid,2)-1;
      int randstart = 0;
      reverse = key.substring(2+modifier,3+modifier);
      modifier += 1;
      String dir = key.substring(2+modifier,4+modifier);
      dirInt = Integer.parseInt(dir);
      String start1 = key.substring(5+modifier,6+modifier);
      String randstartS = start1;
      try{
        String start2 = key.substring(6+modifier,7+modifier);
        randstartS += start2;
        randstart = Integer.parseInt(randstartS);
      }catch (Exception e) {
        System.out.println("Detected 1 digit starting number or incorrect key. Decryption may fail.");
      }
      try{
        String start3 = key.substring(7+modifier,8+modifier);
        randstartS += start3;
        randstart = Integer.parseInt(randstartS);
      }catch (Exception e) {}
      try{
        String start4 = key.substring(8+modifier,9+modifier);
        randstartS += start4;
        randstart = Integer.parseInt(randstartS);
      }catch (Exception e) {}
      randstart = Integer.parseInt(randstartS);
      if (randstart <= gridSqr){
        key = grid + "(" + reverse + dir + ")" + randstart;
      }
      List<Integer> numList = new ArrayList<>();
      for (int i = 0; i < gridSqr+1; i++){
        numList.add(i);
      }
      System.out.println("Decrypting...");
      for (int i = 0; i < message.length(); i++){
        plain = message.substring(0+i, 1+i);
        if(reverse.equals("-")){
          index = alphabet.indexOf(plain);
          randstart %= 93;
          index += randstart;
          index %= 93;
          cipher += alphabet.substring(index, index+1);
        }else if(reverse.equals("+")){
          index = ralphabet.indexOf(plain);
          randstart %= 93;
          index += randstart;
          index %= 93;
          cipher += ralphabet.substring(index, index+1);
        }
        randstart += grid+dirInt;
      }
      System.out.println("Finished!");
      System.out.println("\nCiphertext:\n" + message + "\n\nPlaintext:\n"+ cipher + "\n\nKey:\n" + key);
    }
    else if (operation.equals("help")){
      System.out.println("\nThis program is an cryptographic encryption algorithm that converts a message into ciphertext with a key.\n\nEncrypt (e)\n Type the message and press Enter.\nEnter the key or type auto and press Enter.\n\nTo make a key, combine these 5 parts:\n> Grid size (1-99)\n> Open Parenthesis: (\n> Grid Advancement (Any two digit negative or positive number with sign +/- before number)\n> Closed Parenthesis: )\n> Start number (0 to [Grid size squared - 1])\nExample key: 77(+98)540\nAnother Example: 34(-05)25\n\nAfter entering the key, wait for the program to encrypt your message. The program will automatically copy the text under Export and save to Clipboard. The Export includes the message and the key seperated by ~\n\n\nDecrypt (d)\nType the ciphertext encrypted with the encrypt function or the Export value from the Encryption function and press Enter.\nIf you typed the Export text, the decryption will happen. Otherwise, type the key used to encrypt the message.\nPress Enter and you now have the original message.\n\nRun the program again to get started!");
    }
    else if (operation.equals("exit")){}
    else{
      System.out.println("Error! Could not find command: " + operation + "\nPlease run the program again!");
    }
  }
}
