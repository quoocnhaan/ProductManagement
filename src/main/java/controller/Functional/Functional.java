/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Functional;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author LENOVO
 */
public class Functional {

    public static ImageIcon scaleImg(JLabel jLabel, String url) {
        ImageIcon imageIcon = new ImageIcon(Functional.class.getResource(url));
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        return scaledIcon;
    }

    public static ImageIcon scaleImg(JLabel jLabel, ImageIcon icon) {
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        return scaledIcon;
    }

    public static ImageIcon scaleImg(JButton jButton, ImageIcon icon) {
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        return scaledIcon;
    }

    public static byte[] convertIconToByteArray(ImageIcon icon) throws IOException {
        // Step 1: Get the Image from the ImageIcon
        Image img = icon.getImage();

        // Step 2: Convert the Image to BufferedImage
        BufferedImage bufferedImage = new BufferedImage(
                img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        bufferedImage.getGraphics().drawImage(img, 0, 0, null);

        // Step 3: Write the BufferedImage to a ByteArrayOutputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos); // You can choose "jpg" or another format

        // Step 4: Get the byte array from the ByteArrayOutputStream
        return baos.toByteArray();
    }

    public static ImageIcon convertByteArrayToIcon(byte[] byteArray) {
        if (byteArray != null && byteArray.length > 0) {
            try {
                InputStream is = new ByteArrayInputStream(byteArray);
                BufferedImage bufferedImage = ImageIO.read(is);
                if (bufferedImage != null) {
                    return new ImageIcon(bufferedImage);
                } else {
                    System.out.println("Không thể tạo ImageIcon từ byte array.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Byte array rỗng hoặc null.");
        }
        return null;  // Trả về null nếu không thể chuyển đổi
    }

    public static Color adjustColorBrightness(Color color, float factor) {
        int r = Math.min(255, (int) (color.getRed() * factor));
        int g = Math.min(255, (int) (color.getGreen() * factor));
        int b = Math.min(255, (int) (color.getBlue() * factor));
        return new Color(r, g, b);
    }

}
