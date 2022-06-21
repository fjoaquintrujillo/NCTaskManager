package mx.tc.j2se.tasks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class TaskTest {
    @Test

    public void titleTest(){
        Task task = new TaskImpl();
        task.setTitle("El titulo");
        assertEquals("El titulo", task.getTitle());
    }

    @Test
    public void activeTest(){
        Task task = new TaskImpl();
        task.setActive(true);
        assertEquals(true, task.isActive());
    }

    @Test
    public void getTimeTest(){
        Task task = new TaskImpl();
        task.setTime(10);
        assertEquals(10, task.getTime());
    }

    @Test
    public void getTimeTest2(){
        Task task = new TaskImpl("El titulo",10, 30,5);
        task.setTime(15);
        assertEquals(false, task.isRepeated());
    }

    //Test nextTimeAfter
    @Test
    public void nextTimeAfterTest(){
        Task task = new TaskImpl("El titulo",10,50,10);
        //Task task = new TaskImpl("El titulo",25);
        task.setActive(true);
        assertEquals(40, task.nextTimeAfter(30));
    }





}
