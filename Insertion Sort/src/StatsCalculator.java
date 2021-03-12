import java.util.*;
public class StatsCalculator {
    private ArrayList<Integer> numbers;

    public StatsCalculator(ArrayList<Integer> n){
        numbers = n;
        if(!numbers.isEmpty()) insertionSort();
    }

    public ArrayList<Integer> getNumbers(){
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> n){
        numbers = n;
        if(!numbers.isEmpty()) insertionSort();
    }

    private void insertionSort(){
        ArrayList<Integer> sorted = new ArrayList<>();
        sorted.add(numbers.get(0));
        int index = 0;
        for(int i = 1; i < numbers.size(); i++){
            while(index < sorted.size() && numbers.get(i) > sorted.get(index)) index++;
            sorted.add(index, numbers.get(i));
            index = 0;
        }
        numbers = sorted;
    }

    public double findMean() throws Exception{
        if(numbers.isEmpty()) throw new EmptyListException();
        int sum = 0;
        for(int n: numbers) sum += n;
        return Double.valueOf(sum) / numbers.size();
    }

    public double findMedian() throws Exception{
        if(numbers.isEmpty()) throw new EmptyListException();
        if(numbers.size() % 2 == 1) return Double.valueOf(numbers.get(numbers.size()/2));
        else return Double.valueOf((numbers.get(numbers.size()/2) + numbers.get(numbers.size()/2-1)))/2;
    }

    public ArrayList<Integer> findModes() throws Exception{
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for(int n: numbers){
            if(!frequencies.containsKey(n)) frequencies.put(n, 1);
            else                            frequencies.put(n, frequencies.get(n)+1);
        }

        ArrayList<Integer> modes = new ArrayList<>();
        if(numbers.isEmpty()) throw new EmptyListException();
        int maxFrequency = 0;
        for(int key : frequencies.keySet()){
            if(frequencies.get(key) > maxFrequency){
                maxFrequency = frequencies.get(key);
                modes.clear();
                modes.add(key);
            }
            else if(frequencies.get(key) == maxFrequency){
                modes.add(key);
            }
        }
        if(maxFrequency == 1) return null;

        return modes;
    }

    public Double findStandardDeviation() throws Exception{
        if(numbers.isEmpty()) throw new EmptyListException();
        Double mean = findMean();
        Double differenceSquared = 0.0;
        for(int n: numbers){
            differenceSquared += (n-mean) * (n-mean);
        }
        return Math.sqrt(differenceSquared/numbers.size());
    }
}
