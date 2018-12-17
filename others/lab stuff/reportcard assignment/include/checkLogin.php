<?php
  function _checkLogin($uname, $pwd) {
    if ($uname == "student" && $pwd == "pwd") {
      return 1; // 1 signifies student
    }
    else if ($uname == "op" && $pwd == "pwd") {
      return 2; // 2 signifies data entry operator
    }
    else {
      return 0; // invalid login
    }
  }
  if (empty($_POST)) {
    $check = 0;
  }else 
  {
    $check = _checkLogin($_POST["uname"], $_POST["pwd"]);
  }
?>