package com._1n5aN1aC.tacotek.armor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com._1n5aN1aC.tacotek.common.tacotek;

public class ModularGuiHandler implements IGuiHandler {
	//returns an instance of the Container you made earlier
	@Override
	public Object getServerGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z) {
		// Hooray, no 'magic' numbers - we know exactly which Gui this refers to
		if (guiId == tacotek.GUI_MODULAR_ITEM)
		{
			// Use the player's held item to create the inventory
			return new ModularContainer(player, player.inventory, new ModularInventory(player.getHeldItem(), ((ModularArmor)player.getHeldItem().getItem()).getSize()));
		}
		return null;
	}

	//returns an instance of the Gui you made earlier
	@Override
	public Object getClientGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z) {
		if (guiId == tacotek.GUI_MODULAR_ITEM)
		{
			// We have to cast the new container as our custom class
			// and pass in currently held item for the inventory
			return new ModularGui((ModularContainer) new ModularContainer(player, player.inventory, new ModularInventory(player.getHeldItem(), ((ModularArmor)player.getHeldItem().getItem()).getSize())));
		}
		return null;
	}
}