<%--
  Created by IntelliJ IDEA.
  User: darcusfenix
  Date: 2/1/16
  Time: 1:30 PM
--%>

<div class="row">
    <div class="table-scrollable table-scrollable-borderless">
        <table class="table table-hover table-light">
            <thead>
            <tr class="uppercase">
                <th class="bold font-green text-center"></th>
                <th class="bold font-green text-center" ng-repeat="duracion in duracionList">
                    {{duracion.duracion + (' Horas')}}
                </th>
                <th class="text-center bold font-green">Total</th>
            </tr>
            </thead>

            <tr ng-repeat="persona in personaList">
                <th class="font-blue text-uppercase  text-center">{{persona.nombre}}</th>
                <th class=" text-center" ng-repeat="duracion in duracionList">
                    {{ getTotalBetweenPersonaAndDuracion(persona.id, duracion.id) }}
                </th>
                <th class="text-center bold font-green">
                    {{ getTotalByPersona(persona.id) }}
                </th>
            </tr>

            <tr>
                <th class="font-blue text-uppercase  text-center">Total</th>
                <th class="bold font-green text-center" ng-repeat="duracion in duracionList">
                    {{ getTotalByDuracion(duracion.id) }}
                </th>
                <th class="text-center bold font-green">
                    {{ getTotalOfPulseras() }}
                </th>
            </tr>
        </table>
    </div>
</div>