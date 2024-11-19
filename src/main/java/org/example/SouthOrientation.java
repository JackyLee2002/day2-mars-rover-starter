package org.example;

public class SouthOrientation implements Orientation {
    @Override
    public Direction getDirection() {
        return Direction.S;
    }

    @Override
    public Orientation turnLeft() {
        return new EastOrientation();
    }

    @Override
    public Orientation turnRight() {
        return new WestOrientation();
    }

    @Override
    public void move(MarsRover rover) {
        rover.setY(rover.getY() - 1);
    }
}
