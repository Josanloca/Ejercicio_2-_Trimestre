package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CtrlSalaCine;
import logic.logSalaCine;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewPeliculas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JLabel lblPelicula;
	public static JLabel lbNombrePelicula ;
	public static JLabel lbICCANOMBRE;
	public static JLabel lbGENERONombre;

	public viewPeliculas() {
		setModal(false);	
		setResizable(false);
		setTitle("Cine en casa - Peliculas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icono.png")));

		setBounds(100, 100, 450, 219);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblPelicula = new JLabel("ERROR");
		lblPelicula.setHorizontalAlignment(SwingConstants.CENTER);
		lblPelicula.setFont(new Font("The Wild Breath of Zelda", Font.PLAIN, 20));
		lblPelicula.setOpaque(true);
		lblPelicula.setForeground(Color.ORANGE);
		lblPelicula.setBackground(Color.BLACK);
		lblPelicula.setBounds(10, 11, 100, 130);
		contentPanel.add(lblPelicula);
		{
			JLabel lbTitulo = new JLabel("Titulo: ");
			lbTitulo.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
			lbTitulo.setForeground(new Color(229, 9, 20));
			lbTitulo.setBounds(193, 48, 48, 14);
			contentPanel.add(lbTitulo);
		}
		
		JLabel lbICCA = new JLabel("ICCA:");
		lbICCA.setForeground(Color.WHITE);
		lbICCA.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
		lbICCA.setBounds(193, 71, 32, 14);
		contentPanel.add(lbICCA);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
		lblGenero.setBounds(193, 96, 58, 14);
		contentPanel.add(lblGenero);
		{
			lbNombrePelicula = new JLabel("");
			lbNombrePelicula.setBackground(Color.WHITE);
			lbNombrePelicula.setForeground(Color.BLACK);
			lbNombrePelicula.setOpaque(true);
			lbNombrePelicula.setFont(new Font("Arial", Font.PLAIN, 15));
			lbNombrePelicula.setBounds(251, 48, 173, 14);
			contentPanel.add(lbNombrePelicula);
		}
		{
			lbICCANOMBRE = new JLabel("");
			lbICCANOMBRE.setOpaque(true);
			lbICCANOMBRE.setForeground(Color.BLACK);
			lbICCANOMBRE.setFont(new Font("Arial", Font.PLAIN, 15));
			lbICCANOMBRE.setBackground(Color.WHITE);
			lbICCANOMBRE.setBounds(251, 73, 173, 14);
			contentPanel.add(lbICCANOMBRE);
		}
		{
			lbGENERONombre = new JLabel("");
			lbGENERONombre.setOpaque(true);
			lbGENERONombre.setForeground(Color.BLACK);
			lbGENERONombre.setFont(new Font("Arial", Font.PLAIN, 15));
			lbGENERONombre.setBackground(Color.WHITE);
			lbGENERONombre.setBounds(251, 98, 173, 14);
			contentPanel.add(lbGENERONombre);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNewButton = new JButton("Reservar entrada");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						viewSalaCine vsFrama = new viewSalaCine();
						vsFrama.setVisible(true);
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
