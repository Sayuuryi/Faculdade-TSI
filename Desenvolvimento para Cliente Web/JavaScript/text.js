// let numero = prompt('Insira um valor');

// if ( numero > 10) {
//     alert('é maior que 10');

// } else if(numero == 10) {
//     alert('É igual a 10')

// } else {
//     alert('É menor que 10');
// }

switch (prompt("Como está o tempo?")) {
    case "chuvoso":
        alert("Lembre-se de trazer um casaco")
        break;
    case "ensolarado":
        alert("Vista roupas leves!");
    case "nublado":
        alert("Vá lá fora!");
        break;
    default:
        alert("Tempo desconhecido");
        break;
}