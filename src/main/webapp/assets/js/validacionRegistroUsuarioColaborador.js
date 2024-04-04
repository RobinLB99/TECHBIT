document.addEventListener("DOMContentLoaded", function() {
	// Inputs
	const username = document.querySelector("#validationServerUsername");
	const password = document.querySelector("#validationServerPassword");
	const access = document.querySelector("#validationServerAccess");
	const formUser = document.querySelector("#formCreateUserC");
	const viewPasswordBtn = document.querySelector("#viewPasswordBtn");
	const iconEye = document.querySelector("#iconEye");
	const btnSave = document.querySelector("#guardarUsuarioC");

	// Expresiones regulares
	const usernameRegex = /^[a-zA-Z0-9]{8,}$/;
	const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{12,}$/;

	// Valida los campos estén ingresados correctamente.
	formUser.addEventListener("submit", function(event) {
		event.preventDefault();

		let formIsValid = true;

		if (!usernameRegex.test(username.value)) {
			username.classList.add("is-invalid");
			username.focus();
			formIsValid = false;
		} else {
			username.classList.remove("is-invalid");
			formIsValid = true;
		}

		if (!passwordRegex.test(password.value)) {
			password.classList.add("is-invalid");
			formIsValid = false;
			password.focus();
		} else {
			password.classList.remove("is-invalid");
			formIsValid = true;
		}

		if (formIsValid) this.submit();
	});

  // Muestra u oculta la contraseña.
  viewPasswordBtn.addEventListener("change", function () {
		if (this.checked == true) {
			iconEye.classList.remove("fa-eye-slash");
			iconEye.classList.add("fa-eye");
			password.type = "text";
		}

		if (this.checked == false) {
			iconEye.classList.remove("fa-eye");
			iconEye.classList.add("fa-eye-slash");
			password.type = "password";
		}
	});
});
