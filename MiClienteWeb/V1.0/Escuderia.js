
const URL_API = 'http://127.0.1.1:8080/FormulaSpring'

const aplicacion = document.querySelector('.containerEscuderia')
const getURL = new URLSearchParams(window.location.search)  // esto me saca lo que viene de la url despues de la ? (desglosa los parametros)

//recogemos el parametro que nos viene por la url, el id
const id = getURL.get('id')

//console.log(id) //  Para ver si nos lo pasa bien

fetch(`${URL_API}/escuderias/dametodas`)//pongo el ejemplo con la [0] que es ferrari pero tengo que implementarlo en la api y hacer que me saque escuderia by id
.then((res) => res.json())
.then(escuderias => {

    let e = `id: ${escuderias[0].id} / nombre: ${escuderias[0].nombre} / categoría: ${escuderias[0].categoria}`
    //let e = escuderias.map((e) => e.id == 'SF_F1')    //  Intento de hacer stream de java o filter

    aplicacion.innerHTML = e

})
.catch((err) => console.log(err))