// --- JAVASCRIPT ---

        // 1. Configura tu URL aquí
        const URL_API = "http://localhost:9090/productos/listado"; 

        function cargarDatos() {
            const contenedor = document.getElementById("contenedor-datos");
            contenedor.innerHTML = "Cargando..."; // Feedback visual

            fetch(URL_API)
                .then(response => {
                    if (!response.ok) {
                        throw new Error(`Error HTTP: ${response.status}`);
                    }
                    return response.json();
                })
                .then(data => {
                    // Limpiamos el contenedor
                    contenedor.innerHTML = "";

                    // NOTA: Si usaste @JsonProperty en Java, usa esos nombres aquí.
                    // Si NO usaste anotaciones, usa los nombres exactos de tus variables Java (ej: nombre, precio).
                    
                    // Validación por si Spring devuelve un objeto paginado
                    const lista = Array.isArray(data) ? data : data.content;

                    if(lista.length === 0) {
                        contenedor.innerHTML = "<p>Conexión exitosa, pero la lista está vacía.</p>";
                        return;
                    }

                    // Bucle para crear el HTML de cada objeto
                    lista.forEach(item => {
                        // Creamos un string con el HTML de la tarjeta
                        // Ajusta 'item.nombre', 'item.precio', etc. a tus campos reales
                        const htmlTarjeta = `
                            <div class="tarjeta">
                                <h3>ID: ${item.id}</h3>
                                <p><strong>Producto:</strong> ${item.nombre || item.title}</p>
                                <p><strong>Precio:</strong> $${item.precio || item.price}</p>
                                <p><img src="${item.imagen || item.image}" alt="Imagen del producto"></p>
                            </div>
                        `;

                        // Insertamos el HTML en el contenedor
                        contenedor.innerHTML += htmlTarjeta;
                    });
                })
                .catch(error => {
                    console.error("Error:", error);
                    contenedor.innerHTML = `<div class="error">Falló la conexión: ${error.message}</div>`;
                });

                }
                const formularioBusqueda = document.getElementById("busqueda")
                    formularioBusqueda.addEventListener('submit', function(event){
                        event.preventDefault();
                        //const valor = document.getElementById("datoProducto").value
                        
                    })
                
                function buscarProducto(v){
                    const contenedorBusqueda = document.getElementById("contenedor-busqueda")
                    const valor = document.getElementById("datoProducto").value
                    fetch(`http://localhost:9090/productos/busqueda?id=${(valor)}`,{
                        method: "GET", // 1. Cambiamos a POST (igual que en Postman)
                        headers: {
                            // 2. Le decimos al servidor que le enviamos JSON
                            "Content-Type": "application/json" 
                        },
                        // 3. Convertimos el dato a texto JSON
                        // IMPORTANTE: La clave "id" debe coincidir con lo que espera tu Java
                    })
                    
                    .then(response => {
                    if (!response.ok) {
                        throw new Error(`Error HTTP: ${response.status}`);
                    }
                    return response.json();
                    })
                    .then(producto =>{
                        const nombre = producto.nombre || producto.title;
                        const precio = producto.precio || producto.price;
                        const img = producto.imagenUrl || producto.image;
                        const descripcion = producto.descripcion || producto.description;
                        const htmlTarjeta = `
                            <div class="tarjeta">
                                <h3>ID: ${producto.id}</h3>
                                <p><strong>Producto:</strong> ${producto.nombre || producto.title}</p>
                                <p><strong>Precio:</strong> $${producto.precio || producto.price}</p>
                                <p><img src="${producto.imagen || producto.image}" alt="Imagen del producto"></p>
                            </div>
                        `;
                        contenedorBusqueda.innerHTML+= htmlTarjeta
                
                    })
                }
                    
        