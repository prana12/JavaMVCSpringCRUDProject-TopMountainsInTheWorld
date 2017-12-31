<%@ page language="java" import="java.util.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<% ResourceBundle resource = ResourceBundle.getBundle("info");
	String collector=resource.getString("info.collector");
	String year=resource.getString("info.year");
%>
  
<div id="footer">
	<h5>Copyright © <%= year %>. By <%= collector%></h5>
</div>