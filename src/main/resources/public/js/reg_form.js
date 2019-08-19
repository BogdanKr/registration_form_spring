angular.module("registration_form",[])
    .controller("AppCtrl", function ($scope, $http) {
        $scope.auth = {};
        let resultMessageEl = document.getElementById('resultMessage');
        let exampleInputFirstNameEl = document.getElementById('exampleInputFirstName');
        let exampleInputLastNameEl = document.getElementById('exampleInputLastName');
        let inputFirstNameLabel = document.getElementById('inputFirstNameLabel');
        let inputLastNameLabel = document.getElementById('inputLastNameLabel');
        let emailEl = document.getElementById('exampleInputEmail1');
        let passwordEl = document.getElementById('exampleInputPassword1');
        exampleInputFirstNameEl.addEventListener('input', function()  {
            inputFirstNameLabel.style.color = 'black';
        inputLastNameLabel.style.color = 'black';
        $scope.message = '';
    });
        $scope.sendForm = function(auth){
            $http({
                method: "POST",
                url: "/api/reg_form",
                data: $.param(auth),
                headers: { "Content-Type" : "application/x-www-form-urlencoded" }
            }).then(
                function(data) {
                resultMessageEl.style.color = 'green';
            $scope.message = 'Успешно зарегистрирован';
            exampleInputFirstNameEl.value = 'КТО МОЛОДЕЦ????';
            exampleInputLastNameEl.value = 'ТЫ МОЛОДЕЦ!!!!!';
        },
           function (error) {
                resultMessageEl.style.color = 'red';
                inputFirstNameLabel.style.color = 'red';
                inputLastNameLabel.style.color = 'red';
                emailEl.value = '';
                passwordEl.value = '';
                $scope.message = 'При регистрации произошла ошибка';
            }
        );
        }
    });