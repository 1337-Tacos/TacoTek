package assets.tacotek.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ic2.api.item.ElectricItem;
import ic2.api.item.IElectricItem;

public class GenericElectric extends Item implements IElectricItem {
	
	private boolean canGiveEnergy = false;
	private int maxCharge = 1337;
	private int tier = 1;
	private int transferLimit;

	public GenericElectric(int id) {
		super(id);
		this.canRepair = false;
	}
	
	public GenericElectric(int id, int max, int teir, int transferMax) {
		super(id);
		this.maxCharge = max;
		this.tier = teir;
		this.transferLimit = transferMax;
	}

	/**
	 * @param stack the itemStack which is being used.
	 * @param i the amount of power which is to be used.
	 * @return returns true if the item has enough power, as specified.
	 */
	protected boolean canTakeDamage(ItemStack stack, int i) {
        return ElectricItem.manager.discharge(stack, i, 0x7fffffff, true, true) == i;
    }
	
	/**
	 * @param stack the itemStack which was used.
	 * @param i the amount of power to use.
	 * @param player the player which is using the item.
	 */
	protected void damage(ItemStack stack, int i, EntityPlayer player) {
        ElectricItem.manager.use(stack, i, player);
    }
	
	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		return this.canGiveEnergy;
	}

	@Override
	public int getChargedItemId(ItemStack itemStack) {
		return this.itemID;
	}

	@Override
	public int getEmptyItemId(ItemStack itemStack) {
		return this.itemID;
	}

	@Override
	public int getMaxCharge(ItemStack itemStack) {
		return this.maxCharge;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		return this.tier;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return this.transferLimit;
	}
}