<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><@tiles.getAsString name="title"/></title>
  	<style>
      section {
        border:1px solid;
      }
    </style>
</head>
<body>
    <@tiles.insertAttribute name="section"/>
</body>
</html>
