package com._1n5aN1aC.tacotek.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GenericItemDescription extends GenericItem {

	String description = "No description.";

	public GenericItemDescription(String name, String desc) {
		super(name);
		this.description = desc;
	}

	public GenericItemDescription(String name, String desc, int stackLimit) {
		super(name, stackLimit);
		this.description = desc;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add(description);
	}
}