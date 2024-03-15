import MarsRover.MarsRover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarsRoverTest {

    MarsRover rover = new MarsRover();
    @Test
    public void shouldExistMarsRover() {
        assertNotNull(new MarsRover());
    }

    @Test
    public void shouldHaveAnInitialPosition() {

        assertEquals("0:0:N", rover.getPosition());
    }

    @Test
    public void shouldMoveForward() {

        rover.command("M");

        assertEquals("0:1:N", rover.getPosition());
    }

    @Test
    public void shouldMoveForwardTwice() {

        rover.command("MM");

        assertEquals("0:2:N", rover.getPosition());
    }


    @Test
    public void shouldMoveForward5Times() {

        rover.command("MMMMM");

        assertEquals("0:5:N", rover.getPosition());
    }
    @Test
    public void shouldRotateLeft() {
        rover.command("L");
        assertEquals("0:0:W", rover.getPosition());
    }

    @Test
    public void shouldRotateLeftTwice() {
        rover.command("LL");
        assertEquals("0:0:S", rover.getPosition());
    }

    @Test
    public void shouldRotateLeftThreeTimes() {
        rover.command("LLL");
        assertEquals("0:0:E", rover.getPosition());
    }

    @Test
    public void shouldRotateLeft360() {
        rover.command("LLLL");
        assertEquals("0:0:N", rover.getPosition());
    }

    @Test
    public void shouldRotateRight() {
        rover.command("R");
        assertEquals("0:0:E", rover.getPosition());
    }



    @Test
    public void shouldRotateRightAndMove() {
        rover.command("RM");

        assertEquals("1:0:E", rover.getPosition());
    }

    @Test
    public void shouldRotateRightTwiceAndMove() {
        rover.command("RRM");

        assertEquals("0:-1:S", rover.getPosition());
    }

    @Test
    public void shouldRotateLeftAndRight() {
        rover.command("LR");

        assertEquals("0:0:N", rover.getPosition());
    }

    @Test
    public void shouldWrapAroundOnTheLeft() {
        rover.command("LM");

        assertEquals("255:0:W", rover.getPosition());
    }

}
