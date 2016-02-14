package mx.capitalbus

import grails.transaction.Transactional
import mx.capitalbus.app.bracelet.Bracelet
import mx.capitalbus.app.bracelet.BraceletState
import mx.capitalbus.app.bracelet.CostBracelet

@Transactional
class BraceletService {

    def sessionFactory
    def grailsApplication

    def generatingBracelets(Map objeto) {

        def map = "ID,CODIGO,TIPO,FECHA_CREACION\n";
        BraceletState bs = BraceletState.findById(2)
        def dateNow = new Date()

        objeto.each { w ->
            def sp = getLastAutoIncrementBracelet();
            log.debug(sp)
            /*
            for(int i = sp; i< sp + w.value; i++ ){
                int idCod = i * 3;
                def codeEncrypted = encodeId (idCod)
                Bracelet bracelet = new Bracelet()
                bracelet.code = codeEncrypted
                bracelet.braceletState = bs
                bracelet.costBracelet = CostBracelet.findById(w.key)
                bracelet.creationDate = dateNow

                if (bracelet.validate()) {
                    bracelet.save(flush: true)
                    if (bracelet.id != null){
                        map += bracelet.id +","+bracelet.code.toLowerCase().trim() + "," + bracelet.costBracelet.id + "," + bracelet.creationDate  + "\n"
                    }
                }
            }
            */
        }

        map

    }

    private String encodeId(int id) {
        id.encodeAsMD5().encodeAsSHA1().substring(0, 10)
    }

    private String getDatabaseSchema() {
        def dsUrl = grailsApplication.getProperties()
        String dbName = dsUrl.get('flatConfig').get('dataSource.url')
        dbName.substring(dbName.lastIndexOf("/") + 1)
    }

    private Integer getLastAutoIncrementBracelet() {
        def session = sessionFactory.currentSession
        def String query = 'SELECT AUTO_INCREMENT FROM information_schema.tables ' +
                'WHERE table_name=\'ct_pulcera\' AND table_schema=\'' + getDatabaseSchema() + '\';'
        def sqlQuery = session.createSQLQuery(query)
        (Integer) sqlQuery.uniqueResult()

    }
}