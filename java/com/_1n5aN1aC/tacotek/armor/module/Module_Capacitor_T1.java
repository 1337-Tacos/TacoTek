package com._1n5aN1aC.tacotek.armor.module;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * A (Tier I) Capacitor
 * This holds a very small amount of power, but has large energy pull and release rates.
 * @author Killaa
 */

public class Module_Capacitor_T1 extends GenericModule {

	public Module_Capacitor_T1(String name) {
		super(name, 1000, false, true, false);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		super.addInformation(itemStack, player, dataList, bool);
		dataList.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + "Recieves and Releases Power Quickly");
	}
	
	//Energy Methods
	
	@Override
	public int maxEnergyPulled() {
		return 100;
	}
	
	@Override
	public int maxEnergyReleased() {
		return 100;
	}
	
}
