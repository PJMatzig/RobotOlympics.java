import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

/**
 * This Class defines what the head looks like and draws it along with
 * the eyes, ears, antenna and smile/frown
 */
public class Head {
    private double xPos;
    private double yPos;
    public Head (double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos-10;
    }

    /**
     * A method for drawing the head plus the eyes, ears, and antenna. The various
     * bits are all objects of the appropriate class. The smile is just
     * drawn on the face as is the neck connecting the head to the body.
     * @param gc the Graphics Context object
     * @param winPer a double value representing the robot's winning percentage. used to determine
     *               if the robot is smiling or frowning
     * @param teamColor this is the color of the robot's team, the inner eye is drawn in the
     *                  same color as the robot's team color
     */
    public void drawHead(GraphicsContext gc, double winPer, Color teamColor) {
        //the head
        gc.fillRoundRect(this.xPos, this.yPos, 50, 50, 10, 10);
        //the neck
        gc.fillRect(this.xPos + 20, this.yPos + 50, 10, 10);
        //draw the accouterments that go with the head: inner and outer eye, antenna and smile/frown

        //the outer and inner eye
        Eye e1 = new Eye(this.xPos+15,this.yPos+5,20,20);
        Eye e2 = new Eye(this.xPos+20,this.yPos+10,10,10);
        gc.setFill(Color.BLACK);
        e1.drawEye(gc);
        //the color of the inner eye is determined by winning percentage
        if(winPer>=80){
            gc.setFill(teamColor);
        }else if (winPer>=50){
            gc.setFill(Color.YELLOW);
        }else{
            gc.setFill(Color.ORANGE);
        }
        e2.drawEye(gc);

        //the antenna
        Antenna a1 = new Antenna(this.xPos+25,this.yPos);
        gc.setStroke(Color.BLACK);
        a1.drawAntenna(gc);

        //the smile or frown...if the winning percentage is above 50% then it's a smile
        //otherwise, a frown
        gc.setFill(Color.LIGHTSTEELBLUE);
        if (winPer > 50) {
            gc.strokeArc(this.xPos + 15, this.yPos + 18, 20, 25, 180, 180, ArcType.ROUND);
            gc.fillArc(this.xPos + 15, this.yPos + 18, 20, 25, 180, 180, ArcType.ROUND);
        } else {
            gc.strokeArc(this.xPos + 15, this.yPos + 30, 20, 25, 0, 180, ArcType.ROUND);
            gc.fillArc(this.xPos + 15, this.yPos + 30, 20, 25, 0, 180, ArcType.ROUND);
        }

        //the ears
        Ear ear1 = new Ear(this.xPos,this.yPos);
        Ear ear2= new Ear(this.xPos,this.yPos);
        gc.setStroke(Color.rgb(0,0,0,.75));
        ear1.drawLeftEar(gc);
        ear2.drawRightEar(gc);
    }
}
