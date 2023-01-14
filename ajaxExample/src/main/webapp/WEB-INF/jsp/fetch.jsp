<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "employees";
String userid = "root";
String password = "Root$666";
try {
	Class.forName(driver);
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
try {
	String designation= request.getParameter("designation");
	connection = DriverManager.getConnection(connectionUrl + database, userid, password);
	statement = connection.createStatement();
	String sql = "select name from employees where designation=" + designation;
	resultSet = statement.executeQuery(sql);
	int i = 0;
	while (resultSet.next()) {
		String name = resultSet.getString("name");
		i++;
		out.println(name);
	}
	connection.close();
} catch (Exception e) {
	e.printStackTrace();
}
%>