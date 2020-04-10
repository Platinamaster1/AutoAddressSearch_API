package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import webServers.ClienteWS;
import webServers.Logradouro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Canvas;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class Principal {

	private JFrame frame;
	private JTextField txtZip;
	private JTextField txtStreet;
	private JTextField txtNeigh;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtComplement;
	private JTextField txtNumber;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nicol\\OneDrive\\Outros\\Documentos\\GitHub\\PublicAreaConsultant_WEBSERVER\\images\\student"));
		frame.setBounds(100, 100, 775, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblP = new JLabel("Students Management");
		lblP.setFont(new Font("Courier New", Font.PLAIN, 40));
		panel.add(lblP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblCotuca = new JLabel("COTUCA - 2020 | All Rights Reserved");
		panel_1.add(lblCotuca);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("MODIFICATIONS", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_2.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSearchStudent = new JButton("SEARCH");
		btnSearchStudent.setForeground(Color.WHITE);
		btnSearchStudent.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnSearchStudent.setBackground(Color.BLACK);
		panel_4.add(btnSearchStudent);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setBackground(Color.BLACK);
		btnInsert.setForeground(Color.WHITE);
		btnInsert.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
		panel_4.add(btnInsert);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
		panel_4.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
		panel_4.add(btnDelete);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_5.add(panel_6, BorderLayout.EAST);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(null);
		
		JPanel panel_9 = new JPanel();
		
		JPanel panel_10 = new JPanel();
		
		JPanel panel_11 = new JPanel();
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
							.addContainerGap())
						.addComponent(panel_9, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 56, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 59, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(panel_11, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		
		JLabel lblCidade = new JLabel("City: ");
		lblCidade.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		
		txtCity = new JTextField();
		txtCity.setEditable(false);
		txtCity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtCity.setColumns(20);
		
		txtState = new JTextField();
		txtState.setEditable(false);
		txtState.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtState.setColumns(3);
		
		JLabel lblEstado = new JLabel("State: ");
		lblEstado.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		GroupLayout gl_panel_11 = new GroupLayout(panel_11);
		gl_panel_11.setHorizontalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_11.createSequentialGroup()
					.addGroup(gl_panel_11.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCidade)
						.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_panel_11.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEstado)
						.addComponent(txtState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(60))
		);
		gl_panel_11.setVerticalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addGroup(gl_panel_11.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCidade)
						.addComponent(lblEstado))
					.addGap(6)
					.addGroup(gl_panel_11.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_11.setLayout(gl_panel_11);
		
		JLabel lblBairro = new JLabel("Neighborhood: ");
		lblBairro.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		
		txtNeigh = new JTextField();
		txtNeigh.setEditable(false);
		txtNeigh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtNeigh.setColumns(25);
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addGroup(gl_panel_10.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBairro)
						.addComponent(txtNeigh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addComponent(lblBairro)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNeigh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_10.setLayout(gl_panel_10);
		
		JLabel lblNomeDaRua = new JLabel("Street:");
		lblNomeDaRua.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		
		txtStreet = new JTextField();
		txtStreet.setEditable(false);
		txtStreet.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtStreet.setColumns(30);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		txtNumber = new JTextField();
		txtNumber.setColumns(10);
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNomeDaRua, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtStreet, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumber)
						.addComponent(txtNumber, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeDaRua)
						.addComponent(lblNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_9.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtStreet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_9.setLayout(gl_panel_9);
		
		txtZip = new JTextField();
		txtZip.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtZip.setColumns(10);
		
		JLabel lblCep = new JLabel("Zip Code:");
		lblCep.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Logradouro logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "http://api.postmon.com.br/v1/cep/" + txtZip.getText());
				
				try
				{
					txtStreet.setText(logradouro.getLogradouro());
					txtNeigh.setText(logradouro.getBairro());
					txtCity.setText(logradouro.getCidade());
					txtState.setText(logradouro.getEstado());
					txtComplement.setText(logradouro.getComplemento());
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(frame, "Zip Code not found!");
				}
			}
		});
		
		
		btnSearch.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnSearch.setBackground(Color.BLACK);
		btnSearch.setForeground(Color.WHITE);
		
		JLabel lblComplement = new JLabel("Complement:");
		lblComplement.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		txtComplement = new JTextField();
		txtComplement.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtComplement.setColumns(5);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSearch))
						.addComponent(txtZip, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addComponent(lblComplement, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(94))
						.addGroup(gl_panel_8.createSequentialGroup()
							.addComponent(txtComplement, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCep)
						.addComponent(lblComplement, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtZip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtComplement, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_8.setLayout(gl_panel_8);
		panel_6.setLayout(gl_panel_6);
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new GridLayout(0, 2, -200, 100));
		
		JLabel label = new JLabel("RA:");
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_12.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField.setColumns(5);
		panel_12.add(textField);
		
		JLabel label_1 = new JLabel("Name: ");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_12.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_1.setColumns(27);
		panel_12.add(textField_1);
		
		JLabel label_2 = new JLabel("Course:");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel_12.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_2.setColumns(5);
		panel_12.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("QUERIES", null, panel_3, null);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 754, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 327, Short.MAX_VALUE)
		);
		panel_3.setLayout(gl_panel_3);
	}
}