package view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CtrAdmin;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class ViewAdmin extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JTable usuTable;


	public ViewAdmin() {
		setTitle("Cine en casa - Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icono.png")));

		setBounds(100, 100, 850, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		usuTable = new JTable();
		usuTable.setForeground(Color.WHITE);
		usuTable.setFont(new Font("Bebas Neue", Font.PLAIN, 18));
		usuTable.setRowSelectionAllowed(false);
		usuTable.setBackground(Color.BLACK);
		scrollPane.setViewportView(usuTable);
		{
			setLocationRelativeTo(null);		

		}
		CtrAdmin.loadTable();
	}

}
