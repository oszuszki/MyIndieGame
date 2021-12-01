package appearance;

import panels.GamePanel;

import java.awt.*;

import static appearance.MapBuilding.*;
import static appearance.Images.*;

public class Map {

    private static final int blockSize= 32;

    private static void platform(Graphics g) {
        nextLvl();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                    /**case 0:
                        g.setColor(Color.blue);
                        g.drawRect(j * blockSize,i * blockSize , blockSize, blockSize);
                        break;*/
                    case 1:
                        g.setColor(Color.red);
                        g.drawRect(j * blockSize,i * blockSize , blockSize, blockSize);
                        //g.drawImage(GamePanel.images[17], j * blockSize,i * blockSize, blockSize, blockSize, null);
                        break;
                    case 2:
                        g.setColor(Color.green);
                        g.drawRect(j * blockSize,i * blockSize , blockSize, blockSize);
                        break;
                    case 3:
                        g.drawImage(images[1], arrowX1 * blockSize,arrowY1 * blockSize, blockSize, blockSize, null);
                        break;
                    case 33:
                        g.drawImage(images[2], arrowX2 * blockSize,arrowY2 * blockSize, blockSize, blockSize, null);
                        break;
                    case 4:
                        g.drawImage(images[3], j * blockSize,i * blockSize, blockSize, blockSize, null);
                        break;
                }
            }
        }
    }

    public static void draw(Graphics g) {
        //backGround(g);
        platform(g);
    }
}