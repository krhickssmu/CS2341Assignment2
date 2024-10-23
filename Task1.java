public class Task1 {
        public static void main(String[] args) {
            PriorityQueue jobQueue = new PriorityQueue(10);  
            int totalJobs = 0;
            int totalTime = 0;
            int completionTimeSum = 0;
            while(!StdIn.isEmpty()) {
                int jobId = StdIn.readInt();
                int processingTime = StdIn.readInt();
                jobQueue.insert(new Job(jobId, processingTime));
                totalJobs++;
            }

            StdOut.print("Execution order: [");
            while (!jobQueue.isEmpty()) {
                Job job = (Job) jobQueue.remove();
                totalTime += job.processingTime;
                completionTimeSum += totalTime;
                StdOut.print(job.jobID + (jobQueue.isEmpty() ? "" : ", "));
            }
            StdOut.print("]");

            // Calculate and print average completion time
            double averageCompletionTime = (double) completionTimeSum / totalJobs;
            StdOut.println();
            StdOut.println("Average completion time: "+ averageCompletionTime);
        }
}


