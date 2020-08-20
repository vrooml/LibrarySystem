/*
 * Created by JFormDesigner on Mon Jun 08 22:33:49 CST 2020
 */

package PublicComp;

import javax.swing.border.*;

import Admin.AdminBookDetailFrame;
import Admin.AdminFrame;
import Beans.Book;
import Beans.Reader;
import Reader.BookDetailFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author Yang
 */
public class BookBriefPanel extends JPanel {
    Book bookInfo;
    Reader reader;
    int source;
    public BookBriefPanel(Book book,Reader reader,int source) {
        this.bookInfo=book;
        this.reader=reader;
        this.source=source;
        initComponents();
        if(bookInfo.getCover()!=null){
            bookCover.setIcon(bookInfo.getCover());
        }
        bookName.setText(bookInfo.getTitle());
        bookAuthor.setText(bookInfo.getAuthors());

        this.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(source==1){
                    try{
                        new AdminBookDetailFrame(book);
                    }catch(SQLException|ClassNotFoundException throwables){
                        throwables.printStackTrace();
                    }
                }else{
                    try{
                        new BookDetailFrame(book.getISBN(),String.valueOf(reader.getReaderId()));
                    }catch(SQLException|ClassNotFoundException throwables){
                        throwables.printStackTrace();
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e){

            }
            @Override
            public void mouseReleased(MouseEvent e){

            }
            @Override
            public void mouseEntered(MouseEvent e){

            }
            @Override
            public void mouseExited(MouseEvent e){

            }
        });
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
