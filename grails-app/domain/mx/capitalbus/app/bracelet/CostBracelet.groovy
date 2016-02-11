package mx.capitalbus.app.bracelet

import mx.capitalbus.app.circuit.Circuit

class CostBracelet {

    float cost
    PersonDuration personDuration
    Circuit circuit

    static constraints = {
    }

    static mapping = {
        id generator: 'identity'
    }
}
