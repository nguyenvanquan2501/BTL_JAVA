package entities;

import static utilz.Constants.PlayerConstants.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity {
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 20;
    private int playerAction = IDLE;
    private boolean moving = false, attacking = false;
    private boolean left, up, right, down;
    private float playerSpeed = 2.0f;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {
        updatePos();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 256, 160, null);
    }

         private void updateAnimationTick() {
              aniTick++;
              if (aniTick >= aniSpeed) {
                  aniTick = 0;
                  aniIndex++;
                  if (aniIndex >= GetSpriteAmount(playerAction)) {
                      aniIndex = 0;
                      attacking = false;
                  }
              }
          }
      
   

    private void setAnimation() {
        int startAni = playerAction;

        if (attacking) {
            playerAction = ATTACK_1;
        } else if (moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }

        if (startAni != playerAction) {
            resetAniTick();
        }
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updatePos() {
        moving = false;

        if (left && !right) {
            x -= playerSpeed;
            moving = true;
        } else if (right && !left) {
            x += playerSpeed;
            moving = true;
        }

        if (up && !down) {
            y -= playerSpeed;
            moving = true;
        } else if (down && !up) {
            y += playerSpeed;
            moving = true;
        }
    }

    private void loadAnimations() {
        File imageFile = new File("C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\Wizard_Pack.png");
        try {
            BufferedImage img = ImageIO.read(imageFile);
            animations = new BufferedImage[8][8];
            int tileWidth = 231;
            int tileHeight = 190;
            
            int[] actionOrder = {RUNNING, JUMP, IDLE, ATTACK_1, ATTACK_2, DEATH, HIT, FALL};
            
            for (int j = 0; j < actionOrder.length; j++)
                for (int i = 0; i < animations[j].length; i++)
                    animations[actionOrder[j]][i] = img.getSubimage(i * tileWidth, j * tileHeight, tileWidth, tileHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
