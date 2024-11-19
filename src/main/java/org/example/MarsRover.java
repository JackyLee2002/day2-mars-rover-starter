package org.example;

public class MarsRover {
    private Orientation orientation;
    private int x;
    private int y;

    MarsRover() {
        this.orientation = new NorthOrientation();
        this.x = 0;
        this.y = 0;
    }

    public String showStatus() {
        return String.format("%d:%d:%s", x, y, orientation.getDirection());
    }

//    add getter and setter for x and y
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void executeCommand(String command) {
        if (command.equals("L")) {
            orientation = orientation.turnLeft();
        }
        if (command.equals("R")) {
            orientation = orientation.turnRight();
        }
        if (command.equals("M")) {
            orientation.moveForward(this);
        }
        if (command.equals("B")) {
            orientation.moveBackward(this);
        }
    }

    public String parseCommands(String command) {
        String[] commands = command.split(";");
        for (String c : commands) {
            executeCommand(c);
        }
        return showStatus();
    }
}
