package br.com.carskotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarsKotlinApplication

fun main(args: Array<String>) {
	runApplication<CarsKotlinApplication>(*args)
}
