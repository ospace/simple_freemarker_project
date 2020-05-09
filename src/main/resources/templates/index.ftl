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
    <p>
        레이아웃 선택<br/>
        <a href="/none">미적용</a> | 
        <a href="/">적용</a>
    </p>
    <p>
        Include 사용<br/> 
        <#include  "/components/foo.ftl" ignore_missing=true>
    </p>
    <p>
        매크로사용<br>
        <@util.foo/>
    </p>
    <p>
        기본 모델 객체<br>
        ${ say }
    </p>
    <p>
        데이터 모델객체<br>    
        <#if account??>
            Account: ${account}
        </#if>
        <#if pagination??>
            Pagination: ${pagination}
        </#if>
    </p>
    <p>
        i18n 샘플<br>
        <b><@spring.messageText "greeting", "N/A" /></b><br>
    </p>
    <p>
        Javascript 객체<br>
        <button onclick="showAccount()">Account보여주기</button>  
    </p>
    <script>
        function showAccount() {
            var data = ${(account)!"{}"};   
            alert('Account: '+JSON.stringify(data));
        }
    </script>
</body>
</html>
