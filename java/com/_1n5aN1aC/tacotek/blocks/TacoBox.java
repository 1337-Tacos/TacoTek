package com._1n5aN1aC.tacotek.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import com._1n5aN1aC.tacotek.items.ItemsHelper;

public class TacoBox extends GenericBlock {

	/**
	 * Creates a tacobox
	 * @param name the uniqueid of this tacobox
	 */
	public TacoBox(String name) {
		super(name, Material.wood, 1.0f, 5.0f);

		this.setStepSound(Block.soundTypeWood);
	}

	@Override
	public Item getItemDropped(IBlockState blockstate, Random random, int fortune) {
		return ItemsHelper.taco;
	}

	@Override
	public int damageDropped(IBlockState blockstate) {
		return 0;
	}

	@Override
	public int quantityDropped(IBlockState blockstate, int fortune, Random random) {
		return 8 + random.nextInt(2);
	}
}