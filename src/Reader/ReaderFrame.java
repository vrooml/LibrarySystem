/*
 * Created by JFormDesigner on Mon Jun 08 18:53:18 CST 2020
 */

package Reader;

import PublicComp.SearchPanel;

import java.awt.*;
import javax.swing.*;

/**
 * @author Yang
 */
public class ReaderFrame extends JFrame{
    SearchPanel searchPanel;
    ReaderInfoPanel readerInfoPanel;
    BorrowInfoPanel borrowInfoPanel;

    public ReaderFrame(){
        initComponents();
        init();
    }

    private void init(){
        searchPanel=new SearchPanel(2);
        readerInfoPanel=new ReaderInfoPanel();
        borrowInfoPanel=new BorrowInfoPanel();
        cardPanel.add(searchPanel,"search");
        cardPanel.add(readerInfoPanel,"reader");
        cardPanel.add(borrowInfoPanel,"borrow");
        CardLayout cardLayout=(CardLayout)cardPanel.getLayout();
        searchBookButton.addActionListener(e->{
            cardLayout.show(cardPanel,"search");
        });
        readerInfoButton.addActionListener(e->{
            cardLayout.show(cardPanel,"reader");
        });
        borrowInfoButton.addActionListener(e->{
            cardLayout.show(cardPanel,"borrow");
        });
    }

    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        textArea1=new JTextArea();
        userNameField=new JTextArea();
        searchBookButton=new JButton();
        readerInfoButton=new JButton();
        borrowInfoButton=new JButton();
        cardPanel=new JPanel();
        label1=new JLabel();

        //======== this ========
        setVisible(true);
        setResizable(false);
        Container contentPane=getContentPane();
        contentPane.setLayout(null);

        //---- textArea1 ----
        textArea1.setText("\u6b22\u8fce\uff0c");
        textArea1.setFocusable(false);
        textArea1.setOpaque(false);
        textArea1.setEditable(false);
        textArea1.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,26));
        textArea1.setForeground(Color.white);
        contentPane.add(textArea1);
        textArea1.setBounds(20,25,70,textArea1.getPreferredSize().height);

        //---- userNameField ----
        userNameField.setFocusable(false);
        userNameField.setOpaque(false);
        userNameField.setEditable(false);
        userNameField.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,26));
        userNameField.setForeground(Color.white);
        userNameField.setText("\u7528\u6237\u540d");
        contentPane.add(userNameField);
        userNameField.setBounds(90,25,320,35);

        //---- searchBookButton ----
        searchBookButton.setText("\u56fe\u4e66\u68c0\u7d22");
        searchBookButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,14));
        searchBookButton.setBackground(new Color(89,143,209));
        searchBookButton.setForeground(Color.white);
        searchBookButton.setBorder(null);
        contentPane.add(searchBookButton);
        searchBookButton.setBounds(0,130,305,30);

        //---- readerInfoButton ----
        readerInfoButton.setText("\u8bfb\u8005\u4fe1\u606f");
        readerInfoButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,14));
        readerInfoButton.setBackground(new Color(89,143,209));
        readerInfoButton.setForeground(Color.white);
        readerInfoButton.setBorder(null);
        contentPane.add(readerInfoButton);
        readerInfoButton.setBounds(320,130,300,30);

        //---- borrowInfoButton ----
        borrowInfoButton.setText("\u501f\u9605\u4fe1\u606f");
        borrowInfoButton.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1",Font.PLAIN,14));
        borrowInfoButton.setBackground(new Color(89,143,209));
        borrowInfoButton.setForeground(Color.white);
        borrowInfoButton.setBorder(null);
        contentPane.add(borrowInfoButton);
        borrowInfoButton.setBounds(635,130,303,30);

        //======== cardPanel ========
        {
            cardPanel.setOpaque(false);
            cardPanel.addPropertyChangeListener(
                    new java.beans.PropertyChangeListener(){
                        @Override
                        public void propertyChange(java.beans.PropertyChangeEvent e){
                            if("\u0062or\u0064er"
                                    .equals(e.getPropertyName())) throw new RuntimeException();
                        }
                    });
            cardPanel.setLayout(new CardLayout());
        }
        contentPane.add(cardPanel);
        cardPanel.setBounds(0,160,940,470);

        //---- label1 ----
        label1.setFocusable(false);
        label1.setIcon(new ImageIcon(getClass().getResource("/Source/mainBackground2.png")));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(0,0),label1.getPreferredSize()));

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
    private JTextArea textArea1;
    private JTextArea userNameField;
    private JButton searchBookButton;
    private JButton readerInfoButton;
    private JButton borrowInfoButton;
    private JPanel cardPanel;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args){
        new ReaderFrame();
    }
}
