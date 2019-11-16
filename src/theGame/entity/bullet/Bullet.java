package theGame.entity.bullet;

public class Bullet extends Sprite {
    private final int bulletSpeed; // toc do dan bay
    private final int damage; // sat thuong cua dan
    private int target_x;
    private int target_y;
    private double alpha;
    private int direction;
    
    public Bullet(int x, int y, int bulletSpeed, int damage, int target_x, int target_y) {
        super(x, y);
        this.bulletSpeed = bulletSpeed;
        this.damage = damage;
        this.target_x = target_x;
        this.target_y = target_y;
        if (this.target_x != this.x) {
        	alpha =  ((this.target_y - this.y)/(this.target_x - this.x));
        }
        setDirection();
        initBullet();
    }
    
    private void initBullet() {   
        loadImage("src/icon/Bullet/bullet1.png");        
    }
    
    private void setDirection() {
    	if (alpha > 0) {
    		if (this.x > this.target_x) {
    			direction = 1;
    			return;
    		}
    		else {
    			direction = 2;
    			return;
    		}
    	}
    	if (alpha < 0) {
    		if (this.x > this.target_x) {
    			direction = 3;
    			return;
    		}
    		else {
    			direction = 4;
    			return;
    		}
    	}
    	if (this.target_x == this.x) {
    		if (this.y > this.target_y) {
    			direction = 7;
    			return;
    		}
    		else {
    			direction = 8;
    			return;
    		}
    	}
    	if (alpha == 0) {
    		if (this.x > this.target_x) {
    			direction = 5;
    			return;
    		}
    		else {
    			direction = 6;
    			return;
    		}
    	}
    }

    public void move() {
    	if (direction == 1) {
    		x = x - this.bulletSpeed;
    		y = y - (int) (alpha * this.bulletSpeed);
    		return;
    	}
    	if (direction == 2) {
    		x = x + this.bulletSpeed;
    		y = y + (int) (alpha * this.bulletSpeed);
    		return;
    	}
    	if (direction == 3) {
    		x = x - this.bulletSpeed;
    		y = y + (int) (-alpha * this.bulletSpeed);
    		return;
    	}
    	if (direction == 4) {
    		x = x + this.bulletSpeed;
    		y = y - (int) (-alpha * this.bulletSpeed);
    		return;
    	}
    	if (direction == 5) {
    		x = x - this.bulletSpeed * 2;
    		return;
    	}
    	if (direction == 6) {
    		x = x + this.bulletSpeed * 2;
    		return;
    	}
    	if (direction == 7) {
    		y = y - this.bulletSpeed * 2;
    		return;
    	}
    	if (direction == 8) {
    		y = y + this.bulletSpeed * 2;
    	}
    }
    
    public void checkVisible() {
    	if (this.x < 0 || this.y < 0 || this.y > 720 || this.x > 1000) this.visible = false;  	
    }
}
