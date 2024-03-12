document.addEventListener("DOMContentLoaded", function () {
    const formulario = document.getElementById("form");
    const password1 = document.getElementById("yourPassword");
    const password2 = document.getElementById("yourPasswordRepeat");
    const btnEnviar = document.getElementById("Enviar");

    formulario.addEventListener("submit", function (e) {
        if (password1.value !== password2.value) {
            e.preventDefault();
            alert("Las contraseñas no coindicen. Por favor, verique los campos!");
            password1.classList.add("is-invalid");
            password2.classList.add("is-invalid");
            return false;
        }
    });

    // Limpiar clases de validación cuando se modifica el valor de los campos
    password1.addEventListener("input", function () {
        password1.classList.remove("is-invalid");
        password2.classList.remove("is-invalid");
    });

    password2.addEventListener("input", function () {
        password1.classList.remove("is-invalid");
        password2.classList.remove("is-invalid");
    });
});


