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

		try {
			for (; ; ) {

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

						}
					}

					for (int i = 1; i < BallHolder.size(); i++) {

						System.out.print(BallHolder.get(i) + " ");

					}

					System.out.println("\nPress 2 to quit, 1 to generate new numbers\n");
					BallHolder.clear();

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
