package com.hg.domain

import com.fasterxml.jackson.annotation.JsonProperty

class User(
    @JsonProperty(value = "name") var name: String
) {
}