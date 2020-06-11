/*
 * Created by JFormDesigner on Mon Jun 08 23:40:36 CST 2020
 */

package Reader;

import Beans.Book;
import Beans.Reader;
import Beans.Record;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Yang
 */
public class BookDetailFrame extends JFrame {
    Book book;
    Reader reader;
    public BookDetailFrame(Book book,Reader reader) {
        this.book=book;
        this.reader=reader;
        initComponents();
        init();
    }

    private void init(){

        //请求有哪些id并填充arraylist(应该只显示没被借走的)
        ArrayList<Integer> ids=new ArrayList<>();

        ButtonGroup group=new ButtonGroup();
        for(int i=0;i<ids.size();i++){
            JRadioButton jRadioButton=new JRadioButton(String.valueOf(ids.get(i)));

            group.add(jRadioButton);
            panel2.add(jRadioButton);
        }

        borrowBook.addActionListener(e->{
            //获取选中的jradiobutton中的id并提交请求

        });

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        panel1 = new JPanel();
        cover = new JLabel();
        title = new JTextArea();
        authors = new JTextArea();
        publisher = new JTextArea();
        publishTime = new JTextArea();
        ISBN = new JTextArea();
        textArea6 = new JTextArea();
        textArea7 = new JTextArea();
        textArea8 = new JTextArea();
        textArea9 = new JTextArea();
        borrowBook = new JButton();
        panel2 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(Color.white);
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
            .border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder
            .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.
            awt.Font.BOLD,12),java.awt.Color.red),panel1. getBorder()))
            ;panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}})
            ;
            panel1.setLayout(null);

            //---- cover ----
            cover.setBackground(Color.white);
            cover.setOpaque(true);
            panel1.add(cover);
            cover.setBounds(45, 15, 150, 215);

            //---- title ----
            title.setFocusable(false);
            title.setOpaque(false);
            title.setEditable(false);
            title.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 20));
            title.setText("\u4e66\u540d");
            panel1.add(title);
            title.setBounds(225, 15, 100, 35);

            //---- authors ----
            authors.setFocusable(false);
            authors.setOpaque(false);
            authors.setEditable(false);
            authors.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            authors.setText("\u672a\u77e5");
            panel1.add(authors);
            authors.setBounds(310, 80, 250, 25);

            //---- publisher ----
            publisher.setFocusable(false);
            publisher.setOpaque(false);
            publisher.setEditable(false);
            publisher.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            publisher.setText("\u672a\u77e5");
            panel1.add(publisher);
            publisher.setBounds(310, 115, 250, 25);

            //---- publishTime ----
            publishTime.setFocusable(false);
            publishTime.setOpaque(false);
            publishTime.setEditable(false);
            publishTime.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            publishTime.setText("\u672a\u77e5");
            panel1.add(publishTime);
            publishTime.setBounds(310, 150, 250, 25);

            //---- ISBN ----
            ISBN.setFocusable(false);
            ISBN.setOpaque(false);
            ISBN.setEditable(false);
            ISBN.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
            ISBN.setText("\u672a\u77e5");
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

            //======== panel2 ========
            {
                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
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
    private JButton borrowBook;
    private JPanel panel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
