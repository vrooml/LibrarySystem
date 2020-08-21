package PublicComp;/*
 * Created by JFormDesigner on Mon Jun 08 22:14:54 CST 2020
 */

import Admin.AddBookFrame;
import Beans.Book;
import Beans.Reader;
import Utils.DBConnect;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Yang
 */
public class SearchPanel extends JPanel{
    int source;//表明是从admin打开的还是reader打开的，这样里面点击书本打开界面才会不同
    //1为admin 2为reader

    String readerId;
    ArrayList<Book> books;

    public SearchPanel(int source){
        this.source=source;
        initComponents();
        init();
    }

    public SearchPanel(int source,String readerId){
        this.readerId=readerId;
        this.source=source;
        initComponents();
        init();
    }

    private void init(){
        //admin界面显示添加图书按钮
        if(source==1){
            addBookButton.setVisible(true);
            addBookButton.addActionListener(e->{
                new AddBookFrame();
            });
        }else{
            addBookButton.setVisible(false);
        }

        GridBagLayout gridBag=(GridBagLayout)panel1.getLayout();    // 布局管理器
        final GridBagConstraints[] c={null};
        books=new ArrayList<>();

        //请求book
        DBConnect db=new DBConnect();
        Vector<Map<String,Object>> result=db.selectBooksInf("");
        for(int i=0;i<result.size();i++){
            Book book=new Book((String)result.get(i).get("ISBN"),
                    (String)result.get(i).get("title"),
                    (String)result.get(i).get("authors"),
                    (ImageIcon)result.get(i).get("cover"));
            books.add(book);
        }

        //装载book到ui
        for(int i=0;i<books.size();i++){
            c[0]=new GridBagConstraints();
            if((i+1)%7==0){
                c[0].gridwidth=GridBagConstraints.REMAINDER;
                c[0].fill=GridBagConstraints.BOTH;
            }
            BookBriefPanel briefPanel=new BookBriefPanel(books.get(i),readerId,source);
            gridBag.addLayoutComponent(briefPanel,c[0]);
            panel1.add(briefPanel);

        }



//        添加searchButton的监听
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                books.clear();
                Vector<Map<String,Object>> searchResult=db.selectBooksInf(textField1.getText().trim());
                for(int i=0;i<searchResult.size();i++){
                    Book book=new Book((String)searchResult.get(i).get("ISBN"),
                            (String)searchResult.get(i).get("title"),
                            (String)searchResult.get(i).get("authors"),
                            (ImageIcon)searchResult.get(i).get("cover"));
                    books.add(book);
                }

                panel1.removeAll();
                for(int i=0;i<books.size();i++){
                    c[0]=new GridBagConstraints();
                    if((i+1)%7==0){
                        c[0].gridwidth=GridBagConstraints.REMAINDER;
                        c[0].fill=GridBagConstraints.BOTH;
                    }
                    BookBriefPanel briefPanel=new BookBriefPanel(books.get(i),readerId,source);
                    gridBag.addLayoutComponent(briefPanel,c[0]);
                    panel1.add(briefPanel);

                }

            }
        });
    }


    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        textField1 = new JTextField();
        searchButton = new JButton();
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        addBookButton = new JButton();

        //======== this ========
        setOpaque(false);
        setBackground(Color.white);
        setLayout(null);

        //---- textField1 ----
        textField1.setToolTipText("\u4e66\u540d/\u4f5c\u8005/ISBN");
        add(textField1);
        textField1.setBounds(215, 35, 510, 25);

        //---- searchButton ----
        searchButton.setIcon(new ImageIcon(getClass().getResource("/Source/search.png")));
        searchButton.setBorder(LineBorder.createBlackLineBorder());
        searchButton.setBorderPainted(false);
        searchButton.setOpaque(false);
        searchButton.setBackground(Color.white);
        add(searchButton);
        searchButton.setBounds(740, 35, 25, 25);

        //======== scrollPane1 ========
        {
            scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane1.setBackground(Color.white);

            //======== panel1 ========
            {
                panel1.setBorder(LineBorder.createBlackLineBorder());
                panel1.setBackground(Color.white);
                panel1.setOpaque(false);
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};
                ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
            }
            scrollPane1.setViewportView(panel1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(15, 70, 910, 390);

        //---- addBookButton ----
        addBookButton.setText("\u6dfb\u52a0\u56fe\u4e66");
        addBookButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        addBookButton.setBackground(new Color(89, 143, 209));
        addBookButton.setForeground(Color.white);
        addBookButton.setBorder(null);
        add(addBookButton);
        addBookButton.setBounds(810, 30, 115, 30);

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
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField textField1;
    private JButton searchButton;
    private JScrollPane scrollPane1;
    private JPanel panel1;
    private JButton addBookButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
