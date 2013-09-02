package assets.tacotek.common;

import java.io.File;
import assets.tacotek.Items.Items;
import assets.tacotek.Items.ItemsHelper;
import assets.tacotek.blocks.TacoBox;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
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
	
	public static CreativeTabs tacotekTab = new CreativeTabs("tabTacoTek") { public ItemStack getIconItemStack() {return new ItemStack(Items.Taco);} };
	
	
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
		GameRegistry.addSmelting(Items.Dough.itemID, new ItemStack(Item.bread, 1), 0.5F);
		GameRegistry.addSmelting(Items.UncookedTortilla.itemID, new ItemStack(Items.Tortilla, 1), 1.0F);
	}
	
	private static void craftingRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(Items.Flour, 1),
			Item.wheat );
		GameRegistry.addShapelessRecipe(new ItemStack(Items.Dough, 1), 
			Items.Flour, Item.bucketWater );
		GameRegistry.addShapelessRecipe(new ItemStack(Items.Salt, 1), 
			Item.bucketWater, Item.bucketWater, Item.bucketWater, Item.bucketWater );
		GameRegistry.addShapelessRecipe(new ItemStack(Items.UncookedTortilla, 1), 
			Items.Dough );
		GameRegistry.addShapelessRecipe(new ItemStack(Items.Cheese, 1), 
			Item.bucketMilk, Item.bucketMilk, Items.Salt );
		GameRegistry.addShapelessRecipe(new ItemStack(Items.Taco, 9), 
			tacoBox );
		GameRegistry.addRecipe(new ItemStack(Items.Taco, 1), new Object[]{ "C", "B", "T",
			'C', Items.Cheese, 'B', Item.beefCooked, 'T', Items.Tortilla, });
		GameRegistry.addRecipe(new ItemStack(tacotek.tacoBox, 1), new Object[]{ "TTT", "TTT", "TTT",
			'T', Items.Taco, });
	}
}