package br.com.carskotlin.service

import br.com.carskotlin.entity.CarEntity
import br.com.carskotlin.repository.CarRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
//TODO: implements exceptionHandler in all cases
class CarService(val carRepository: CarRepository) {

    fun insert(carEntity : CarEntity)  : CarEntity {
        return carRepository.save(carEntity);
    }

    fun getCars(): List<CarEntity> {
        return carRepository.findAll();
    }

    fun getCar(id : Int) : CarEntity {
        return carRepository.getOne(id)
    }

    fun deleteCar(id : Int) {
        carRepository.deleteById(id)
    }

    fun updateCar(carEntity: CarEntity, id: Int) : CarEntity {
        var carEntityOptional : Optional<CarEntity> = carRepository.findById(id)
        var carEntityToBeUpdated : CarEntity = carEntityOptional.get()
        fillCarroEntityToBeUpdated(carEntityToBeUpdated,carEntity)
        carRepository.save(carEntityToBeUpdated)
        return carEntityToBeUpdated
    }

    fun fillCarroEntityToBeUpdated(carEntityToBeUpdated: CarEntity, carEntity: CarEntity) {
        // Copiar as propriedades - poucos elementos somente para teste
        carEntityToBeUpdated.name = carEntity.name

    }
}