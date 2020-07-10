/*
 * Created by JFormDesigner on Mon Jun 08 23:40:36 CST 2020
 */

package Reader;

import Beans.Book;
import Beans.Reader;

import Beans.Record;
import PublicComp.LoginFrame;
import Utils.DBConnect;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import java.util.ArrayList;


/**
 * @author Yang
 */
public class BookDetailFrame extends JFrame {
    String INisbn;
    String ID;
    Book bookInf = null;
    Vector<String> borrowedBookId = new  Vector<String>();  //存放已借阅书籍bookid
    Vector<String> unBorrowedBookId = new Vector<String>();  //存放未借阅书籍bookid


    public BookDetailFrame(String INisbn,String ID) throws SQLException, ClassNotFoundException {
        this.INisbn= INisbn;
        this.ID=ID;
        initComponents();
        init();
    }

    private void init(){

        //请求有哪些id并填充jlist


        borrowBook.addActionListener(e->{
            //获取选中的jradiobutton中的id并提交请求
            int selectIndex = jList.getSelectedIndex();
            if(selectIndex == -1)
                JOptionPane.showMessageDialog(null,"请选择需要借阅的书籍","Error",JOptionPane.ERROR_MESSAGE);
            else if(selectIndex >= unBorrowedBookId.size())
                JOptionPane.showMessageDialog(null,"所选书籍已借阅，请选择尚未被借阅书籍","Error",JOptionPane.ERROR_MESSAGE);
            else{
                try {
                    DBConnect db = new DBConnect();
                    String selectBookId = unBorrowedBookId.get(selectIndex);
                    Vector<String> bookMes = updateInfAndToString();   //再次查找最新借阅信息，防止刷新不及时借阅到已经借阅的图书
                    boolean isBookBeBorrowed = false; //标识书本是否被借阅
                    for(String i : borrowedBookId){
                        if(borrowedBookId.equals(selectBookId)){
                            isBookBeBorrowed = true;
                            break;
                        }
                    }

                    if(isBookBeBorrowed == true)
                        JOptionPane.showMessageDialog(null,"所选书籍已借阅，请选择尚未被借阅书籍","Error",JOptionPane.ERROR_MESSAGE);
                     else{
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                        Date date = new Date();
                        String borrowTime = df.format(date);
                        long longTime = date.getTime();
                        long day = 90;    //借书时间未90天
                        day = day * 24 * 60 * 60 * 1000;
                        longTime += day;
                        date = new Date(longTime);
                        String returnTiem = df.format(date);

                        DBConnect db2 = new DBConnect();
                        int statue = db2.borrowBook(new Record(0,Integer.parseInt(selectBookId),Integer.parseInt(ID),null,borrowTime,returnTiem));
                        if(statue == 0)
                            JOptionPane.showMessageDialog(null,"借阅成功，请在" + returnTiem + "之前归还图书。","Success",JOptionPane.INFORMATION_MESSAGE);
                        else if(statue == 1)
                            JOptionPane.showMessageDialog(null,"你的借书数量已达上限！","Error",JOptionPane.ERROR_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null,"系统错误，请稍后重试","Error",JOptionPane.ERROR_MESSAGE);
                    }

                    Vector<String> bookMes2 = updateInfAndToString();   //再次查找最新借阅信息，防止刷新不及时借阅到已经借阅的图书
                    jList.setListData(bookMes2);

                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }


        });

        this.setVisible(true);
    }


    private void initComponents() throws SQLException, ClassNotFoundException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        DBConnect db = new DBConnect();
        bookInf = db.getDetailedBookInf(INisbn);

        panel1 = new JPanel();

        ImageIcon coverImage = bookInf.getCover();
        coverImage.setImage(coverImage.getImage().getScaledInstance(150,coverImage.getIconHeight()*150/coverImage.getIconWidth(),Image.SCALE_DEFAULT));
        cover = new JLabel(coverImage);
        title = new JTextArea(bookInf.getTitle());
        authors = new JTextArea(bookInf.getAuthors());
        publisher = new JTextArea(bookInf.getPublisher());
        publishTime = new JTextArea(bookInf.getPublishDate());
        ISBN = new JTextArea(bookInf.getISBN());

        textArea6 = new JTextArea();
        textArea7 = new JTextArea();
        textArea8 = new JTextArea();
        textArea9 = new JTextArea();
        borrowBook = new JButton();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        idList = new JList();

        //======== this ========
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
            . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder
            . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .
            awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder( )) )
            ; panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
            ;
            panel1.setLayout(null);

            //---- cover ----
            //cover.setBackground(Color.white);
            cover.setOpaque(true);
            panel1.add(cover);
            cover.setBounds(45, 15, 150, 215);

            //---- title ----
            title.setFocusable(false);
            title.setOpaque(false);
            title.setEditable(false);
            title.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 20));
            panel1.add(title);
            title.setBounds(225, 15, 100, 35);

            //---- authors ----
            authors.setFocusable(false);
            authors.setOpaque(false);
            authors.setEditable(false);
            authors.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            panel1.add(authors);
            authors.setBounds(310, 80, 250, 25);

            //---- publisher ----
            publisher.setFocusable(false);
            publisher.setOpaque(false);
            publisher.setEditable(false);
            publisher.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            panel1.add(publisher);
            publisher.setBounds(310, 115, 250, 25);

            //---- publishTime ----
            publishTime.setFocusable(false);
            publishTime.setOpaque(false);
            publishTime.setEditable(false);
            publishTime.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            panel1.add(publishTime);
            publishTime.setBounds(310, 150, 250, 25);

            //---- ISBN ----
            ISBN.setFocusable(false);
            ISBN.setOpaque(false);
            ISBN.setEditable(false);
            ISBN.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            panel1.add(ISBN);
            ISBN.setBounds(310, 185, 250, 25);

            //---- textArea6 ----
            textArea6.setFocusable(false);
            textArea6.setOpaque(false);
            textArea6.setEditable(false);
            textArea6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea6.setText("\u4f5c\u8005\uff1a");
            panel1.add(textArea6);
            textArea6.setBounds(230, 80, 60, 25);

            //---- textArea7 ----
            textArea7.setFocusable(false);
            textArea7.setOpaque(false);
            textArea7.setEditable(false);
            textArea7.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea7.setText("\u51fa\u7248\u793e\uff1a");
            panel1.add(textArea7);
            textArea7.setBounds(230, 115, 60, 25);

            //---- textArea8 ----
            textArea8.setFocusable(false);
            textArea8.setOpaque(false);
            textArea8.setEditable(false);
            textArea8.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea8.setText("\u51fa\u7248\u65f6\u95f4\uff1a");
            panel1.add(textArea8);
            textArea8.setBounds(230, 150, 80, 25);

            //---- textArea9 ----
            textArea9.setFocusable(false);
            textArea9.setOpaque(false);
            textArea9.setEditable(false);
            textArea9.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea9.setText("ISBN\uff1a");
            panel1.add(textArea9);
            textArea9.setBounds(230, 185, 80, 25);

            //---- borrowBook ----
            borrowBook.setText("\u501f\u4e66");
            borrowBook.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
            borrowBook.setBackground(new Color(89, 143, 209));
            borrowBook.setForeground(Color.white);
            borrowBook.setBorder(null);
            panel1.add(borrowBook);
            borrowBook.setBounds(150, 410, 305, 30);

            //-------列表框提示信息---------
            JTextArea textArea10 = new JTextArea();
            textArea10.setFocusable(false);
            textArea10.setOpaque(false);
            textArea10.setEditable(false);
            textArea10.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
            textArea10.setText(String.format("   %-30s%-40s%-20s","书本ID","是否被借阅","归还日期"));
            panel1.add(textArea10);
            textArea10.setBounds(35, 240, 535, 20);

            //======== panel2 ========
            {
                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                Vector<String> booksMes = updateInfAndToString();
                jList = new JList(booksMes);
                //System.out.print(booksMes);



                JScrollPane jScrollPane = new JScrollPane(jList);
                jScrollPane.setPreferredSize(new Dimension(520,130));
                panel2.add(jScrollPane);
                //panel2.setLayout(null);

//                //======== scrollPane1 ========
//                {
//                    scrollPane1.setViewportView(panel2);
//                }
//                panel1.add(scrollPane1);
//                scrollPane1.setBounds(0, 0, 525, 135);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }

            panel1.add(panel2);
            panel2.setBounds(40, 260, 525, 135);

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
            this.setResizable(false);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new BookDetailFrame("9787020002207","7");
    }

    Vector<String> updateInfAndToString() throws SQLException, ClassNotFoundException {   //返回书本详细信息，并转化为string
        unBorrowedBookId.clear();
        borrowedBookId.clear();
        Vector<String> bookInf = new Vector<String>();
        DBConnect db = new DBConnect();
        Vector<Record>  borrowedBookRecord =  db.queryBorrowedBookRecord(INisbn);   //已借阅
        DBConnect db2 = new DBConnect();
        Vector<String>  unBorrowedBookRecord = db2.queryAvailableBook(INisbn);    //未借阅
        for(String i : unBorrowedBookRecord){
            unBorrowedBookId.add(i);
            bookInf.add(String.format("%-50s否",i));
        }

        for(Record i : borrowedBookRecord){
            borrowedBookId.add(String.valueOf(i.getBookId()));
            bookInf.add(String.format("%-50s是%40s%20s",i.getBookId(),"",i.getReturnDate()));
        }
        return bookInf;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Yang
    private JPanel panel1;
    private JLabel cover;
    private JTextArea title;
    private JTextArea authors;
    private JTextArea publisher;
    private JTextArea publishTime;
    private JTextArea ISBN;
    private JTextArea textArea6;
    private JTextArea textArea7;
    private JTextArea textArea8;
    private JTextArea textArea9;
    private JButton borrowBook;
    private JPanel panel2;

    JList jList;   //书本信息jList
    private JScrollPane scrollPane1;
    private JList idList;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}


