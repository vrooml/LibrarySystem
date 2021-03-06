package PublicComp;/*
 * Created by JFormDesigner on Mon Jun 08 11:56:38 CST 2020
 */

import Admin.AdminFrame;
import PublicComp.RegisterFrame;
import Reader.ReaderFrame;
import Utils.DBConnect;
import Utils.SHA1Encryption;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Yang
 */
public class LoginFrame extends JFrame{
    DBConnect db;

    public LoginFrame(){
        initComponents();
        init();
    }

    private void init(){
        //jradiobutton二选一监听
        ButtonGroup group=new ButtonGroup();
        group.add(readerButton);
        group.add(adminButton);

        login.addActionListener(e->{
            //登录逻辑

            String id = accountField.getText();
            String password = String.valueOf(passwordField1.getPassword());
            System.out.print(password);
            password = SHA1Encryption.getSHA1(password);  //密码加密
            int loginStatue;  //记录登录状态
            DBConnect db = new DBConnect();
            if(readerButton.isSelected()){    //读者登录
                loginStatue = db.readerLogin(id, password); //调用数据库读者登陆接口
                if(loginStatue == 0) {  //登陆成功
                    new ReaderFrame(id);
                    this.setVisible(false);  //登陆成功，隐藏当前窜口
                }

            }
            else {     //管理员登录
                loginStatue = db.adminLogin(id, password); //调用数据库管理员登陆接口
                if(loginStatue == 0) {
                    new AdminFrame();
                    this.setVisible(false);  //登陆成功，隐藏当前窜口
                }
            }

            if(loginStatue == 1)  //账号不存在
                JOptionPane.showMessageDialog(null,"账号不存在","Error",JOptionPane.ERROR_MESSAGE);
            else if(loginStatue == 2) //账号密码不匹配
                JOptionPane.showMessageDialog(null,"账号与密码不匹配","Error",JOptionPane.ERROR_MESSAGE);
//            new ReaderFrame(db);
//            or
//            new AdminFrame(db);
        });

        //注册按钮监听
        register.addActionListener(e->{
            new RegisterFrame();
        });

    }

    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        textArea2 = new JTextArea();
        accountField = new JTextField();
        textArea3 = new JTextArea();
        login = new JButton();
        register = new JButton();
        textArea1 = new JTextArea();
        readerButton = new JRadioButton();
        adminButton = new JRadioButton();
        passwordField1 = new JPasswordField();
        label1 = new JLabel();

        //======== this ========
        setVisible(true);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- textArea2 ----
        textArea2.setText("\u8d26\u53f7");
        textArea2.setFocusable(false);
        textArea2.setOpaque(false);
        textArea2.setEditable(false);
        textArea2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(textArea2);
        textArea2.setBounds(100, 205, 35, 20);
        contentPane.add(accountField);
        accountField.setBounds(100, 225, 340, 30);

        //---- textArea3 ----
        textArea3.setText("\u5bc6\u7801");
        textArea3.setFocusable(false);
        textArea3.setOpaque(false);
        textArea3.setEditable(false);
        textArea3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        contentPane.add(textArea3);
        textArea3.setBounds(100, 280, 35, 20);

        //---- login ----
        login.setText("\u767b\u5f55");
        login.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        login.setBackground(new Color(89, 143, 209));
        login.setForeground(Color.white);
        contentPane.add(login);
        login.setBounds(120, 390, 115, 25);

        //---- register ----
        register.setText("\u8bfb\u8005\u6ce8\u518c");
        register.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        register.setBackground(new Color(89, 143, 209));
        register.setForeground(Color.white);
        contentPane.add(register);
        register.setBounds(305, 390, 115, 25);

        //---- textArea1 ----
        textArea1.setText("\u6b22\u8fce\u4f7f\u7528\u56fe\u4e66\u7ba1\u7406\u7cfb\u7edf");
        textArea1.setFocusable(false);
        textArea1.setOpaque(false);
        textArea1.setEditable(false);
        textArea1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 26));
        contentPane.add(textArea1);
        textArea1.setBounds(135, 75, 270, 35);

        //---- readerButton ----
        readerButton.setText("\u8bfb\u8005");
        readerButton.setOpaque(false);
        readerButton.setSelected(true);
        contentPane.add(readerButton);
        readerButton.setBounds(new Rectangle(new Point(160, 175), readerButton.getPreferredSize()));

        //---- adminButton ----
        adminButton.setText("\u7ba1\u7406\u5458");
        adminButton.setOpaque(false);
        contentPane.add(adminButton);
        adminButton.setBounds(320, 175, 65, 19);
        contentPane.add(passwordField1);
        passwordField1.setBounds(100, 300, 340, 30);

        //---- label1 ----
        label1.setIcon(new ImageIcon(getClass().getResource("/Source/background.png")));
        label1.setFocusable(false);
        contentPane.add(label1);
        label1.setBounds(0, 0, 530, 440);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextArea textArea2;
    private JTextField accountField;
    private JTextArea textArea3;
    private JButton login;
    private JButton register;
    private JTextArea textArea1;
    private JRadioButton readerButton;
    private JRadioButton adminButton;
    private JPasswordField passwordField1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        new LoginFrame();
    }
}
