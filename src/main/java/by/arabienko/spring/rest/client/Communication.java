package by.arabienko.spring.rest.client;

import by.arabienko.spring.rest.client.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    private final static String URL = "http://localhost:8080/REST/api/workers";
    private Worker worker;


    public List<Worker> getAllWorkers() {

        ResponseEntity<List<Worker>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET,
                        null, new  ParameterizedTypeReference<List<Worker>>(){});
    return responseEntity.getBody();
    }

    public Worker getWorkerById(int id) {

        return restTemplate.getForObject(URL+"/"+id, Worker.class);
    }

    public void updateSaveWorkerById(Worker worker){

        if (worker.getId()==0){
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, worker, String.class);
            System.out.println("The worker was added to DB.");
            System.out.println(responseEntity.getBody());
        }else {
            restTemplate.put(URL, worker);
            System.out.println("The worker with ID = "+ worker.getId()
                    +" was updated to DB.");
        }
    }

    public void deleteWorker(int id){

        restTemplate.delete(URL+"/"+id);
        System.out.println("The worker with ID = "+id
                +" was deleted from DB.");
    }
}


