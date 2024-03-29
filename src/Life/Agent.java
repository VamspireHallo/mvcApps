package Life;

import CALab.*;

import java.awt.*;
import java.util.Random;
import java.util.Set;

public class Agent extends Cell
{
    int status = 0;
    int ambience = 8;

    Set<Integer> isReborn = Society.rebirth;
    Set<Integer> isDead = Society.death;


    @Override
    public void observe() { //updates the ambience
        ambience = 0;
        for (Cell a : neighbors) {
            if (((Agent) a).getStatus() == 1) {
                ambience++;
            }
        }
    }

    @Override
    public void interact()
    {

    }

    @Override
    public void update() // if cell is alive with 0 1 4 5 6 7 8 neighbors it becomes dead. if dead with 2 or 3 becomes alive
    {
        if (isDead.contains(ambience) && status == 1 )
        {
            status = 0;
        }
        if (isReborn.contains(ambience) && status == 0 )
        {
            status = 1;
        }
    }

    @Override
    public void nextState()
    {
        if (status == 0)
        {
            status = 1;
        }
        else
        {
            status = 0;
        }

    }
    public void setStatus(int stat)
    {
        status = stat;
    }

    @Override
    public void reset(boolean randomly)
    {
        if (randomly == true)
        {
            Random random = new Random();
            int randomNumber = random.nextInt(2);
            status = randomNumber;
        }
        if (randomly == false){
            status = 0;
        }
    }

    @Override
    public int getAmbience()
    {
        observe();
        return ambience;
    }

    @Override
    public Color getColor() { // should be red if cell is dead and green if cell is alive
        if (status == 0)
        {
            return Color.RED;
        }
        else if (status == 1)
        {
            return Color.GREEN;
        }
        else
        {
            return Color.BLACK;
        }
    }

    @Override
    public int getStatus() { //0 = dead cell which should be red. 1 = live cell which should be green
        return status;
    }
}
