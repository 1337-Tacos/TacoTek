package assets.tacotek.common;

import java.util.EnumSet;

import assets.tacotek.Items.ItemsHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TacoTickHandler implements ITickHandler {
//4 Helmet 3 Chest 2 Legs 1 Boots
	
	//Tick counter.
	int interval=0;
	
	//Runs every player tick.
	private void onPlayerTick(EntityPlayer player){
		interval++;
		
		//Checks if 5 ticks have passed.
		if (interval==100){
			
			//Zeroes out interval counter.
			interval=0;
			
			//If player is wearing chest armor.
			if(player.getCurrentItemOrArmor(3)!=null){
			
				ItemStack chest=player.getCurrentItemOrArmor(3);
			
				//If chest armor is Shield Unit.
				if(chest.getItem() == ItemsHelper.shield_chest){
					player.addPotionEffect((new PotionEffect(22,100,2)));
					player.addChatMessage(chest.toString());
				}
			}
		}
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		if(type.equals(EnumSet.of(TickType.PLAYER))){
			
			onPlayerTick((EntityPlayer) tickData[0]);
			
		}

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
