document.addEventListener("DOMContentLoaded", function() {
	const inombres = document.getElementById("inputNombres");
	const iapellidos = document.getElementById("inputApellidos");
	const iCedula = document.getElementById("inputCedula");
	const iTelefono = document.getElementById("inputTelefono");
	const inacimiento = document.getElementById("inputNacimiento");
	const iemail = document.getElementById("inputEmail");
	const icargo = document.getElementById("inputCargo");
	const idepart = document.getElementById("inputDepartamento");

	const EmailRegExp = /^[\w.%+-]+@(gmail|outlook|hotmail|live|yahoo|[\w-]+)(\.[a-zA-Z]{2,})?$/;

	document
		.getElementById("SendEmployForm")
		.addEventListener("submit", function(event) {
			if (
				inombres.value === "" ||
				iapellidos.value === "" ||
				iCedula.value === "" ||
				iTelefono.value === "" ||
				inacimiento.value === "" ||
				iemail.value === "" ||
				icargo.value === "" ||
				idepart.value === "" ||
				iCedula.value.length !== 10 ||
				iTelefono.value.length !== 10 ||
				!EmailRegExp.test(iemail.value)
			) {
				event.preventDefault();

				// Validar campos llenos
				if (inombres.value === "") {
					alert("Por favor, ingresa tu nombres.");
					inombres.focus();

				} else if (iapellidos.value === "") {
					alert("Por favor, ingresa tus apellidos.");
					iapellidos.focus();

				} else if (iCedula.value === "") {
					alert("Por favor, ingresa tu número de cedula.");
					iCedula.focus();

				} else if (iTelefono.value === "") {
					alert("Por favor, ingresa tu número de telefono.");
					iTelefono.focus();

				} else if (inacimiento.value === "") {
					alert("Por favor, ingresa tu fecha de nacimiento.");
					inacimiento.focus();

				} else if (iemail.value === "") {
					alert("Por favor, ingresa tu correo electrónico.");
					iemail.focus();

				} else if (icargo.value === "") {
					alert("Por favor, selecciona un cargo.");
					icargo.focus();

				} else if (idepart.value === "") {
					alert("Por favor, selecciona un departamento.");
					idepart.focus();

				} else if (iCedula.value.length !== 10) {
					alert("Por favor, ingresa un número de cedula válido.");
					iCedula.focus();

				} else if (iTelefono.value.length !== 10) {
					alert("Por favor, ingresa tu número de telefono.");
					iTelefono.focus();
					
				} else if (!EmailRegExp.test(iemail.value)) {
					alert("Por favor, ingresa tu correo electrónico válido.");
					iemail.focus();
				}
			}
		});
});
