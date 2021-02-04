package view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import logic.logNuevoUsuario;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class nuevoUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfNTelefono;
	public static JTextField tfEmail;
	public static JLabel lblImagen;
	private JButton okButton;
	private JButton cancelButton;
	private JTextField tfContraseña;


	public nuevoUsuario() {
		setModal(true);
		setTitle("Cine en casas - Nuevo usuario");
		
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
		
		tfContraseña = new JTextField();
		tfContraseña.setColumns(10);
		tfContraseña.setBounds(133, 224, 171, 20);
		contentPanel.add(tfContraseña);
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setOpaque(true);
		lblImagen.setForeground(Color.BLACK);
		lblImagen.setBackground(Color.WHITE);
		lblImagen.setBounds(228, 8, 76, 76);
		contentPanel.add(lblImagen);
		
		JDateChooser dateChooser = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		
		dateChooser.setBounds(133, 253, 171, 20);
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
					String pattern = "yyyy-MM-dd";
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
					System.out.println(simpleDateFormat.format(dateChooser.getDate()));
					
					logNuevoUsuario.introducirNuevoUsuario(tfNombre,tfApellido,tfNTelefono,tfEmail,tfContraseña);
					
					logNuevoUsuario.seleccionarFichero();
				}
			});
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						logNuevoUsuario.upload();
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addComponent(btnNewButton)
					.addComponent(okButton)
					.addComponent(cancelButton)
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
}
