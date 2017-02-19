(function () {
    'use strict'

    angular
        .module('api', ['ngResource'])
        .factory('apiService', apiService)
        .controller('getBands', getBands);

    apiService.$inject = ['$resource'];
    function apiService($resource) {
        return $resource('http://localhost:8080/metodo', { id: '@id' }, {
            get: { method: 'GET', isArray: false },
            texto: { method: 'GET', url: 'http://localhost:8080/metodo' ,isArray: false },
            update: { method: 'PUT' }
        })
    }

    getBands.$inject = ['apiService'];
    function getBands(apiService) {
        var vm = this;

        apiService.texto(function(data){
            vm.valor = data;
        },function(erro){
            alert(erro);
        });



    }

})();
