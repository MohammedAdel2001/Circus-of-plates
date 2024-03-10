/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package package1;

import package2.Circus;

/**
 *
 * @author LENOVO
 */
public class ball extends ImageObject {
    
    private Circus c;
    private String name = "ball";
    public ball(int posX, int posY, String path, int type, Circus c) {
        super(posX, posY, path, type);
        this.c = c;
    }

    public ball(int posX, int posY, String path, Circus c) {
        super(posX, posY, path);
        this.c = c;
    }

    @Override
    public String getName() {
        return name;
    }
    

    
}
