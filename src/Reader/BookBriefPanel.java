/*
 * Created by JFormDesigner on Mon Jun 08 22:33:49 CST 2020
 */

package Reader;

import javax.swing.border.*;
import Beans.Book;

import java.awt.*;
import javax.swing.*;

/**
 * @author Yang
 */
public class BookBriefPanel extends JPanel {
    Book bookInfo;
    public BookBriefPanel(Book book) {
        this.bookInfo=book;
        initComponents();
        if(bookInfo.getCover()!=null){
            bookCover.setIcon(bookInfo.getCover());
        }
        bookName.setText(bookInfo.getTitle());
        bookAuthor.setText(bookInfo.getAuthors());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        bookCover = new JLabel();
        bookName = new JTextArea();
        bookAuthor = new JTextArea();

        //======== this ========
        setBackground(Color.white);
        setOpaque(false);
        setPreferredSize(new Dimension(110, 210));
        setBorder(null);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //---- bookCover ----
        bookCover.setBackground(Color.white);
        add(bookCover);
        bookCover.setBounds(15, 10, 100, 140);

        //---- bookName ----
        bookName.setFocusable(false);
        bookName.setOpaque(false);
        bookName.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.BOLD, 16));
        add(bookName);
        bookName.setBounds(5, 150, 120, 30);

        //---- bookAuthor ----
        bookAuthor.setFocusable(false);
        bookAuthor.setOpaque(false);
        bookAuthor.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        add(bookAuthor);
        bookAuthor.setBounds(5, 180, 120, 30);

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
    private JLabel bookCover;
    private JTextArea bookName;
    private JTextArea bookAuthor;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
