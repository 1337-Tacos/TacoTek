package assets.tacotek.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ic2.api.item.IElectricItem;

public class GenericElectric extends Item implements IElectricItem {

	public GenericElectric(int id) {
		super(id);
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getChargedItemId(ItemStack itemStack) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEmptyItemId(ItemStack itemStack) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxCharge(ItemStack itemStack) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack) {
		// TODO Auto-generated method stub
		return 0;
	}
}