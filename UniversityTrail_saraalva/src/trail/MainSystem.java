package trail;

import java.util.ArrayList;

public class MainSystem {
	//helper class:
	private Helper bff;
	//this prompt will be used repeatedly when getting user input:
	private String playerPrompt;
	//list of menu items
	private ArrayList<MenuEvent> eventMenu;
	private Student player;
	private boolean gameOver;
	
	
	// TODO file system thing
	public void run() {
		boolean keepGoing = false;
		printWeekOverview();
		//if game over:
		if(gameOver) {
			bff.print("You were not able to complete this semester. Try again :(");
		}
		else {
			bff.print("Would you like to do something else this week? (y/n)");
			bff.print("\n" + playerPrompt);
			keepGoing = bff.inputYesNo(">>");
			//if not skip week, call menu loop
			if(keepGoing) {
				menuLoop();
			}
		}

		
	}
	public void menuLoop() {
		//menu events
		printStats();
		printMenu(eventMenu);
		bff.print(playerPrompt);
		int choice = bff.inputInt(">>", 0, 11);
		switch(choice) {
		case 0:
			//study
			bff.print("Which class would you like to study for?");
			//print class schedule
			int count = 0;
			for(ClassOnSchedule c: player.getSchedule().getClassList()) {
				bff.print(count + ". " + c.getClassName());
				count++;
			}
			bff.print(playerPrompt);
			int classChoice = bff.inputInt(">>", 0, 3);
			switch(classChoice) {
			//what class you picked
				case 0:
					
					break;
				
			}
			break;
		
		}
	}
	public void printWeekOverview() {
		//print player stats to be displayed every round:
		bff.print("Week " + player.getWeekInSemester() + " of 18");
		bff.printLine();
		bff.print("A week of classes has gone by.");
		checkMealSwipes();
		checkStatuses();
		
	}
	public void printStats() {
		bff.printLine();
		bff.print("Meal Swipes: " + player.getMealSwipes());
		bff.print("Happiness: " + player.getHappinessStatus() + "/100");
		bff.print("Health: " + player.getHealthStatus() + "/100");
		bff.print("Grades: " + player.getGradesStatus() + "/100");
		bff.print("Funds: $" + String.format("%.2f", player.getFunds()));
		bff.printLine();
	
	}
	public void checkStatuses() {
		//check all status to see if they are in danger of losing:
		if(player.getGradesStatus() <= 20 && !(player.getGradesStatus() <= 0)) {
			bff.print("Warning! Your grade status is very low.");
		}
		if(player.getHealthStatus() <= 20 && !(player.getHealthStatus() <= 0)) {
			bff.print("Warning! Your health is very low.");
		}
		if(player.getHappinessStatus() <= 20 && !(player.getHappinessStatus() <= 0)) {
			bff.print("Warning! Your happiness status is very low.");
		}
		//check all status to see if its game over:
		if(player.getHealthStatus() <= 0) {
			gameOver = true;
			bff.print("Your health has dropped to 0.\nGAME OVER!");
		}
		if(player.getGradesStatus() <= 0) {
			gameOver = true;
			bff.print("You have failed your classes.\nGAME OVER!");
		}
		if(player.getHappinessStatus() <= 0) {
			gameOver = true;
			bff.print("Your mental health is too poor to continue.\nGAME OVER!");
		}
		
	}
	public void checkMealSwipes() {
		//subtract meal swipes
		if(player.getMealSwipes() < 7) {
			bff.print("You will have consumed " + player.getMealSwipes() + " meal swipes by the end of the week.");
			int difference = 7 - player.getMealSwipes();
			int healthDropped = difference*20;
			bff.print("You haven't eaten enough this week so your health has dropped by " + healthDropped);
			player.setHealthStatus(player.getHealthStatus() - healthDropped);
			player.setMealSwipes(0);
		}
		else {
			player.setMealSwipes(player.getMealSwipes()-7);
			bff.print("You will have consumed 7 meal swipes by the end of the week.");
		}
		//if they are running low
		if(player.getMealSwipes() < 7) {
			bff.print("Warning! You have " + player.getMealSwipes() + " meal swipes left.");
		}
	}
	public void startGame() {
		//get player name
		//TODO make a player file system later:
		bff.print("What is your name?");
		String name = bff.inputWord(">>");
		//starting sequence (setup)
		bff.print(Majors.getMajorsMenu());
		bff.print(playerPrompt);
		int majorChoice = bff.inputInt(">>", 0, 9);
		//make specific student class based on major choice:
		switch(majorChoice) {
			case 0:
				player = new ArtStudent(name);
				break;
			case 1:
				player = new HistoryStudent();
				break;
			case 2:
				player = new ScienceStudent();
				break;
			case 3:
				player = new LawStudent();
				break;
			case 4:
				player = new BusinessStudent();
				break;
			case 5:
				player = new EconStudent();
				break;
			case 6:
				player = new CSStudent();
				break;
			case 7:
				player = new EnglishStudent();
				break;
			case 8:
				player = new MedStudent();
				break;
			case 9:
				player = new FilmStudent();
				break;
		}
		//intro message:
		bff.print("\nWelcome to University! It is your freshman year, and the start of your adult life!\n"
				+ "You must survive your first semester by balancing good grades, chores, work, and health.\n"
				+ "You are a " + Majors.values()[majorChoice].getTitle() + " major and have a very flexible job at the campus Library,\n"
				+ "which pays at the rate of $12 an hour.\n");
		
		//print class schedule
		player.getSchedule().printClassSchedule();
		
		//intro message #2:
		bff.print("Before classes start, you must purchase supplies for class, food, and other essentials from the University Store.\n"
				+ "You have $1000 in your bank account.\n");
		
		//this would be when the screen refreshes to the shop but that is not yet implemented and may never be lol
		bff.inputLine("Hit ENTER to continue");
		//call supplies buying method:
		buySupplies(player);
		
		
	}
	
	public void makeMenu(){
		//default menu
		//happiness, health, grades, name, money
		this.eventMenu.add(new MenuEvent(-10, -5, 5,"Study", 0));
		this.eventMenu.add(new MenuEvent(-5, -10, -15,"Work", 12));
		this.eventMenu.add(new MenuEvent(10, 0, -5,"Go to " + this.player.getClub(), 0));
		this.eventMenu.add(new MenuEvent(15, 0, -5,"Go to Sporting Event", 0));
		this.eventMenu.add(new MenuEvent(10, 10, 0,"Take a Relaxing Walk", 0));
		this.eventMenu.add(new MenuEvent(15, -20, -15,"Go to a Party", 0));
		this.eventMenu.add(new MenuEvent(-5, 0, 5,"Study", 0));
		//custom event
		this.eventMenu.add(this.player.getActivity());
		
	}
	//print menu nicely
	public void printMenu(ArrayList<MenuEvent> menu) {
		int counter = 0;
		for(MenuEvent m: menu) {
			bff.print(counter + ". " + m.getNameOfEvent());
			counter++;
		}
		bff.print(counter + ". View Report Card");
		counter++;
		bff.print(counter + ". Visit University Store");
		counter++;
		bff.print(counter + ". Continue to Next Week");
		counter++;
		bff.print(counter + ". Save and Exit");
		bff.printLine();
		bff.print("\n");
	}
	//pass in specific major's supply list:
	public void buySupplies(Student person) {
		boolean exit = false;
		double total = 0.0;
		//TODO add while loop
		while(!exit) {
			System.out.println(Shop.getShopMenu());
			person.printSupplyList();
			bff.printLine();
			bff.print("Total Spent: $" + String.format("%.2f", total));
			bff.print("Amount Left: $" + String.format("%.2f", person.getFunds()) + "\n");
			bff.print(playerPrompt);
			int choice = bff.inputInt(">>", 0, 8);;
			switch(choice) {
			case 0:
				bff.print("How many textbooks?");
				int num0 = bff.inputInt(">>");
				int bookTotal = 80*num0;
				//check if they have enough money:
				if((person.getFunds()-bookTotal) <= 0) {
					bff.print("Not enough money!");
				}
				else {
					total += bookTotal;
					person.setFunds(person.getFunds()-bookTotal);
				}
				break;
			case 1:
				bff.print("How many notebooks?");
				int num1 = bff.inputInt(">>");
				int noteTotal = 5*num1;
				if((person.getFunds()-noteTotal) <= 0) {
					bff.print("Not enough money!");
				}
				else {
					total += noteTotal;
					person.setFunds(person.getFunds()-noteTotal);
				}
				break;
			case 2:
				bff.print("How many notebooks?");
				int num2 = bff.inputInt(">>");
				int novelTotal = 10*num2;
				if((person.getFunds()-novelTotal) <= 0) {
					bff.print("Not enough money!");
				}
				else {
					total += novelTotal;
					person.setFunds(person.getFunds()-novelTotal);
				}
				break;
			case 3:
				bff.print("How many paint sets?");
				int num3 = bff.inputInt(">>");
				int paintTotal = 50*num3;
				if((person.getFunds()-paintTotal) <= 0) {
					bff.print("Not enough money!");
				}
				else {
					total += paintTotal;
					person.setFunds(person.getFunds()-paintTotal);
				}
				break;
			case 4:
				bff.print("How many lab coats?");
				int num4 = bff.inputInt(">>");
				int labTotal = 20*num4;
				if((person.getFunds()-labTotal) <= 0) {
					bff.print("Not enough money!");
				}
				else {
					total += labTotal;
					person.setFunds(person.getFunds()-labTotal);
				}
				break;
			case 5:
				bff.print("How many computer mice?");
				int num5 = bff.inputInt(">>");
				int mouseTotal = 15*num5;
				if((person.getFunds()-mouseTotal) <= 0) {
					bff.print("Not enough money!");
				}
				else {
					total += mouseTotal;
					person.setFunds(person.getFunds()-mouseTotal);
				}
				break;
			case 6:
				bff.print("How many graphing calculators?");
				int num6 = bff.inputInt(">>");
				int calcTotal = 75*num6;
				if((person.getFunds()-calcTotal) <= 0) {
					bff.print("Not enough money!");
				}
				else {
					total += calcTotal;
					person.setFunds(person.getFunds()-calcTotal);
				}
				break;
			case 7:
				bff.print("How many meal swipes?");
				int num7 = bff.inputInt(">>");
				int mealTotal = 12*num7;
				if((person.getFunds()-mealTotal) <= 0) {
					bff.print("Not enough money!");
				}
				else {
					total += mealTotal;
					person.setFunds(person.getFunds()-mealTotal);
					person.setMealSwipes(person.getMealSwipes()+num7);
					bff.print("Note: you now have " + person.getMealSwipes() + " meal swipes (need 7 per week to maintain healthy)");
				}
				break;
			case 8:
				exit = true;
				break;
				
			}
		}
		
	}
	
	//TODO constructor for MainSystem class - initialize variables
	public MainSystem() {
		bff = new Helper();
		playerPrompt = "What is your choice?\n";
		eventMenu = new ArrayList<>();
		gameOver = false;
	}
	
	//for tests rn
	public static void main(String[] args) {
		
		Helper helper = new Helper();
		MainSystem program = new MainSystem();
		
		//pick if you want to start game or quit immediately
		helper.print("Welcome to University Trail");
		helper.printLine();
		helper.print("\n1. Begin Semester\n2. Quit\n");
		helper.printLine();
		helper.print("What is your choice?\n");
		int start = helper.inputInt(">>", 1, 2);
		if(start == 1) {
			//TODO check if the account is new or not. rn let's assume it is :) run startGame which sets up everything.
			program.startGame();
			program.makeMenu();
			//loop run until semester ends or until player loses
			program.run();
		}

	}
	

}


