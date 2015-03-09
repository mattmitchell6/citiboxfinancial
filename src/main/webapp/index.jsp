<html>

<head>
  <meta charset="UTF-8">
  <title>Citibox Login</title>
  <link rel="stylesheet" href="style.css" media="screen" type="text/css" />
</head>

<body>
  <div class="banner">
    <h1>Welcome to Citibox Financial</h1>
  </div>

  <div class="login-card">
    <h1>Log-in</h1><br>

    <form action="/login" method="post">
      <label>Email
        <input type="text" name="email" placeholder="mmitchell@box.com">
      </label>

      <label>Password
        <input type="password" name="pass" placeholder="Password">
      </label>

      <input type="submit" name="login" class="login login-submit" value="login">
    </form>

    <div class="login-help">
      Not a member yet? <a href="register.jsp">Register</a>
    </div>
  </div>

</body>

</html>