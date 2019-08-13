package main.java.stockmarket.Handlers;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomValueHandler {
	
	Random randGenerator;
	
	public RandomValueHandler() {
		randGenerator = new Random();
	}
	
	public  int generateRandomIntInRange(int min, int max) {
		randGenerator.setSeed(System.currentTimeMillis());
	    return randGenerator.nextInt((max - min) + 1) + min;
	}
	
	public  double generateRandomDoubleInRange(double min, double max) {	
		randGenerator.setSeed(System.currentTimeMillis());

		double result = (randGenerator.nextDouble()*(max-min+1)) + min;
		result = result*100;
		result = Math.round(result);
		result = result /100;
	    return result;
	}
}
