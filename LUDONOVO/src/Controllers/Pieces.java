package Controllers;

import java.awt.*;
import java.awt.geom.*;

public class Pieces  extends Ellipse2D  {

	public int posX;
	public int posY;
	public int size;
	public Color color;
	public int house;
	public boolean estaNaRetaFinal;
	public boolean isInGame = false;
	
	public Pieces() {
		
		this.color = Color.BLACK;
		this.isInGame = false;
		
	}

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return posX; 
	}


	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return posY;
	}


	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return size;
	}


	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return size;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void setFrame(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		
	}
	
}
