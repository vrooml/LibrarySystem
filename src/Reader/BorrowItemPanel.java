/*
 * Created by JFormDesigner on Mon Jun 08 23:16:00 CST 2020
 */

package Reader;

import Beans.Record;
import Utils.DBConnect;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Yang
 */
public class BorrowItemPanel extends JPanel {
    Record record;
    DBConnect db;
    public BorrowItemPanel(Record record,DBConnect db) {
        this.record=record;
        this.db=db;
        initComponents();
        bookName.setText(record.getBookName());
        bTime.setText(record.getBorrowDate());
        rTime.setText(record.getReturnDate());

        returnBook.addActionListener(e->{
            //还书逻辑
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        bookName = new JTextArea();
        bTime = new JTextArea();
        rTime = new JTextArea();
        returnBook = new JButton();

        //======== this ========
        setBackground(Color.white);
        setBorder(null);
        setLayout(null);

        //---- bookName ----
        bookName.setText("\u4e66\u540d");
        bookName.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        bookName.setOpaque(false);
        bookName.setEditable(false);
        bookName.setBorder(LineBorder.createBlackLineBorder());
        add(bookName);
        bookName.setBounds(0, 0, 255, 30);

        //---- bTime ----
        bTime.setOpaque(false);
        bTime.setEditable(false);
        bTime.setText("\u501f\u9605\u65f6\u95f4");
        bTime.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        bTime.setBorder(LineBorder.createBlackLineBorder());
        add(bTime);
        bTime.setBounds(255, 0, 240, 30);

        //---- rTime ----
        rTime.setOpaque(false);
        rTime.setEditable(false);
        rTime.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        rTime.setText("\u5e94\u8fd8\u4e66\u65f6\u95f4");
        rTime.setBorder(LineBorder.createBlackLineBorder());
        add(rTime);
        rTime.setBounds(495, 0, 255, 30);

        //---- returnBook ----
        returnBook.setText("\u8fd8\u4e66");
        returnBook.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        returnBook.setBackground(new Color(89, 143, 209));
        returnBook.setForeground(Color.white);
        returnBook.setBorder(null);
        add(returnBook);
        returnBook.setBounds(750, 0, 130, 30);

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
    private JTextArea bookName;
    private JTextArea bTime;
    private JTextArea rTime;
    private JButton returnBook;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
