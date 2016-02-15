package mx.capitalbus.app

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import groovy.json.JsonSlurper
import mx.capitalbus.app.bracelet.Bracelet
@Secured('ROLE_SUPER_ADMIN')
class BraceletController {

    def braceletService

    def create (){
        render ( new Bracelet() as JSON)
    }

    def save (){
        String json = params.list("json");
        if (json != null) {
            def jsonSlurper = new JsonSlurper()
            def object = jsonSlurper.parseText(json)
            def map  = [:]
            for (String a : object) {
                def cc = JSON.parse(a)
                Integer ic = cc.idCost
                Integer ca = cc.amount
                map.put(ic,ca)
            }
            def mapCVS =  braceletService.generatingBracelets(map);
            render( [text : mapCVS + ""] as JSON )
        }else {
            response.status = 404
            render([message: message(code: "vendedor.notFound")] as JSON)
        }
    }
}
