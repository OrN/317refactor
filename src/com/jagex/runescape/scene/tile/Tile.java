package com.jagex.runescape.scene.tile;

import com.jagex.runescape.InteractiveObject;
import com.jagex.runescape.collection.Linkable;
import com.jagex.runescape.scene.object.*;

public final class Tile extends Linkable {

	public int z;

	public int x;
	public int y;
	public final int anInt1310;
	public PlainTile plainTile;
	public ShapedTile shapedTile;
	public Wall wall;
	public WallDecoration wallDecoration;
	public GroundDecoration groundDecoration;
	public GroundItemTile groundItemTile;
	public int entityCount;
	public InteractiveObject[] interactiveObjects;
	public int[] interactiveObjectsSize;
	public int interactiveObjectsSizeOR;
	public int logicHeight;
	public boolean aBoolean1322;
	public boolean aBoolean1323;
	public boolean aBoolean1324;
	public int anInt1325;
	public int anInt1326;
	public int anInt1327;
	public int anInt1328;
	public Tile tileBelow;

	public Tile(final int z, final int x, final int y) {
        this.interactiveObjects = new InteractiveObject[5];
        this.interactiveObjectsSize = new int[5];
        this.anInt1310 = this.z = z;
        this.x = x;
        this.y = y;
	}
}
