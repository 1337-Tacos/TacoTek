package com._1n5aN1aC.tacotek.blocks;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiTiny extends GuiContainer {

	public GuiTiny (InventoryPlayer inventoryPlayer,
			TacoBoxTileEntity tileEntity) {
		//the container is instantiated and passed to the superclass for handling
		super(new ContainerTiny(inventoryPlayer, tileEntity));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		//draw text and stuff here
		//the parameters for drawString are: string, x, y, color
		mc.fontRendererObj.drawString("Tiny", 8, 6, 4210752);
		//draws "Inventory" or your regional equivalent
		mc.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,
			int par3) {
		//draw your Gui here, only thing you need to change is the path
		ResourceLocation loc = new ResourceLocation("/gui/trap.png");
		//ITextureObject texture = mc.renderEngine.getTexture(loc);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(loc);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}