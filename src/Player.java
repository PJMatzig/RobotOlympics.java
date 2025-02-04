import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Player {
    private double xPos;
    private double yPos;
    private int winningPercentage;

    private Color teamColor;

    private String title;

    //the constructors
    public Player (double xPos, double yPos, Color teamColor){
        this.xPos=xPos;
        this.yPos=yPos;
        this.teamColor=teamColor;
        this.winningPercentage=(int) ((Math.random()*100));
        this.title="";
    }

    /**
     * This constructor is used to create a referee object
     * @param xPos is the x co-ordinate.
     * @param yPos is the y coordinate.
     * @param teamColor is a rgb value representing the team's color
     * @param title is used only for a referee object
     */
    public Player (double xPos, double yPos, Color teamColor, String title){
        this.xPos=xPos;
        this.yPos=yPos;
        this.teamColor=teamColor;
        this.title=title;
        this.winningPercentage=100;
    }

    /**
     * This method draws the various pieces of the robot to the screen.
     * @param gc is the GraphicsContext object.
     */
    public void drawRobot(GraphicsContext gc){
        //set up the various objects that represent the extra parts of the robot
        Head h1=new Head(this.xPos+25,this.yPos-50);
        Wheel w1=new Wheel(this.xPos-10,this.yPos+5);
        Wheel w2=new Wheel(this.xPos+100,this.yPos+5);

        //set the drawing colors
        gc.setFill(this.teamColor);
        gc.setStroke(this.teamColor);

        //draw the body of the robot: main body then inner square
        gc.fillRoundRect(this.xPos, this.yPos,100,100,10,10);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(4);
        gc.strokeRoundRect(this.xPos+15,this.yPos+15,70,70,10,10);

        //start drawing the extra parts, starting with the head, sometimes altering the drawing color
        h1.drawHead(gc, getWinningPercentage(),teamColor);

        //draw the wheels
        gc.setFill(Color.rgb(5,5,5,.6));
        w1.drawWheel(gc);
        w2.drawWheel(gc);

        //draw text for winning percentage and Referee title
        //the if conditions adjust where the text is drawn depending on what the size of the text is
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        String output="";
        if (winningPercentage<10){
            output="0"+winningPercentage;
            gc.strokeText(output,xPos+41,yPos+56);

        }else {
            gc.strokeText(String.valueOf(this.winningPercentage), xPos + 36, yPos + 56);
        }
//        if (this.winningPercentage<10){
//            gc.strokeText(String.valueOf(this.winningPercentage),xPos+45,yPos+57);
//        }else{
//
//        }
        if (this.title.length()<20){
            gc.strokeText(this.title, 890-this.title.length(), 540);
        }else{
            gc.strokeText(this.title, 840-this.title.length(), 540);
        }
    }

    /**
     * This method returns the robots winning percentage.
     * @return is the value of individual robot's winning percentage.
     */
    public int getWinningPercentage(){
        return this.winningPercentage;
    }
}
