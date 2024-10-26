public class Job3 implements Comparable <Job3>{

    int jobID;
    int processingTime;
    int arrivalTime;

    public int compareTo(Job3 x){
        if (this.arrivalTime != x.arrivalTime){
            return this.arrivalTime - x.arrivalTime;
        }
        else{
            return this.processingTime - x.processingTime;
        }
    }

    public Job3(int jobID, int processTime, int arrival){
        this.jobID = jobID;
        this.processingTime = processTime;
        this.arrivalTime = arrival;
    }

}