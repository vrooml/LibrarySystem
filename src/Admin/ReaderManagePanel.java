/*
 * Created by JFormDesigner on Tue Jun 09 17:29:37 CST 2020
 */

package Admin;

import Beans.Reader;
import Beans.Record;
import Utils.DBConnect;
import sun.security.pkcs11.Secmod;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Yang
 */
public class ReaderManagePanel extends JPanel {
    ArrayList<Record> records;
    public ReaderManagePanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        textField1 = new JTextField();
        button1 = new JButton();
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        textArea3 = new JTextArea();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textArea4 = new JTextArea();
        button2 = new JButton();
        textField4 = new JTextField();
        button3 = new JButton();
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        textArea1.setText("\u7528\u6237\u540d");

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
        , 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
         getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- textField1 ----
        textField1.setToolTipText("\u7528\u6237\u540d/\u7528\u6237id");
        add(textField1);
        textField1.setBounds(215, 20, 510, 25);

        //---- button1 ----
        button1.setIcon(new ImageIcon(getClass().getResource("/Source/search.png")));
        button1.setBorder(LineBorder.createBlackLineBorder());
        button1.setBorderPainted(false);
        button1.setOpaque(false);
        button1.setBackground(Color.white);
        add(button1);
        button1.setBounds(740, 20, 25, 25);

/*搜索按钮监听器*/
        //给搜索按钮添加事务监听器
        button1.addActionListener(e->{
            String getReaderID = textField1.getText().toString();  //待检索的用户ID
            readerID = Integer.parseInt(getReaderID);
            DBConnect dbConnect = new DBConnect();
            Reader readerMes = dbConnect.queryReaderInformation(readerID);
            if(readerMes.getReaderId() == -1){  //待检索的用户不存在
                textArea1.setText("\u7528\u6237\u540d");
                textField2.setText("");  //地址
                textField3.setText("");  //号码
                textField4.setText(""); //借书限制
                JOptionPane.showMessageDialog(null,"用户不存在，请从新检索！","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{     //将检索的用户数据填入其中
                textField2.setText(readerMes.getAddress());  //地址
                textField3.setText(readerMes.getPhoneNumber());  //号码
                textField4.setText(String.valueOf(readerMes.getLimits())); //借书限制
                textArea1.setText(readerMes.getName());
            }
        });


        //---- textArea1 ----
        textArea1.setFocusable(false);
        textArea1.setOpaque(false);
        textArea1.setEditable(false);
        textArea1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 26));
        add(textArea1);
        textArea1.setBounds(90, 75, 100, textArea1.getPreferredSize().height);

        //---- textArea2 ----
        textArea2.setFocusable(false);
        textArea2.setOpaque(false);
        textArea2.setEditable(false);
        textArea2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        textArea2.setText("\u5730\u5740\uff1a");
        add(textArea2);
        textArea2.setBounds(215, 80, 70, 25);

        //---- textArea3 ----
        textArea3.setFocusable(false);
        textArea3.setOpaque(false);
        textArea3.setEditable(false);
        textArea3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        textArea3.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
        add(textArea3);
        textArea3.setBounds(215, 120, textArea3.getPreferredSize().width, 25);

        //---- textField2 ----
        textField2.setOpaque(false);
        textField2.setBackground(Color.white);
        textField2.setEditable(true);
        textField2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        add(textField2);
        textField2.setBounds(305, 80, 430, 25);

        //---- textField3 ----
        textField3.setOpaque(false);
        textField3.setBackground(Color.white);
        textField3.setEditable(true);
        textField3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        add(textField3);
        textField3.setBounds(305, 120, 430, 25);

        //---- textArea4 ----
        textArea4.setFocusable(false);
        textArea4.setOpaque(false);
        textArea4.setEditable(true);
        textArea4.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        textArea4.setText("\u501f\u9605\u9650\u989d\uff1a");
        add(textArea4);
        textArea4.setBounds(215, 155, 85, 25);

        //---- button2 ----
        button2.setText("\u4fee\u6539\u7528\u6237");
        button2.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        button2.setBackground(new Color(89, 143, 209));
        button2.setForeground(Color.white);
        button2.setBorder(null);
        add(button2);
        button2.setBounds(115, 420, 305, 30);

        //修改读者信息按钮监听器
        button2.addActionListener(e->{
            String address = textField2.getText();
            String phone = textField3.getText();
            String limit = textField4.getText();

            if(address.equals("") || phone.equals("") || limit.equals("")){  //修改信息为空
                JOptionPane.showMessageDialog(null,"信息不能为空！","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{  //修改
                Reader reader = new Reader(readerID,textArea1.getText(),"",address,phone,Integer.parseInt(limit));
                DBConnect dbConnect = new DBConnect();
                int status = dbConnect.modifyReaderInformation(reader);
                if(status == 0)   //修改成功
                    JOptionPane.showMessageDialog(null,"修改读者信息成功！","Success",JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null,"修改读者信息失败，请稍后重试！","Error",JOptionPane.ERROR_MESSAGE);
            }
        });



        //---- textField4 ----
        textField4.setOpaque(false);
        textField4.setBackground(Color.white);
        textField4.setEditable(true);
        textField4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        add(textField4);
        textField4.setBounds(305, 155, 95, 25);

        //---- button3 ----
        button3.setText("\u5220\u9664\u7528\u6237");
        button3.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        button3.setBackground(new Color(89, 143, 209));
        button3.setForeground(Color.white);
        button3.setBorder(null);
        add(button3);
        button3.setBounds(525, 420, 305, 30);

        //删除读者按钮监听器
        button3.addActionListener(e->{
            if(readerID != 0){
                int result = JOptionPane.showConfirmDialog(null,"确定删除读者：  " + readerID + "  吗？", "删除用户确认",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);   //确认删除
                if(result == JOptionPane.YES_OPTION){
                    DBConnect dbConnect = new DBConnect();
                    int status = dbConnect.deleteReader(readerID);
                    if(status == 0) {  //成功删除
                        JOptionPane.showMessageDialog(null,"已成功删除读者：" + readerID + "。","Success",JOptionPane.INFORMATION_MESSAGE);
                        textArea1.setText("\u7528\u6237\u540d");
                        textField2.setText("");  //地址
                        textField3.setText("");  //号码
                        textField4.setText(""); //借书限制
                    }
                    else
                        JOptionPane.showMessageDialog(null,"删除读者失败，请稍后重试！","Error",JOptionPane.ERROR_MESSAGE);
                }



            }else {
                JOptionPane.showMessageDialog(null,"请先检索需要删除的用户！","Error",JOptionPane.ERROR_MESSAGE);
            }
        });

        //======== scrollPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
            }
            scrollPane1.setViewportView(panel1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(40, 200, 855, 210);

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

    private void init(){
        GridBagLayout gridBag=(GridBagLayout)panel1.getLayout();    // 布局管理器
        GridBagConstraints c=null;
        //请求还书记录逻辑
        records=new ArrayList<>();

        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));


        for(int i=0;i<records.size();i++){
            c=new GridBagConstraints();
            c.gridwidth=GridBagConstraints.REMAINDER;
            c.fill=GridBagConstraints.BOTH;
            BookItemPanel briefPanel=new BookItemPanel(records.get(i));
            gridBag.addLayoutComponent(briefPanel,c);
            panel1.add(briefPanel);
        }

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yang
    private JTextField textField1;
    private JButton button1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextField textField2;
    private JTextField textField3;
    private JTextArea textArea4;
    private JButton button2;
    private JTextField textField4;
    private JButton button3;
    private JScrollPane scrollPane1;
    private JPanel panel1;
    int readerID = 0;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
