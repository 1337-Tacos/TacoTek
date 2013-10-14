package assets.tacotek.Items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import assets.tacotek.common.tacotek;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GenericPlantable extends GenericItem implements IPlantable {

	public EnumPlantType plantType;
	
	//Constructor:id.
	public GenericPlantable(int id, String name, EnumPlantType newPlantType) {
		super(id, name);
		this.plantType = newPlantType;
	}

	@Override
	public EnumPlantType getPlantType(World world, int x, int y, int z) {
		return this.plantType;
	}

	@Override
	public int getPlantID(World world, int x, int y, int z) {
		// TODO Not sure this is correct.
		return this.itemID;
	}

	@Override
	public int getPlantMetadata(World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}
}