/*
 * Created by JFormDesigner on Mon Jun 08 23:40:36 CST 2020
 */

package Admin;

import Admin.BookItemPanel;
import Beans.Book;
import Beans.Record;
import Utils.DBConnect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Yang
 */
public class AddBookFrame extends JFrame{
    Book book;
    int _bookNumber;


    public AddBookFrame(){
        initComponents();
        init();
    }

    private void init(){
        //DBConnect db = new DBConnect();//连接数据库
        int isAddOK;//记录是否成功添加新书
        JFrame jf = new JFrame("添加新书");
        jf.setSize(610,460);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //给添加新书的按钮添加监听器，按下之后会检验输入的各个数据的合法性，如果全都合法的话就用得到的数据建一个book实例并调用数据库添加新书的函数。
        addBookButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(title.getText().equals(null)||title.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"添加失败，图书名字不能为空！");
                    return;
                }
                else if(author.getText().equals(null)||author.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"添加失败，作者名字不能为空！");
                    return;
                }
                else if(ISBN.getText().equals(null)||ISBN.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"添加失败，ISBN编号不能为空！");
                    return;
                }
                else if(publishTIme.getText().equals(null)||publishTIme.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"添加失败，出版日期不能为空！");
                    return;
                }
                else if(publisher.getText().equals(null)||publisher.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"添加失败，出版社名称不能为空！");
                    return;
                }
                else if(bookNumber.getText().equals(null)||bookNumber.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"添加失败，添加数量不能为空！");
                    return;
                }
                else if(bookNumber.getText().charAt(0) == '0')
                {
                    JOptionPane.showMessageDialog(null,"添加失败，输入了非法的图书数量，只能输入大于0的数字，且数字不能以0为开头！");
                    return;
                }
                else if(!isAllDigit(bookNumber.getText()))
                {
                    JOptionPane.showMessageDialog(null,"添加失败，输入了非法的图书数量，只能输入大于0的数字，且数字不能以0为开头！");
                    return;
                }
                else //上述情况都没有出现，数据可用，调用函数上传至数据库
                {
                    _bookNumber=Integer.valueOf(bookNumber.getText());//将文本框内的添加数量转化成数字
                    /*Book newbook=new Book(ISBN.getText(),title.getText(),author.getText(),publisher.getText(),publishTIme.getText(),);
                    isAddOK=db.addNewBook(newbook,_booknumber);
                    if(!isAddOK)//添加成功
                    {
                        JOptionPane.showMessageDialog(null,message:"添加图书成功！");
                        return;
                    }
                    else if(isAddOK==1)
                    {
                    JOptionPane.showMessageDialog(null,message:"操作异常，添加图书失败！");
                    return;
                    }
                    else
                    {
                    JOptionPane.showMessageDialog(null,message:"系统出错,添加图书失败！");
                    return;
                    }
                     */
                }
            }
        });

        jf.setContentPane(panel1);
        jf.setVisible(true);


    }

    boolean isAllDigit(String str) //判断字符串是否全部为数字的函数
    {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        panel1 = new JPanel();
        cover = new JLabel();
        textArea6 = new JTextArea();
        textArea7 = new JTextArea();
        textArea8 = new JTextArea();
        textArea9 = new JTextArea();
        textArea10 = new JTextArea();
        author = new JTextField();
        title = new JTextField();
        publisher = new JTextField();
        publishTIme = new JTextField();
        ISBN = new JTextField();
        bookNumber = new JTextField();
        addBookButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
            border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER
            , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
            .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) ); panel1. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r"
            .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            panel1.setLayout(null);

            //---- cover ----
            cover.setBackground(Color.white);
            cover.setOpaque(true);
            cover.setText("\u4e0a\u4f20\u5c01\u9762");
            panel1.add(cover);
            cover.setBounds(35, 75, 165, 230);

            //---- textArea6 ----
            textArea6.setFocusable(false);
            textArea6.setOpaque(false);
            textArea6.setEditable(false);
            textArea6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea6.setText("\u4f5c\u8005\uff1a");
            panel1.add(textArea6);
            textArea6.setBounds(220, 130, 60, 25);

            //---- textArea7 ----
            textArea7.setFocusable(false);
            textArea7.setOpaque(false);
            textArea7.setEditable(false);
            textArea7.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea7.setText("\u51fa\u7248\u793e\uff1a");
            panel1.add(textArea7);
            textArea7.setBounds(220, 170, 60, 25);

            //---- textArea8 ----
            textArea8.setFocusable(false);
            textArea8.setOpaque(false);
            textArea8.setEditable(false);
            textArea8.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea8.setText("\u51fa\u7248\u65f6\u95f4\uff1a");
            panel1.add(textArea8);
            textArea8.setBounds(220, 210, 80, 25);

            //---- textArea9 ----
            textArea9.setFocusable(false);
            textArea9.setOpaque(false);
            textArea9.setEditable(false);
            textArea9.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea9.setText("ISBN\uff1a");
            panel1.add(textArea9);
            textArea9.setBounds(220, 250, 80, 25);

            //---- textArea10 ----
            textArea10.setFocusable(false);
            textArea10.setOpaque(false);
            textArea10.setEditable(false);
            textArea10.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea10.setText("\u6dfb\u52a0\u6570\u91cf\uff1a");
            panel1.add(textArea10);
            textArea10.setBounds(220, 290, 80, 25);
            panel1.add(author);
            author.setBounds(305, 130, 220, author.getPreferredSize().height);

            //---- title ----
            title.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 20));
            title.setText("\u4e66\u540d");
            panel1.add(title);
            title.setBounds(220, 65, 220, 40);
            panel1.add(publisher);
            publisher.setBounds(305, 170, 220, 24);
            panel1.add(publishTIme);
            publishTIme.setBounds(305, 210, 220, 24);
            panel1.add(ISBN);
            ISBN.setBounds(305, 250, 220, 24);
            panel1.add(bookNumber);
            bookNumber.setBounds(305, 290, 220, 24);

            //---- addBookButton ----
            addBookButton.setText("\u6dfb\u52a0\u56fe\u4e66");
            addBookButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
            addBookButton.setBackground(new Color(89, 143, 209));
            addBookButton.setForeground(Color.white);
            addBookButton.setBorder(null);
            panel1.add(addBookButton);
            addBookButton.setBounds(150, 360, 305, 30);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 610, 460);

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
    // Generated using JFormDesigner Evaluation license - Yang
    private JPanel panel1;
    private JLabel cover;
    private JTextArea textArea6;
    private JTextArea textArea7;
    private JTextArea textArea8;
    private JTextArea textArea9;
    private JTextArea textArea10;
    private JTextField author;
    private JTextField title;
    private JTextField publisher;
    private JTextField publishTIme;
    private JTextField ISBN;
    private JTextField bookNumber;
    private JButton addBookButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
