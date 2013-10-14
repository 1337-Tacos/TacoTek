package assets.tacotek.Items;

import net.minecraft.item.ItemSeeds;
import assets.tacotek.common.tacotek;

public class GenericPlantable extends ItemSeeds {

	public GenericPlantable(int id, int plantID, int soilID, String name) {
		super(id, plantID, soilID);
		this.setCreativeTab(tacotek.tacotekTab);
		this.setUnlocalizedName(name);
	}
}