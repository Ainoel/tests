package gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AutosizeTextArea extends JTextArea {
    public static final int MIN_FONT_SIZE = 10;
    public static final int MAX_FONT_SIZE = 56;
    Graphics g;

    public AutosizeTextArea() {
        super("");
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                adaptFont(AutosizeTextArea.this);
            }
        });
        getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                adaptFont(AutosizeTextArea.this);
            }

            public void removeUpdate(DocumentEvent e) {
                adaptFont(AutosizeTextArea.this);
            }

            public void insertUpdate(DocumentEvent e) {
                adaptFont(AutosizeTextArea.this);
            }
        });
    }

    protected void adaptFont(JTextArea l) {
        if (g == null) {
            return;
        }
        Rectangle r = l.getBounds();
        int fontSize = MIN_FONT_SIZE;
        Font f = l.getFont();

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        while (fontSize < MAX_FONT_SIZE) {
            r1.setSize(getTextSize(l, f.deriveFont(f.getStyle(), fontSize)));
            r2.setSize(getTextSize(l, f.deriveFont(f.getStyle(), fontSize + 1)));
            if (r.height < r2.height || r.width < r2.width) {
                break;
            }
            fontSize++;
        }

        setFont(f.deriveFont(f.getStyle(), fontSize));
        repaint();
    }

    private Dimension getTextSize(JTextArea l, Font f) {
        Dimension size = new Dimension();
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics(f);
        size.width = fm.stringWidth(l.getText());
        size.height = fm.getHeight();

        return size;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;
    }
}