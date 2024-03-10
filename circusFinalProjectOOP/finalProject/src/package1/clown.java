/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package package1;

/**
 *
 * @author LENOVO
 */
public class clown extends ImageObject{
    private String name = "clown";
    public clown(int posX, int posY, String path) {
        super(posX, posY, path);
    }

    @Override
    public String getName() {
        return name;
    }

    public clown(int posX, int posY, String path, int type) {
        super(posX, posY, path, type);
    }
    
    @Override
    public void setY(int my)
    {
        
    }
    

    
    
}
