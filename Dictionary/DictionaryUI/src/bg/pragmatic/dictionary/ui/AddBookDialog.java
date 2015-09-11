package bg.pragmatic.dictionary.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class AddBookDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddBookDialog dialog = new AddBookDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddBookDialog() {
		setTitle("Add book");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(113, 11, 311, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(113, 42, 311, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(113, 73, 311, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(113, 104, 311, 20);
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			textField_4 = new JTextField();
			textField_4.setBounds(113, 135, 311, 20);
			contentPanel.add(textField_4);
			textField_4.setColumns(10);
		}
		{
			textField_5 = new JTextField();
			textField_5.setBounds(113, 166, 311, 20);
			contentPanel.add(textField_5);
			textField_5.setColumns(10);
		}
		{
			JLabel lblHeadline = new JLabel("Headline:");
			lblHeadline.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblHeadline.setBounds(48, 11, 55, 20);
			contentPanel.add(lblHeadline);
		}
		{
			JLabel lblAuthor = new JLabel("Author:");
			lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblAuthor.setBounds(48, 42, 55, 20);
			contentPanel.add(lblAuthor);
		}
		{
			JLabel lblPrice = new JLabel("Price:");
			lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPrice.setBounds(48, 73, 55, 20);
			contentPanel.add(lblPrice);
		}
		{
			JLabel lblPublishers = new JLabel("Publishers:");
			lblPublishers.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPublishers.setBounds(48, 104, 68, 20);
			contentPanel.add(lblPublishers);
		}
		{
			JLabel lblIsForeign = new JLabel("Is foreign:");
			lblIsForeign.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIsForeign.setBounds(48, 135, 55, 20);
			contentPanel.add(lblIsForeign);
		}
		{
			JLabel lblStock = new JLabel("Stock:");
			lblStock.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblStock.setBounds(48, 166, 55, 20);
			contentPanel.add(lblStock);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Add");
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
