/*
 * Created by JFormDesigner on Mon Jun 08 18:53:18 CST 2020
 */

package Admin;

import Reader.BorrowInfoPanel;
import Reader.ReaderInfoPanel;
import PublicComp.SearchPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Yang
 */
public class AdminFrame extends JFrame{
    SearchPanel searchPanel;
    ReaderManagePanel  readerManagePanel;

    public AdminFrame(){
        initComponents();
        init();
    }

    private void init(){
        searchPanel=new SearchPanel(1);
        readerManagePanel=new ReaderManagePanel();
        cardPanel.add(searchPanel,"search");
        cardPanel.add(readerManagePanel,"reader");
        CardLayout cardLayout=(CardLayout)cardPanel.getLayout();
        searchBookButton.addActionListener(e->{
            cardLayout.show(cardPanel,"search");
        });
        readerInfoButton.addActionListener(e->{
            cardLayout.show(cardPanel,"reader");
        });
    }

    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        textArea1 = new JTextArea();
        adminNameField = new JTextArea();
        searchBookButton = new JButton();
        readerInfoButton = new JButton();
        cardPanel = new JPanel();
        label1 = new JLabel();

        //======== this ========
        setVisible(true);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- textArea1 ----
        textArea1.setText("\u6b22\u8fce\uff0c");
        textArea1.setFocusable(false);
        textArea1.setOpaque(false);
        textArea1.setEditable(false);
        textArea1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 26));
        textArea1.setForeground(Color.white);
        contentPane.add(textArea1);
        textArea1.setBounds(20, 25, 70, textArea1.getPreferredSize().height);

        //---- adminNameField ----
        adminNameField.setFocusable(false);
        adminNameField.setOpaque(false);
        adminNameField.setEditable(false);
        adminNameField.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 26));
        adminNameField.setForeground(Color.white);
        adminNameField.setText("\u7ba1\u7406\u5458");
        contentPane.add(adminNameField);
        adminNameField.setBounds(90, 25, 320, 35);

        //---- searchBookButton ----
        searchBookButton.setText("\u56fe\u4e66\u7ba1\u7406");
        searchBookButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        searchBookButton.setBackground(new Color(89, 143, 209));
        searchBookButton.setForeground(Color.white);
        searchBookButton.setBorder(null);
        contentPane.add(searchBookButton);
        searchBookButton.setBounds(95, 130, 305, 30);

        //---- readerInfoButton ----
        readerInfoButton.setText("\u8bfb\u8005\u7ba1\u7406");
        readerInfoButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 14));
        readerInfoButton.setBackground(new Color(89, 143, 209));
        readerInfoButton.setForeground(Color.white);
        readerInfoButton.setBorder(null);
        contentPane.add(readerInfoButton);
        readerInfoButton.setBounds(540, 130, 300, 30);

        //======== cardPanel ========
        {
            cardPanel.setOpaque(false);
            cardPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
            javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax
            .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
            .awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt
            .Color.red),cardPanel. getBorder()));cardPanel. addPropertyChangeListener(new java.beans.
            PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".
            equals(e.getPropertyName()))throw new RuntimeException();}});
            cardPanel.setLayout(new CardLayout());
        }
        contentPane.add(cardPanel);
        cardPanel.setBounds(0, 160, 940, 470);

        //---- label1 ----
        label1.setFocusable(false);
        label1.setIcon(new ImageIcon(getClass().getResource("/Source/mainBackground2.png")));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(0, 0), label1.getPreferredSize()));

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
    private JTextArea textArea1;
    private JTextArea adminNameField;
    private JButton searchBookButton;
    private JButton readerInfoButton;
    private JPanel cardPanel;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args){
        new AdminFrame();
    }
}
