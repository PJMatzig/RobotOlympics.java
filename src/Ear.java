import javafx.scene.canvas.GraphicsContext;

public class Ear {
    private double xPos;
    private double yPos;
    public Ear(double xPos, double yPos){
        this.xPos=xPos;
        this.yPos=yPos;
    }

    /**
     * This method draws the left ear on the robot
     * @param gc is the GraphicsContext object.
     */
    public void drawLeftEar(GraphicsContext gc){
        gc.setLineWidth(3.5);
        gc.strokeLine(this.xPos-2,this.yPos+25,this.xPos-15,this.yPos+25);
        gc.strokeLine(this.xPos-2,this.yPos+17,this.xPos-2,this.yPos+33);
        gc.strokeLine(this.xPos-8,this.yPos+19,this.xPos-8,this.yPos+31);
        gc.strokeLine(this.xPos-14,this.yPos+21,this.xPos-14,this.yPos+29);
    }

    /**
     * This method draws the right ear on the robot.
     * @param gc is the GraphicsContext object.
     */
    public void drawRightEar(GraphicsContext gc){
        gc.setLineWidth(3.5);
        gc.strokeLine(this.xPos+52,this.yPos+25,this.xPos+65,this.yPos+25);
        gc.strokeLine(this.xPos+52,this.yPos+17,this.xPos+52,this.yPos+33);
        gc.strokeLine(this.xPos+58,this.yPos+19,this.xPos+58,this.yPos+31);
        gc.strokeLine(this.xPos+64,this.yPos+21,this.xPos+64,this.yPos+29);
    }
}
