import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


class referenceNum {

  String alphabet = "ABCDEFGHIJKLMNOPQRSTUVXWYZ";
  String[] letters = {"A","A"};

  int number = 0;
  int number1 = -1;

  String combination = letters[0] + number + letters[1] + number1;

  File combos = new File("res/combos.txt").getAbsoluteFile();
  File results = new File("res/results.txt").getAbsoluteFile();

  public static void getNum() {

      referenceNum obj = new referenceNum();

      BufferedReader br =  null;
      FileReader fr = null;

      try {
          fr = new FileReader(obj.results);
          br = new BufferedReader(fr);

          String sCurrentLine, sCurrentLine1 = "";

          br = new BufferedReader(new FileReader(obj.results));

          while ((sCurrentLine = br.readLine()) != null) {
              sCurrentLine1 = sCurrentLine;
          }

          obj.number1 = Character.getNumericValue(sCurrentLine1.charAt(3));
          obj.letters[1] = String.valueOf(sCurrentLine1.charAt(2));
          obj.number = Character.getNumericValue(sCurrentLine1.charAt(1));
          obj.letters[0] = String.valueOf(sCurrentLine1.charAt(0));

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

      referenceNum obj = new referenceNum();

      if (!obj.combination.contentEquals("Z9Z9")) {
          obj.number1++;

          if (obj.number1 > 9) {
              int letterIndex = obj.alphabet.indexOf(obj.letters[1]) + 1;
              if (letterIndex < obj.alphabet.length()) {
                  obj.letters[1] = String.valueOf(obj.alphabet.charAt(letterIndex));
              }
              else {
                  obj.number++;
                  obj.letters[1] = "A";
              }
              obj.number1 = 0;
          }

          if (obj.number > 9) {
              int letterIndex = obj.alphabet.indexOf(obj.letters[0]) + 1;
              if (letterIndex < obj.alphabet.length()) {
                  obj.letters[0] = String.valueOf(obj.alphabet.charAt(letterIndex));
              }
              obj.number = 0;
          }

          obj.combination = obj.letters[0] + obj.number + obj.letters[1] + obj.number1;
      }


      try {
          if (!obj.combos.exists())
              obj.combos.createNewFile();

          FileWriter fileWriter = new FileWriter(obj.combos);
          BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
          bufferedWriter.write(obj.combination);
          bufferedWriter.close();
          fileWriter.close();
      }

      catch (Exception e) {
          e.printStackTrace();
      }
  }

  public static void checkNums(String[] result, String refNumber) throws IOException {

      referenceNum obj = new referenceNum();

      String currentLine, currentLine1, refBalls = "";
      int counter = 0, l = 0;
      String[] matchedBalls = new String[6];

      FileReader fileReader = new FileReader(obj.results);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      while ((currentLine = bufferedReader.readLine()) != null) {
          currentLine1 = currentLine;
          if (currentLine1.substring(currentLine1.length() - 4, currentLine1.length()).equals(refNumber.toUpperCase())) {

              refBalls = currentLine1.substring(0,17);
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

}
