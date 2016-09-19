import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Lottery {

	public static void main (String[] args) {

		Random ballpicker = new Random();
		ArrayList<Integer> BallHolder = new ArrayList<Integer>();
		int gua = 0;
		int gua2 = 0;

		System.out.println("Would you like to generate some numbers ? 1 = yes and 2 = no");
		Scanner scan = new Scanner(System.in);

		int prompt = scan.nextInt();

		if (prompt == 1) {

				BallHolder.add(null);

				for (int i = 0; i < 6; i++) {

					gua = ballpicker.nextInt(50);
					gua2 = ballpicker.nextInt(50);

					if (!(BallHolder.contains(gua)) && gua > 0) {

						BallHolder.add(gua);

					} else if (!(BallHolder.contains(gua2)) && gua2 > 0) {

						BallHolder.add(gua2);
					} else {

					}
				}

				for (int i = 1; i < BallHolder.size(); i++) {

					System.out.print(BallHolder.get(i) + " ");
				}

		}

		else if (prompt == 2) {

			System.out.println("Thanks for running this program");
			System.exit(0);

		}

		else {

			System.out.println("Incorrect option please try again.");

		}
	}
}
