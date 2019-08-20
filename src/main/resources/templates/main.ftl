<#import "parts/common.ftl" as mymacro>
<@mymacro.page>


    <div>Edd user</div>
    ${message!}
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
        <form method="get" action="main">
            <input type="text" name="findName" placeholder="find with user FirstName" value="${filter!}">

            <button type="submit">Find user</button>
        </form>
    </div>
    <table>
        <thead>
        <tr>
<#--            <th>Id</th>-->
            <th>First name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Active</th>
            <th>Role</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users! as usr>
            <tr>
<#--                <td>${usr.id}</td>-->
                <td>${usr.firstName}</td>
                <td>${usr.lastName}</td>
                <td>${usr.email}</td>
                <td>${usr.password}</td>
                <td>${usr.active?then('Active','Not active')}</td>
                <td>${usr.roleType}</td>
                <td><a href="/user/${usr.id}">Edit</a> </td>
            </tr>
        <#else >
            No user
        </#list>
        </tbody>
    </table>

</@mymacro.page>