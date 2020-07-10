package PublicComp;/*
 * Created by JFormDesigner on Mon Jun 08 22:14:54 CST 2020
 */

import Admin.AddBookFrame;
import Beans.Book;
import Beans.Reader;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Yang
 */
public class SearchPanel extends JPanel{
    int source;//表明是从admin打开的还是reader打开的，这样里面点击书本打开界面才会不同
    //1为admin 2为reader

    Reader reader=null;
    ArrayList<Book> books;

    public SearchPanel(int source){
        this.source=source;
        initComponents();
        init();
    }

    public SearchPanel(int source,Reader reader){
        this.reader=reader;
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
        GridBagConstraints c=null;
        books=new ArrayList<>();
        books.add(new Book("1234","测试","作者",null));
        books.add(new Book("1234","测试","作者",null));
        books.add(new Book("1234","测试","作者",null));
        books.add(new Book("1234","测试","作者",null));
        books.add(new Book("1234","测试","作者",null));
        books.add(new Book("1234","测试","作者",null));
        books.add(new Book("1234","测试","作者",null));
        books.add(new Book("1234","测试","作者",null));
        books.add(new Book("1234","测试","作者",null));
        books.add(new Book("1234","测试","作者",null));
        books.add(new Book("1234","测试","作者",null));
        books.add(new Book("1234","测试","作者",null));

        //装载book到ui
        for(int i=0;i<books.size();i++){
            c=new GridBagConstraints();
            if((i+1)%8==0){
                c.gridwidth=GridBagConstraints.REMAINDER;
                c.fill=GridBagConstraints.BOTH;
            }
            BookBriefPanel briefPanel=new BookBriefPanel(books.get(i),reader,source);
            gridBag.addLayoutComponent(briefPanel,c);
            panel1.add(briefPanel);

        }


        //请求books


        //添加searchButton的监听
//        searchButton.addActionListener(e -> {
//            try{
//
//            }catch(){
//
//            }
//        });
    }


    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        addBookButton = new JButton();

        //======== this ========
        setOpaque(false);
        setBackground(Color.white);
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
        EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing
        . border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,
        java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
        { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )
        throw new RuntimeException( ) ;} } );
        setLayout(null);

        //---- textField1 ----
        textField1.setToolTipText("\u4e66\u540d/\u4f5c\u8005/ISBN");
        add(textField1);
        textField1.setBounds(215, 35, 510, 25);

        //---- button1 ----
        button1.setIcon(new ImageIcon(getClass().getResource("/Source/search.png")));
        button1.setBorder(LineBorder.createBlackLineBorder());
        button1.setBorderPainted(false);
        button1.setOpaque(false);
        button1.setBackground(Color.white);
        add(button1);
        button1.setBounds(740, 35, 25, 25);

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
    // Generated using JFormDesigner Evaluation license - Yang
    private JTextField textField1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JPanel panel1;
    private JButton addBookButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
