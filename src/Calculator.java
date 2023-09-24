import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	// mention and getiing the instance
	private JFrame frame;
	private JTextField textfield;
	private JButton[] numberButtons = new JButton[10];
	private JButton[] functionButtons = new JButton[9];
	private JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton, negButton;

	private JPanel panel;
	private Font myFont = new Font("Times-Roman", Font.BOLD, 30);
	private double num1 = 0, num2 = 0, result = 0;
	private char Operator;

	Calculator() {
		// Componenets-------------------------------------
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(420, 550);
		frame.getContentPane().setLayout(null);
		Color color = new Color(64, 18, 139);
		Color color1 = new Color(255, 165, 0);
		frame.getContentPane().setBackground(color);
		ImageIcon image = new ImageIcon("logo.png");
		frame.setIconImage(image.getImage());

		// textfield Componenets--------------------------------------->

		textfield = new JTextField();
		textfield.setSelectionColor(new Color(0, 153, 1));
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		textfield.setBackground(Color.white);

		// Button Componenets--------------------------------------->
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		equButton = new JButton("=");
		decButton = new JButton(".");
		delButton = new JButton("Del");
		clrButton = new JButton("C");
		negButton = new JButton("(-)");

		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;

		// Function Buttons Printing and
		// Componets--------------------------------------->
		for (int i = 0; i < 9; i++) {

			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBackground(color1);

			functionButtons[i].setForeground(Color.BLACK);
		}
		// Number Button Printing--------------------->
		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBackground(Color.white);
		}

		// Neg,Clear,Delete Componenets--------------------------------------->
		clrButton.setBounds(50, 100, 100, 40);
		negButton.setBounds(150, 100, 100, 40);
		delButton.setBounds(250, 100, 100, 40);

		// Panel Componenets--------------------------------------->
		panel = new JPanel();
		panel.setBounds(50, 150, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(Color.WHITE);

		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);

		// frame Componenets--------------------------------------->
		frame.getContentPane().add(panel);
		frame.getContentPane().add(textfield);
		frame.setVisible(true);
		frame.getContentPane().add(clrButton);
		frame.getContentPane().add(delButton);
		frame.getContentPane().add(negButton);

	}

	// Functions of the Buttons--------------------------------------->

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}

		}
		if (e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}

		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			Operator = '+';

			textfield.setText("");

		}

		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			Operator = '-';

			textfield.setText("");

		}

		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			Operator = '*';

			textfield.setText("");

		}

		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			Operator = '/';

			textfield.setText("");

		}
		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());

			switch (Operator) {
				case '+':
					result = num1 + num2;
					break;

				case '-':
					result = num1 - num2;
					break;

				case '*':
					result = num1 * num2;
					break;

				case '/':
					result = num1 / num2;

					break;

			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		if (e.getSource() == clrButton) {

			textfield.setText("");
		}
		if (e.getSource() == delButton) {

			String string = textfield.getText();
			textfield.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}

		if (e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
	}

}
