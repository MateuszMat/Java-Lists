package Cars;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {
	protected JButton buttonAdd = new JButton("Add New Car");
	protected JButton buttonSearch = new JButton("Search Cars");
	protected JButton buttonSort = new JButton("Sort Cars");

	protected JList<Cars> listCar = new JList<>();
	protected ListModel<Cars> listModel;
	protected java.util.List<Cars> cars = new ArrayList<>();
	private final JLabel lblNewLabel = new JLabel("");
	private final JLabel lblNewLabel_1 = new JLabel("");

	public MainFrame() {
		super("Car Search");
		getContentPane().setBackground(Color.LIGHT_GRAY);

		initComponents();

		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void initComponents() {
		JPanel panelButton = new JPanel();
		panelButton.setBounds(323, 103, 323, 33);
		panelButton.setBackground(Color.LIGHT_GRAY);
		buttonAdd.setFont(new Font("Californian FB", Font.BOLD, 12));
		buttonAdd.setForeground(Color.BLUE);

		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addCar();
			}
		});
		buttonSort.setFont(new Font("Baskerville Old Face", Font.BOLD, 12));
		buttonSort.setForeground(Color.BLUE);

		buttonSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				sortCars();
			}
		});
		buttonSearch.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 12));
		buttonSearch.setForeground(Color.BLUE);

		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				searchCars();
			}
		});
		getContentPane().setLayout(null);
		lblNewLabel.setBounds(702, 382, 282, 179);
		lblNewLabel.setIcon(new ImageIcon("C:\\eclipse projects\\Software Design Assignment\\src\\old.jpg"));
		
		getContentPane().add(lblNewLabel);
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panelButton.add(buttonAdd);
		panelButton.add(buttonSearch);
		panelButton.add(buttonSort);

		getContentPane().add(panelButton);
		listCar.setBounds(292, 168, 400, 360);
		listCar.setFont(new Font("MS PGothic", Font.BOLD, 14));
		listCar.setBackground(new Color(51, 153, 255));

		listCar.setPreferredSize(new Dimension(400, 360));

		listModel = new ListModel<Cars>(cars);
		listCar.setModel(listModel);

		listModel.addElement(new Cars("Audi"));
		lblNewLabel_1.setBounds(0, 412, 275, 149);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\eclipse projects\\Software Design Assignment\\src\\70s.jpg"));
		
		getContentPane().add(lblNewLabel_1);

		getContentPane().add(listCar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\eclipse projects\\Software Design Assignment\\src\\90.jpg"));
		lblNewLabel_2.setBounds(691, 0, 293, 163);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\eclipse projects\\Software Design Assignment\\src\\2020s.jpg"));
		lblNewLabel_3.setBounds(0, 0, 293, 149);
		getContentPane().add(lblNewLabel_3);
	}

	private void addCar() {
		String carModel = JOptionPane.showInputDialog(this, "Enter car model");
		if (carModel != null) {
			listModel.addElement(new Cars(carModel));
		}
	}

	private void sortCars() {
		Collections.sort(cars);
		listModel.fireDataChanged();
	}

	private void searchCars() {
		String carModel = JOptionPane.showInputDialog(this, "Enter cars model to search for:");

		if (carModel == null) {
			return;
		}

		Collections.sort(cars);

		int foundIndex = Collections.binarySearch(cars, new Cars(carModel));

		if (foundIndex >= 0) {
			listCar.setSelectedIndex(foundIndex);
		} else {
			JOptionPane.showMessageDialog(this, "Could not find the car " + carModel);
		}
	}
}