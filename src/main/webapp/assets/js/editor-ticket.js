const descripcion = document.querySelector("textarea#description");
let editor;

const verificar = setInterval(function () {
	const e = document.querySelector("iframe#description_ifr");
	console.log(editor);
	if (e !== null && e !== undefined) {
		editor = e;
		clearInterval(verificar);
	}
}, 100);

const formNewTicket = document.getElementById("NewTicket");
formNewTicket.addEventListener("submit", function (event) {
	tinyMCE.triggerSave();

	if (descripcion.value === "" || descripcion.value == null) {
		event.preventDefault();
		alert("Debe dar una descripción al problema!");
	}
});
