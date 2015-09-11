package bg.pragmatic.dictionary.model;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class DictionaryTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private static final int COLUMNS_COUNT = 2;
	private List<WordEntity> wordEntites;
	
	@Override
	public int getRowCount() {
		return (wordEntites != null ? wordEntites.size() : 0);
	}

	@Override
	public int getColumnCount() {
		return COLUMNS_COUNT;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		WordEntity wordEntity = wordEntites.get(rowIndex);
		if(columnIndex == 0) {
			return wordEntity.getWord();
		} else {
			return wordEntity.getTranslation();
		}
	}
	
	public void setWordEntities(List<WordEntity> list) {
		wordEntites = list;
		fireTableDataChanged();
	}

	public WordEntity getWordEntity(int index) {
		return wordEntites.get(index);
	}
}
