<#import "parts/common.ftl" as mymacro>
<#import "parts/login.ftl" as mylogin>
<@mymacro.page>

    <div>
        <@mylogin.logout />
    </div>

    <div>
        <form method="post" action="addUser">
            <input type="text" name="firstName" placeholder="FirstName">
            <input type="text" name="lastName" placeholder="LastName">
            <input type="email" name="email" placeholder="Email">
            <input type="password" name="password" placeholder="Password">

            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Save</button>
        </form>
    </div>

    <div>Список юзеров</div>

    <div>
        <form method="get" action="/main">
            <input type="text" name="findName" placeholder="find with user FirstName" >

            <button type="submit">Find user</button>
        </form>
    </div>
    <#list users as user>
        <div>
            <span>${user.id}</span>
            <b>${user.firstName}</b>
            <b>${user.lastName}</b>
            <i>${user.email}</i>
            <span>${user.password}</span>
            <span>${user.active?then('Active','Not active')}</span>
            <b>${user.roleType}</b>
        </div>
<#else >
        No user
    </#list>

</@mymacro.page>