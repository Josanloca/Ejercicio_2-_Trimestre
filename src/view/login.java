package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Canvas;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField tfCorreo;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Medac\\git\\Ejercicio_2-_Trimestre\\img\\icono.png"));
		setTitle("Cine en casa - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("login");
		lblNewLabel.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(120, 58, 44, 22);
		contentPane.add(lblNewLabel);
		
		JLabel titulo = new JLabel("Cine en casa");
		titulo.setForeground(new Color(229, 9, 20));
		titulo.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		titulo.setBounds(80, 11, 123, 36);
		contentPane.add(titulo);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblCorreo.setBounds(15, 100, 65, 22);
		contentPane.add(lblCorreo);
		
		tfCorreo = new JTextField();
		tfCorreo.setBounds(95, 99, 180, 25);
		contentPane.add(tfCorreo);
		tfCorreo.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Passw:");
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblContraseña.setBounds(15, 150, 65, 22);
		contentPane.add(lblContraseña);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		btnLogin.setBounds(97, 203, 90, 28);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 20));
		passwordField.setBounds(95, 150, 180, 25);
		contentPane.add(passwordField);
	}
}
