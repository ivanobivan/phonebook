<%@ page import="java.util.ArrayList" %>
<%@ page import="database.ManageSQL" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head>
	<title>phonebook</title>
	<link rel="stylesheet" type="text/css" href="style.css"/>

	<script src="js/jquery-3.2.1.min.js" type="text/javascript" ></script>
	<script src="js/script.js" type="text/javascript" ></script>
	<%--я сделал этот коммит--%>
</head>
<body>
<%database.ManageSQL manageSQL = new ManageSQL();%>
<h1>Phonebook</h1>
<div class="navigation">
	<div class="nav">
    <li><a id="Add" href="#">Add</a></li>
    <li><a id="Find" href="#">Find</a></li>
    <li><a id="Edit" href="#">Edit</a></li>
    </div>
</div>

<div id="table">
	<table>
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Patronymic</th>
			<th>City</th>
			<th>Street</th>
			<th>House number</th>
			<th>Phone number</th>
			<th>Phone number</th>
			<th>Phone number</th>
		</tr>

        <%ArrayList<String[]> arrayList;%>
        <% arrayList= (ArrayList<String[]>) request.getAttribute("data");
            String[] strings ;
            if(arrayList!=null){
                for (int i = 0; i < arrayList.size(); i++ ) {
                strings = arrayList.get(i);
                    %><tr><%
                    for(int j = 0; j < strings.length;j++){
                 %>
             <td><%=strings[j]%></td>
        <%}%>
                <td class="mini_symbol"><span class="edit_position">&#9998;</span></td>
                <td class="mini_symbol"><span class="remove_position">&#10006;</span></td>
            </tr>
            <%}}%>
		
	</table>
</div>

<div class="dobavlenie">
	<form  action="AddServlet" method="get">
		<input type="text" placeholder="Name*" name="first_name" required maxlength="12" ><br><br>
		<input type="text" placeholder="Surname" name="second_name" maxlength="12"><br><br>
		<input type="text" placeholder="Patronymic" name="third_name" maxlength="12"><br><br>
		<input type="text" placeholder="City" name="city" maxlength="12"><br><br>
		<input type="text" placeholder="Street" name="street" maxlength="12" pattern="\d+" maxlength="5"><br><br>
		<input type="text" placeholder="House number" name="number_of_home" ><br><br>
		<input type="text" placeholder="Phone number*" name="number_of_phone_one" required pattern="[0-9]{11}" ><span id="symbol_one" >&#10010;</span><br><br>
		<div class="extra_number_one">
			<input type="text" placeholder="Phone number" name="number_of_phone_two" pattern="[0-9]{11}"><span id="symbol_two">&#10010;</span><br><br>
		</div>
		<div class="extra_number_two">
			<input type="text" placeholder="Phone number" name="number_of_phone_three" pattern="[0-9]{11}">
		</div>
		<p>*Required</p>
		<input type="submit" name="otpavit" value="Send"><br>
	</form>
</div>

<div class="find_form">
	<form action="FindServlet" method="get">
		<input type="text" placeholder="Name*" name="first_name" maxlength="12"><br><br>
		<input type="text" placeholder="Phone number*" name = "number_of_phone_one" pattern="[0-9]{11}"><span id="symbol_three">&#10010;</span><br><br>
		<div class="custom_find">
			<input type="text" placeholder="Surname" name="second_name" maxlength="12"><br><br>
		</div>
		<p>*Required</p>
		<input type="submit" name="otpavit" value="Send"><br>
	</form>
</div>

<div class="edit_form">
	<form action="EditServlet" method="get">
		<div class="hidden_form_edit">
			<input type="text" name="first_name_edit_hidden">
			<input type="text" name="second_name_edit_hidden">
			<input type="text" name="third_name_edit_hidden">
			<input type="text" name="city_edit_hidden">
			<input type="text" name="street_edit_hidden">
			<input type="text" name="number_of_home_edit_hidden">
			<input type="text" name="number_of_phone_one_edit_hidden">
			<input type="text" name="number_of_phone_two_edit_hidden">
			<input type="text" name="number_of_phone_three_edit_hidden">
		</div>

		<input type="text" placeholder="Name*" name="first_name_edit" required maxlength="12"><br><br>
		<input type="text" placeholder="Surname" name="second_name_edit" maxlength="12"><br><br>
		<input type="text" placeholder="Patronymic" name="third_name_edit" maxlength="12"><br><br>
		<input type="text" placeholder="City" name="city_edit" maxlength="12"><br><br>
		<input type="text" placeholder="Street" name="street_edit" maxlength="12"><br><br>
		<input type="text" placeholder="House number" name="number_of_home_edit"><br><br>
		<input type="text" placeholder="Phone number*" name="number_of_phone_one_edit" required pattern="[0-9]{11}"><br><br>
		<input type="text" placeholder="Phone number" name="number_of_phone_two_edit" pattern="[0-9]{11}"><br><br>
		<input type="text" placeholder="Phone number" name="number_of_phone_three_edit" pattern="[0-9]{11}">
		<p>*Required</p>
		<input type="button" name="otpavit" value="Send"><br>
		<div class="hidden_form">
			<p>Are you shure?</p>
			<input type="submit" name="ok" value="OK">
			<input type="button" name="cancel" value="Cancel">
		</div>
	</form>
</div>

<div class="delete_form">
	<form action="DeleteServlet" method="get">
	<div class="forms_delete">
			<input type="text" name="first_name_delete" required>
			<input type="text" name="second_name_delete">
			<input type="text" name="third_name_delete">
			<input type="text" name="city_delete">
			<input type="text" name="street_delete">
			<input type="text" name="number_of_home_delete">
			<input type="text" name="number_of_phone_one_delete" required>
			<input type="text" name="number_of_phone_two_delete">
			<input type="text" name="number_of_phone_three_delete">
		</div>
		<div class="hidden_form_delete">
			<p>Are you shure?</p>
			<input type="submit" name="ok_delete" value="OK">
			<input type="button" name="cancel_delete" value="Cancel">
		</div>
	</form>
</div>
</body>
</html>