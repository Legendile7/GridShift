//By Divesh Gupta, All Rights Reserved.
import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
class Main {
  public static void main(String[] args) {
    Scanner scam = new Scanner(System.in);
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String ralphabet = "zyxwvutsrqponmlkjihgfedcba";
    String numbers = "0123456789";
    String rnumbers = "9876543210";
    String symbols = "!@#$%^&*()_-+={[}]|\\:;\"\'<,>.?/`~";
    String plain = "";
    String cipher = "";
    String start2 = "";
    String start3 = "";
    String start4 = "";
    int one = 0;
    int two = 0;
    int index = 0;
    int grid = 0;
    int modifier = 0;
    double gridSqr = 0;
    System.out.print("GridShift Version Beta 1.7.9 (December 6, 2021)\nCreated by Divesh Gupta. All rights reserved.\nWould you like to encrypt or decrypt (e/d/help/exit)? ");
    String operation = scam.nextLine();
    if (operation.equals("e")){
      System.out.println("Enter message to encrypt (letters and numbers only): ");
      String message = scam.nextLine();
      message = message.toLowerCase();
      message = message.replaceAll("\\p{Punct}", "*");
      if (message.contains("*")){
        System.out.print("Punctuation replaced with *\nWould you like to remove it (y/n)? ");
        String punc = scam.nextLine();
        if (punc.equals("y")){
          message = message.replaceAll("\\p{Punct}", "");
        }
      }
      System.out.println("Enter the key (<key>/auto):");
      String key = scam.nextLine();
      if (key.equals("auto")){
        System.out.println("Generating Key...");
        grid = (int)(Math.random() * 90 + 10);
        gridSqr = Math.pow(grid,2)-1;
        //for (int i = 0; i < gridSqr; i++){
        //  alphabet += alphabet1;
        //}
        int randStart = (int)(Math.random() * gridSqr);
        //String[] dirList = {"ll", "rr", "dd", "uu", "lu", "ru", "ld", "rd"};
        String[] dirList = {"dd", "uu", "ld", "rd", "lu", "ru"};
        Random ran = new Random();
        String dir = dirList[ran.nextInt(dirList.length)];
        key = grid + dir + randStart;
        System.out.println("Key generated: " + key);
        System.out.println("Creating Grid...");
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < gridSqr+1; i++){
          numList.add(i);
        }
        System.out.println("[0, 1, 2, 3..." + (int)gridSqr + "]");
        System.out.println("Encrypting...");
        for (int i = 0; i < message.length(); i++){
          plain = message.substring(0+one, 1+two);
          if (dir == "dd"){
            index = alphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += alphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = numbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += numbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid;
          }
          if (dir == "uu"){
            index = ralphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += ralphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = rnumbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += rnumbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid;
          }
          if (dir == "rd"){
            index = alphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += alphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = numbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += numbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid+1;
          }
          if (dir == "ld"){
            index = alphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += alphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = numbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += numbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid-1;
          }
          if (dir == "lu"){
            index = ralphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += ralphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = rnumbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += rnumbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid+1;
          }
          if (dir == "ru"){
            index = ralphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += ralphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = rnumbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += rnumbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid-1;
          }
          one++;
          two++;
        }
        System.out.println("Finished! Fetching...");
        System.out.println("\nPlaintext:\n" + message + "\n\nCiphertext:\n" + cipher + "\n\nKey:\n" + key + "\n\nExport:\n" + cipher + ":" + key + "\n\nCopied to clipboard!");
        String export = cipher + ":" + key;
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
          System.out.println("Small grid number detected! Cipher will be less secure!");
          grid = Integer.parseInt(gridS);
        }
        gridSqr = Math.pow(grid,2)-1;
        //for (int i = 0; i < gridSqr; i++){
          //alphabet += alphabet1;
        //}
        int randStart = (int)(Math.random() * gridSqr);
        String dir = key.substring(1+modifier,3+modifier);
        String start1 = key.substring(3+modifier,4+modifier);
        try{
          start2 = key.substring(4+modifier,5+modifier);
        }catch (Exception e) {
          System.out.println("Detected 1 digit starting number or incorrect key. Encryption may fail.");
        }
        try{
          start3 = key.substring(5+modifier,6+modifier);
        }catch (Exception e) {}
        try{
          start4 = key.substring(6+modifier,7+modifier);
        }catch (Exception e) {}
        randStart = Integer.parseInt(start1+start2+start3+start4);
        if (randStart <= gridSqr){
          key = grid + dir + randStart;
        }
        System.out.println("Creating Grid...");
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < gridSqr+1; i++){
          numList.add(i);
        }
          System.out.println("[0, 1, 2, 3..." + (int)gridSqr + "]");
        System.out.println("Encrypting...");
        for (int i = 0; i < message.length(); i++){
          plain = message.substring(0+one, 1+two);
          if (dir.equals("dd")){
            index = alphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += alphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = numbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += numbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid;
          }
          if (dir.equals("uu")){
            index = ralphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += ralphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = rnumbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += rnumbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid;
          }
          if (dir.equals("rd")){
            index = alphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += alphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = numbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += numbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid+1;
          }
          if (dir.equals("ld")){
            index = alphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += alphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = numbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += numbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid-1;
          }
          if (dir.equals("lu")){
            index = ralphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += ralphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = rnumbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += rnumbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid+1;
          }
          if (dir.equals("ru")){
            index = ralphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += ralphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = rnumbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += rnumbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid-1;
          }
          one++;
          two++;
        }
        System.out.println("Finished! Fetching...");
        System.out.println("\nPlaintext:\n" + message + "\n\nCiphertext:\n" + cipher + "\n\nKey:\n" + key + "\n\nExport:\n" + cipher + ":" + key + "\n\nCopied to clipboard!");
        String export = cipher + ":" + key;
        StringSelection stringSelection = new StringSelection(export);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
      }
    }
    else if (operation.equals("d")){
      System.out.println("Enter message to decrypt (letters and numbers only): ");
      String message = scam.nextLine();
      message = message.toLowerCase();
      System.out.println("Enter the key:");
      String key = scam.nextLine();
      System.out.println("Using key: " + key);
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
      //for (int i = 0; i < gridSqr; i++){
        //alphabet += alphabet1;
      //}
      int randStart = (int)(Math.random() * gridSqr);
      String dir = key.substring(1+modifier,3+modifier);
      String start1 = key.substring(3+modifier,4+modifier);
      try{
        start2 = key.substring(4+modifier,5+modifier);
      }catch (Exception e) {
        System.out.println("Detected 1 digit starting number or incorrect key. Decryption may fail.");
      }
      try{
        start3 = key.substring(5+modifier,6+modifier);
      }catch (Exception e) {}
      try{
        start4 = key.substring(6+modifier,7+modifier);
      }catch (Exception e) {}
      randStart = Integer.parseInt(start1+start2+start3+start4);
      key = grid + dir + randStart;
      System.out.println("Creating Grid...");
      List<Integer> numList = new ArrayList<>();
      for (int i = 0; i < gridSqr+1; i++){
        numList.add(i);
      }
      System.out.println("[0, 1, 2, 3..." + (int)gridSqr + "]");
      System.out.println("Decrypting...");
      plain = message.substring(0+one, 1+two);
      index = alphabet.indexOf(plain);
      for (int i = 0; i < message.length(); i++){
        plain = message.substring(0+one, 1+two);
        if (dir.equals("dd")){
          index = ralphabet.indexOf(plain);
          randStart %= 26;
          index += randStart;
          index %= 26;
          if (!plain.equals(" ")){
            if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += ralphabet.substring(index, index+1);
            }else if (numbers.indexOf(plain) != -1){
              int numdex = rnumbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
              cipher += rnumbers.substring(numdex, numdex+1);
            }else{
                cipher += "*";
              }
          }else{
            cipher += " ";
          }
          randStart += grid;
        }
        if (dir.equals("uu")){
          index = alphabet.indexOf(plain);
          randStart %= 26;
          index += randStart;
          index %= 26;
          if (!plain.equals(" ")){
            if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += alphabet.substring(index, index+1);
            }else if (numbers.indexOf(plain) != -1){
              int numdex = numbers.indexOf(plain);
              randStart %= 10;
              numdex += randStart;
              numdex %= 10;
              cipher += numbers.substring(numdex, numdex+1);
            }else{
              cipher += "*";
            }
          }else{
            cipher += " ";
          }
          randStart += grid;
        }
        if (dir.equals("rd")){
          index = ralphabet.indexOf(plain);
          randStart %= 26;
          index += randStart;
          index %= 26;
          if (!plain.equals(" ")){
            if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += ralphabet.substring(index, index+1);
            }else if (numbers.indexOf(plain) != -1){
              int numdex = rnumbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
              cipher += rnumbers.substring(numdex, numdex+1);
            }else{
              cipher += "*";
            }
          }else{
            cipher += " ";
          }
          randStart += grid+1;
        }
        if (dir.equals("ld")){
          index = ralphabet.indexOf(plain);
          randStart %= 26;
          index += randStart;
          index %= 26;
          if (!plain.equals(" ")){
            if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += ralphabet.substring(index, index+1);
            }else if (numbers.indexOf(plain) != -1){
              int numdex = rnumbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
              cipher += rnumbers.substring(numdex, numdex+1);
            }else{
              cipher += "*";
            }
          }
          else{
            cipher += " ";
          }
          randStart += grid-1;
        }
        if (dir.equals("lu")){
          index = alphabet.indexOf(plain);
          randStart %= 26;
          index += randStart;
          index %= 26;
          if (!plain.equals(" ")){
            if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
            cipher += alphabet.substring(index, index+1);
            }else if (numbers.indexOf(plain) != -1){
              int numdex = numbers.indexOf(plain);
              randStart %= 10;
              numdex += randStart;
              numdex %= 10;
              cipher += numbers.substring(numdex, numdex+1);
            }else{
              cipher += "*";
            }
          }else{
            cipher += " ";
          }
          randStart += grid+1;
          }
          if (dir.equals("ru")){
            index = alphabet.indexOf(plain);
            randStart %= 26;
            index += randStart;
            index %= 26;
            if (!plain.equals(" ")){
              if (numbers.indexOf(plain) == -1 && symbols.indexOf(plain) == -1){
              cipher += alphabet.substring(index, index+1);
              }else if (numbers.indexOf(plain) != -1){
                int numdex = numbers.indexOf(plain);
                randStart %= 10;
                numdex += randStart;
                numdex %= 10;
                cipher += numbers.substring(numdex, numdex+1);
              }else{
                cipher += "*";
              }
            }else{
              cipher += " ";
            }
            randStart += grid-1;
          }
        one++;
        two++;
      } 
      System.out.println("Finished! Fetching...");
      System.out.println("\nCiphertext:\n" + message + "\n\nPlaintext:\n"+ cipher + "\n\nKey:\n" + key + "\n\nExport:\n" + message + ":" + key);
      String export = message + ":" + key;
      StringSelection stringSelection = new StringSelection(export);
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(stringSelection, null);
    }
    else if (operation.equals("help")){
      System.out.println("\nThis program is an cryptographic encryption algorithm that converts a message into ciphertext with a key.\n\nStart by encrypting (e), type your message and press enter.\nIf you know how to make a key, type the key.\nOtherwise, type auto.\nTo make a key, combine these 3 parts:\n> Grid size (1-99)\n> Direction (uu, dd, lu, ru, ld, rd)\n> Start number (0 to [Grid size squared - 1])\nExample key: 77dd540\nAfter you have entered the key, wait for the program to encrypt your message. Copy and save the Ciphertext AND Key.\n\nTo decrypt, run the program and type (d).\nThen type the ciphertext you encrypted before with the encrypt function.\nThen type the key you used to encrypt the message.\nPress enter and you should have your original message.\n\nRun the program again to get started!");
    }
    else if (operation.equals("exit")){}
    else{
      System.out.println(operation);
      System.out.println("Incorrect Input! Please run the program again!");
    }
  }
}
