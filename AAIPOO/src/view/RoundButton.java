package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

class RoundButton extends JButton {
    private static final long serialVersionUID = 1L;
    private Color normalColor = new Color(240, 240, 240);
    private Color hoverColor = new Color(200, 200, 255);

    public RoundButton(String label) {
        super(label);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(normalColor);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

       
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalColor);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
        super.paintComponent(g);
        g2.dispose();
    }

}