
const pilotoContainer = document.getElementById('pilotoContainer')    //cojo del html el container, ahi es donde voy a ir metiendolo todo

const getPilotos = async () => {

    const url = `http://127.0.1.1:8080/FormulaSpring/pilotos/dametodos`
    const res =  await fetch(url)
    const pilotos = await res.json()

    //console.log(pilotos)

    pilotos.forEach(piloto => {
        
        crearIDPiloto(piloto)

    });

}

const crearIDPiloto = (piloto) => {

    const pilotoID = document.createElement('div')
    pilotoID.classList.add('piloto')

    //  Puedo coger la informacion del piloto actual ya que lo obtengo de la data parseada a json de cada elemento individual que me llega aqui para crear su tarjeta
    const pilotoInnerHTML = `
    <div class="imagen">
        <img src="${piloto.urlImage}" alt="">
    </div>

    <div class="info">
        <div class="nombre"><strong>${piloto.nombre}</strong></div>

        <div class="dorsal"><h3>${piloto.dorsal}</h3></div>

        <div class="fechaNac">${piloto.fechaNacimiento}</div>
    </div>

    `
    /*
    <div class="mundiales">

        <div class="mundial">
            <div class="anio">${piloto.mundiales[1].anno}</div>
            <div class="categoria">${piloto.mundiales[1].categoria}</div>
        </div>
    </div>
    */

    pilotoID.innerHTML = pilotoInnerHTML

    pilotoContainer.appendChild(pilotoID)

}

getPilotos()

