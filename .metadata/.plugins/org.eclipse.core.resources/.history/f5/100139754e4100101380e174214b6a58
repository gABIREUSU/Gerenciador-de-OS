package Model;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MostrarImagem extends JPanel {
    private static final long serialVersionUID = 1L;
	private Image imagem;

    public MostrarImagem() {
        setOpaque(false); 
        ImageIcon imgIcon = new ImageIcon(getClass().getResource("/imagens/minhaImagem.png"));
        imagem = imgIcon.getImage();
    }


    @Override
    protected void paintComponent(Graphics g) { 
        super.paintComponent(g);
        g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
    }
}
