/**
 * Created by grupo-becm on 1/25/16.
 */

angular.module('CapitalBusApp').factory('Pulsera', function ($resource) {
    return $resource('pulsera/:id', {id: '@id'}, {
        get: {
            method: 'GET',
            url: 'pulsera/show/:id'
        },
        update: {
            method: 'PUT',
            url: 'pulsera/update/'
        },
        delete: {
            method: 'DELETE',
            url: 'pulsera/delete/:id'
        },
        create: {
            method: 'GET',
            url: 'pulsera/create/'
        },
        save: {
            method: 'POST',
            url: 'pulsera/save'
        }
    });
});