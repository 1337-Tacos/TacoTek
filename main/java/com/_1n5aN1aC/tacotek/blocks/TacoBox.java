package com._1n5aN1aC.tacotek.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com._1n5aN1aC.tacotek.items.ItemsHelper;
import com._1n5aN1aC.tacotek.common.tacotek;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TacoBox extends GenericBlock {
	//Constructor
	public TacoBox(String name) {
		super(name, Material.wood, 1.0f, 5.0f);
		
		this.setStepSound(Block.soundTypeWood);
	}
	
	public int quantityDropped(Random rand) {
		return 9;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("Store a Lot of Tacos");
		dataList.add("All in one Block.");
	}
}