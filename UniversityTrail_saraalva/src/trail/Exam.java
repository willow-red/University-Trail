package trail;

import java.util.ArrayList;
import java.util.Random;

/**
 * Random Events
 * @author Sara Alvarado 
 * University Trail
 */

public class Exam extends Event{
	
	//attributes unique to random events:
	private Random rand = new Random();
	
	public Exam(int happinessStatus, int healthStatus, int gradesStatus, String nameOfEvent, double money) {
		super(happinessStatus, healthStatus, gradesStatus, nameOfEvent, money);
	}
	
	


}
