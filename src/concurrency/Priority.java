package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Priority {
    private static volatile boolean notStart = true;
    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<Job>();
        for(int i = 0 ; i < 10 ; i++){
            int p = i < 5? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(p);
            jobs.add(job);
            Thread thread = new Thread(job , "t"+i);
            thread.setPriority(p);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(1);
        notEnd = false;
        for (Job job : jobs){
            System.out.println("job priority:"+job.priority + ", count="+job.jobcount);
        }

    }

    static class Job implements Runnable{
        private int priority;
        private long jobcount;

        public Job(int priority){
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart){
                Thread.yield();
            }
            while (notEnd){
                Thread.yield();
                jobcount++;
            }
        }
    }

}


