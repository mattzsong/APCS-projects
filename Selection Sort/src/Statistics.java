import java.util.*;

public class Statistics {
    private int[][] quarterAverageTable;

    public Statistics(AllStudents a){
        quarterAverageTable = new int[a.getStudentNumber()][4];
        for(int i = 0; i < a.getStudentNumber(); i++) quarterAverageTable[i] = a.getStudentInfo()[i].getQuarterAverages();
    }

    public double[] getMeans(){
        double[] means = new double[4];
        for(int i = 0; i < 4; i++){
            double sum = 0;
            for(int j = 0; j < quarterAverageTable.length; j++){
                sum += quarterAverageTable[j][i];
            }
            means[i] = sum / quarterAverageTable.length;
        }
        return means;
    }

    public double[] getMedians(){
        double[] medians = new double[4];
        if(quarterAverageTable.length % 2 == 1){
            for(int i = 0; i < 4; i++){
                medians[i] = Double.valueOf(quarterAverageTable[quarterAverageTable.length/2][i]);
            }
        }
        else{
            for(int i = 0; i < 4; i++){
                medians[i] = (quarterAverageTable[quarterAverageTable.length/2][i] + quarterAverageTable[quarterAverageTable.length/2-1][i])/2.0;
            }
        }
        return medians;
    }

    public ArrayList<Integer>[] getModes(){
        ArrayList<Integer>[] modeList = (ArrayList<Integer>[])new ArrayList[4];
        HashMap<Integer, Integer> frequencies;
        for(int i = 0; i < 4; i++){
            frequencies = new HashMap<>();
            for(int j = 0; j < quarterAverageTable.length; j++){
                int val = quarterAverageTable[j][i];
                if(!frequencies.containsKey(val)) frequencies.put(val, 1);
                else                            frequencies.put(val, frequencies.get(val)+1);
            }
            ArrayList<Integer> modes = new ArrayList<>();
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
            if(maxFrequency == 1) modeList[i] = null;
            else                  modeList[i] = modes;
        }
        return modeList;
    }

    public double[] getStandardDeviations(){
        double[] sd = new double[4];
        double[] means = getMeans();
        Double differenceSquared;
        for(int i = 0; i < 4; i++){
            differenceSquared = 0.0;
            for(int j = 0; j < quarterAverageTable.length; j++){
            differenceSquared += (quarterAverageTable[j][i]-means[i]) * (quarterAverageTable[j][i]-means[i]);
            }
            sd[i] = Math.sqrt(differenceSquared / quarterAverageTable.length);
        }
        return sd;
    }

    
}
