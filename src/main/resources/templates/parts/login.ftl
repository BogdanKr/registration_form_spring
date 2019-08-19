<#macro login path isRegisterForm logOrReg>

    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Email </label>
            <div class="col-sm-4">
                <input type="email" name="email" class="form-control" placeholder="Email" required/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Password: </label>
            <div class="col-sm-4 ">
                <input type="password" name="password" class="form-control" placeholder="Password" required/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">${logOrReg}</button>
    </form>
    <div class="mt-1">
        <#if !isRegisterForm><a href="/registration">Add new User</a></#if>
    </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">Loguot</button>
    </form>
</#macro>