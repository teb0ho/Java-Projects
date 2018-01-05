import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


class referenceNum {

  static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVXWYZ";
  static String[] letters = {"A","A"};

  static int number = 0;
  static int number1 = -1;

  static String combination;

  static File combos = new File("res/combos.txt").getAbsoluteFile();
  static File results = new File("res/results.txt").getAbsoluteFile();

  public static void getNum() {

      BufferedReader br =  null;
      FileReader fr = null;

      try {
          fr = new FileReader(combos);
          br = new BufferedReader(fr);

          String sCurrentLine, sCurrentLine1 = "";

          br = new BufferedReader(new FileReader(combos));

          while ((sCurrentLine = br.readLine()) != null) {
            sCurrentLine1 = sCurrentLine;
          }

          number1 = Character.getNumericValue(sCurrentLine1.charAt(3));
          letters[1] = String.valueOf(sCurrentLine1.charAt(2));
          number = Character.getNumericValue(sCurrentLine1.charAt(1));
          letters[0] = String.valueOf(sCurrentLine1.charAt(0));

          combination = letters[0] + number + letters[1] + number1;

      }

      catch (Exception e) {
          System.out.println("1st reference number generated");
      }

      finally {
          try {
              if (br != null)
                  br.close();
              if (fr != null)
                  fr.close();
          }
          catch (Exception ex) {
              ex.printStackTrace();
          }
      }
  }

  public static void genNums() {

      if (!combination.contentEquals("Z9Z9")) {
          number1++;

          if (number1 > 9) {
              int letterIndex = alphabet.indexOf(letters[1]) + 1;
              if (letterIndex < alphabet.length()) {
                  letters[1] = String.valueOf(alphabet.charAt(letterIndex));
              }
              else {
                  number++;
                  letters[1] = "A";
              }
              number1 = 0;
          }

          if (number > 9) {
              int letterIndex = alphabet.indexOf(letters[0]) + 1;
              if (letterIndex < alphabet.length()) {
                  letters[0] = String.valueOf(alphabet.charAt(letterIndex));
              }
              number = 0;
          }

          combination = letters[0] + number + letters[1] + number1;
      }


      try {
          if (!combos.exists())
              combos.createNewFile();

          FileWriter fileWriter = new FileWriter(combos);
          BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
          bufferedWriter.write(combination);
          bufferedWriter.close();
          fileWriter.close();
      }

      catch (Exception e) {
          e.printStackTrace();
      }
  }

  public static void checkNums(String[] result, String refNumber) {

      String currentLine, currentLine1, refBalls = "";
      int counter = 0, l = 0;
      String[] matchedBalls = new String[6];

      try {

          FileReader fileReader = new FileReader(results);
          BufferedReader bufferedReader = new BufferedReader(fileReader);


          while ((currentLine = bufferedReader.readLine()) != null) {
              currentLine1 = currentLine;
              if (currentLine1.substring(currentLine1.length() - 4, currentLine1.length()).equals(refNumber.toUpperCase())) {

                  refBalls = currentLine1.substring(0, 17);
                  break;
              }
          }

          if (refBalls.isEmpty()) {
              System.out.println("Your reference could not be found");
          }

          else {

              for (int i = 0; i < 6; i++) {

                  if (refBalls.contains(result[i])) {
                      matchedBalls[l] = result[i].trim();

                      if (!matchedBalls[l].equals("0")) {
                          counter++;
                      }

                      l++;
                  }
              }
          }

          if (counter != 0) {
              System.out.print("You have: " + counter + " matche(s) they are: ");

              for (String x : matchedBalls) {
                  if (x != null)
                      System.out.print(x + " ");

              }
              System.out.println();
          }

          else {
              System.out.println("You have zero matches.");
          }

      }

      catch (StringIndexOutOfBoundsException sE) {
          System.out.println("Your reference could not be found please try again.");
          return;
      }

      catch (IOException e) {
          e.printStackTrace();
      }

      catch (Exception e) {
          e.printStackTrace();
      }

  }

}
