package assets.tacotek.Items;

import ic2.api.item.ElectricItem;
import ic2.api.item.ICustomElectricItem;
import ic2.api.item.IElectricItemManager;
import ic2.api.item.ISpecialElectricItem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GT_Rockcutter_Item extends Item implements ICustomElectricItem {
	public int mCharge, mTransfer, mTier;

    public Set mineableBlocks = new HashSet();
    
	public GT_Rockcutter_Item(int aID) {
		super(aID);
		setCreativeTab(tacotek.tacotekTab);
		setMaxStackSize(1);
		setMaxDamage(100);
		setNoRepair();
		mCharge = 10000;
		mTransfer = 100;
		mTier = 1;
        
        mineableBlocks.add(Block.stone);
	}

	@Override
	public boolean onItemUse(ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ, int aSide, float var8, float var9, float var10) {
		ic2.api.item.ElectricItem.use(aStack, 0, aPlayer);
		return false;
	}
	
	@Override
    public void onCreated(ItemStack aStack, World aWorld, EntityPlayer aPlayer) {
    }

	@Override
    public boolean canHarvestBlock(Block var1) {
        return var1.blockMaterial != Material.rock && var1.blockMaterial != Material.iron ? mineableBlocks.contains(var1) : true;
    }

    public boolean hitEntity(ItemStack var1, EntityLiving var2, EntityLiving var3) {
        return true;
    }

	@Override
    public int getItemEnchantability() {
        return 0;
    }
	
	@Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack) {
        return false;
    }
	
    public int getDamageVsEntity(Entity var1) {
        return 1;
    }

	public boolean onBlockDestroyed(ItemStack var1, World var2, int var3, int var4, int var5, int var6, EntityPlayer var7) {
        ic2.api.item.ElectricItem.use(var1, 0, (EntityPlayer)var7);
		if ((double)Block.blocksList[var3].getBlockHardness(var2, var4, var5, var6) != 0.0D && ElectricItem.canUse(var1, 500)) {
            if (var7 instanceof EntityPlayer) {
                ic2.api.item.ElectricItem.use(var1, 500, (EntityPlayer)var7);
            } else {
                ic2.api.item.ElectricItem.discharge(var1, 500, mTier, true, false);
            }
        }
        return true;
    }

	@Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(int var1, CreativeTabs var2, List var3) {
        ItemStack tCharged = new ItemStack(this, 1), tUncharged = new ItemStack(this, 1, getMaxDamage());
        ic2.api.item.ElectricItem.charge(tCharged, Integer.MAX_VALUE, Integer.MAX_VALUE, true, false);
        var3.add(tCharged);
        var3.add(tUncharged);
    }

	@Override
    public boolean getShareTag() {
        return true;
    }
    
	public boolean canProvideEnergy() {
		return false;
	}
	
	public int getChargedItemId() {
		return itemID;
	}
	
	public int getEmptyItemId() {
		return itemID;
	}
	
	public int getMaxCharge() {
		return mCharge;
	}
	
	public int getTier() {
		return mTier;
	}
	
	public int getTransferLimit() {
		return mTransfer;
	}

	@Override
	public boolean canProvideEnergy(ItemStack itemStack) {
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
		return 200;
	}

	@Override
	public int getTier(ItemStack itemStack) {
		return 1;
	}

	@Override
	public int getTransferLimit(ItemStack itemStack) {
		return 100;
	}

	public int charge(ItemStack itemStack, int amount, int tier,
			boolean ignoreTransferLimit, boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int discharge(ItemStack itemStack, int amount, int tier,
			boolean ignoreTransferLimit, boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean canUse(ItemStack itemStack, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean canShowChargeToolTip(ItemStack itemStack) {
		// TODO Auto-generated method stub
		return false;
	}
}