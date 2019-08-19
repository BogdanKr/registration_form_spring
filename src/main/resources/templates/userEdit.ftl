<#import "parts/common.ftl" as mymacro>

<@mymacro.page>

    <div>User editor</div>
    <form action="/user" method="post">
        <input type="text" name="firstName" value="${user.firstName}">
        <input type="text" name="lastName" value="${user.lastName}">
        <input type="email" name="email" value="${user.email}">
        <input type="password" name="password" value="${user.password}">
<#--        <input type="checkbox" name="active" value="${user.active}" >-->
        <#list roles  as role>
        <label><input type="radio" name="roleType" value="${role}"
                    ${user.roleType?contains(role)?string("checked","")}>${role}</label>
        </#list>
        <input type="hidden" name="userId" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Save</button>
    </form>


</@mymacro.page>
