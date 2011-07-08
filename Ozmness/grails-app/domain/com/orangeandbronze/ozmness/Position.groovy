package com.orangeandbronze.ozmness

class Position {
    String name

    static hasMany = [ratings:Rating]
    static mapping = {table 'positions'}

    static constraints = {
        name(blank: false)
    }

    String toString() {
        "$name"
    }
}
