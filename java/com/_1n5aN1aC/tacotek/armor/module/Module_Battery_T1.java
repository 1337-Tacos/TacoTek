package com._1n5aN1aC.tacotek.armor.module;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * A (Tier I) Battery Module
 * This holds a small-ish amount of power, and can transfer a relatively small amount of power per armor tick
 * @author 1n5aN1aC
 */
public class Module_Battery_T1 extends GenericModule {

	public Module_Battery_T1(String name) {
		super(name, 10000, false, true, false);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		super.addInformation(itemStack, player, dataList, bool);
		dataList.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + "Stores a Small Amount of Power");
	}

	//Energy Max Methods
	@Override
	public int maxEnergyPulled() {
		return 10;
	}

	@Override
	public int maxEnergyReleased() {
		return 10;
	}
}