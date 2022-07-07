package mx.tc.j2se.tasks;

public class LinkedTaskListImpl implements LinkedTaskList{
    //Linked nodes
    //Empty constructor
    public LinkedTaskListImpl(){};
    Task value;
    LinkedTaskListImpl next;
    LinkedTaskListImpl head;
    int size;


    public LinkedTaskListImpl(Task value){
        this.value = value;
        this.next = null;
    }
    public Task getValue(){
        return value;
    }
    public void linkNext(LinkedTaskListImpl n){
        next = n;
    }
    public LinkedTaskListImpl getNext(){
        return next;
    }
    public void linkedList(){
        head = null;
        size = 0;
    }

    @Override
    public void add(Task task) {
        try {
            if(task != null){
                if (head == null) {
                    head = new LinkedTaskListImpl(task);
                } else {
                    LinkedTaskListImpl temp = head;
                    LinkedTaskListImpl nlink = new LinkedTaskListImpl(task);
                    nlink.linkNext(temp);
                    head = nlink;
                }
                size++;
            } else {
                throw new Exception("Task is null!");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }



    }

    @Override
    public boolean remove(Task task) {
        boolean b = false;
        try {
            if(task != null){
                int index = -1;

                LinkedTaskListImpl tempo = head;
                for (int a = 0; a < size; a++){
                    if (tempo.getValue() == task){
                        index = a;
                        b = true;
                    }
                    tempo = tempo.getNext();
                }
                if (index == -1){
                    b = false;
                    size++;
                }
                else if (index == 0){
                    head = head.getNext();
                } else {
                    int counter = 0;
                    LinkedTaskListImpl temporal = head;
                    while (counter < index-1){
                        temporal = temporal.getNext();
                        counter++;
                    }
                    temporal.linkNext(temporal.getNext().getNext());

                }
                size--;
            }else {
                throw new Exception("Task is null!");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return b;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Task getTask(int index) {
        int counter = 0;
        LinkedTaskListImpl temporal = head;
        try {
            if (index >= 0 && index < size) {
                while (counter < size - index - 1) {
                    temporal = temporal.getNext();
                    counter++;
                }
            } else {
                throw new Exception(" Index outside the boundaries!");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return temporal.getValue();
    }

    @Override
    public LinkedTaskList incoming(int from, int to) {
        LinkedTaskList incomingList = new LinkedTaskListImpl();
        LinkedTaskList incomingList2 = new LinkedTaskListImpl();
        LinkedTaskListImpl tempo = head;
        int timea;
        Task taskcheking;
        try {
            if (from < 1) {
                throw new Exception("'From' can´t be less than 1");
            } else if (to < 1) {
                throw new Exception("'To' can´t be less than 1");
            } else if (from > to) {
                throw new Exception("'From' can´t be bigger than 'To'");
            } else {
                if (from >= 0 && from < to) {
                    for (int x = 0; x < size; x++) {
                        taskcheking = tempo.getValue();
                        timea = taskcheking.nextTimeAfter(from);
                        if ((timea < to) && (timea != -1)) {
                            incomingList.add(taskcheking);

                        }
                        tempo = tempo.getNext();
                    }
                    for (int y = 0; y < incomingList.size(); y++) {
                        incomingList2.add(incomingList.getTask(incomingList.size() - y - 1));
                    }
                }

            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return incomingList2;
    }

    private class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }
}