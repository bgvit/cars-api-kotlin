package br.com.carskotlin.resource

import br.com.carskotlin.entity.CarEntity
import br.com.carskotlin.service.CarService
import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity as ResponseEntity

@RestController
@RequestMapping("cars")
class CarResource (val carService : CarService)  {

    @PostMapping
    fun postCar(@RequestBody carEntity : CarEntity) : ResponseEntity<CarEntity> {
        val newCarEntity = carService.insert(carEntity)
        return ResponseEntity.ok(newCarEntity)
    }
    @PutMapping("/{id}")
    fun putCar (@PathVariable("id") id : Int,
                @RequestBody carEntity : CarEntity)
                : ResponseEntity<CarEntity> {
          carEntity.id = id
        val foundCarEntity : CarEntity
                foundCarEntity = carService.update(car : CarEntity, id : Int)
    }

    @GetMapping
    fun getCars() : ResponseEntity<List<CarEntity>> {
        return ResponseEntity.ok(carService.getCars())
    }

    @GetMapping
    fun getCar(id : Int) : ResponseEntity<CarEntity> {
        return ResponseEntity.ok(carService.getCar(id))
    }

    @DeleteMapping
    fun deleteCar(@PathVariable("id") id : Int) : ResponseEntity {
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }

}