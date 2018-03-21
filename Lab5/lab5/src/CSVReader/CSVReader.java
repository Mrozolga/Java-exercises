package CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {
    BufferedReader reader;
    String delimiter;
    boolean hasHeader;
    String filename;
    List<String> columnLabels = new ArrayList<>();
    Map<String, Integer> columnLabelsToInt = new HashMap<>();
    String[]current;
    String[] header;

    public CSVReader(String filename){
        this.filename=filename;
    }

    public CSVReader(String filename,String delimiter){
        this(filename);
        this.delimiter=delimiter;
    }


    public CSVReader(String filename,String delimiter,boolean hasHeader) throws IOException {
        reader = new BufferedReader(new FileReader(filename));
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if(hasHeader) parseHeader();
    }

    private void parseHeader() throws IOException {
        String line = reader.readLine();
        if (line == null) {
            return;
        }
        header = line.split(delimiter);
        for (int i = 0; i < header.length; i++) {
                columnLabels.add(header[i]);
                columnLabelsToInt.put(header[i], i);
        }
    }

    public boolean next() throws IOException {
        String line = reader.readLine();
        if (line==null) {
            return false;
        }
        current = line.split(delimiter);
        return true;
    }
    public List<String> getColumnLabels()
    {
        return columnLabels;
    }
    public int getRecordLength()
    {
        return current.length;
    }
    public boolean isMissing(int columnIndex)
    {
        if(columnIndex>=current.length || current[columnIndex].isEmpty())
            return true;
        else return false;
    }

    public boolean isMissing(String columnLabel) {
        if(!columnLabelsToInt.containsKey(columnLabel))
            return true;
        return isMissing(columnLabelsToInt.get(columnLabel));
    }

    public String get(int columnIndex)
    {
        if (this.isMissing(columnIndex)) return "";
            return this.current[columnIndex];
    }
    public String get(String columnLabel)
    {
        if(isMissing(columnLabel))
            return "";
        int index = columnLabelsToInt.get(columnLabel);
        return current[index];
    }
    public int getInt(int columnIndex)
    {
        if(isMissing(columnIndex))
            throw new RuntimeException("ERROR!");
        String data = get(columnIndex);
        return Integer.parseInt(data);
    }
    public int getInt(String columnLabel)
    {
        if(isMissing(columnLabel))
            throw new RuntimeException("ERROR!");
        String data = get(columnLabel);
        return Integer.parseInt(data);
    }
    long getLong(int columnIndex) {
        if (this.isMissing(columnIndex)) throw new RuntimeException("ERROR!");
        String data = get(columnIndex);
        return Long.parseLong(data);

    }
    long getLong(String columnLabel) {
        if (isMissing(columnLabel)) throw new RuntimeException("ERROR!");
        String data = get(columnLabel);
        return Long.parseLong(data);

    }
        double getDouble(int columnIndex) {
            if (this.isMissing(columnIndex)) throw new RuntimeException("ERROR!");
                return Double.parseDouble(current[columnIndex]);

        }
        public double getDouble(String columnLabel)
    {
        if (this.isMissing(columnLabel)) throw new RuntimeException("ERROR!");
            int n = this.columnLabelsToInt.get(columnLabel);
            return Double.parseDouble(current[n]);

    }
}
