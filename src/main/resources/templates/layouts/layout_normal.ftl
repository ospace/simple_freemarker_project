<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
  	<title><@tiles.getAsString name="title"/></title>
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
        border:1px solid;
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
