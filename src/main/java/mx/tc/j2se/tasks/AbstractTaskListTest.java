package mx.tc.j2se.tasks;
import org.junit.jupiter.api.Test;

import static mx.tc.j2se.tasks.TaskListFactory.createTaskList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractTaskListTest {
    @Test

    public void addTest(){
        Task task = new TaskImpl("Cafe",10);
        Task task1 = new TaskImpl("Correr",5,15,2);

        AbstractTaskList tasks = createTaskList(ListTypes.types.ARRAY);
        tasks.add(task);
        tasks.add(task1);
        assertEquals(task1,tasks.getTask(1));
        assertEquals(tasks.size(),2);

        AbstractTaskList tasks2 = createTaskList(ListTypes.types.LINKED);
        tasks2.add(task);
        tasks2.add(task1);
        assertEquals(task1,tasks2.getTask(1));
        assertEquals(tasks2.size(),2);
    }
    @Test
    public void removeTest(){
        AbstractTaskList tasks = createTaskList(ListTypes.types.ARRAY);

        Task task0 = new TaskImpl("Cafe",10);
        Task task1 = new TaskImpl("Correr",5,15,2);
        Task task2 = new TaskImpl("Dormir",8);
        Task task3 = new TaskImpl("Despertar",20);
        Task task4 = new TaskImpl("Medicina",3,30,8);
        Task task5 = new TaskImpl("Estudiar",25);
        Task task6 = new TaskImpl("Leer",30);
        Task task7 = new TaskImpl("Jugar",2);
        Task task8 = new TaskImpl("Pasear",45);
        Task task9 = new TaskImpl("Lavar",7);
        Task task10 = new TaskImpl("Trabajar",12);

        tasks.add(task0);
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);
        tasks.add(task7);
        tasks.add(task8);
        tasks.add(task9);
        tasks.add(task10);


        assertEquals(true,tasks.remove(task10));
        assertEquals(tasks.size(),10);
        assertEquals(task9,tasks.getTask(9));

        AbstractTaskList tasks2 = createTaskList(ListTypes.types.LINKED);
        tasks2.add(task0);
        tasks2.add(task1);
        tasks2.add(task2);
        tasks2.add(task3);
        tasks2.add(task4);
        tasks2.add(task5);
        tasks2.add(task6);
        tasks2.add(task7);
        tasks2.add(task8);
        tasks2.add(task9);
        tasks2.add(task10);
        assertEquals(true,tasks2.remove(task5));
        assertEquals(true,tasks2.remove(task2));
        assertEquals(tasks2.size(),9);
        assertEquals(task10,tasks2.getTask(8));
    }

    @Test
    public void incomingTest(){
        AbstractTaskList tasks = createTaskList(ListTypes.types.ARRAY);
        AbstractTaskList alltasks = createTaskList(ListTypes.types.ARRAY);
        AbstractTaskList tar = createTaskList(ListTypes.types.ARRAY);

        Task task0 = new TaskImpl("Cafe",10);
        Task task1 = new TaskImpl("Correr",5,20,2);
        Task task2 = new TaskImpl("Dormir",8);
        Task task3 = new TaskImpl("Despertar",20);
        Task task4 = new TaskImpl("Medicina",3,30,7);

        task0.setActive(true);
        task1.setActive(true);
        task2.setActive(true);
        task3.setActive(true);
        task4.setActive(true);

        alltasks.add(task0);
        alltasks.add(task1);
        alltasks.add(task2);
        alltasks.add(task3);
        alltasks.add(task4);

        tasks.add(task0);
        tasks.add(task1);
        tasks.add(task4);

        System.out.println("Lista completa--------------------");
        for (int x=0; x<alltasks.size();x++){
            Task tareita = alltasks.getTask(x);
            System.out.println("Tarea: "+tareita.getTitle()+" "+tareita.getStartTime()+" "+tareita.getEndTime()+" "+tareita.getRepeatInterval());
        }
        System.out.println("Lista incoming------------------");
        tar = alltasks.incoming(8,12, ListTypes.types.ARRAY);
        for (int x=0; x<tar.size();x++){
            Task tarea = tar.getTask(x);
            System.out.println("Tarea: "+tarea.getTitle()+" "+tarea.getStartTime()+" "+tarea.getEndTime()+" "+tarea.getRepeatInterval());
        }
        System.out.println("Lista tasks-----------------------");
        for (int x=0; x<tasks.size();x++){
            Task a = tasks.getTask(x);
            System.out.println("Tarea: "+a.getTitle()+" "+a.getStartTime()+" "+a.getEndTime()+" "+a.getRepeatInterval());
        }
        //assertEquals(tasks,tar);

        AbstractTaskList tasks2 = createTaskList(ListTypes.types.LINKED);
        AbstractTaskList alltasks2 = createTaskList(ListTypes.types.LINKED);
        AbstractTaskList tar2 = createTaskList(ListTypes.types.LINKED);

        alltasks2.add(task0);
        alltasks2.add(task1);
        alltasks2.add(task2);
        alltasks2.add(task3);
        alltasks2.add(task4);

        tasks2.add(task0);
        tasks2.add(task1);
        tasks2.add(task4);

        System.out.println("Lista2 completa--------------------");
        for (int x=0; x<alltasks2.size();x++){
            Task tareita = alltasks2.getTask(x);
            System.out.println("Tarea: "+tareita.getTitle()+" "+tareita.getStartTime()+" "+tareita.getEndTime()+" "+tareita.getRepeatInterval());
        }
        System.out.println("Lista2 incoming------------------");
        tar2 = alltasks2.incoming(8,12, ListTypes.types.LINKED);
        for (int x=0; x<tar2.size();x++){
            Task tarea = tar2.getTask(x);
            System.out.println("Tarea: "+tarea.getTitle()+" "+tarea.getStartTime()+" "+tarea.getEndTime()+" "+tarea.getRepeatInterval());
        }
        System.out.println("Lista2 tasks-----------------------");
        for (int x=0; x<tasks2.size();x++){
            Task a = tasks2.getTask(x);
            System.out.println("Tarea: "+a.getTitle()+" "+a.getStartTime()+" "+a.getEndTime()+" "+a.getRepeatInterval());
        }
        //assertEquals(tar,tar2);
    }
}
