package com._1n5aN1aC.tacotek.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Handles Proxying initialization events to the server, when ran on the serverside
 * @author 1n5aN1aC
 */
public class ServerProxy extends CommonProxy {
	
	@Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }
	
    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }
    
    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
}