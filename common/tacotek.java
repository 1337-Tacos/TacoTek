package assets.tacotek.common;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import assets.tacotek.Items.ItemsHelper;
import assets.tacotek.blocks.BlocksHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
		modid = tacotek.modID,
		name = "TacoTek",
		version = "0.2.3"
		//dependencies = 	"required-after:BuildCraft|Core;" +
		//					"after:IC2;" +
		//					"after:ComputerCraft;"
	)
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class tacotek {

	public static final String modID = "tacotek";
	
	//GUIHANDLER
	
	public static CreativeTabs tacotekTab = new CreativeTabs("tabTacoTek") { public ItemStack getIconItemStack() {return new ItemStack(ItemsHelper.taco);} };
	
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		Configuration config = new Configuration(new File("config/TacoTek.cfg") );
		config.load();
		IDsHelper.runConfiguration(config);
		config.save();
		
		//Load Creative Tab
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabTacoTek", "TacoTek");
		
		//TextureAnimationConverter.convertTxtToPngMCMeta();
		BlocksHelper.setupBlocks();
		ItemsHelper.setupItems();
		
		craftingRecipes();
        smeltingRecipes();
        
        //GameRegistry.registerWorldGenerator(new WorldGenOres());
        
        //NetworkRegistry.instance().registerGuiHandler(instance, guihandler);
	}
	
	private static void smeltingRecipes() {
		GameRegistry.addSmelting(ItemsHelper.dough.itemID, new ItemStack(Item.bread, 1), 0.5F);
		GameRegistry.addSmelting(ItemsHelper.uncookedTortilla.itemID, new ItemStack(ItemsHelper.tortilla, 1), 1.0F);
	}
	
	private static void craftingRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsHelper.flour, 1),
			Item.wheat );
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsHelper.dough, 1),
			ItemsHelper.flour, Item.bucketWater );
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsHelper.salt, 1),
			Item.bucketWater, Item.bucketWater, Item.bucketWater, Item.bucketWater );
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsHelper.uncookedTortilla, 1),
			ItemsHelper.dough );
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsHelper.cheese, 1),
			Item.bucketMilk, Item.bucketMilk, ItemsHelper.salt );
		GameRegistry.addShapelessRecipe(new ItemStack(ItemsHelper.taco, 9),
			BlocksHelper.tacoBox );
		GameRegistry.addRecipe(new ItemStack(ItemsHelper.taco, 1), new Object[]{ "C", "B", "T",
			'C', ItemsHelper.cheese, 'B', Item.beefCooked, 'T', ItemsHelper.tortilla, });
		GameRegistry.addRecipe(new ItemStack(BlocksHelper.tacoBox, 1), new Object[]{ "TTT", "TTT", "TTT",
			'T', ItemsHelper.taco, });
	}
}