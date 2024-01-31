package JavaTeamP;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import oracleDb.DbConnect;


public class EmpMainDesign extends JFrame implements ActionListener{

	DbConnect db=new DbConnect();
	Container cp;
	BufferedImage img=null;
	
	EmpMain em=new EmpMain("디자인");
	
	JButton connbtn;
	JLabel lblMain;
	
	public EmpMainDesign() {
		setTitle("배경화면 테스트");
		
		JLayeredPane layeredPane=new JLayeredPane();
		layeredPane.setSize(480, 320);
		layeredPane.setLayout(null);
		
		try {
			img=ImageIO.read(new File("C:\\sist0103\\image\\project\\emp_image.jpg"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
			System.exit(0);
		}
		
		myPanel panel=new myPanel();
		panel.setSize(480,320);
		layeredPane.add(panel);
		
		setLayout(null);
		
		add(layeredPane);
		
		initDesign();
		
		setBounds(700, 220, 480, 320);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initDesign()
	{
		this.setLayout(null);
		
		connbtn = new JButton("시작하기");
		connbtn.setBounds(190, 210, 90, 30);
		connbtn.addActionListener(this);
		this.add(connbtn);
	}

	
	class myPanel extends JPanel{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			g.drawImage(img, 0, 0, null);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object ob = e.getSource();
		
		if(ob==connbtn) {
			EmpMain add = new EmpMain("");
			em.setVisible(true);
			
		}
		
	}
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new EmpMainDesign();
	}
    
}

