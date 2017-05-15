$(document).ready(function() { 

	$(".extra_number_one").css("visibility","hidden");
	$(".extra_number_two").css("visibility","hidden");
	$(".custom_find").css("visibility","hidden");

	$("#Add").click(function(){
		$(".navigation").css("background-color", "#333");
		$(".nav a").css("color","white");
		$(".dobavlenie").toggle(300);
		$(".find_form").hide();
		$(".edit_form").hide();
		$(".custom_find").css("visibility","hidden");

	});

	$("#symbol_one").click(function(){
		$(".extra_number_one").css("visibility","visible");
	});

	$("#symbol_two").click(function(){
		$(".extra_number_two").css("visibility","visible");
	});



	$("#Find").click(function(){
		$(".navigation").css("background-color", "#CCECCB");
		$(".nav a").css("color","black");
		$(".find_form").toggle(300);
		$(".dobavlenie").hide();
		$(".edit_form").hide();
		$(".extra_number_one").css("visibility","hidden");
		$(".extra_number_two").css("visibility","hidden");

	});

	$("#symbol_three").click(function(){
		$(".custom_find").css("visibility","visible");
	});

	$("#table").find("td .edit_position").click(function(){
		$(".navigation").css("background-color", "#DEABD1");
		$(".nav a").css("color","black");
		$(".edit_form").toggle(300);
		$(".dobavlenie").hide();
		$(".find_form").hide();
		$(".custom_find").css("visibility","hidden");
		$(".extra_number_one").css("visibility","hidden");
		$(".extra_number_two").css("visibility","hidden");
		var i = $(this).parent("td").parent("tr").index();
        
		$('input[name="first_name_edit"]').val($("tr:eq(" + i + ")" + " td:eq(0)").html());
		$('input[name="second_name_edit"]').val($("tr:eq(" + i + ")" + " td:eq(1)").html());
		$('input[name="third_name_edit"]').val($("tr:eq(" + i + ")" + " td:eq(2)").html());
		$('input[name="city_edit"]').val($("tr:eq(" + i + ")" + " td:eq(3)").html());
		$('input[name="street_edit"]').val($("tr:eq(" + i + ")" + " td:eq(4)").html());
		$('input[name="number_of_home_edit"]').val($("tr:eq(" + i + ")" + " td:eq(5)").html());
		$('input[name="number_of_phone_one_edit"]').val($("tr:eq(" + i + ")" + " td:eq(6)").html());
		$('input[name="number_of_phone_two_edit"]').val($("tr:eq(" + i + ")" + " td:eq(7)").html());
		$('input[name="number_of_phone_three_edit"]').val($("tr:eq(" + i + ")" + " td:eq(8)").html());

        $('input[name="first_name_edit_hidden"]').val($("table tr:eq(" + i + ")" + " td:eq(0)").html());
        $('input[name="second_name_edit_hidden"]').val($("table tr:eq(" + i + ")" + " td:eq(1)").html());
        $('input[name="third_name_edit_hidden"]').val($("table tr:eq(" + i + ")" + " td:eq(2)").html());
        $('input[name="city_edit_hidden"]').val($("table tr:eq(" + i + ")" + " td:eq(3)").html());
        $('input[name="street_edit_hidden"]').val($("table tr:eq(" + i + ")" + " td:eq(4)").html());
        $('input[name="number_of_home_edit_hidden"]').val($("table tr:eq(" + i + ")" + " td:eq(5)").html());
        $('input[name="number_of_phone_one_edit_hidden"]').val($("table tr:eq(" + i + ")" + " td:eq(6)").html());
        $('input[name="number_of_phone_two_edit_hidden"]').val($("table tr:eq(" + i + ")" + " td:eq(7)").html());
        $('input[name="number_of_phone_three_edit_hidden"]').val($("table tr:eq(" + i + ")" + " td:eq(8)").html());
	});

	$("#Edit").click(function(){
		$(".edit_form").hide(300);
	});

	$('input[name="otpavit"]').click(function(){
		$(".edit_form .hidden_form").show(200);
		
	});
	$('input[name="cancel"]').click(function(){
			$(".edit_form .hidden_form").hide(200);
		});

	$("td .remove_position").click(function(){
		$(".edit_form .hidden_form").hide();
		$(".dobavlenie").hide();
		$(".edit_form").hide();
		$(".find_form").hide();
		$(".navigation").css("background-color", "#74B9A9");
		var i = $(this).parent("td").parent("tr").index();
		$('input[name="first_name_delete"]').val($("tr:eq(" + i + ")" + " td:eq(0)").html());
		$('input[name="second_name_delete"]').val($("tr:eq(" + i + ")" + " td:eq(1)").html());
		$('input[name="third_name_delete"]').val($("tr:eq(" + i + ")" + " td:eq(2)").html());
		$('input[name="city_delete"]').val($("tr:eq(" + i + ")" + " td:eq(3)").html());
		$('input[name="street_delete"]').val($("tr:eq(" + i + ")" + " td:eq(4)").html());
		$('input[name="number_of_home_delete"]').val($("tr:eq(" + i + ")" + " td:eq(5)").html());
		$('input[name="number_of_phone_one_delete"]').val($("tr:eq(" + i + ")" + " td:eq(6)").html());
		$('input[name="number_of_phone_two_delete"]').val($("tr:eq(" + i + ")" + " td:eq(7)").html());
		$('input[name="number_of_phone_three_delete"]').val($("tr:eq(" + i + ")" + " td:eq(8)").html());
		$(".delete_form .hidden_form_delete").show(200);
	});

	$('input[name="cancel_delete"]').click(function(){
			$(".delete_form .hidden_form_delete").hide(200);
		});

});