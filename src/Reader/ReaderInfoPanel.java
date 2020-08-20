/*
 * Created by JFormDesigner on Mon Jun 08 22:47:38 CST 2020
 */

package Reader;

import Utils.DBConnect;
import Beans.Reader;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author Yang
 */
public class ReaderInfoPanel extends JPanel{
    int readerId;
    Reader reader;

    public ReaderInfoPanel(String id){
        this.readerId=Integer.parseInt(id);
        initComponents();
        init();
    }

    private void init(){
        setReaderInformation();

        //添加修改信息监听器
        alterButton.addActionListener(e -> {
            if(alterButton.getText().equals("修改信息")){
                System.out.println("修改信息");
                alterButton.setText("完成");
                addressField.setEditable(true);
                phoneField.setEditable(true);
            }else{
                System.out.println("完成");
                Reader newReader=new Reader(reader);
                newReader.setAddress(addressField.getText());
                newReader.setPhoneNumber(phoneField.getText());
                DBConnect db = new DBConnect();
                int condition=db.modifyReaderInformation(newReader);
                System.out.println(condition);
                if(condition==0){
                    JOptionPane.showMessageDialog(this,"修改成功");
                }else if(condition==1){
                    JOptionPane.showMessageDialog(this,"传入信息有误");
                }else{
                    JOptionPane.showMessageDialog(this,"系统异常","错误",JOptionPane.ERROR_MESSAGE);
                }
                setReaderInformation();
            }
        });
    }

    //通过readerId获取读者信息，并显示
    private void setReaderInformation(){
        //用readerId获取读者信息并显示
        DBConnect db = new DBConnect();
        reader=new Reader(db.queryReaderInformation(readerId));
        nameArea.setText(reader.getName());
        addressField.setText(reader.getAddress());
        phoneField.setText(reader.getPhoneNumber());
        limitsDisplayArea.setText(String.valueOf(reader.getLimits()));
        alterButton.setText("修改信息");
        addressField.setEditable(false);
        phoneField.setEditable(false);
    }


    private void initComponents(){


        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        nameArea = new JTextArea();
        addressArea = new JTextArea();
        addressField = new JTextField();
        phoneArea = new JTextArea();
        phoneField = new JTextField();
        limitsArea = new JTextArea();
        alterButton = new JButton();
        limitsDisplayArea = new JTextArea();

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
        nameArea.setFocusable(false);
        nameArea.setOpaque(false);
        nameArea.setEditable(false);
        nameArea.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 26));
        nameArea.setText("\u7528\u6237\u540d");
        add(nameArea);
        nameArea.setBounds(215, 90, 100, 35);

        //---- textArea2 ----
        addressArea.setFocusable(false);
        addressArea.setOpaque(false);
        addressArea.setEditable(false);
        addressArea.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        addressArea.setText("\u5730\u5740\uff1a");
        add(addressArea);
        addressArea.setBounds(215, 155, 70, 25);

        //---- textField1 ----
        addressField.setOpaque(false);
        addressField.setBackground(Color.white);
        addressField.setEditable(false);
        addressField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        addressField.setText("\u6b63\u5728\u67e5\u8be2...");
        add(addressField);
        addressField.setBounds(305, 155, 430, 25);

        //---- textArea3 ----
        phoneArea.setFocusable(false);
        phoneArea.setOpaque(false);
        phoneArea.setEditable(false);
        phoneArea.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        phoneArea.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
        add(phoneArea);
        phoneArea.setBounds(215, 210, 80, 25);

        //---- textField2 ----
        phoneField.setOpaque(false);
        phoneField.setBackground(Color.white);
        phoneField.setEditable(false);
        phoneField.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        phoneField.setText("\u6b63\u5728\u67e5\u8be2...");
        add(phoneField);
        phoneField.setBounds(305, 210, 430, 25);

        //---- textArea4 ----
        limitsArea.setFocusable(false);
        limitsArea.setOpaque(false);
        limitsArea.setEditable(false);
        limitsArea.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        limitsArea.setText("\u501f\u9605\u9650\u989d\uff1a");
        add(limitsArea);
        limitsArea.setBounds(215, 265, 85, 25);

        //---- button1 ----
        alterButton.setText("\u4fee\u6539\u4fe1\u606f");
        alterButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        alterButton.setBackground(new Color(89, 143, 209));
        alterButton.setForeground(Color.white);
        alterButton.setBorder(null);
        add(alterButton);
        alterButton.setBounds(320, 365, 305, 30);

        //---- textArea5 ----
        limitsDisplayArea.setFocusable(false);
        limitsDisplayArea.setOpaque(false);
        limitsDisplayArea.setEditable(false);
        limitsDisplayArea.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        limitsDisplayArea.setText("\u6b63\u5728\u67e5\u8be2...");
        add(limitsDisplayArea);
        limitsDisplayArea.setBounds(310, 265, 85, 25);

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
    private JTextArea nameArea;
    private JTextArea addressArea;
    private JTextField addressField;
    private JTextArea phoneArea;
    private JTextField phoneField;
    private JTextArea limitsArea;
    private JButton alterButton;
    private JTextArea limitsDisplayArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
