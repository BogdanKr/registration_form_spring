<#import "parts/common.ftl" as mymacro>
<#--<#import "parts/login.ftl" as mylogin>-->
<#include "parts/security.ftl">


<@mymacro.page>

    <h5>Hello ${name} <#if isAdmin>you are ADMIN !</#if></h5>

<#include "parts/messageEdit.ftl"/>
<#include "parts/messageList.ftl"/>


</@mymacro.page>
