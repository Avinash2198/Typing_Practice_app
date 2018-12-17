README
-------
* Two accounts supported
    Username: op        Password: pwd -> the data entry operator account
    Username: student   Password: pwd -> the student account

* Start with page marks_auth1.html

* The data entry operator sees both the display and edit options after login whereas the student can only access the display option in the 2nd page.

* The php pages in between cannot be randomly accessed because the POST data is lost, this login data gets verified in each page individually.

Assignment structure:
----------------------
1. marks_auth1.html -> Login page

2. marks_auth1.php  -> Shows the display and edit option as appropriate

3. include/checkLogin.php -> Checks if right person logged in or not for each page.

4. view_marksheet.php -> Asks for student username in case of op and displays the marksheet directly in case of student.

5. view_marksheet2.php -> Shows the required marksheet based on student username given by op.

6. include/generate_marksheet.php -> Generates the marksheet

7. edit_marksheet.php -> Form based based page visible to op only, has certain default values

8. save_marksheet.php -> Displays the POST data received and generates a marksheet dynamically based on the data

9. style.css -> simple css styling for good readability
