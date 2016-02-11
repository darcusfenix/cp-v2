/**
 * Created by becm on 2/10/16.
 */

function BraceleteGenerateController($rootScope,
                                     $scope,
                                     $http,
                                     $timeout,
                                     $stateParams,
                                     Salesman,
                                     Circuit,
                                     KindPerson,
                                     DaysDuration){

    $scope.$on('$viewContentLoaded', function () {
        App.initAjax();
        $scope.getCircuits();
    });


    $scope.getCircuits = function(){

        App.blockUI(
            {
                target: "#generate-bracelet",
                boxed: !0,
                message: "Cargando..."
            });

        Circuit.query(function (data) {

            $scope.circuitList = data;

            $scope.getKindPerson();

        }, function(err){
            console.log(err)
        });
    };
    $scope.getKindPerson = function(){
        KindPerson.query(function (data) {

            $scope.kindPersontList = data;

            $scope.getDaysDuration();

        }, function(err){
            console.log(err)
        });
    };
    $scope.getDaysDuration = function(){
        DaysDuration.query(function (data) {

            $scope.daysDurationList = data;

            App.unblockUI("#generate-bracelet");
        }, function(err){
            console.log(err)
        });
    };

};