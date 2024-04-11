const nombres = document.querySelector("#inputNombres");
const apellidos = document.querySelector("#inputApellidos");
const cedula = document.querySelector("#inputCedula");
const telefono = document.querySelector("#inputTelefono");
const email = document.querySelector("#inputEmail");
const nacimiento = document.querySelector("#inputNacimiento");

const form = document.querySelector("#formDataCliente");

const EmailRegExp =
	/^[\w.%+-]+@(gmail|outlook|hotmail|live|yahoo|[\w-]+)(\.[a-zA-Z]{2,})?$/;

form.addEventListener("submit", function (event) {
	if (
		nombres.value === "" ||
		apellidos.value === "" ||
		cedula.value === "" ||
		telefono.value === "" ||
		nacimiento.value === "" ||
		email.value === "" ||
		cedula.value.length !== 10 ||
		telefono.value.length !== 10 ||
		!EmailRegExp.test(email.value)
	) {
		event.preventDefault();

		// Validar campos llenos
		if (nombres.value === "") {
			alert("Por favor, ingresa tu nombres.");
			nombres.classList.add("is-invalid");
			nombres.focus();
		} else if (apellidos.value === "") {
			alert("Por favor, ingresa tus apellidos.");
			apellidos.classList.add("is-invalid");
			apellidos.focus();
		} else if (cedula.value === "") {
			alert("Por favor, ingresa tu número de cédula.");
			cedula.classList.add("is-invalid");
			cedula.focus();
		} else if (telefono.value === "") {
			alert("Por favor, ingresa tu número de teléfono.");
			telefono.classList.add("is-invalid");
			telefono.focus();
		} else if (nacimiento.value === "") {
			alert("Por favor, ingresa tu fecha de nacimiento.");
			nacimiento.classList.add("is-invalid");
			nacimiento.focus();
		} else if (email.value === "") {
			alert("Por favor, ingresa tu correo electrónico.");
			email.classList.add("is-invalid");
			email.focus();
		} else if (cedula.value.length !== 10) {
			alert("Por favor, ingresa un número de cédula válido.");
			cedula.classList.add("is-invalid");
			cedula.focus();
		} else if (telefono.value.length !== 10) {
			alert("Por favor, ingresa tu número de teléfono.");
			telefono.classList.add("is-invalid");
			telefono.focus();
		} else if (!EmailRegExp.test(email.value)) {
			alert("Por favor, ingresa tu correo electrónico válido.");
			email.classList.add("is-invalid");
			email.focus();
		}
	} else {
		nombres.classList.add("is-valid");
		apellidos.classList.add("is-valid");
		cedula.classList.add("is-valid");
		telefono.classList.add("is-valid");
		nacimiento.classList.add("is-valid");
		email.classList.add("is-valid");
	}

	nombres.addEventListener("input", () =>
		nombres.classList.remove("is-invalid")
	);
	apellidos.addEventListener("input", () =>
		apellidos.classList.remove("is-invalid")
	);
	cedula.addEventListener("input", () => cedula.classList.remove("is-invalid"));
	telefono.addEventListener("input", () =>
		telefono.classList.remove("is-invalid")
	);
	nacimiento.addEventListener("input", () =>
		nacimiento.classList.remove("is-invalid")
	);
	email.addEventListener("input", () => email.classList.remove("is-invalid"));
});
