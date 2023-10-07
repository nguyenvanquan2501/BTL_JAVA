package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gamestates.Playing;
import java.awt.geom.Rectangle2D;
import levels.Level;
import utilz.LoadSave;
import static utilz.Constants.EnemyConstants.*;

public class EnemyManager {

	private Playing playing;
	private BufferedImage[][] bringer_of_deathArr;
	private ArrayList<Bringer_Of_Death> bringer_of_death = new ArrayList<>();

	public EnemyManager(Playing playing) {
		this.playing = playing;
		loadEnemyImgs();
	}
      
      public void loadEnemies(Level level) {
		bringer_of_death = level.getBringer_Of_Death();
	}
      
      public void update(int[][] lvlData, Player player) {
		boolean isAnyActive = false;
		for (Bringer_Of_Death c : bringer_of_death)
			if (c.isActive()) {
				c.update(lvlData, player);
				isAnyActive = true;
			}
		if(!isAnyActive)
			playing.setLevelCompleted(true);
	}
      
      public void draw(Graphics g, int xLvlOffset) {
		drawBringer_Of_Death(g, xLvlOffset);
	}
      
      private void drawBringer_Of_Death(Graphics g, int xLvlOffset) {
		for (Bringer_Of_Death c : bringer_of_death)
			if (c.isActive()) {
				g.drawImage(bringer_of_deathArr[c.getEnemyState()][c.getAniIndex()], (int) c.getHitbox().x - xLvlOffset - BRINGER_OF_DEATH_DRAWOFFSET_X + c.flipX(), (int) c.getHitbox().y - BRINGER_OF_DEATH_DRAWOFFSET_Y,
						BRINGER_OF_DEATH_WIDTH * c.flipW(), BRINGER_OF_DEATH_HEIGHT, null);
//				c.drawHitbox(g, xLvlOffset);
//				c.drawAttackBox(g, xLvlOffset);

			}

	}
      
      public void checkEnemyHit(Rectangle2D.Float attackBox) {
		for (Bringer_Of_Death c : bringer_of_death)
			if (c.isActive())
				if (attackBox.intersects(c.getHitbox())) {
					c.hurt(10);
					return;
				}
	}
      
      private void loadEnemyImgs() {
		bringer_of_deathArr = new BufferedImage[8][8];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BRINGER_OF_DEATH_SPRITE);
		for (int j = 0; j < bringer_of_deathArr.length; j++)
			for (int i = 0; i < bringer_of_deathArr[j].length; i++)
				bringer_of_deathArr[j][i] = temp.getSubimage(i * BRINGER_OF_DEATH_WIDTH_DEFAULT, j * BRINGER_OF_DEATH_HEIGHT_DEFAULT, BRINGER_OF_DEATH_WIDTH_DEFAULT, BRINGER_OF_DEATH_HEIGHT_DEFAULT);
	}
      
//      private void loadEnemyImgs() {
//		bringer_of_deathArr = new BufferedImage[8][8];
//		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.BRINGER_OF_DEATH_SPRITE);
//		for (int j = 0; j < bringer_of_deathArr.length; j++)
//			for (int i = 0; i < bringer_of_deathArr[j].length; i++)
//				bringer_of_deathArr[j][i] = temp.getSubimage(i * 140, j * 90, 140, 90);
//	}
      
	public void resetAllEnemies() {
		for (Bringer_Of_Death c : bringer_of_death)
			c.resetEnemy();
      }
	
}
