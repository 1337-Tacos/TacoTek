package com._1n5aN1aC.tacotek.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com._1n5aN1aC.tacotek.armor.ModularArmor;
import com._1n5aN1aC.tacotek.armor.gui.ModularInventory;

public class GuiHandler implements IGuiHandler {

	public static final byte MODULAR_ARMOR_WEARING = 1;
	public static final byte MODULAR_ARMOR_HOLDING = 2;

	//returns an instance of the Container you made earlier
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		ModularInventory inv;
		BlockPos pos = new BlockPos(x, y, z);

		switch(id) {
			case MODULAR_ARMOR_WEARING:
				ItemStack stack = player.getCurrentArmor(1);
				if (stack.getItem() instanceof ModularArmor) {
					inv = new ModularInventory(stack, ((ModularArmor)stack.getItem()).getSize() );
					if (inv.getContainerStack() != null) {
						//
					}
				}
				break;
			case MODULAR_ARMOR_HOLDING:
				return pos;
		}

		return null;
	}

	//returns an instance of the Gui you made earlier
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
}