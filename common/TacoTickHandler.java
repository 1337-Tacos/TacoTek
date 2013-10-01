package assets.tacotek.common;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import assets.tacotek.Items.ItemsHelper;
import assets.tacotek.Items.ShieldArmor;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.Player;

public class TacoTickHandler implements ITickHandler {

	private int tCount = 0;	//Tick counter.
	private int armorCheck = 10;	//How long shield buff lasts.
	private int warmup = 0;	//Counts warmup till shield is applied.

	private void onPlayerTick(EntityPlayer player) {
		tCount++;
		//if (tCount == 5){
		// Work in progress.--> replaceItem(player,Item.bread,ItemsHelper.toast);
		//}

		//If ticks is equal to armorCheck interval.
		if (tCount == armorCheck) {

			//Zeroes out tick counter.
			tCount = 0;

			//If player is wearing chest armor.
			if(player.getCurrentItemOrArmor(3) != null) {
				//Returns what is in armor slot.
				ItemStack stack=player.getCurrentItemOrArmor(3);

				//If equipped item is a shield chest.
				if (stack.getItem() == ItemsHelper.shield_chest) {
					ShieldArmor chest = (ShieldArmor) stack.getItem();
					chest.tickArmor(stack, (Player) player);
				}
			}
		}
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		if(type.equals(EnumSet.of(TickType.PLAYER))) {
			onPlayerTick((EntityPlayer) tickData[0]);
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel() {
		return null;
	}
}