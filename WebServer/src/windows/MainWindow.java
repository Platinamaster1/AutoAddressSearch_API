package windows;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

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

import daos.Students;
import dbos.Student;

import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

public class MainWindow {

	private JFrame frame;
	
	private JTextField txtZip;
	private JTextField txtStreet;
	private JTextField txtNeigh;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtComplement;
	private JTextField txtNumber;
	private JTextField txtRa;
	private JTextField txtName;
	private JTextField txtCourse;
	
	private JButton btnSearch;
	private JButton btnSearchStudent;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnDelete;
	
	private JTabbedPane tabbedPane;
	
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	
	private JLabel lblP;
	private JLabel lblCotuca;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblBairro;
	private JLabel lblNomeDaRua;
	private JLabel lblNumber;
	private JLabel lblCep;
	private JLabel lblComplement;
	private JLabel lblRa;
	private JLabel lblName;
	private JLabel lblCourse;
	
	private GroupLayout gl_panel_3;
	private GroupLayout gl_panel_6;
	private GroupLayout gl_panel_7;
	private GroupLayout gl_panel_8;
	private GroupLayout gl_panel_9;
	private GroupLayout gl_panel_10;
	private GroupLayout gl_panel_11;
	private GroupLayout gl_panel_12;
	private GroupLayout gl_panel_13;
	private GroupLayout gl_panel_14;
	

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nicol\\OneDrive\\Outros\\Documentos\\GitHub\\PublicAreaConsultant_WEBSERVER\\images\\student"));
		frame.setBounds(100, 100, 775, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		lblP = new JLabel("Students Management");
		lblP.setFont(new Font("Courier New", Font.PLAIN, 40));
		panel.add(lblP);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		lblCotuca = new JLabel("COTUCA - 2020 | All Rights Reserved");
		panel_1.add(lblCotuca);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("MODIFICATIONS", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_2.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnSearchStudent = new JButton("SEARCH");
		btnSearchStudent.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSearchStudent.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					if(txtRa.getText()==null || txtRa.getText().equals(""))
						throw new Exception ("RA is necessary for the search!");
					
					int ra = Integer.parseInt(txtRa.getText());
					
					Student student = null;
					try
					{
						student = Students.getStudent(ra);
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null, "Student not found!", "ERROR", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					txtName.setText(student.getName());
					
					txtCourse.setText(String.valueOf(student.getCourseNumber()));
					txtZip.setText(student.getZipCode());
					btnSearch.doClick();
					txtComplement.setText(student.getComplement());
					txtNumber.setText(String.valueOf(student.getNumber()));
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Fill the RA blank and try again!", "ERROR", JOptionPane.ERROR_MESSAGE);
					txtRa.requestFocus();
				}
			}
		});
		btnSearchStudent.setForeground(Color.WHITE);
		btnSearchStudent.setFont(new Font("Dialog", Font.PLAIN, 25));
		btnSearchStudent.setBackground(Color.BLACK);
		panel_4.add(btnSearchStudent);
		
		btnInsert = new JButton("INSERT");
		btnInsert.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnInsert.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					int ra = Integer.parseInt(txtRa.getText());
					String name = txtName.getText();
					int course = Integer.parseInt(txtCourse.getText());
					String zip = txtZip.getText();
					String complem = txtComplement.getText();
					int number = Integer.parseInt(txtNumber.getText());
					if(!Students.exists(Integer.parseInt(txtRa.getText())))
					{
						Student student = new Student(ra, name, course, zip, complem, number);
						Students.insert(student);
						JOptionPane.showMessageDialog(null, "Sucessful insert!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Student already registered!", "ERROR", JOptionPane.ERROR_MESSAGE);
						ScreenCleaner();
						txtRa.requestFocus();
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Fill all the blanks and try again later!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnInsert.setBackground(Color.BLACK);
		btnInsert.setForeground(Color.WHITE);
		btnInsert.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
		panel_4.add(btnInsert);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					if(Students.exists(Integer.parseInt(txtRa.getText())))
					{
						int ra = Integer.parseInt(txtRa.getText());
						String name = txtName.getText();
						int course = Integer.parseInt(txtCourse.getText());
						String zip = txtZip.getText();
						String complem = txtComplement.getText();
						int number = Integer.parseInt(txtNumber.getText());
						
						Student student = new Student(ra, name, course, zip, complem, number);
						Students.update(student);
						JOptionPane.showMessageDialog(null, "Sucessful update!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "There isn't any student registered with that RA!");
						ScreenCleaner();
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Fill all the blanks and try again later!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
		panel_4.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if(txtRa.getText()==null || txtRa.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "RA is necessary for the deletion!", "ERROR", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					int ra = Integer.parseInt(txtRa.getText());
					if(JOptionPane.showConfirmDialog(null, "Do you really want to delete this Student?", "DELETION", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					{
						Students.delete(ra);
						JOptionPane.showMessageDialog(null, "Sucessful delete!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						ScreenCleaner();
					}
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Student not found! Try again!", "ERROR", JOptionPane.ERROR_MESSAGE);
					ScreenCleaner();
				}
			}
		});
		btnDelete.setBackground(Color.BLACK);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
		panel_4.add(btnDelete);
		
		panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_5.add(panel_6, BorderLayout.EAST);
		
		panel_8 = new JPanel();
		panel_8.setBorder(null);
		
		panel_9 = new JPanel();
		
		panel_10 = new JPanel();
		
		panel_11 = new JPanel();
		gl_panel_6 = new GroupLayout(panel_6);
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
		
		lblCidade = new JLabel("City: ");
		lblCidade.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		
		txtCity = new JTextField();
		txtCity.setEditable(false);
		txtCity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtCity.setColumns(20);
		
		txtState = new JTextField();
		txtState.setEditable(false);
		txtState.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtState.setColumns(3);
		
		lblEstado = new JLabel("State: ");
		lblEstado.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		
		gl_panel_11 = new GroupLayout(panel_11);
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
		
		lblBairro = new JLabel("Neighborhood: ");
		lblBairro.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		
		txtNeigh = new JTextField();
		txtNeigh.setEditable(false);
		txtNeigh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtNeigh.setColumns(25);
		
		gl_panel_10 = new GroupLayout(panel_10);
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
		
		lblNomeDaRua = new JLabel("Street:");
		lblNomeDaRua.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		
		txtStreet = new JTextField();
		txtStreet.setEditable(false);
		txtStreet.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtStreet.setColumns(30);
		
		lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		txtNumber = new JTextField();
		txtNumber.setColumns(10);
		
		gl_panel_9 = new GroupLayout(panel_9);
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
		
		lblCep = new JLabel("Zip Code:");
		lblCep.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		
		btnSearch = new JButton("SEARCH");
		btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
					String complemento = logradouro.getComplemento();
					if(complemento != null)
						txtComplement.setText(logradouro.getComplemento());
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Zip Code not found!", "ERROR", JOptionPane.ERROR_MESSAGE);
					txtStreet.setText("");
					txtNeigh.setText("");
					txtCity.setText("");
					txtState.setText("");
					txtComplement.setText("");
					txtNumber.setText("");
				}
			}
		});
		
		
		btnSearch.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnSearch.setBackground(Color.BLACK);
		btnSearch.setForeground(Color.WHITE);
		
		lblComplement = new JLabel("Complement:");
		lblComplement.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		txtComplement = new JTextField();
		txtComplement.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtComplement.setColumns(5);
		
		gl_panel_8 = new GroupLayout(panel_8);
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
		
		panel_12 = new JPanel();
		panel_5.add(panel_12, BorderLayout.CENTER);
		
		panel_7 = new JPanel();
		
		panel_13 = new JPanel();
		
		panel_14 = new JPanel();
		
		gl_panel_12 = new GroupLayout(panel_12);
		gl_panel_12.setHorizontalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(3, Short.MAX_VALUE))
				.addGroup(gl_panel_12.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_14, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel_12.createSequentialGroup()
					.addComponent(panel_13, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_12.setVerticalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_14, GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE)
					.addGap(62)
					.addComponent(panel_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(81)
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		lblRa = new JLabel("RA:");
		lblRa.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		txtRa = new JTextField();
		txtRa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtRa.setColumns(5);
		
		gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14.setHorizontalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addComponent(lblRa , GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(txtRa, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_panel_14.setVerticalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_14.setLayout(gl_panel_14);
		
		lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtName.setColumns(27);
		
		gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13.setHorizontalGroup(
			gl_panel_13.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_13.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblName)
					.addGap(23)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel_13.setVerticalGroup(
			gl_panel_13.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_13.setLayout(gl_panel_13);
		
		txtCourse = new JTextField();
		txtCourse.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtCourse.setColumns(5);
		
		lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCourse)
					.addGap(18)
					.addComponent(txtCourse, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(1)
							.addComponent(txtCourse, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCourse, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_7.setLayout(gl_panel_7);
		panel_12.setLayout(gl_panel_12);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("QUERIES", null, panel_3, null);
		gl_panel_3 = new GroupLayout(panel_3);
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
	
	private void ScreenCleaner()
	{
		txtZip.setText("");
		txtStreet.setText("");
		txtNeigh.setText("");
		txtCity.setText("");
		txtState.setText("");
		txtComplement.setText("");
		txtNumber.setText("");
		txtRa.setText("");
		txtName.setText("");
		txtCourse.setText("");
	}
}
