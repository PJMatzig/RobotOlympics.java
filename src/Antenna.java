import javafx.scene.canvas.GraphicsContext;

public class Antenna {
    private double xPos;
    private double yPos;
    public Antenna(double xPos,double yPos){
        this.xPos=xPos;
        this.yPos=yPos;
    }
    public void drawAntenna(GraphicsContext gc){
        gc.setLineWidth(1.75);
        gc.strokeLine(this.xPos,this.yPos,this.xPos,this.yPos-5);
        gc.strokeOval(this.xPos-10,this.yPos-10,20,5);
    }
}
