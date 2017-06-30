package io.egensolutions.repository;

import io.egensolutions.entities.vehicle.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImplementation implements VehicleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findAllVehicles() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAllVehicles", Vehicle.class);
        return query.getResultList();
    }

    public Vehicle findOneVehicle(String vin) {
        return entityManager.find(Vehicle.class,vin);
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;
    }

    public Vehicle findByModel(String model) {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findByModel", Vehicle.class);
        query.setParameter("modelParameter", model);
        List<Vehicle> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }
    public Vehicle updateVehicle(Vehicle vehicle) {
        return entityManager.merge(vehicle);
    }

    public void deleteVehicle(String vin) {
        entityManager.remove(entityManager.find(Vehicle.class,vin));
    }
}
