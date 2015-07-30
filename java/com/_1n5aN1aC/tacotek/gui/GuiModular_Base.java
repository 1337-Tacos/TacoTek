package com._1n5aN1aC.tacotek.gui;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com._1n5aN1aC.tacotek.armor.storage.ContainerModular;

public abstract class GuiModular_Base extends GuiBase {
	ItemStack itemStack;

	public GuiModular_Base(ItemStack stack, InventoryPlayer inventory, IInventory itemInventory, int size, ResourceLocation resLoc) {
		super(new ContainerModular(itemInventory, inventory, stack, size), resLoc);
		this.itemStack = stack;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRendererObj.drawString(itemStack.hasDisplayName() ? itemStack.getDisplayName() : I18n.format("gui.ModularArmor.name", new Object[] {}), 50, 12, 4210752);
		this.fontRendererObj.drawString(itemStack.hasDisplayName() ? itemStack.getDisplayName() : I18n.format("gui.ModularArmor.slots.name", new Object[] {}), 62, 55, 4210752);
	}
}