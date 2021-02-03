package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Start.principal;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class nuevoUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfNTelefono;
	private JTextField tfEmail;
	private JTextField textField_5;
	public static JLabel lblImagen;


	public nuevoUsuario() {
		setTitle("Cine en casas - Nuevo usuario");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int reply = JOptionPane.showConfirmDialog(principal.frame, "Seguro que quieres salir?", "Advertencia", JOptionPane.YES_NO_OPTION);
				if (reply == 0) {
					System.exit(0);
				}}
		});
		setAlwaysOnTop(true);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 340, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
		lblNombre.setBounds(33, 98, 90, 20);
		contentPanel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setBounds(33, 129, 90, 20);
		contentPanel.add(lblApellido);
		
		JLabel lblNumeroTe = new JLabel("Nº Telefono:");
		lblNumeroTe.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
		lblNumeroTe.setForeground(Color.WHITE);
		lblNumeroTe.setBounds(33, 160, 90, 20);
		contentPanel.add(lblNumeroTe);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
		lblEmail.setBounds(33, 191, 90, 20);
		contentPanel.add(lblEmail);
		
		JLabel lblContras = new JLabel("Contrasena:");
		lblContras.setForeground(Color.WHITE);
		lblContras.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
		lblContras.setBounds(33, 222, 90, 20);
		contentPanel.add(lblContras);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
		lblFecha.setBounds(33, 253, 90, 20);
		contentPanel.add(lblFecha);
		
		JLabel Titulo = new JLabel("Nuevo Usuario");
		Titulo.setForeground(new Color(229, 9, 20));
		Titulo.setFont(new Font("Bebas Neue", Font.PLAIN, 35));
		Titulo.setBounds(21, 11, 171, 57);
		contentPanel.add(Titulo);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(133, 98, 171, 20);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setColumns(10);
		tfApellido.setBounds(133, 131, 171, 20);
		contentPanel.add(tfApellido);
		
		tfNTelefono = new JTextField();
		tfNTelefono.setColumns(10);
		tfNTelefono.setBounds(133, 162, 171, 20);
		contentPanel.add(tfNTelefono);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(133, 193, 171, 20);
		contentPanel.add(tfEmail);
		
		JTextField tfCo = new JTextField();
		tfCo.setColumns(10);
		tfCo.setBounds(133, 224, 171, 20);
		contentPanel.add(tfCo);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(133, 255, 171, 20);
		contentPanel.add(textField_5);
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setOpaque(true);
		lblImagen.setForeground(Color.BLACK);
		lblImagen.setBackground(Color.WHITE);
		lblImagen.setBounds(228, 8, 76, 76);
		contentPanel.add(lblImagen);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
