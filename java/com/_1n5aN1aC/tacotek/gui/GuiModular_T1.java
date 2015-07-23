package com._1n5aN1aC.tacotek.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com._1n5aN1aC.tacotek.armor.storage.ContainerModular;
import com._1n5aN1aC.tacotek.common.ModInfo;

public class GuiModular_T1 extends GuiBase {
	private static final ResourceLocation resLoc = new ResourceLocation(ModInfo.MOD_ID, "textures/gui/canvas_bag.png");
	ItemStack bag;

	public GuiModular_T1(ItemStack bag, InventoryPlayer playerInventory, IInventory canvasBagInventory) {
		super(new ContainerModular(canvasBagInventory, playerInventory, bag), resLoc);
		this.bag = bag;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		this.fontRendererObj.drawString(bag.hasDisplayName() ? bag.getDisplayName() : I18n.format("item.canvas_bag.name", new Object[] {}), 8, 6, 4210752);
	}
}