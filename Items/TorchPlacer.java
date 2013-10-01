package assets.tacotek.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import assets.tacotek.common.PlayerInventoryHelper;
import assets.tacotek.common.SideHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TorchPlacer extends GenericItem {

	String shortDesc = "Contains 9001 Torches.";
	String description = "No description.";

	public TorchPlacer(int id, String name, String desc, int dmg, int stack) {
		super(id, name);
		this.description = desc;
		this.isDamageable();
		this.setMaxDamage(dmg);
		this.setMaxStackSize(stack);
	}

	//Forge calls this when the item is used.
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		boolean isServer = player instanceof EntityPlayerMP;

		if (player.isSneaking()) {
			int howManyTorches = PlayerInventoryHelper.loadBag(player, Block.torchWood.blockID, stack.getItemDamage());
			stack.setItemDamage(stack.getItemDamage() - howManyTorches);

			updateTooltip(stack);
			return true;
		}

		//Checks if damage value is maxed.
		if (stack.getItemDamage() >= stack.getMaxDamage()) {

			//Makes sure client side for player message.
			if (!isServer) {
				//Displays chat that dispenser is out of torches.
				player.addChatMessage("§8No torches left.");
			}
			//Tells forge item use was illegal.
			return false;
		}
		updateTooltip(stack);

		//Returns an array of coords that are adjusted for the side selected.
		int[] adjCoords=SideHelper.sideAdjust(x, y, z, side);

		//Converts the array elements back into x, y, and z.
		x = adjCoords[0];
		y = adjCoords[1];
		z = adjCoords[2];

		//Checks if player can edit block.
		if (player.canPlayerEdit(x, y, z, side, stack)) {

			//Checks if location is empty.
			if(world.getBlockId(x, y, z) == 0) {

				world.setBlock(x, y, z, Block.torchWood.blockID);
				world.notifyBlockOfNeighborChange(x, y, z, Block.torchWood.blockID);
				stack.setItemDamage(stack.getItemDamage() + 1);
				//Tells forge item use was legal.
				return true;
			}
		}
		return false;
	}

	protected void updateTooltip(ItemStack stack) {
		String torch = String.valueOf(this.getMaxDamage(stack) - stack.getItemDamage());
		description = shortDesc.replace("9001", torch);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool) {
		dataList.add(description);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int var1, CreativeTabs var2, List list) {
		ItemStack full = new ItemStack(this, 1);
		ItemStack empty = new ItemStack(this, 1, getMaxDamage());
		list.add(full);
		list.add(empty);
	}
}
