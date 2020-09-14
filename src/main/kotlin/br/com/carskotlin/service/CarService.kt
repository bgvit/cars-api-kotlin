package br.com.carskotlin.service

import br.com.carskotlin.entity.CarEntity
import br.com.carskotlin.repository.CarRepository
import org.springframework.stereotype.Service

@Service
class CarService(val carRepository: CarRepository) {

    fun insert(carEntity : CarEntity)  : CarEntity {
        return carRepository.save(carEntity);
    }

    fun getCars(): List<CarEntity> {
        return carRepository.findAll();
    }

    fun getCar(id : Int) : CarEntity {
        return carRepository.getOne(1)
    }

    fun deleteCar(id : Int) {
        carRepository.deleteById(id)
    }
}