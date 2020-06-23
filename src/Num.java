package src;

import java.util.Random;
import java.util.ArrayList;

class Num {

  static String lotto() {

      StringBuilder textLotto = new StringBuilder();
      Random ballpicker = new Random();
      ArrayList<Integer> BallHolder = new ArrayList<>();
      String sBall, sBall1;
      int rdmNum;

      BallHolder.add(null);

      do {
          rdmNum = ballpicker.nextInt(50);

          if (!(BallHolder.contains(rdmNum)) && rdmNum > 0)
              BallHolder.add(rdmNum);


      } while (BallHolder.size() != 7);


      for (int i = 1; i < BallHolder.size(); i++) {

          sBall = BallHolder.get(i).toString();

          if (sBall.length() < 2)
              sBall1 = "0" + sBall;
          else
              sBall1 = sBall;


          textLotto.append(sBall1).append(" ");

      }

      return textLotto.toString();
  }

  static String powerBall() {

      StringBuilder textPwrBall = new StringBuilder();
      Random ballpicker = new Random();
      ArrayList<Integer> BallHolder = new ArrayList<>();
      String sBall, sBall1;
      int rdmNum, pwrBall;

      BallHolder.add(null);

      do {
          rdmNum = ballpicker.nextInt(50);

          if (!(BallHolder.contains(rdmNum)) && rdmNum > 0)
              BallHolder.add(rdmNum);


      } while (BallHolder.size() != 6);

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

          textPwrBall.append(sBall1).append(" ");

      }

      return textPwrBall.toString();

  }

}
