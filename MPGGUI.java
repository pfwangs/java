import javax.swing.*;
import java.awt.event.*;

public class MPGGUI extends JFrame {
	private JPanel panel;
	private JLabel milesMessageLabel;
	private JLabel gallonsMessageLabel;
	private JLabel mpgLabel;
	private JLabel errorLabel;

	private JTextField gallonsTextField;
	private JTextField milesTextField;
	private JTextField mpgTextField;
	private JTextField errorTextField;

	private JButton calcButton;
	private JButton exitButton;
	private final int WINDOW_WIDTH = 310;
	private final int WINDOW_HEIGHT = 300;

	public MPGGUI() {
		setTitle("MPG Converter");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanel();
		add(panel);
		setVisible(true);

	}

	private void buildPanel() {
		// create labels
		milesMessageLabel = new JLabel("Enter number of miles");
		gallonsMessageLabel = new JLabel("Enter number of gallons");
		mpgLabel = new JLabel("MPG: ");
		errorLabel = new JLabel("Error Message");

		// create textfields
		mpgTextField = new JTextField(20);
		gallonsTextField = new JTextField(10);
		milesTextField = new JTextField(10);
		errorTextField = new JTextField(15);

		// create buttons
		calcButton = new JButton("Calculate MPG");
		calcButton.addActionListener(new CalcButtonListener());
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ExitListener());

		// add components to panel
		panel = new JPanel();
		panel.add(milesMessageLabel);
		panel.add(milesTextField);
		panel.add(gallonsMessageLabel);
		panel.add(gallonsTextField);
		panel.add(mpgLabel);
		panel.add(mpgTextField);
		panel.add(errorLabel);
		panel.add(errorTextField);
		panel.add(calcButton);
		panel.add(exitButton);

	}

	private class CalcButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String milesInput;
			String gallonsInput;
			double miles;
			double gallons;
			double mpgDouble;
			String mpgString;
			milesInput = milesTextField.getText();
			gallonsInput = gallonsTextField.getText();

			try {
				miles = Double.parseDouble(milesInput);
				gallons = Double.parseDouble(gallonsInput);
				errorTextField.setText("");
				if (miles < 0 || gallons < 0) {// checks to make sure that the user is not entering a negative number
					throw new NegativeDoubleException();
				}
				mpgDouble = miles / gallons;
				mpgString = Double.toString(mpgDouble);
				// JOptionPane.showMessageDialog(null, mpg);
				mpgTextField.setText(mpgString);
			} catch (NegativeDoubleException error) {
				errorTextField.setText("Must enter positive number");

			} catch (NumberFormatException error) {
				errorTextField.setText("Invalid input.");

			}

		}
	}
	private class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	        //DO SOMETHING
	        System.exit(0);
	    }
	}

}