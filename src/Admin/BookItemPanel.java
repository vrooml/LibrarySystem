package Admin;/*
 * Created by JFormDesigner on Mon Jun 08 23:16:00 CST 2020
 */

import Beans.Record;
import Utils.DBConnect;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Yang
 */
public class BookItemPanel extends JPanel {
    Record record;
    public BookItemPanel(Record record) {
        this.record=record;
        initComponents();
        bookId.setText(String.valueOf(record.getBookId()));
        readerId.setText(String.valueOf(record.getReaderId()));

        deleteBook.addActionListener(e->{
            //删除逻辑
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        bookId = new JTextArea();
        deleteBook = new JButton();
        readerId = new JTextArea();

        //======== this ========
        setBackground(Color.white);
        setBorder(null);
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder (
        0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder
        . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .
        red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java .
        beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(null);

        //---- bookId ----
        bookId.setText("\u4e66id");
        bookId.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        bookId.setOpaque(false);
        bookId.setEditable(false);
        bookId.setBorder(LineBorder.createBlackLineBorder());
        add(bookId);
        bookId.setBounds(0, 0, 110, 30);

        //---- deleteBook ----
        deleteBook.setText("\u5220\u9664");
        deleteBook.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        deleteBook.setBackground(new Color(89, 143, 209));
        deleteBook.setForeground(Color.white);
        deleteBook.setBorder(null);
        add(deleteBook);
        deleteBook.setBounds(330, 0, 205, 30);

        //---- readerId ----
        readerId.setText("\u501f\u4e66\u4ebaid");
        readerId.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        readerId.setOpaque(false);
        readerId.setEditable(false);
        readerId.setBorder(LineBorder.createBlackLineBorder());
        add(readerId);
        readerId.setBounds(110, 0, 220, 30);

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
    private JTextArea bookId;
    private JButton deleteBook;
    private JTextArea readerId;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
