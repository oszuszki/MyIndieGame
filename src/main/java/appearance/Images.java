package appearance;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class Images {

    public static BufferedImage[] images;

    public Images() {
        images = new BufferedImage[4];

        try {
            images[0] = ImageIO.read(this.getClass().getResourceAsStream("/player_standing_right.png"));
            images[1] = ImageIO.read(this.getClass().getResourceAsStream("/arrow_l.png"));
            images[2] = ImageIO.read(this.getClass().getResourceAsStream("/arrow_r.png"));
            images[3] = ImageIO.read(this.getClass().getResourceAsStream("/spike_up.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
