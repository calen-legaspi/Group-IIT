package com.orangeandbronze.ozmness

class Technology {
    Technology parent
    String name

    static constraints = {
        parent()
        name(blank: false)
    }

    String toString() {
        "$name"
    }
}
