import java.util.Comparator;
import java.util.ArrayList;

public class Task3 {
    public static void main(String[] args) {


        ArrayList<Job3> list = new ArrayList<>();

        int jobID;
        int processTime;
        int arrival;
        int clock = 0;


        PriorityQueue<Job3> pq = new PriorityQueue(10);

        int time = 0;
        int totalJobs = 0;
        double completionT = 0;


        //read from txt file
        while (!StdIn.isEmpty()){
            jobID = StdIn.readInt();
            processTime = StdIn.readInt();
            arrival = StdIn.readInt();

            //add input to be sorted later based on arrival
            list.add(new Job3(jobID, processTime, arrival));
        }


        list.sort(new Comparator<Job3>() {
            @Override
            public int compare(Job3 j1, Job3 j2) {
                return Integer.compare(j1.arrivalTime, j2.arrivalTime);
            }
        });
        for (int i=0; i<list.get(list.size()-1).arrivalTime; i++){

            for (Job3 job : list) {

                //check for new arrivals -> compare processing time and swap w shortest time
                if (job.arrivalTime == clock) {
                    pq.insert(job);
                    totalJobs++;
                }

            }
            clock++;
        }
        //print execution order
        StdOut.print("Execution order: [");
        while(!pq.isEmpty()){
            Job3 job = (Job3)pq.remove();
            time = time + job.processingTime;
            StdOut.print(job.jobID + ", ");
        }
        StdOut.print("]");

        // print avg time
        completionT = (double) time/totalJobs;
        StdOut.println();
        StdOut.println("Average Completion Time: " + completionT);
    }
}