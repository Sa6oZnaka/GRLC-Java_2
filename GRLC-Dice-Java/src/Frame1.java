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
	private JLabel DisplayBet;
	private int balance=500;
	private int Bet=10;
	private int minDeposit=2;
	private int Result=0;
	private JLabel lblBalance;
	private JLabel lblGrlc;
	private JLabel lblBet;
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
		
		JButton btnEven = new JButton("ODD");
		btnEven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Random rn = new Random();
				int answer = rn.nextInt(6) + 1;
				Result = answer;
				Bet = Integer.parseInt(textBox.getText());
				if(Bet >= minDeposit) {
					DisplayBet.setText(Result + "");
					if(Bet <= balance) {
						if((answer & 1) == 1) {
							JOptionPane.showMessageDialog(null, "You Win :)");
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
				}else {
					JOptionPane.showMessageDialog(null, "Minimum bet is 2GRLC!");
				}
			}
		});
		btnEven.setBounds(238, 135, 89, 23);
		frame.getContentPane().add(btnEven);
		
		JButton btnOdd = new JButton("EVEN");
		btnOdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rn = new Random();
				int answer = rn.nextInt(6) + 1;
				Result = answer;
				Bet = Integer.parseInt(textBox.getText());
				if(Bet >= minDeposit) {
					DisplayBet.setText(Result + "");
					if(Bet <= balance) {
						if((answer & 1) == 1) {
							JOptionPane.showMessageDialog(null, "You Lost :(");
							balance -= Bet;
							label.setText(balance + "");
						}else {
							JOptionPane.showMessageDialog(null, "You Win :)");
							balance += Bet;
							label.setText(balance + "");
						}
					}else {
						JOptionPane.showMessageDialog(null, "You dont have enought money :(");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Minimum bet is 2GRLC!");
				}
			}
		});
		btnOdd.setBounds(101, 135, 89, 23);
		frame.getContentPane().add(btnOdd);
		
		textBox = new JTextField();
		textBox.setText("10");
		textBox.setToolTipText("");
		textBox.setBounds(101, 83, 226, 20);
		frame.getContentPane().add(textBox);
		textBox.setColumns(10);
		
		label = new JLabel("500");
		label.setBounds(206, 42, 28, 14);
		frame.getContentPane().add(label);
		
		lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(137, 34, 59, 30);
		frame.getContentPane().add(lblBalance);
		
		lblGrlc = new JLabel("GRLC");
		lblGrlc.setBounds(253, 42, 37, 14);
		frame.getContentPane().add(lblGrlc);
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(166, 185, 46, 14);
		frame.getContentPane().add(lblResult);
		
		DisplayBet = new JLabel("-");
		DisplayBet.setBounds(227, 185, 46, 14);
		frame.getContentPane().add(DisplayBet);
		
		lblBet = new JLabel("Bet:");
		lblBet.setBounds(63, 86, 28, 14);
		frame.getContentPane().add(lblBet);
	}
}
