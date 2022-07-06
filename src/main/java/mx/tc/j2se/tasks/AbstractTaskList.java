package mx.tc.j2se.tasks;

import static mx.tc.j2se.tasks.TaskListFactory.createTaskList;

public abstract class AbstractTaskList {
    //public AbstractTaskList(){}

    /**
     * This method adds the specified task to the list.
     * @param task the task that we want to add.
     */
    abstract void add(Task task);
    /**
     *  This method removes a task from the list and returns true, if such a task was in the list.
     *  If the list contains the same task several times, any of them should be removed.
     *  @param task the task that we want to remove.
     *  @return 'true' if the task was in the list.
     */
    abstract boolean remove(Task task);
    /**
     * This method returns the number of tasks in the list.
     * @return the length of the list.
     */
    abstract int size();
    /**
     *  This method returns a task which takes the specified place in the list.
     *  @param index the index of the task that we want to.
     *  @return the task.
     */
    abstract Task getTask(int index);
    /**
     *  This method returns a subset of tasks that are scheduled for execution
     *  at least once after the "from" time, and not later than the "to" time.
     *  @param from the start time of the period that we want to know.
     *  @param to the end time of the period that we want to know.
     *  @return the subset of tasks that are scheduled.
     */
    AbstractTaskList incoming(int from, int to, ListTypes.types type){
        AbstractTaskList incomingList= createTaskList(type);
        int timea;
        Task taskcheking;
        for (int x=0; x< size(); x++){
            taskcheking = getTask(x);
            timea = taskcheking.nextTimeAfter(from);
            if ((timea < to) && (timea != -1)){
                incomingList.add(taskcheking);

            }
        }
        return incomingList;
    }
}

