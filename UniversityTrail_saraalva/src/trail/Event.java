package trail;

public abstract class Event implements HasStatus{
	private int happinessStatus;
	private int healthStatus;
	private int gradesStatus;
	

	public void setHappinessStatus(int happinessStatus) {
		this.happinessStatus = happinessStatus;
	}

	public void setHealthStatus(int healthStatus) {
		this.healthStatus = healthStatus;
	}

	public void setGradesStatus(int gradesStatus) {
		this.gradesStatus = gradesStatus;
	}
	
	
}
