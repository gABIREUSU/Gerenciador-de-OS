package design;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class RoundedPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private Color backgroundColor = Color.WHITE;
    private int cornerRadius = 30;

    public RoundedPanel() {
        setOpaque(false); // necessário para desenhar o fundo personalizado
    }

    public void setBackgroundColor(Color bgColor) {
        this.backgroundColor = bgColor;
        repaint();
    }

    public void setCornerRadius(int radius) {
        this.cornerRadius = radius;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();

        Graphics2D graphics = (Graphics2D) g.create();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(backgroundColor);
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

        graphics.setColor(backgroundColor.darker());
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

        graphics.dispose();
    }
}
