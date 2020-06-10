/*
 * Created by JFormDesigner on Mon Jun 08 18:05:12 CST 2020
 */

import Utils.DBConnect;

import java.awt.*;
import javax.swing.*;

/**
 * @author Yang
 */
public class RegisterFrame extends JFrame{
    DBConnect db;

    public RegisterFrame(DBConnect db){
        this.db=db;
        initComponents();
        init();
    }

    private void init(){
        //按钮监听及判空逻辑等
    }

    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        panel1=new JPanel();
        textArea1=new JTextArea();
        textArea3=new JTextArea();
        textField1=new JTextField();
        textArea4=new JTextArea();
        textField2=new JTextField();
        textArea5=new JTextArea();
        textField3=new JTextField();
        textArea6=new JTextArea();
        textField4=new JTextField();
        button1=new JButton();

        //======== this ========
        setVisible(true);
        setResizable(false);
        Container contentPane=getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0
                    ,0,0,0),"JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
                    ,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red),
                    panel1.getBorder()));
            panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){
                @Override
                public void propertyChange(java.beans.PropertyChangeEvent e
                ){
                    if("\u0062ord\u0065r".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });
            panel1.setLayout(null);

            //---- textArea1 ----
            textArea1.setText("\u6ce8\u518c\u8d26\u6237");
            textArea1.setFocusable(false);
            textArea1.setOpaque(false);
            textArea1.setEditable(false);
            textArea1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,26));
            panel1.add(textArea1);
            textArea1.setBounds(180,30,110,35);

            //---- textArea3 ----
            textArea3.setText("\u540d\u5b57");
            textArea3.setFocusable(false);
            textArea3.setOpaque(false);
            textArea3.setEditable(false);
            textArea3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,14));
            panel1.add(textArea3);
            textArea3.setBounds(60,90,35,20);
            panel1.add(textField1);
            textField1.setBounds(60,110,340,30);

            //---- textArea4 ----
            textArea4.setFocusable(false);
            textArea4.setOpaque(false);
            textArea4.setEditable(false);
            textArea4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,14));
            textArea4.setText("\u5bc6\u7801");
            panel1.add(textArea4);
            textArea4.setBounds(60,155,35,20);
            panel1.add(textField2);
            textField2.setBounds(60,175,340,30);

            //---- textArea5 ----
            textArea5.setText("\u5730\u5740");
            textArea5.setFocusable(false);
            textArea5.setOpaque(false);
            textArea5.setEditable(false);
            textArea5.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,14));
            panel1.add(textArea5);
            textArea5.setBounds(60,225,65,20);
            panel1.add(textField3);
            textField3.setBounds(60,245,340,30);

            //---- textArea6 ----
            textArea6.setText("\u7535\u8bdd\u53f7\u7801");
            textArea6.setFocusable(false);
            textArea6.setOpaque(false);
            textArea6.setEditable(false);
            textArea6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,14));
            panel1.add(textArea6);
            textArea6.setBounds(60,295,75,20);
            panel1.add(textField4);
            textField4.setBounds(60,315,340,30);

            //---- button1 ----
            button1.setText("\u786e\u8ba4\u6ce8\u518c");
            button1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,14));
            button1.setBackground(new Color(89,143,209));
            button1.setForeground(Color.white);
            panel1.add(button1);
            button1.setBounds(175,380,115,25);
        }
        contentPane.add(panel1);
        panel1.setBounds(0,0,465,445);

        {
            // compute preferred size
            Dimension preferredSize=new Dimension();
            for(int i=0;i<contentPane.getComponentCount();i++){
                Rectangle bounds=contentPane.getComponent(i).getBounds();
                preferredSize.width=Math.max(bounds.x+bounds.width,preferredSize.width);
                preferredSize.height=Math.max(bounds.y+bounds.height,preferredSize.height);
            }
            Insets insets=contentPane.getInsets();
            preferredSize.width+=insets.right;
            preferredSize.height+=insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yang
    private JPanel panel1;
    private JTextArea textArea1;
    private JTextArea textArea3;
    private JTextField textField1;
    private JTextArea textArea4;
    private JTextField textField2;
    private JTextArea textArea5;
    private JTextField textField3;
    private JTextArea textArea6;
    private JTextField textField4;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
