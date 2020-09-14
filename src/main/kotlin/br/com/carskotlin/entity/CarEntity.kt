package br.com.carskotlin.entity

import javax.persistence.*

@Entity
data class CarEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    @Column(nullable = false)
    val name: String


)
{

}