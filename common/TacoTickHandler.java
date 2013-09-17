package assets.tacotek.common;

import java.util.EnumSet;

import assets.tacotek.Items.ItemsHelper;
import assets.tacotek.Items.ShieldArmor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.Player;

public class TacoTickHandler implements ITickHandler {
	
	private int tCount=0;	//Tick counter.
	private int armorRate=100;	//How long shield buff lasts.
	private int warmup=0;	//Counts warmup till shield is applied.
	
	private void onPlayerTick(EntityPlayer player) {
		tCount++;
		
		//if (tCount==5){
		// Work in progress.--> replaceItem(player,Item.bread,ItemsHelper.toast);
		//}
		
		if (tCount==armorRate) {
			
			//Zeroes out tick counter.
			tCount=0;
			
			//If player is wearing chest armor.
			if(player.getCurrentItemOrArmor(3)!=null) {
				ItemStack stack=player.getCurrentItemOrArmor(3);
				
				//If equiped item is a shield chest.
				if (stack.getItem()==ItemsHelper.shield_chest) {
					ShieldArmor chest = (ShieldArmor) stack.getItem();
				
					if (chest!=null) {
						chest.tickArmor(stack, (Player) player);
					}
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