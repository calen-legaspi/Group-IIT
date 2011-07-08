package com.orangeandbronze.ozmness

class Project {
    String name
    Employee lead

    static hasMany = [technologies:Technology]

    static constraints = {
        name(blank: false)
        lead(nullable: true)
    }

    String toString() {
        "$name"
    }
}
