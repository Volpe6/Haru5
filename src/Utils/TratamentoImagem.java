/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Andrew, Viviane
 */
public class TratamentoImagem {
    
    public TratamentoImagem() {}
    
     
    /**
     * Converte icon em image
     * 
     * @return image 
     */
    public static Image convertrIconImagem(Icon icon) {
        
        if (icon.getClass() == ImageIcon.class) {
           return ((ImageIcon)icon).getImage();
        } 
        else {
           int w = icon.getIconWidth();
           int h = icon.getIconHeight();
           GraphicsEnvironment   ge    = GraphicsEnvironment.getLocalGraphicsEnvironment();
           GraphicsDevice        gd    = ge.getDefaultScreenDevice();
           GraphicsConfiguration gc    = gd.getDefaultConfiguration();
           BufferedImage         image = gc.createCompatibleImage(w, h);
//           Graphics2D            g     = image.createGraphics();
//           icon.paintIcon(null, g, 0, 0);
//           g.dispose();
           return image;
        }
 
    }
    
    /**
     * Redimensiona a imagem passada
     * 
     * @param oImagem - Icon a ser redimensionado
     * @param iComp   - comprimento
     * @param iAlt    - altura
     * @return Icon
     */
    public static Icon redimensionaImagem(Icon oImagem, int iComp, int iAlt) {
        ImageIcon oImgIcon = new ImageIcon(convertrIconImagem(oImagem));
        oImgIcon.setImage(oImgIcon.getImage().getScaledInstance(iComp, iAlt, 0));
        
        return oImgIcon;
    }
    
    /**
     * Redimensiona a imagem passada
     * 
     * @param oImagem - Image a ser redimensionado
     * @param iComp   - comprimento
     * @param iAlt    - altura
     * @return Icon
     */
    public static Image redimensionaImagem(Image oImagem, int iComp, int iAlt) {
        ImageIcon oImgIcon = new ImageIcon(oImagem);
        oImgIcon.setImage(oImgIcon.getImage().getScaledInstance(iComp, iAlt, 0));
        
        return oImgIcon.getImage();
    }
    
    @Deprecated
    public static Image rotacionarImagem(Image oImagem) {
//         GraphicsEnvironment   ge    = GraphicsEnvironment.getLocalGraphicsEnvironment();
//           GraphicsDevice        gd    = ge.getDefaultScreenDevice();
//           GraphicsConfiguration gc    = gd.getDefaultConfiguration();
//        BufferedImage image = gc.createCompatibleImage(oImagem.getWidth(null), oImagem.getHeight(null));
//        Graphics2D g2d = image.createGraphics();
//        g2d.rotate(50);
        BufferedImage oImg = new BufferedImage(oImagem.getWidth(null), oImagem.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g2D = img.createGraphics();
//        g2D.rotate(50);
        int width = oImg.getWidth();
        int heigth = oImg.getHeight();

        BufferedImage oRotate = new BufferedImage(width, heigth, oImg.getType());
        
        for(int y = 0; y < heigth; y++) {
            for(int x = 0; x < width; x++) {
                oRotate.setRGB((width -1) - x, (heigth - 1) - y, oImg.getRGB(x, y));
            }
        }

        return new ImageIcon(oRotate).getImage();
    }
}
