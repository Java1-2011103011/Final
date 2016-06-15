import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
	// 이 줄은 별 의미 없음.
	// JFrame을 상속받았을 때 나오는 경고를 없애기 위함
	public static final long serialVersionUID = 0L;
	
	// 멤버 변수 선언
	public JTextField text;
	public boolean mode = false;
	public double operand1= 0;
	public double operand2 = 0;
	public String operator = "";
	
	public Calculator() {
		super("계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeLayout();
	}
	
	public void makeLayout() {
		JPanel panel = new JPanel();
		text = new JTextField("0", 17);		
		text.setHorizontalAlignment(JTextField.RIGHT);
		
		panel.add(text);
		add(panel, "North");
		
		// 버튼 크기를 같게 하기 위해서..
		Dimension d = new Dimension(45, 30);		
		
		// 연산 버튼 생성
		JButton operator[] = new JButton[6];		
		operator[0] = new JButton("+");		
		operator[1] = new JButton("-");
		operator[2] = new JButton("*");
		operator[3] = new JButton("/");
		operator[4] = new JButton("=");
		operator[5] = new JButton("C");		
		
		for (int i = 0; i < 6; i++) {
			operator[i].setPreferredSize(d);	// 버튼 크기 설정
			operator[i].addActionListener(this);
		}
		
		// 숫자 버튼 생성
		JButton[] button = new JButton[10];
		for (int i = 0; i < 10; i++) {
			button[i] = new JButton(i+"");
			button[i].setPreferredSize(d);
			button[i].addActionListener(this);
		}
		
		// 버튼을 넣을 서브 패널 생성
		JPanel[] p = new JPanel[4];
		for (int i = 0; i < 4; i++) {			
			p[i] = new JPanel();
			p[i].setLayout(new FlowLayout());
			p[i].setAlignmentX(JPanel.LEFT_ALIGNMENT);
		}
		
		p[0].add(button[7]);
		p[0].add(button[8]);
		p[0].add(button[9]);
		p[0].add(operator[0]);
		
		p[1].add(button[4]);
		p[1].add(button[5]);
		p[1].add(button[6]);
		p[1].add(operator[1]);
		
		p[2].add(button[1]);
		p[2].add(button[2]);
		p[2].add(button[3]);
		p[2].add(operator[2]);
		
		p[3].add(button[0]);
		p[3].add(operator[3]);
		p[3].add(operator[4]);
		p[3].add(operator[5]);
		
		// 패널 생성
		JPanel pad = new JPanel();
		pad.setLayout(new BoxLayout(pad, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < 4;  i++)
			pad.add(p[i]);
		
		add(pad, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
