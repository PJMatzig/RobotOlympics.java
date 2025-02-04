import javafx.scene.canvas.GraphicsContext;

public class Eye {
    private double xPos;
    private double yPos;
    private double width;
    private double height;
    public Eye(double xPos,double yPos,double width,double height){
        this.xPos=xPos;
        this.yPos=yPos;
        this.width=width;
        this.height=height;
    }

    /**
     * This method draws a circle representing an eye at the specified coordinates
     *
     * @param gc is the GraphicsContext object.
     */
    public void drawEye(GraphicsContext gc){
        gc.fillOval(this.xPos,this.yPos,this.width,this.height);
    }
}
