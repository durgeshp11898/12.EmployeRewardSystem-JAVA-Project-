import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;

class Screen {
	JFrame f;
	JLabel l1, l2, l3, l4, l5, l6, l7;
	JTextField t1, t2, t3, t4, t5, t6, t7;
	JButton b1, b2, b3, b4, b5;

	Screen() {
		f = new JFrame("Screen");
		f.setSize(1400, 1400);
		JPanel p = new JPanel();
		p.setBounds(150, 100, 700, 400);
		p.setBorder(new MatteBorder(2, 2, 2, 2, Color.BLACK));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		l1 = new JLabel("Name");
		l1.setBounds(280, 180, 80, 30);
		l2 = new JLabel("Address");
		l2.setBounds(280, 230, 80, 30);
		l3 = new JLabel("Phone");
		l3.setBounds(280, 280, 80, 30);
		l4 = new JLabel("Email:");
		l4.setBounds(280, 330, 80, 30);
		l5 = new JLabel("Hours");
		l5.setBounds(280, 380, 80, 30);
		l6 = new JLabel("Projects");
		l6.setBounds(280, 430, 80, 30);
		l7 = new JLabel("Events");
		l6.setBounds(280, 480, 80, 30);

		t1 = new JTextField();
		t1.setBounds(450, 180, 200, 30);
		t2 = new JTextField();
		t2.setBounds(450, 230, 200, 30);
		t3 = new JTextField();
		t3.setBounds(450, 280, 200, 30);
		t4 = new JTextField();
		t4.setBounds(450, 330, 200, 30);
		t5 = new JTextField();
		t5.setBounds(450, 380, 200, 30);
		t6 = new JTextField();
		t6.setBounds(450, 430, 200, 30);
		t7 = new JTextField();
		t7.setBounds(450, 480, 200, 30);

		b1 = new JButton("<<");
		b1.setBounds(190, 430, 100, 30);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int p = Integer.parseInt(t3.getText());
				int q = Integer.parseInt(t5.getText());
				int r = Integer.parseInt(t6.getText());
				int x = Integer.parseInt(t7.getText());
				try {
					Class.forName("org.postgresql.Driver");
					Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.16.1/AG19");
					Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs = st.executeQuery("select * from Employee");
					while (rs.next()) {
						if (rs.getInt(3) == p)
							if (rs.getInt(5) == q)
								if (rs.getInt(6) == r)
									if (rs.getInt(7) == x)

										break;

					}

					if (rs.previous()) {
						t1.setText(rs.getString(1));
						t2.setText(rs.getString(2));
						t3.setText(rs.getString(3));
						t4.setText(rs.getString(4));
						t5.setText(rs.getString(5));
						t6.setText(rs.getString(6));
						t7.setText(rs.getString(7));
						con.close();
					}
				}

				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		b2 = new JButton("DELETE");
		b2.setBounds(310, 430, 100, 30);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int pp = Integer.parseInt(t3.getText());
				int qq = Integer.parseInt(t5.getText());
				int rr = Integer.parseInt(t6.getText());
				int xx = Integer.parseInt(t7.getText());

				try {
					Class.forName("org.postgresql.Driver");
					Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:8080", "dp", "    ");
					Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs = st.executeQuery("select * from employee");
					while (rs.next()) {
						if (rs.getInt(3) == pp)
							if (rs.getInt(5) == qq)
								if (rs.getInt(6) == rr)
									if (rs.getInt(7) == xx)
										break;
					}
					if (rs.next()) {
						t1.setText(rs.getString(1));
						t2.setText(rs.getString(2));
						t3.setText(rs.getString(3));
						t4.setText(rs.getString(4));
						t5.setText(rs.getString(5));
						t6.setText(rs.getString(6));
						t7.setText(rs.getString(7));
					}
					int o = st.executeUpdate("delete from Employee where phn=" + pp);
					if (o == 1) {
						JOptionPane.showMessageDialog(null, "Deletion Successfull!");
					} else
						JOptionPane.showMessageDialog(null, "Deletion Unsuccessfull!");

					con.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});

		b3 = new JButton("UPDATE");
		b3.setBounds(430, 430, 100, 30);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String a, b, c;
				int n, m, l, k;
				a = t2.getText();
				n = Integer.parseInt(t3.getText());
				c = t4.getText();
				m = Integer.parseInt(t5.getText());
				l = Integer.parseInt(t6.getText());
				k = Integer.parseInt(t7.getText());
				if (n < 0 && m < 0 && l < 0 && k < 0)
					JOptionPane.showMessageDialog(null, "Number can't be negative");

				if (a.compareTo("") == 0 || c.compareTo("") == 0)
					JOptionPane.showMessageDialog(null, "TextField cannot be empty");
				else {
					b = t1.getText();
					{
						try {
							Class.forName("org.postgresql.Driver");
							Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.16.1/AG19", "AG19",
									"");
							Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
									ResultSet.CONCUR_UPDATABLE);
							int nn1 = st.executeUpdate("update employee set hours='" + m + "' where name='" + b + "'");
							int nn2 = st
									.executeUpdate("update employee set project='" + l + "' where name='" + b + "'");
							int nn3 = st.executeUpdate("update employee set events='" + k + "' where name='" + b + "'");

							if (nn1 == 1 || nn2 == 1 || nn3 == 1)
								JOptionPane.showMessageDialog(null, "UPDATE SUCCESSFUL");
							else
								JOptionPane.showMessageDialog(null, "UPDATE UNSUCCESSFUL");
							con.close();

						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}
		});
		b4 = new JButton(">>");
		b4.setBounds(550, 430, 100, 30);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int p = Integer.parseInt(t3.getText());
				int q = Integer.parseInt(t5.getText());
				int r = Integer.parseInt(t6.getText());
				int x = Integer.parseInt(t7.getText());

				try {
					Class.forName("org.postgresql.Driver");
					Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.16.1/AG19", "AG19", "");
					Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					ResultSet rs = st.executeQuery("select * from employee");
					while (rs.next()) {
						if (rs.getInt(3) == p && rs.getInt(5) == q && rs.getInt(6) == r && rs.getInt(7) == x)
							break;
					}
					if (rs.next()) {
						t1.setText(rs.getString(1));
						t2.setText(rs.getString(2));
						t3.setText(rs.getString(3));
						t4.setText(rs.getString(4));
						t5.setText(rs.getString(5));
						t6.setText(rs.getString(6));
						t7.setText(rs.getString(7));
						con.close();
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});

		b5 = new JButton("EXIT");
		b5.setBounds(670, 430, 100, 30);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.16.1/AG19", "AG19", "");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			rs.next();
			rs.next();
			rs.next();
			t1.setText(rs.getString(1));
			t2.setText(rs.getString(2));
			t3.setText(rs.getString(3));
			t4.setText(rs.getString(4));
			t5.setText(rs.getString(5));
			t6.setText(rs.getString(6));
			t7.setText(rs.getString(7));
			con.close();
		}

		catch (Exception ae) {
			System.out.println(ae.getMessage());
		}
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.add(t5);
		f.add(t6);
		f.add(t7);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(p);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		new Screen();
	}
}
