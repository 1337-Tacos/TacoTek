package com._1n5aN1aC.tacotek.handlers;

import java.util.HashMap;
import java.util.Map;

import com._1n5aN1aC.tacotek.armor.ModularArmorMain;

import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

/**
 * Called every tick.  Per player.  Yes.
 * @author 1n5aN1aC
 */
public class TacoPlayerTickHandler {

	/**
	 * A map of integer arrays. </br>
	 * [0] is whether the user seems to be wearing our armor
	 * [1] is how many ticks left for a re-check.
	 */
	Map<Integer, int[]> playerList = new HashMap<Integer, int[]>();

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=false)
	public void onEvent(PlayerTickEvent event) {
		//We're only running this on the tick-ending tick.
		//This may be improper, we will need to investigate
		if (event.phase == Phase.END) {
			//get the player's ID, and then take care of it.
			checkPlayer(event.player.getEntityId(), event);
		}
	}

	/**
	 * Takes a playerID as a arg, and checks if they are currently being ticked.  </br>
	 * Takes care of handling adding them to the tick, and incrementing ticks.
	 * @param player the (mostly) unique ID of this player.
	 * @param event
	 */
	private void checkPlayer(int player, PlayerTickEvent event) {
		//Make sure the player exists
		if (playerList.containsKey(player)) {
			//Now check if the player needs a fullCheck.
			if (playerList.get(player)[0] < 1) {
				runPlayer(player, event);
			}
			//Decrement the player's counter
			playerList.put(player, new int[]{playerList.get(player)[0] - 1, playerList.get(player)[1]} );
		}
		//Oops, new player, so we need to add it to our list
		else {
			playerList.put(player, new int[]{1200, 0});
		}
	}

	/**
	 * Ran only when the player has ticked down to 0, and therefore needs a full check. </br>
	 * Checks whether we need to run the clean-up work for when the player unequips their armor.
	 * @param player the ID of the player to do a full-check on.
	 * @param event
	 */
	private void runPlayer(int player, PlayerTickEvent event) {
		//If the player is wearing ModularArmor, set it as such
		if (event.player.inventory.armorItemInSlot(2) != null && event.player.inventory.armorItemInSlot(2).getItem() instanceof ModularArmorMain) {
			//If we just put the armor on
			if (playerList.get(player)[1] == 0) {
				System.out.println("just put on");
			}
			playerList.put(player, new int[]{100, 1});
			return;
		}
		//Did the player just take their armor off?
		else if (playerList.get(player)[1] == 1) {
			System.out.println("just took off");
		}
		playerList.put(player, new int[]{200, 0});
	}
}