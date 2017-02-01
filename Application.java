import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lori on 2/1/2017.
 */
public class Application {

    /**
     * This method tries to build a goal inches long row full of bricks.
     * Returns true if it is possible to make the goal by choosing from the given bricks.
     *
     * @param smallBrick 1 inch long bricks
     * @param bigBrick   5 inch long bricks
     * @param goal       the desired dimension of the row     *
     */
    private String makeBricks(int smallBrick, int bigBrick, int goal) {
        String True = String.valueOf(true);
        String False = String.valueOf(false);
        int s_Brick = 1;
        int b_Brick = 5;
        int numberOf_s_Bricks = 1;
        int numberOf_b_Bricks = 1;
        int totalBricks = 0;
        int row_lengh = 0;
       // int[] row_lenght;

        if (goal > 0) {
            //row_lenght = new int[goal];
            if (smallBrick < 0 || bigBrick < 0)
                return "Only positive values allowed for smallBrick and bigBrick.";
            numberOf_s_Bricks = smallBrick * s_Brick;
            numberOf_b_Bricks = bigBrick * b_Brick;
            totalBricks = numberOf_b_Bricks + numberOf_s_Bricks;
            if (totalBricks < goal)
                return "There are not enough bricks.";
            System.out.println("Total bricks = " + totalBricks);
            row_lengh = goal - totalBricks;
            if (row_lengh < 0) {
                String numberAsString = Integer.toString(row_lengh);
                return "Reminder = " + numberAsString;
            }
              //row_lenght = addBricks(row_lenght,totalBricks);

        } else
            return "Please enter a valid length for the goal.";

        //  System.out.format("Big bricks = %d Small bricks %d",numberOf_b_Bricks, numberOf_s_Bricks);
        return True;
    }

    private static int[] addBricks(int[] row, int total_bricks){
        row = Arrays.copyOf(row, row.length + 1);
        row[row.length - 1] = total_bricks;
        return row;
    }

    public static void main(String[] args) {
        Application application = new Application();

        System.out.println(application.makeBricks(0,3, 13));
    }
}
