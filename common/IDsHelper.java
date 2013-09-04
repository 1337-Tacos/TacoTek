package assets.tacotek.common;

import net.minecraftforge.common.Configuration;

public class IDsHelper {

	//Config File Categories
	public static String blockids = "Block IDs";
	public static String itemids = "Item IDs";
	public static String liquidids = "Liquid IDs";
	
	//Block IDs
	public static int tacoBoxID;
	
	//Item IDs
	public static int cheeseID;
	public static int doughID;
	public static int flourID;
	public static int saltID;
	public static int tacoID;
	public static int toasterID;
	public static int tortillaID;
	public static int uncookedTortillaID;
	
	//liquid IDs
	//public static int liquidConcreteStillID;
	
	public static void runConfiguration(Configuration config) {
		//Block IDs
		tacoBoxID = config.get(blockids, "Taco Box ID", 701).getInt();
		
		//Item IDs
		cheeseID = config.get(itemids, "Cheese ID", 1001).getInt();
		doughID = config.get(itemids, "Dough ID", 1002).getInt();
		flourID = config.get(itemids, "Flour ID", 1003).getInt();
		saltID = config.get(itemids, "Salt ID", 1004).getInt();
		tacoID = config.get(itemids, "Taco ID", 1005).getInt();
		toasterID = config.get(itemids, "Toaster ID", 1006).getInt();
		tortillaID = config.get(itemids, "Tortilla ID", 1007).getInt();
		uncookedTortillaID = config.get(itemids, "Uncooked Tortilla ID", 1008).getInt();
		
		//Liquid IDs
		//liquidConcreteStillID = config.get(liquidids, "Liquid Concrete Still ID", 2001).getInt();
	}
}