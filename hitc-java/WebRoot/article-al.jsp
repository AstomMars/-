<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="gbk">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>HITC-����׷�</title>
    <!-- zui -->
    <link href="css/zui.min.css" rel="stylesheet">
  </head>
  <body>
  </br></br>
  
  	   <header id="header" class="bg-primary">
      <div class="navbar navbar-inverse navbar-fixed-top" id="navbar" role="banner">
        <div class="container">
          <div class="navbar-header">
            
            <a href="/" class="navbar-brand"><span class="path-zui-36"><i class="path-1"></i><i class="path-2"></i></span> <span class="brand-title">${Ccbt}</span> &nbsp;<small class="zui-version"></small> </a>
          </div>
          <nav class="collapse navbar-collapse zui-navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
              <li id="navDownloadLink"><a title="������Ϣ" href="docs/download/zui-1.5.0-dist.zip" target="_blank"><i class="icon icon-download-alt"></i><span> ������Ϣ</span></a></li>
              <li><a title="��Ӻ���" href="http://forum.zui.sexy/forum/" target="_blank"><i class="icon icon-comments-alt"></i><span> ��Ӻ���</span></a></li>
              <li><a title="��ϵ����" href="https://github.com/easysoft/zui" target="_blank"><i class="icon icon-github"></i><span> ��ϵ����</span></a></li>
            </ul>
          </nav>
        </div>
      </div>
      
        
      </div>
    </header>
  
<div class="container">  

  
    <h2>�����룬</h2>
	<h1>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp�����š�<h1>

    <article class="article article-condensed">
  <header>
    <dl class="dl-inline pull-right">
      <span class="label label-danger"><i class="icon-eye-open"></i>${hot}</span>
    </dl>
    <h1>${title}</h1>
  </header>
  <section class="content">
    <p>${content}</p>
    
  </section>
  <footer>
    
    <p class="text-important">���Ľ�ѡ�� ���չ�����</p>
    
  </footer>
</article>
</div>

    <!-- jQuery (ZUI�е�Javascript���������jQuery) -->
    <script src="jquery-3.1.1.min.js"></script>
    <!-- ZUI Javascript��� -->
    <script src="js/zui.min.js"></script>
  </body>
</html>