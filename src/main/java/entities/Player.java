package entities;

import appearance.MapBuilding;

import java.awt.*;
import java.awt.event.KeyEvent;

import static appearance.MapBuilding.*;
import static entities.Collisions.*;


public class Player {

    private static boolean right = false;
    private static boolean left = false;
    private static boolean up = false;
    private static boolean down = false;
    private static boolean canJump = false;

    private static boolean dStillPressed = false;
    private static boolean aStillPressed = false;

    private static final double jumpSpeed = 5;
    private static double currentJumpSpeed = jumpSpeed;
    private static final double maxFallSpeed = 8;
    private static double currentFallSpeed = .3;

    private static final int CHARACTERSIZE = 32;
    private static final int CHARACTERMOVINGSPEED = 3;

    public static void playerActions() {
        goToTheNextLevel();
        collisionWithTrapBlock();
        canJump();
        rightBlockIsSolid();
        leftBlockIsSolid();
        upperBlockIsSolid();
        downBlockIsAir();

        if(up || down) {
            if(dStillPressed && !(MapBuilding.map[((y) / 32)][((x + 32) / 32)] == 1
                    || ((y % 32) > 5 && MapBuilding.map[((y) / 32) + 2][((x + 32) / 32)] == 1)))
                right = true;
            if(aStillPressed && !(MapBuilding.map[((y) / 32)][((x - 6) / 32)] == 1
                    || ((y % 32) > 5 && MapBuilding.map[((y) / 32 + 2)][((x - 4) / 32)] == 1)))
                left = true;
        }

        if(right){
            x += CHARACTERMOVINGSPEED;
        }

        if(left){
            x -= CHARACTERMOVINGSPEED;
        }

        if (up && !down) {
            y -= currentJumpSpeed;
            currentJumpSpeed -= .2;
            if (currentJumpSpeed <= 0) {
                currentJumpSpeed = jumpSpeed;
                up = false;
                down = true;
                canJump = false;
            }
        }

        if (down) {
            y += currentFallSpeed;
            if (currentFallSpeed < maxFallSpeed) {
                currentFallSpeed += .3;
            }
        }
        if (!down) {
            currentFallSpeed = .3;
        }

    }


    public static boolean isRight() {
        return right;
    }

    public static boolean isLeft() {
        return left;
    }

    public static boolean isDown() {
        return down;
    }

    public static void setRight(boolean right) {
        Player.right = right;
    }

    public static void setLeft(boolean left) {
        Player.left = left;
    }

    public static boolean isUp() {
        return up;
    }

    public static void setUp(boolean up) {
        Player.up = up;
    }

    public static void setDown(boolean down) {
        Player.down = down;
    }

    public static void setCanJump(boolean canJump) {
        Player.canJump = canJump;
    }

    public static double getJumpSpeed() {
        return jumpSpeed;
    }

    public static void setCurrentJumpSpeed(double currentJumpSpeed) {
        Player.currentJumpSpeed = currentJumpSpeed;
    }

    public static int getCHARACTERSIZE() {
        return CHARACTERSIZE;
    }

    public static void draw(Graphics g) {

        //animation(g);
        //g.setColor(Color.red);
        //g.drawRect(x, y, width, height);

    }

    public static void keyPressed(int k) {
        if (k == KeyEvent.VK_ESCAPE)
            System.exit(0);
        if (k == KeyEvent.VK_D) {
            right = true;
            left = false;
            dStillPressed = true;
        }
        if (k == KeyEvent.VK_S) {
            currentJumpSpeed = jumpSpeed;
            up = false;
            down = true;
            canJump = false;
        }
        if (k == KeyEvent.VK_A){
            left = true;
            right = false;
            aStillPressed = true;
        }
        if (k == KeyEvent.VK_W && canJump)
            up = true;
        if (k == KeyEvent.VK_P)
            setLvlCounter(1);
    }
    public static void keyReleased(int k) {
        if (k == KeyEvent.VK_D){
            right = false;
            dStillPressed = false;}
        if (k == KeyEvent.VK_A){
            left = false;
            aStillPressed = false;}

    }
    }
