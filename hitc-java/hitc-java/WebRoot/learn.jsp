<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="gbk">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>HITC-��������</title>
    <!-- zui -->
    <link href="css/zui.min.css" rel="stylesheet">
  </head>
  <body>
  </br></br>
    <!-- �ڴ˴�������Ĵ��� -->
	
	   <header id="header" class="bg-primary">
      <div class="navbar navbar-inverse navbar-fixed-top" id="navbar" role="banner">
        <div class="container">
          <div class="navbar-header">
            
            <a href="${Ccbt}_fillName.action" class="navbar-brand"><span class="path-zui-36"><i class="path-1"></i><i class="path-2"></i></span> <span class="brand-title">${Ccbt}</span> &nbsp;<small class="zui-version"></small> </a>
          </div>
          <nav class="collapse navbar-collapse zui-navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
              <li id="navDownloadLink"><a href="person_${Ccbt}.action?userName=${Ccbt}"><i class="icon icon-download-alt"></i><span> ������Ϣ</span></a></li>
              <li><a title="��Ӻ���" href="${Ccbt}_friend.action" ><i class="icon icon-comments-alt"></i><span> ��Ӻ���</span></a></li>
              <li><a title="�½�Ȧ��" href="addedition.action?userName=${Ccbt}"><i class="icon icon-github"></i><span> �½�Ȧ��</span></a></li>
            </ul>
          </nav>
        </div>
      </div>
      
        
      </div>
    </header>
<div class="container">

<div class="welcome">
    <h2>�װ���${Ccbt}</h2>
    <h1>��ӭ����HITC��</h1>
</div>


<div class="body">

<div class="left" style="width:200px;float:left">
	
	<nav class="menu" data-toggle="menu" style="width: 200px">
	<script>
	function zx()
	{
		document.getElementById("clicktozx").click();
	}
	</script>

<a href="welcome.html" id="clicktozx"></a>
	
  <button class="btn btn-primary" onclick="zx()"><i class="icon-edit"></i> ע��</button>
  <ul class="nav nav-primary">
    <li><a href="#"><i class="icon-th"></i> �ȵ�����</a>
	  <ul class="nav">
        <li><a href="news_branch_${Ccbt}.action">��ѧԺ����</a></li>
        <li><a href="news_hot_${Ccbt}.action">���ȶ�����</a></li>
      </ul>
	</li>
    <li><a href="people.action?userName=${Ccbt}"><i class="icon-user"></i> �ȵ�����</a>
	</li>
    <li>
      <a href="#"><i class="icon-time"></i> �ȵ㻰��</a>
      <ul class="nav">
        <li><a href="topic_branch_${Ccbt}.action">��ѧԺ����</a></li>
        <li><a href="topic_hot_${Ccbt}.action">���ȶ�����</a></li>
      </ul>
    </li>
    <li>
    ${edition}
    </li>
  </ul>
</nav>

</div>


<div class="right"  style="width:600px;float:left">

<div class="list list-condensed">
  <header>
    <h3><i class="icon-list-ul"></i> ${change} </h3>
  </header>
  <div class="items items-hover">
    ${result}
</div>

    <!-- jQuery (ZUI�е�Javascript���������jQuery) -->
    <script src="jquery-3.1.1.min.js"></script>
    <!-- ZUI Javascript��� -->
    <script src="js/zui.min.js"></script>
  </body>
</html>