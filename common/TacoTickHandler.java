package assets.tacotek.common;

import java.util.EnumSet;

import assets.tacotek.Items.ItemsHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TacoTickHandler implements ITickHandler {
//4 Helmet 3 Chest 2 Legs 1 Boots
	
	private void onPlayerTick(EntityPlayer player){
		
		if(player.getCurrentItemOrArmor(4)!=null){
			ItemStack helmet=player.getCurrentItemOrArmor(4);
			if(helmet.getItem() == ItemsHelper.tux_chest){
				player.addPotionEffect((new PotionEffect(22,10,2)));
			}
		}
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
