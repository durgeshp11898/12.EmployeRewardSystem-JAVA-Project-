import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class View extends JFrame {
	static View fr;
	static JButton bestBtn;
	static JRadioButton hours;
	static JRadioButton projects;
	static JRadioButton events;
	static JButton viewBtn;
	static JButton backBtn;

	public static void main(String args[]) {
		JFrame frame = new JFrame("View/Update");
		frame.setVisible(true);
		frame.setBounds(200, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = frame.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.YELLOW);

		Font f2 = new Font("Arial", Font.ITALIC, 25);
		JLabel heading_lbl = new JLabel();

		heading_lbl.setBounds(250, 5, 200, 140);
		heading_lbl.setText("<html><font><u><b>VIEW/UPDATE</b></u></font></html>");
		heading_lbl.setFont(f2);

		JLabel l1 = new JLabel(
				new ImageIcon("stock-vector-searching-for-new-staff-from-list-with-magnifying-glass-794992504.jpg"));
		l1.setBounds(550, 5, 500, 700);
		c.add(l1);
		JLabel criteria_lbl = new JLabel("Options :");
		criteria_lbl.setBounds(150, 160, 150, 130);

		Cursor cur = new Cursor(Cursor.HAND_CURSOR);

		viewBtn = new JButton("VIEW/UPDATE");
		viewBtn.setBounds(400, 500, 220, 70);
		viewBtn.setCursor(cur);

		// viewBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		hours = new JRadioButton("HOURS");
		hours.setBounds(250, 260, 170, 30);
		hours.setCursor(cur);

		projects = new JRadioButton("PROJECTS");
		projects.setBounds(250, 300, 200, 30);
		projects.setCursor(cur);

		events = new JRadioButton("EVENTS");
		events.setBounds(250, 340, 200, 30);
		events.setCursor(cur);

		ButtonGroup criteria_grp = new ButtonGroup();
		criteria_grp.add(hours);
		criteria_grp.add(projects);
		criteria_grp.add(events);

		bestBtn = new JButton("BEST");
		bestBtn.setBounds(650, 500, 220, 70);
		bestBtn.setCursor(cur);

		/*
		 * bestBtn.addActionListener(new ActionListener(){ public void
		 * actionPerformed(ActionEvent event) { best_action(event); } });
		 */
		Font f = new Font("Arial", Font.BOLD, 20);

		criteria_lbl.setFont(f2);
		hours.setFont(f);
		projects.setFont(f);
		events.setFont(f);
		bestBtn.setFont(f);

		c.add(heading_lbl);
		c.add(hours);
		c.add(projects);
		c.add(events);
		c.add(bestBtn);
		c.add(viewBtn);
		c.add(criteria_lbl);

		backBtn = new JButton("BACK");
		backBtn.setBounds(150, 500, 220, 70);
		backBtn.setCursor(cur);

		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Login.main(new String[] {});
				fr.dispose();
			}
		});

		// Font f=new Font("Arial",Font.BOLD,14);
		viewBtn.setFont(f);
		backBtn.setFont(f);
		c.add(viewBtn);
		c.add(backBtn);
		c.add(heading_lbl);
	}
}
