<#ftl encoding='UTF-8'>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title><@tiles.getAsString name="title"/></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        
    <link type="text/css" rel="stylesheet" href="/assets/bootstrap/dist/css/bootstrap.min.css">
    
  	<style>
        nav {
            background:#333333;
            padding:10px;
            color:white;
        }
        nav a {
            text-decoration:none;
            color:lightblue;
        }
        section {
            padding-left: 8px;
            padding-right: 8px;
        }
        footer {
            background:#333333;
            padding:5px;
            color:white;
            text-align:center;
            font-size:11px;
        }
    </style>
</head>
<body>
<header>
    <@tiles.insertAttribute name="header"/>
</header>
<nav>
    <@tiles.insertAttribute name="nav"/>
</nav>
<section>
    <@tiles.insertAttribute name="section"/>
</section>
<footer>
    <@tiles.insertAttribute name="footer"/>
</footer>
</body>
</html>
