//

const index1 = document.querySelector("#miApp");    //. para clase / # para id
const index2 = document.querySelector(".contenedor");

const URL_API = "http://127.0.1.1:8080/FormulaSpring";

fetch(`${URL_API}/escuderias/dametodas`)
.then((res) => res.json())
.then((escuderias) => {

    console.log(escuderias) //  Muestro por consola el documento json con las escuderias

    escuderias.forEach(escuderia => {
        
        const p = document.createElement('p')   //  Creo un parrafo y lo guardo en una variable, posteriormente le voy a ir añadiendo todos
        
        p.setAttribute('id', escuderia.id)  //le meto un atributo a cada parrafo que genero, y al atributo id le paso el valor del id de escuderia para que me lo coja
        
        //Lo hacemos clickable, le hago un listener y una funcion lambda para lo que quiero en el onClick
        p.addEventListener('click', function(){

            window.location.href = `./escuderia.html?id=${escuderia.id}`
        })

        p.innerHTML = toStringEscuderia(escuderia)
        index2.appendChild(p)

    });

    //mostrar lista con id y nombre
    const divLista = escuderias.map((escuderia) => `<li>${escuderia.id} 🏎 ${escuderia.nombre}</li>`)

    //  Se lo paso al index1 para que lo pinte
    index1.innerHTML = `${divLista}`

})
.catch(err => console.log(err));    //Me guardo el error que me pueda dar

function toStringEscuderia(escuderia)
{
    return `ESCUDERIA =>  id: ${escuderia.id} / nombre: ${escuderia.nombre} / categoria: ${escuderia.categoria}. `
}