package com._1n5aN1aC.tacotek.common;

public class SideHelper {

	//Adjusts the coordinate to place a block based on which side is clicked.
	public static int[] sideAdjust(int x, int y, int z, int side) {

		//Adjusted[0] = x
		//Adjusted[1] = y
		//Adjusted[2] = z
		int[] Adjusted=new int[3];

		int xm = 0;
		int ym = 0;
		int zm = 0;

		if (side == 0) {		//0 = bottom
			ym = -1;
		} else if(side == 1) {	//1 = top
			ym = 1;
		} else if (side == 2) {	//2 = North
			zm = -1;
		} else if (side == 3) {	//3 - South
			zm = 1;
		} else if (side == 4) {	//4 = West
			xm = -1;
		} else if (side == 5) {	//5 = East
			xm = 1;
		}

		Adjusted[0] = x + xm;
		Adjusted[1] = y + ym;
		Adjusted[2] = z + zm;

		//Returns array of adjusted x, y, and z values.
		return Adjusted;
	}
}
