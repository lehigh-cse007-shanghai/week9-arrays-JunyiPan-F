package lehigh;

import processing.core.PApplet;

import java.lang.reflect.Array;

public class MovingBalls extends PApplet {
    int howManyBalls = 3;
    float x[] = new float[howManyBalls];
    float y[] = new float[howManyBalls];
    float speedX[] = new float[howManyBalls];
    float speedY[] = new float[howManyBalls];
    float color[][] = new float[howManyBalls][3];
    int radius = 20;

    public void settings() {
        size(500, 500);

        for (int i = 0; i < howManyBalls; i++) {
            x[i] = random(radius, width - radius);
            y[i] = random(radius, height - radius);
            speedX[i] = random(1,1);
            speedY[i] = random(1,1);
            color[i] = new float[]{random(255), random(255), random(255)};
        }
    }

    public void draw() {
        background(250, 142, 82);
        fill(255, 0, 0);
        stroke(255, 10, 10);
        for (int i = 0; i < howManyBalls; i++) {
            fill(color[i][0], color[i][1], color[i][2]);
            ellipse(x[i], y[i], radius * 2, radius * 2);


            if ((x[i] - radius) <= 0 || (x[i] + radius) >= width)
                speedX[i] = -speedX[i];

            if ((y[i] - radius) <= 0 || (y[i] + radius) >= height)
                speedY[i] = -speedY[i];

            x[i] += speedX[i];
            y[i] += speedY[i];
        }
        for (int i = 0; i < howManyBalls; i++) {
            line(x[0], y[0], x[1], y[1]);
        }
    }


    public static void main(String[] args) {
        String[] processingArgs = {"MovingBalls"};
        MovingBalls movingBalls = new MovingBalls();
        PApplet.runSketch(processingArgs, movingBalls);
    }
}