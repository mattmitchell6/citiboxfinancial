<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Citibox Loan Form</title>
  <link rel="stylesheet" href="style.css" media="screen" type="text/css" />
</head>

<body>
  <div class="banner">
    <h1>Loan Request</h1>
  </div>
  <div class="login-card">
    <h1>Fill In Information</h1><br>
    <label>Social Security Number
      <input type="text" name="ssn" placeholder="XXX-XX-XXXX">
    </label>

    <label>Bank Account Number
      <input type="text" name="ssn" placeholder="111222333444">
    </label>      

    <label>Loan Request Amount
      <input type="text" name="amount" placeholder="$100,000">
    </label>

    
    <br>
    <form action="/uploadloan" method="post" enctype="multipart/form-data">
      <label>Upload Financial Documents
        <input type="file" name="file">
      </label>
      <br>
      <input type="submit" name="loan" class="login login-submit" value="Request Loan">
    </form>
  </div>
</body>

</html>