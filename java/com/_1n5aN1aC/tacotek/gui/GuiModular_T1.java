package com._1n5aN1aC.tacotek.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com._1n5aN1aC.tacotek.common.ModInfo;

public class GuiModular_T1 extends GuiModular_Base {
	private static final ResourceLocation resLoc = new ResourceLocation(ModInfo.MOD_ID, "textures/gui/Gui_Modular_T1.png");

	public GuiModular_T1(ItemStack stack, InventoryPlayer inventory, IInventory itemInventory) {
		super(stack, inventory, itemInventory, resLoc);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		this.fontRendererObj.drawString(itemStack.hasDisplayName() ? itemStack.getDisplayName() : I18n.format("gui.ModularArmor_MkI.name", new Object[] {}), 55, 25, 4210752);
		this.fontRendererObj.drawString(itemStack.hasDisplayName() ? itemStack.getDisplayName() : I18n.format("6 ", new Object[] {}), 52, 55, 4210752);
	}
}