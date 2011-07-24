package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Maquina extends Figura {

    private int base;
    private int ptsX [] = new int [3];
    private int ptsY [] = new int [3];
    private Polygon triangulo = new Polygon();
    
    public Maquina(Point posicion, int base) {
        this.posicion = posicion;
        this.base = base;
        this.seleccionada = false;
    }

    public void setBase(int base) {
        this.base = base;
    }   

    public int getBase() {
        return base;
    }

    @Override
    public boolean dentroFigura(Point p) {
        int difX = Math.abs(p.x - (posicion.x + (base / 2)));
        int difY = Math.abs(p.y - (posicion.y + (base / 2)));
        return ((difX < base / 2) && (difY < base / 2));
    }

    @Override
    public void dibujar(Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(this.getX(), this.getY(), this.getBase(), this.getBase());
         
        ptsX[0] = this.getX();
        ptsY[0] = this.getY() + this.getBase();
        
        ptsX[1] = this.getX() + (this.getBase() / 2);
        ptsY[1] = this.getY() + (this.getBase() + (this.getBase()/2));
        
        ptsX[2] = this.getX() + this.getBase();      
        ptsY[2] = this.getY() + this.getBase();        
        
        triangulo = new Polygon(ptsX, ptsY, 3);
        g.fillPolygon(triangulo);
		        
        if (this.getSeleccionada()) {
            g.setColor(Color.RED);
            g.drawRect(this.getX() + 7, this.getY() + 7, this.getBase() - 20, this.getBase() - 20);
        }
    }
}
