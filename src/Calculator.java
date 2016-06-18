import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
		
	// ��� ���� ����
	public JTextField text;
	public boolean mode = false;
	public double operand1= 0;
	public double operand2 = 0;
	public String operator = "";
	
	public Calculator() {
		super("����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeLayout();
	}
	
	public void makeLayout() {
		JPanel panel = new JPanel();
		text = new JTextField("0", 17);		
		text.setHorizontalAlignment(JTextField.RIGHT);
		
		panel.add(text);
		add(panel, "North");
		
		// ��ư ũ�⸦ ���� �ϱ� ���ؼ�..
		Dimension d = new Dimension(45, 30);		
		
		// ���� ��ư ����
		JButton operator[] = new JButton[6];		
		operator[0] = new JButton("+");		
		operator[1] = new JButton("-");
		operator[2] = new JButton("*");
		operator[3] = new JButton("/");
		operator[4] = new JButton("=");
		operator[5] = new JButton("C");		
		
		for (int i = 0; i < 6; i++) {
			operator[i].setPreferredSize(d);	// ��ư ũ�� ����
			operator[i].addActionListener(this);
		}
		
		// ���� ��ư ����
		JButton[] button = new JButton[10];
		for (int i = 0; i < 10; i++) {
			button[i] = new JButton(i+"");
			button[i].setPreferredSize(d);
			button[i].addActionListener(this);
		}
		
		// ��ư�� ���� ���� �г� ����
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
		
		// �г� ����
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


	public String cal() {

		String result = "";
		if(operator.equals("+")) {
			operand1 += operand2;
			result = operand1 + "";
		} else if(operator == "-") {
			operand1 -= operand2;
			result = operand1 + "";
		} else if(operator == "*") {
			operand1 *= operand2;
			result = operand1 + "";
		} else if(operator == "/") {
			if (operand2 != 0) {
				operand1 /= operand2;
				result = operand1 + "";
			} else {
				result = "No";
			}
		}
		
		return result;
	}
	
	public void cal(String op) {
		// �Է¹��� ���ڰ� ������ �ƹ� �ϵ� ���� ����
		if (text.getText().equals("") || text.getText() == null)
			return;
		
		if (operator.equals("")) {
			// ����� ó�� �� ��
			operand1 = Double.parseDouble(text.getText());
			operator = op;
			text.setText("");
		} else {
			// ���� ���
			operand2 = Double.parseDouble(text.getText());
			text.setText(cal());
			operator = op;
			mode = true;
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();
		if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
			// ������ ó��
			cal(cmd);
		} else if (cmd.equals("=")) {
			// �����ڰ� ������ �ȵǾ� ������ �ƹ� �ϵ� ���Ѵ�.
			if (operator.equals(""))
				return;
			
			// ��� ��� ó��
			operand2 = Double.parseDouble(text.getText());			
			text.setText(cal());

			// ���� ����� ���� �ʱ�ȭ
			operand1 = 0;
			operand2 = 0;
			operator = "";			
			mode = true;
		} else if (cmd.equals("C")) {
			// Ŭ����
			operand1 = 0;
			operand2 = 0;
			operator = "";
			text.setText("0");
		} else {
			// ���� ó��
			if (mode == true) {
				mode = false;
				text.setText(cmd);
			} else  {
				if (text.getText().equals("0")) {
					text.setText(cmd);
				} else {
					text.setText(text.getText() + cmd);
				}
			}
		}
	}
}
