package design;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MostrarSeta extends JButton {
    private static final long serialVersionUID = 1L;
    private Image imagem;

    public MostrarSeta() {
        setOpaque(false); 
        setContentAreaFilled(false); 
        setBorderPainted(false); 
        setFocusPainted(false); 

        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagens/seta.png"));
        imagem = imgIcon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g);
        g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
    }
}