package com._1n5aN1aC.tacotek.armor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com._1n5aN1aC.tacotek.common.ModInfo;
import com._1n5aN1aC.tacotek.common.tacotek;

public abstract class ModularArmorMain extends GenericArmor {

	/** The number of Inventory Slots in this armor */
	public static int invSize;

	/**
	 * Creates a new type of Modular Armor
	 * @param name the uniqueid of the ModularArmorMain
	 * @param material the armorMaterial type which this armor is made out of
	 * @param renderIndex 2 for leggings, 1 for others.
	 * @param armorType Stores the armor type: 0 is helmet, 1 is plate, 2 is legs and 3 is boots
	 */
	public ModularArmorMain(String name, ArmorMaterial material, int renderIndex, int armorType) {
		super(name, material, renderIndex, armorType);
		//An option to allow coloring of armor or somesuch:
		//this.setHasSubtypes(true);
	}

	/** @return the number of inventory slots this Tier of ModularArmorMain has. */
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
		if (itemStack.getItem() instanceof ModularArmorMain) {
			//TODO: Allow partial use of modular armor with reduced functionality, depending on pieces worn
			//We require the player to be wearing full Modular Armor before we do much of anything.
			if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() instanceof ModularArmorSimple
					&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() instanceof ModularArmorMain
					&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() instanceof ModularArmorSimple
					&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() instanceof ModularArmorSimple) {
				this.effectPlayer(player, Potion.regeneration, 1, 139);
				//TODO:  Check if each refresh of potion generates additional packets, and if so, how much overhead this amounts to
				this.effectPlayer(player, Potion.nightVision, 0, 239);
			}

			//This is where we tick the modules.
			tickModules();
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

	// Without this method, your inventory will NOT work!!!
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 1; // return any value greater than zero
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if (!world.isRemote && !player.isSneaking()) {
			openGui(player, itemstack);
		}
		return itemstack;
	}

	protected void openGui(EntityPlayer entityplayer, ItemStack stack) {
		if (stack != null && stack.getItem() != null && stack.getItem() instanceof ModularArmorMain) {
			ModularArmorMain armor = (ModularArmorMain)stack.getItem();
			BlockPos pos = entityplayer.getPosition();
			
			if (armor.getSize() == ModInfo.T1Modular_Size) {
				entityplayer.openGui(tacotek.instance, ModInfo.GUI_MODULAR_ITEMT1, entityplayer.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ());
			}
			else if (armor.getSize() == ModInfo.T2Modular_Size) {
				entityplayer.openGui(tacotek.instance, ModInfo.GUI_MODULAR_ITEMT2, entityplayer.getEntityWorld(), pos.getX(), pos.getY(), pos.getZ());
			}
		}
	}

	private void tickModules() {
		
	}
}