package by.arabienko.spring.rest.dao.impl;

import by.arabienko.spring.rest.dao.WorkersDAO;
import by.arabienko.spring.rest.entity.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkerDAOImpl implements WorkersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Worker> getAllWorkers() {

        Session session = sessionFactory.getCurrentSession();
        //        Query workerQuery = session.createQuery("from workers", Worker.class);
//        List<Worker> workerList = workerQuery.getResultList();
        return session.createQuery("from Worker ", Worker.class)
                .getResultList();
    }

    @Override
    public void saveWorker(Worker worker) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(worker);
    }

    @Override
    public Worker getWorker(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Worker.class, id);
    }

    @Override
    public void deleteWorker(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query workerQuery;
        workerQuery = session.createQuery("delete from Worker " +
                "where id = :workerID").setParameter("workerID", id);
        workerQuery.executeUpdate();
//        session.remove(session.get(Worker.class, id));
    }
}
