package com._1n5aN1aC.tacotek.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com._1n5aN1aC.tacotek.common.RenderRegistrationHelper;

/**
 * @author 1n5aN1aC
 * Handles Proxying initialization events to the client, when ran on the clientside
 */
public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}
	
	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		
		RenderRegistrationHelper.registerItemRenderer();
		RenderRegistrationHelper.registerBlockRenderer();
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
}