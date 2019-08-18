<#import "parts/common.ftl" as mymacro>
<#import "parts/login.ftl" as mylogin>

<@mymacro.page>
Login page

<@mylogin.login "/login" />

<a href="/registration">Add new User</a>

</@mymacro.page>