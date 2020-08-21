/*
 * Created by JFormDesigner on Mon Jun 08 22:58:43 CST 2020
 */

package Reader;

import javax.swing.border.*;
import Beans.Reader;
import Beans.Record;
import Utils.DBConnect;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;

/**
 * @author Yang
 */
public class BorrowInfoPanel extends JPanel{
    ArrayList<Record> records;
    String readerId;

    public BorrowInfoPanel(String readerId){
        this.readerId=readerId;
        initComponents();
        init();
    }

    private void init(){
        GridBagLayout gridBag=(GridBagLayout)panel1.getLayout();    // 布局管理器
        GridBagConstraints c=null;
        //请求还书记录逻辑
        records=new ArrayList<>();

        DBConnect db=new DBConnect();
        Vector<Record> recordResult=db.queryReaderBorrowingRecord(readerId);
        records.addAll(recordResult);

        for(int i=0;i<records.size();i++){
            c=new GridBagConstraints();
            c.gridwidth=GridBagConstraints.REMAINDER;
            c.fill=GridBagConstraints.BOTH;
            BorrowItemPanel borrowItemPanel=new BorrowItemPanel(records.get(i),this);
            gridBag.addLayoutComponent(borrowItemPanel,c);
            panel1.add(borrowItemPanel);
        }

    }

    void update(){
        panel1.removeAll();
        GridBagLayout gridBag=(GridBagLayout)panel1.getLayout();    // 布局管理器
        GridBagConstraints c=null;
        records=new ArrayList<>();

        DBConnect db=new DBConnect();
        Vector<Record> recordResult=db.queryReaderBorrowingRecord(readerId);
        records.addAll(recordResult);

        for(int i=0;i<records.size();i++){
            c=new GridBagConstraints();
            c.gridwidth=GridBagConstraints.REMAINDER;
            c.fill=GridBagConstraints.BOTH;
            BorrowItemPanel borrowItemPanel=new BorrowItemPanel(records.get(i),this);
            gridBag.addLayoutComponent(borrowItemPanel,c);
            panel1.add(borrowItemPanel);
        }
        this.updateUI();
    }

    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        borrowTime = new JTextArea();
        bookName = new JTextArea();
        returnTime = new JTextArea();

        //======== this ========
        setOpaque(false);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
        setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};
            }
            scrollPane1.setViewportView(panel1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(30, 35, 885, 405);

        //---- borrowTime ----
        borrowTime.setText("\u501f\u4e66\u65f6\u95f4");
        borrowTime.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        borrowTime.setEditable(false);
        borrowTime.setBorder(null);
        borrowTime.setFocusable(false);
        borrowTime.setOpaque(false);
        add(borrowTime);
        borrowTime.setBounds(160, 5, 260, 30);

        //---- bookName ----
        bookName.setText("\u4e66\u540d");
        bookName.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        bookName.setEditable(false);
        bookName.setBorder(null);
        bookName.setFocusable(false);
        bookName.setOpaque(false);
        add(bookName);
        bookName.setBounds(30, 5, 130, 30);

        //---- returnTime ----
        returnTime.setText("\u5e94\u8fd8\u65f6\u95f4");
        returnTime.setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 16));
        returnTime.setEditable(false);
        returnTime.setBorder(null);
        returnTime.setFocusable(false);
        returnTime.setOpaque(false);
        add(returnTime);
        returnTime.setBounds(420, 5, 300, 30);

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
    private JScrollPane scrollPane1;
    private JPanel panel1;
    private JTextArea borrowTime;
    private JTextArea bookName;
    private JTextArea returnTime;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
