package com._1n5aN1aC.tacotek.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com._1n5aN1aC.tacotek.armor.ModularArmor;
import com._1n5aN1aC.tacotek.armor.ModularInventory;
import com._1n5aN1aC.tacotek.blocks.GuiTiny;
import com._1n5aN1aC.tacotek.blocks.TacoBoxTileEntity;

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
						return 
					}
				}
				break;
			case MODULAR_ARMOR_HOLDING:
				return pos;
				break;
		}

		return null;
	}

	//returns an instance of the Gui you made earlier
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(pos);
		if(tileEntity instanceof TacoBoxTileEntity){
			return new GuiTiny(player.inventory, (TacoBoxTileEntity) tileEntity);
		}
		return null;

	}
}