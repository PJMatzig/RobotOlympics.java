import javafx.scene.canvas.GraphicsContext;

/**
 * This Class defines the wheel and holds the draw method for it.
 */
public class Wheel {
    private double xPos;
    private double yPos;
    public Wheel (double xPos,double yPos){
        this.xPos=xPos;
        this.yPos=yPos;
    }

    /**
     * This method draws a wheel.
     * @param gc is the GraphicsContext object.
     */
    public void drawWheel(GraphicsContext gc){
        gc.fillRoundRect(this.xPos,this.yPos,10,110,10,10);//wheel
    }
}
