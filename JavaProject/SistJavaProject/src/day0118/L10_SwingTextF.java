package day0118;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;

//2+3 = 5 <=이렇게 출력해보기.
public class L10_SwingTextF extends JFrame {
	
	Container cp;
	JTextField tfNum1, tfNum2;
	JButton btnAdd, btnMin, btnGop, btnDiv;
	JLabel lblNum1, lblNum2, lblResult;
	
	public L10_SwingTextF() {

		super("텍스트필드 문제 ☆ 10");
		
		cp = this.getContentPane();
		
		this.setBounds(200,100,500,300);
		cp.setBackground(new Color(221,200,245));
		
		setDesign();
		
		this.setVisible(true);

	}
	
	
	public void setDesign() {
	
		this.setLayout(null);
		lblNum1 = new JLabel("숫자1");
		lblNum2 = new JLabel("숫자2");
		
		lblNum1.setBounds(20, 20, 50, 30);
		this.add(lblNum1);
		
		lblNum2.setBounds(20, 60, 50, 30);
		this.add(lblNum2);

		tfNum1 = new JTextField();
		tfNum1.setBounds(80,20,60,30);
		this.add(tfNum1);
		
		tfNum2 = new JTextField();
		tfNum2.setBounds(80,60,60,30);
		this.add(tfNum2);
		
		btnAdd = new JButton("+");
		btnAdd.setBounds(40, 110, 70, 40);
		this.add(btnAdd);
		
		
		btnMin = new JButton("-");
		btnMin.setBounds(120, 110, 70, 40);
		this.add(btnMin);
		
		btnGop = new JButton("*");
		btnGop.setBounds(200, 110, 70, 40);
		this.add(btnGop);
		
		btnDiv = new JButton("/");
		btnDiv.setBounds(280, 110, 70, 40);
		this.add(btnDiv);
		
		
		lblResult = new JLabel("결과 나오는 곳...");
		lblResult.setBounds(20,170,250,60);
		lblResult.setBorder(new TitledBorder("결과확인"));
		lblResult.setFont(new FontUIResource("", Font.BOLD, 25));
		this.add(lblResult);
		
		//익명내부클래스
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int num1 = Integer.parseInt(tfNum1.getText().trim());
				int num2 = Integer.parseInt(tfNum2.getText().trim());
				//앞뒤공백 제거후 변환
				//tfNum1에 쓴 글을 가지고 온다.
				
				int sum = num1 + num2;
				
				String s = num1 + "+" +num2 + " = " +sum;
				lblResult.setText(s);
				//위의 lblResult변수의 초기값인 "결과 나오는 곳..."
				//을 .setText()함수를 이용해서 재선언하기(내용 바꾸기)
				
			}
		});
		
		btnMin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int num1 = Integer.parseInt(tfNum1.getText().trim());
				int num2 = Integer.parseInt(tfNum2.getText().trim());
				//앞뒤공백 제거후 변환
				//tfNum1에 쓴 글을 가지고 온다.
				
				int min = num1 - num2;
				
				String s = num1 + "-" +num2 + " = " +min;
				lblResult.setText(s);
				//위의 lblResult변수의 초기값인 "결과 나오는 곳..."
				//을 .setText()함수를 이용해서 재선언하기(내용 바꾸기)
				
			}
		});
		
		btnGop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int num1 = Integer.parseInt(tfNum1.getText().trim());
				int num2 = Integer.parseInt(tfNum2.getText().trim());
				//앞뒤공백 제거후 변환
				//tfNum1에 쓴 글을 가지고 온다.
				
				int sum = num1 * num2;
				
				String s = num1 + "*" +num2 + " = " +sum;
				lblResult.setText(s);
				//위의 lblResult변수의 초기값인 "결과 나오는 곳..."
				//을 .setText()함수를 이용해서 재선언하기(내용 바꾸기)
				
			}
		});
		
		btnDiv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int num1 = Integer.parseInt(tfNum1.getText().trim());
				int num2 = Integer.parseInt(tfNum2.getText().trim());
				//앞뒤공백 제거후 변환
				//tfNum1에 쓴 글을 가지고 온다.
				
				double sum = (double)num1 / num2;
				
				String s = num1 + "/" +num2 + " = " +sum;
				lblResult.setText(s);
				//위의 lblResult변수의 초기값인 "결과 나오는 곳..."
				//을 .setText()함수를 이용해서 재선언하기(내용 바꾸기)
				
			}
		});	
	}

	public static void main(String[] args) {

		new L10_SwingTextF();
	}

}
