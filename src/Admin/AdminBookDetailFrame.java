/*
 * Created by JFormDesigner on Mon Jun 08 23:40:36 CST 2020
 */

package Admin;

import Beans.Book;
import Beans.Reader;
import Beans.Record;
import PublicComp.BookBriefPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Yang
 */
public class AdminBookDetailFrame extends JFrame{
    Book book;
    ArrayList<Record> records;

    public AdminBookDetailFrame(Book book){
        this.book=book;
        initComponents();
        init();
    }

    private void init(){
        GridBagLayout gridBag=(GridBagLayout)panel2.getLayout();    // 布局管理器
        GridBagConstraints c=null;
        records=new ArrayList<>();

        //请求record逻辑

        //装载record到ui
        for(int i=0;i<records.size();i++){
            c=new GridBagConstraints();
            c.gridwidth=GridBagConstraints.REMAINDER;
            c.fill=GridBagConstraints.BOTH;
            BookItemPanel bookItemPanel=new BookItemPanel(records.get(i));
            gridBag.addLayoutComponent(bookItemPanel,c);
            panel2.add(bookItemPanel);
        }
    }

    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        panel1=new JPanel();
        cover=new JLabel();
        title=new JTextArea();
        authors=new JTextArea();
        publisher=new JTextArea();
        publishTime=new JTextArea();
        ISBN=new JTextArea();
        textArea6=new JTextArea();
        textArea7=new JTextArea();
        textArea8=new JTextArea();
        textArea9=new JTextArea();
        scrollPane1=new JScrollPane();
        panel2=new JPanel();

        //======== this ========
        Container contentPane=getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
                    new javax.swing.border.EmptyBorder(0,0,0,0),"JFor\u006dDesi\u0067ner \u0045valu\u0061tion"
                    ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
                    ,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12)
                    ,java.awt.Color.red),panel1.getBorder()));
            panel1.addPropertyChangeListener(
                    new java.beans.PropertyChangeListener(){
                        @Override
                        public void propertyChange(java.beans.PropertyChangeEvent e
                        ){
                            if("bord\u0065r".equals(e.getPropertyName())) throw new RuntimeException()
                                    ;
                        }
                    });
            panel1.setLayout(null);

            //---- cover ----
            cover.setBackground(Color.white);
            cover.setOpaque(true);
            panel1.add(cover);
            cover.setBounds(40,10,150,215);

            //---- title ----
            title.setFocusable(false);
            title.setOpaque(false);
            title.setEditable(false);
            title.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,20));
            title.setText("\u4e66\u540d");
            panel1.add(title);
            title.setBounds(220,10,100,35);

            //---- authors ----
            authors.setFocusable(false);
            authors.setOpaque(false);
            authors.setEditable(false);
            authors.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,16));
            authors.setText("\u672a\u77e5");
            panel1.add(authors);
            authors.setBounds(305,75,250,25);

            //---- publisher ----
            publisher.setFocusable(false);
            publisher.setOpaque(false);
            publisher.setEditable(false);
            publisher.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,16));
            publisher.setText("\u672a\u77e5");
            panel1.add(publisher);
            publisher.setBounds(305,110,250,25);

            //---- publishTime ----
            publishTime.setFocusable(false);
            publishTime.setOpaque(false);
            publishTime.setEditable(false);
            publishTime.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,16));
            publishTime.setText("\u672a\u77e5");
            panel1.add(publishTime);
            publishTime.setBounds(305,145,250,25);

            //---- ISBN ----
            ISBN.setFocusable(false);
            ISBN.setOpaque(false);
            ISBN.setEditable(false);
            ISBN.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,16));
            ISBN.setText("\u672a\u77e5");
            panel1.add(ISBN);
            ISBN.setBounds(305,180,250,25);

            //---- textArea6 ----
            textArea6.setFocusable(false);
            textArea6.setOpaque(false);
            textArea6.setEditable(false);
            textArea6.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,16));
            textArea6.setText("\u4f5c\u8005\uff1a");
            panel1.add(textArea6);
            textArea6.setBounds(225,75,60,25);

            //---- textArea7 ----
            textArea7.setFocusable(false);
            textArea7.setOpaque(false);
            textArea7.setEditable(false);
            textArea7.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,16));
            textArea7.setText("\u51fa\u7248\u793e\uff1a");
            panel1.add(textArea7);
            textArea7.setBounds(225,110,60,25);

            //---- textArea8 ----
            textArea8.setFocusable(false);
            textArea8.setOpaque(false);
            textArea8.setEditable(false);
            textArea8.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,16));
            textArea8.setText("\u51fa\u7248\u65f6\u95f4\uff1a");
            panel1.add(textArea8);
            textArea8.setBounds(225,145,80,25);

            //---- textArea9 ----
            textArea9.setFocusable(false);
            textArea9.setOpaque(false);
            textArea9.setEditable(false);
            textArea9.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,16));
            textArea9.setText("ISBN\uff1a");
            panel1.add(textArea9);
            textArea9.setBounds(225,180,80,25);

            //======== scrollPane1 ========
            {
                scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                //======== panel2 ========
                {
                    panel2.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel2.getLayout()).columnWidths=new int[]{0,0};
                    ((GridBagLayout)panel2.getLayout()).rowHeights=new int[]{0,0};
                    ((GridBagLayout)panel2.getLayout()).columnWeights=new double[]{1.0,1.0E-4};
                    ((GridBagLayout)panel2.getLayout()).rowWeights=new double[]{1.0,1.0E-4};
                }
                scrollPane1.setViewportView(panel2);
            }
            panel1.add(scrollPane1);
            scrollPane1.setBounds(35,230,535,205);

            {
                // compute preferred size
                Dimension preferredSize=new Dimension();
                for(int i=0;i<panel1.getComponentCount();i++){
                    Rectangle bounds=panel1.getComponent(i).getBounds();
                    preferredSize.width=Math.max(bounds.x+bounds.width,preferredSize.width);
                    preferredSize.height=Math.max(bounds.y+bounds.height,preferredSize.height);
                }
                Insets insets=panel1.getInsets();
                preferredSize.width+=insets.right;
                preferredSize.height+=insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0,0,610,460);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
