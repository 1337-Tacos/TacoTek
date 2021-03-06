package com._1n5aN1aC.tacotek.armor.module;

import java.util.ArrayList;

import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * This class handles keeping track of a reference to each usable armor module.
 * It also Keeps a list of each module, and their restrictions.
 * @author 1n5aN1aC
 */
public abstract class ModuleHelper {

	/**
	 * This is the list of modules that is internally kept of all allowable armor modules.
	 * Any items not registered in this list will not be allowed to be put in a modular armor,
	 * as well as will not be ticked, or in any way handled by the armor system. 
	 */
	private static ArrayList<GenericModule> registeredModules = new ArrayList<GenericModule>();

	//Define Modules here
	public static Module_Battery_T1 battery_T1;
	public static Module_Battery_T2 battery_T2;
	public static Module_Battery_T3 battery_T3;
	
	public static Module_Capacitor_T1 capacitor_T1;
	public static Module_Capacitor_T2 capacitor_T2;
	public static Module_Capacitor_T3 capacitor_T3;

	/**
	 * Called during the init phase to register all the vanilla modules into the game.
	 * This method should contain a single line for each usable module in the base mod.
	 */
	public static void setupModules() {
		//Register Modules here
		GameRegistry.registerItem( battery_T1 = new Module_Battery_T1("battery_T1"), "battery_T1");
		GameRegistry.registerItem( battery_T2 = new Module_Battery_T2("battery_T2"), "battery_T2");
		GameRegistry.registerItem( battery_T3 = new Module_Battery_T3("battery_T3"), "battery_T3");
		GameRegistry.registerItem( capacitor_T1 = new Module_Capacitor_T1("capacitor_T1"), "capacitor_T1");
		GameRegistry.registerItem( capacitor_T2 = new Module_Capacitor_T2("capacitor_T2"), "capacitor_T2");
		GameRegistry.registerItem( capacitor_T3 = new Module_Capacitor_T3("capacitor_T3"), "capacitor_T3");
	}

	public static void registerModules() {
		//Now we register each module with our module system:
		registerModule(battery_T1);
		registerModule(battery_T2);
		registerModule(battery_T3);
		registerModule(capacitor_T1);
		registerModule(capacitor_T2);
		registerModule(capacitor_T3);
	}

	/**
	 * This takes a single module as an argument, and registers it into the mods internal list
	 * This is required to make the module actually work as a module in any modular armor.
	 * 
	 * @param module the modular armor module that you want to add to
	 * the list of registered modules.
	 */
	public static void registerModule(GenericModule module) {
		//First we make sure that the module isn't already in the list
		for (GenericModule moduleInList : registeredModules) {
			//If it is, we return without adding it.
			if (moduleInList.getClass() == module.getClass()) {
				return;
			}
		}
		//Then we just add the new module to the list!
		registeredModules.add(module);
	}
}