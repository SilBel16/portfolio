export class persona{
    id?: number; //Dato no necesario, es automático
    nombre: string;
    apellido: string;
    img: string;

    constructor(nombre: string, apellido: string, img: string) {
        this.nombre = nombre; //inicializo los atributos
        this.apellido = apellido;
        this.img = img;
    }
}