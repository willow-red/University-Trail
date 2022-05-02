package trail;


/**
 * Shop
 * @author Sara Alvarado 
 * University Trail
 */

//Used HW08 PersonExplorerMenu as a loose guide for a menu system.
public enum Shop {
	TEXTBOOK("Textbook", 80.00),
	NOTEBOOK("Notebook", 5.00),
	NOVEL("Novel", 10.00),
	PAINT_SET("Paint Set", 50.00),
	LAB_COAT("Lab Coat", 20.00),
	COMPUTER_MOUSE("Computer Mouse", 15.00),
	GRAPHING_CALCULATOR("Graphing Calculator", 75.00),
	MEAL_SWIPE("Meal Swipe", 12.00);
	
	private final String item;
	private final double price;
	
	Shop(String item, double price){
		this.item = item;
		this.price = price;
	}
	//print a nice looking shop menu!
	public static String getShopMenu() {
		String menu = "\n";
		for(int i = 0; i<32; i++) {
			menu+="-";
		}
		menu+="\n\tUniversity Store\n";
		for(int i = 0; i<32; i++) {
			menu+="-";
		}
		menu+= "\n";
		for(Shop op: Shop.values()) {
			//for the longer menu items, so the prices line up:
			if(op.ordinal() == 5 || op.ordinal() == 6) {
				menu += op.ordinal() + ". " + op.item + "\t$" + String.format("%.2f", op.price) + "\n";
			}
			//for every other menu item
			else {
				menu += op.ordinal() + ". " + op.item + "\t\t$" + String.format("%.2f", op.price) + "\n";
			}
		}
		menu += "8. Exit Store\n";
		for(int i = 0; i<32; i++) {
			menu+="-";
		}
		return menu;
	}

}
