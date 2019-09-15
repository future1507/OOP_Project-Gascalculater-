
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Gas {
	public static void main(String[] args) {
		MyWindow mywindow = new MyWindow();
		//mywindow.Top();
		mywindow.Left();
		mywindow.Center();
		mywindow.Right();
		mywindow.Down();

		mywindow.setVisible(true);
	}
}
class MyWindow extends JFrame implements ActionListener{	
	public JFileChooser fc = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Textfile", "txt");
	
	public File file = new File("");
	public String path = "";
	public MyWindow() {
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		setSize(1280,720);
		setTitle("Program Gas Calculate");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		
		//ImagePanel picture = new ImagePanel(new ImageIcon("gas.jpg").getImage());
		//getContentPane().add(picture);
		//pack();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	public void Top(JTextField text) {
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout(FlowLayout.LEFT));
		JMenuBar mn = new JMenuBar();
		JMenu mn_file = new JMenu("File");
		JMenu mn_about = new JMenu("About");
		JMenuItem mn_open = new JMenuItem("Open");
		JMenuItem mn_save = new JMenuItem("Save");
		top.setPreferredSize(new Dimension(1280,30));
		
		mn_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc.setFileFilter(filter);
				int returnval = fc.showOpenDialog(MyWindow.this);
				if(returnval == fc.APPROVE_OPTION) {
					file = fc.getSelectedFile(); 
					path = file.getPath();
					text.setText(path);
				}
			}
		});
		mn_file.add(mn_open);
		mn_file.add(mn_save);
		mn.add(mn_file);
		mn.add(mn_about);
		top.add(mn);
		add(top,BorderLayout.NORTH);
	}
	public void Left() {
		JPanel spleft = new JPanel();
		spleft.setLayout(new BorderLayout());
		JPanel leftspleft = new JPanel();
		leftspleft.setPreferredSize(new Dimension(10,0));
		JPanel rightspright = new JPanel();
		rightspright.setPreferredSize(new Dimension(10,0));
		
		JPanel left = new JPanel();
		left.setLayout(new FlowLayout());
		left.setPreferredSize(new Dimension(300,300));
		
		InputFile(left);
		InputTester(left);
		Detail(left);
		GasDis(left);
		ExitProgram(left);
		
		spleft.add(leftspleft,BorderLayout.WEST);
		spleft.add(rightspright,BorderLayout.EAST);
		spleft.add(left,BorderLayout.CENTER);
		add(spleft,BorderLayout.WEST);
	}
	public void Center() {
		JPanel center = new JPanel();
		center.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		Table(center);
		Message(center);
		Type(center);
		add(center,BorderLayout.CENTER);
	}
	
	public void Right() {
		JPanel right = new JPanel();
		right.setPreferredSize(new Dimension(160,0));
		add(right,BorderLayout.EAST);
	}
	public void Down() {
		JPanel down = new JPanel();
		down.setPreferredSize(new Dimension(0,50));
		add(down,BorderLayout.SOUTH);
	}
	public void InputFile(JPanel left) {
		JPanel input_file = new JPanel();
		input_file.setLayout(new BorderLayout());
		JTextField text = new JTextField();
		Panel bt = new Panel();
		bt.setLayout(new FlowLayout());
		JButton bt_open = new JButton("Open File");
		JButton bt_clear = new JButton("Clear");
		JLabel lb = new JLabel();
		lb.setText("   File : ");
		Panel top = new Panel();
		Panel right = new Panel();
		
		input_file.setBorder ( BorderFactory.createLineBorder ( Color.black, 2 ) );
		input_file.setPreferredSize(new Dimension(300,80));
		top.setPreferredSize(new Dimension(0,20));
		bt.setPreferredSize(new Dimension(0,35));
		right.setPreferredSize(new Dimension(30,0));
		bt.add(bt_open);
		bt.add(bt_clear);
		input_file.add(text,BorderLayout.CENTER);
		input_file.add(top,BorderLayout.NORTH);
		input_file.add(right,BorderLayout.EAST);
		input_file.add(lb,BorderLayout.WEST);
		input_file.add(bt,BorderLayout.SOUTH);
		left.add(input_file);
		bt_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fc.setFileFilter(filter);
				int returnval = fc.showOpenDialog(MyWindow.this);
				if(returnval == fc.APPROVE_OPTION) {
					file = fc.getSelectedFile(); 
					path = file.getPath();
					text.setText(path);
				}
			}
		});
		
		Top(text);
	}
	public void InputTester(JPanel left) {
		JPanel input_test = new JPanel();
		input_test.setLayout(new BorderLayout());
		JTextField textfield = new JTextField();
		JPanel bt = new JPanel();
		bt.setLayout(new FlowLayout());
		JButton bt_ok = new JButton("OK");
		JButton bt_clear = new JButton("Clear");
		JPanel top = new JPanel();
		Panel right = new Panel();
		Panel west_input_test = new Panel();
		JLabel lb_top = new JLabel("Input The depth of the abyss");
		JLabel lb_right = new JLabel("m^3");
		
		input_test.setBorder ( BorderFactory.createLineBorder ( Color.black, 2 ) );
		bt.add(bt_ok);
		bt.add(bt_clear);
		top.setPreferredSize(new Dimension(0,50));
		bt.setPreferredSize(new Dimension(0,40));
		right.setPreferredSize(new Dimension(50,0));
		west_input_test.setPreferredSize(new Dimension(30,0));
		input_test.setPreferredSize(new Dimension(300,120));
		top.add(lb_top);
		right.add(lb_right);
		input_test.add(textfield,BorderLayout.CENTER);
		input_test.add(top,BorderLayout.NORTH);
		input_test.add(right,BorderLayout.EAST);
		input_test.add(west_input_test,BorderLayout.WEST);
		input_test.add(bt,BorderLayout.SOUTH);
		left.add(input_test);
		
	}
	public void Detail(JPanel left) {
		JPanel detail = new JPanel();
		detail.setLayout(new GridLayout(4,1));
		Label total = new Label("\tTotal\t : \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  0.00");
		Label avg = new Label("\tAverage\t : \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  0.00");
		Label max = new Label("\tMaximum\t : \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t0.00");
		Label min = new Label("\tMinimum\t : \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 0.00");
		
		detail.setBorder ( BorderFactory.createLineBorder ( Color.black, 2 ) );
		detail.setPreferredSize(new Dimension(300,120));
		detail.add(total);
		detail.add(avg);
		detail.add(max);
		detail.add(min);
		left.add(detail);
	}
	public void GasDis(JPanel left) {
		JPanel gasdis = new JPanel();
		gasdis.setLayout(new GridLayout(2,1));
		JPanel gasarea = new JPanel();
		gasarea.setLayout(new BorderLayout());
		JLabel lb_gasarea = new JLabel("GAS AREA 0 m^3");
		JPanel distance = new JPanel();
		distance.setLayout(new BorderLayout());
		JLabel lb_distance = new JLabel("Distance 0 m.");
		JLabel leftgas = new JLabel();
		JLabel leftdis = new JLabel();
		
		gasdis.setBorder ( BorderFactory.createLineBorder ( Color.black, 2 ) );
		gasarea.setBackground(Color.blue);
		distance.setBackground(Color.ORANGE);
		lb_gasarea.setForeground(Color.white);
		gasdis.setPreferredSize(new Dimension(300,200));
		leftgas.setPreferredSize(new Dimension(100,0));
		leftdis.setPreferredSize(new Dimension(100,0));
		gasarea.add(leftgas,BorderLayout.WEST);
		gasarea.add(lb_gasarea,BorderLayout.CENTER);
		distance.add(leftdis,BorderLayout.WEST);
		distance.add(lb_distance,BorderLayout.CENTER);
		gasdis.add(gasarea);
		gasdis.add(distance);
		left.add(gasdis);
	}
	public void ExitProgram(JPanel left) {
		JPanel exit = new JPanel();
		exit.setLayout(new GridLayout(1,1));
		JButton bt_exit = new JButton("Exit Program");
		
		exit.setPreferredSize(new Dimension(300,30));
		exit.setBorder ( BorderFactory.createLineBorder ( Color.black, 2 ) );
		exit.add(bt_exit);
		left.add(exit);
	}
	public void Table(JPanel center) {
		JPanel table = new JPanel();
		table.setPreferredSize(new Dimension(720,480));
		table.setBorder ( BorderFactory.createLineBorder ( Color.black, 2 ) );
		table.setBackground(Color.LIGHT_GRAY);
		center.add(table);
	}
	public void Message(JPanel center) {
		JPanel msg = new JPanel();
		msg.setLayout(new FlowLayout());
		JLabel lb_msg = new JLabel("Message");
		TextArea textmsg = new TextArea("",4,30,TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		msg.setBorder ( BorderFactory.createLineBorder ( Color.black, 2 ) );
		msg.add(lb_msg);
		msg.add(textmsg);
		center.add(msg);
	}
	public void Type(JPanel center) {
		JPanel type = new JPanel();
		type.setLayout(new GridLayout(2,2));
		
		JPanel nogas = new JPanel();
		nogas.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel c_nogas = new JPanel();
		Label lb_nogas = new Label("No gas");
		
		JPanel gasm = new JPanel();
		gasm.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel c_gasm = new JPanel();
		Label lb_gasm = new Label("Gas medium");
		
		JPanel mgas = new JPanel();
		mgas.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel c_mgas = new JPanel();
		Label lb_mgas = new Label("More gas");
		
		JPanel gasf = new JPanel();
		gasf.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel c_gasf = new JPanel();
		Label lb_gasf = new Label("Gas quite a few");
		
		type.setBorder ( BorderFactory.createLineBorder ( Color.black, 2 ) );
		type.setPreferredSize(new Dimension(387,90));
		c_nogas.setBackground(Color.red);
		c_nogas.setPreferredSize(new Dimension(30,30));
		c_gasm.setBackground(Color.yellow);
		c_gasm.setPreferredSize(new Dimension(30,30));
		c_mgas.setBackground(Color.green);
		c_mgas.setPreferredSize(new Dimension(30,30));
		c_gasf.setBackground(Color.ORANGE);
		c_gasf.setPreferredSize(new Dimension(30,30));
		
		nogas.add(c_nogas);
		nogas.add(lb_nogas);
		gasm.add(c_gasm);
		gasm.add(lb_gasm);
		mgas.add(c_mgas);
		mgas.add(lb_mgas);
		gasf.add(c_gasf);
		gasf.add(lb_gasf);
		
		type.add(nogas);
		type.add(mgas);
		type.add(gasm);
		type.add(gasf);
		
		center.add(type);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}

class ImagePanel extends JPanel {

	 private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }
 }

