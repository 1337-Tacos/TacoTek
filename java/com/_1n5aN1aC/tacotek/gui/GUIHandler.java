package com._1n5aN1aC.tacotek.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com._1n5aN1aC.tacotek.armor.ModularArmor_T1;
import com._1n5aN1aC.tacotek.armor.storage.ContainerModular;
import com._1n5aN1aC.tacotek.armor.storage.InventoryModular;
import com._1n5aN1aC.tacotek.common.ModInfo;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		//BlockPos pos = new BlockPos(x, y, z);
		//Creates a container
		//TileEntity ent = world.getTileEntity(pos);

		if (ID == ModInfo.GUI_MODULAR_ITEMT1) {
			if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ModularArmor_T1) {
				InventoryModular inv = new InventoryModular(player, player.getCurrentEquippedItem(), "Canvas Bag", false, 27);
				return new ContainerModular(inv, player.inventory, player.getCurrentEquippedItem());
			}
		} else if (ID == ModInfo.GUI_MODULAR_ITEMT2) {
			//
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		//BlockPos pos = new BlockPos(x, y, z);
		//TileEntity ent = world.getTileEntity(pos);
		
		if (ID == ModInfo.GUI_MODULAR_ITEMT1) {
			if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ModularArmor_T1) {
				InventoryModular inv = new InventoryModular(player, player.getCurrentEquippedItem(), "Canvas Bag", false, 27);
				return new GuiModular_T1(player.getCurrentEquippedItem(), player.inventory, inv);
			}
		} else if (ID == ModInfo.GUI_MODULAR_ITEMT2) {
			//
		}
		return null;
	}
}