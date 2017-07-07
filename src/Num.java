import java.util.Random;
import java.util.ArrayList;

class Num {

  public static String lotto () {

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

  public static String powerBall () {

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

}
