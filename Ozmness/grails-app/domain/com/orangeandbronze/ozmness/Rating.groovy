package com.orangeandbronze.ozmness

class Rating {
    Integer value
    Technology technology

    static constraints = {
        technology(blank: false)
        value(range: 1..3)
    }

    String toString() {
        "$technology $value"
    }
}
