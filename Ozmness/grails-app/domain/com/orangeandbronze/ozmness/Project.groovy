package com.orangeandbronze.ozmness

class Project {
    String name
    Employee lead

    static hasMany = [technologies:Technology]

    static constraints = {
        name(blank: false)
        lead()
    }

    String toString() {
        "$name"
    }
}
