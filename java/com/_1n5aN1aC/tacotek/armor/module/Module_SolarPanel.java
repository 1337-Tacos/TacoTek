package com._1n5aN1aC.tacotek.armor.module;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * A (Tier I) Solar Panel Module.
 * This generates a small amount of power every armor tick, and provides it to other modules.
 * @author 1n5aN1aC
 */
public class Module_SolarPanel extends GenericModule {

	public Module_SolarPanel(String name) {
		super(name, 500, true, false, false);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		super.addInformation(itemStack, player, dataList, bool);
		dataList.add(EnumChatFormatting.YELLOW + "" + EnumChatFormatting.ITALIC + "Generates Small Amounts of Power");
	}

	@Override
	public int maxEnergyReleased() {
		return 10;
	}

	@Override
	public void onArmorTick(EntityPlayer player) {
		//TODO if (isInSunlight()) {
			addEnergy(player.getItemInUse(), 10);
		//}
	}
}