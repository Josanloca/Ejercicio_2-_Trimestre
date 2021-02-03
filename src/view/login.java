package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Start.principal;
import logic.logPrincipal;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static JPanel contentPane;
	private JTextField tfCorreo;
	private JPasswordField passwordField;


	public login() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int reply = JOptionPane.showConfirmDialog(principal.frame, "Seguro que quieres salir?", "Advertencia", JOptionPane.YES_NO_OPTION);
				if (reply == 0) {
					System.exit(0);
				}
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Medac\\git\\Ejercicio_2-_Trimestre\\img\\icono.png"));
		
		setTitle("Cine en casa - Login");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuLogin = new JMenu("Ayuda");
		menuBar.add(menuLogin);
		
		JMenuItem btnMenNuevoUsuario = new JMenuItem("No tengo cuenta");
		btnMenNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuLogin.add(btnMenNuevoUsuario);
		
		JMenuItem btnMenAdmin = new JMenuItem("Administracion");
		btnMenAdmin.setEnabled(false);
		menuLogin.add(btnMenAdmin);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Cine en casa");
		titulo.setForeground(new Color(229, 9, 20));
		titulo.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		titulo.setBounds(80, 30, 123, 36);
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

		btnLogin.setForeground(Color.BLACK);
		btnLogin.setBorderPainted(false);
		btnLogin.setBorder(new LineBorder(Color.BLACK));
		btnLogin.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		btnLogin.setBounds(95, 187, 90, 28);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 20));
		passwordField.setBounds(95, 150, 180, 25);
		contentPane.add(passwordField);
		

			btnLogin.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String sX="x";
					if(tfCorreo.getText().toString().equals("") && passwordField.getText().toString().equals("123")) {
						btnMenAdmin.setEnabled(true);
					}else {
						if(logPrincipal.LoginUsuario(tfCorreo,passwordField).equals("ok")) {
							sX = "Conexion Correcta";
						}else {
							sX = "Conexion Erronea";
						}
						JOptionPane.showMessageDialog(principal.frame,sX);
					}					
				}
			});

	}
}
