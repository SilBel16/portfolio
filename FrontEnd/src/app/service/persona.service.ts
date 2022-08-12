import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { persona } from '../model/persona.model';

@Injectable({
  providedIn: 'root'
})

export class PersonaService {

    //de donde quiero que llame al backend
    URL = 'https://localhost8080/personas'

  constructor(private http:HttpClient) { }

  public getPersona(): Observable<persona>{ //observable--> hacer peticiones asincronas
    return this.http.get<persona>(this.URL+'/traer/perfil');
  } 



}