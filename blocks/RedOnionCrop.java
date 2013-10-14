package assets.tacotek.blocks;

import java.util.Random;

import assets.tacotek.Items.ItemsHelper;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class RedOnionCrop extends Block {

	public RedOnionCrop (int id) {
		super(id, Material.plants);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
		setTickRandomly(true);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool (World world, int x, int y, int z) {
		return null;
	}

	public int getRenderType () {
		return 6;
	}

	public boolean isOpaqueCube () {
		return false;
	}

	public int getBlockTextureFromSideAndMetadata (int side, int metadata) {
		return 32 + metadata;
	}

	public void updateTick (World world, int x, int y, int z, Random random) {
		if (world.getBlockMetadata(x, y, z) == 1) {
			return;
		}

		if (random.nextInt(isFertile(world, x, y - 1, z) ? 12 : 25) != 0) {
			return;
		}

		world.setBlockMetadataWithNotify(x, y, z, 1, z);
	}

	public void onNeighborBlockChange (World world, int x, int y, int z, int neighborId) {
		if (!canBlockStay(world, x, y, z)) {
			dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlock(x, y, z, 0);
			world.notifyBlockOfNeighborChange(x, y, z, 0);
		}
	}

	public boolean canBlockStay (World world, int x, int y, int z) {
		Block soil = blocksList[world.getBlockId(x, y - 1, z)];
		return (world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) 
				&& (soil != null && soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, ItemsHelper.redOnion));
	}

	public int idDropped (int metadata, Random random, int par2) {
		switch (metadata) {
		case 0:
			//seeds
			return ItemsHelper.redOnion.itemID;
		case 1:
			//fruit
			return ItemsHelper.redOnion.itemID;
		default:
			// Error case!
			return -1; // air
		}
	}

	public int idPicked (World world, int x, int y, int z) {
		//seeds
		return ItemsHelper.redOnion.itemID;
	}
}