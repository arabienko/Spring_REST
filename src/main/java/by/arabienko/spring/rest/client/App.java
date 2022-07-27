package by.arabienko.spring.rest.client;

import by.arabienko.spring.rest.client.confoguration.MyConfig;
import by.arabienko.spring.rest.client.entity.Worker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = applicationContext.getBean("communication", Communication.class);
//        List<Worker> workerList = communication.getAllWorkers();
//        System.out.println(workerList);

//        System.out.println(communication.getWorkerById(5));

       Worker worker = new Worker("Inga", "Vorobey", "HR", 5000);
//        worker.setId(18);
    communication.updateSaveWorkerById(worker);

//        communication.deleteWorker(18);
    }
}
