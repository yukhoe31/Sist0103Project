package JavaTeamP;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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


//제일 처음으로 나오는 화면(main메서드 여기에 존재)
public class EmpMainDesign extends JFrame implements ActionListener{

	DbConnect db=new DbConnect();
	Container cp;
	BufferedImage img=null;
	
	EmpMain em=new EmpMain("인사관리 시스템");
	
	JButton connbtn;
	JLabel lblMain;
	
	public EmpMainDesign() {
		setTitle("인사관리 시스템");
		
		JLayeredPane layeredPane=new JLayeredPane();
		layeredPane.setSize(1200,700);
		layeredPane.setLayout(null);
		
		try {
			img=ImageIO.read(new File("C:\\sist0103\\image\\project\\city.jpg"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
			System.exit(0);
		}
		
		myPanel panel=new myPanel();
		panel.setSize(1200,700);
		layeredPane.add(panel);
		
		setLayout(null);
		
		add(layeredPane);
		
		initDesign();
		
		setBounds(700, 220,1200, 700);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initDesign()
	{
		this.setLayout(null);
		
		
		
		connbtn = new JButton("실행");
		Font customFont = new Font("바탕체",Font.BOLD, 26);
		
	    connbtn.setFont(customFont);
		
		connbtn.setBounds(550, 500, 100, 50);
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
			this.setVisible(false);
			
		}
		
	}
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new EmpMainDesign();
	}
    
}

