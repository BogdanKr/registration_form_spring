angular.module("login_form",[])
    .controller("LogCtrl", function ($scope, $http) {

        $scope.auth = {};
        let resultMessageEl = document.getElementById('resultMessage');
        let exampleInputEmailEl = document.getElementById('exampleInputEmail1');
        let exampleInputPasswordEl = document.getElementById('exampleInputPassword1');
        let exampleInputEmailLabel = document.getElementById('exampleInputEmailLabel');
        let exampleInputPasswordLabel = document.getElementById('exampleInputPasswordLabel');
        if(!exampleInputEmailEl )
            return;
        exampleInputEmailEl.addEventListener('input', function() {
            exampleInputEmailLabel.style.color = 'black';
        exampleInputPasswordLabel.style.color = 'black';
        exampleInputEmailEl.style.color = 'black';
        $scope.message = '';
    });
        $scope.sendForm = function(auth){
            $http({
                method: "POST",
                url: "/mylogin",
                data: $.param(auth),
                headers: { "Content-Type" : "application/x-www-form-urlencoded" }
            }).then(
                function(data) {
                resultMessageEl.style.color = 'green';
            $scope.message = "Доступ разрешен";
            exampleInputEmailEl.value = '';
            exampleInputPasswordEl.value = '';
        },
            function(error) {
                exampleInputEmailLabel.style.color = 'red';
                exampleInputPasswordLabel.style.color = 'red';
                resultMessageEl.style.color = 'red';
                exampleInputEmailEl.value = '';
                exampleInputPasswordEl.value = '';
                $scope.message = "Доступ запрещен"
            }
        );
        }
    });