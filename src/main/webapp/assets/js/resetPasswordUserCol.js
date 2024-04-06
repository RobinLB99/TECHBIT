document.addEventListener("DOMContentLoaded", function() {
	const formPassword = document.querySelector("#formResetPasswordUser");
	const password = document.querySelector("#validationServerPassword");
	const viewPasswordBtn = document.querySelector("#btnViewPassword");

  const passwordRegex = /^[^\s]{5,}$/;

	formPassword.addEventListener("submit", function(event) {
    event.preventDefault();
    
    if (!passwordRegex.test(password.value)) {
      password.classList.add("is-invalid");
    } else {
      password.classList.remove("is-invalid");
      password.classList.add("is-valid");

      this.submit();
    }
  });
  
  viewPasswordBtn.children[0].addEventListener("change", function () {
    if (this.checked) {
      viewPasswordBtn.children[1].classList.remove("fa-eye-slash");
      viewPasswordBtn.children[1].classList.add("fa-eye");
      password.type = "text";
    } else {
      viewPasswordBtn.children[1].classList.remove("fa-eye");
      viewPasswordBtn.children[1].classList.add("fa-eye-slash");
      password.type = "password";
    }
  })
});
