package theGame.entity.bullet;

public class Bullet extends Sprite {
    private final int bulletSpeed; // toc do dan bay
    private final int damage; // sat thuong cua dan
    private int target_x;
    private int target_y;
    private int alpha;
    private int direction;
    
    public Bullet(int x, int y, int bulletSpeed, int damage, int target_x, int target_y) {
        super(x, y);
        this.bulletSpeed = bulletSpeed;
        this.damage = damage;
        this.target_x = target_x;
        this.target_y = target_y;
        if (this.target_x != this.x) {
        	alpha = (int) ((this.target_y - this.y)/(this.target_x - this.x));
        }
        setDirection();
        initBullet();
    }
    
    private void initBullet() {   
        loadImage("src/icon/Bullet/bullet1.png");
        //getImageDimensions();        
    }
    
    private void setDirection() {
    	if (this.x < this.target_x) {
    		if (this.target_y != this.y) {
    			direction = 2;
    			
    			return;
    		}
    		else {
    			direction = 1;
    			return;
    		}
    	}
    	if (this.target_x == this.x) {
    		if (this.y < this.target_y) {
    			direction = 3;
    			return;
    		}
    		else {
    			direction = 4;
    			return;
    		}
    	}
    	if (this.x > this.target_x) {
    		if (this.target_y != this.y) {
    			direction = 5;
    			return;
    		}
    		else {
    			direction = 6;
    		}
    	}    	
    }

    public void move() {
    	// bo sung chieu chuyen dong
    	if (direction == 1) {
    		this.x += this.bulletSpeed;
    		return;
    	}
    	if (direction == 2) {
    		this.x += this.bulletSpeed;
    		this.y += alpha * this.bulletSpeed;
    		return;
    	}
    	if (direction == 3) {
    		this.y += this.bulletSpeed;
    		return;
    	}
    	if (direction == 4) {
    		this.y -= this.bulletSpeed;
    		return;
    	}
    	if (direction == 5) {
    		this.x -= this.bulletSpeed;
    		this.y += alpha * this.bulletSpeed;
    		return;
    	}
    	if (direction == 6) {
    		this.x -= this.bulletSpeed;	
    		return;
    	}
    }
    
    public void checkVisible() {
    	if (this.x < 0 || this.y < 0 || this.y > 720 || this.x > 1000) this.visible = false;  	
    }
}
