package cl.samtech.ot.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Imagen {
    //Ancho máximo
    public static int MAX_WIDTH=800;
    //Alto máximo
    public static int MAX_HEIGHT=800;
    
	public Imagen() {
		
		
    }
     
    public static BufferedImage loadImage(InputStream archivo) {
        BufferedImage bimage = null;
        try {
            bimage = ImageIO.read(archivo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bimage;
    }
    
    public static void saveImage(BufferedImage bufferedImage, String pathName) {
        try {
            String format = (pathName.endsWith(".png")) ? "png" : "jpg";
            File file =new File(pathName);
            file.getParentFile().mkdirs();
            ImageIO.write(bufferedImage, format, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }
    
    public static void copyImage(InputStream archivo, String copyPath) {
        BufferedImage bimage = loadImage(archivo);
        if(bimage.getHeight()>bimage.getWidth()){
            int heigt = (bimage.getHeight() * MAX_WIDTH) / bimage.getWidth();
            bimage = resize(bimage, MAX_WIDTH, heigt);
            int width = (bimage.getWidth() * MAX_HEIGHT) / bimage.getHeight();
            bimage = resize(bimage, width, MAX_HEIGHT);
        }else{
        	if(bimage.getWidth() < MAX_WIDTH){
        	
        		bimage = resize(bimage, bimage.getWidth() ,  bimage.getHeight());

        	}else{
        		int width = (bimage.getWidth() * MAX_HEIGHT) / bimage.getHeight();
	            bimage = resize(bimage, width, MAX_HEIGHT);
	            int heigt = (bimage.getHeight() * MAX_WIDTH) / bimage.getWidth();
	            bimage = resize(bimage, MAX_WIDTH, heigt);
        	}
        }
        saveImage(bimage, copyPath);
    }
}
