   <?php 
    // global $personal_data;
    
    
    function _displayPersonalInfo(){
      $personal_data["Name"] = "Ayaskant Panigrahi";
      $personal_data["Roll No."] = 2016059;
      $personal_data["Father's name"] = "Subrat Swarup Panigrahi";
      $personal_data["Mother's name"] = "Manasee Panigrahi";
      $personal_data["School name"] = "FIITJEE Kukatpally, Hyderabad - 500072";
      
      echo "<table>";
      foreach ($personal_data as $key=>$value) {
        echo "<tr><td>$key</td><td>$value</td></tr>";
      }
      echo "</table>";
    }
    
    
    function _displayMarks(){
      $subjects = array
      (
        array("ENG", "English", 95, 100, 0),
        array("MA1", "Math A", 74, 75, 0),
        array("MA2", "Math B", 0, 75, 0)
      );
      
      $net_percentage = 0;
      ?>
      <table>
      <tr>
        <th>Subject code</th>
        <th>Subject name</th>
        <th>Marks obtained</th>
        <th>Max. marks</th>
        <th>Percentage</th>
      </tr>
      
      
      
      <?php
      $isFail = false;
      foreach($subjects as &$value) {
        $value[4] = ($value[2] *100) / $value[3];
        $net_percentage += $value[4] / 3; // try to bring down precision
        
        echo "<tr>";
        foreach($value as &$value2) {
          if ($value[4] < 35) {$isFail = true; echo "<td>$value2 * </td>";}
          else {echo "<td>$value2</td>";}  
        }
        echo "</tr>";
      }
      echo "</table>";
      unset($value);
      
      
      echo "Final percentage = $net_percentage";
      echo "<br/>Result:";
      
      if ($isFail == true) {
        echo "<b><h2>FAIL</h2></b><br/>";
        echo "<div id=\"fail\">";
        echo "<em>The failed subjects are: </em><br/><ul>";
        foreach($subjects as $value) {
          // echo "$value[4]";
          if ($value[4] < 35) {
            // echo "inside if";
            echo "<li>$value[0]  $value[1]</li><br/>";
          }
        }
        echo "</ul></div>";
      }
      else {
        echo "<b><h2>PASS</h2></b><br/>";
      }
    };
    // function _displayAvgMarks(){};
    // function _displayPassFail(){};
    
    function _fetchMarksheet($uname){
      _displayPersonalInfo();
      _displayMarks();// show star with fail
      // _displayAvgMarks();
      // _displayPassFail();// show list of subjects
    };
    
    
    ?>