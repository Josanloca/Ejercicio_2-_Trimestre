package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.CtrlGeneral;
import Controller.CtrlLogin;
import Start.principal;
import logic.logLogin;

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
import javax.swing.JCheckBox;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static nuevoUsuario nUFrame = new nuevoUsuario();
	public static ViewGeneral vgFrame = new ViewGeneral();
	public static ViewAdmin vaFrame = new ViewAdmin();
	public static JPanel contentPane;
	public static JTextField tfCorreo;
	public static JPasswordField passwordField;
	public static JCheckBox cbRecordatorio;


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

		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icono.png")));
		
		setTitle("Cine en casa - Login");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 300, 340);
		
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuLogin = new JMenu("Ayuda");
		menuBar.add(menuLogin);
		
		JMenuItem btnMenNuevoUsuario = new JMenuItem("No tengo cuenta");
		btnMenNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nUFrame.setVisible(true);
			}
		});
		menuLogin.add(btnMenNuevoUsuario);
		
		JMenuItem btnMenAdmin = new JMenuItem("Administracion");
		btnMenAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaFrame.setVisible(true);
				principal.frame.setVisible(false);
			}
		});
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
		
		JLabel lblContrasena = new JLabel("Passw:");
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblContrasena.setBounds(15, 150, 65, 22);
		contentPane.add(lblContrasena);
		
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
		
		boolean b = CtrlLogin.isExiste();

		
		cbRecordatorio = new JCheckBox("");
		cbRecordatorio.setBounds(185, 225, 18, 18);
		cbRecordatorio.setSelected(b);
		contentPane.add(cbRecordatorio);
		
		JLabel lblRecordar = new JLabel("Recordar");
		lblRecordar.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
		lblRecordar.setForeground(Color.ORANGE);
		lblRecordar.setBounds(80, 227, 65, 16);
		contentPane.add(lblRecordar);
		

			btnLogin.addActionListener(new ActionListener() {
				
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					String sX="x";
					if(tfCorreo.getText().toString().equals("") && passwordField.getText().toString().equals("123")) {
						btnMenAdmin.setEnabled(true);
					}else {
						if(logLogin.LoginUsuario(tfCorreo,passwordField).equals("ok")) {
							vgFrame.setVisible(true);
							principal.frame.setVisible(false);
							if(cbRecordatorio.isSelected()) {
								CtrlLogin.cargaUsuario();
							}else {
								CtrlLogin.borrado();
							}
							CtrlGeneral.NombreUsuario();
						}else {
							sX = "Conexion Erronea";
							JOptionPane.showMessageDialog(principal.frame,sX);
						}
						
					}					
				}
			});

	}
}
