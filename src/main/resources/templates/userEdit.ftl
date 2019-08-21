<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">

<@mymacro.page>

    <div>User editor</div>
    <form action="/user" method="post">
        <label >Firs Name
            <input type="text" name="firstName" value="${usr.firstName}">
        </label>
        <label>Last Name
            <input type="text" name="lastName" value="${usr.lastName}">
        </label>
        <label>Email
            <input type="email" name="email" value="${usr.email}">
        </label>
        <label>Password
            <input type="password" name="password" value="">
        </label>
        <#if isAdmin>
            <div class="custom-control custom-switch">
                <input type="checkbox" class="custom-control-input" id="customSwitch1"
                        ${usr.active?string("checked","")} name="active">
                <label class="custom-control-label" for="customSwitch1" >Active</label>
            </div>
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
