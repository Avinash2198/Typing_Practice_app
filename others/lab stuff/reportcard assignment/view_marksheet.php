<html>
  <head>
  <title>Marksheet</title>
  <link rel="stylesheet" href="style.css" />
  </head>
  <body>
  <?php?>
  <?php
  include("include/checkLogin.php");
  
  if ($check == 0): ?>
    <h3>Incorrect login or password! Please try again!</h3>
    <a href="marks_auth1.html">Go back to Login page</a>
  <?php else:
    include("include/generate_marksheet.php");
    if ($check == 1):
      _fetchMarksheet($_POST["uname"]);?>
    <?php else:?>
      <form action="view_marksheet2.php" method="post">
        <label>Enter student username: </label> <input type="text" name="stud_uname" value="student"/>
        <input type="hidden" name="uname" value="<?php echo $_POST["uname"];?>">
        <input type="hidden" name="pwd" value="<?php echo $_POST["pwd"];?>">
        <input type="submit"/>
      </form>
    <?php endif; ?>
  <?php endif; ?>
  </body>
</html>