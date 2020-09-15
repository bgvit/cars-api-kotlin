package br.com.carskotlin.resource

import br.com.carskotlin.entity.CarEntity
import br.com.carskotlin.service.CarService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
                : ResponseEntity<Void> {
          carEntity.id = id

        val foundCarEntity : CarEntity = carService.updateCar(carEntity, id)
        return ResponseEntity.noContent().build<Void>()
    }

    @GetMapping
    fun getCars() : ResponseEntity<List<CarEntity>> {
        return ResponseEntity.ok(carService.getCars())
    }

    @GetMapping("/{id}")
    fun getCar(@PathVariable("id") id : Int) : ResponseEntity<CarEntity> {
        return ResponseEntity.ok(carService.getCar(id))
    }

    @DeleteMapping("/{id}" +
            "")
    fun deleteCar(@PathVariable("id") id : Int) : ResponseEntity<Void> {
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }

}