package package2;

import java.util.LinkedList;
import java.util.List;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.util.ArrayList;
import java.util.Stack;
import package1.ImageObject;
import package1.*;

public class Circus implements World{
        private int x ;
	private static int MAX_TIME = 1 * 60 * 1000;	
	private int score = 0;
	private long startTime = System.currentTimeMillis();
	private final int width;
	private final int height;
	private  final ArrayList<GameObject> constant = new ArrayList<GameObject>();
	private  final ArrayList<GameObject> moving = new ArrayList<GameObject>();
	public  final ArrayList<GameObject> control = new ArrayList<GameObject>();  
        private clown clown;
        private Stack<plate> stack1 = new Stack<>();
        private Stack<plate> stack2 = new Stack<>();
        private final int speed;

    public clown getClown() {
        return clown;
    }
        
        
       
	public Circus(int screenWidth, int screenHeight, int speed) {
                
                this.speed=speed;
		width = 1000;
		height = 750;
                this.clown = new clown(screenWidth/3, (int)(screenHeight*0.79), "/clown2.png");
		control.add(this.clown);
                x= control.get(0).getY();
                
		for(int i=0; i<10; i++){
			moving.add(new plate((int)(Math.random() * width), -1 * (int)(Math.random() * height/3), "/plate1small.png",0,this));
                        moving.add(new plate((int)(Math.random() * width), -1 * (int)(Math.random() * height/3), "/plate2small.png",1,this));
                        
                }
                for(int i=0; i<1; i++){
                        moving.add(new ball((int)(Math.random() * width), -1 * (int)(Math.random() * height/3), "/bomba.png",this));
                    
                }
                

                constant.add(new ImageObject(0,0,"/circus2.png"));
	}
	private boolean intersect(GameObject o1, GameObject o2){
                if(((ImageObject)o1).getName().equals("plate"))
                {
                    boolean x = (o1.getX()+o1.getWidth() > o2.getX()) && (o1.getX() < o2.getX()+50); 
                    boolean y = (o1.getX()+o1.getWidth() > o2.getX()+o2.getWidth()-50) && (o1.getX() < o2.getX()+o2.getWidth());
                    boolean z = o1.getY()+o1.getHeight() == this.x;
                    return ((x && z) || (y&&z));
                }
                else
                {
                    boolean x = (o1.getX() + o1.getWidth() <= o2.getX()+o2.getWidth() ) && (o1.getX()+o1.getWidth() >= clown.getX());
                    boolean y = (o1.getX() >= o2.getX() ) && (o1.getX()+o1.getWidth() <= o2.getX()+o2.getWidth());
                    boolean z = (o1.getX() > o2.getX() ) && (o1.getX() < o2.getX()+o2.getWidth());
                    boolean high = (o1.getY() >= 700-192)  &&  (o1.getY() <=700);
                    if((x&&high) || (y&&high) || (z&&high))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
	}
	@Override
        
 

 public boolean refresh() {
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME; 

        
        for (GameObject m : moving) {
        
        if(((ImageObject)m).getName().equals("plate"))
        {
            
            if (!intersect(m, clown)) {
                if (!control.contains(m)) {
                    m.setY((m.getY() + 1));
                    if (m.getY() == getHeight()) {
                        m.setY(-1 * (int) (Math.random() * getHeight()));
                        m.setX((int) (Math.random() * getWidth()));
                    }
                    m.setX(m.getX() + (Math.random() > 0.5 ? 1 : -1));
                    if (!timeout && intersect(m, clown)) {
                        if ((clown.getX()+(clown.getWidth()/2)) < m.getX()) {
                            stack2.push((plate) m);
                            
                        } else {
                            
                            stack1.push((plate) m);
                            
                        }

                       
                    }
                } else {
                    
                    
                    if(stack1.contains(m))
                    {
                        m.setX(clown.getX());
                        
                        
                    }else{
                        
                        m.setX(clown.getX()+clown.getWidth()-40);
                    }
                    
                    
                }
            } else {
                control.add(m);
                x -= m.getHeight();
                
                if(stack1.size() >= 3)
                {
                    if(stack1.get(stack1.size()-1).getColor() == stack1.get(stack1.size()-2).getColor() && stack1.get(stack1.size()-1).getColor() == stack1.get(stack1.size()-3).getColor())
                    {
                        score +=1;
                        plate p1 = stack1.pop();
                        plate p2 = stack1.pop();
                        plate p3 = stack1.pop();
                        control.remove(p1);
                        control.remove(p2);
                        control.remove(p3);
                        x= x+p1.getHeight()+p2.getHeight()+p3.getHeight();
                        
                        
                        p1.setX((int)(Math.random() * width));
                        p1.setY(-1 * (int)(Math.random() * height/3));
                        p2.setX((int)(Math.random() * width));
                        p2.setY(-1 * (int)(Math.random() * height/3));
                        p3.setX((int)(Math.random() * width));
                        p3.setY(-1 * (int)(Math.random() * height/3));
                        
                        
                        
                    }
                }
                
                
                if(stack2.size() >= 3)
                {
                    if(stack2.get(stack2.size()-1).getColor() == stack2.get(stack2.size()-2).getColor() && stack2.get(stack2.size()-1).getColor() == stack2.get(stack2.size()-3).getColor())
                    {
                        score +=1;
                        plate p1 = stack2.pop();
                        plate p2 = stack2.pop();
                        plate p3 = stack2.pop();
                        control.remove(p1);
                        control.remove(p2);
                        control.remove(p3);
                        x= x+p1.getHeight()+p2.getHeight()+p3.getHeight();
                        
                        p1.setX((int)(Math.random() * width));
                        p1.setY(-1 * (int)(Math.random() * height/3));
                        p2.setX((int)(Math.random() * width));
                        p2.setY(-1 * (int)(Math.random() * height/3));
                        p3.setX((int)(Math.random() * width));
                        p3.setY(-1 * (int)(Math.random() * height/3));
                        
                        
                        
                    }
                }
                

            }
        
        }
        else
        {
            
            m.setY((m.getY() + speed));
            if (m.getY() >= getHeight()) {
                m.setY(-1 * (int) (Math.random() * getHeight()));
                m.setX((int) (Math.random() * getWidth()));
            }
            m.setX(m.getX() + (Math.random() > 0.5 ? 1 : -1));
            if(intersect(m,this.clown))
            {
                score-=1;
                m.setX((int)(Math.random() * width));
                m.setY(-1 * (int)(Math.random() * height/3));
                while(stack1.size()>0)
                {
                    plate p = stack1.pop();
                    control.remove(p);
                    p.setX((int)(Math.random() * width));
                    p.setY(-1 * (int)(Math.random() * height/3));
                    x= x+p.getHeight();
                }
                while(stack2.size()>0) 
                {
                    plate p = stack2.pop();
                    control.remove(p);
                    p.setX((int)(Math.random() * width));
                    p.setY(-1 * (int)(Math.random() * height/3));
                    x= x+p.getHeight();
                }
                
            }
        }
            }
        
            
        


        return !timeout;
    }
 
	@Override
	public int getSpeed() {	
		return 10; 
	}
	@Override
	public int getControlSpeed() {	
		return 20;  
	}
	@Override
	public List<GameObject> getConstantObjects() {	
		return constant;	
	}
	@Override
	public List<GameObject> getMovableObjects() {	
		return moving;	
	}
	@Override
	public List<GameObject> getControlableObjects() {	
		return control;	
	}
	@Override
	public int getWidth() {	
		return width; 
	}
	@Override
	public int getHeight() { 
		return height; 
	}
	@Override
	public String getStatus() {
		return "Score=" + score + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis()-startTime))/1000);	// update status
	}
}