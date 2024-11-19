package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarsRoverTest {
    @Test
    public void should_initialise_mars_rover() {
        // given
        MarsRover rover = new MarsRover();
        // when
        String report = rover.showStatus();
        // then
        assertEquals("0:0:N", report);
    }

    @Test
    public void should_face_west_when_orient_north_and_turn_left() { //00N turn left
        // given
        MarsRover rover = new MarsRover();
        // when
        String response = rover.executeCommand("L");
        String report = rover.showStatus();
        // then
        assertEquals("0:0:W", response);
        assertEquals("0:0:W", report);
    }

    @Test
    public void should_face_south_when_orient_west_and_turn_left() { //00W turn left
        // given
        MarsRover rover = new MarsRover();
        // when
       rover.executeCommand("L");
        String response = rover.executeCommand("L");
        // then
        assertEquals("0:0:S", response);
    }

    @Test
    public void should_face_east_when_orient_south_and_turn_left() { //00S turn left
        // given
        MarsRover rover = new MarsRover();
        // when
        rover.executeCommand("L");
        rover.executeCommand("L");
        String response = rover.executeCommand("L");
        // then
        assertEquals("0:0:E", response);
    }

    @Test
    public void should_face_north_when_orient_east_and_turn_left() { //00E turn left
        // given
        MarsRover rover = new MarsRover();
        // when
        rover.executeCommand("L");
        rover.executeCommand("L");
        rover.executeCommand("L");
        String response = rover.executeCommand("L");
        // then
        assertEquals("0:0:N", response);
    }

    @Test
    public void should_face_east_when_orient_north_and_turn_right() { //    00N turn right
        // given
        MarsRover rover = new MarsRover();
        // when
        String response = rover.executeCommand("R");
        // then
        assertEquals("0:0:E", response);
    }

    @Test
    public void should_face_south_when_orient_east_and_turn_right() { //    00 E turn right
        // given
        MarsRover rover = new MarsRover();
        // when
        rover.executeCommand("R");
        String response = rover.executeCommand("R");
        // then
        assertEquals("0:0:S", response);
    }

    @Test
    public void should_face_west_when_orient_south_and_turn_right() { //    00 S turn right
        // given
        MarsRover rover = new MarsRover();
        // when
        rover.executeCommand("R");
        rover.executeCommand("R");
        String response = rover.executeCommand("R");
        // then
        assertEquals("0:0:W", response);
    }

    @Test
    public void should_face_north_when_orient_west_and_turn_right() { //00W turn right
        // given
        MarsRover rover = new MarsRover();
        // when
        rover.executeCommand("L");
        String response = rover.executeCommand("R");
        // then
        assertEquals("0:0:N", response);
    }


    @Test
    public void should_move_forward_when_orient_north() { //    move forward from 00N to 01N
        // given
        MarsRover rover = new MarsRover();
        // when
        String response = rover.executeCommand("M");
        // then
        assertEquals("0:1:N", response);
    }

    @Test
    public void should_move_forward_when_orient_east() { //    move forward from 00E to 10E
        // given
        MarsRover rover = new MarsRover();
        rover.executeCommand("R");
        // when
        String response = rover.executeCommand("M");
        // then
        assertEquals("1:0:E", response);
    }

    @Test
    public void should_move_forward_when_orient_south() { //    move forward from 00S to 0-1S
        // given
        MarsRover rover = new MarsRover();
        rover.executeCommand("R");
        rover.executeCommand("R");
        // when
        String response = rover.executeCommand("M");
        // then
        assertEquals("0:-1:S", response);
    }




}

