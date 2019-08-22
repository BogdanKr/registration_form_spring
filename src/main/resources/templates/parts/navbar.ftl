<#include "security.ftl">
<#import "login.ftl" as mylogin>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">RegForm</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home </a>
            </li>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/my-messages/${user.id}">My messages </a>
                </li>
            <li class="nav-item">
                <a class="nav-link" href="/registration/edit/${user.id}">Edit profile</a>
            </li>
            </#if>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user/main">User list </a>
                </li>
            </#if>

        </ul>

        <div class="navbar-text mr-3"> ${name}</div>
        <#if name!="guest">
            <div>
                <@mylogin.logout />
            </div>
        </#if>
    </div>
</nav>

