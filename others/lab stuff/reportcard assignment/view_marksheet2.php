<html>
  <head>
  <title>Marksheet</title>
  <link rel="stylesheet" href="style.css" />
  </head>
  <body>
  <?php?>
  <?php
  
  
  include("include/checkLogin.php");
  
  if ($check == 0 || $check == 1): ?>
    <h3>Access denied!</h3>
    <a href="marks_auth1.html">Go back to Login page</a>
  <?php
  else: 
    include("include/generate_marksheet.php");
    _fetchMarksheet($_POST["stud_uname"]);
  endif; 
  ?>
  </body>
</html>