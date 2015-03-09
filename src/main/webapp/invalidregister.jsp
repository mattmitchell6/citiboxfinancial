<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Citibox Register</title>
  <link rel="stylesheet" href="style.css" media="screen" type="text/css" />
</head>

<body>
  <div class="banner">
  <h1>
    <center>Please Enter Registration Information</center>
  </h1>
  </div>
  <div class="login-card">
    <h1>Register</h1>
    <br>
    <form action="/register">
      <label>Full Name<input type="text" name="name" placeholder="Matthew Mitchell">
      </label>
      
      <label>Email <input type="text" name="email" placeholder="mmitchell@box.com">
      </label>
      
      <label>Password <input type="password" name="pass" placeholder="Password">
      </label>

      <p style="color:red;text-align:center">Invalid registration information</p>

      <input type="submit" name="submit" class="login login-submit" value="submit">
    </form>
</body>

</html>