import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SignUp1 extends JFrame implements ActionListener {
	static SignUp1 frame;
	JFrame f;
	JLabel l1, l2, l3, l4;
	JTextField t1, t2;
	JPasswordField p1, p2;
	JButton btn1, btn2;
	int pick;
	int pick1[] = new int[2];

	SignUp1() {
		f = new JFrame();
		f.setSize(700, 700);
		f.setLayout(null);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l1 = new JLabel("Registration Form", JLabel.CENTER);
		l2 = new JLabel("Login Name");
		l3 = new JLabel("Password");
		l4 = new JLabel("Confirm Password");

		t1 = new JTextField(20);
		t2 = new JTextField(20);
		// =new JTextField(20);
		p1 = new JPasswordField(20);
		p2 = new JPasswordField(20);
		btn1 = new JButton("Submit");
		btn1.addActionListener(this);
		btn2 = new JButton("Back");
		btn2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// String name=textField.getText();

				// String password=String.valueOf(passwordField.getPassword());

				// if(name.equals("admin")&&password.equals("admin123")){

				Login.main(new String[] {});

				frame.dispose();

				/*
				 * }else{
				 * 
				 * JOptionPane.showMessageDialog(Welcome.this, "Sorry,Error","Login Error!",
				 * JOptionPane.ERROR_MESSAGE);
				 * 
				 * //textField.setText("");
				 * 
				 * //passwordField.setText("");
				 * 
				 * }
				 */
			}
		});

		/*
		 * Random rand=new Random(); String s=""; for(int i=0;i<2;i++) {
		 * pick=rand.nextInt(20); pick1[i]=pick; s+=pick+""; if(i==0) s+="=";
		 * t3.setText(s); }
		 */

		l1.setBounds(100, 30, 400, 30);
		l2.setBounds(80, 70, 200, 30);
		l3.setBounds(80, 110, 200, 30);
		l4.setBounds(80, 150, 200, 30);
		t1.setBounds(300, 70, 200, 30);
		t2.setBounds(300, 110, 200, 30);
		// t4.setBounds(400,230,200,30);
		p1.setBounds(300, 150, 200, 30);
		p2.setBounds(300, 190, 200, 30);

		btn1.setBounds(250, 270, 100, 30);
		btn2.setBounds(250, 370, 100, 30);

		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(l3);
		f.add(t2);
		f.add(l4);
		f.add(p1);
		// f.add(p2);
		// f.add(t4);
		f.add(btn1);
		f.add(btn2);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			int x = 0, i;
			String error = "";
			char s3[] = p1.getPassword();
			char s4[] = p1.getPassword();
			String s8 = new String(s3);
			String s9 = new String(s4);
			int f1 = 0, f2 = 0, f3 = 0, f4 = 0, flg1 = 0, flg2 = 0, flg3 = 0;
			if (s8.length() >= 6)
				f1 = 1;
			else
				error += "\n Too Short";
			for (i = 0; i < s8.length(); i++) {
				if (s8.charAt(i) >= 65 && s8.charAt(i) <= 90)
					f2 = 1;
			}

			if (f2 == 0)
				error += "\n No capital letters";
			for (i = 0; i < s8.length(); i++) {
				if (s8.charAt(i) >= 48 && s8.charAt(i) <= 57)
					f3 = 1;
			}
			if (f3 == 0)
				error += "\n No numbers";
			for (i = 0; i < s8.length(); i++) {
				if ((s8.charAt(i) >= 33 && s8.charAt(i) <= 41) || (s8.charAt(i) == 94 || s8.charAt(i) == 95))
					f4 = 1;
			}
			if (f4 == 0)
				error += "\n No special chars";
			if (f1 == 1 && f2 == 1 && f3 == 1 && f4 == 1)
				flg1 = 1;
			if (s8.equals(s9))
				flg2 = 1;
			else
				error = error + "\n Passwords don't match";
			String test = p2.getText();
			int testn = Integer.parseInt(test);
			if (testn == (pick1[0] + pick1[1]))
				flg3 = 1;
			if (flg1 == 1 && flg2 == 1 && flg3 == 1)
				JOptionPane.showMessageDialog(btn1, "Registration Successful");
			else
				JOptionPane.showMessageDialog(btn1, "Registration Failed" + error);
		}
	}

	public static void main(String args[]) {
		new SignUp1();
	}
}
