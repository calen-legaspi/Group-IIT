package com.orangeandbronze.ozmness

class Rating {
    Integer value
    Technology technology

    static constraints = {
        technology(blank: false)
        value(blank: false, min: 1, max: 3)
    }

    String toString() {
        "$rated $technology $value"
    }
}
