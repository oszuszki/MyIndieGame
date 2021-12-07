package appearance;

import panels.GamePanel;

import java.awt.*;

import static appearance.MapBuilding.*;
import static appearance.Images.*;

public class MapAppearance {

    private static final int blockSize= 32;

    private static void mapGraphics(Graphics g) {
        nextLvl();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                    /**case 0:
                        g.setColor(Color.blue);
                        g.drawRect(j * blockSize,i * blockSize , blockSize, blockSize);
                        break;*/
                    case 1:
                        //g.setColor(Color.red);
                        //g.drawRect(j * blockSize,i * blockSize , blockSize, blockSize);
                        g.drawImage(Images.images[16], j * blockSize,i * blockSize , blockSize, blockSize, null);
                        //g.drawImage(GamePanel.images[17], j * blockSize,i * blockSize, blockSize, blockSize, null);
                        break;
                    case 2:
                        g.setColor(Color.green);
                        g.drawRect(j * blockSize,i * blockSize , blockSize, blockSize);
                        break;
                    case 3:
                        g.drawImage(images[0], j * blockSize,i * blockSize, blockSize, blockSize, null);
                        break;
                    case 33:
                        g.drawImage(images[1], j * blockSize,i * blockSize, blockSize, blockSize, null);
                        break;
                    case 4:
                        g.drawImage(images[2], j * blockSize,i * blockSize, blockSize, blockSize, null);
                        break;
                }
            }
        }
    }

    public static void draw(Graphics g) {
        //backGround(g);
        mapGraphics(g);
    }
}