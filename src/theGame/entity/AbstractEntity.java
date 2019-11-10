package theGame.entity;

public abstract class AbstractEntity implements GameEntity {
	private int posX;
	private int posY;
	private int width;
	private int height;

	protected AbstractEntity(int posX, int posY, int width, int height) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
	}

	@Override
	public final int getPosX() {
		return posX;
	}

	protected final void setPosX(int posX) {
		this.posX = posX;
	}

	@Override
	public final int getPosY() {
		return posY;
	}

	protected final void setPosY(int posY) {
		this.posY = posY;
	}

	protected final void setHeight(int height) {
		this.height = height;
	}

}
