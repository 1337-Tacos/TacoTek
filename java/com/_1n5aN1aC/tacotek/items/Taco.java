package com._1n5aN1aC.tacotek.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import com._1n5aN1aC.tacotek.common.tacotek;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Taco extends GenericFood {
	
	public Taco(String name) {
		super(name, 8, 0.4f, true);
		this.setPotionEffect(22, 240, 0, 1.0F);	//Absorption ,4 Minutes, 2 hearts, always
		this.maxStackSize = 16;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("Yummy Yummy Tacos!");
	}
}