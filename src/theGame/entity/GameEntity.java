package theGame.entity;

public interface GameEntity {
	// hien thi do hoa
	void graphic();
	
	// cap nhat trang thai cho cac doi tuong dong
	void update();
	
	// vi tri cua doi tuong
	int getPosX();

	int getPosY();


}
