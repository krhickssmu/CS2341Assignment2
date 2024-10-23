public class Job implements Comparable<Job>{
    int jobID, processingTime;

    public int compareTo(Job other) {
        return this.processingTime - other.processingTime;
    }

    public Job(int jobId, int processingTime){
        this.jobID=jobId;
        this.processingTime=processingTime;
    }
}
