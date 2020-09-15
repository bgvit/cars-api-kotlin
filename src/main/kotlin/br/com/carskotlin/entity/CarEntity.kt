package br.com.carskotlin.entity

import javax.persistence.*

@Entity(name="car")
data class CarEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @Column(nullable = false)
    var name: String


)
{

}