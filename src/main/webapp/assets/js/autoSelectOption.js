document.addEventListener("DOMContentLoaded", function() {
	const textCargo = document.getElementById("textCargo");
	const textDepart = document.getElementById("textDepart");
	const inSelCargo = document.getElementById("inputCargo");
	const inSelDepart = document.getElementById("inputDepartamento");

	// Autoseleccionar cargo
	for (let i = 0; i < inSelCargo.length; i++) {
		const element = inSelCargo[i];

		if (textCargo.value === element.value) {
            element.selected = true;
            break;
		}
	}

	//Autoseleccionar departamento
	for (let i = 0; i < inSelDepart.length; i++) {
		const element = inSelDepart[i];

		if (textDepart.value === element.value) {
			element.selected = true;
			break;
		}
	}
});
