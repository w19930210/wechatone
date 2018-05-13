<%--
  Created by IntelliJ IDEA.
  User: wang zhe
  Date: 2018/4/23
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品信息并上传写有html的txt文件</title>
</head>
<body>
<form name="addProductForm" enctype="multipart/form-data"
      action="${pageContext.servletContext.contextPath }/product/add"
      method="post">
  <table class="ttab" height="100" width="50%" border="0" cellpadding="0" cellspacing="1" align="center">
    <tr>
      <td height="60" colspan="2">
        <div align="center">
          <font color="blue" size="6"><b>添加商品信息</b>
          </font>
        </div></td>
    </tr>

    <tr>
      <td height="30" width="40%">
        <div align="right" class="STYLE1">商品名称：</div>
      </td>
      <td>
        <div align="left" class="STYLE1" style="padding-left: 10px;">
          <input style="height: 20px; width: 70%"
                 id="name" name="name" />
        </div>
      </td>
    </tr>

    <tr>
      <td height="30" width="40%">
        <div align="right" class="STYLE1">商品价格：</div>
      </td>
      <td>
        <div align="left" class="STYLE1" style="padding-left: 10px;">
          <input style="height: 20px; width: 70%"
                 id="price" name="price" />
        </div>
      </td>
    </tr>

    <tr>
      <td height="30" width="40%">
        <div align="right" class="STYLE1">商品每件价格：</div>
      </td>
      <td>
        <div align="left" class="STYLE1" style="padding-left: 10px;">
          <input style="height: 20px; width: 70%"
                 id="onePrice" name="onePrice" />
        </div>
      </td>
    </tr>

    <tr>
      <td height="30" width="40%">
        <div align="right" class="STYLE1">商品网址：</div>
      </td>
      <td>
        <div align="left" class="STYLE1" style="padding-left: 10px;">
          <input style="height: 20px; width: 70%"
                 id="ali_html" name="ali_html" />
        </div>
      </td>
    </tr>

    <tr>
      <td height="30" width="40%">
        <div align="right" class="STYLE1">选择文件(zip格式)：</div>
      </td>
      <td>
        <div align="left" class="STYLE1" style="padding-left: 10px;">
          <input type="file" style="height: 20px; width: 70%" name="htmlFile" />
        </div>
      </td>
    </tr>

    <tr>
      <td colspan="4" style="padding: 10px">
        <div align="center">
          <input type="submit" value="　保　存　" class="input_btn_style1" /> <input
                id="backBt" type="button" value="　返　回　" class="input_btn_style1"
                onclick="javascript:window.location.href='javascript:history.go(-1)'" />
        </div></td>
    </tr>
  </table>
</form>

</body>
</html>
