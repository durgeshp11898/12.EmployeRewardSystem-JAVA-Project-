import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Welcome extends JFrame {
	static JButton b1;
	static JLabel l1, l2, l3;
	JLabel ll;
	static Welcome fr;

	public static void main(String args[]) {
		JFrame frame = new JFrame("WELCOME");
		frame.setVisible(true);
		frame.setBounds(200, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = frame.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.YELLOW);

		Font f2 = new Font("Arial", Font.BOLD, 30);
		JLabel l2 = new JLabel();

		l2.setBounds(100, 5, 300, 240);
		l2.setText("<html><body><marquee><font><u><b>***WELCOME***</b></u></font></marquee></body></html>");
		l2.setFont(f2);

		JLabel l1 = new JLabel(new ImageIcon("IMG_2254.JPG"));
		l1.setBounds(200, 50, 850, 500);
		c.add(l1);

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);

		b1 = new JButton("OK");
		b1.setBounds(650, 500, 220, 70);
		b1.setCursor(cur);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Login.main(new String[] {});
				fr.dispose();
			}
		});

		Font f1 = new Font("Arial", Font.BOLD, 25);
		b1.setFont(f1);
		c.add(b1);
		c.add(l2);
	}
}
