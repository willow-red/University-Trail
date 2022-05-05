package trail;

import java.util.ArrayList;
import java.util.Random;

/**
 * Random Events
 * @author Sara Alvarado 
 * University Trail
 */

public class RandomEvent extends Event{
	
	//attributes unique to random events:
	private Random rand = new Random();
	
	public RandomEvent(int happinessStatus, int healthStatus, int gradesStatus, String nameOfEvent, double money) {
		super(happinessStatus, healthStatus, gradesStatus, nameOfEvent, money);
	}
	
	//constructed using random values , cannot input values.
	public RandomEvent() {
		
	}
	//generator methods
	
	//generates the name of the event:
	private String randomGoodEvent() {
		String eventName = "";
		//hardcoded good events:
		ArrayList<String> goodEvents = new ArrayList<>();
		goodEvents.add("You ");
		
		
		
		return eventName;
	}
	private String randomBadEvent() {
		String eventName = "";
		//hardcoded bad events:
		
		
		
		
		return eventName;
	}
	
	
	private int randomHappiness() {
		
	}

}
