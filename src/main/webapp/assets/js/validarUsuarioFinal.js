const cnombres = document.getElementById("validationServer01");
const capellidos = document.getElementById("validationServer02");
const ccedula = document.getElementById("validationServer03");
const ctelefono = document.getElementById("validationServer04");
const ccorreo = document.getElementById("validationServer05");
const cdirip = document.getElementById("validationServer06");
const cdirmac = document.getElementById("validationServer07");

const formdata = document.getElementById("formdatafinaluser");
let enviar;

const validaciones = () => {
    if (cnombres.value !== "") {
        cnombres.classList.remove("is-invalid");
        cnombres.classList.add("is-valid");
    }

    if (capellidos.value !== "") {
        capellidos.classList.remove("is-invalid");
        capellidos.classList.add("is-valid");
    }

    if (!ccedula.value.match(/^[0-9]{10}$/)) {
        ccedula.classList.remove("is-valid");
        ccedula.classList.add("is-invalid");
        enviar = false;
    } else {
        ccedula.classList.remove("is-invalid");
        ccedula.classList.add("is-valid");
    }

    if (!ctelefono.value.match(/^[0-9]{10}$/)) {
        ctelefono.classList.remove("is-valid");
        ctelefono.classList.add("is-invalid");
        enviar = false;
    } else {
        ctelefono.classList.remove("is-invalid");
        ctelefono.classList.add("is-valid");
    }

    const regexCorreo = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if (!ccorreo.value.match(regexCorreo)) {
        ccorreo.classList.remove("is-valid");
        ccorreo.classList.add("is-invalid");
        enviar = false;
    } else {
        ccorreo.classList.remove("is-invalid");
        ccorreo.classList.add("is-valid");
    }

    const regexDirIP =
        /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;

    if (!cdirip.value.match(regexDirIP)) {
        cdirip.classList.remove("is-valid");
        cdirip.classList.add("is-invalid");
        enviar = false;
    } else {
        cdirip.classList.remove("is-invalid");
        cdirip.classList.add("is-valid");
    }

    const regexDirMAC = /^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$/;

    if (!cdirmac.value.match(regexDirMAC)) {
        cdirmac.classList.remove("is-valid");
        cdirmac.classList.add("is-invalid");
        enviar = false;
    } else {
        cdirmac.classList.remove("is-invalid");
        cdirmac.classList.add("is-valid");
    }
};

formdata.addEventListener("submit", function (event) {
    event.preventDefault();
    enviar = true;

    validaciones();

    if (enviar == true) formdata.submit();
});
