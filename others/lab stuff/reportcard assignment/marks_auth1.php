<html>
  <head>
    <title>What do you want to do?</title><!--Try to use headers instead!-->
    <link rel="stylesheet" href="style.css" />
  </head>
  <body>
    <?php
      include("include/checkLogin.php");
      if ($check == 1 || $check == 2): ?>
      <form action="view_marksheet.php" method="post">
        <label>Display marksheet</label>
        <input type="hidden" name="uname" value="<?php echo $_POST["uname"];?>">
        <input type="hidden" name="pwd" value="<?php echo $_POST["pwd"];?>">
        <input type="submit"/>
      </form>
        <?php if ($check == 2): ?>
        <form action="edit_marksheet.php" method="post">
          <label>Edit marksheet</label>
          <input type="hidden" name="uname" value="<?php echo $_POST["uname"];?>">
          <input type="hidden" name="pwd" value="<?php echo $_POST["pwd"];?>">
          <input type="submit"/>
        </form>
      <?php endif;?>
    <?php else: ?>
      <h3>Incorrect login or password! Please try again!</h3>
      <a href="marks_auth1.html">Go back to Login page</a>
    <?php endif;?>
  </body>
</html>