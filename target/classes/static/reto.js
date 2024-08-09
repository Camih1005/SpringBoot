document.addEventListener('DOMContentLoaded', () => {
  
    let aggE = document.getElementById("vbtn-radio1");
    let deleteE = document.getElementById("vbtn-radio2");
    let buscarE = document.getElementById("vbtn-radio3");

  
    let seccionAgregar = document.getElementById("Tadd");
    let seccionBuscar = document.getElementById("Tbuscar");
    let tablaId = document.getElementById("tablaId");

    function ocultarTodasLasSecciones() {
        seccionAgregar.style.display = 'none';
        seccionBuscar.style.display = 'none';
        tablaId.style.display = 'none'; 
    }

    aggE.addEventListener("click", () => {
        ocultarTodasLasSecciones();
        seccionAgregar.style.display = 'block';
    });

    deleteE.addEventListener("click", () => {
        ocultarTodasLasSecciones();
        seccionAgregar.style.display = 'block'; 
    });

    buscarE.addEventListener("click", () => {
        ocultarTodasLasSecciones();
        seccionBuscar.style.display = 'block';
    });


    let formBuscar = document.getElementById("fmBuscar");
    let tabla = document.getElementById("tableB");

    let formListar = document.getElementById("vbtn-radio4");

    formListar.addEventListener("click", (e) => {
        let URL = "http://localhost:9090/api/list-all";
        fetch(URL)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                let tablaId = document.getElementById("tablaId");
                let tabla = document.getElementById("tableB");

                if (data.length > 0) {
                    tablaId.style.display = 'block';
              
                    let rows = data.map((user, index) => `
                        <tr>
                            <td>${index + 1}</td>
                            <td>${user.cedula}</td>
                            <td>${user.nombre}</td>
                            <td>${user.apellido}</td>
                        </tr>
                    `).join('');

                    tabla.innerHTML = `
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Cedula</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                            </tr>
                        </thead>
                        <tbody>
                            ${rows}
                        </tbody>
                    `;
                } else {
                    tablaId.style.display = 'none';
                }
            })
            .catch(error => console.error('Problema en el fetch', error));
    });

    formBuscar.addEventListener("submit", (e) => {
        e.preventDefault();
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
                    tablaId.style.display = 'block';
                    tabla.innerHTML = `
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Cedula</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>${data[0].cedula}</td>
                                <td>${data[0].nombre}</td>
                                <td>${data[0].apellido}</td>
                            </tr>
                        </tbody>
                    `;
                } else {
                    tablaId.style.display = 'none';
                }
            })
            .catch(error => console.error('Problema en el fetch', error));
    });
});
