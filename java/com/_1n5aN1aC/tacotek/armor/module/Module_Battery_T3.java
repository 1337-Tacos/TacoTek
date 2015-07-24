package com._1n5aN1aC.tacotek.armor.module;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * A (Tier III) Battery Module
 * @author Killaa
 */

public class Module_Battery_T3 extends GenericModule {

	public Module_Battery_T3(String name) {
		super(name, 100000, false, true, false);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		super.addInformation(itemStack, player, dataList, bool);
		dataList.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + "Stores a LOT of Power");
	}

	//Energy Methodsw

	@Override
	public int maxEnergyPulled() {
		return 15;
	}

	@Override
	public int maxEnergyReleased() {
		return 15;
	}
}
	

