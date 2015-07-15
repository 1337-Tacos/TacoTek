package com._1n5aN1aC.tacotek.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import com._1n5aN1aC.tacotek.common.tacotek;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Taco extends ItemFood {
	public Taco(int id, String name) {
		super(id, 8, true);
		this.setCreativeTab(tacotek.tacotekTab);
		this.setPotionEffect(22, 300, 0, 1.0F);
		this.setUnlocalizedName(name);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("Yummy Yummy Tacos!");
	}
}