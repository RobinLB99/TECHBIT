document.addEventListener("DOMContentLoaded", function() {
	const btnBorrar = document.querySelector("#btnBorrarRegistro");
	const btnActualizar = document.querySelector("#btnActualizarRegistro");
	const formBorrarEmpleados = document.querySelector(
		"#borrarRegistrosEmpleados"
	);
	const formModificarEmpleado = document.querySelector("#employModForm");
	const checkboxes = document.getElementsByName("checkbox");
    const inputIdForDelete = document.querySelector("#idForDelete");
    const inputIdForModify = document.querySelector("#inIdEmMod");
	const arrayIdForDelete = [];

	// Disponibilidad del boton borrar registro según los registros marcados
	for (let i = 0; i < checkboxes.length; i++) {
		checkboxes[i].addEventListener("change", function() {
			for (let i = 0; i < checkboxes.length; i++) {
				if (checkboxes[i].checked) {
					btnBorrar.disabled = false;
					btnBorrar.classList.remove("btn-secondary");
					btnBorrar.classList.add("btn-danger");

					return;
				}
			}

			btnBorrar.disabled = true;
			btnBorrar.classList.remove("btn-danger");
			btnBorrar.classList.add("btn-secondary");
		});
	}

	// Disponibilidad del boton Actualizar registro según los registros marcados
	for (let i = 0; i < checkboxes.length; i++) {
		checkboxes[i].addEventListener("change", function() {
			let checkedCount = 0;

			for (let i = 0; i < checkboxes.length; i++) {
				if (checkboxes[i].checked) {
					checkedCount++;
				}
			}

			btnActualizar.disabled = checkedCount !== 1;

			if (btnActualizar.disabled) {
				btnActualizar.classList.remove("btn-warning");
				btnActualizar.classList.add("btn-secondary");

				return;
			}

			btnActualizar.classList.remove("btn-secondary");
			btnActualizar.classList.add("btn-warning");
		});
	}

	// Ingesar datos de IDs de registros a eliminar.
	formBorrarEmpleados.addEventListener("submit", function(event) {
		event.preventDefault();

		checkboxes.forEach(elemento => {
			if (elemento.checked) {
				arrayIdForDelete.push(elemento.value);
			}
		});

		let jsonText = JSON.stringify(arrayIdForDelete);
		inputIdForDelete.value = jsonText;

		this.submit();
	});

	// Ingesar ID de registro a modificar.
	formModificarEmpleado.addEventListener("submit", function(event) {
        event.preventDefault();
        
        checkboxes.forEach(elemento => {
			if (elemento.checked) {
                inputIdForModify.value = elemento.value;
			}
        });
        
        this.submit();
	});
});
