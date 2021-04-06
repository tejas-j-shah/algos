import java.util.*;

public class MaxMeetings {

    public static void main(String[] args) {

        double[] sortedStarts = {1, 2.30, 3, 5 };
        double[] sortedEnds = {2, 4, 5, 7};
        double[] unsortedStarts = {3, 2.30, 1, 5 };
        double[] unSortedEnds = {5, 4, 2, 7};
        System.out.println(" Max meetings that can be attended for sorted meetings is::: " + getMaxMeetingsCountSorted(sortedStarts, sortedEnds));
        System.out.println(" Max meetings that can be attended for unsorted meetings is::: " + getMaxMeetingsCountUnSorted(unsortedStarts, unSortedEnds));
    }

    // Assuming Arrays are sorted
    private static int getMaxMeetingsCountSorted(double[] starts, double[] ends) {
        int count = 1; // As the person will definitely attend one meeting if the list isnt empty
        for (int k=0 ; k<starts.length-1; k++) {
            if (starts[k+1] >= ends [k]) {
                count ++;
            }
        }
        return count;
    }

    // Assuming Arrays are NOT sorted
    private static int getMaxMeetingsCountUnSorted(double[] starts, double[] ends) {
        List<StartEndTime> times = new ArrayList<>();
        for (int i=0; i<starts.length; i++) {
            times.add(new StartEndTime(starts[i], ends[i]));
        }
        Collections.sort(times);
        int count = 1; // As the person will definitely attend one meeting if the list isnt empty
        for (int k=0 ; k<times.size()-1; k++) {
            if (times.get(k+1).getStartTime() >= times.get(k).getEndTime()) {
                count ++;
            }
        }
        return count;
    }

    static class StartEndTime implements Comparable<StartEndTime>{
        Double startTime;
        Double endTime;

        public StartEndTime(Double startTime, Double endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Double getStartTime() {
            return startTime;
        }

        public Double getEndTime() {
            return endTime;
        }


        @Override
        public int compareTo(StartEndTime o) {
            return  (this.getStartTime().compareTo((o).getStartTime()));

        }
    }
}

