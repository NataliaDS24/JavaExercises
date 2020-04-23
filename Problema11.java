import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class Problema11 extends JFrame {

	private JPanel contentPane;
	private JSpinner bultos;
	private JComboBox comboBox;
	private int num,b;
	private boolean bandera=false;
	private int si=0;
	private int no=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema11 frame = new Problema11();
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
	public Problema11() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSpinner bultos = new JSpinner();
		bultos.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                repaint();
            }
        });
		bultos.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		bultos.setBounds(30, 43, 89, 20);
		contentPane.add(bultos);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                repaint();
            }
        });
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Interior", "Exterior"}));
		comboBox.setBounds(256, 43, 126, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Sortear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				b=Integer.parseInt(bultos.getValue().toString());
				num= 1 + (int) Math.random()*3;
				bandera=true;
				if(b>5 || num==1) {
					si=si+1;
				}if(num==2 || num==3) {
					no=no+1;
				}
				setTitle("Revisados: "+si+" No revisados: "+no);
				repaint();
			}
		});
		btnNewButton.setBounds(164, 127, 89, 23);
		contentPane.add(btnNewButton);
	}
	
	public void paint (Graphics g)
    {
		super.paint(g);
		g.setColor (Color.white);
		g.fillOval (164, 190, 95, 95);
		if(bandera==true) 
		{
			if(b>5 || num==1) {
				g.setColor (Color.red);
				g.fillOval (164, 190, 95, 95);
			}if(num==2 || num==3) {
				g.setColor (Color.green);
				g.fillOval (164, 190, 95, 95);
			}
			
		}
		
    }
}
