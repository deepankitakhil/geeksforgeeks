package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepankit on 12/12/2016.
 */

public class TimeStampRecorder {

  private List<LogData> logDataEntries;

  public TimeStampRecorder(List<LogData> logDataEntries) {
    this.logDataEntries = logDataEntries;
  }

  public static void main(String[] args) {
    String fromTimestamp = "2";
    String toTimestamp = "4";
    TimeStampRecorder timeStampRecorder = new TimeStampRecorder(new ArrayList<>());
    List<LogData> logDataList = timeStampRecorder.processFile("someFilePath");
    timeStampRecorder.updateLogEntries(logDataList);
    OutputQueryData outputQueryData = timeStampRecorder.queryMappedDataToListOutTransactionsUsingBinarySearch(logDataList, fromTimestamp, toTimestamp);
    timeStampRecorder.queryOutput(outputQueryData);
  }

  private void updateLogEntries(List<LogData> logDataList) {
    logDataEntries = logDataList;
  }

  private void queryOutput(OutputQueryData outputQueryData) {
    for (int index = outputQueryData.fromTimeStampDataIndex; index <= outputQueryData.toTimeStampDataIndex; index++)
      System.out.println(logDataEntries.get(index).data);
  }

  private OutputQueryData queryMappedDataToListOutTransactionsUsingBinarySearch(List<LogData> logDataList,
                                                                                String fromTimeStamp, String toTimeStamp) {
    int fromTimeStampDataIndex = performBinarySearch(logDataList, 0, logDataList.size(), fromTimeStamp);
    int toTimeStampDataIndex = performBinarySearch(logDataList, 0, logDataList.size(), toTimeStamp);
    return new OutputQueryData(fromTimeStampDataIndex, toTimeStampDataIndex);
  }

  private int performBinarySearch(List<LogData> dataEntryList, int startIndex, int endIndex, String timeStamp) {
    if (startIndex < endIndex) {
      int midIndex = startIndex + (endIndex - startIndex) / 2;
      String logDataTimeStamp = dataEntryList.get(midIndex).timeStamp;
      if (timeStamp.compareTo(logDataTimeStamp) > 0)
        return performBinarySearch(dataEntryList, midIndex, endIndex, timeStamp);
      else
        return performBinarySearch(dataEntryList, startIndex, midIndex, timeStamp);
    }
    return Integer.MIN_VALUE;
  }

  private List<LogData> processFile(String filePath) {
    List<LogData> logData = new ArrayList<>();
    logData.add(new LogData("1", "first message"));
    logData.add(new LogData("2", "first message"));
    logData.add(new LogData("3", "first message"));
    logData.add(new LogData("4", "first message"));
    logData.add(new LogData("5", "first message"));
    logData.add(new LogData("6", "first message"));
    logData.add(new LogData("7", "first message"));
    logData.add(new LogData("8", "first message"));
    return logData;
  }


  private static class LogData {
    private String timeStamp;
    private String data;

    public LogData(String timeStamp, String data) {
      this.timeStamp = timeStamp;
      this.data = data;
    }
  }

  private static class OutputQueryData {
    private int fromTimeStampDataIndex;
    private int toTimeStampDataIndex;

    public OutputQueryData(int fromTimeStampDataIndex, int toTimeStampDataIndex) {
      this.fromTimeStampDataIndex = fromTimeStampDataIndex;
      this.toTimeStampDataIndex = toTimeStampDataIndex;
    }
  }

}
