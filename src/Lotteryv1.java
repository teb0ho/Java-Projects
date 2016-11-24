import java.util.*;
import java.io.*;


public class Lotteryv1 {
	public static void main (String[] args) {
		Random ballnumbers = new Random();
		InputStreamReader readr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(readr);
		
		System.out.println();
		
		
		for (int i = 0; i < 6; i++){
		System.out.print(ballnumbers.nextInt(50) + " ");
		}
	}
}
