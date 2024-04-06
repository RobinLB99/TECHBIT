document.addEventListener("DOMContentLoaded", function() {
	const btnPasswordReset = document.querySelector("#ResetPasswordBtn");
	const btnModUser = document.querySelector("#ModifyUserBtn");
	const users = document.querySelectorAll("input[name='checkboxUser']");

	btnPasswordReset.children[1].disabled = true;
	btnModUser.children[1].disabled = true;

	users.forEach(element => {
		element.checked = false;
		element.addEventListener("change", function() {
			btnPasswordReset.children[0].value = this.value;
			btnPasswordReset.children[1].disabled = false;
			btnPasswordReset.children[1].classList.remove("btn-secondary");
			btnPasswordReset.children[1].classList.add("btn-primary");

			btnModUser.children[0].value = this.value;
			btnModUser.children[1].disabled = false;
			btnModUser.children[1].classList.remove("btn-secondary");
			btnModUser.children[1].classList.add("btn-warning");

			// console.log("ID KEY-REST: " + btnPasswordReset.children[0].value);
			// console.log("ID MOD-USER: " + btnModUser.children[0].value);
		});
	});
});
