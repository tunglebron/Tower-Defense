package theGame.entity.NonMoving;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Road {
	private int x;
	private int y;
	
	public Road(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public static Image loadImage() {
        ImageIcon ii = new ImageIcon("src/icon/sand.jpg");
        Image image = ii.getImage();
        return image;
	}
		
}
