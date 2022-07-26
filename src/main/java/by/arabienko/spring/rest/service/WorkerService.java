package by.arabienko.spring.rest.service;

import by.arabienko.spring.rest.entity.Worker;

import java.util.List;

public interface WorkerService {

    public List<Worker> getAllWorkers();
    public void saveWorker(Worker worker);
    public Worker getWorker(int id);
    public void deleteWorker(int id);
}
