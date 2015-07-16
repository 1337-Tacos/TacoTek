package com._1n5aN1aC.tacotek.blocks;

import com._1n5aN1aC.tacotek.common.tacotek;
import com._1n5aN1aC.tacotek.items.IRenderable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class GenericBlock extends Block implements IRenderable {
	
	private final String name;
	
	/**
	 * @param name the unique item name of the item
	 * @param prettyName the pretty (English) name of the item
	 * @param material
	 * @param hardness
	 * @param resistance
	 */
	public GenericBlock(String name, Material material, float hardness, float resistance) {
		super(material);
		this.name = name;
		
		this.setUnlocalizedName(tacotek.MODID + "_" + name);
		this.setCreativeTab(tacotek.tacotekTab);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}
	
	/**
	 * @param name
	 * @param prettyName
	 * @param material
	 * @param hardness
	 * @param resistance
	 * @param harvester tool: "pickaxe", "axe", "shovel" 
	 * @param breakLevel level: 0=wood; 1=stone; 2=iron; 3=diamond tool 
	 */
	public GenericBlock(String name, Material material, float hardness, float resistance, String harvester, int breakLevel) {
		this(name, material, hardness, resistance);
		this.setHarvestLevel(harvester, breakLevel);
	}
	
	/**
	 * Provides a default for hardness and material in case you just want a real quick block.
	 * @param name
	 * @param prettyName
	 */
	public GenericBlock(String name) {
		this(name, Material.rock, 2.0f, 10.0f);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	/**
	 * @return the itemName of the item
	 */
	public String getName() {
		return name;
	}

	@Override
	public Item getItem() {
		return Item.getItemFromBlock(this);
	}
}