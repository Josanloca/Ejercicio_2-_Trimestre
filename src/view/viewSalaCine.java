package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import Controller.CtrlSalaCine;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewSalaCine extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static DefaultPieDataset dataset = new DefaultPieDataset();
	public static JFreeChart chart;
	public static JLabel lblNumeroActual= new JLabel("0");
	
	
	

	public viewSalaCine() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icono.png")));

		setTitle("Cine en casa - Entradas");
		CtrlSalaCine.iniciador();

		contentPanel.setBackground(Color.BLACK);
		contentPanel.setLayout(null);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBounds(54, 10, 680, 420);
		contentPanel.add(chartPanel);
		setBounds(100, 100, 804, 602);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Entradas reservadas: ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(190, 450, 107, 14);
		contentPanel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlSalaCine.sumaEntrada();
			}
		});
		btnNewButton_1.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		btnNewButton_1.setBounds(301, 473, 53, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlSalaCine.restaEntrada();
			}
		});
		btnNewButton.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		btnNewButton.setBounds(134, 473, 50, 23);
		contentPanel.add(btnNewButton);
		
		lblNumeroActual = new JLabel("");
		lblNumeroActual.setFont(new Font("Bebas Neue", Font.BOLD, 20));
		lblNumeroActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroActual.setForeground(Color.WHITE);
		lblNumeroActual.setBounds(194, 475, 89, 21);
		contentPanel.add(lblNumeroActual);
		
		CtrlSalaCine.iniciador();
		setLocationRelativeTo(null);		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton cancelButton = new JButton("Cancel");
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
