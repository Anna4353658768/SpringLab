package repository;

import org.springframework.data.repository.CrudRepository;

import entity.Manufacturer;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long>{

}
