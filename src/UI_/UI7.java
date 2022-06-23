package UI_;

import Mangerdata.MangerMembers;
import Mangerdata.MangerRelation;
import Mysql.Mysql;
import OBJ.Clubs;
import OBJ.Members;
import Tools.GlobalObject;
import Tools.RenewStudentThrd;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class UI7 extends JFrame {
    UI7( List<Members> list)
    {


        setLayout(null);
        setTitle("成员信息");
        setBounds(400, 0, 1000, 800);
        setLayout(null);
        setResizable(false);

        ImageIcon img=new ImageIcon("imag/8.png");
        JLabel background=new JLabel(img);
        background.setBounds(0,0,1000,800);
        Container c=getContentPane();
        c.add(background,new Integer(Integer.MIN_VALUE));

        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        panel.setBounds(0,100,1000,700);
        panel1.setBounds(0,0,1000,100);

        JButton button=new JButton("返回");
        button.setFont(new Font("华文琥珀", Font.BOLD, 30));
        JButton button1=new JButton("添加成员");
        button1.setFont(new Font("华文琥珀", Font.BOLD, 30));
        JButton button2=new JButton("查看成员参加的社团");
        button2.setFont(new Font("华文琥珀", Font.BOLD, 30));
        JButton button3=new JButton("总计");
        button3.setFont(new Font("华文琥珀", Font.BOLD, 30));

        button.setOpaque(false);
        button1.setOpaque(false);
        button2.setOpaque(false);
        button3.setOpaque(false);

        JLabel label = new JLabel("学 生 社 团 成 员 信 息", SwingConstants.CENTER);
        label.setBounds(0, 50, 1000, 100);
        label.setFont(new Font("华文琥珀", Font.BOLD, 40));
        panel1.add(label);

        Vector Head = new Vector();
        Vector Msg = new Vector();
        MangerMembers.initTable(Msg,Head,list);

        DefaultTableModel model = new DefaultTableModel(Msg, Head);//表格样式
        JTable table1 = new JTable(model){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };

        table1.setOpaque(false);
        table1.getTableHeader().setFont(new Font("华文楷体", Font.BOLD, 20));

        DefaultTableCellRenderer cr = new DefaultTableCellRenderer();
        cr.setHorizontalAlignment(JLabel.CENTER);
        //表格设置透明
        cr.setOpaque(false);
        table1.setOpaque(false);
        table1.setDefaultRenderer(Object.class, cr);

        table1.setFont(new Font("华文楷体", Font.BOLD, 20));
        table1.setRowHeight(40);//改变高度

        GlobalObject.setjTable1(table1);

        JScrollPane jScrollPane = new JScrollPane(table1) {//设置其大小
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(900, 500);
            }
        };
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            UI9 ui9=new UI9();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index=Integer.parseInt(table1.getValueAt(table1.getSelectedRow(),0).toString());
                System.out.println(index);
                Mysql mysql=new Mysql();
                List<Clubs>list=new ArrayList<Clubs>();
                list= MangerRelation.FindClubs(index);
                UI8 ui8=new UI8(list);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"该社团成员人数为："+table1.getRowCount(),"提示",JOptionPane.INFORMATION_MESSAGE);
            }
        });


        jScrollPane.setOpaque(false);
        jScrollPane.getViewport().setOpaque(false);
        panel.add(jScrollPane, BorderLayout.CENTER);
        panel.add(button);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        button.setContentAreaFilled(false);
        button1.setContentAreaFilled(false);
        button2.setContentAreaFilled(false);
        button3.setContentAreaFilled(false);
        panel1.setOpaque(false);
        panel.setOpaque(false);
        background.add(panel);
        background.add(panel1);
        setVisible(true);

    }
}
class test7
{
    public static void main(String[] args) {
        UI7 ui7=new UI7(new ArrayList<>());
    }
}