<#import "parts/common.ftl" as mymacro>
<#include "parts/security.ftl">


<@mymacro.page>

    <#if isCurrentUser || isAdmin>
    <#include "parts/messageEdit.ftl"/>
    </#if>
    <#include "parts/messageList.ftl"/>

</@mymacro.page>