import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;
import javax.swing.border.*;
import java.util.Arrays;

public class Best extends JFrame {

	static Best fr;
	static JLabel l1, l2;
	static JTextField t1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("BEST");
		frame.setVisible(true);
		frame.setBounds(200, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		t1 = new JTextField(20);
		t1.setBounds(300, 70, 200, 30);

		Container c = frame.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.YELLOW);

		Font f2 = new Font("Arial", Font.BOLD, 30);
		JLabel l2 = new JLabel();

		l2.setBounds(100, 5, 300, 240);
		l2.setText("<html><body><marquee><font><u><b>*** BEST EMPLOYEE ***</b></u></font></marquee></body></html>");
		l2.setFont(f2);

		JLabel l1 = new JLabel(new ImageIcon("IMG_2255.JPG"));
		l1.setBounds(200, 50, 850, 500);
		c.add(l1);
		c.add(l2);
		c.add(t1);

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);

		int[] array = new int[10];

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.16.1/AG19", "AG19", "");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select * from employee");
			ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();

			while (rs.next()) {
				for (int i = 0; i < column; i++) {
					array[i] = rs.getInt(5); // replace 5 with column_id;
				}
			}
			int max = Arrays.stream(array).max().getAsInt();

			for (int i = 0; i < array.length; i++) {
				if (array[i] == max) {
					rs = st.executeQuery("select empname from employee where id = i");
					String bestEmp = rs.toString();
					t1.setText(bestEmp);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
