package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.CtrlGeneral;
import Controller.CtrlPeliculas;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ViewGeneral extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public static viewPeliculas vpFrame = new viewPeliculas();
	public static JLabel lblNewLabel ;
	@SuppressWarnings("rawtypes")
	public static JList lPelicula;
	private final Map<String, ImageIcon> imageMap;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ViewGeneral() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icono.png")));

		setTitle("Cine en casa - General");
		
		setLocationRelativeTo(null);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Bienvenido: ");
		lblNewLabel.setFont(new Font("Bebas Neue", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(368, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		String[] nameList = CtrlGeneral.NombrePeliculasList();
		
		lPelicula = new JList(nameList);
		lPelicula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vpFrame.setVisible(true);
				CtrlPeliculas.iniciacionPeli();
				System.out.println("hola");
			}
		});

		lPelicula.setForeground(Color.RED);
		lPelicula.setBackground(Color.BLACK);
        imageMap = CtrlGeneral.createImageMap(nameList);
        lPelicula.setCellRenderer(new MarioListRenderer());


		scrollPane.setViewportView(lPelicula);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(40);
		contentPane.add(panel_1, BorderLayout.WEST);
	}
	
	//en honor al que se lo he robado le dejare su nombre
    public class MarioListRenderer extends DefaultListCellRenderer {

		private static final long serialVersionUID = 1L;
		Font font = new Font("helvitica", Font.BOLD, 24);

        @Override
        public Component getListCellRendererComponent(
                @SuppressWarnings("rawtypes") JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            label.setIcon(imageMap.get((String) value));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(font);
            return label;
        }
    }
}
