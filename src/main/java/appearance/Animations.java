package appearance;


import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Scanner;

import static entities.Player.*;
import static appearance.MapBuilding.*;

public class Animations {

    private static int left_animation;
    private static int right_animation;
    private static int leftFramecounter;
    private static int rightFramecounter;
    private static int standingFramecounter;

    private static void standAnimation(Graphics g){
        if (!isRight() && !isLeft() && !isUp() && !isDown()){
            if (left_animation > right_animation){
                switch (standingFramecounter){
                    case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 -> {
                        g.drawImage(Images.images[4],  x, y , null);
                        standingFramecounter += 1;
                    }
                    case 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39 -> {
                        g.drawImage(Images.images[6],  x, y , null);
                        standingFramecounter += 1;
                    }
                    case 40 -> {
                        g.drawImage(Images.images[6],  x, y , null);
                        standingFramecounter = 0;
                    }
                }}
            else{
                switch (standingFramecounter){
                    case 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 -> {
                        g.drawImage(Images.images[3],  x, y , null);
                        standingFramecounter += 1;
                    }
                    case 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39 -> {
                        g.drawImage(Images.images[5],  x, y , null);
                        standingFramecounter += 1;
                    }
                    case 40 -> {
                        g.drawImage(Images.images[5],  x, y , null);
                        standingFramecounter = 0;
                    }
                }
            }
        }
    }

    private static void runAnimation(Graphics g){
        if(isRight() && !isUp() && !isDown()){
            left_animation = 0;
            right_animation = 1;
            switch (rightFramecounter) {
                case 0, 1, 2, 3 -> {
                    g.drawImage(Images.images[9], MapBuilding.x, MapBuilding.y, null);
                    rightFramecounter += 1;
                }
                case 4, 5, 6, 7 -> {
                    g.drawImage(Images.images[10], MapBuilding.x, MapBuilding.y, null);
                    rightFramecounter += 1;
                }
                case 8, 9, 10 -> {
                    g.drawImage(Images.images[11], MapBuilding.x, MapBuilding.y, null);
                    rightFramecounter += 1;
                }
                case 11 -> {
                    g.drawImage(Images.images[11], MapBuilding.x, MapBuilding.y, null);
                    rightFramecounter = 0;
                }
            }
        }
        else if (isLeft() && !isUp() && !isDown()) {
            left_animation = 1;
            right_animation = 0;
            switch (rightFramecounter) {
                case 0, 1, 2, 3 -> {
                    g.drawImage(Images.images[12], MapBuilding.x, MapBuilding.y, null);
                    rightFramecounter += 1;
                }
                case 4, 5, 6, 7 -> {
                    g.drawImage(Images.images[13], MapBuilding.x, MapBuilding.y, null);
                    rightFramecounter += 1;
                }
                case 8, 9, 10 -> {
                    g.drawImage(Images.images[14], MapBuilding.x, MapBuilding.y, null);
                    rightFramecounter += 1;
                }
                case 11 -> {
                    g.drawImage(Images.images[14], MapBuilding.x, MapBuilding.y, null);
                    rightFramecounter = 0;
                }
            }
        }
    }

    private static void jumpAnimation(Graphics g) {
        if(isUp() || isDown()) {
            if(isLeft())
                g.drawImage(Images.images[7],  x, y , null);
            if(isRight())
                g.drawImage(Images.images[8],  x, y , null);
            if (!isRight() && !isLeft()){
                if (left_animation > right_animation)
                    g.drawImage(Images.images[7],  x, y , null);
                else
                    g.drawImage(Images.images[8],  x, y , null);
            }

        }
    }

    public static void draw(Graphics g) {
        standAnimation(g);
        runAnimation(g);
        jumpAnimation(g);
    }
}

/*  public static void animation (Graphics g) {

        g.setColor(Color.blue);
        g.drawRect(x,y ,32, 32);

        if(up || down) {
            if(left)
                g.drawImage(GamePanel.images[16],  x, y , null);
            if(right)
                g.drawImage(GamePanel.images[15],  x, y , null);
            if (!right && !left){
                if (left_animation > right_animation)
                    g.drawImage(GamePanel.images[16],  x, y , null);
                else
                    g.drawImage(GamePanel.images[15],  x, y , null);
            }

        }


        if (!right && !left && !up && !down){
            if (left_animation > right_animation)
                g.drawImage(GamePanel.images[9],  x, y , null);
            else
                g.drawImage(GamePanel.images[11],  x, y , null);
        }


        if (left && !up && !down) {
            right_animation = 0;
            left_animation = 1;
            switch (lFramecounter) {
                case 0, 2, 4, 6, 8 -> {
                    g.drawImage(GamePanel.images[5], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 10, 12, 14, 16 -> {
                    g.drawImage(GamePanel.images[6], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 18, 20, 22, 24 -> {
                    g.drawImage(GamePanel.images[7], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 26, 28, 30 -> {
                    g.drawImage(GamePanel.images[8], x, y, null);
                    lFramecounter = lFramecounter + 2;
                }
                case 32 -> {
                    g.drawImage(GamePanel.images[8], x, y, null);
                    lFramecounter = 0;
                }
            }
        }
        else if (right && !up && !down) {
            left_animation = 0;
            right_animation = 1;
            switch (rFramecounter) {
                case 0, 2, 4, 6, 8 -> {
                    g.drawImage(GamePanel.images[1], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 10, 12, 14, 16 -> {
                    g.drawImage(GamePanel.images[2], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 18, 20, 22, 24 -> {
                    g.drawImage(GamePanel.images[3], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 26, 28, 30, 32-> {
                    g.drawImage(GamePanel.images[4], x, y, null);
                    rFramecounter = rFramecounter + 2;
                }
                case 34-> {
                    g.drawImage(GamePanel.images[4], x, y, null);
                    rFramecounter = 0;
                }

            }
        }
    }*/
