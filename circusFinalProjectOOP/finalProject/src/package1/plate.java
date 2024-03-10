/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package package1;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import package2.*;

/**
 *
 * @author LENOVO
 */
enum Color {
    RED,
    BLUE;
}
public class plate extends ImageObject{

    private Color color;
    private String name ="plate";

    @Override
    public String getName() {
        return name;
    }

    public int getColor() {
        if(this.color.equals(Color.BLUE))
        {
            return 0;
        }else
        {
            return 1;
        }
    }
    Circus c ;
    public plate(int posX, int posY, String path, int color, Circus c) {
        super(posX, posY, path);
        if(color == 0 )
        {
        this.color = Color.BLUE;
        }
        else
        {
            this.color = Color.RED;
        }
        
        this.c = c;
        
    }

    public plate(int posX, int posY, String path, int type, int color, Circus c) {
        super(posX, posY, path, type);
        if(color == 0 )
        {
        this.color = Color.BLUE;
        }
        else
        {
            this.color = Color.RED;
        }
        this.c = c;
    }
    
    @Override
    public void setY(int mY)
    {
        int flag = 0;
        for (GameObject m : this.c.getControlableObjects())
        {
            if(m.equals(this))
            {
                flag=1;
            }
        }
        if(flag==1)
        {
            
        }else
        {
            super.setY(mY);
        }
    }
    
    @Override
    public void setX(int mX)
    {
        
        
        int flag = 0;
        for (GameObject m : this.c.getControlableObjects())
        {
            if(m.equals(this))
            {
                flag=1;
            }
        }
        if(flag==1)
        {
            if(this.c.getClown().getX()==0 || this.c.getClown().getX()==(1000-192))
            {
                
            }else
            {
                super.setX(mX);
            }
        }else
        {
            super.setX(mX);
        }
    }
    

    



}
