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
	ItemStack itemStack;

	public GuiModular_T1(ItemStack stack, InventoryPlayer playerInventory, IInventory canvasBagInventory) {
		super(new ContainerModular(canvasBagInventory, playerInventory, stack), resLoc);
		this.itemStack = stack;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		this.fontRendererObj.drawString(itemStack.hasDisplayName() ? itemStack.getDisplayName() : I18n.format("gui.ModularArmor_T1.name", new Object[] {}), 8, 6, 4210752);
	}
}