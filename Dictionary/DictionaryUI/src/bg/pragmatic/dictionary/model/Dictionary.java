package bg.pragmatic.dictionary.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
	
	private Map<String, WordEntity> words;
	private static final String FILE_NAME = "dictionary.data";
	
	public Dictionary() {
		words = new HashMap<String, WordEntity>();
	}
	/**
	 * Add Entity
	 * @param entity
	 */
	public void addEntity(WordEntity entity) {
		words.put(entity.getWord(), entity);
	}
	
	public void deleteWordEntity(String word) {
		words.remove(word);
	}
	
	/**
	 * Search WordEntity that matches the given word 
	 * @param word
	 * @return WordEntity if is found. Otherwise null
	 */
	public WordEntity searchWord(String word) {
		return words.get(word);
	}
	
	public int getWordsCount() {
		return words.size();
	}
	
	public List<WordEntity> getSortedWordEntities() {
		return words.values()
				.stream()
				.sorted((w1, w2) -> w1.getWord().compareTo(w2.getWord()))
				.collect(Collectors.toList());
	}
	
	public void save() {
		try(PrintWriter writer = new PrintWriter(FILE_NAME)) {
			
			for(WordEntity wordEntity : words.values()) {
				writer.println(wordEntity.getWord() + " = " + wordEntity.getTranslation());
			}
			
		} catch (FileNotFoundException e) {
		} 
	}
	
	public void load() {
		try(Scanner sc = new Scanner(new File(FILE_NAME))) {
			
			while(sc.hasNext()) {
				String line = sc.nextLine();
				WordEntity wordEntity = parseLine(line);
				if(wordEntity != null) {
					addEntity(wordEntity);
				}
			}
				
		} catch (FileNotFoundException e) {
		}
	}
	
	private WordEntity parseLine(String line) {
		String[] tokens = line.split("=");
		if(tokens.length == 2) {
			return new WordEntity(tokens[0].trim(), tokens[1].trim());
		}
		
		return null;
	}
}
