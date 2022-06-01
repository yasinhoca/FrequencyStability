import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class form1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form1 frame = new form1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public form1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(10000, 10000, 100000, 10000));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		spinner.setBounds(214, 12, 95, 28);
		contentPane.add(spinner);

		JLabel lblNewLabel = new JLabel("Arama Uzay\u0131 B\u00FCy\u00FCkl\u00FC\u011F\u00FC");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(23, 17, 181, 19);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Olu\u015Ftur");

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(337, 12, 138, 28);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 61, 452, 218);
		contentPane.add(scrollPane);

		JTextArea t1 = new JTextArea();
		t1.setFont(new Font("Monospaced", Font.PLAIN, 12));
		t1.setLineWrap(true);
		scrollPane.setViewportView(t1);

		JButton btnNewButton_1 = new JButton("Binary Patternleri Ara");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(114, 310, 240, 29);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 358, 450, 228);
		contentPane.add(scrollPane_1);

		JTextArea t2 = new JTextArea();
		scrollPane_1.setViewportView(t2);
		t2.setLineWrap(true);
		t2.setFont(new Font("Monospaced", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1 = new JLabel("Yasin Sa\u011Flam");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(368, 596, 107, 19);
		contentPane.add(lblNewLabel_1);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int s = (int) spinner.getValue();
				t1.setText(uret(s));
				btnNewButton_1.setEnabled(true);
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int d1,d2,d3,d4;
				d1 = patternAra("00",t1.getText());
				d2 = patternAra("01",t1.getText());
				d3 = patternAra("10",t1.getText());
				d4 = patternAra("11",t1.getText());
				String s="00 patterni "+d1+" adet bulundu\n"+ 
						"00-> "+ciz(d1) +
						"\n\n01 patterni "+d2+" adet bulundu\n"+ 
						"01-> "+ciz(d2) +
						"\n\n10 patterni "+d3+" adet bulundu\n"+ 
						"10-> " +ciz(d3) +
						"\n\n11 patterni "+d4+" adet bulundu\n"+ 
						"11-> "+ ciz(d4) ;
				t2.setText(s);

			}
		});

	}

	String uret(int s) {
		String u="";
		Random r = new Random();
		for(int i=0;i<s;i++) {
			int a = r.nextInt(2);
			u += Integer.toString(a);
		}		
		return u;
	}

	int patternAra(String p, String u) {
		int adet=0;
		for(int i=0;i<u.length()-1;i++) {
			String ikili = Character.toString(u.charAt(i)) + Character.toString(u.charAt(i+1));	
			if(p.equals(ikili)) adet++;
		}
		return adet;
	}

	String ciz(int s) {
		float k = (float) s/100;
		int l = Math.round(k);
		String u="";
		for(int i=0;i<l;i++) u+="|";
		return u;
	}
}
