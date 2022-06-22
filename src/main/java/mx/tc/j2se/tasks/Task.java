package mx.tc.j2se.tasks;

public interface Task {
    /**
     * This method is for reading the task name
     * @return  the task name.
     */
    String getTitle();
    /**
     * This method is for setting the task name
     * @param title the task name.
     */
    void setTitle(String title);
    /**
     * This method is for reading the task status
     * @return true if the task is active.
     */
    boolean isActive();
    /**
     * This method is for setting the task status
     * @param active  true for active and false for inactive tasks.
     */
    void setActive(boolean active);
    /**
     * This method is for get the time of execution of a non-repetitive task.
     * If the task is a repetitive one, return the start time of the repetition
     * @return the time of execution.
     */
    int getTime();
    /**
     * This method is for set time of a non-repetitive task.
     * If the task was a repetitive it should become non-repetitive
     *  @param time the time of execution.
     */
    void setTime(int time);
    /**
     * This method is for get the start time of a repetitive task.
     * If the task is a non-repetitive one, return the time of execution
     * @return the star time.
     */
    int getStartTime();
    /**
     * This method is for get the end time of a repetitive task.
     * If the task is a non-repetitive one, return the time of execution
     * @return the end time.
     */
    int getEndTime();
    /**
     * This method is for get the interval time of a repetitive task.
     * If the task is a non-repetitive one, return 0
     * @return the repetitive interval
     */
    int getRepeatInterval();
    /**
     * This method is for set time of a repetitive task.
     * If the task is a non-repetitive one, it should become repetitive
     *  @param start the start time.
     *  @param end the end time.
     *  @param interval the interval time.
     */
    void setTime(int start, int end, int interval);
    /**
     * This method is for checking the task repeatability
     * @return the boolean variable "repeated".
     */
    boolean isRepeated();
    /**
     * This method is for checking the next task execution.
     * @param current the current time.
     * @return the next task.
     */
    int nextTimeAfter(int current);

}