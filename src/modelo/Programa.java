
package modelo;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;


public class Programa extends Figura{
    
    private int radio;
    private int base;
    
    public Programa(Point posicion, int radio, int base){
        this.radio = radio;
        this.base = base;
        this.posicion = posicion;
        this.seleccionada = false;
    }
    
    public void setRadio(int radio){
        this.radio = radio;
    }
    
    public int getRadio(){
        return radio;
    }
    
    public void setBase(int base){
        this.base = base;
    }
    
    public int getBase(){
        return base;
    }
    
    @Override
    public boolean dentroFigura(Point p) {
        int difX = Math.abs(p.x - (posicion.x + (radio / 2)));
        int difY = Math.abs(p.y - (posicion.y + (radio / 2)));
        return ((difX < radio / 2) && (difY < radio / 2));
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(this.getX(),this.getY(), this.getRadio(),this.getRadio());
        
        g.fillRect(this.getX()+6, this.getY()+20, this.getBase(), this.getBase()+20);
        
        if (this.getSeleccionada()) {
            g.setColor(Color.RED);
            g.drawRect(this.getX() + 7, this.getY() + 7, this.getRadio() - 20, this.getRadio() - 20);
        }
    }
    
}
