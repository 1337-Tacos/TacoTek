package com._1n5aN1aC.tacotek.common;

import com._1n5aN1aC.tacotek.blocks.ContainerTiny;
import com._1n5aN1aC.tacotek.blocks.GuiTiny;
import com._1n5aN1aC.tacotek.blocks.TacoBoxTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final byte MODULAR_ARMOR_WEARING = 1;
    public static final byte MODULAR_ARMOR_HOLDING = 2;

	//returns an instance of the Container you made earlier
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(pos);
		if(tileEntity instanceof TacoBoxTileEntity){
			return new ContainerTiny(player.inventory, (TacoBoxTileEntity) tileEntity);
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