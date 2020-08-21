package Admin;/*
 * Created by JFormDesigner on Mon Jun 08 23:16:00 CST 2020
 */

import Beans.Reader;
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
    public BookItemPanel(Record record,ReaderManagePanel parentPanel) {
        this.record=record;
        initComponents();
        bookName.setText(String.valueOf(record.getBookName()));
        borrowTime.setText(String.valueOf(record.getBorrowDate()));
        returnTime.setText(String.valueOf(record.getReturnDate()));
        deleteButton.addActionListener(e->{
            //删除逻辑
            DBConnect db=new DBConnect();
            int result=db.returnBook(record);
            if(result==0){
                JOptionPane.showMessageDialog(this,"还书成功");
                parentPanel.updateBorrowInfo(record.getReaderId());
            }else if(result==1){
                JOptionPane.showMessageDialog(this,"传入信息有误或数据库信息异常");
            }else{
                JOptionPane.showMessageDialog(this,"系统出错");
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        bookName = new JTextArea();
        borrowTime = new JTextArea();
        returnTime = new JTextArea();
        deleteButton = new JButton();

        //======== this ========
        setBackground(Color.white);
        setBorder(null);
        setPreferredSize(new Dimension(855, 30));
        setLayout(null);

        //---- bookName ----
        bookName.setText("\u4e66\u540d");
        bookName.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        bookName.setOpaque(false);
        bookName.setEditable(false);
        bookName.setBorder(LineBorder.createBlackLineBorder());
        add(bookName);
        bookName.setBounds(0, 0, 130, 30);

        //---- borrowTime ----
        borrowTime.setText("\u501f\u4e66\u65f6\u95f4");
        borrowTime.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        borrowTime.setOpaque(false);
        borrowTime.setEditable(false);
        borrowTime.setBorder(LineBorder.createBlackLineBorder());
        add(borrowTime);
        borrowTime.setBounds(130, 0, 260, 30);

        //---- returnTime ----
        returnTime.setText("\u5e94\u8fd8\u65f6\u95f4");
        returnTime.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        returnTime.setOpaque(false);
        returnTime.setEditable(false);
        returnTime.setBorder(LineBorder.createBlackLineBorder());
        add(returnTime);
        returnTime.setBounds(390, 0, 300, 30);

        //---- deleteButton ----
        deleteButton.setText("\u5220\u9664\u8bb0\u5f55");
        deleteButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        deleteButton.setBackground(new Color(89, 143, 209));
        deleteButton.setForeground(Color.white);
        deleteButton.setBorder(null);
        add(deleteButton);
        deleteButton.setBounds(690, 0, 165, 30);

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
    private JTextArea bookName;
    private JTextArea borrowTime;
    private JTextArea returnTime;
    private JButton deleteButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
