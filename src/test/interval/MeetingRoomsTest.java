package test.interval;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRoomsTest {
    @Test
    public void TestMeetingRooms() {


    }

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return true;
        }
        intervals.sort(Comparator.comparingInt(o -> o.start));


        for (int i= 0; i < intervals.size() - 1; i++){
            Interval first = intervals.get(i);
            Interval second = intervals.get(i+1);

            if (first.end > second.start){
                return false;
            }
        }

        return true;

    }
}
