<#import "parts/common.ftl" as mymacro>
<#import "parts/login.ftl" as mylogin>
<@mymacro.page>

    <div>
        <@mylogin.logout />
    </div>
    <div>Edd user</div>
    <div>
        <form method="post" action="addUser">
            <input type="text" name="firstName" placeholder="FirstName">
            <input type="text" name="lastName" placeholder="LastName">
            <input type="email" name="email" placeholder="Email">
            <input type="password" name="password" placeholder="Password">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect01">Roles</label>
                </div>
                <select class="custom-select" id="inputGroupSelect01">
                    <option selected>Choose...</option>
                    <option value="1">Admin</option>
                    <option value="2">User</option>
                </select>
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type="submit">Save</button>
        </form>
    </div>

    <div>Список юзеров</div>

    <div>
        <form method="get" action="/main">
            <input type="text" name="findName" placeholder="find with user FirstName">

            <button type="submit">Find user</button>
        </form>
    </div>
    <table>
        <thead>
        <tr>
            <th>Id</th>
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
        <#list users as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.active?then('Active','Not active')}</td>
                <td>${user.roleType}</td>
                <td><a href="/user/${user.id}">Edit</a> </td>
            </tr>
        <#else >
            No user
        </#list>
        </tbody>
    </table>

</@mymacro.page>