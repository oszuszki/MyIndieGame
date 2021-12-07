package appearance;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class Images {

    public static BufferedImage[] images;

    public Images() {
        images = new BufferedImage[17];

        try {
            images[0] = ImageIO.read(this.getClass().getResourceAsStream("/arrow_l.png"));
            images[1] = ImageIO.read(this.getClass().getResourceAsStream("/arrow_r.png"));
            images[2] = ImageIO.read(this.getClass().getResourceAsStream("/spike_up.png"));
            images[3] = ImageIO.read(this.getClass().getResourceAsStream("/player_standing_right.png"));
            images[4] = ImageIO.read(this.getClass().getResourceAsStream("/player_standing_left.png"));
            images[5] = ImageIO.read(this.getClass().getResourceAsStream("/player_standing_right_1.png"));
            images[6] = ImageIO.read(this.getClass().getResourceAsStream("/player_standing_left_1.png"));
            images[7] = ImageIO.read(this.getClass().getResourceAsStream("/player_jump_left.png"));
            images[8] = ImageIO.read(this.getClass().getResourceAsStream("/player_jump_right.png"));
            images[9] = ImageIO.read(this.getClass().getResourceAsStream("/player_run_right_0.png"));
            images[10] = ImageIO.read(this.getClass().getResourceAsStream("/player_run_right_1.png"));
            images[11] = ImageIO.read(this.getClass().getResourceAsStream("/player_run_right_2.png"));
            images[12] = ImageIO.read(this.getClass().getResourceAsStream("/player_run_left_0.png"));
            images[13] = ImageIO.read(this.getClass().getResourceAsStream("/player_run_left_1.png"));
            images[14] = ImageIO.read(this.getClass().getResourceAsStream("/player_run_left_2.png"));
            images[15] = ImageIO.read(this.getClass().getResourceAsStream("/brick_block.png"));
            images[16] = ImageIO.read(this.getClass().getResourceAsStream("/bg_brick_block.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
