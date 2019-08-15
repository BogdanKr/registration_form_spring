<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login form's Main</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
</head>
<body ng-app="login_form" ng-controller="LogCtrl">
<div class="col-md-8 col-md-offset-2">
    <h1>Login form's Main</h1>
</div>
<div class="container" style="margin-top: 60px">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h3 id="resultMessage">{{message}}</h3>
            <h1 class="page-header">Login with email and password</h1>
            <#if error>
                <div class="alert alert-danger" role="alert">
                    Invalid email or password !
                </div>
            </#if>
            <#if logout>
            <div class="alert alert-info" role="alert">
                You've been logged out successful !
            </div>
            </#if>

            <form style="margin-bottom: 30px" name="form" autocomplete="off" novalidate
                  ng-submit="form.$valid && sendForm(auth)">
                <div class="form-group">
                    <label id="exampleInputEmailLabel" for="exampleInputEmail1">Email address</label>
                    <input type="email"
                           class="form-control"
                           id="exampleInputEmail1"
                           placeholder="Email"
                           required
                           ng-model="auth.email">
                </div>
                <div class="form-group">
                    <label id="exampleInputPasswordLabel" class="control-label"
                           for="exampleInputPassword1">Password</label>
                    <input type="password"
                           class="form-control"
                           id="exampleInputPassword1"
                           placeholder="Password"
                           required
                           ng-model="auth.password">
                </div>
                <button type="submit" class="btn btn-success" style="margin-top:30px" ng-disabled="form.$invalid">
                    Log in
                </button>
            </form>
            <a class="btn btn-primary" href="/form" role="button">Registrate</a>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/main.js"></script>
</body>
</html>