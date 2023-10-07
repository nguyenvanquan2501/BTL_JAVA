package levels;

import entities.Bringer_Of_Death;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import entities.*;
import main.Game;
import static utilz.HelpMethods.GetBringer_Of_Death;
import static utilz.HelpMethods.GetLevelData;
import static utilz.HelpMethods.GetPlayerSpawn;

public class Level {

	private BufferedImage img;
	private int[][] lvlData;
	private ArrayList<Bringer_Of_Death> bringer_of_death;
	private int lvlTilesWide;
	private int maxTilesOffset;
	private int maxLvlOffsetX;
	private Point playerSpawn;

	public Level(BufferedImage img) {
		this.img = img;
		createLevelData();
		createEnemies();
		calcLvlOffsets();
		calcPlayerSpawn();
	}
      
      private void calcPlayerSpawn() {
		playerSpawn = GetPlayerSpawn(img);
	}
      private void calcLvlOffsets() {
		lvlTilesWide = img.getWidth();
		maxTilesOffset = lvlTilesWide - Game.TILES_IN_WIDTH;
		maxLvlOffsetX = Game.TILES_SIZE * maxTilesOffset;
	}
      
      private void createEnemies() {
		bringer_of_death = GetBringer_Of_Death(img);
	}
      
      public int getSpriteIndex(int x, int y) {
		return lvlData[y][x];
	}

	public int[][] getLevelData() {
		return lvlData;
	}

	public int getLvlOffset() {
		return maxLvlOffsetX;
	}
      
      private void createLevelData() {
		lvlData = GetLevelData(img);
	}

      public ArrayList<Bringer_Of_Death> getBringer_Of_Death() {
		return bringer_of_death;
	}

	public Point getPlayerSpawn() {
		return playerSpawn;
	}
      
	
}
