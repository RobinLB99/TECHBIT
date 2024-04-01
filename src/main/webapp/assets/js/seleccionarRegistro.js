document.addEventListener("DOMContentLoaded", function() {
	//Ingesar datos de IDs de registros a eliminar.
	const formBorrarEmpleados = document.querySelector(
		"#borrarRegistrosEmpleados"
	);
	const checkboxes = document.getElementsByName("checkbox");
	const inputIdForDelete = document.querySelector("#idForDelete");
	const arrayIdForDelete = [];

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

	//Ingesar datos de IDs de registros a eliminar.
});
