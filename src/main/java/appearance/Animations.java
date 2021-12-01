package appearance;

import entities.Player;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Scanner;

public class Animations {

    private static void runAnimation(boolean isRuning){

    }

    private static void standAnimation(Graphics g){
        g.drawImage(Images.images[0], MapBuilding.x, MapBuilding.y, null);
    }

    public static void draw(Graphics g) {
        standAnimation(g);
    }
}
