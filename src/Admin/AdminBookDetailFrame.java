/*
 * Created by JFormDesigner on Mon Jun 08 23:40:36 CST 2020
 */

package Admin;

import Beans.Book;
import Beans.Reader;
import Beans.Record;
import PublicComp.BookBriefPanel;
import Utils.DBConnect;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author Yang
 */
public class AdminBookDetailFrame extends JFrame{
    Book book;
    Book bookInf = null;
    Vector<Record> records = new Vector<Record>();

    public AdminBookDetailFrame(Book book) throws SQLException, ClassNotFoundException {
        super("书籍详情信息");
        this.book=book;
        initComponents();
        init();
        this.setVisible(true);
    }

    private void init(){
        GridBagLayout gridBag=(GridBagLayout)panel2.getLayout();    // 布局管理器
        GridBagConstraints c=null;

        //请求record逻辑

//        //装载record到ui
//        for(int i=0;i<records.size();i++){
//            c=new GridBagConstraints();
//            c.gridwidth=GridBagConstraints.REMAINDER;
//            c.fill=GridBagConstraints.BOTH;
//            BookItemPanel bookItemPanel=new BookItemPanel(records.get(i));
//            gridBag.addLayoutComponent(bookItemPanel,c);
//            panel2.add(bookItemPanel);
//        }
    }

    private void initComponents() throws SQLException, ClassNotFoundException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        DBConnect db = new DBConnect();
        bookInf = db.getDetailedBookInf(book.getISBN());

        panel1 = new JPanel();
        //填充信息
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
        scrollPane1 = new JScrollPane();
        panel2 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);


        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
            .EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER,javax
            .swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,
            12),java.awt.Color.red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans
            .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".equals(e.
            getPropertyName()))throw new RuntimeException();}});
            panel1.setLayout(null);

            //---- cover ----
            cover.setBackground(Color.white);
            cover.setOpaque(true);
            panel1.add(cover);
            cover.setBounds(40, 10, 150, 215);

            //---- title ----
            title.setFocusable(false);
            title.setOpaque(false);
            title.setEditable(false);
            title.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 20));
            panel1.add(title);
            title.setBounds(220, 10, 100, 35);

            //---- authors ----
            authors.setFocusable(false);
            authors.setOpaque(false);
            authors.setEditable(false);
            authors.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            panel1.add(authors);
            authors.setBounds(305, 75, 250, 25);

            //---- publisher ----
            publisher.setFocusable(false);
            publisher.setOpaque(false);
            publisher.setEditable(false);
            publisher.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            panel1.add(publisher);
            publisher.setBounds(305, 110, 250, 25);

            //---- publishTime ----
            publishTime.setFocusable(false);
            publishTime.setOpaque(false);
            publishTime.setEditable(false);
            publishTime.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            panel1.add(publishTime);
            publishTime.setBounds(305, 145, 250, 25);

            //---- ISBN ----
            ISBN.setFocusable(false);
            ISBN.setOpaque(false);
            ISBN.setEditable(false);
            ISBN.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            panel1.add(ISBN);
            ISBN.setBounds(305, 180, 250, 25);

            //---- textArea6 ----
            textArea6.setFocusable(false);
            textArea6.setOpaque(false);
            textArea6.setEditable(false);
            textArea6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea6.setText("\u4f5c\u8005\uff1a");
            panel1.add(textArea6);
            textArea6.setBounds(225, 75, 60, 25);

            //---- textArea7 ----
            textArea7.setFocusable(false);
            textArea7.setOpaque(false);
            textArea7.setEditable(false);
            textArea7.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea7.setText("\u51fa\u7248\u793e\uff1a");
            panel1.add(textArea7);
            textArea7.setBounds(225, 110, 60, 25);

            //---- textArea8 ----
            textArea8.setFocusable(false);
            textArea8.setOpaque(false);
            textArea8.setEditable(false);
            textArea8.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea8.setText("\u51fa\u7248\u65f6\u95f4\uff1a");
            panel1.add(textArea8);
            textArea8.setBounds(225, 145, 80, 25);

            //---- textArea9 ----
            textArea9.setFocusable(false);
            textArea9.setOpaque(false);
            textArea9.setEditable(false);
            textArea9.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            textArea9.setText("ISBN\uff1a");
            panel1.add(textArea9);
            textArea9.setBounds(225, 180, 80, 25);


            //-------列表框提示信息---------
            JTextArea textArea10 = new JTextArea();
            textArea10.setFocusable(false);
            textArea10.setOpaque(false);
            textArea10.setEditable(false);
            textArea10.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
            textArea10.setText(String.format("%-20s%-10s%-10s%-30s%-20s","书本ID","是否被借阅","借阅人ID","借阅日期","归还日期"));
            panel1.add(textArea10);
            textArea10.setBounds(35, 260, 535, 20);



            //======== scrollPane1 ========
            {
                scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                //======== panel2 ========
                {
                    panel2.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0};
                    ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0};
                    ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                    getBookMes();
                    jList = new JList(toListString());   //初始化列表
                    jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                    JScrollPane jScrollPaneOfJList = new JScrollPane(jList);
                    jScrollPaneOfJList.setPreferredSize(new Dimension(530,200));
                    panel2.add(jScrollPaneOfJList);  //添加到面板
                }
                scrollPane1.setViewportView(panel2);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(35, 280, 535, 205);

            //---- delBook ----
            delBook = new JButton("删除书本");
            panel1.add(delBook);
            delBook.setBounds(430, 490, 140, 25);
            delBook.addActionListener(e->{

                int[] selectedIndices = jList.getSelectedIndices();  //获取列表所选的书籍
                if(selectedIndices.length == 0)   //未选择书籍
                    JOptionPane.showMessageDialog(null,"未选中书籍","提示",JOptionPane.INFORMATION_MESSAGE);
                else{
                    //确认是否删除书籍
                    int opt = JOptionPane.showConfirmDialog(null,
                            "是否删除所选的" + selectedIndices.length + "本书籍并删除书籍的借阅信息？", "确认信息",
                            JOptionPane.YES_NO_OPTION);
                    if(opt == JOptionPane.YES_OPTION){
                        for(int i : selectedIndices){
                            DBConnect db1 = new DBConnect();
                            if(records.get(i).getReaderId() == -1){   //所选书本未借出
                                db1.deleteAvailableBook(records.get(i).getBookId());
                            }
                            else{   //所选书本已借出
                                db1.deleteBorrowedBook(records.get(i));
                            }
                        }
                        getBookMes();
                        jList.setListData(toListString());
                        JOptionPane.showMessageDialog(null,"删除书本成功","提示",JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            });


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
        panel1.setBounds(0, 0, 610, 520);

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


    void getBookMes(){   //获取书籍信息
        records.clear();
        DBConnect db = new DBConnect();
        records = db.queryBorrowedBookRecord(book.getISBN());//已经借阅
        Vector<String> unBorrowedBookRecord = db.queryAvailableBook(book.getISBN());//未借阅
        for(String i : unBorrowedBookRecord)
            records.add(new Record(0,Integer.parseInt(i),-1,null,null,null));
    }

    Vector<String> toListString(){    //将书籍信息转换成放在列表中的字符串
        Vector<String> listString = new Vector<String>();
        for(Record i : records){
            if(i.getReaderId() != -1){   //已经借阅
                listString.add(String.format("%-30s%-20s%-20s%-40s%-20s",i.getBookId(),"是",i.getReaderId(),i.getBorrowDate(),i.getReturnDate()));
            }
            else{        //未借阅
                listString.add(String.format("%-30s%-20s",i.getBookId(),"否"));
            }
        }

        return listString;
    }



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new AdminBookDetailFrame(new Book("9787020002207",null,null,null));
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
    private JScrollPane scrollPane1;
    private JPanel panel2;
    private JButton delBook;   //删除某本书
    JList jList;   //书本信息jList
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
