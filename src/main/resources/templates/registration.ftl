<#import "parts/common.ftl" as mymacro>
<#import "parts/login.ftl" as mylogin>

<@mymacro.page>
Add new user

    ${message}

<@mylogin.login "/registration" />

</@mymacro.page>