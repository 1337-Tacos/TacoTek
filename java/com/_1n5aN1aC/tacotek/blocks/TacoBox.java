package com._1n5aN1aC.tacotek.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com._1n5aN1aC.tacotek.common.tacotek;
import com._1n5aN1aC.tacotek.items.IRenderable;
import com._1n5aN1aC.tacotek.items.ItemsHelper;

public class TacoBox extends Block implements IRenderable {

	private static String name;

	/**
	 * Creates a tacobox
	 * @param name the uniqueid of this tacobox
	 */
	public TacoBox(String name) {
		super(Material.wood);
		this.name = name;

		this.setHardness(1.0f);
		this.setResistance(5.0f);
		this.setCreativeTab(tacotek.tacotekTab);
		this.setStepSound(Block.soundTypeWood);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("Store a Lot of Tacos");
		dataList.add("All in one Block.");
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

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Item getItem() {
		return Item.getItemFromBlock(this);
	}
}