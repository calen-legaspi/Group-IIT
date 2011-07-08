package com.orangeandbronze.ozmness

class Position {
    String name

    static mapping = {table 'positions'}

    static constraints = {
        name(blank: false)
    }

    String toString() {
        "$name"
    }
}
