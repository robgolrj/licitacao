(function () {
    'use strict'

    angular
        .module('api', ['ngResource', 'ui.grid', 'ui.grid.selection', 'ngRoute'])
        .factory('apiService', apiService)
        .controller('cadastroController', cadastroController)
        .controller('licitacaoController', licitacaoController)
        .controller('lancesController', lancesController);

    apiService.$inject = ['$resource'];
    function apiService($resource) {
        var service = $resource('http://localhost:8080/metodo', { id: '@id' }, {
            get: { method: 'GET', isArray: false },
            texto: { method: 'GET', url: 'http://localhost:8080/licitacao/metodo' ,isArray: false },
            listarTodos: { method: 'GET', url: 'http://localhost:8080/licitacao/listarTodos' ,isArray: true},
            incluir: { method: 'POST', url: 'http://localhost:8080/licitacao/incluir' ,isArray: false},
            listarAbertas: { method: 'GET', url: 'http://localhost:8080/licitacao/listarAbertas' ,isArray: true},
            listOfertas: { method: 'GET', url: 'http://localhost:8080/licitacao/recuperarOfertas' ,isArray: true},
            update: { method: 'PUT' }
        })


        return service
    }

    cadastroController.$inject = ['apiService'];
    function cadastroController(apiService) {
        var vm = this;

        vm.licitacao = {};
        vm.licitacao.dataLimite = new Date();
        vm.licitacao.dataLimite = null;

        apiService.texto(function(data){
        vm.valor = data;
        },function(erro){
            alert(erro);
        });

        vm.gridOptions = {
            data : 'vm.licitacaoList',
            columnDefs: [
                { name: 'descricao'},
                { name: 'valorBase', cellFilter: 'currency' },
                { name: 'valorIncremento',  cellFilter: 'currency' },
                { name: 'dataLimite', cellFilter: 'date:"dd-MM-yyyy HH:MM"' },
                { name: 'status'}
            ]
        };

        var listarTodos = function() {
            apiService.listarTodos(function (data) {
                vm.licitacaoList = data;
            }, function (erro) {
                alert(erro);
            });
        }

        vm.incluir = function(){
            apiService.incluir(vm.licitacao, function(){
                listarTodos();
                vm.licitacao = {};
            });
        }

        listarTodos();

    }

    licitacaoController.$inject = ['apiService',  '$scope', '$rootScope'];
    function licitacaoController(apiService, $scope, $rootScope) {
        var vm = this;

        vm.gridOptions = {
            data : 'vm.licitacaoAbertasList',
            multiSelect: false,
            columnDefs: [
                { name: 'descricao'},
                { name: 'valorBase', cellFilter: 'currency' },
                { name: 'dataLimite', cellFilter: 'date:"dd-MM-yyyy HH:MM"' }
            ]
        };

        var listarAbertas = function() {
            apiService.listarAbertas(function (data) {
                vm.licitacaoAbertasList = data;
            });
        }

        vm.gridOptions.onRegisterApi = function(gridApi){
            $scope.gridApi = gridApi;
            gridApi.selection.on.rowSelectionChanged($scope,function(row){
                $rootScope.licitacao = row.entity.descricao;
            });
        };

        listarAbertas();
    }

    lancesController.$inject = ['apiService',  '$rootScope'];
    function lancesController(apiService, $rootScope) {
        var vm = this;

        vm.gridOptions = {
            data : 'vm.ofertasList'
        };

        vm.ofertar = function(){
            $rootScope.licitacao;
        }

        var listOfertas = function() {
            apiService.listOfertas(null,    function (data) {
                vm.ofertasList = data;
            });
        }

        listOfertas();

    }


})();
