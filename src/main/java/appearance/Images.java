package appearance;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class Images {

    public static BufferedImage[] images;

    public Images() {
        images = new BufferedImage[1];

        try {
            images[0] = ImageIO.read(this.getClass().getResourceAsStream("/player_standing_right.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
