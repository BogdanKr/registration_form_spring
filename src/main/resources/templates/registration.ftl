<#import "parts/common.ftl" as mymacro>
<#import "parts/login.ftl" as mylogin>

<@mymacro.page>
<div class="mb-1"> Add new user </div>

    ${message!}

<@mylogin.login "/registration" true "Registration"/>

    <a href="/login">Login</a>

</@mymacro.page>