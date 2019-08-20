<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">

<@mymacro.page>

    <div>User editor</div>
    <form action="/user" method="post">
        <input type="text" name="firstName" value="${usr.firstName}">
        <input type="text" name="lastName" value="${usr.lastName}">
        <input type="email" name="email" value="${usr.email}">
        <input type="password" name="password" value="${usr.password}">
<#--        <input type="checkbox" name="active" value="${user.active}" >-->
        <#if isAdmin>
        <#list roles  as role>
        <label><input type="radio" name="roleType" value="${role}"
                    ${usr.roleType?contains(role)?string("checked","")}>${role}</label>
        </#list>
        </#if>
        <input type="hidden" name="userId" value="${usr.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Save</button>
    </form>


</@mymacro.page>
