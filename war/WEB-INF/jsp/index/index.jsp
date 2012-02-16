<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VRaptor Blank Project</title>
</head>
<body>
	
	<h1>Hello there :)</h1>
	
	<ul>
		<c:forEach items="${samples}" var="sample">
			<li>${sample.name}</li>
		</c:forEach>
	</ul>
</body>
</html>