public class Task2 {
    public static void main(String[] args) {
        PriorityQueue jobQueue = new PriorityQueue(10);
        int totalJobs = 0;
        int totalTime = 0;
        int completionTimeSum = 0;
        while (!StdIn.isEmpty()) {
            int jobId = StdIn.readInt();
            int processingTime = StdIn.readInt();
            int priority = StdIn.readInt();
            jobQueue.insert(new Job2(jobId, processingTime, priority));
            totalJobs++;
        }

        StdOut.print("Execution order: [");
        while (!jobQueue.isEmpty()) {
            Job2 job = (Job2) jobQueue.remove();
            totalTime += job.processingTime;
            completionTimeSum += totalTime;
            StdOut.print(job.jobID + (jobQueue.isEmpty() ? "" : ", "));
        }
        StdOut.print("]");

        // Calculate and print average completion time
        double averageCompletionTime = (double) completionTimeSum / totalJobs;
        StdOut.println();
        StdOut.println("Average completion time: " + averageCompletionTime);
    }
}