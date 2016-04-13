import java.util.*;

public class Lottery {
	public static void main (String[] args){
		Random ballnumbers = new Random();
		
		for (int i = 0; i < 6; i++){
		System.out.print(ballnumbers.nextInt(50) + " ");
		}
	}
}
