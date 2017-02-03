import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Lori on 2/1/2017.
 */
public class Application {

    /**
     * This method invokes two other methods that try to fill up the goal inch long row lenght and
     * returns true if the the row could be built by small and big bricks that it is provided with.
     *
     * @param numberOfSmallBricks number of small bricks
     * @param numberOfBigBricks   number of big bricks
     * @param rowLength           the length of the row
     * @return false if the row goal lenght could not be built.
     */
    private String makeBricks(int numberOfSmallBricks, int numberOfBigBricks, int rowLength) {
        String True = String.valueOf(true);
        String False = String.valueOf(false);
        int goalFromBigBricks = bigBricksFirst(numberOfBigBricks, rowLength);
        boolean goalFromSmallBricks;
        if (goalFromBigBricks == 0)
            return True;
        else {
            goalFromSmallBricks = smallBricksNext(numberOfSmallBricks, goalFromBigBricks);
            if (goalFromSmallBricks == true)
                return True;
        }
        return False;
    }

    /**
     * This method takes the row length and subtracts one big brick from it in recursive way.
     * If it succeeded returns true if not then returns the remaining row length.
     *
     * @param numberOfBigBricks number of big bricks
     * @param rowLength         the length of the row
     * @return just whatever integer, it will not reach that anyway
     */
    private int bigBricksFirst(int numberOfBigBricks, int rowLength) {
        int oneBigBrick = 5;

        if (numberOfBigBricks == 0 && rowLength > 0)
            return rowLength;
        if (rowLength == 0)
            return rowLength;
        if (rowLength - oneBigBrick >= 0) {
            rowLength -= oneBigBrick;
            return bigBricksFirst(numberOfBigBricks - 1, rowLength);
        }
        return 1;
    }

    /**
     * This method takes the remaining row length after it was subtracted from by all the big bricks first.
     * Returns true if there are enough small bricks to fill the remaining space in the row.
     * Returns false if there aren't any small bricks left to fill in the remaining space in the row.
     *
     * @param numberOfSmallBricks the number of small bricks
     * @param newRowLength        the remaining row length
     * @return true and false.
     */
    private boolean smallBricksNext(int numberOfSmallBricks, int newRowLength) {
        if (numberOfSmallBricks >= newRowLength)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Application application = new Application();

        System.out.println(application.makeBricks(3, 2, 10));
    }
}
