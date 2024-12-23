<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prime Number Check</title>

<style type="text/css">


h2{
color: brown;

}
</style>
</head>
<body>




<%  for (int i = 2; i <= 50; i++) {
    boolean isPrime = true;
    for (int j = 2; j < i; j++) {
        if (i % j == 0) {
            isPrime = false;
            break;
        }
    }
    if (isPrime) {
        out.println("<h2>Prime Number : "+ i + "</h3>");
    }
}%>

</body>
</html>