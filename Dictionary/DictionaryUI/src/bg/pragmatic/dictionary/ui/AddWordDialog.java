package bg.pragmatic.dictionary.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import bg.pragmatic.dictionary.model.WordEntity;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddWordDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldWord;
	private JTextField textFieldTranslation;
	
	private WordEntity wordEntity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddWordDialog dialog = new AddWordDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddWordDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textFieldWord = new JTextField();
		textFieldWord.setBounds(193, 20, 206, 28);
		contentPanel.add(textFieldWord);
		textFieldWord.setColumns(10);
		
		textFieldTranslation = new JTextField();
		textFieldTranslation.setBounds(193, 77, 206, 28);
		contentPanel.add(textFieldTranslation);
		textFieldTranslation.setColumns(10);
		
		JLabel lblWord = new JLabel("Word:");
		lblWord.setBounds(37, 26, 61, 16);
		contentPanel.add(lblWord);
		
		JLabel lblTranslation = new JLabel("Translation:");
		lblTranslation.setBounds(37, 83, 88, 16);
		contentPanel.add(lblTranslation);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textFieldWord.getText().length() > 0 &&
								textFieldTranslation.getText().length() > 0) {
							wordEntity = new WordEntity(textFieldWord.getText(),
									textFieldTranslation.getText());
						}
						
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public WordEntity getWordEntity() {
		return wordEntity;
	}
}
