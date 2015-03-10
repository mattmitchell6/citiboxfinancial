<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Citibox Login</title>
  <link rel="stylesheet" href="style.css" media="screen" type="text/css" />
</head>

<body>
  <div class="banner">
    <h1>Successful Registration!</h1>
  </div>
  <div class="login-card">
    <h1>Welcome
      <br>
      <!-- script to get user's name, grabbed/modified from: 
        http://stackoverflow.com/questions/901115/how-can-i-get-query-string-values-in-javascript
      -->
      <script>
        function getParameterByName(name) {
          name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
          var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"), 
           results = regex.exec(location.search);
          return results === null ? "" : 
           decodeURIComponent(results[1].replace(/\+/g, " "));
        }
        var name = getParameterByName('name');
        if(name == "")
          name = "Ron Burgundy?";
        document.write(name);
      </script>

    </h1>
    <br>

  <form action="homepage.jsp">
    <input type="submit" name="continue" class="login login-submit" value="continue to home page">
  </form>
  </div>

</body>

</html>