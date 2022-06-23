package UI_;

import Mangerdata.MangerClubs;
import Mysql.Mysql;
import OBJ.Clubs;
import Tools.RenewClubsThrd;
import Tools.textisNull;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI3 extends JFrame {
    UI3()
    {
        this.setTitle("社团插入信息");
        this.setBounds(500,200,400,200);
        this.setVisible(true);
        setResizable(false);
        this.setLayout(null);

        ImageIcon img = new ImageIcon("imag/10.png");
        JLabel background = new JLabel(img);
        background.setBounds(0, 0, 400, 200);
        final Container c = getContentPane();
        c.add(background, new Integer(Integer.MIN_VALUE));

        JButton button=new JButton("确定");
        JButton button1=new JButton("取消");
        button.setContentAreaFilled(false);//去掉填充
        button1.setContentAreaFilled(false);//去掉填充

        button.setFont(new Font("华文琥珀",Font.BOLD,20));
        button1.setFont(new Font("华文琥珀",Font.BOLD,20));

        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();
        JLabel label1=new JLabel("      ID:      ");
        JLabel label2=new JLabel("社团名称:");
        JLabel label3=new JLabel("社团信息:");

        label1.setFont(new Font("华文琥珀",Font.BOLD,20));
        label2.setFont(new Font("华文琥珀",Font.BOLD,20));
        label3.setFont(new Font("华文琥珀",Font.BOLD,20));

        JTextField textField1=new JTextField(10);
        JTextField textField2=new JTextField(10);
        JTextField textField3=new JTextField(10);


        textField1.setFont(new Font("华文琥珀",Font.BOLD,20));
        textField2.setFont(new Font("华文琥珀",Font.BOLD,20));
        textField3.setFont(new Font("华文琥珀",Font.BOLD,20));

        panel1.setBounds(0,0,400,150);
        panel2.setBounds(0,150,400,150);
        panel3.setBounds(0,300,400,150);
        panel5.setBounds(0,450,400,150);
        panel4.setBounds(0,0,400,600);

        panel1.add(label1,CENTER_ALIGNMENT);
        panel2.add(label2,CENTER_ALIGNMENT);
        panel3.add(label3,CENTER_ALIGNMENT);

        panel1.add(textField1,CENTER_ALIGNMENT);
        panel2.add(textField2,CENTER_ALIGNMENT);
        panel3.add(textField3,CENTER_ALIGNMENT);
        panel5.add(button,CENTER_ALIGNMENT);
        panel5.add(button1,CENTER_ALIGNMENT);

        panel1.setOpaque(false);
        panel2.setOpaque(false);
        panel3.setOpaque(false);
        panel4.setOpaque(false);
        panel5.setOpaque(false);

        panel4.add(panel1);
        panel4.add(panel2);
        panel4.add(panel3);
        panel4.add(panel5);
        background.add(panel4);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mysql mysql=new Mysql();
                if(textisNull.isNull(textField1)||textisNull.isNull(textField2)||textisNull.isNull(textField3))
                {JOptionPane.showMessageDialog(null,"请输入完整的信息","提示",JOptionPane.WARNING_MESSAGE);}
                Integer a=Integer.parseInt(textField1.getText());
                int res=MangerClubs.AddClub(new Clubs(a,textField2.getText(),textField3.getText()));
                if(res>0)
                {   Thread thread=new Thread(new RenewClubsThrd());
                    thread.start();
                    JOptionPane.showMessageDialog(null,"录入成功","提示",JOptionPane.INFORMATION_MESSAGE);}
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             dispose();
            }
        });





    }
}
class test
{
    public static void main(String[] args) {
        UI3 ui3=new UI3();
    }
}


