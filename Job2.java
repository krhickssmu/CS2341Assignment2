public class Job2 implements Comparable<Job2>{
    int jobID, processingTime, priority;
    public int compareTo(Job2 other) {
        if (this.priority != other.priority) {
            return this.priority - other.priority;
        } else {
            return this.processingTime - other.processingTime;
        }
    }
    public Job2(int jobId, int processingTime, int priority){
        this.jobID=jobId;
        this.processingTime=processingTime;
        this.priority=priority;
    }
}

