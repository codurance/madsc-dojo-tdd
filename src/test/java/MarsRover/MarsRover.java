package MarsRover;

import java.util.Map;

public class MarsRover {
    private  interface Command{
         int getX(int currentX);
         int getY(int currentY);
    }
    private static class NorthCommand implements Command{

        @Override
        public int getX(int currentX) {
            return currentX;
        }

        @Override
        public int getY(int currentY) {
            return currentY+1;
        }
    }
    private Map<String, Command> directionToCommand = Map.of("N", new NorthCommand());
    public static final int MAX_DIRECTIONS = 4;
    public static final int MAX_X_COORD = 255;
    public static final int MIN_X_COORD = 0;
    public static final int MIN_Y_COORD = 0;
    String[] directions = new String[]{"N", "W", "S", "E"};
    String position = "0:0:N";
    int xCoord = MIN_X_COORD;
    int yCoord = MIN_Y_COORD;
    int direction = 0;

    public String getPosition() {

        return this.xCoord + ":" + this.yCoord + ":" + getDirection();
    }

    private String getDirection() {
        return this.directions[this.direction];
    }

    public void command(String m) {
        String[] individualCommands = m.split("");
        for (String command : individualCommands) {
            if (command.equals("L"))
                this.direction = rotateLeft();
            else if (command.equals("R"))
                this.direction = rotateRight();
            else moveForward();
        }
    }

    private void moveForward() {
        if (getDirection().equals("W"))
            this.xCoord -= 1;
        else if(getDirection().equals("E"))
            this.xCoord ++;
        else if(getDirection().equals("S"))
            this.yCoord--;
        else{
            Command command = directionToCommand.get(getDirection());
            this.xCoord = command.getX(this.xCoord);
            this.yCoord= command.getY(this.yCoord);
        }

        if (xCoord < MIN_X_COORD)
            xCoord = MAX_X_COORD;
    }

    private int rotateLeft() {
        return (this.direction + 1) % MAX_DIRECTIONS;
    }

    private int rotateRight() {
        return (this.direction + MAX_DIRECTIONS - 1) % MAX_DIRECTIONS;
    }

}
