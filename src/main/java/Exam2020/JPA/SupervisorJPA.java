package Exam2020.JPA;

import Exam2020.Models.Student;
import Exam2020.Models.Supervisor;
import Exam2020.Repos.SupervisorRepo;
import Exam2020.Services.SupervisorService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupervisorJPA implements SupervisorService {
    private List<Supervisor> supervisors;

    private final SupervisorRepo supervisorRepo;

    public SupervisorJPA(SupervisorRepo supervisorRepo) {
        this.supervisorRepo = supervisorRepo;
    }

    // Init some supervisors for testing
    @PostConstruct
    private void iniDataForTesting() {

        supervisors = new ArrayList<Supervisor>();
        Supervisor supervisor1 = new Supervisor("Jon", "Jone@kea.dk");  //TODO Find supervisor
        supervisors.add(supervisor1);
    }

    /**
     *
     * @return List of all supervisors
     */
    @Override
    public List<Supervisor> findAll() {
        List<Supervisor> result = new ArrayList<>();
        supervisorRepo.findAll().forEach(result::add); //adds iterable to list
        return result;
    }

    /**
     * @param name of supervisor
     * @return List of all where getName.ignorecase returns true
     */
    @Override
    public List<Supervisor> findByName(String name) {
        List<Supervisor> result = supervisors.stream()
                .filter(x -> x.getName().equalsIgnoreCase(name))    //Java 8 lambda art
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public Supervisor save(Supervisor object) {
        return supervisorRepo.save(object);
    }

    @Override
    public void delete(Supervisor object) {
        supervisorRepo.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        supervisorRepo.deleteById(aLong);
    }

    @Override
    public Optional<Supervisor> findById(Long aLong) {
        return Optional.empty();
    }
}
