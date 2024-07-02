// FORM TICKET ASIGN
const formAsignTech = document.getElementById("asignTicketMethod");
const idTicketSelected = document.getElementById("ticketIDSelected");
const btnAsignTech = document.getElementById("btnAsignTech");

const listTickets = document.getElementsByName("_idTicket");

formAsignTech.addEventListener("submit", (event) => {
   event.preventDefault();
})

listTickets.forEach(ticket => {
   ticket.addEventListener("change", () => {
      if (ticket.checked) {
         // TOMAR EL ID DEL TICKET
         idTicketSelected.value = ticket.value;
         // ACTIVAR EL BOTON DE ASIGNAR
         btnAsignTech.disabled = false;
      }
   })
})

document.addEventListener("DOMContentLoaded", () => {
   btnAsignTech.disabled = true;
})