package UI_;

import Mangerdata.MangerMembers;
import Mangerdata.MangerRelation;
import Mysql.Mysql;
import OBJ.Members;
import OBJ.Releation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class UI6 extends JFrame {


    UI6()
    {

        String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        }
        catch (Exception E)
        {

        }

        setTitle("社团成员添加");
        setResizable(false);
        setBounds(550, 100, 400, 600);
        setLayout(null);



        JTextField jTextField=new JTextField();
        JTextField jTextField1=new JTextField();
        JTextField jTextField2=new JTextField();
        JTextField jTextField3=new JTextField();
        jTextField.setColumns(18);
        jTextField1.setColumns(18);
        jTextField2.setColumns(18);
        jTextField3.setColumns(18);

        jTextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int keyChar = e.getKeyChar();
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){

                }else{
                    e.consume(); //关键，屏蔽掉非法输入
                }
            }
        });
        jTextField2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int keyChar = e.getKeyChar();
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){

                }else{
                    e.consume(); //关键，屏蔽掉非法输入
                }
            }
        });

        JButton jButton=new JButton("确定");
        JButton jButton1=new JButton("重置");

        JLabel lblNewLabel = new JLabel("兴趣爱好：");
        JLabel lblNewLabel_1 = new JLabel("学生姓名:");
        JLabel lblNewLabel_2 = new JLabel("学生年龄:");
        JLabel lblNewLabel_3 = new JLabel("学生性别:");
        JLabel lblNewLabel_4 = new JLabel("       学生ID:");
        JLabel lblNewLabel_5 = new JLabel("所属院系:");
        JLabel lblNewLabel_6 = new JLabel("         社团ID:");

        JTextArea jTextArea = new JTextArea(100,100);


        ButtonGroup buttonGroup=new ButtonGroup();
        JRadioButton man = new JRadioButton("男");
        man.setSelected(true);
        buttonGroup.add(man);

        JRadioButton woman = new JRadioButton("女");
        buttonGroup.add(woman);

        JComboBox jComboBox = new JComboBox();
        jComboBox.addItem("请选择");
        jComboBox.addItem("计数");
        jComboBox.addItem("生环");
        jComboBox.addItem("机电");
        jComboBox.addItem("外语");

        Container c=getContentPane();
        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        panel.setLayout(new FlowLayout((FlowLayout.LEFT)));
        panel1.setLayout(new FlowLayout((FlowLayout.LEFT)));
        panel2.setLayout(new FlowLayout((FlowLayout.LEFT)));
        panel3.setLayout(new FlowLayout((FlowLayout.LEFT)));
        panel.setBounds(0,50,500,100);
        panel1.setBounds(0,150,500,100);
        panel2.setBounds(0,250,500,100);
        panel3.setBounds(0,350,500,150);
        panel4.setBounds(0,520,400,100);
        panel.add(lblNewLabel_1);
        panel.add(jTextField);
        panel.add(lblNewLabel_2);
        panel.add(jTextField1);
        panel1.add(lblNewLabel_3);
        panel1.add(man);
        panel1.add(woman);
        panel1.add(lblNewLabel_4);
        panel1.add(jTextField2);
        panel2.add(lblNewLabel_5);
        panel2.add(jComboBox);
        panel2.add(lblNewLabel_6);
        panel2.add(jTextField3);
        panel3.add(lblNewLabel);
        panel3.add(jTextArea);
        panel4.add(jButton);
        panel4.add(jButton1);





        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Members members=new Members(Integer.parseInt(jTextField2.getText()),jTextField.getText(),getRadioTest(buttonGroup),Integer.parseInt(jTextField1.getText()),jComboBox.getSelectedItem().toString(),jTextArea.getText());

                Mysql mysql1=new Mysql();
                if(MangerRelation.IDisExist(Integer.parseInt(jTextField2.getText())))
                {
                    JOptionPane.showMessageDialog(null,"该学生ID被注册","提示",JOptionPane.INFORMATION_MESSAGE);
                }

                Mysql mysql2=new Mysql();
                if(!MangerRelation.IDisExist(Integer.parseInt(jTextField2.getText()))){
                Mysql mysql3=new Mysql();
                int res1=MangerMembers.AddMembers(members);
                Mysql mysql4=new Mysql();
                int res2=MangerRelation.AddRelation(new Releation(Integer.parseInt(jTextField3.getText()),Integer.parseInt(jTextField2.getText())));
                if(res1>0&&res2>0)
                    {
                        JOptionPane.showMessageDialog(null,"添加成功","提示",JOptionPane.INFORMATION_MESSAGE);
                    }
                else{
                    JOptionPane.showMessageDialog(null,"添加失败","警告",JOptionPane.ERROR_MESSAGE);
                }
                }
            }
        });

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              dispose();
              new UI6().setVisible(true);
            }
        });

       c.add(panel);
       c.add(panel1);
       c.add(panel2);
       c.add(panel3);
       c.add(panel4);

       setVisible(true);
    }


    String getRadioTest(ButtonGroup buttonGroup)
    {
        String res="男";
        Enumeration<AbstractButton> radioBtns=buttonGroup.getElements();
        while (radioBtns.hasMoreElements()) {
            AbstractButton btn = radioBtns.nextElement();
            if(btn.isSelected()){
               res=btn.getText();
                break;
            }
        }
        return res;
    }
}
class  test6
{
    public static void main(String[] args) {
        UI6 ui6=new UI6();
    }
}