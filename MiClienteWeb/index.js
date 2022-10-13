const index = document.querySelector(".contenedor");    //. para clase / # para id

const URL_API = "http://127.0.1.1:8080/FormulaSpring";

fetch(`${URL_API}/escuderias/dametodas`)
.then((res) => res.json())
.then((escuderias) => {

    console.log(escuderias)

    const divLista = escuderias.map((escuderia) => `<li>${escuderia.id} 🏎 ${escuderia.nombre}</li>`)

    index.innerHTML = `${divLista}`

})
.catch;
