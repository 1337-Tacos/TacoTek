package com._1n5aN1aC.tacotek.armor.module;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author 1n5aN1aC
 * A simple Small Battery Module
 */
public class Module_BatterySmall extends GenericModule {
	
	public Module_BatterySmall(String name) {
		super(name, 10000, false, true, false);
		this.maxEnergy = 10000;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		super.addInformation(itemStack, player, dataList, bool);
		dataList.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + "This is a Module_BatterySmall");
	}
	
	//Energy Methods
	
	@Override
	public int maxEnergyPulled() {
		return 10;
	}
	
	@Override
	public int maxEnergyReleased() {
		return 10;
	}
}