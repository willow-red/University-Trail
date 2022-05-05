package trail;

import java.util.Objects;

public abstract class Event implements HasStatus{
	
	//pojo
	private int happinessStatus;
	private int healthStatus;
	private int gradesStatus;
	private String nameOfEvent;
	private double money;
	
	
	public Event(int happinessStatus, int healthStatus, int gradesStatus, String nameOfEvent, double money) {
		super();
		this.happinessStatus = happinessStatus;
		this.healthStatus = healthStatus;
		this.gradesStatus = gradesStatus;
		this.nameOfEvent = nameOfEvent;
		this.money = money;
	}


	public int getHappinessStatus() {
		return happinessStatus;
	}
	public void setHappinessStatus(int happinessStatus) {
		this.happinessStatus = happinessStatus;
	}
	public int getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(int healthStatus) {
		this.healthStatus = healthStatus;
	}
	public int getGradesStatus() {
		return gradesStatus;
	}
	public void setGradesStatus(int gradesStatus) {
		this.gradesStatus = gradesStatus;
	}
	public String getNameOfEvent() {
		return nameOfEvent;
	}
	public void setNameOfEvent(String nameOfEvent) {
		this.nameOfEvent = nameOfEvent;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}


	@Override
	public int hashCode() {
		return Objects.hash(gradesStatus, happinessStatus, healthStatus, money, nameOfEvent);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return gradesStatus == other.gradesStatus && happinessStatus == other.happinessStatus
				&& healthStatus == other.healthStatus
				&& Double.doubleToLongBits(money) == Double.doubleToLongBits(other.money)
				&& Objects.equals(nameOfEvent, other.nameOfEvent);
	}


	@Override
	public String toString() {
		return "Event [happinessStatus=" + happinessStatus + ", healthStatus=" + healthStatus + ", gradesStatus="
				+ gradesStatus + ", nameOfEvent=" + nameOfEvent + ", money=" + money + "]";
	}
	
	public void printHappinessStatus() {
		System.out.println(this.happinessStatus + "/" + 100);
	}
	public void printHealthStatus() {
		System.out.println(this.healthStatus + "/" + 100);
	}
	public void printGradesStatus() {
		System.out.println(this.gradesStatus + "/" + 100);
	}


	
	
}
