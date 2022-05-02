package trail;


public class MainSystem {
	//helper class:
	private Helper bff;
	//this prompt will be used repeatedly when getting user input:
	private String playerPrompt;
	
	
	// TODO file system thing
	public void run() {
		bff.printFancy("Welcome to University Trail");
		
	}
	public Student startGame() {
		Student player = null;
		//starting sequence (setup)
		bff.print(Majors.getMajorsMenu());
		bff.print(playerPrompt);
		int majorChoice = bff.inputInt(">>", 0, 9);
		//make specific student class based on major choice:
		switch(majorChoice) {
			case 0:
				player = new ArtStudent();
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
		//test
		System.out.println(player);
		//intro message:
		bff.print("\nWelcome to University! It is your freshman year, and the start of your adult life!\n"
				+ "You must survive your first semester by balancing good grades, chores, work, and health.\n"
				+ "You are a " + Majors.values()[majorChoice].getTitle() + " major and have a very flexible job at the campus Library,\n"
				+ "which pays at the rate of $12 an hour.\n");
		
		//TODO print class schedule
		
		//intro message #2:
		bff.print("\nBefore classes start, you must purchase supplies for class, food, and other essentials from the University Store.\n"
				+ "You have $1000 in your bank account.\n");
		
		//this would be when the screen refreshes to the shop but that is not yet implemented and may never be lol
		bff.inputLine("Hit ENTER to continue");
		//call supplies buying method:
		buySupplies();

		//return the player to be used in the main game:
		return player;
	}
	
	public void buySupplies() {
		System.out.println(Shop.getShopMenu());
	}
	
	public void gameLoop() {
		//starts game - things that happen every round
	}
	
	
	//TODO constructor for MainSystem class - initialize variables
	public MainSystem() {
		bff = new Helper();
		playerPrompt = "What is your choice?\n";
	}
	
	//for tests rn
	public static void main(String[] args) {
		
		Helper helper = new Helper();
		MainSystem program = new MainSystem();
		
		//pick if you want to start game or quit immediately
		helper.print("Welcome to University Trail");
		helper.printLine();
		helper.print("\n\t1. Begin Semester\n\t2. Quit\n");
		helper.printLine();
		helper.print("What is your choice?\n");
		int start = helper.inputInt(">>", 1, 2);
		if(start == 1) {
			//TODO check if the account is new or not. rn let's assume it is :) run startGame which sets up everything.
			program.startGame();
			program.run();
		}

	}
	
	
	
	
	

}






