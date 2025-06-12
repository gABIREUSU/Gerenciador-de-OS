package design;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class TextButton extends JButton {

    private static final long serialVersionUID = 1L;

    private final Color normalColor = Color.WHITE;
    private final Color hoverColor = new Color(180, 150, 255); // Roxo claro

    public TextButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setFont(new Font("Sitka Small", Font.PLAIN, 13));
        setForeground(normalColor);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Efeito hover
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(normalColor);
            }
        });
    }
}

