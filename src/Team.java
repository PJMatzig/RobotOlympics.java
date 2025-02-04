import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * The Team class
 *
 */
public class Team {
    private double xPos;
    private double yPos;
    private String teamName;
    private Color teamColor;
    //the constructor
    public Team(double xPos, double yPos,String teamName, Color teamColor) {
       this.xPos=xPos;
       this.yPos=yPos;
       this.teamName=teamName;
       this.teamColor=teamColor;


    }

    /**
     * This method draws the Team which consists of three objects of the Player class.
     *
     *
     * @param gc is the GraphicsContext object
     */
    public void drawTeam(GraphicsContext gc){


        //Each robot has a winning percentage associated with it.
        //This is the average for each team.
        double averageWinningPercentage;

        Player p1 = new Player(this.xPos,this.yPos,teamColor);
        Player p2 = new Player(this.xPos+200,this.yPos,teamColor);
        Player p3 = new Player(this.xPos+400,this.yPos,teamColor);
        //format the output nicely while doing the calculation
        averageWinningPercentage= Double.parseDouble(String.format("%.2f",(double) (p1.getWinningPercentage() +
                p2.getWinningPercentage() + p3.getWinningPercentage())/3));

        //draw all the graphics and text output
        p1.drawRobot(gc);
        p2.drawRobot(gc);
        p3.drawRobot(gc);
        gc.strokeText(this.teamName, this.xPos-30, this.yPos+140);
        gc.strokeText("Average Winning Percentage: "+averageWinningPercentage,this.xPos+190,this.yPos+140);
    }
}
