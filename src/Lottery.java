import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Teb0ho on 2016-11-24 - 2017-05-29.
 */

public class Lottery {

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVXWYZ";
    String[] letters = new String[] {"A","A"};

    int number = 0;
    int number1 = -1;

    String combination = letters[0] + number + letters[1] + number1;

    void getNum() {
        BufferedReader br =  null;
        FileReader fr = null;
        File file = new File("res/combos.txt").getAbsoluteFile();

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String sCurrentLine, sCurrentLine1 = "";

            br = new BufferedReader(new FileReader(file));

            while ((sCurrentLine = br.readLine()) != null) {
                sCurrentLine1 = sCurrentLine;
            }

            number1 = Character.getNumericValue(sCurrentLine1.charAt(3));
            letters[1] = String.valueOf(sCurrentLine1.charAt(2));
            number = Character.getNumericValue(sCurrentLine1.charAt(1));
            letters[0] = String.valueOf(sCurrentLine1.charAt(0));

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

    void genNums() {

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


        File file = new File("res/combos.txt").getAbsoluteFile();

        try {
            if (!file.exists())
                file.createNewFile();

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(combination);
            bufferedWriter.close();
            fileWriter.close();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void checkNums(String[] result, String refNumber) throws IOException {

        String currentLine, currentLine1, refBalls = "";
        int counter = 0, l = 0;
        String[] matchedBalls = new String[6];
        File file = new File("res/results.txt").getAbsoluteFile();
        FileReader fileReader = new FileReader(file);
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
                    counter++;
                    matchedBalls[l] = result[i];
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


    static String lotto () {

        String textLotto = "";
        Random ballpicker = new Random();
        ArrayList<Integer> BallHolder = new ArrayList<Integer>();
        String sBall, sBall1;
        int rdmNum = 0;

        BallHolder.add(null);

        for (;;) {

            rdmNum = ballpicker.nextInt(50);

            if (!(BallHolder.contains(rdmNum)) && rdmNum > 0)
                BallHolder.add(rdmNum);


            if (BallHolder.size() == 7)
                break;

        }


        for (int i = 1; i < BallHolder.size(); i++) {

            sBall = BallHolder.get(i).toString();

            if (sBall.length() < 2)
                sBall1 = "0" + sBall;
            else
                sBall1 = sBall;


            textLotto+= sBall1 + " ";

        }

        return textLotto;
    }

    static String powerBall () {

        String textPwrBall = "";
        Random ballpicker = new Random();
        ArrayList<Integer> BallHolder = new ArrayList<Integer>();
        String sBall, sBall1;
        int rdmNum = 0, pwrBall = 0;

        BallHolder.add(null);

        for (;;) {
            rdmNum = ballpicker.nextInt(50);

            if (!(BallHolder.contains(rdmNum)) && rdmNum > 0)
                BallHolder.add(rdmNum);



            if (BallHolder.size() == 6)
                break;

        }

        for (;;) {
            pwrBall = ballpicker.nextInt(21);

            if (pwrBall > 0) {
                BallHolder.add(pwrBall);
                break;
            }
        }

        for (int i = 1; i < BallHolder.size(); i++) {

            sBall = BallHolder.get(i).toString();

            if (sBall.length() < 2)
                sBall1 = "0" + sBall;
            else
                sBall1 = sBall;

            textPwrBall+= sBall1 + " ";

        }

        return textPwrBall;

    }

    public static void main (String[] args) {

        String textLotto, textPwrBall, sixNumbers, sixNumbers1;
        String[] uNumbers = new String[6];
        File file = new File("res/results.txt").getAbsoluteFile();
        File file1 = new File("res/combos.txt");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Lottery myLotObj = new Lottery();
        BufferedReader br = null;
        FileReader fr = null;

        System.out.println("Would you like to generate some numbers ? 1 = yes, 2 = no, 3 = check results");

        try {
            for (;;) {

                Scanner scan = new Scanner(System.in);

                int prompt = scan.nextInt();
                String sCurrentLine, sCurrentLine1 = "";

                if (prompt == 1) {

                    System.out.println("What type of lotto numbers would you like to generate ? 1 = Standard Lotto 2 = Powerball");
                    int lottoOpts = scan.nextInt();

                    if (lottoOpts == 1) {
                        textLotto = lotto();
                        myLotObj.getNum();
                        myLotObj.genNums();

                        if(!file.exists())
                            file.createNewFile();

                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        fr = new FileReader(file1);
                        br = new BufferedReader(fr);
                        br = new BufferedReader(new FileReader(file1));

                        while ((sCurrentLine = br.readLine()) != null) {
                            sCurrentLine1 = sCurrentLine;
                        }

                        bufferedWriter.write(textLotto + "\tLotto\t\t" + dateFormat.format(date) + "\t" + sCurrentLine1 + "\n");
                        bufferedWriter.close();
                        fileWriter.close();

                        System.out.println(textLotto);
                    }

                    else if (lottoOpts == 2) {
                        textPwrBall = powerBall();
                        myLotObj.getNum();
                        myLotObj.genNums();

                        if(!file.exists())
                            file.createNewFile();


                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        fr = new FileReader(file1);
                        br = new BufferedReader(fr);
                        br = new BufferedReader(new FileReader(file1));

                        while ((sCurrentLine = br.readLine()) != null) {
                            sCurrentLine1 = sCurrentLine;
                        }
                        bufferedWriter.write(textPwrBall + "\tPowerball\t" + dateFormat.format(date) + "\t" + sCurrentLine1 + "\n");
                        bufferedWriter.close();
                        fileWriter.close();

                        System.out.println(textPwrBall);
                    }


                    System.out.println("\nPress 2 to quit, 1 to generate new numbers\n");

                }

                else if (prompt == 2) {

                    System.out.println("Thanks for running this program");
                    System.exit(0);

                }

                else if (prompt == 3) {
                    String refNumber;
                    refNumber = scan.nextLine();

                    System.out.println("Enter your reference number (e.g. A0A0) the reference numbers for different number combinations can be found in the directory \"res/results.txt\": ");

                    refNumber = scan.nextLine();

                    for (int i = 0; i < 6; i++) {
                        int k = i;
                        k++;

                        System.out.println("Enter your " + k + " number: ");
                        sixNumbers = scan.nextLine();

                        if (sixNumbers.length() < 2)
                            sixNumbers1 = "0" + sixNumbers;
                        else
                            sixNumbers1 = sixNumbers;

                        uNumbers[i] = sixNumbers1;
                    }

                    checkNums(uNumbers, refNumber);

                    System.out.println();
                    System.out.println("Would you like to generate some numbers ? 1 = yes, 2 = no, 3 = check results");
                }

                else {

                    System.out.println("Incorrect option please try again.");

                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error - incorrect answer please enter the number 1 or 2 ");
        }
        finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
