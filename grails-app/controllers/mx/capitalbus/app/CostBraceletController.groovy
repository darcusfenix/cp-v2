package mx.capitalbus.app

import grails.converters.JSON
import mx.capitalbus.app.bracelet.CostBracelet
import mx.capitalbus.app.circuit.Circuit

class CostBraceletController {

    def costBraceletByCircuit() {
        def a = CostBracelet.createCriteria()
        def results = a.list {
            eq("circuit", Circuit.findById(params.int('id')))
        }
        if (results != null) {
            def pd = results.personDuration

            render(pd as JSON)
        }
    }
}
