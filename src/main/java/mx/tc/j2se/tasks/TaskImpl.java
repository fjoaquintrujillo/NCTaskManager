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


    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public boolean isActive(){
        return active;
    }

    @Override
    public void setActive(boolean active){
        this.active = active;
    }

    @Override
    public int getTime(){
        if(repeated){
            return start;
        } else {
            return time;
        }
    }

    @Override
    public void setTime(int time){
        if(repeated){
            repeated = false;
            this.time = time;
        } else {
            this.time = time;
        }
    }

    @Override
    public int getStartTime(){
        if (!repeated){
            return time;
        } else {
            return start;
        }
    }

    @Override
    public int getEndTime(){
        if (!repeated){
            return time;
        } else {
            return end;
        }
    }

    @Override
    public int getRepeatInterval(){
        if (!repeated){
            return 0;
        } else {
            return interval;
        }
    }

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


    public boolean isRepeated(){
        return repeated;
    }


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
