import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JECSprite implements DisplayableSprite, MovableSprite {

	Image image = null;
	
	public JECSprite() {
		super();

		if (image == null) {
			try {
				image = ImageIO.read(new File("res/abc/ABC-sprite.png"));
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}		
		}		
	}
	
}
