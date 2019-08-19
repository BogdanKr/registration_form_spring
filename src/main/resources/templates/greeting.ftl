<#import "parts/common.ftl" as mymacro>
<#import "parts/login.ftl" as mylogin>

<@mylogin.logout/>

<@mymacro.page>

<div>Hello, user</div>
<div><a href="/user/main">User list</a></div>

</@mymacro.page>
