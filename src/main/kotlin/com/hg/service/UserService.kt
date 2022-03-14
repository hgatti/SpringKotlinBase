package com.hg.service

import com.hg.entity.UserEntity
import com.hg.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserService @Autowired constructor(
    val userRepository: UserRepository
) {

    fun findUser(id: Long): Optional<UserEntity> {
        return userRepository.findById(id)
    }

    fun createUser(userName: String): UserEntity {
        val userEntity = UserEntity(null, userName)
        return userRepository.save(userEntity)
    }

}