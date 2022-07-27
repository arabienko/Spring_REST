package by.arabienko.spring.rest.сontroller;

import by.arabienko.spring.rest.entity.Worker;
import by.arabienko.spring.rest.exception_handling.NoSuchWorkerException;
import by.arabienko.spring.rest.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private WorkerService service;

    @GetMapping("/workers")
    public List<Worker> showAllWorker() {

        return service.getAllWorkers();
    }

    @GetMapping("/workers/{id}")
    public Worker showWorkerById(@PathVariable int id) {

        Worker worker = service.getWorker(id);
        if (worker==null) {
            throw new NoSuchWorkerException("There is no such worker with ID = "
                    + id + " in DataBase.");
        }
        return service.getWorker(id);
    }

    @PostMapping("/workers")
    public Worker addNewWorker(@RequestBody Worker worker) {
        service.saveWorker(worker);
        return worker;
    }

    @PutMapping("/workers")
    public Worker returnUpdateWorker(@RequestBody Worker worker){
        service.saveWorker(worker);
        return worker;
    }

    @DeleteMapping("/workers/{id}")
    public String deleteWorkerById(@PathVariable int id){
        Worker worker = service.getWorker(id);
        if (worker==null){
            throw new NoSuchWorkerException("There is no such worker with ID = "
                    + id + " in DataBase.");
        }
        service.deleteWorker(id);
        return"Worker with ID = "
                + id + " was deleted from DataBase.";
    }
}
