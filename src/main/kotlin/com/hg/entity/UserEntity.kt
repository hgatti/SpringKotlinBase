package com.hg.entity

import javax.persistence.*

@Entity
@Table(name = "USER")
class UserEntity(
    @Id @GeneratedValue @Column(name = "IDT_USER") var id: Long? = null,
    @Column(name = "NAM_NAME") var name: String
)