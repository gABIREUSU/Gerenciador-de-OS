package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import javax.swing.JPanel;

public class GradientePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        int w = getWidth();
        int h = getHeight();

        
        Color color1 = new Color(93, 12, 255);   // Roxo forte
        Color color2 = new Color(155, 0, 250);   // Magenta claro
        Color color3 = new Color(0, 212, 255);   // Ciano

        float[] dist = { 0.0f, 0.5f, 1.0f };
        Color[] colors = { color1, color2, color3 };

        
        LinearGradientPaint gradient = new LinearGradientPaint(
            0, 0, w, h, dist, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE
        );

        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, w, h);
        g2d.dispose();
    }
}
