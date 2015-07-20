package com._1n5aN1aC.tacotek.armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

import org.lwjgl.input.Keyboard;

import com._1n5aN1aC.tacotek.armor.gui.ModularContainer;
import com._1n5aN1aC.tacotek.common.ModInfo;
import com._1n5aN1aC.tacotek.common.tacotek;
import com._1n5aN1aC.tacotek.network.GUIPacket;
import com._1n5aN1aC.tacotek.network.ModNetwork;

public abstract class ModularArmor extends GenericArmor {

	/** The number of Inventory Slots in this armor */
	public static int invSize;

	/**
	 * Creates a new type of Modular Armor
	 * @param name the uniqueid of the ModularArmor
	 * @param material the armorMaterial type which this armor is made out of
	 * @param renderIndex 2 for leggings, 1 for others.
	 * @param armorType Stores the armor type: 0 is helmet, 1 is plate, 2 is legs and 3 is boots
	 */
	public ModularArmor(String name, ArmorMaterial material, int renderIndex, int armorType) {
		super(name, material, renderIndex, armorType);
	}

	/** @return the number of inventory slots this Tier of ModularArmor has. */
	public int getSize() {
		return this.invSize;
	}

	/**
	 * Called by the server every tick while this item is in the player's inventory.
	 * This is used to implement the entire advanced armor system.
	 */
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		//We only operate on a Modular Chestplate itself
		if (itemStack.getItem() instanceof ModularArmor && ((ModularArmor)itemStack.getItem()).armorType == 1) {
			//We require the player to be wearing full Modular Armor before we do much of anything.
			//TODO: Allow partial use of modular armor with reduced functionality, depending on pieces worn
			if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() instanceof ModularArmor
					&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() instanceof ModularArmor
					&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() instanceof ModularArmor
					&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() instanceof ModularArmor) {
				this.effectPlayer(player, Potion.regeneration, 1, 139);
				//TODO:  Check if each refresh of potion generates additional packets, and if so, how much overhead this amounts to
				this.effectPlayer(player, Potion.nightVision, 0, 239);
			}

			NBTUpdate(itemStack, world, player);
		}
	}

	/**
	 * Applies a specified potion effect to the player for the specified number of seconds, then refreshing it.
	 * For nightvision, it is refreshed at <10 seconds, otherwise, <1 second
	 * @param player the player object to apply the potion to
	 * @param potion the potion effect to apply
	 * @param amplifier the strength to apply said potion at
	 * @param length how long (in ticks) to apply the effect for.
	 */
	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier, int length) {
		int refresh = 25;
		//If nightvision, then refresh at <10 seconds
		if (potion.id == Potion.nightVision.getId())
			refresh = 220;
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= refresh)
			player.addPotionEffect(new PotionEffect(potion.id, length, amplifier, true, false));
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack stack, EntityPlayer player) {
		if (stack != null && player instanceof EntityPlayerMP && player.openContainer instanceof ModularContainer) {
			player.closeScreen();
		}

		return super.onDroppedByPlayer(stack, player);
	}

	// Without this method, your inventory will NOT work!!!
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1; // return any value greater than zero
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if (world.isRemote) {
			ModNetwork.net.sendToServer( new GUIPacket.GUImessage(ModInfo.GUI_MODULAR_ITEM, GUIPacket.FROM_HOLDING));
		}
		return itemstack;
	}

	private void NBTUpdate(ItemStack itemstack, World world, Entity entity) {
		// Only Player's will be accessing the GUI
		if (!world.isRemote && entity instanceof EntityPlayer) {
			// Cast Entity parameter as an EntityPlayer
			EntityPlayer player = (EntityPlayer) entity;

			// Check if the player is not in a menu, if key 'I' is pressed and
			// the player is currently holding the correct type of item (an ItemInventory)
			if (FMLClientHandler.instance().getClient().inGameHasFocus && Keyboard.isKeyDown(Keyboard.KEY_I) &&
					player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ModularArmor) {
				// Open the correct GUI for the player at player's position
				player.openGui(tacotek.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
			}

			// If our ContainerItem is currently open, write contents to NBT when needsUpdate is true
			if(player.openContainer != null && player.openContainer instanceof ModularContainer
					&& ((ModularContainer) player.openContainer).needsUpdate) {
				((ModularContainer) player.openContainer).writeToNBT();
				// Set needsUpdate back to false so we don't continually write to NBT
				((ModularContainer) player.openContainer).needsUpdate = false;
			}
		}
	}
}