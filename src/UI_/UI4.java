package UI_;

import Mangerdata.MangerUser;
import Mysql.Mysql;
import OBJ.Users;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI4 extends JFrame {
        public UI4()
        {
            setTitle("注册");
            setBounds(500,200,350,200);
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setResizable(false);

            Container c=getContentPane();

            JPanel panel1=new JPanel();
            JPanel panel2=new JPanel();
            JPanel panel3=new JPanel();
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel3.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton jButton1=new JButton("确定");
            JButton jButton2=new JButton("取消");

            jButton1.setContentAreaFilled(false);
            jButton2.setContentAreaFilled(false);
            jButton1.setFont(new Font("仿宋",Font.BOLD,20));
            jButton2.setFont(new Font("仿宋",Font.BOLD,20));
            JLabel label1=new JLabel("用户名:",SwingConstants.LEFT);
            JLabel label2=new JLabel("  密码:",SwingConstants.LEFT);

            label1.setFont(new Font("宋体",Font.BOLD,20));
            label2.setFont(new Font("宋体",Font.BOLD,20));

            JTextField jTextField1=new JTextField(15);
            JTextField jTextField2=new JTextField(15);
            jTextField1.setFont(new Font("宋体",Font.BOLD,20));
            jTextField2.setFont(new Font("宋体",Font.BOLD,20));

            panel1.add(label1);
            panel1.add(jTextField1);
            panel2.add(label2);
            panel2.add(jTextField2);
            panel3.add(jButton1);
            panel3.add(jButton2);
            c.add(panel1);
            c.add(panel2);
            c.add(panel3);

            setVisible(true);

            jButton1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Mysql mysql=new Mysql();
                    Users users=new Users(jTextField1.getText(),Integer.parseInt(jTextField2.getText()));
                    if(!MangerUser.FindMangerUsers(users)) {
                        if(MangerUser.AddMangerUser(users)>0)
                        System.out.println("successful");
                        else System.out.println("failed");
                        JOptionPane.showMessageDialog(null,"注册成功","提示",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        System.out.println("failed");
                        JOptionPane.showMessageDialog(null,"注册失败","提示",JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            jButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                dispose();
                }
            });
        }
}
class test4
{
    public static void main(String[] args) {
        UI4 ui4=new UI4();
    }
}

