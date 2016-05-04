package View;

import Controller.ExeSQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dell on 2016/5/4.
 */
public class Login extends JFrame {
    public Login(){
        ExeSQL sql1=new ExeSQL();
        sql1.connSQL();
        this.setTitle("ESchoolbag");
        JLabel jl = new JLabel("ESchoolbag",SwingUtilities.CENTER);
        Font font = new Font("幼圆",Font.BOLD,24);
        jl.setFont(font);
        jl.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.add(jl,BorderLayout.NORTH);

        font = new Font("幼圆",Font.PLAIN,12);

        JLabel jl_name = new JLabel("用户名：",SwingUtilities.RIGHT);
        jl_name.setFont(font);

        JLabel jl_pass1 = new JLabel("密码：",SwingUtilities.RIGHT);
        jl_pass1.setFont(font);

        JPanel jp_center_left = new JPanel();
        jp_center_left.setLayout(new GridLayout(5,1));
        jp_center_left.add(jl_name);
        jp_center_left.add(jl_pass1);

        JTextField jt_name = new JTextField();
        JPasswordField jt_pass1 = new JPasswordField();
        jt_pass1.setEchoChar('*');

        JPanel jp_center_right = new JPanel();
        jp_center_right.setLayout(new GridLayout(5,1));
        jp_center_right.add(jt_name);
        jp_center_right.add(jt_pass1);

        JPanel jp_center = new JPanel();
        jp_center.setLayout(new GridLayout(1,2));
        jp_center.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 60));
        jp_center.add(jp_center_left);
        jp_center.add(jp_center_right);

        JButton jb1 = new JButton("登录");
        JButton jb2 = new JButton("注册");

        JPanel jp_south = new JPanel();
        jp_south.add(jb1);
        jp_south.add(jb2);
        jp_south.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        this.add(jp_center);
        this.add(jp_south,BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(370, 280);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(sql1.Login(jt_name.getText(),jt_pass1.getText())){
                    System.out.println("登录成功");
                }
                else {
                    System.out.println("error");
                }
            }
        });
    }

}
