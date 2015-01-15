package wator;

import grid.*;

import java.util.Random;

public class Wator {

	public static void main(String[] args) {
		Environment env = new Environment(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Integer.parseInt(args[2]),Integer.parseInt(args[3]),
			Integer.parseInt(args[4]),Integer.parseInt(args[5]),Integer.parseInt(args[6]));
		int s = Integer.parseInt(args[7]);
		Random rand = new Random();
		for (int i = 1 ; i <= s ; i++) {
			int randomWidth = rand.nextInt(Integer.parseInt(args[0]));
			int randomHeight = rand.nextInt(Integer.parseInt(args[1]));
			env.actAt(randomWidth,randomHeight);
			env.display("step "+i+"/"+s);
		}
	}

}