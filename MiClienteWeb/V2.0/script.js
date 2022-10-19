
const pilotoContainer = document.getElementById('pilotoContainer')    //cojo del html el container, ahi es donde voy a ir metiendolo todo

const getPilotos = async () => {

    const url = `http://127.0.1.1:8080/FormulaSpring/pilotos/dametodos`
    const res =  await fetch(url)
    const pilotos = await res.json()

    console.log(pilotos)

}

getPilotos()

