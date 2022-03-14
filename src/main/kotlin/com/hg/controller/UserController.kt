package com.hg.controller

import com.hg.domain.User
import com.hg.entity.UserEntity
import com.hg.service.UserService
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional


@RestController
class UserController @Autowired constructor(
    val userService: UserService
) {

    @ApiResponses(
        ApiResponse(code = 200, message = "Retorna o usuario"),
        ApiResponse(code = 400, message = "Usuario não encontrado")
    )
    @GetMapping("users/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<UserEntity> {
        val userEntity: Optional<UserEntity> = userService.findUser(id)
        return if (userEntity.isPresent) {
            ResponseEntity(userEntity.get(), HttpStatus.OK)
        } else {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping(
        path = ["users"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun create(@RequestBody user: User): ResponseEntity<UserEntity> {
        val user: UserEntity = userService.createUser(user.name)
        return ResponseEntity(user, HttpStatus.CREATED)
    }
}