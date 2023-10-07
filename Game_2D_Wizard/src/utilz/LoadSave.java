package utilz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;

public class LoadSave {

     
      
            
	public static final String PLAYER_ATLAS = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\Wizard_Pack.png"; // Đường dẫn tương đối đến tệp ảnh
      public static final String LEVEL_ATLAS = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\outside_sprites.png";
      public static final String MENU_BUTTONS = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\button_atlas.png";
	public static final String MENU_BACKGROUND = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\menu_background.png";
      public static final String PAUSE_BACKGROUND = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\pause_menu.png";
	public static final String SOUND_BUTTONS = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\sound_button.png";
	public static final String URM_BUTTONS = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\urm_buttons.png";
	public static final String VOLUME_BUTTONS = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\volume_buttons.png";
      public static final String MENU_BACKGROUND_IMG = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\background_menu.png";
      public static final String PLAYING_BG_IMG = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\backgound.jpg";
	public static final String BIG_CLOUDS = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\big_clouds.png";
	public static final String SMALL_CLOUDS = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\small_clouds.png";
      //public static final String BRINGER_OF_DEATH_SPRITE = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\Bringer-of-Death-SpritSheet.png";
      public static final String BRINGER_OF_DEATH_SPRITE ="C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\Resized_Bringer-of-Death-SpritSheet.png";
      
      
      public static final String STATUS_BAR = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\health_power_bar.png";
	public static final String COMPLETED_IMG = "C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\completed_sprite.png";

     
	public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static BufferedImage[] GetAllLevels() {
        // Sử dụng trực tiếp đường dẫn tuyệt đối
        File file = new File("C:\\CODE\\BTL_JAVA\\Game_2D_Wizard\\src\\res\\lvs");
        
        if (!file.exists() || !file.isDirectory()) {
            System.out.println("Thư mục không tồn tại hoặc không phải là thư mục");
            return null;
        }

        File[] files = file.listFiles((dir, name) -> name.endsWith(".png"));
        if (files == null) {
            System.out.println("Không tìm thấy tệp nào trong thư mục");
            return null;
        }

        BufferedImage[] imgs = new BufferedImage[files.length];
        for (int i = 0; i < imgs.length; i++) {
            try {
                imgs[i] = ImageIO.read(files[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return imgs;
    }

}




