/*
 * Created by JFormDesigner on Mon Jun 08 22:58:43 CST 2020
 */

package Reader;

import Beans.Reader;
import Beans.Record;
import Utils.DBConnect;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Yang
 */
public class BorrowInfoPanel extends JPanel{
    DBConnect db;
    ArrayList<Record> records;

    public BorrowInfoPanel(DBConnect db){
        this.db=db;
        initComponents();
        init();
    }

    private void init(){
        GridBagLayout gridBag=(GridBagLayout)panel1.getLayout();    // 布局管理器
        GridBagConstraints c=null;
        //请求还书记录逻辑
        records=new ArrayList<>();

        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));
        records.add(new Record(1,1,1,"测试","2020-6-9","2020-6-9"));


        for(int i=0;i<records.size();i++){
            c=new GridBagConstraints();
            c.gridwidth=GridBagConstraints.REMAINDER;
            c.fill=GridBagConstraints.BOTH;
            BorrowItemPanel briefPanel=new BorrowItemPanel(records.get(i),db);
            gridBag.addLayoutComponent(briefPanel,c);
            panel1.add(briefPanel);
        }

    }

    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Yang
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();

        //======== this ========
        setOpaque(false);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
        .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); }} );
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
    private JScrollPane scrollPane1;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
