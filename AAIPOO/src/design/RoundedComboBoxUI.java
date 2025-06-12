package design;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class RoundedComboBoxUI extends BasicComboBoxUI {

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        comboBox.setOpaque(false);
        comboBox.setBackground(Color.WHITE);
        comboBox.setBorder(new EmptyBorder(5, 10, 5, 5)); // padding interno
    }

    @Override
    protected JButton createArrowButton() {
        JButton button = new JButton("▼");
        button.setBorder(null);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setForeground(Color.GRAY);
        return button;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arc = 15;
        int width = c.getWidth();
        int height = c.getHeight();

        // Fundo branco
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, width, height, arc, arc);

        // Borda cinza clara (como o DJTextField)
        g2.setColor(Color.LIGHT_GRAY);
        g2.setStroke(new BasicStroke(1.2f));
        g2.drawRoundRect(0, 0, width - 1, height - 1, arc, arc);

        g2.dispose();

        super.paint(g, c);
    }

    @Override
    public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 15, 15);
    }
}

