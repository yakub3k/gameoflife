package menu;

import javax.swing.*;

class CheckBoxPanel extends JPanel {
    private final JCheckBox checkbox0;
    private final JCheckBox checkbox1;
    private final JCheckBox checkbox2;
    private final JCheckBox checkbox3;
    private final JCheckBox checkbox4;
    private final JCheckBox checkbox5;
    private final JCheckBox checkbox6;
    private final JCheckBox checkbox7;
    private final JCheckBox checkbox8;

    CheckBoxPanel(String title) {
        checkbox0 = new JCheckBox("0");
        checkbox1 = new JCheckBox("1");
        checkbox2 = new JCheckBox("2");
        checkbox3 = new JCheckBox("3");
        checkbox4 = new JCheckBox("4");
        checkbox5 = new JCheckBox("5");
        checkbox6 = new JCheckBox("6");
        checkbox7 = new JCheckBox("7");
        checkbox8 = new JCheckBox("8");

        JTextField label = new JTextField(title);
        label.setEditable(false);
        add(label);
        add(checkbox0);
        add(checkbox1);
        add(checkbox2);
        add(checkbox3);
        add(checkbox4);
        add(checkbox5);
        add(checkbox6);
        add(checkbox7);
        add(checkbox8);
    }

    boolean[] getValue() {
        return new boolean[]{
                checkbox0.isSelected(),
                checkbox1.isSelected(),
                checkbox2.isSelected(),
                checkbox3.isSelected(),
                checkbox4.isSelected(),
                checkbox5.isSelected(),
                checkbox6.isSelected(),
                checkbox7.isSelected(),
                checkbox8.isSelected()
        };
    }

    void selectDead(){
        checkbox3.setSelected(true);
    }

    void selectLive(){
        checkbox2.setSelected(true);

        checkbox3.setSelected(true);
    }
}
