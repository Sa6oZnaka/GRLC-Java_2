import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JLabel;

public class Frame1 {

	private JFrame frame;
	private JTextField textBox;
	private JLabel label;
	private int balance=500;
	private int Bet=10;
	private JLabel lblBalance;
	private JLabel lblGrlc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnEven = new JButton("Even");
		btnEven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rn = new Random();
				int answer = rn.nextInt(10) + 1;
				
				Bet = Integer.parseInt(textBox.getText());
				if(Bet <= balance) {
					if(answer > 5) {
						JOptionPane.showMessageDialog(null, "You win :)");
						balance += Bet;
						label.setText(balance + "");
					}else {
						JOptionPane.showMessageDialog(null, "You Lost :(");
						balance -= Bet;
						label.setText(balance + "");
					}
				}else {
					JOptionPane.showMessageDialog(null, "You dont have enought money :(");
				}
			}
		});
		btnEven.setBounds(101, 136, 89, 23);
		frame.getContentPane().add(btnEven);
		
		JButton btnOdd = new JButton("ODD");
		btnOdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rn = new Random();
				int answer = rn.nextInt(10) + 1;
				
				Bet = Integer.parseInt(textBox.getText());
				if(Bet <= balance) {
					if(answer < 5) {
						JOptionPane.showMessageDialog(null, "You win :)");
						balance += Bet;
						label.setText(balance + "");
					}else {
						JOptionPane.showMessageDialog(null, "You Lost :(");
						balance -= Bet;
						label.setText(balance + "");
					}
				}else {
					JOptionPane.showMessageDialog(null, "You dont have enought money :(");
				}
			}
		});
		btnOdd.setBounds(242, 136, 89, 23);
		frame.getContentPane().add(btnOdd);
		
		textBox = new JTextField();
		textBox.setBounds(101, 83, 230, 20);
		frame.getContentPane().add(textBox);
		textBox.setColumns(10);
		
		label = new JLabel("500");
		label.setBounds(155, 42, 31, 14);
		frame.getContentPane().add(label);
		
		lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(101, 42, 46, 14);
		frame.getContentPane().add(lblBalance);
		
		lblGrlc = new JLabel("GRLC");
		lblGrlc.setBounds(189, 42, 46, 14);
		frame.getContentPane().add(lblGrlc);
	}
}
