package com._1n5aN1aC.tacotek.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.apache.commons.lang3.text.WordUtils;
import org.lwjgl.opengl.GL11;

public class GuiBase extends GuiContainer {

	private static final int COLOR_TEXT		= 4210752;
	private final ResourceLocation resLoc;

	public GuiBase(Container container, ResourceLocation resLoc) {
		super(container);
		this.resLoc = resLoc;
	}

	@Override
	public void setWorldAndResolution(Minecraft mc, int par2, int par3) {
		super.setWorldAndResolution(mc, par2, par3);
	}

	public static void drawVerticalProgressBar(int xOffset, int yOffset, int h, int w, float value, float max, int color) {
		float perc = value / max;
		int height = (int) (h * perc);
		drawRect(xOffset, yOffset + h - height, xOffset + w, yOffset + h, color);
	}

	public void drawHorizontalAlignedString(int xOffset, int yOffset, int w, String text, boolean useShadow) {
		int stringWidth = fontRendererObj.getStringWidth(text);
		int newX = xOffset;
		if (stringWidth < w) {
			newX = w / 2 - stringWidth / 2 + xOffset;
		}
		fontRendererObj.drawString(text, newX, yOffset, COLOR_TEXT, useShadow);
	}

	public void drawString(int xOffset, int yOffset, String text, boolean useShadow) {
		fontRendererObj.drawString(text, xOffset, yOffset, COLOR_TEXT, useShadow);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 94 + 2, COLOR_TEXT);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(resLoc);

		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

	@Override
	public void drawScreen(int x, int y, float partialTick) {
		super.drawScreen(x, y, partialTick);
		List<String> tooltip = new ArrayList<String>();
		if (!tooltip.isEmpty()) {
			List<String> localizedTooltip = new ArrayList<String>();
			for (String line : tooltip) {
				String localizedLine = I18n.format(line);
				String[] lines = WordUtils.wrap(localizedLine, 50).split(System.getProperty("line.separator"));
				for (String locLine : lines) {
					localizedTooltip.add(locLine);
				}
			}
			drawHoveringText(localizedTooltip, x, y, fontRendererObj);
		}
	}

	public void redraw() {
		buttonList.clear();
		initGui();
	}
}