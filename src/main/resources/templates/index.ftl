<#ftl encoding='UTF-8'>
<#import "util.ftl" as util>
<#import "org/springframework/web/servlet/view/freemarker/spring.ftl" as spring/>
<#-- <#import "/tiles.ftl" as tiles/> -->

<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Welcome 환영</title>
</head>
<body>
    <a href="/normal">기본화면 이동</a>
    <#-- 직접 추가하는 경우 
    <div class="row">
        <#include  "/header.ftl" ignore_missing=true>
    </div>
    -->
    
    <#if account??>
        <p>계정: ${account}</p>
    </#if>
    
    <@util.foo/>
        
    <script>
        var data = ${(account)!"{}"};
        console.log(data);
    </script>
</body>
</html>


<#-- <#import "/org/springframework/web/servlet/view/freemarker/spring.ftl" as spring/> -->
<#-- <#import "/spring.ftl" as spring/> -->
<#-- <#import "spring.ftl" as spring/> -->
<h1><@spring.messageText "greeting", "N/A" /> ${say}</h1>
<h2>헤더: ${springMacroRequestContext.contextPath}</h2>