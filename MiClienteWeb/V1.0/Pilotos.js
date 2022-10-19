const URL_API = 'http://127.0.1.1:8080/FormulaSpring'

const aplicacion = document.querySelector('.containerPilotos')

fetch(`${URL_API}/pilotos/dametodos`)
.then(el => el.json())
.then((pilotos) => {

    pilotos.forEach(piloto => {

        const p = document.createElement('p')
        p.setAttribute('id', piloto.id)

        p.addEventListener('click', function(){

            window.location.href = `./pilotos.html?id=${piloto.id}`     //Esto hago que me lelve a piloto.html y ahi hago cada uno del piloto que sea
        })

        p.innerHTML = `<hr> <br> ID: ${piloto.id} <br>NOMBRE: ${piloto.nombre} <br>DORSAL: ${piloto.dorsal} <br>FECHA DE NACIMIENTO: ${piloto.fechaNacimiento} <br>MUNDIALES: ${piloto.mundiales} <br><img class="imagenPiloto" src="${piloto.urlImage}"> <br>`
        aplicacion.appendChild(p)
        
        
    });

} )

.catch((err) => console.log(err))