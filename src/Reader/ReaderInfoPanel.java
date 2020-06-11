/*
 * Created by JFormDesigner on Mon Jun 08 22:47:38 CST 2020
 */

package Reader;

import Utils.DBConnect;

import java.awt.*;
import javax.swing.*;

/**
 * @author Yang
 */
public class ReaderInfoPanel extends JPanel{
    public ReaderInfoPanel(){
        initComponents();
        init();
    }

    private void init(){
        //填充info数据
    }

    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        textField1 = new JTextField();
        textArea3 = new JTextArea();
        textField2 = new JTextField();
        textArea4 = new JTextArea();
        button1 = new JButton();
        textArea5 = new JTextArea();

        //======== this ========
        setPreferredSize(new Dimension(940, 470));
        setBackground(Color.white);
        setOpaque(false);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
        . EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax
        . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
        12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans
        . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .
        getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- textArea1 ----
        textArea1.setFocusable(false);
        textArea1.setOpaque(false);
        textArea1.setEditable(false);
        textArea1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 26));
        textArea1.setText("\u7528\u6237\u540d");
        add(textArea1);
        textArea1.setBounds(215, 90, 100, 35);

        //---- textArea2 ----
        textArea2.setFocusable(false);
        textArea2.setOpaque(false);
        textArea2.setEditable(false);
        textArea2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        textArea2.setText("\u5730\u5740\uff1a");
        add(textArea2);
        textArea2.setBounds(215, 155, 70, 25);

        //---- textField1 ----
        textField1.setOpaque(false);
        textField1.setBackground(Color.white);
        textField1.setEditable(false);
        textField1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        textField1.setText("\u6b63\u5728\u67e5\u8be2...");
        add(textField1);
        textField1.setBounds(305, 155, 430, 25);

        //---- textArea3 ----
        textArea3.setFocusable(false);
        textArea3.setOpaque(false);
        textArea3.setEditable(false);
        textArea3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        textArea3.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
        add(textArea3);
        textArea3.setBounds(215, 210, 80, 25);

        //---- textField2 ----
        textField2.setOpaque(false);
        textField2.setBackground(Color.white);
        textField2.setEditable(false);
        textField2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        textField2.setText("\u6b63\u5728\u67e5\u8be2...");
        add(textField2);
        textField2.setBounds(305, 210, 430, 25);

        //---- textArea4 ----
        textArea4.setFocusable(false);
        textArea4.setOpaque(false);
        textArea4.setEditable(false);
        textArea4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        textArea4.setText("\u501f\u9605\u9650\u989d\uff1a");
        add(textArea4);
        textArea4.setBounds(215, 265, 85, 25);

        //---- button1 ----
        button1.setText("\u4fee\u6539\u4fe1\u606f");
        button1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        button1.setBackground(new Color(89, 143, 209));
        button1.setForeground(Color.white);
        button1.setBorder(null);
        add(button1);
        button1.setBounds(320, 365, 305, 30);

        //---- textArea5 ----
        textArea5.setFocusable(false);
        textArea5.setOpaque(false);
        textArea5.setEditable(false);
        textArea5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        textArea5.setText("\u6b63\u5728\u67e5\u8be2...");
        add(textArea5);
        textArea5.setBounds(310, 265, 85, 25);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yang
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextField textField1;
    private JTextArea textArea3;
    private JTextField textField2;
    private JTextArea textArea4;
    private JButton button1;
    private JTextArea textArea5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
