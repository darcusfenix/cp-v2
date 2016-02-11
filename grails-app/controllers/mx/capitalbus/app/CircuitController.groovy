package mx.capitalbus.app

import grails.converters.JSON
import mx.capitalbus.app.circuit.Circuit

class CircuitController {

    def index() {
        render (Circuit.findAllByEnabled(true) as JSON)
    }
}
