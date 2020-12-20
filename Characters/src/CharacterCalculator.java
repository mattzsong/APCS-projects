import java.util.Arrays;

public class CharacterCalculator {
    private String input;
    private int[] wordFrequency;
    private int[] letterFrequency;
    private String[] words;
    private boolean endPunctuation;
    
    //constructor
    public CharacterCalculator(String s) {
        input = s;
        input.trim();                       //remove whitespace from ends of string
        wordFrequency = new int[0];
        letterFrequency = new int[26];
        words = new String[0];
        endPunctuation = false;
    }


    public void displayInfo() {
        findFrequency();
        int characters = calculateCharacters();
        int wordCount = calculateWords();

        System.out.println("Characters: " + characters);
        System.out.println("Letter frequencies: ");
        for(int i = 0; i < 26; i++){
            if(letterFrequency[i] > 0){
                System.out.println((char)(i+65) + " " + letterFrequency[i]);
            }
        }

        System.out.println("Words: " + wordCount);
        for(int i = 0; i < words.length; i++){
            System.out.println(words[i] + " " + wordFrequency[i]);
        }

    }

    //helper methods
    private int calculateCharacters() {
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            sum += words[i].length() * wordFrequency[i];
        }
        if (endPunctuation)
            sum++;
        return sum;
    }

    private int calculateWords(){
        int sum = 0;
        for(int i = 0; i < wordFrequency.length; i++) sum += wordFrequency[i];
        return sum;
    }

    private void findFrequency() {
        int beginIndex = -1;
        int currentIndex = 0;
        while (currentIndex < input.length()) {
            char c = input.charAt(currentIndex);
            //a non-whitespace character 
            if (!(c == ' ' || c == '\t'))
                //when a new word begins
                if(beginIndex < 0) beginIndex = currentIndex;
                //a letter character is added to the letter frequency using ASCII
                if(((int)c >= 65 && (int)c <= 90) || ((int)c >= 97 && (int)c <= 122)){
                    char uppercaseC = Character.toUpperCase(c);
                    letterFrequency[(int)uppercaseC - 65]++;
                }
            //when a word ends
            else if ((c == ' ' || c == '\t') && beginIndex >= 0) {
                String word = input.substring(beginIndex, currentIndex);
                int indexOfWord = getIndexOfWord(word);
                //increase the frequency if the word is already present
                if (indexOfWord >= 0)
                    wordFrequency[indexOfWord]++;
                //add a new frequency if the word is not present
                else {
                    addToWords(word.toUpperCase());
                    addToWordFrequency();
                }
                beginIndex = -1;
            }
            currentIndex++;
        }

        //determining the last word
        String lastWord = input.substring(beginIndex, input.length());
        char lastChar = lastWord.charAt(lastWord.length() - 1);
        if (lastChar == '.' || lastChar == '!' || lastChar == '?' || lastChar == ':' || lastChar == ';'
                || lastChar == ',')
            endPunctuation = true;

        if (endPunctuation)
            lastWord = lastWord.substring(0, lastWord.length() - 1);
        int indexOfWord = getIndexOfWord(lastWord);
        if (indexOfWord >= 0)
            wordFrequency[indexOfWord]++;
        else {
            addToWords(lastWord.toUpperCase());
            addToWordFrequency();
        }
    }

    private int getIndexOfWord(String w) {
        for (int i = 0; i < words.length; i++) {
            if (w.toUpperCase().equals(words[i]))
                return i;
        }
        return -1;
    }

    private void addToWordFrequency() {
        int[] newwordFrequency = Arrays.copyOf(wordFrequency, wordFrequency.length + 1);
        newwordFrequency[newwordFrequency.length - 1] = 1;
        this.wordFrequency = newwordFrequency;
    }

    private void addToWords(String w) {
        String[] newWords = Arrays.copyOf(words, words.length + 1);
        newWords[newWords.length - 1] = w;
        this.words = newWords;
    }
}
