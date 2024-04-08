const formulario = document.querySelector("#formCreateRoot");
const password1 = document.querySelector("#passwordGroup");
const password2 = document.querySelector("#repeatePasswordGroup");

formulario.addEventListener("submit", function (event) {
	event.preventDefault();

	const regExpPassword = /^\S{5,}$/;

	if (regExpPassword.test(password1.children[1].value) == false) {
		password1.children[1].classList.remove("is-valid");
		password1.children[1].classList.add("is-invalid");
	} else {
		password1.children[1].classList.remove("is-invalid");
		password1.children[1].classList.add("is-valid");

		if (password2.children[1].value === password1.children[1].value) {
			password2.children[1].classList.remove("is-invalid");
			password2.children[1].classList.add("is-valid");
			formulario.submit();
		} else {
			password2.children[1].classList.remove("is-valid");
			password2.children[1].classList.add("is-invalid");
		}
	}

});
