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
		// Prevenir el envío automático para hacer la validación manual
		event.preventDefault();

		// Validar cada campo individualmente
		const isUsernameValid = usernameRegex.test(username.value);
		const isPasswordValid = passwordRegex.test(password.value);
		const isAccessValid = access.value !== "";

		// Aplicar o remover clases de validación para feedback visual
		if (isUsernameValid) {
			username.classList.remove("is-invalid");
		} else {
			username.classList.add("is-invalid");
		}

		if (isPasswordValid) {
			password.classList.remove("is-invalid");
		} else {
			password.classList.add("is-invalid");
		}

		if (isAccessValid) {
			access.classList.remove("is-invalid");
		} else {
			access.classList.add("is-invalid");
		}

		// Si todos los campos son válidos, enviar el formulario
		if (isUsernameValid && isPasswordValid && isAccessValid) {
			// Usamos formUser.submit() para evitar la recursión del evento
			formUser.submit();
		} else {
			// Opcional: enfocar el primer campo inválido para guiar al usuario
			if (!isUsernameValid) {
				username.focus();
			} else if (!isPasswordValid) {
				password.focus();
			} else if (!isAccessValid) {
				access.focus();
			}
		}
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
