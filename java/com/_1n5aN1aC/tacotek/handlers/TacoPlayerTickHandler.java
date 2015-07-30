package com._1n5aN1aC.tacotek.handlers;

import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class TacoPlayerTickHandler {
	
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=false)
    public void onEvent(PlayerTickEvent event) {
    	if (event.phase == Phase.END) {
    		//System.out.println(event.player);
    	}
    }
}