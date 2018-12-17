<html>
  <head>
  <title>Edit</title>
  <link rel="stylesheet" href="style.css" />
  </head>
  <body>
  <?php?>
  <?php
  include("include/checkLogin.php");

  if ($check == 0 || $check == 1):?>
    <h3>Access denied!</h3>
    <a href="marks_auth1.html">Go back to Login page</a>
  <?php else: 
      $personal_data["Name"] = "Ayaskant Panigrahi";
      $personal_data["Roll No."] = 2016059;
      $personal_data["Father's name"] = "Subrat Swarup Panigrahi";
      $personal_data["Mother's name"] = "Manasee Panigrahi";
      $personal_data["School name"] = "FIITJEE Kukatpally, Hyderabad - 500072";
      
      $subjects = array
      (
        array("ENG", "English", 95, 100, 0),
        array("MA1", "Math A", 74, 75, 0),
        array("MA2", "Math B", 0, 75, 0)
      );
  ?>
      
    <form action="save_marksheet.php" method="post">
    <fieldset>
    <legend>Personal details</legend>
      <table>
        <tr>
          <td><label name="Name">Name</label></td>
          <td><input name="Name" type="text" value="<?php echo $personal_data["Name"];?>"/></td>
        </tr>
        <tr>
          <td><label name="Roll No." >Roll No.</label></td>
          <td><input name="Roll No." type="text" value="<?php echo $personal_data["Roll No."];?>"/></td>
        </tr>
        <tr>
          <td><label name="Father's name" >Father's name</label></td>
          <td><input name="Father's name" type="text" value="<?php echo $personal_data["Father's name"];?>"/></td>
        </tr>
        <tr>
          <td><label name="Mother's name" >Mother's name</label></td>
          <td><input name="Mother's name" type="text" value="<?php echo $personal_data["Mother's name"];?>"/></td>
        </tr>
        <tr>
          <td><label name="School name" >School name</label></td>
          <td><input name="School name" type="text" value="<?php echo $personal_data["School name"];?>"/></td>
        </tr>
      </table>
    </fieldset>
    <fieldset>
      <legend>Marks in various subjects</legend>
      <table>
      
      <tr>
        <th>Subject code</th>
        <th>Subject name</th>
        <th>Marks obtained</th>
        <th>Max. marks</th>
      </tr>
      
      <tr>
        <td><input name="subjects[0][0]" type="text" required/></td>
        <td><input name="subjects[0][1]" type="text" required/></td>
        <td><input name="subjects[0][2]" type="text" required/></td>
        <td><input name="subjects[0][3]" type="text" value="100" required/></td>
      </tr>
      
      <tr>
        <td><input name="subjects[1][0]" type="text" required/></td>
        <td><input name="subjects[1][1]" type="text" required/></td>
        <td><input name="subjects[1][2]" type="text" required/></td>
        <td><input name="subjects[1][3]" type="text" value="100" required/></td>
      </tr>
      
      <tr>
        <td><input name="subjects[2][0]" type="text" required/></td>
        <td><input name="subjects[2][1]" type="text" required/></td>
        <td><input name="subjects[2][2]" type="text"required /></td>
        <td><input name="subjects[2][3]" type="text" value="100" required/></td>
      </tr>
    </table>
    </fieldset>
    <input type="submit"/>
    </form>
  <?php endif; ?>
  </body>
</html>