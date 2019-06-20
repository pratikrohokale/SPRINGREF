<%@page isELIgnored="false" %>

 <h1 style="color:red;text-align:center">MultiActionController App </h1>
 
 <form action="perform.htm" method="POST">
    user Id :: <input type="text" name="uid"><br>
    User name ::<input type="text" name="uname"><br>
    Address  ::<input type="text" name="addrs"><br>
    Email  ::<input type="text" name="mail"><br>
     <input type="submit" name="opt"  value="insert">
     <input type="submit" name="opt"  value="update">
     <input type="submit" name="opt"  value="remove">
     <input type="submit" name="opt"  value="view">
      <input type="submit" name="opt1"  value="abc">
 </form> 
 
 ${operation}  <br>
 cmd data :: ${cmdData}