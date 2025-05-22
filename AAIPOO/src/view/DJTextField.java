package View;

import javax.swing.JTextField;
import java.awt.*;

public class DJTextField extends JTextField {
    private static final long serialVersionUID = 1L;
    private String vlrPadrao;
    private int arc = 20;
    public String getVlrPadrao() {
        return vlrPadrao;
    }

    public void setVlrPadrao(String vlrPadrao) {
        this.vlrPadrao = vlrPadrao;
    }

    public DJTextField(String text) {
        super(text);
        vlrPadrao = text;
        setOpaque(false); 
        setBorder(null);  
        setForeground(Color.GRAY); 
    }

    public void setTxPadrao() {
        this.setText(vlrPadrao);
    }

    public void DfocusGained() {
        if (this.getText().equals(vlrPadrao)) {
            this.setText("");
            setForeground(Color.BLACK);
        }
    }

    public void DfocusLost() {
        if (this.getText().isEmpty()) {
            this.setText(vlrPadrao);
            setForeground(Color.GRAY);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Cor de fundo 
        g2.setColor(getBackground() != null ? getBackground() : Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Cor da borda
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
        g2.dispose();
    }
}

