/**
 * 
 */
package trail;

/**
 * @author saraalvarado
 *apply to classes that should have a "status": variables that indicate a happiness, health, and grade status levels.
 */
public interface HasStatus {
	//any class that implements HasStatus should have methods to return a percentage of happiness,health, and grades.
	public void setHappinessStatus(int numStatusPoints);
	public void setHealthStatus(int numStatusPoints);
	public void setGradesStatus(int numStatusPoints);
	
	public int getHappinessStatus();
	public int getHealthStatus();
	public int getGradesStatus();
	
	public void printHappinessStatus();
	public void printHealthStatus();
	public void printGradesStatus();
	
}
