package Life;

import CALab.*;

import java.awt.*;

public class Agent extends Cell
{
    int status = 0;
    int ambience = 8;

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
        if (((ambience <= 8 && ambience >= 4) || (ambience == 1) || ambience == 0) && status == 1 )
        {
            status = 0;
        }
        if ((ambience == 1 || ambience == 2) && status == 0 )
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
            getColor();
        }
        if (status == 1)
        {
            status = 0;
            getColor();
        }

    }

    @Override
    public void reset(boolean randomly)
    {
        if (randomly == true)
        {
            status = 1;
        }
        if (randomly == false){
            status = 0;
        }
    }

    @Override
    public int getAmbience() {
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
            return null;
        }
    }

    @Override
    public int getStatus() { //0 = dead cell which should be red. 1 = live cell which should be green
        return status;
    }
}
