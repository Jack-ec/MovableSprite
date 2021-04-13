import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JECSprite implements DisplayableSprite, MovableSprite {
	
	private static Image upImage;
	private static Image downImage;
	private static Image leftImage;
	private static Image rightImage;
	private static Image image;
	private double centerX = 0;
	private double centerY = 0;
	private double width = 50;
	private double height = 50;
	private double velocityX = 0;
	private double velocityY = 0;
	
	public JECSprite() {
		super();

		if (upImage == null) {
			try {
				upImage = ImageIO.read(new File("res/JEC/upimage.png"));
				downImage = ImageIO.read(new File("res/JEC/downimage.png"));
				leftImage = ImageIO.read(new File("res/JEC/leftimage.png"));
				rightImage = ImageIO.read(new File("res/JEC/rightimage.png"));
				image = ImageIO.read(new File("res/JEC/image.png"));

			}
			catch (IOException e) {
				System.out.println(e.toString());
			}		
		}		
	}

	@Override
	public void setCenterX(double centerX) {
		this.centerX = centerX;
		
	}

	@Override
	public void setCenterY(double centerY) {
		this.centerY = centerY;
		
	}

	@Override
	public void moveX(double pixelsPerSecond) {
		this.velocityX = pixelsPerSecond;
		
	}

	@Override
	public void moveY(double pixelsPerSecond) {
		this.velocityY = pixelsPerSecond;
		
	}

	@Override
	public void stop() {
		this.velocityX = 0;
		this.velocityX = 0;
		
	}

	@Override
	public Image getImage() {
		if (velocityX > 0) {
			return rightImage;
		}
		if (velocityX < 0) {
			return leftImage;
		}
		if (velocityY > 0) {
			return downImage;
		}
		if (velocityY < 0)
			return upImage;
		else {
			return image;
		}
	}

	@Override
	public boolean getVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public double getMinX() {
		// TODO Auto-generated method stub
		return centerX - (width / 2);
	}

	@Override
	public double getMaxX() {
		// TODO Auto-generated method stub
		return centerX + (width / 2);
	}

	@Override
	public double getMinY() {
		// TODO Auto-generated method stub
		return centerY - (width / 2);
	}

	@Override
	public double getMaxY() {
		// TODO Auto-generated method stub
		return centerY + (width / 2);
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public double getCenterX() {
		// TODO Auto-generated method stub
		return centerX;
	}

	@Override
	public double getCenterY() {
		// TODO Auto-generated method stub
		return centerY;
	}

	@Override
	public boolean getDispose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(Universe universe, KeyboardInput keyboard, long actual_delta_time) {
		double distanceX = this.velocityX * actual_delta_time * 0.001;
		double distanceY = this.velocityY * actual_delta_time * 0.001;
		
		this.centerX += distanceX;
		this.centerY += distanceY;
	}
	
}
