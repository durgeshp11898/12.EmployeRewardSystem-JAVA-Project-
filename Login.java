import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {
	// Container c;
	static Login frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
					// frame.setBackground(Color.YELLOW);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		// setBackground(Color.YELLOW);

		JLabel lblAdminLoginForm = new JLabel("Admin Login Form");
		JLabel l1 = new JLabel(new ImageIcon("business-collection-michael-002.jpg"));
		l1.setBounds(80, 300, 700, 500);
		add(l1);
		JFrame f = new JFrame();
		f.setBackground(Color.YELLOW);
		// lblAdminLoginForm.setForeground(Color.GRAY);
		lblAdminLoginForm.setFont(new Font("Tahoma", Font.BOLD, 25));

		JLabel lblEnterName = new JLabel("Enter Name:");
		lblEnterName.setFont(new Font("Arial", Font.PLAIN, 21));

		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setFont(new Font("Arial", Font.PLAIN, 21));

		textField = new JTextField();
		textField.setColumns(10);

		JButton btnLogin = new JButton("Login");
		// btnLogin.setBounds(100,80,100,30);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				if (name.equals("durgesh") && password.equals("durgesh123")) {
					View.main(new String[] {});
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(Login.this, "Sorry, Username or Password Error", "Login Error!",
							JOptionPane.ERROR_MESSAGE);
					textField.setText("");
					passwordField.setText("");
				}
			}
		});
		JButton btnSignup = new JButton("SignUp");
		// btnSignup.setBounds(100,80,100,30);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp1.main(new String[] {});
				frame.dispose();
			}
		});

		passwordField = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);

		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(124).addComponent(lblAdminLoginForm))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(19)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEnterName).addComponent(lblEnterPassword))
								.addGap(47)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(passwordField)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
				.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(107, Short.MAX_VALUE).addGap(5)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSignup, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
		// .addGap(300)
		// .addGap(200)
		));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(lblAdminLoginForm).addGap(36)
				.addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(lblEnterName).addComponent(textField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(38)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(45).addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
				.addGap(20).addGroup(gl_contentPane.createSequentialGroup()

						.addComponent(btnSignup, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(170, Short.MAX_VALUE).addContainerGap(170, Short.MAX_VALUE))));
		contentPane.setLayout(gl_contentPane);
	}
}
