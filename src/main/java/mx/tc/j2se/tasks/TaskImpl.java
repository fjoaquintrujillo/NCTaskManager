package mx.tc.j2se.tasks;

public class TaskImpl implements Task{

    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean repeated;

    //Empty constructor
    public TaskImpl(){};

    //For inactive task to run at a specified time without repeating with a given name
    public TaskImpl(String title, int time){
        this.title = title;
        this.time = time;
        repeated = false;
    }

    //For inactive task to run within the specified time range (including the start and the end time) with the set repetition interval and with a given name
    public TaskImpl(String title, int start, int end, int interval){
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        repeated = true;
    }

    //For reading the task name
    @Override
    public String getTitle(){
        return title;
    }
    //For setting the task name
    @Override
    public void setTitle(String title){
        this.title = title;
    }
    //For reading the task status
    @Override
    public boolean isActive(){
        return active;
    }
    //For setting the task status
    @Override
    public void setActive(boolean active){
        this.active = active;
    }

    // Methods for non-repetitive tasks
    //If the task is a repetitive one, return the start time of the repetition
    @Override
    public int getTime(){
        if(repeated){
            return start;
        } else {
            return time;
        }
    }
    //If the task was a repetitive it should become non-repetitive
    @Override
    public void setTime(int time){
        if(repeated){
            repeated = false;
            this.time = time;
        } else {
            this.time = time;
        }
    }
    //Methods for repetitive tasks
    //If the task is a non-repetitive one, return the time of execution
    @Override
    public int getStartTime(){
        if (!repeated){
            return time;
        } else {
            return start;
        }
    }
    //If the task is a non-repetitive one, return the time of execution
    @Override
    public int getEndTime(){
        if (!repeated){
            return time;
        } else {
            return end;
        }
    }
    //If the task is a non-repetitive one, return 0
    @Override
    public int getRepeatInterval(){
        if (!repeated){
            return 0;
        } else {
            return interval;
        }
    }
    //If the task is a non-repetitive one, it should become repetitive
    @Override
    public void setTime(int start, int end, int interval){
        if (!repeated){
            repeated = true;
            this.start = start;
            this.end = end;
            this.interval = interval;
        } else {
            this.start = start;
            this.end = end;
            this.interval = interval;
        }
    }

    //To check the repeatability
    public boolean isRepeated(){
        return repeated;
    }

    //To check the next task execution
    public int nextTimeAfter(int current){
        int i=0;
        if(!active){
            return -1;
        } else {
            if(!repeated){
                if (current >= time){
                    return  -1;
                } else {
                    return  time;
                }
            } else {
                if (current >= end){
                    return  -1;
                } else if (current < start){
                    return start;
                } else if (current == start){
                    return start+interval;
                } else {
                    int k=1;
                    for(int j=start; j <=current; j+=interval){
                        i=start+k*interval;
                        k++;
                    }
                    return i;
                }
            }
        }
    }
}
