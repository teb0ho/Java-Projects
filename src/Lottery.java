import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.Date;

/**
 * Created by Teb0ho on 2016-11-24 - 2016-11-28.
 */

public class lottery {

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
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        System.out.println("Would you like to generate some numbers ? 1 = yes and 2 = no");

        try {
            for (; ; ) {

                Scanner scan = new Scanner(System.in);

                int prompt = scan.nextInt();

                if (prompt == 1) {

                    System.out.println("Would you type of lotto numbers would you like to generate ? 1 = lotto 2 = Powerball");
                    int lottoOpts = scan.nextInt();

                    if (lottoOpts == 1) {
                        textLotto = lotto();



                        if(!file.exists()) {
                            file.createNewFile();
                        }

                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(textLotto + "\tLotto\t\t" + dateFormat.format(date) + "\n");
                        bufferedWriter.close();

                        System.out.println(textLotto);
                    }

                    else if (lottoOpts == 2) {
                        textPwrBall = powerBall();

                        if(!file.exists()) {
                            file.createNewFile();
                        }

                        FileWriter fileWriter = new FileWriter(file, true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(textPwrBall + "\tPowerball\t" + dateFormat.format(date) + "\n");
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
    }
}
