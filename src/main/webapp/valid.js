function food() {
	let f_name = document.getElementById("f_name").value;
	let f_type = document.getElementById("f_type").value;
	let f_cate = document.getElementById("f_cate").value;
	let f_price = document.getElementById("f_price").value;

	if (f_name.trim() == "") {
		document.getElementById("n_error").innerText = "please enter Food Name";
		return false;
	}
	else {
		document.getElementById("n_error").innerText = "";
	}

	if (f_type.trim() == "") {
		document.getElementById("t_error").innerText = "please enter Food Type";
		return false;
	} else {
		document.getElementById("t_error").innerText = "";
	}
	if (f_cate.trim() == "") {
		document.getElementById("c_error").innerText = "please enter Food Category";
		return false;
	} else {
		document.getElementById("c_error").innerText = "";
	}
	if (f_price.trim() == "") {
		document.getElementById("p_error").innerText = "please enter Food Price";
		return false;
	} else {
		document.getElementById("p_error").innerText = "";
	}

	return true;
}