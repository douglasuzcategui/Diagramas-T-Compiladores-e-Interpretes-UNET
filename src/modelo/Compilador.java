
package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;



public class Compilador extends Figura {
    
    private int baseRect;
    private int altoRect;
    private int ladoCuad;

    public Compilador(int baseRect, int altoRect, int ladoCuad, Point posicion) {
        this.baseRect = baseRect;
        this.altoRect = altoRect;
        this.ladoCuad = ladoCuad;
        this.posicion = posicion;
    }
    
    

    public int getAltoRect() {
        return altoRect;
    }

    public void setAltoRect(int altoRect) {
        this.altoRect = altoRect;
    }

    public int getBaseRect() {
        return baseRect;
    }

    public void setBaseRect(int baseRect) {
        this.baseRect = baseRect;
    }

    public int getLadoCuad() {
        return ladoCuad;
    }

    public void setLadoCuad(int ladoCuad) {
        this.ladoCuad = ladoCuad;
    }
    
    

    @Override
    public boolean dentroFigura(Point p) {
        int difX=Math.abs(p.x-(posicion.x+(baseRect/2)));
		int difY=Math.abs(p.y-(posicion.y+(baseRect/2)));
		return ( (difX<baseRect/2) && (difY<baseRect/2)); 
    }

    @Override
    public void dibujar(Graphics g) {
        
        g.setColor(Color.ORANGE);
        
        g.fillRect(this.getX(), this.getY(), baseRect, altoRect);
        g.fillRect(this.getX()+(int)((baseRect/2)-(ladoCuad/2)), this.getY()+altoRect, ladoCuad, ladoCuad);
        
        if (this.getSeleccionada()) {
            g.setColor(Color.RED);
            g.drawRect(this.getX() + 7, this.getY() + 7, this.getBaseRect() - 20, this.getBaseRect() - 50);
        }
        
    }
    
}
