package mx.capitalbus.app

import grails.converters.JSON
import mx.capitalbus.app.bracelet.CostBracelet
import mx.capitalbus.app.circuit.Circuit

class CostBraceletController {

    def costBraceletByCircuit() {
        def r  = CostBracelet.findAllByCircuit(Circuit.findById(params.int('id')))
        render ([r] as JSON)
    }
}
