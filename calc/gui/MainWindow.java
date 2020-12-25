package gui;

import evaluator.Evaluator;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.Locale;

public class MainWindow {
    private JPanel mainPanel;
    private AutosizeTextArea input;

    private JButton bPar;
    private JButton bEq;

    private JButton bPow;
    private JButton bDiv;
    private JButton bMul;
    private JButton bMin;
    private JButton bPlu;

    private JButton b0;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;

    private JButton bDelete;
    private JButton bClear;
    private JButton bDot;

    static JFrame mw;

    static boolean open = true;
    static DecimalFormat df;

    public static void main(String[] args) {
        mw = new JFrame("Calculator");
        mw.setContentPane(new MainWindow().mainPanel);
        mw.pack();
        mw.setSize(340, 510);
        mw.setResizable(false);
        mw.setVisible(true);

        df = new DecimalFormat("#");
        df.setMaximumFractionDigits(12);

    }

    public MainWindow() {
        $$$setupUI$$$();
        ActionListener buttonPress = e -> {
            input.setText(
                input.getText() + ((JButton) e.getSource()).getText().strip()
            );
        };

        b0.addActionListener(buttonPress);
        b1.addActionListener(buttonPress);
        b2.addActionListener(buttonPress);
        b3.addActionListener(buttonPress);
        b4.addActionListener(buttonPress);
        b5.addActionListener(buttonPress);
        b6.addActionListener(buttonPress);
        b7.addActionListener(buttonPress);
        b8.addActionListener(buttonPress);
        b9.addActionListener(buttonPress);

        bPlu.addActionListener(buttonPress);
        bMin.addActionListener(buttonPress);
        bMul.addActionListener(buttonPress);
        bDiv.addActionListener(buttonPress);
        bPow.addActionListener(buttonPress);
        bDot.addActionListener(buttonPress);

        bEq.addActionListener((e) -> {
            try {
                double result = Evaluator.eval(input.getText());
                input.setText(df.format(result));
            } catch (Exception ex) {
                input.setText(ex.getLocalizedMessage());
            }
        });

        bPar.addActionListener((e) -> {
            input.setText(
                input.getText() + (open ? "(" : ")")
            );
            open = !open;
        });

        bDelete.addActionListener((e) -> {
            input.setText(
                input.getText().substring(0, input.getText().length() - 2)
            );
        });

        bClear.addActionListener((e) -> {
            input.setText("");
        });
    }

    private void createUIComponents() {
        input = new AutosizeTextArea();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        input.setLineWrap(true);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 7;
        gbc.weightx = 4.0;
        gbc.weighty = 20.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(input, gbc);
        bPar = new JButton();
        bPar.setContentAreaFilled(true);
        bPar.setDefaultCapable(true);
        Font bParFont = this.$$$getFont$$$(null, Font.BOLD, 20, bPar.getFont());
        if (bParFont != null) bPar.setFont(bParFont);
        bPar.setIconTextGap(4);
        bPar.setText("( )");
        bPar.putClientProperty("hideActionText", Boolean.FALSE);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 5.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(bPar, gbc);
        bPow = new JButton();
        Font bPowFont = this.$$$getFont$$$(null, Font.BOLD, 24, bPow.getFont());
        if (bPowFont != null) bPow.setFont(bPowFont);
        bPow.setText("^");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.weightx = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(bPow, gbc);
        bDiv = new JButton();
        Font bDivFont = this.$$$getFont$$$(null, Font.BOLD, 24, bDiv.getFont());
        if (bDivFont != null) bDiv.setFont(bDivFont);
        bDiv.setText("/");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 5;
        gbc.weightx = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(bDiv, gbc);
        bMul = new JButton();
        Font bMulFont = this.$$$getFont$$$(null, Font.BOLD, 24, bMul.getFont());
        if (bMulFont != null) bMul.setFont(bMulFont);
        bMul.setText("*");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 5;
        gbc.weightx = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(bMul, gbc);
        bMin = new JButton();
        Font bMinFont = this.$$$getFont$$$(null, Font.BOLD, 24, bMin.getFont());
        if (bMinFont != null) bMin.setFont(bMinFont);
        bMin.setText("-");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 7;
        gbc.weightx = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(bMin, gbc);
        b9 = new JButton();
        Font b9Font = this.$$$getFont$$$(null, Font.BOLD, 24, b9.getFont());
        if (b9Font != null) b9.setFont(b9Font);
        b9.setText("9");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 7;
        gbc.weightx = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(b9, gbc);
        b8 = new JButton();
        Font b8Font = this.$$$getFont$$$(null, Font.BOLD, 24, b8.getFont());
        if (b8Font != null) b8.setFont(b8Font);
        b8.setText("8");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.weightx = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(b8, gbc);
        b7 = new JButton();
        Font b7Font = this.$$$getFont$$$(null, Font.BOLD, 24, b7.getFont());
        if (b7Font != null) b7.setFont(b7Font);
        b7.setText("7");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 5.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(b7, gbc);
        b4 = new JButton();
        Font b4Font = this.$$$getFont$$$(null, Font.BOLD, 24, b4.getFont());
        if (b4Font != null) b4.setFont(b4Font);
        b4.setText("4");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.weightx = 5.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(b4, gbc);
        b5 = new JButton();
        Font b5Font = this.$$$getFont$$$(null, Font.BOLD, 24, b5.getFont());
        if (b5Font != null) b5.setFont(b5Font);
        b5.setText("5");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 9;
        gbc.weightx = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(b5, gbc);
        b6 = new JButton();
        Font b6Font = this.$$$getFont$$$(null, Font.BOLD, 24, b6.getFont());
        if (b6Font != null) b6.setFont(b6Font);
        b6.setText("6");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 9;
        gbc.weightx = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(b6, gbc);
        bPlu = new JButton();
        Font bPluFont = this.$$$getFont$$$(null, Font.BOLD, 24, bPlu.getFont());
        if (bPluFont != null) bPlu.setFont(bPluFont);
        bPlu.setText("+");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 9;
        gbc.weightx = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(bPlu, gbc);
        b1 = new JButton();
        Font b1Font = this.$$$getFont$$$(null, Font.BOLD, 24, b1.getFont());
        if (b1Font != null) b1.setFont(b1Font);
        b1.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.weightx = 5.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(b1, gbc);
        b2 = new JButton();
        Font b2Font = this.$$$getFont$$$(null, Font.BOLD, 24, b2.getFont());
        if (b2Font != null) b2.setFont(b2Font);
        b2.setText("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 11;
        gbc.weightx = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(b2, gbc);
        b3 = new JButton();
        Font b3Font = this.$$$getFont$$$(null, Font.BOLD, 24, b3.getFont());
        if (b3Font != null) b3.setFont(b3Font);
        b3.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 11;
        gbc.weightx = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(b3, gbc);
        bEq = new JButton();
        Font bEqFont = this.$$$getFont$$$(null, Font.BOLD, 24, bEq.getFont());
        if (bEqFont != null) bEq.setFont(bEqFont);
        bEq.setText("=");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 11;
        gbc.gridheight = 3;
        gbc.weightx = 5.0;
        gbc.weighty = 5.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(bEq, gbc);
        bDelete = new JButton();
        Font bDeleteFont = this.$$$getFont$$$(null, Font.BOLD, 22, bDelete.getFont());
        if (bDeleteFont != null) bDelete.setFont(bDeleteFont);
        bDelete.setText("←");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 3;
        gbc.weightx = 5.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(bDelete, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 8;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spacer2, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 14;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spacer7, gbc);
        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(spacer8, gbc);
        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(spacer9, gbc);
        final JPanel spacer10 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(spacer10, gbc);
        final JPanel spacer11 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(spacer11, gbc);
        final JPanel spacer12 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(spacer12, gbc);
        bClear = new JButton();
        Font bClearFont = this.$$$getFont$$$(null, Font.BOLD, 24, bClear.getFont());
        if (bClearFont != null) bClear.setFont(bClearFont);
        bClear.setText("C");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.weightx = 5.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(bClear, gbc);
        b0 = new JButton();
        Font b0Font = this.$$$getFont$$$(null, Font.BOLD, 24, b0.getFont());
        if (b0Font != null) b0.setFont(b0Font);
        b0.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 13;
        gbc.gridwidth = 3;
        gbc.weightx = 10.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(b0, gbc);
        bDot = new JButton();
        Font bDotFont = this.$$$getFont$$$(null, Font.BOLD, 24, bDot.getFont());
        if (bDotFont != null) bDot.setFont(bDotFont);
        bDot.setText(".");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 13;
        gbc.weightx = 5.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(bDot, gbc);
        final JPanel spacer13 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        mainPanel.add(spacer13, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}