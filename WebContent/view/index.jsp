<html>
<head>
<script type="text/javascript" src="jQuery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	 $("#submit").click(function(){
		  alert("tttt");
		  });
});
</script>
 
</head>
<body>
   <form id="mainForm" action="<%=request.getContextPath() %>/house/getTcList" method="post">
      <input type="button" name="submit" id="submit" value="submit"/>
      <input type="submit" name="submit1" id="submit1" value="submit1"/>
   </form>
</body>
</html>