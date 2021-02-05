package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Controller.CtrlNuevoUsuario;
import Model.usuario;
import logic.logNuevoUsuario;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class nuevoUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	public static JPanel contentPanel = new JPanel();
	//public static nuevoUsuario bFrame = new nuevoUsuario();
	private JTextField tfNombre;
	private JTextField tfApellido;
	public static JTextField tfNTelefono;
	public static JTextField tfEmail;
	public static JLabel lblImagen;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField tfContrasena;
	public static JDateChooser dateChooser;


	public nuevoUsuario() {
		setTitle("Cine en casas - Nuevo usuario");
		setModal(true);	
		setAlwaysOnTop(true);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		tfContrasena = new JTextField();
		tfContrasena.setColumns(10);
		tfContrasena.setBounds(133, 224, 171, 20);
		contentPanel.add(tfContrasena);
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setOpaque(true);
		lblImagen.setForeground(Color.BLACK);
		lblImagen.setBackground(Color.WHITE);
		lblImagen.setBounds(228, 8, 76, 76);
		contentPanel.add(lblImagen);
		
		dateChooser = new JDateChooser("yyyy-MM-dd", "#### - ## - ##", '_');
		dateChooser.setBounds(133, 253, 171, 20);
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse("2000-01-01");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		dateChooser.setDate(date);
		contentPanel.add(dateChooser);

		
		Panel panel = new Panel();
		panel.setBounds(228, 74, 76, -72);
		contentPanel.add(panel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnNewButton = new JButton("Seleccionar imagen");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logNuevoUsuario.seleccionarFichero();
				}
			});
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Model.usuario oUsua = new usuario(tfNombre.getText().toString(),tfApellido.getText().toString(),15,tfEmail.getText().toString(),dateChooser.getDate(),tfContrasena.getText().toString());

						CtrlNuevoUsuario.onclick_OK(oUsua);
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(6)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGap(28)
						.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(cancelButton)
								.addComponent(okButton))
							.addComponent(btnNewButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
}
