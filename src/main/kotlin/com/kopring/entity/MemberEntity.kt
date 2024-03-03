package com.kopring.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class MemberEntity (
    val name: String,
){
    @Id
    @GeneratedValue
    var id: Long? = null

}