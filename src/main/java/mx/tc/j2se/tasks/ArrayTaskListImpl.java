package mx.tc.j2se.tasks;

public class ArrayTaskListImpl implements ArrayTaskList{
    //Empty constructor
    public ArrayTaskListImpl(){};
    //private int i;
    private Task list[] = new Task[]{};


    @Override
    public void add(Task task) {
        Task newlist[] = new Task[list.length+1];
        int i;
        for(i = 0; i < list.length; i++ ){
            newlist[i] = list[i];
        }
        newlist[i] = task;
        list=newlist;

    }

    @Override
    public boolean remove(Task task) {
        boolean a= false;
        Task removelist[] = new Task[list.length];

        for (int j=0; j< list.length; j++){
            removelist[j] = list[j];
            if (list[j]==task){
                for(int k = j+1; k < list.length; k++ ){
                    removelist[j] = list[k];
                    j++;
                }
                a= true;
                break;
            }
        }
        Task finallist[] = new Task[list.length-1];
        for (int k=0; k< list.length-1; k++) {
            finallist[k] = removelist[k];
        }
        list=finallist;

        return a;
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public Task getTask(int index) {
        return list[index];
    }

    @Override
    public ArrayTaskList incoming(int from, int to) {
        ArrayTaskList incomingList = new ArrayTaskListImpl();
        int timea;
        Task taskcheking;
        for (int x=0; x< list.length; x++){
            taskcheking = list[x];
            timea = taskcheking.nextTimeAfter(from);
            if ((timea < to) && (timea != -1)){
                incomingList.add(taskcheking);

            }
        }
        return incomingList;

    }

}
