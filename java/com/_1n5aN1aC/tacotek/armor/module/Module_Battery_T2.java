package com._1n5aN1aC.tacotek.armor.module;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * A (Tier II) Battery Module
 * @author Killaa
 */
public class Module_Battery_T2 extends GenericModule{

	public Module_Battery_T2(String name) {
		super(name, 25000, false, true, false);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		super.addInformation(itemStack, player, dataList, bool);
		dataList.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + "Battery Module - Tier II");
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
