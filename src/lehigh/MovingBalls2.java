package lehigh;

import processing.core.PApplet;

import java.util.ArrayList;

public class MovingBalls2 extends PApplet {
    class Ball{
        int x, y, radius;
        float speedx, speedy;
        float [] color;

        Ball(){
            radius = (int) random(5,10);
            x = (int) random(width - radius);
            y = (int) random(width - radius);
            speedx = random(1f, 2.0f);
            speedy = random(1f, 2.0f);
            color = new float[] {random(255),random(255),random(255)};
        }

        public void move(){
            fill(color[0],color[1],color[2]);
            ellipse(x,y,radius,radius);
            x += speedx;
            y += speedy;
            if (x > 500 || x< 0){
                speedx *= -1;
            }
            if (y > 500 || x< 0){
                speedy *= -1;
            }
        }
    }

    ArrayList<Ball> balls;

    public void settings(){
        size(500,500);
        balls = new ArrayList<>();
        for(int i = 0; i < 200; i++){
            balls.add(new Ball());
        }
    }

    public void draw(){
        background(150);
        fill(255);

        for(Ball ball:balls){
            ball.move();
        }
    }
    public void mouseClicked(){
        for (int i=0; i <200; i++){
            if (balls.get(i).x-balls.get(i).radius <mouseX && mouseX <balls.get(i).x+balls.get(i).radius && balls.get(i).y-balls.get(i).radius <mouseY && mouseY < balls.get(i).y+balls.get(i).radius){
                balls.get(i).speedx += 10;
                balls.get(i).speedy += 10;
            }
        }
    }

    public static void main(String[] args){
        String[] processingArgs = {"MovingBalls2"};
        MovingBalls2 movingBalls2 = new MovingBalls2();
        PApplet.runSketch(processingArgs, movingBalls2);
    }
}
