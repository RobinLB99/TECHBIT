const form = document.getElementById("formModUser");
const username = document.querySelector("#validationServerUsername");
const privilegiosRequest = document.querySelector("input[name='privilegios']");
const select = document.querySelector("#validationServerAccess");

// Validar el usuario
const usernameRegex = /^[a-zA-Z0-9]{8,}$/;
form.addEventListener("submit", function(event) {
	event.preventDefault();

  if (!usernameRegex.test(username.value)) {
    username.classList.remove("is-valid");
		username.classList.add("is-invalid");
  }

  if (usernameRegex.test(username.value)) {
    username.classList.remove("is-invalid");
    username.classList.add("is-valid");
    this.submit();
  }
});

// Auto-seleccionar los actuales privilegios
for (let i = 0; i <= select.length; i++) {
	if (select[i].value == privilegiosRequest.value) {
		select[i].selected = true;
	}
}
