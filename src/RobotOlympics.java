
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;



/**
 * Canvas Size: 1500x1000
 *
 *
 *
 * @author Peter-John Matzig (000926606)
 */
public class RobotOlympics extends Application {

    /**This is a method for setting a random background color on the Canvas. the method draws a square starting at (0,0)
     * and using the canvas object's getWidth and getHeight methods to extend the square to the edges of the canvas.
     * The method selects a random color from the backgroundColors array
     *
     * @param gc The GraphicsContext object
     * @param canvas the Canvas object
     *
     */
    public static void setBackground(GraphicsContext gc, Canvas canvas){
        //The following array contains the names of all the colors used for the background.
        //Use the Color.valueOf(array[index]) method to access them.
        String[] backgroundColors={"aliceblue","lightyellow","ghostwhite","honeydew","ivory","lavender","lightblue","lightcoral",
                "lightcyan","lightgrey","peru","lightpink"};
        int randomNum=(int) (Math.random()*12);
        gc.setFill(Color.valueOf(backgroundColors[randomNum]));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    /** This is a method for constructing the default font used in the program - Monospace set to size 18
     *
     * @param gc is the Graphics Context object
     */
    public static void setFont(GraphicsContext gc){
        Font defaultFont = Font.font("Monospace",18);
        gc.setFont(Font.font(defaultFont.getFamily(),defaultFont.getSize()));
    }

    /**
     * This is a method for drawing the Referee. It contains the randomization code for determining which
     * team the referee is dawn from, it instantiates the ref object from the Player class and draws it
     * @param gc the Graphics Context object
     */
    public static void drawReferee(GraphicsContext gc){
        int randomNumber=(int)Math.floor(Math.random() *(3 - 1 + 1) + 1);
        if (randomNumber==1){
            Player ref = new Player(900,400,Color.rgb(0,255,0),"Chief Four Twenty Officer");
            ref.drawRobot(gc);
        }else if (randomNumber==2){
            Player ref = new Player(900,400,Color.rgb(0,100,195),"Head of H.A.L.");
            ref.drawRobot(gc);
        }else{
            Player ref = new Player(900,400,Color.rgb(255,0,0),"Lead KillBot");
            ref.drawRobot(gc);
        }
    }

    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(1200, 800); // Set canvas Size in Pixels
        stage.setTitle("**********Robot Olympics**********"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // YOUR CODE STARTS HERE

        //set the background color
        RobotOlympics.setBackground(gc,canvas);

        //set the font used in the program
        RobotOlympics.setFont(gc);

        //instantiate the team objects
        Team t1 = new Team(110,150,"The Four Twenty's",Color.rgb(0,255,0));
        Team t2 = new Team(110,400,"The Sons of H.A.L.",Color.rgb(0,100,195));
        Team t3 = new Team(110,650,"The Future KillBots",Color.rgb(255,0,0));

        //draw the three teams
        t1.drawTeam(gc);
        t2.drawTeam(gc);
        t3.drawTeam(gc);

        //draw the referee
        RobotOlympics.drawReferee(gc);

//      // YOUR CODE STOPS HERE
        stage.show();
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
