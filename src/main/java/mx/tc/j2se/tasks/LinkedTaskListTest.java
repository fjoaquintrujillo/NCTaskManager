package mx.tc.j2se.tasks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class LinkedTaskListTest {
    @Test

    public void addTest(){
        Task task0 = new TaskImpl("Cafe",10);
        Task task1 = new TaskImpl("Correr",5,15,2);
        Task task2 = new TaskImpl("Dormir",8);
        Task task3 = new TaskImpl("Despertar",20);
        Task task4 = new TaskImpl("Medicina",3,30,8);

        LinkedTaskList tasks = new LinkedTaskListImpl();
        tasks.add(task0);
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        assertEquals(task4,tasks.getTask(4));
        assertEquals(tasks.size(),5);
    }
    @Test
    public void removeTest(){
        LinkedTaskList tasks = new LinkedTaskListImpl();
        //ArrayTaskList tar = new ArrayTaskListImpl();
        //Task tareita = new TaskImpl();
        Task tareita2 = new TaskImpl();

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
        Task task11 = new TaskImpl("No encontrado", 5);

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

        System.out.println("Lista completa--------------------");
        for (int x=0; x<tasks.size();x++){
            Task tareita = tasks.getTask(x);
            System.out.println("Tarea: "+tareita.getTitle()+" "+tareita.getStartTime()+" "+tareita.getEndTime()+" "+tareita.getRepeatInterval());
        }
        assertEquals(11,tasks.size());

        assertEquals(false,tasks.remove(null));

        System.out.println("Lista borrada--------------------");
        for (int x=0; x<tasks.size();x++){
            Task tareita = tasks.getTask(x);
            System.out.println("Tarea: "+tareita.getTitle()+" "+tareita.getStartTime()+" "+tareita.getEndTime()+" "+tareita.getRepeatInterval());
        }
        //assertEquals(task6,tasks.getTask(5));
        assertEquals(11,tasks.size());

    }

    @Test
    public void incomingTest(){
        LinkedTaskList tasks = new LinkedTaskListImpl();
        LinkedTaskList alltasks = new LinkedTaskListImpl();
        LinkedTaskList tar = new LinkedTaskListImpl();

        Task task0 = new TaskImpl("Cafe",10);
        Task task1 = new TaskImpl("Correr",5,20,2);
        Task task2 = new TaskImpl("Dormir",3);
        Task task3 = new TaskImpl("Despertar",20);
        Task task4 = new TaskImpl("Medicina",5,20,2);

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
        tar = alltasks.incoming(8,12);
        for (int x=0; x<tar.size();x++){
            Task tarea = tar.getTask(x);
            System.out.println("Tarea: "+tarea.getTitle()+" "+tarea.getStartTime()+" "+tarea.getEndTime()+" "+tarea.getRepeatInterval());
        }
        System.out.println("Lista tasks-----------------------");
        for (int x=0; x<tasks.size();x++){
            Task a = tasks.getTask(x);
            System.out.println("Tarea: "+a.getTitle()+" "+a.getStartTime()+" "+a.getEndTime()+" "+a.getRepeatInterval());
        }
        //System.out.println(tasks.toString());
        assertEquals(tasks,tar);
    }
}
