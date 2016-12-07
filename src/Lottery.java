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
 * Created by Teb0ho on 2016-11-24 - 2016-12-03.
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

            String sCurrentLine;
            String sCurrentLine1 = "";

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
            if (!file.exists()) {
                file.createNewFile();
            }

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


    static String lotto () {

        String textLotto = "";
        Random ballpicker = new Random();
        ArrayList<Integer> BallHolder = new ArrayList<Integer>();
        int rdmNum = 0;
        int rdmNum1 = 0;

        BallHolder.add(null);

        for (int i = 0; i < 6; i++) {

            rdmNum = ballpicker.nextInt(50);
            rdmNum1 = ballpicker.nextInt(50);

            if (!(BallHolder.contains(rdmNum)) && rdmNum > 0) {

                BallHolder.add(rdmNum);

            } else if (!(BallHolder.contains(rdmNum1)) && rdmNum1 > 0) {

                BallHolder.add(rdmNum1);

            }
        }

        for (int i = 1; i < BallHolder.size(); i++) {

            textLotto+= BallHolder.get(i) + " ";

        }

        return textLotto;
    }

    static String powerBall () {

        String textPwrBall = "";
        Random ballpicker = new Random();
        ArrayList<Integer> BallHolder = new ArrayList<Integer>();
        int rdmNum = 0;
        int rdmNum1 = 0;
        int pwrBall = 0;

        BallHolder.add(null);

        for (int i = 0; i < 5; i++) {

            rdmNum = ballpicker.nextInt(50);
            rdmNum1 = ballpicker.nextInt(50);

            if (!(BallHolder.contains(rdmNum)) && rdmNum > 0) {

                BallHolder.add(rdmNum);

            } else if (!(BallHolder.contains(rdmNum1)) && rdmNum1 > 0) {

                BallHolder.add(rdmNum1);

            }
        }

        for (;;) {
            pwrBall = ballpicker.nextInt(21);

            if (pwrBall > 0) {
                BallHolder.add(pwrBall);
                break;
            }
        }

        for (int i = 1; i < BallHolder.size(); i++) {

            textPwrBall+= BallHolder.get(i) + " ";

        }

        return textPwrBall;

    }

    public static void main (String[] args) {

        String textLotto;
        String textPwrBall;
        File file = new File("res/results.txt").getAbsoluteFile();
        File file1 = new File("res/combos.txt");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Lottery myLotObj = new Lottery();
        BufferedReader br = null;
        FileReader fr = null;

        System.out.println("Would you like to generate some numbers ? 1 = yes and 2 = no");

        try {
            for (; ; ) {

                Scanner scan = new Scanner(System.in);

                int prompt = scan.nextInt();
                String sCurrentLine;
                String sCurrentLine1 = "";

                if (prompt == 1) {

                    System.out.println("What type of lotto numbers would you like to generate ? 1 = Standard Lotto 2 = Powerball");
                    int lottoOpts = scan.nextInt();

                    if (lottoOpts == 1) {
                        textLotto = lotto();
                        myLotObj.getNum();
                        myLotObj.genNums();

                        if(!file.exists()) {
                            file.createNewFile();
                        }

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

                        System.out.println(textLotto);
                    }

                    else if (lottoOpts == 2) {
                        textPwrBall = powerBall();
                        myLotObj.getNum();
                        myLotObj.genNums();

                        if(!file.exists()) {
                            file.createNewFile();
                        }

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

                        System.out.println(textPwrBall);
                    }


                    System.out.println("\nPress 2 to quit, 1 to generate new numbers\n");

                } else if (prompt == 2) {

                    System.out.println("Thanks for running this program");
                    System.exit(0);

                } else {

                    System.out.println("Incorrect option please try again.");

                }
            }
        }
        catch (Exception e) {
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
