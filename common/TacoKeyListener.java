package assets.tacotek.common;

import net.minecraft.entity.player.EntityPlayer;
import ic2.api.util.IKeyboard;

public class TacoKeyListener implements IKeyboard {

	@Override
	public boolean isAltKeyDown(EntityPlayer player) {
		return false;
	}

	@Override
	public boolean isBoostKeyDown(EntityPlayer player) {
		return false;
	}

	@Override
	public boolean isForwardKeyDown(EntityPlayer player) {
		return false;
	}

	@Override
	public boolean isJumpKeyDown(EntityPlayer player) {
		return false;
	}

	@Override
	public boolean isModeSwitchKeyDown(EntityPlayer player) {
		return false;
	}

	@Override
	public boolean isSideinventoryKeyDown(EntityPlayer player) {
		return false;
	}

	@Override
	public boolean isHudModeKeyDown(EntityPlayer player) {
		return false;
	}

	@Override
	public boolean isSneakKeyDown(EntityPlayer player) {
		return false;
	}

}
