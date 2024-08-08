document.addEventListener('DOMContentLoaded', () => {
 
    let form = document.getElementById("fmdata");
    let nombreParaMostrar = document.getElementById("nombre");

   
    form.addEventListener("submit", (event) => {
        event.preventDefault();
        let cedula = document.getElementById("cedula").value;
        let URL = `http://localhost:9090/api/list-details/${cedula}`;

        fetch(URL)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                if (data.length > 0) {
                    nombreParaMostrar.textContent = `Nombre: ${data[0].nombre}`;
                } else {
                    nombreParaMostrar.textContent = 'No se encontraron datos.';
                }
            })
            .catch(error => console.error('proglema en el fetch', error));
    });
});
