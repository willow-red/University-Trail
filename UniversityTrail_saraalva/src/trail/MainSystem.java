package trail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainSystem {
	//helper class:
	private Helper bff;
	//this prompt will be used repeatedly when getting user input:
	private String playerPrompt;
	//list of menu items
	private ArrayList<MenuEvent> eventMenu;
	private Student player;
	private boolean gameOver;
	private String playerName;
	File saveFile = null;
	
	
	public void fileMenu() {
		String SAVE_FILE_LOCATION = "./saves/";
		File savesFolder = new File(SAVE_FILE_LOCATION);
		savesFolder.mkdir();	// make saves folder if it doesnt exist
		
		//printing all the save files
		String prompt = "Open a Save File:";
		File[] files = savesFolder.listFiles();
	    for (int i = 0; i < files.length; i++){
	        if (files[i].isFile()){ //if its a file
	        	prompt += "\n\t" + String.valueOf(i+1) + ". " + files[i].getName();
	        }
	    }
	    for(int i = files.length; i < 3; i++) {
	    	prompt += "\n\t" + String.valueOf(i+1) + ". (Empty)";
	    }
	    bff.printFancy(prompt);
	    int input = bff.inputInt("What is your choice?",1,3);
	    
	    //if new account
	    if((input-1) >= files.length) {
	    	System.out.println("Save File " + input + " is empty. Create a new one:");
	    	playerName = bff.inputWord("Enter a name");
	    	saveFile = new File(SAVE_FILE_LOCATION + playerName + ".txt");
	    	bff.print("Created new save file named " + playerName + "!");
	    	startGame();
	    	
	    } else {
	    	saveFile = files[input-1];
	    	ArrayList<Object> data = load(saveFile.getName());
	    	if(data == null) {
				System.out.println("This shouldnt happen1");
			} 
	    	else if(data.size() == 0) {
				System.out.println("This shouldnt happen2");
			} 
	    	else {
				System.out.println("Welcome back!");
				//check what object to create
				//String typeOfStudent, String name, double funds, String year, int week, 
				//int mealSwipes, int happiness, int health, int grades
				
				if(((String)data.get(0)).equalsIgnoreCase("ArtStudent")) {
					player = new ArtStudent((String)data.get(1), (double)data.get(2), (String)data.get(3),
							(int)data.get(4), (int)data.get(5), (int)data.get(6), (int)data.get(7), (int)data.get(8));
				}
				else if(((String)data.get(0)).equalsIgnoreCase("BusinessStudent")) {
					player = new BusinessStudent((String)data.get(1), (double)data.get(2), (String)data.get(3),
							(int)data.get(4), (int)data.get(5), (int)data.get(6), (int)data.get(7), (int)data.get(8));
				}
				else if(((String)data.get(0)).equalsIgnoreCase("CSStudent")) {
					player = new CSStudent((String)data.get(1), (double)data.get(2), (String)data.get(3),
							(int)data.get(4), (int)data.get(5), (int)data.get(6), (int)data.get(7), (int)data.get(8));
				}
				else if(((String)data.get(0)).equalsIgnoreCase("EconStudent")) {
					player = new EconStudent((String)data.get(1), (double)data.get(2), (String)data.get(3),
							(int)data.get(4), (int)data.get(5), (int)data.get(6), (int)data.get(7), (int)data.get(8));
				}
				else if(((String)data.get(0)).equalsIgnoreCase("EnglishStudent")) {
					player = new EnglishStudent((String)data.get(1), (double)data.get(2), (String)data.get(3),
							(int)data.get(4), (int)data.get(5), (int)data.get(6), (int)data.get(7), (int)data.get(8));
				}
				else if(((String)data.get(0)).equalsIgnoreCase("FilmStudent")) {
					player = new FilmStudent((String)data.get(1), (double)data.get(2), (String)data.get(3),
							(int)data.get(4), (int)data.get(5), (int)data.get(6), (int)data.get(7), (int)data.get(8));
				}
				else if(((String)data.get(0)).equalsIgnoreCase("HistoryStudent")) {
					player = new HistoryStudent((String)data.get(1), (double)data.get(2), (String)data.get(3),
							(int)data.get(4), (int)data.get(5), (int)data.get(6), (int)data.get(7), (int)data.get(8));
				}
				else if(((String)data.get(0)).equalsIgnoreCase("LawStudent")) {
					player = new LawStudent((String)data.get(1), (double)data.get(2), (String)data.get(3),
							(int)data.get(4), (int)data.get(5), (int)data.get(6), (int)data.get(7), (int)data.get(8));
				}
				else if(((String)data.get(0)).equalsIgnoreCase("MedStudent")) {
					player = new MedStudent((String)data.get(1), (double)data.get(2), (String)data.get(3),
							(int)data.get(4), (int)data.get(5), (int)data.get(6), (int)data.get(7), (int)data.get(8));
				}
				else if(((String)data.get(0)).equalsIgnoreCase("ScienceStudent")) {
					player = new ScienceStudent((String)data.get(1), (double)data.get(2), (String)data.get(3),
							(int)data.get(4), (int)data.get(5), (int)data.get(6), (int)data.get(7), (int)data.get(8));
				}
				
				System.out.println("Name: " + player.getName());
				printStats();

			}
	    	
	    }
	}
		
	//save and quit
	public void saveAndQuit() {
		Boolean saveSuccess = save(saveFile.getName(), player.getMajorName(), player.getName(), player.getFunds(),
				player.getYear(), player.getWeekInSemester(), player.getMealSwipes(), player.getHappinessStatus(),
				player.getHealthStatus(), player.getGradesStatus());
		if(saveSuccess) {
			System.out.println("We saved your data successfully :) See you next time!");
		} 
		else {
			System.out.println("Oh no we weren't able to save your data");
		}
		
	}
		
	//loads data from text file, returns an arraylist of the data *IN THE SAME ORDER YOU SAVED IT IN*
	//return = null; means there was an error opening the file
	//return = empty arraylist; means the user hasnt made a save file before
	//return = arraylist; means the user made a save file before and theres data in it
	public static ArrayList<Object> load(String FILE_NAME) {
		ArrayList<Object> data = new ArrayList<>();
		try(FileInputStream fis = new FileInputStream("./saves/" + FILE_NAME); Scanner sc = new Scanner(fis)){
              String typeOfStudent = sc.nextLine();
              String name = sc.nextLine(); 
              double funds = sc.nextDouble(); 
              sc.nextLine();
              String year = sc.nextLine();
              int week = sc.nextInt();
              sc.nextLine();
              int mealSwipes = sc.nextInt();
              sc.nextLine();
              int happiness = sc.nextInt();
              sc.nextLine();
              int health = sc.nextInt();
              sc.nextLine();
              int grades = sc.nextInt();
              sc.nextLine();
              
              data.add(typeOfStudent);
              data.add(name);
              data.add(funds);
              data.add(year);
              data.add(week);
              data.add(mealSwipes);
              data.add(happiness);
              data.add(health);
              data.add(grades);
              
              return data;
		} 
		catch (FileNotFoundException e) {
			return data;
		} 
		catch (IOException e) {
			System.out.println("IO Exception :(");
			return null;
		}
	}
	//saves data to text file, parameters you want to save can be added in the arguments
		//return = true; means successfully saved data
		//return = false; means it failed to save the data
		public boolean save(String FILE_NAME, String typeOfStudent, String name, double funds, String year, int week, 
				int mealSwipes, int happiness, int health, int grades) {
			try(FileOutputStream fos = new FileOutputStream("./saves/" + FILE_NAME); PrintWriter pw = new PrintWriter(fos)){
				pw.println(typeOfStudent);
				pw.println(name); 
				pw.println(funds); 
				pw.println(year);
				pw.println(week);
				pw.println(mealSwipes);
				pw.println(happiness);
				pw.println(health);
				pw.println(grades);
				return true;
			} 
			catch (FileNotFoundException e) {
				System.out.println("File not found :(");
				return false;
			} 
			catch (IOException e) {
				System.out.println("IO Exception :(");
				return false;
			}
		}
	
	
	
	public void run() {
		//game loop
		while(!gameOver && player.getWeekInSemester()<=18) {
			week();
		}
		if(player.getWeekInSemester()==18) {
			bff.print("You have successfully survived this semester!! Here are your final stats and grades:");
			printStats();
			player.getSchedule().setGpa();
			player.getSchedule().printReportCard();
			
		}
	}
	public void week() {
		//do this every week
		boolean keepGoing = false;
		printWeekOverview();
		if(player.getWeekInSemester()!=1) {
			checkIfStudied();
			//add health
			player.setHealthStatus(player.getHealthStatus()+15);
		}
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
			player.setWeekInSemester(player.getWeekInSemester()+1);
		}

		
	}
	public void menuLoop() {
		//menu events
		boolean exit = false;
		while(!exit) {
			printStats();
			printMenu(eventMenu);
			bff.print(playerPrompt);
			int choice = bff.inputInt(">>", 0, 11);
			switch(choice) {
			case 0:
				//study
				bff.print("Which class would you like to study for?");
				bff.printLine();
				//print class schedule
				int count = 0;
				for(ClassOnSchedule c: player.getSchedule().getClassList()) {
					bff.print(count + ". " + c.getClassName());
					count++;
				}
				bff.printLine();
				bff.print(playerPrompt);
				int classChoice = bff.inputInt(">>", 0, 3);
				//get the class:
				player.getSchedule().getClassList().get(classChoice).setStudied(true);
				bff.print("This class requires " + player.getSchedule().getClassList().get(classChoice).getNumStudyingRequired() +
						" hours of studying per week.");
				//increase individual class points
				player.getSchedule().getClassList().get(classChoice).study();
				//update grades
				player.getSchedule().getClassList().get(classChoice).setClassGradeLetter();
				//update statuses
				bff.print("Happiness: " + eventMenu.get(0).getHappinessStatus()*player.getSchedule().getClassList().get(classChoice).getNumStudyingRequired());
				player.setHappinessStatus(player.getHappinessStatus() + (eventMenu.get(0).getHappinessStatus()*player.getSchedule().getClassList().get(classChoice).getNumStudyingRequired()));
				bff.print("Health: " + eventMenu.get(0).getHealthStatus()*player.getSchedule().getClassList().get(classChoice).getNumStudyingRequired());
				player.setHealthStatus(player.getHealthStatus() + (eventMenu.get(0).getHealthStatus()*player.getSchedule().getClassList().get(classChoice).getNumStudyingRequired()));
				bff.print("Grades Status: " + eventMenu.get(0).getGradesStatus()*player.getSchedule().getClassList().get(classChoice).getNumStudyingRequired());
				player.setGradesStatus(player.getGradesStatus() + (eventMenu.get(0).getGradesStatus()*player.getSchedule().getClassList().get(classChoice).getNumStudyingRequired()));
				break;
			case 1:
				//work
				bff.print("How many hours would you like to work?\n");
				bff.print(playerPrompt);
				int hours = bff.inputInt(">>", 0, 15);
				bff.print("Happiness: " + eventMenu.get(1).getHappinessStatus()*hours);
				player.setHappinessStatus(player.getHappinessStatus() + (eventMenu.get(1).getHappinessStatus()*hours));
				bff.print("Health: " + eventMenu.get(1).getHealthStatus()*hours);
				player.setHealthStatus(player.getHealthStatus() + (eventMenu.get(1).getHealthStatus()*hours));
				bff.print("Grades Status: " + eventMenu.get(1).getGradesStatus()*hours);
				player.setGradesStatus(player.getGradesStatus() + (eventMenu.get(1).getGradesStatus()*hours));
				bff.print("Funds: " + eventMenu.get(1).getMoney()*hours);
				player.setFunds(player.getFunds() + (eventMenu.get(1).getMoney()*hours));
				break;
			case 2:
				//club
				bff.print("You went to " + player.getClub() + ".\n");
				bff.print("Happiness: " + eventMenu.get(2).getHappinessStatus());
				player.setHappinessStatus(player.getHappinessStatus() + (eventMenu.get(2).getHappinessStatus()));
				bff.print("Health: " + eventMenu.get(2).getHealthStatus());
				player.setHealthStatus(player.getHealthStatus() + (eventMenu.get(2).getHealthStatus()));
				bff.print("Grades Status: " + eventMenu.get(2).getGradesStatus());
				player.setGradesStatus(player.getGradesStatus() + (eventMenu.get(2).getGradesStatus()));
				break;
			case 3:
				//sport event
				bff.print("You went to a sporting event.\n");
				bff.print("Happiness: " + eventMenu.get(3).getHappinessStatus());
				player.setHappinessStatus(player.getHappinessStatus() + (eventMenu.get(3).getHappinessStatus()));
				bff.print("Health: " + eventMenu.get(3).getHealthStatus());
				player.setHealthStatus(player.getHealthStatus() + (eventMenu.get(3).getHealthStatus()));
				bff.print("Grades Status: " + eventMenu.get(3).getGradesStatus());
				player.setGradesStatus(player.getGradesStatus() + (eventMenu.get(3).getGradesStatus()));
				break;
			case 4:
				//walk
				bff.print("You took a relaxing walk.\n");
				bff.print("Happiness: " + eventMenu.get(4).getHappinessStatus());
				player.setHappinessStatus(player.getHappinessStatus() + (eventMenu.get(4).getHappinessStatus()));
				bff.print("Health: " + eventMenu.get(4).getHealthStatus());
				player.setHealthStatus(player.getHealthStatus() + (eventMenu.get(4).getHealthStatus()));
				bff.print("Grades Status: " + eventMenu.get(4).getGradesStatus());
				player.setGradesStatus(player.getGradesStatus() + (eventMenu.get(4).getGradesStatus()));
				break;
			case 5:
				//party
				bff.print("You went to a late night party.\n");
				bff.print("Happiness: " + eventMenu.get(5).getHappinessStatus());
				player.setHappinessStatus(player.getHappinessStatus() + (eventMenu.get(5).getHappinessStatus()));
				bff.print("Health: " + eventMenu.get(5).getHealthStatus());
				player.setHealthStatus(player.getHealthStatus() + (eventMenu.get(5).getHealthStatus()));
				bff.print("Grades Status: " + eventMenu.get(5).getGradesStatus());
				player.setGradesStatus(player.getGradesStatus() + (eventMenu.get(5).getGradesStatus()));
				break;
			case 6:
				//custom activity
				bff.print("You did your favorite activity, " + player.getActivity().getNameOfEvent() + "!\n");
				bff.print("Happiness: " + eventMenu.get(6).getHappinessStatus());
				player.setHappinessStatus(player.getHappinessStatus() + (eventMenu.get(6).getHappinessStatus()));
				bff.print("Health: " + eventMenu.get(6).getHealthStatus());
				player.setHealthStatus(player.getHealthStatus() + (eventMenu.get(6).getHealthStatus()));
				bff.print("Grades Status: " + eventMenu.get(6).getGradesStatus());
				player.setGradesStatus(player.getGradesStatus() + (eventMenu.get(6).getGradesStatus()));
				break;
			case 7:
				//report card
				player.getSchedule().setGpa();
				player.getSchedule().printReportCard();
				bff.print("Press ENTER to continue");
				bff.inputLine(">>");
				break;
			case 8:
				//store
				buySupplies(player);
				break;
			case 9:
				exit = true;
				break;
			case 10:
				//save and exit
				saveAndQuit();
				gameOver = true;
				exit = true;
				break;
			
			}
		}
		
	}
	public void checkIfStudied() {
		//loop thru class schedule
		for(ClassOnSchedule c: player.getSchedule().getClassList()) {
			if(!c.isStudied() && c.getNumStudyingRequired() != 0) {
			//if one class says false as studied, take away grade points
				bff.print("\nYou forgot to study for " + c.getClassName() + " last week!");
				c.setClassGradeNum(c.getClassGradeNum() - (c.getNumStudyingRequired()*5));
				c.setClassGradeLetter();
				bff.print("Your grade for this class is now " + c.getClassGradeLetter());
				player.setGradesStatus(player.getGradesStatus() - (c.getNumStudyingRequired()*2));
			}
			c.setStudied(false);
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
		
		//grades every round
		
		
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
		//starting sequence (setup)
		bff.print(Majors.getMajorsMenu());
		bff.print(playerPrompt);
		int majorChoice = bff.inputInt(">>", 0, 9);
		//make specific student class based on major choice:
		switch(majorChoice) {
			case 0:
				player = new ArtStudent(playerName);
				break;
			case 1:
				player = new HistoryStudent(playerName);
				break;
			case 2:
				player = new ScienceStudent(playerName);
				break;
			case 3:
				player = new LawStudent(playerName);
				break;
			case 4:
				player = new BusinessStudent(playerName);
				break;
			case 5:
				player = new EconStudent(playerName);
				break;
			case 6:
				player = new CSStudent(playerName);
				break;
			case 7:
				player = new EnglishStudent(playerName);
				break;
			case 8:
				player = new MedStudent(playerName);
				break;
			case 9:
				player = new FilmStudent(playerName);
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
		this.eventMenu.add(new MenuEvent(-5, 0, 5,"Study", 0));
		this.eventMenu.add(new MenuEvent(-2, -2, -2,"Work", 12));
		this.eventMenu.add(new MenuEvent(10, 0, -5,"Go to " + this.player.getClub(), 0));
		this.eventMenu.add(new MenuEvent(15, 0, -5,"Go to Sporting Event", 0));
		this.eventMenu.add(new MenuEvent(10, 10, 0,"Take a Relaxing Walk", 0));
		this.eventMenu.add(new MenuEvent(15, -20, -15,"Go to a Party", 0));
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
		playerName = null;
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
			program.fileMenu();
			program.makeMenu();
			program.run();
			
		}

	}
	

}


