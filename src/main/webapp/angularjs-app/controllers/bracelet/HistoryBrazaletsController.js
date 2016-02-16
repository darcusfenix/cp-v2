/**
 * Created by darcusfenix on 2/15/16.
 */

/**
 * Created by becm on 2/10/16.
 */

function HistoryBrazaletsController($rootScope,
                                     $scope,
                                     $http,
                                     $timeout,
                                     $stateParams,
                                     Bracelet) {

    $scope.historyList = [];

    $scope.$on('$viewContentLoaded', function () {
        App.initAjax();

    });

    $scope.breceletInstance  = Bracelet.create(function (data) {
        $scope.breceletInstance = data;
    });

    $scope.getCircuits = function () {

        App.blockUI(
            {
                target: "#p-b-history-bracelets",
                boxed: !0,
                message: "Cargando..."
            });

        Bracelet.query(function (data) {
            $scope.historyList = data;

        }, function (err) {
            console.log(err)
        });
    };

    $scope.getDaysDuration = function () {
        DaysDuration.query(function (data) {
            $scope.daysDurationList = data;
            App.unblockUI("#p-b-history-bracelets");
            $scope.updateCostOnView();
            $scope.preparingListOfBracelets();
        }, function (err) {
            console.log(err)
        });
    };



}