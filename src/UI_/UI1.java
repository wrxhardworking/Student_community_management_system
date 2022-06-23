package UI_;
import Mangerdata.MangerUser;
import Mysql.Mysql;
import OBJ.Users;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Tools.RenewClubsThrd;
import Tools.textisNull;
public class UI1 extends JFrame {
    public UI1()
    {
        String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }


        setTitle("登录窗口");
        setBackground(Color.blue);
        setBounds(400,10,800,800);
        setLayout(null);
//        setVisible(true);
        setResizable(false);
        //getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置背景
        ImageIcon img=new ImageIcon("imag/8.png");
        JLabel background=new JLabel(img);
        background.setBounds(0,0,800,800);
        Container c=getContentPane();
        c.add(background,new Integer(Integer.MIN_VALUE));

        //设置按钮
        JButton btn=new JButton("登陆");
        btn.setBounds(100,500,200,100);
        btn.setFont(new Font("方正舒体",Font.BOLD,40));
        btn.setContentAreaFilled(false);//去掉填充
        btn.setFocusPainted(false);//去边框
////        btn.setBorder(null);

        JButton btn2=new JButton("注册");
        btn2.setBounds(500,500,200,100);
        btn2.setFont(new Font("方正舒体",Font.BOLD,40));
        btn2.setContentAreaFilled(false);
        btn2.setFocusPainted(false);//去内边框
//        btn2.setBorder(null);//设置无边框


        //设置label
        JLabel label1=new JLabel("学生社团管理系统",SwingConstants.CENTER);
        label1.setFont(new Font("华文琥珀",Font.BOLD,40));
        label1.setBounds(200,-100,400,400);

        JLabel label2=new JLabel("账号",SwingConstants.CENTER);
        label2.setFont(new Font("宋体",Font.BOLD,25));

        JLabel label3=new JLabel("密码",SwingConstants.CENTER);
        label3.setFont(new Font("宋体",Font.BOLD,25));


        //设置输入框
        JTextField textField1=new JTextField(10);
        JPasswordField textField2=new JPasswordField(10) ;
        textField1.setFont(new Font("宋体",Font.BOLD,27));
        textField2.setFont(new Font("宋体",Font.BOLD,27));
        textField1.setOpaque(false);
        textField2.setOpaque(false);

//        限制只能输入数字 键盘点击事件
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                int keyChar = e.getKeyChar();

                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9||(keyChar>='A'&&keyChar<='z')){

                }else{
                    e.consume(); //关键，屏蔽掉非法输入
                }
            }
        });
        textField2.addKeyListener(new KeyAdapter() {
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

        //设置按钮监听事件
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textisNull.isNull(textField1)||textisNull.isNull(textField2))
                {
                    JOptionPane.showMessageDialog(null,"输入信息不能为空","提示",JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Mysql mysql=new Mysql();

                if(MangerUser.FindMangerUsers(new Users(textField1.getText(),Integer.parseInt(textField2.getText()))))
                {
                    UI2 ui2=new UI2();
                    dispose();}
                else {
                    JOptionPane.showMessageDialog(null,"登陆失败","提示",JOptionPane.ERROR_MESSAGE);
                    System.out.println("access failed");
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI4 ui4=new UI4();

            }
        });

        //标签面板
        JPanel panel=new JPanel(new BorderLayout());
        panel.add(label2,BorderLayout.NORTH);
        panel.add(label3,BorderLayout.SOUTH);
        panel.setBounds(120,220,200,150);
        panel.setOpaque(false);
        //输入框面板
        JPanel panel1=new JPanel(new BorderLayout());
        panel1.add(textField1,BorderLayout.NORTH);
        panel1.add(textField2,BorderLayout.SOUTH);
        panel1.setBounds(280,220,300,150);
        panel1.setOpaque(false);//设置为透明

        //背景下添加组件
        background.add(btn);
        background.add(btn2);
        background.add(panel);
        background.add(panel1);
        background.add(label1);

        setVisible(true);
    }
    public static void main(String[] args) {
            UI1 ui1 =new UI1();
    }
}
