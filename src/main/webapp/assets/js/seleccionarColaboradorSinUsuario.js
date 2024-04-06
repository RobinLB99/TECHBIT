document.addEventListener("DOMContentLoaded", function() {
	const inputIDColaborador = document.querySelector(
		"input[name='idColaboradorSinUsuario']"
	);
	const addUserBtn = document.querySelector("button[name='addUser']");
	const ratios = document.querySelectorAll("input[name='ratioCheckColNotUser']");
	
	addUserBtn.disabled = true;
	inputIDColaborador.value = 0;

	// Seleccionar el ID del colaborador a asignar un usuario
	ratios.forEach(element => {
		element.checked = false;
		element.addEventListener("change", function() {
			if (element.checked) inputIDColaborador.value = element.value;
			addUserBtn.dispatchEvent(new Event("change"));
		});
	});

	// Cambiar el estado activo del botón asignar usuario
	addUserBtn.addEventListener("change", function() {
		if (addUserBtn.disabled == true) {
			addUserBtn.classList.remove("btn-secondary");
			addUserBtn.classList.add("btn-primary");
			addUserBtn.disabled = false;
		}
	});
});
