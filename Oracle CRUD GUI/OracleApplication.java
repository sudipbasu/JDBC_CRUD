import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.ImageIcon;
import java.awt.Color;
public class OracleApplication {

	private JFrame frmOracleCrud;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OracleApplication window = new OracleApplication();
					window.frmOracleCrud.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 //Create the application.
	 
	Connection conn;
	public OracleApplication() {
		conn = Oracle_Conn.dbconnect();
		initialize();
	}

	
	private void initialize() {
		frmOracleCrud = new JFrame();
		frmOracleCrud.setTitle("Oracle CRUD");
		frmOracleCrud.setBounds(100, 100, 1128, 663);
		frmOracleCrud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOracleCrud.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(213, 139, 209, 36);
		frmOracleCrud.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(540, 145, 334, 31);
		frmOracleCrud.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEmployeeName = new JLabel("Employee Name :");
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEmployeeName.setBounds(213, 210, 250, 36);
		frmOracleCrud.getContentPane().add(lblEmployeeName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(540, 215, 334, 31);
		frmOracleCrud.getContentPane().add(textField_1);
		
		JLabel lblEmployeeEmail = new JLabel("Employee Email :");
		lblEmployeeEmail.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEmployeeEmail.setBounds(213, 290, 250, 36);
		frmOracleCrud.getContentPane().add(lblEmployeeEmail);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(540, 290, 334, 31);
		frmOracleCrud.getContentPane().add(textField_2);
		
		JLabel lblEmployeeDesignation = new JLabel("Employee Designation :");
		lblEmployeeDesignation.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEmployeeDesignation.setBounds(213, 369, 309, 36);
		frmOracleCrud.getContentPane().add(lblEmployeeDesignation);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(540, 374, 334, 31);
		frmOracleCrud.getContentPane().add(textField_3);
		
		JLabel lblEmployeeAddress = new JLabel("Employee Address :");
		lblEmployeeAddress.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEmployeeAddress.setBounds(213, 447, 269, 36);
		frmOracleCrud.getContentPane().add(lblEmployeeAddress);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(540, 452, 334, 31);
		frmOracleCrud.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					int id;
					String name,email,designation,address;
					id = Integer.parseInt(textField.getText());
					name = textField_1.getText();
					email = textField_2.getText();
					designation = textField_3.getText();
					address = textField_4.getText();
					PreparedStatement pst = conn.prepareStatement("insert into EMPLOYEE (ID,NAME,EMAIL,DESIGNATION,ADDRESS) VALUES (?,?,?,?,?)");
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setString(3, email);
					pst.setString(4, designation);
					pst.setString(5, address);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Inserted");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
				}
				catch(Exception e2)
				{
					System.err.println(e2.getLocalizedMessage());
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		btnNewButton.setBounds(174, 538, 97, 25);
		frmOracleCrud.getContentPane().add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					int id;
					String name,email,designation,address;
					id = Integer.parseInt(textField.getText());
					name = textField_1.getText();
					email = textField_2.getText();
					designation = textField_3.getText();
					address = textField_4.getText();
					PreparedStatement pst = conn.prepareStatement("update EMPLOYEE SET NAME = ? , EMAIL = ?, DESIGNATION = ?, ADDRESS = ? WHERE ID =?");
					pst.setString(1, name);
					pst.setString(2, email);
					pst.setString(3, designation);
					pst.setString(4, address);
					pst.setInt(5, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		btnUpdate.setBounds(342, 538, 97, 25);
		frmOracleCrud.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					int id;
					id = Integer.parseInt(textField.getText());
					PreparedStatement pst = conn.prepareStatement("delete from EMPLOYEE WHERE ID = ?");
					pst.setInt(1, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Deleted");
					textField.setText("");
				}
				catch(Exception e)
				{
					System.err.println(e.getLocalizedMessage());
				}
			}
		});
		btnDelete.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		btnDelete.setBounds(529, 538, 97, 25);
		frmOracleCrud.getContentPane().add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		btnExit.setBounds(722, 536, 97, 25);
		frmOracleCrud.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("H:\\JDBC\\JDBC_GUI_Application\\src\\icons8-notebook-emoji-96.png"));
		lblNewLabel_1.setBounds(12, 0, 189, 130);
		frmOracleCrud.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Employee Registration ");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(379, 43, 442, 53);
		frmOracleCrud.getContentPane().add(lblNewLabel_2);
	}
}
