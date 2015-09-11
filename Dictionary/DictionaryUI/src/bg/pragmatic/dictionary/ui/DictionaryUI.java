package bg.pragmatic.dictionary.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import bg.pragmatic.dictionary.model.Dictionary;
import bg.pragmatic.dictionary.model.DictionaryTableModel;
import bg.pragmatic.dictionary.model.WordEntity;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DictionaryUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textFieldSearchWord;
	private JTable table;
	private DictionaryTableModel tableModel;
	private Dictionary dictionary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DictionaryUI frame = new DictionaryUI();
					frame.load();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DictionaryUI() {
		
		dictionary = new Dictionary();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldSearchWord = new JTextField();
		textFieldSearchWord.setBounds(6, 6, 165, 28);
		contentPane.add(textFieldSearchWord);
		textFieldSearchWord.setColumns(10);
		
		JButton btnSearchWord = new JButton("Search word");
		btnSearchWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchWord();
			}
		});
		btnSearchWord.setBounds(189, 7, 117, 29);
		contentPane.add(btnSearchWord);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 69, 275, 174);
		contentPane.add(scrollPane);
		
		tableModel = new DictionaryTableModel();
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
		JButton btnAddWord = new JButton("Add word");
		btnAddWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWord();
			}
		});
		btnAddWord.setBounds(303, 65, 117, 29);
		contentPane.add(btnAddWord);
		
		JButton btnDeleteWord = new JButton("Delete word");
		btnDeleteWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteWord();
			}
		});
		btnDeleteWord.setBounds(303, 106, 117, 29);
		contentPane.add(btnDeleteWord);
	}
	
	public void load() {
		dictionary.load();
		tableModel.setWordEntities(dictionary.getSortedWordEntities());
	}
		
	private void addWord() {
		AddWordDialog dialog = new AddWordDialog();
		dialog.setModal(true);
		dialog.setVisible(true);
		
		WordEntity wordEntity = dialog.getWordEntity();
		if(wordEntity != null) {
			dictionary.addEntity(wordEntity);
			dictionary.save();
			tableModel.setWordEntities(dictionary.getSortedWordEntities());
		}
	}
	
	private void deleteWord() {
		int selectedRow = table.getSelectedRow();
		if(selectedRow != -1) {
			WordEntity wordEntity = tableModel.getWordEntity(selectedRow);
			dictionary.deleteWordEntity(wordEntity.getWord());
			dictionary.save();
			tableModel.setWordEntities(dictionary.getSortedWordEntities());
		}
	}
	
	private void searchWord() {
		String word = textFieldSearchWord.getText().trim();
		if(word.length() > 0) {
			WordEntity wordEntity = dictionary.searchWord(word);
			if(wordEntity != null) {
				JOptionPane.showMessageDialog(this,
						"Translation of " + wordEntity.getWord() + " is " + wordEntity.getTranslation(),
						"Translation",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this,
						"Unable to find word: " + word,
						"Translation",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
