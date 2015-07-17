package com._1n5aN1aC.tacotek.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com._1n5aN1aC.tacotek.common.tacotek;
import com._1n5aN1aC.tacotek.items.IRenderable;
import com._1n5aN1aC.tacotek.items.ItemsHelper;

public class TacoBox extends BlockContainer implements IRenderable {
	
	private static String name;
	
	//Constructor
	/**
	 * Creates a tacobox
	 * @param name the uniqueid of this tacobox
	 */
	public TacoBox(String name) {
		super(Material.wood);
		this.name = name;
		
		this.setHardness(1.0f);
		this.setResistance(5.0f);
		this.setCreativeTab(tacotek.tacotekTab);
		this.setStepSound(Block.soundTypeWood);
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add("Store a Lot of Tacos");
		dataList.add("All in one Block.");
	}
	
	@Override
	public Item getItemDropped(IBlockState blockstate, Random random, int fortune) {
	    return ItemsHelper.taco;
	}

	@Override
	public int damageDropped(IBlockState blockstate) {
	    return 0;
	}

	@Override
	public int quantityDropped(IBlockState blockstate, int fortune, Random random) {
	    return 8 + random.nextInt(2);
	}
	
	
	
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntity tileEntity = world.getTileEntity(pos);
		System.out.println("lol");
		if (tileEntity == null || player.isSneaking()) {
			System.out.println("lol2");
			return false;
		}
		
		//code to open gui explained later
		player.openGui(tacotek.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
		return true;
    }
	
	@Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
            dropItems(world, pos);
            super.breakBlock(world, pos, state);
    }

    private void dropItems(World world, BlockPos pos){
            Random rand = new Random();

            TileEntity tileEntity = world.getTileEntity(pos);
            if (!(tileEntity instanceof IInventory)) {
                    return;
            }
            IInventory inventory = (IInventory) tileEntity;

            for (int i = 0; i < inventory.getSizeInventory(); i++) {
                    ItemStack item = inventory.getStackInSlot(i);

                    if (item != null && item.stackSize > 0) {
                            float rx = rand.nextFloat() * 0.8F + 0.1F;
                            float ry = rand.nextFloat() * 0.8F + 0.1F;
                            float rz = rand.nextFloat() * 0.8F + 0.1F;
                            
                            EntityItem entityItem = new EntityItem(world, pos.getX() + rx, pos.getY() + ry, pos.getZ() + rz, 
                            		new ItemStack(item.getItem(), item.stackSize, item.getMetadata()));

                            if (item.hasTagCompound()) {
                            	entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                            }

                            float factor = 0.05F;
                            entityItem.motionX = rand.nextGaussian() * factor;
                            entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                            entityItem.motionZ = rand.nextGaussian() * factor;
                            world.spawnEntityInWorld(entityItem);
                            item.stackSize = 0;
                    }
            }
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
    	return new TacoBoxTileEntity();
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TacoBoxTileEntity();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Item getItem() {
		return Item.getItemFromBlock(this);
	}
}